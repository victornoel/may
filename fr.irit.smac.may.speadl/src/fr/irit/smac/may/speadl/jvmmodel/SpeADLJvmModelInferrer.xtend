package fr.irit.smac.may.speadl.jvmmodel

import com.google.inject.Inject
import fr.irit.smac.may.speadl.SpeADLUtils
import fr.irit.smac.may.speadl.speadl.AbstractComponent
import fr.irit.smac.may.speadl.speadl.ComponentPart
import fr.irit.smac.may.speadl.speadl.Ecosystem
import fr.irit.smac.may.speadl.speadl.PortRef
import fr.irit.smac.may.speadl.speadl.RequiredPort
import fr.irit.smac.may.speadl.speadl.Species
import fr.irit.smac.may.speadl.speadl.SpeciesPart
import java.util.List
import org.apache.log4j.Logger
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class SpeADLJvmModelInferrer extends AbstractModelInferrer {

	static val LOG = Logger.getLogger(SpeADLJvmModelInferrer)

	public static val REQUIRES_INTERFACE = "Requires"
	public static val PROVIDES_INTERFACE = "Provides"
	public static val REQUIRES_CLASS_PREFIX = "BridgeImpl"
	public static val COMPONENT_INTERFACE = "Component"
	public static val COMPONENT_CLASS = "ComponentImpl"
	public static val PARTS_INTERFACE = "Parts"
	
	/**
     * convenience API to build and initialize JVM types and their members.
     */
	@Inject extension SpeADLJvmTypesBuilder

	@Inject extension IQualifiedNameProvider

	@Inject extension TypeReferences

	@Inject extension SpeADLUtils

	@Inject extension TypeReferenceSerializer
	
	def dispatch void infer(Ecosystem ecosystem, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		val clazz = ecosystem.toClass(ecosystem.fullyQualifiedName) [c|
			c.abstract = true
			c.typeParameters += ecosystem.typeParameters.map[cloneWithProxies]
			c.initNowAbstractComponent(ecosystem)
			
			for(species: ecosystem.species) {
				newClass(species.name) [s|
					s.abstract = true
					s.static = true
					s.typeParameters += c.typeParameters.map[cloneEObjectWithProxies]
					s.initNowAbstractComponent(species)
					c.members += s
				]
			}
		]
		
		acceptor.accept(clazz).initializeLater [ c |
			try {
				initLaterAbstractComponent(c, ecosystem)
				for(species: ecosystem.species) {
					val sc = c.getInnerType(species.name)
					if (sc != null) { // can happen if there is an error and the species does not exist
						initLaterAbstractComponent(sc, species)
					}
				}
			} catch (Exception e) {
				LOG.error("Error initializing JvmElement", e);
			}
		]
	}
	
	def void initNowAbstractComponent(JvmGenericType clazz, AbstractComponent comp) {
		
		// here we declare everything that will need to be completely declared 
		// for future cross-reference is the second pass
		
		if (comp.specializes == null) {
			val requires = newInterface(REQUIRES_INTERFACE) [
				typeParameters += clazz.typeParameters.map[cloneEObjectWithProxies]
			]
			
			clazz.members += requires
		}
		
		val componentClass = newClass(COMPONENT_CLASS) [
			typeParameters += clazz.typeParameters.map[cloneEObjectWithProxies]
		]
			
		val parts = newInterface(PARTS_INTERFACE) [
			typeParameters += clazz.typeParameters.map[cloneEObjectWithProxies]
		]

		val provides = newInterface(PROVIDES_INTERFACE) [
			typeParameters += clazz.typeParameters.map[cloneEObjectWithProxies]
		]
		
		val componentIf = newInterface(COMPONENT_INTERFACE) [
			typeParameters += clazz.typeParameters.map[cloneEObjectWithProxies]
		]
		
		clazz.members += parts
		clazz.members += componentClass
		clazz.members += provides
		clazz.members += componentIf		
		
	}
	
	def void initLaterAbstractComponent(JvmGenericType c, AbstractComponent comp) {
		
		// all the references to typeParameters in the SpeADL are
		// to those inferred for the ecosystem
		val referencedTypeParameters = switch comp {
			Ecosystem : c.typeParameters
			Species : comp.parentEcosystem.associatedJvmClass.typeParameters
		}
		
		val myTypeParameters = c.typeParameters
		val myTypeParametersRefs = myTypeParameters.map[createTypeRef]
		
		for(co: myTypeParameters.map[constraints].flatten) {
			val tr = co.typeReference.substituteTypeParameters(referencedTypeParameters, myTypeParametersRefs, comp.eResource)
			co.setTypeReference(tr)
		}
		
//		var JvmGenericType requirest
		
//		if (comp.specializes.useless) {
//			requires = c.getInnerType(REQUIRES_INTERFACE)
//			provides = c.getInnerType(PROVIDES_INTERFACE)
//			componentIf = c.getInnerType(COMPONENT_INTERFACE)
//			initRequires(comp, referencedTypeParameters, requires)
//			initProvides(comp, referencedTypeParameters, provides)
//			initComponent(comp, referencedTypeParameters, componentIf, provides)
//		} else {
//			val superType = comp.specializes.substituteTypeParameters(referencedTypeParameters, myTypeParameters, comp.eResource)
//			c.superTypes += superType
//			requires = superType.type.getInnerType(REQUIRES_INTERFACE)
//			provides = superType.type.getInnerType(PROVIDES_INTERFACE)
//			componentIf = superType.type.getInnerType(COMPONENT_INTERFACE)
//		}

		if (!comp.specializes.useless) {
			val superType = comp.specializes.substituteTypeParameters(referencedTypeParameters, myTypeParametersRefs, comp.eResource)
			c.superTypes += superType
		}

		val requiresRef = if (!comp.specializes.useless) {
			val superType = comp.specializes.substituteTypeParameters(referencedTypeParameters, myTypeParametersRefs, comp.eResource)
			superType.rootSupertype.getInnerTypeReference(REQUIRES_INTERFACE)
		} else {
			val requires = c.getInnerType(REQUIRES_INTERFACE)
			initRequires(comp, referencedTypeParameters, requires)
			requires.getParameterizedTypeRefWith(myTypeParameters)
		}

		val parts = c.getInnerType(PARTS_INTERFACE)
		val componentClass = c.getInnerType(COMPONENT_CLASS)
		val provides = c.getInnerType(PROVIDES_INTERFACE)
		val componentIf = c.getInnerType(COMPONENT_INTERFACE)
		
		initProvides(comp, referencedTypeParameters, provides)
		initComponent(comp, referencedTypeParameters, componentIf, provides)
		initParts(comp, referencedTypeParameters, parts)
		initComponentImpl(comp, referencedTypeParameters, c, componentClass)
		
		// they must be cloned before being directly assigned to an element of an EObject!
		val componentClassRef = componentClass.getParameterizedTypeRefWith(myTypeParameters)
		val componentIfRef = componentIf.getParameterizedTypeRefWith(myTypeParameters)
		val providesRef = provides.getParameterizedTypeRefWith(myTypeParameters)
		//val requiresRef = requires.getParameterizedTypeRefWith(myTypeParameters)
		val partsRef = parts.getParameterizedTypeRefWith(myTypeParameters)
		
		c.members += newField("init", Boolean.TYPE.getTypeForName(c)) [
			initializer = [append('''false;''')]
			visibility = JvmVisibility.PRIVATE
			documentation = '''
			Used to check that two components are not created from the same implementation,
			that the component has been started to call requires(), provides() and parts()
			and that the component is not started by hand.
			'''
		]
		
		c.members += newField("started", Boolean.TYPE.getTypeForName(c)) [
			initializer = [append('''false;''')]
			visibility = JvmVisibility.PRIVATE
			documentation = "Used to check that the component is not started by hand."
		]
		
		c.members += newField("selfComponent", componentClassRef)[]
		
		c.members += newMethod("start", Void.TYPE.getTypeForName(c)) [
			if (!comp.specializes.useless) {
				annotations += c.toAnnotation(Override)
			}
			visibility = JvmVisibility.PROTECTED
			documentation = '''
			Can be overridden by the implementation.
			It will be called automatically after the component has been instantiated.
			'''
			body = [
				append('''
					if (!this.init || this.started) {
						throw new RuntimeException("start() should not be called by hand: to create a new component, use newComponent().");
					}
				''')
			]
		]
		
		c.members += newMethod("provides", providesRef) [
			if (!comp.specializes.useless) {
				annotations += c.toAnnotation(Override)
			}
			visibility = JvmVisibility.PROTECTED
			documentation = '''
			This can be called by the implementation to access the provided ports.
			'''
			body = [
				append('''
				assert this.selfComponent != null: "This is a bug.";
				if (!this.init) {
					throw new RuntimeException("provides() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if provides() is needed to initialise the component.");
				}
				return this.selfComponent;
				''')
			]
		]
		
		for (port : comp.provides) {
			if (port.bound == null) {
				c.members += newMethod("make_" + port.name, port.typeReference.substituteTypeParameters(referencedTypeParameters, myTypeParametersRefs, comp.eResource)) [
					abstract = true
					visibility = JvmVisibility.PROTECTED
					documentation = '''
					This should be overridden by the implementation to define the provided port.
					This will be called once during the construction of the component to initialize the port.
					'''
				]
			}
		}
		
		c.members += newMethod("requires", requiresRef) [
			if (!comp.specializes.useless) {
				annotations += c.toAnnotation(Override)
			}
			visibility = JvmVisibility.PROTECTED
			documentation = '''
			This can be called by the implementation to access the required ports.
			'''
			body = [
				append('''
				assert this.selfComponent != null: "This is a bug.";
				if (!this.init) {
					throw new RuntimeException("requires() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if requires() is needed to initialise the component.");
				}
				return this.selfComponent.bridge;
				''')
			]
		]
		
		c.members += newMethod("parts", partsRef) [
			if (!comp.specializes.useless) {
				annotations += c.toAnnotation(Override)
			}
			visibility = JvmVisibility.PROTECTED
			documentation = '''
			This can be called by the implementation to access the parts and their provided ports.
			'''
			body = [
				append('''
				assert this.selfComponent != null: "This is a bug.";
				if (!this.init) {
					throw new RuntimeException("parts() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if parts() is needed to initialise the component.");
				}
				return this.selfComponent;
				''')]
		]
		
		for (part : comp.parts) {
			val ptr = part.typeReference.substituteTypeParameters(referencedTypeParameters, myTypeParametersRefs, comp.eResource)
			switch part {
				ComponentPart: {
					c.members += newMethod("make_"+part.name, ptr) [
						visibility = JvmVisibility.PROTECTED
						abstract = true
						documentation = '''
						This should be overridden by the implementation to define how to create this sub-component.
						This will be called once during the construction of the component to initialize this sub-component.
						'''
					]
				}
				SpeciesPart: {
					c.members += newField("use_"+part.name, ptr) []
				}
			}
		}
		
		c.members += newMethod("_newComponent", componentIfRef) [
			if (!comp.specializes.useless) {
				annotations += c.toAnnotation(Override)
			}
			parameters += newParameter("b", requiresRef)
			parameters += newParameter("start", Boolean.TYPE.getTypeForName(componentClass))
			
			synchronized = true
			documentation = '''
			Not meant to be used to manually instantiate components (except for testing).
			'''
			val m = it
			body = [
				append('''
				if (this.init) {
					throw new RuntimeException("This instance of «c.simpleName» has already been used to create a component, use another one.");
				}
				this.init = true;
				''')
				componentClassRef.serialize(c, it)
				append(''' «declareSyntheticVariable(m, "comp")» = new ''')
				componentClassRef.serialize(c, it)
				append('''(this, b, true);
				''')
				append('''
				if (start) {
					«getName(m)».start();
				}
				return comp;
				''')
			]
		]
		
		switch comp {
			Ecosystem: {
				for(species: comp.species) {
					val str = c.getInnerType(species.name).getParameterizedTypeRefWith(myTypeParameters)
					
					// careful about the type parameters (substitution)
					// here it is ok, because we are in c and the reference to type params
					// are to those of the inferred class which is c
					c.members += newMethod("make_"+species.name, str) [
						parameters += species.parameters.map[p|newParameter(p.name, p.parameterType)]
						visibility = JvmVisibility.PROTECTED
						abstract = true
						documentation = '''
						This should be overridden by the implementation to instantiate the implementation of the species.
						'''
					]
					
					c.members += newMethod("_createImplementationOf"+species.name, str) [
						parameters += species.parameters.map[p|newParameter(p.name, p.parameterType)]
						documentation = '''
						Do not call, used by generated code.
						'''
						val m = it
						body = [
							str.serialize(c, it)
							append(''' «declareSyntheticVariable(m,"implem")» = make_«species.name»(«species.parameters.map[name].join(",")»);
							''')
							append('''
							if («getName(m)» == null) {
								throw new RuntimeException("make_«species.name»() in «c.qualifiedName» should not return null.");
							}
							assert «getName(m)».ecosystemComponent == null: "This is a bug.";
							assert this.selfComponent != null: "This is a bug.";
							«getName(m)».ecosystemComponent = this.selfComponent;
							''')
							for(use: species.parts.filter(SpeciesPart)) {
								append('''
								assert this.selfComponent.implem_«use.speciesReference.part.name» != null: "This is a bug.";
								assert «getName(m)».use_«use.name» == null: "This is a bug.";
								«getName(m)».use_«use.name» = this.selfComponent.implem_«use.speciesReference.part.name»._createImplementationOf«use.speciesReference.species.name»(«use.speciesReference.arguments.map[name].join(",")»);
								''')
							}
							append('''return «getName(m)»;''')
						]
					]
					
					if (species.allRequires.empty) {
						c.members += newMethod("new"+species.name, str.getInnerTypeReference(COMPONENT_INTERFACE)) [
							parameters += species.parameters.map[p|newParameter(p.name, p.parameterType)]
							visibility = JvmVisibility.PROTECTED
							documentation = '''
							This can be called to create an instance of the species from inside the implementation of the ecosystem.
							'''
							val m = it
							body = [
								str.serialize(c, it)
								append(''' «declareSyntheticVariable(m, "implem")» = _createImplementationOf«species.name»(«species.parameters.map[name].join(",")»);
								''')
								append('''
								return «getName(m)»._newComponent(new ''')
								val i = str.getInnerTypeReference(REQUIRES_INTERFACE)
								i.serialize(c, it)
								append('''() {},true);''')
							]
						]
					}
				}
				
				if (comp.allRequires.empty) {
					c.members += newMethod("newComponent", componentIfRef) [
						if (!comp.specializes.useless) {
							annotations += c.toAnnotation(Override)
						}
						documentation = '''
						Use to instantiate a component from this implementation.
						'''
						body = [
							append('''
							return this._newComponent(new ''')
							requiresRef.serialize(c, it)
							append('''() {}, true);''')
						]
					]
				}
			}
			
			Species: {
				val parentRef = comp.parentEcosystem.associatedJvmClass.getParameterizedTypeRefWith(myTypeParameters)
				
				c.members += newField("ecosystemComponent", parentRef.getInnerTypeReference(COMPONENT_CLASS)) []
				c.members += newMethod("eco_provides", parentRef.getInnerTypeReference(PROVIDES_INTERFACE)) [
					visibility = JvmVisibility.PROTECTED
					documentation = '''
					This can be called by the species implementation to access the provided ports of its ecosystem.
					'''
					body = [
						append('''
						assert this.ecosystemComponent != null: "This is a bug.";
						return this.ecosystemComponent;
						''')
					]
				]
				
				// TODO get the super super super
				c.members += newMethod("eco_requires", parentRef.rootSupertype.getInnerTypeReference(REQUIRES_INTERFACE)) [
					visibility = JvmVisibility.PROTECTED
					documentation = '''
					This can be called by the species implementation to access the required ports of its ecosystem.
					'''
					body = [
						append('''
						assert this.ecosystemComponent != null: "This is a bug.";
						return this.ecosystemComponent.bridge;
						''')
					]
				]
				c.members += newMethod("eco_parts", parentRef.getInnerTypeReference(PARTS_INTERFACE)) [
					visibility = JvmVisibility.PROTECTED
					documentation = '''
					This can be called by the species implementation to access the parts of its ecosystem and their provided ports.
					'''
					body = [
						append('''
						assert this.ecosystemComponent != null: "This is a bug.";
						return this.ecosystemComponent;
						''')
					]
				]
			}
		}
	}
	
	def initRequires(AbstractComponent comp, List<JvmTypeParameter> originalTypeParameters, JvmGenericType requires) {
		
		val myTypeParametersRefs = requires.typeParameters.map[createTypeRef]
		
		for(c: requires.typeParameters.map[constraints].flatten) {
			val tr = c.typeReference.substituteTypeParameters(originalTypeParameters, myTypeParametersRefs, comp.eResource)
			c.setTypeReference(tr)
		}
		
		for (port : comp.requires) {
			requires.members += newMethod(port.name, port.typeReference.substituteTypeParameters(originalTypeParameters, requires.typeParameters.map[createTypeRef], comp.eResource))[
				documentation = '''
				This can be called by the implementation to access this required port.
				'''
			]
		}
	}
	
	def initProvides(AbstractComponent comp, List<JvmTypeParameter> originalTypeParameters, JvmGenericType provides) {
		
		val myTypeParametersRefs = provides.typeParameters.map[createTypeRef]
		
		for(c: provides.typeParameters.map[constraints].flatten) {
			val tr = c.typeReference.substituteTypeParameters(originalTypeParameters, myTypeParametersRefs, comp.eResource)
			c.setTypeReference(tr)
		}
		
		if (!comp.specializes.useless) {
			val nstr = comp.specializes.substituteTypeParameters(originalTypeParameters, myTypeParametersRefs, comp.eResource)
			provides.superTypes += nstr.getInnerTypeReference(PROVIDES_INTERFACE)
		}
		
		for (port : comp.provides) {
			provides.members += newMethod(port.name, port.typeReference.substituteTypeParameters(originalTypeParameters, myTypeParametersRefs, comp.eResource)) [
				documentation = '''
				This can be called to access the provided port.
				'''
			]
		}
	}
	
	def initParts(AbstractComponent comp, List<JvmTypeParameter> originalTypeParameters, JvmGenericType parts) {
		
		val myTypeParametersRefs = parts.typeParameters.map[createTypeRef]
		
		for(c: parts.typeParameters.map[constraints].flatten) {
			val tr = c.typeReference.substituteTypeParameters(originalTypeParameters, myTypeParametersRefs, comp.eResource)
			c.setTypeReference(tr)
		}
		
		if (!comp.specializes.useless) {
			val nstr = comp.specializes.substituteTypeParameters(originalTypeParameters, myTypeParametersRefs, comp.eResource)
			parts.superTypes += nstr.getInnerTypeReference(PARTS_INTERFACE)
		}
		
		for(part: comp.parts) {
			val nptr = part.typeReference.substituteTypeParameters(originalTypeParameters, myTypeParametersRefs, comp.eResource)
			parts.members += newMethod(part.name, nptr.getInnerTypeReference(COMPONENT_INTERFACE)) [
				documentation = '''
				This can be called by the implementation to access the part and its provided ports.
				It will be initialized after the required ports are initialized and before the provided ports are initialized.
				'''
			]
		}
	}
	
	def initComponent(AbstractComponent comp, List<JvmTypeParameter> originalTypeParameters, JvmGenericType componentIf, JvmGenericType provides) {
		
		val myTypeParametersRef = componentIf.typeParameters.map[createTypeRef]
		
		for(c: componentIf.typeParameters.map[constraints].flatten) {
			val tr = c.typeReference.substituteTypeParameters(originalTypeParameters, myTypeParametersRef, comp.eResource)
			c.setTypeReference(tr)
		}
		
		if (!comp.specializes.useless) {
			val nstr = comp.specializes.substituteTypeParameters(originalTypeParameters, myTypeParametersRef, comp.eResource)
			componentIf.superTypes += nstr.getInnerTypeReference(COMPONENT_INTERFACE)
		}
		
		componentIf.superTypes += provides.getParameterizedTypeRefWith(componentIf.typeParameters)
	}
	
	def initComponentImpl(AbstractComponent comp, List<JvmTypeParameter> originalTypeParameters, JvmGenericType implem, JvmGenericType componentClass) {
		
		val myTypeParameters = componentClass.typeParameters
		val myTypeParametersRefs = myTypeParameters.map[createTypeRef]
		
		for(c: componentClass.typeParameters.map[constraints].flatten) {
			val tr = c.typeReference.substituteTypeParameters(originalTypeParameters, myTypeParametersRefs, comp.eResource)
			c.setTypeReference(tr)
		}
		
		componentClass.static = true
		
		val implemRef = implem.getParameterizedTypeRefWith(myTypeParameters)
		
		if (!comp.specializes.useless) {
			val nstr = comp.specializes.substituteTypeParameters(originalTypeParameters, myTypeParametersRefs, comp.eResource)
			componentClass.superTypes += nstr.getInnerTypeReference(COMPONENT_CLASS)
		}
		
		componentClass.superTypes += implemRef.getInnerTypeReference(COMPONENT_INTERFACE)
		componentClass.superTypes += implemRef.getInnerTypeReference(PARTS_INTERFACE)
		
		val requiresRef = if (!comp.specializes.useless) {
			val nstr = comp.specializes.substituteTypeParameters(originalTypeParameters, myTypeParametersRefs, comp.eResource)
			nstr.rootSupertype.getInnerTypeReference(REQUIRES_INTERFACE)
		} else {
			implemRef.getInnerTypeReference(REQUIRES_INTERFACE)
		}
		
		componentClass.members += newField("bridge", requiresRef) [
			final = true
		]
		
		componentClass.members += newField("implementation", implemRef) [
			final = true
		]
		
		componentClass.members += newMethod("start", Void.TYPE.getTypeForName(componentClass)) [
			if (!comp.specializes.useless) {
				annotations += componentClass.toAnnotation(Override)
			}
			visibility = JvmVisibility.PUBLIC
			body = [
				append('''
				«IF !comp.specializes.useless»
				super.start();
				«ENDIF»
				''')
				for (part : comp.parts) {
					val tr = part.typeReference
					val nptr = tr.substituteTypeParameters(originalTypeParameters, myTypeParametersRefs, comp.eResource)
					val ctr = nptr.getInnerTypeReference(COMPONENT_CLASS)
					append('''
					assert this.«part.name» != null: "This is a bug.";
					((''');
					ctr.serialize(componentClass, it)
					append(''') this.«part.name»).start();
					''')
				}
				append('''
				this.implementation.start();
				this.implementation.started = true;
				''')
			]
		]
		
		componentClass.members += newMethod("initParts", Void.TYPE.getTypeForName(componentClass)) [
			if (!comp.specializes.useless) {
				annotations += componentClass.toAnnotation(Override)
			}
			visibility = JvmVisibility.PROTECTED
			body = [
				append('''
				«IF !comp.specializes.useless»
				super.initParts();
				«ENDIF»
				''')
				for (part : comp.parts) {
					append('''
					assert this.«part.name» == null: "This is a bug.";
					''')
					switch part {
						ComponentPart: {
							// TODO maybe use serialize instead of writing the class name directly
							append('''
								assert this.implem_«part.name» == null: "This is a bug.";
								this.implem_«part.name» = this.implementation.make_«part.name»();
								if (this.implem_«part.name» == null) {
									throw new RuntimeException("make_«part.name»() in «implem.qualifiedName» should not return null.");
								}
								this.«part.name» = this.implem_«part.name»._newComponent(new «REQUIRES_CLASS_PREFIX»_«part.name»(), false);
							''')
						}
						SpeciesPart: {
							// TODO maybe use serialize instead of writing the class name directly
							append('''
								assert this.implementation.use_«part.name» != null: "This is a bug.";
								this.«part.name» = this.implementation.use_«part.name»._newComponent(new «REQUIRES_CLASS_PREFIX»_«part.speciesReference.part.name»_«part.name»(), false);
							''')
						}
					}
				}
			]
		]
		
		componentClass.members += newMethod("initProvidedPorts", Void.TYPE.getTypeForName(componentClass)) [
			if (comp.specializes != null) {
				annotations += componentClass.toAnnotation(Override)
			}
			visibility = JvmVisibility.PROTECTED
			body = [
				append('''
				«IF !comp.specializes.useless»
				super.initProvidedPorts();
				«ENDIF»
				«FOR port : comp.provides.filter[bound == null]»
				assert this.«port.name» == null: "This is a bug.";
				this.«port.name» = this.implementation.make_«port.name»();
				if (this.«port.name» == null) {
					throw new RuntimeException("make_«port.name»() in «implem.qualifiedName» should not return null.");
				}
				«ENDFOR»
				''')
			]
		]
		
		componentClass.members += newConstructor() [
			parameters += newParameter("implem", implemRef)
			parameters += newParameter("b", requiresRef)
			parameters += newParameter("doInits", Boolean.TYPE.getTypeForName(componentClass))
			body = [
				append('''
				«IF !comp.specializes.useless»
				super(implem, b, false);
				«ENDIF»
				this.bridge = b;
				this.implementation = implem;
				
				assert implem.selfComponent == null: "This is a bug.";
				implem.selfComponent = this;
				
				// prevent them to be called twice if we are in
				// a specialized component: only the last of the
				// hierarchy will call them after everything is initialised
				if (doInits) {
					initParts();
					initProvidedPorts();
				}
				''')
			]
		]
		
		for (port : comp.provides) {
			val bound = port.bound
			
			val ptr = port.typeReference.substituteTypeParameters(originalTypeParameters, myTypeParametersRefs, comp.eResource)
			
			if (bound == null) {
				componentClass.members += newField(port.name, ptr) []
			}
			
			componentClass.members += newMethod(port.name, ptr) [
				final = true
				body = [
					append('''return this.''')
					if (bound == null) {
						append(port.name)
					} else {
						appendPortRefCall(bound, comp instanceof Species)
					}
					append(";")
				]
			]
		}
		
		for (part : comp.parts) {
			val tr = part.typeReference
			val nptr = tr.substituteTypeParameters(originalTypeParameters, myTypeParametersRefs, comp.eResource)
			val ctr = nptr.getInnerTypeReference(COMPONENT_INTERFACE)
			
			componentClass.members += newField(part.name, ctr) []
			
			// used to initialize species from other species
			switch part {
				ComponentPart : {
					componentClass.members += newField("implem_" + part.name, nptr) []
				}
			}
			
			val bridgePartName = switch part {
				ComponentPart: part.name
				SpeciesPart: part.speciesReference.part.name+"_"+part.name
			}
			
			componentClass.members += newClass(REQUIRES_CLASS_PREFIX+"_"+bridgePartName) [
				visibility = JvmVisibility.PRIVATE
				final = true
				superTypes += nptr.rootSupertype.getInnerTypeReference(REQUIRES_INTERFACE)
				for(binding: part.bindings) {
					val bound = binding.to
					val rt = binding.resolveTypeFrom.toJavaCompliantTypeReference.substituteTypeParameters(originalTypeParameters, myTypeParametersRefs, part.eResource)
					members += newMethod(binding.from.name, rt) [
						final = true
						body = [
							append("return ")
							append(componentClass)
							append(".this.")
							appendPortRefCall(bound, comp instanceof Species)
							append(";")
						]
					]
				}
			]
			
			componentClass.members += newMethod(part.name, ctr) [
				final = true
				body = [append('''return this.«part.name»;''')]
			]
		}
	}
	
	private def appendPortRefCall(ITreeAppendable it, PortRef bound, boolean inSpecies) {
		if (bound.part != null) {
			if (inSpecies && bound.part.eContainer instanceof Ecosystem) {
				append('''implementation.ecosystemComponent.''')
			}
			append('''«bound.part.name».''')
		} else {
			if (inSpecies && bound.port.eContainer instanceof Ecosystem) {
				append('''implementation.ecosystemComponent.''')
			}
			switch bound.port {
				RequiredPort: append('''bridge.''')
			}
		}
		append('''«bound.port.name»()''')
	}
}
