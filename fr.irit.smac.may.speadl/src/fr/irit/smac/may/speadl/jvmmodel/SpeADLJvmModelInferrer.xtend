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
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class SpeADLJvmModelInferrer extends AbstractModelInferrer {

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

	@Inject extension SpeADLUtils
	
	def dispatch void infer(Ecosystem ecosystem, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		// - toClass makes that the type parameters are those seen
		// and referred to in the speadl file inside the ecosystem
		// because SpeADLImportSectionNamespaceScopeProvider exploits the JvmType
		// TODO it would be better to only rely on those of the ecosystem itself
		// (in SpeADLImportSectionNamespaceScopeProvider)
		// but it create strange loops that prevent things to work… to investigate!
		if (ecosystem.name !== null) {
			val clazz =	ecosystem.toClass(ecosystem.fullyQualifiedName)
			ecosystem.initNowAbstractComponent(clazz, acceptor)
		}
	}
	
	def void initNowAbstractComponent(AbstractComponent comp, JvmGenericType clazz, IJvmDeclaredTypeAcceptor acceptor) {
		// the acceptor makes the class part of the resource
		// and provides the initializeLater whose content is called after all of the elements
		// have passed the preIndexingPhase (important for specialises that relies on element declared after)
		
		// here we declare everything that will need to be completely declared 
		// for future cross-reference is the second pass
		
		// class is not abstract if there is nothing to initialize
		// in the implem
		clazz.abstract = !comp.notAbstract
		
		val sourceParametersHolder = switch comp {
			Ecosystem: comp
			Species: comp.parentEcosystem
		}
		
		// - cloneWithProxies associate them to the ecosystem.typeParameters
		// which are the one of the speadl file
		// -> note that any constraints on the type parameters are still
		// pointing to ecosystem clazz types (not problematic for an ecosystem, but it is for
		// species, the other interface and classes below
		// this will be fixed in the second pass in laterXX
		
		clazz.typeParameters += sourceParametersHolder.typeParameters.map[cloneWithProxies]
		
		if (comp.specializes === null) {
			val requires = comp.toInterface(REQUIRES_INTERFACE) [
				static = true
				typeParameters += sourceParametersHolder.typeParameters.map[cloneWithProxies]
			]
			clazz.members += requires
			acceptor.accept(requires) [
				comp.initLaterRequires(clazz, requires)
			]
		}
		
		val componentClass = comp.toClass(COMPONENT_CLASS) [
			static = true
			typeParameters += sourceParametersHolder.typeParameters.map[cloneWithProxies]
		]
		val parts = comp.toInterface(PARTS_INTERFACE) [
			static = true
			typeParameters += sourceParametersHolder.typeParameters.map[cloneWithProxies]
		]
		val provides = comp.toInterface(PROVIDES_INTERFACE) [
			static = true
			typeParameters += sourceParametersHolder.typeParameters.map[cloneWithProxies]
		]
		val componentIf = comp.toInterface(COMPONENT_INTERFACE) [
			static = true
			typeParameters += sourceParametersHolder.typeParameters.map[cloneWithProxies]
		]
		
		clazz.members += componentIf
		clazz.members += provides
		clazz.members += parts
		clazz.members += componentClass
		
		acceptor.accept(provides) [
			comp.initLaterProvides(clazz, provides)
		]
		acceptor.accept(componentIf) [
			comp.initLaterComponent(clazz, componentIf, provides)
		]
		acceptor.accept(parts) [
			comp.initLaterParts(clazz, parts)
		]
		acceptor.accept(componentClass) [
			comp.initLaterComponentImpl(clazz, componentClass)
		]
		
		acceptor.accept(clazz) [
			comp.initLaterAbstractComponent(clazz)
		]
		
		if (comp instanceof Ecosystem) {
			for(species: comp.species) {
				if (species.name !== null) {
					val sClazz = species.toClass(species.name) [
						static = true
					]
					clazz.members += sClazz
					species.initNowAbstractComponent(sClazz, acceptor)
				}
			}
		}
	}
	
	def void initLaterAbstractComponent(AbstractComponent comp, JvmGenericType clazz) {
		
		val myTypeParameters = clazz.typeParameters
		
		// this will be used in two cases:
		// replace parameters for the inferred class of the species
		// replace parameters for the inferred subclasses
		// -> there is a useless replacement in the present method
		// for ecosystems (since in that case referencedTypeParameters == myTypeParameters)
		// TODO use a lambda for substituting and avoid useless substitution => does not work well…
		// TODO see if there is something that can take care of the constraints…
		val substitutor = comp.getSubstitutor(clazz, comp.eResource)
		
		for(co: myTypeParameters.map[constraints].flatten) {
			val tr = co.typeReference.substituteWith(substitutor)
			co.setTypeReference(tr)
		}

		if (comp.specializes !== null) {
			val superType = comp.specializes.substituteWith(substitutor)
			clazz.superTypes += superType
		}
		
		// they must be cloned before being directly assigned to an element of an EObject!
		// do they??
		val clazzRef = clazz.getParameterizedTypeRefWith(myTypeParameters)
		val componentClassRef = clazzRef.getInnerTypeReference(COMPONENT_CLASS)
		val componentIfRef = clazzRef.getInnerTypeReference(COMPONENT_INTERFACE)
		val providesRef = clazzRef.getInnerTypeReference(PROVIDES_INTERFACE)
		val partsRef = clazzRef.getInnerTypeReference(PARTS_INTERFACE)
		// parenthesis are needed because of
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=436279
		val requiresRef = (if (comp.specializes !== null) {
			comp.specializes.substituteWith(substitutor).rootSupertype
		} else {
			clazzRef
		}).getInnerTypeReference(REQUIRES_INTERFACE)
		
		clazz.members += newField("init", typeRef(boolean)) [
			initializer = '''false;'''
			visibility = JvmVisibility.PRIVATE
			documentation = '''
				Used to check that two components are not created from the same implementation,
				that the component has been started to call requires(), provides() and parts()
				and that the component is not started by hand.
			'''
		]
		
		clazz.members += newField("started", typeRef(boolean)) [
			initializer = '''false;'''
			visibility = JvmVisibility.PRIVATE
			documentation = '''
				Used to check that the component is not started by hand.
			'''
		]
		
		clazz.members += newField("selfComponent", componentClassRef)[]
		
		clazz.members += comp.toMethod("start", typeRef(void)) [
			if (comp.specializes !== null) {
				annotations += annotationRef(Override)
			}
			visibility = JvmVisibility.PROTECTED
			documentation = '''
				Can be overridden by the implementation.
				It will be called automatically after the component has been instantiated.
			'''
			body = '''
				if (!this.init || this.started) {
					throw new RuntimeException("start() should not be called by hand: to create a new component, use newComponent().");
				}
			'''
		]
		
		clazz.members += comp.toMethod("provides", providesRef) [
			if (comp.specializes !== null) {
				annotations += annotationRef(Override)
			}
			visibility = JvmVisibility.PROTECTED
			documentation = '''
				This can be called by the implementation to access the provided ports.
			'''
			body = '''
				assert this.selfComponent != null: "This is a bug.";
				if (!this.init) {
					throw new RuntimeException("provides() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if provides() is needed to initialise the component.");
				}
				return this.selfComponent;
			'''
		]
		
		for (port : comp.provides) {
			val isOverride = port.overridenPortTypeRef !== null
			if (port.bound === null || isOverride) {
				clazz.members += port.toMethod("make_" + port.name, port.typeReference.substituteWith(substitutor)) [
					visibility = JvmVisibility.PROTECTED

					if (isOverride) {
						annotations += annotationRef(Override);
					}

					if (port.bound !== null) {
						final = true;
						body = '''
							throw new AssertionError("This is a bug");
						'''
						documentation = '''
							This will never be called because this component bind the provided port.
						'''
					} else {
						abstract = true
						documentation = '''
							This should be overridden by the implementation to define the provided port.
							This will be called once during the construction of the component to initialize the port.
						'''
					}
				]
			}
		}
		
		clazz.members += comp.toMethod("requires", requiresRef) [
			if (comp.specializes !== null) {
				annotations += annotationRef(Override)
			}
			visibility = JvmVisibility.PROTECTED
			documentation = '''
				This can be called by the implementation to access the required ports.
			'''
			body = '''
				assert this.selfComponent != null: "This is a bug.";
				if (!this.init) {
					throw new RuntimeException("requires() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if requires() is needed to initialise the component.");
				}
				return this.selfComponent.bridge;
			'''
		]
		
		clazz.members += comp.toMethod("parts", partsRef) [
			if (comp.specializes !== null) {
				annotations += annotationRef(Override)
			}
			visibility = JvmVisibility.PROTECTED
			documentation = '''
				This can be called by the implementation to access the parts and their provided ports.
			'''
			body = '''
				assert this.selfComponent != null: "This is a bug.";
				if (!this.init) {
					throw new RuntimeException("parts() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if parts() is needed to initialise the component.");
				}
				return this.selfComponent;
			'''
		]
		
		for (part : comp.parts) {
			val ptr = part.typeReference.substituteWith(substitutor)
			switch part {
				ComponentPart: {
					clazz.members += part.toMethod("make_"+part.name, ptr) [
						visibility = JvmVisibility.PROTECTED
						abstract = true
						documentation = '''
							This should be overridden by the implementation to define how to create this sub-component.
							This will be called once during the construction of the component to initialize this sub-component.
						'''
					]
				}
				SpeciesPart: {
					clazz.members += newField("use_"+part.name, ptr) []
				}
			}
		}
		
		clazz.members += comp.toMethod("_newComponent", componentIfRef) [
			if (comp.specializes !== null) {
				annotations += annotationRef(Override)
			}
			parameters += newParameter("b", requiresRef)
			parameters += newParameter("start", typeRef(boolean))
			
			synchronized = true
			documentation = '''
				Not meant to be used to manually instantiate components (except for testing).
			'''
			body = '''
				if (this.init) {
					throw new RuntimeException("This instance of «clazz.simpleName» has already been used to create a component, use another one.");
				}
				this.init = true;
				«componentClassRef»  _comp = new «componentClassRef»(this, b, true);
				if (start) {
					_comp.start();
				}
				return _comp;
			'''
		]
		
		switch comp {
			Ecosystem: {
				for(species: comp.species) {
					val str = clazz.getInnerType(species.name).getParameterizedTypeRefWith(myTypeParameters)
					
					val isAbstract = !species.notAbstract
					// careful about the type parameters (substitution)
					// here it is ok, because we are in c and the reference to type params
					// are to those of the inferred class which is c
					clazz.members += species.toMethod("make_"+species.name, str) [
						parameters += species.parameters.map[p|newParameter(p.name, p.parameterType)]
						visibility = JvmVisibility.PROTECTED
						abstract = isAbstract
						documentation = '''
							This should be overridden by the implementation to instantiate the implementation of the species.
						'''
						if (!isAbstract) {
							body = '''
								return new «str»();
							'''
						}
					]
					
					clazz.members += species.toMethod("_createImplementationOf"+species.name, str) [
						parameters += species.parameters.map[p|newParameter(p.name, p.parameterType)]
						documentation = '''
							Do not call, used by generated code.
						'''
						val m = it
						body = [
							append(str.toLightweightTypeReference(clazz.eResource))
							append(''' «declareSyntheticVariable(m,"implem")» = make_«species.name»(«species.parameters.map[name].join(",")»);
							''')
							append('''
							if («getName(m)» == null) {
								throw new RuntimeException("make_«species.name»() in «clazz.qualifiedName» should not return null.");
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
						clazz.members += species.toMethod("new"+species.name, str.getInnerTypeReference(COMPONENT_INTERFACE)) [
							parameters += species.parameters.map[p|newParameter(p.name, p.parameterType)]
							visibility = JvmVisibility.PROTECTED
							documentation = '''
								This can be called to create an instance of the species from inside the implementation of the ecosystem.
							'''
							body = '''
								«str» _implem = _createImplementationOf«species.name»(«species.parameters.map[name].join(",")»);
								return _implem._newComponent(new «str.getInnerTypeReference(REQUIRES_INTERFACE)»() {},true);
							'''
						]
					}
				}
				
				if (comp.allRequires.empty) {
					clazz.members += comp.toMethod("newComponent", componentIfRef) [
						if (comp.specializes !== null) {
							annotations += annotationRef(Override)
						}
						documentation = '''
							Use to instantiate a component from this implementation.
						'''
						body = '''
							return this._newComponent(new «requiresRef»() {}, true);
						'''
					]
				}
			}
			
			Species: {
				val parentEco = comp.parentEcosystem
				val parentRef = parentEco.associatedJvmClass.getParameterizedTypeRefWith(myTypeParameters)
				
				clazz.members += newField("ecosystemComponent", parentRef.getInnerTypeReference(COMPONENT_CLASS)) []
				clazz.members += parentEco.toMethod("eco_provides", parentRef.getInnerTypeReference(PROVIDES_INTERFACE)) [
					visibility = JvmVisibility.PROTECTED
					documentation = '''
						This can be called by the species implementation to access the provided ports of its ecosystem.
					'''
					body = '''
						assert this.ecosystemComponent != null: "This is a bug.";
						return this.ecosystemComponent;
					'''
				]
				
				clazz.members += parentEco.toMethod("eco_requires", parentRef.rootSupertype.getInnerTypeReference(REQUIRES_INTERFACE)) [
					visibility = JvmVisibility.PROTECTED
					documentation = '''
						This can be called by the species implementation to access the required ports of its ecosystem.
					'''
					body = '''
						assert this.ecosystemComponent != null: "This is a bug.";
						return this.ecosystemComponent.bridge;
					'''
				]
				clazz.members += parentEco.toMethod("eco_parts", parentRef.getInnerTypeReference(PARTS_INTERFACE)) [
					visibility = JvmVisibility.PROTECTED
					documentation = '''
						This can be called by the species implementation to access the parts of its ecosystem and their provided ports.
					'''
					body = '''
						assert this.ecosystemComponent != null: "This is a bug.";
						return this.ecosystemComponent;
					'''
				]
			}
		}
	}
	
	def void initLaterRequires(AbstractComponent comp, JvmGenericType clazz, JvmGenericType requires) {
		
		val substitutor = comp.getSubstitutor(requires, comp.eResource)
		
		for(c: requires.typeParameters.map[constraints].flatten) {
			val tr = c.typeReference.substituteWith(substitutor)
			c.setTypeReference(tr)
		}
		
		for (port : comp.requires) {
			requires.members += port.toMethod(port.name, port.typeReference.substituteWith(substitutor))[
				documentation = '''
					This can be called by the implementation to access this required port.
				'''
			]
		}
	}
	
	def void initLaterProvides(AbstractComponent comp, JvmGenericType clazz, JvmGenericType provides) {
		
		val substitutor = comp.getSubstitutor(provides, comp.eResource)
		
		for(c: provides.typeParameters.map[constraints].flatten) {
			val tr = c.typeReference.substituteWith(substitutor)
			c.setTypeReference(tr)
		}
		
		if (comp.specializes !== null) {
			val nstr = comp.specializes.substituteWith(substitutor)
			provides.superTypes += nstr.getInnerTypeReference(PROVIDES_INTERFACE)
		}
		
		for (port : comp.provides) {
			provides.members += port.toMethod(port.name, port.typeReference.substituteWith(substitutor)) [
				documentation = '''
					This can be called to access the provided port.
				'''
			]
		}
	}
	
	def void initLaterParts(AbstractComponent comp, JvmGenericType clazz, JvmGenericType parts) {
		
		val substitutor = comp.getSubstitutor(parts, comp.eResource)
		
		for(c: parts.typeParameters.map[constraints].flatten) {
			val tr = c.typeReference.substituteWith(substitutor)
			c.setTypeReference(tr)
		}
		
		if (comp.specializes !== null) {
			val nstr = comp.specializes.substituteWith(substitutor)
			parts.superTypes += nstr.getInnerTypeReference(PARTS_INTERFACE)
		}
		
		for(part: comp.parts) {
			val nptr = part.typeReference.substituteWith(substitutor)
			parts.members += part.toMethod(part.name, nptr.getInnerTypeReference(COMPONENT_INTERFACE)) [
				documentation = '''
					This can be called by the implementation to access the part and its provided ports.
					It will be initialized after the required ports are initialized and before the provided ports are initialized.
				'''
			]
		}
	}
	
	def void initLaterComponent(AbstractComponent comp, JvmGenericType clazz, JvmGenericType componentIf, JvmGenericType provides) {
				
		val substitutor = comp.getSubstitutor(componentIf, comp.eResource)
		
		for(c: componentIf.typeParameters.map[constraints].flatten) {
			val tr = c.typeReference.substituteWith(substitutor)
			c.setTypeReference(tr)
		}
		
		if (comp.specializes !== null) {
			val nstr = comp.specializes.substituteWith(substitutor)
			componentIf.superTypes += nstr.getInnerTypeReference(COMPONENT_INTERFACE)
		}
		
		componentIf.superTypes += provides.getParameterizedTypeRefWith(componentIf.typeParameters)
	}
	
	def void initLaterComponentImpl(AbstractComponent comp, JvmGenericType clazz, JvmGenericType componentClass) {
		
		val clazzRef = clazz.getParameterizedTypeRefWith(componentClass.typeParameters)
		val substitutor = comp.getSubstitutor(componentClass, comp.eResource)
		
		for(c: componentClass.typeParameters.map[constraints].flatten) {
			val tr = c.typeReference.substituteWith(substitutor)
			c.setTypeReference(tr)
		}
		
		if (comp.specializes !== null) {
			val nstr = comp.specializes.substituteWith(substitutor)
			componentClass.superTypes += nstr.getInnerTypeReference(COMPONENT_CLASS)
		}
		
		componentClass.superTypes += clazzRef.getInnerTypeReference(COMPONENT_INTERFACE)
		componentClass.superTypes += clazzRef.getInnerTypeReference(PARTS_INTERFACE)
		
		// parenthesis are needed because of
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=436279
		val requiresRef = (if (comp.specializes !== null) {
			comp.specializes.substituteWith(substitutor).rootSupertype
		} else {
			clazzRef
		}).getInnerTypeReference(REQUIRES_INTERFACE)
		
		componentClass.members += newField("bridge", requiresRef) [
			final = true
		]
		
		componentClass.members += newField("implementation", clazzRef) [
			final = true
		]
		
		componentClass.members += comp.toMethod("start", typeRef(void)) [
			if (comp.specializes !== null) {
				annotations += annotationRef(Override)
			}
			visibility = JvmVisibility.PUBLIC
			body = '''
				«IF comp.specializes !== null»
					super.start();
				«ENDIF»
				«FOR part : comp.parts»
					assert this.«part.name» != null: "This is a bug.";
					((«part.typeReference.substituteWith(substitutor).getInnerTypeReference(COMPONENT_CLASS)») this.«part.name»).start();
				«ENDFOR»
				this.implementation.start();
				this.implementation.started = true;
			'''
		]
		
		for (part : comp.parts) {
			componentClass.members += part.toMethod("init_"+part.name, typeRef(void)) [
				visibility = JvmVisibility.PRIVATE
				body = '''
					assert this.«part.name» == null: "This is a bug.";
					«IF part instanceof ComponentPart»
						assert this.implem_«part.name» == null: "This is a bug.";
						this.implem_«part.name» = this.implementation.make_«part.name»();
						if (this.implem_«part.name» == null) {
							throw new RuntimeException("make_«part.name»() in «clazzRef.qualifiedName» should not return null.");
						}
						this.«part.name» = this.implem_«part.name»._newComponent(new «REQUIRES_CLASS_PREFIX»_«part.name»(), false);
					«ELSEIF part instanceof SpeciesPart»
						assert this.implementation.use_«part.name» != null: "This is a bug.";
						this.«part.name» = this.implementation.use_«part.name»._newComponent(new «REQUIRES_CLASS_PREFIX»_«(part as SpeciesPart).speciesReference.part.name»_«part.name»(), false);
					«ENDIF»
				'''
			]
		}
		
		componentClass.members += comp.toMethod("initParts", typeRef(void)) [
			if (comp.specializes !== null) {
				annotations += annotationRef(Override)
			}
			visibility = JvmVisibility.PROTECTED
			body = '''
				«IF comp.specializes !== null»
					super.initParts();
				«ENDIF»
				«FOR part : comp.parts»
					init_«part.name»();
				«ENDFOR»
			'''
		]
		
		// we redefine everything in case of override
		for(port: comp.provides) {
			val isOverride = port.overridenPortTypeRef !== null
			componentClass.members += port.toMethod("init_"+port.name, typeRef(void)) [
				visibility = JvmVisibility.PROTECTED
				if (isOverride) {
					annotations += annotationRef(Override)
				}
				if (port.bound === null) {
					body = '''
						assert this.«port.name» == null: "This is a bug.";
						this.«port.name» = this.implementation.make_«port.name»();
						if (this.«port.name» == null) {
							throw new RuntimeException("make_«port.name»() in «clazzRef.qualifiedName» shall not return null.");
						}
					'''
				} else {
					body = '''
						// nothing to do here
					'''
				}
			]
		}
		
		componentClass.members += comp.toMethod("initProvidedPorts", typeRef(void)) [
			if (comp.specializes !== null) {
				annotations += annotationRef(Override)
			}
			visibility = JvmVisibility.PROTECTED
			body = '''
				«IF comp.specializes !== null»
					super.initProvidedPorts();
				«ENDIF»
				«FOR port : comp.provides.filter[overridenPortTypeRef === null]»
					init_«port.name»();
				«ENDFOR»
			'''
		]
		
		componentClass.members += newConstructor() [
			parameters += newParameter("implem", clazzRef)
			parameters += newParameter("b", requiresRef)
			parameters += newParameter("doInits", typeRef(boolean))
			body = '''
				«IF comp.specializes !== null»
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
			'''
		]
		
		for (port : comp.provides) {
			val bound = port.bound
			
			val ptr = port.typeReference.substituteWith(substitutor)
			
			val isOverride = port.overridenPortTypeRef !== null
			val isBound = bound !== null
			
			if (!isBound) {
				// we don't reuse those of the super class in case of override
				componentClass.members += newField(port.name, ptr) []
			}
			
			componentClass.members += port.toMethod(port.name, ptr) [
				if (isOverride) {
					annotations += annotationRef(Override)
				}
				body = '''
					return this.«IF isBound»«portRefCall(bound, comp instanceof Species)»«ELSE»«port.name»«ENDIF»;
				'''
			]
		}
		
		for (part : comp.parts) {
			val tr = part.typeReference
			val nptr = tr.substituteWith(substitutor)
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
					val rt = binding.resolveTypeFrom.substituteWith(substitutor).toJavaCompliantTypeReference
					members += binding.toMethod(binding.from.name, rt) [
						final = true
						body = '''
							return «componentClass».this.«portRefCall(bound, comp instanceof Species)»;
						'''
					]
				}
			]
			
			componentClass.members += part.toMethod(part.name, ctr) [
				final = true
				body = '''
					return this.«part.name»;
				'''
			]
		}
	}
	
	private def CharSequence portRefCall(PortRef bound, boolean inSpecies) '''
		«IF bound.part !== null»
			«IF inSpecies && bound.part.eContainer instanceof Ecosystem»
				implementation.ecosystemComponent.
			«ENDIF»
			«bound.part.name»().
		«ELSE»
			«IF inSpecies && bound.port.eContainer instanceof Ecosystem»
				implementation.ecosystemComponent.
			«ENDIF»«IF bound.port instanceof RequiredPort»bridge.«ENDIF»
		«ENDIF»
		«bound.port.name»()
	'''
}