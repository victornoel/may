package fr.irit.smac.may.speadl.validation

import com.google.inject.Inject
import fr.irit.smac.may.speadl.SpeADLUtils
import fr.irit.smac.may.speadl.speadl.AbstractComponent
import fr.irit.smac.may.speadl.speadl.Binding
import fr.irit.smac.may.speadl.speadl.ComponentPart
import fr.irit.smac.may.speadl.speadl.ContentElement
import fr.irit.smac.may.speadl.speadl.Ecosystem
import fr.irit.smac.may.speadl.speadl.Part
import fr.irit.smac.may.speadl.speadl.PortRef
import fr.irit.smac.may.speadl.speadl.ProvidedPort
import fr.irit.smac.may.speadl.speadl.RequiredPort
import fr.irit.smac.may.speadl.speadl.SpeadlPackage
import fr.irit.smac.may.speadl.speadl.SpeciesReference
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmWildcardTypeReference
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.ComposedChecks
import org.eclipse.xtext.validation.NamesAreUniqueValidator
import org.eclipse.xtext.EcoreUtil2
import fr.irit.smac.may.speadl.speadl.Species

/**
 * Custom validation rules. 
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 * 
 * Carefull, NORMAL check rules are not taken into account to prevent generation
 * The idea is that there valiation rules are relying on the generated code to be valid...
 */
@ComposedChecks(validators=#[SpeADLXtendXtextInspiredValidator, SpeADLJvmTypeReferenceValidator, NamesAreUniqueValidator])
class SpeADLValidator extends AbstractSpeADLValidator {
	
	@Inject extension SpeADLUtils
	
//	@Check
//	def checkProvidedPortsUsed(AbstractComponent comp) {
//		
//		val bounds = 
//			(comp.parts.map[bindings.map[to.port]].flatten
//				+ comp.provides.map[bound].filterNull
//			).toSet
//		
//		for(part: comp.parts) {
//			for (pp: part.abstractComponent.allProvides) {
//				if (!bounds.contains(pp)) {
//					warning("Provided port "+pp.name+" not used.", part, SpeadlPackage.Literals.CONTENT_ELEMENT__NAME)
//				}
//			}
//		}
//	}
	
	/**
	 * See checkLocalUsageOfDeclaredFields for hilighting unbinded part!
	 * And checkNonInitializedFieldsHaveAType if we want to infer type of already bound provides, would be nice...
	 */
	
	@Check
	def checkPortRef(PortRef pr) {
		// port can't be null nor a proxy: no need to check
		if (pr.port == null || pr.port.eIsProxy) return;
		// part can be null, but can't be a proxy: no need to check
		if (pr.part != null && pr.part.eIsProxy) return;
		
		val typeTo = pr.resolveType
		
		val typeFrom = switch cont: pr.eContainer {
			Binding: cont.resolveTypeFrom
			ProvidedPort: cont.typeReference.toLightweightTypeReference(pr.eResource)
		}
		
		if(typeFrom != null && typeTo != null) {
			if(!typeFrom.isAssignableFrom(typeTo)) {
				error("Incompatible types: " +typeFrom +" is not the same or a supertype of "+typeTo, SpeadlPackage.Literals.PORT_REF__PORT)
			}
		}
	}
	
	@Check
	def checkPortRefEco(PortRef pr) {
		val comp = EcoreUtil2.getContainerOfType(pr, AbstractComponent)
		if (pr.ecosystem && !(comp instanceof Species)) {
			warning("The keyword eco is meant to be used from inside a Species", SpeadlPackage.Literals.PORT_REF__ECOSYSTEM)
		}
	}
	
	@Check
	def checkStartsWithCapital(AbstractComponent ne) {
		if (!Character.isUpperCase(ne.getName().charAt(0))) {
			error("Name must start with a capital",
					SpeadlPackage.Literals.ABSTRACT_COMPONENT__NAME);
		}
	}
	
	@Check
	def checkStartsWithCapital(JvmTypeParameter ne) {
		if (!Character.isUpperCase(ne.getName().charAt(0))) {
			error("Name must start with a capital",
					TypesPackage.Literals.JVM_TYPE_PARAMETER__NAME);
		}
	}
	
	@Check
	def checkStartsWithoutCapital(ContentElement ne) {
		if (!Character.isLowerCase(ne.getName().charAt(0))) {
			error("Name must not start with a capital",
					SpeadlPackage.Literals.CONTENT_ELEMENT__NAME);
		}
	}
	
	@Check
	def checkBound(Part ci) {
		val toBind = ci.abstractComponent.allRequires.toSet
		val bound = ci.bindings.map[from].toSet
		
		toBind.removeAll(bound)
		if(!toBind.empty) {
			error("Missing bindings for required ports.",
					SpeadlPackage.Literals.CONTENT_ELEMENT__NAME);
		}
	}
	
	@Check
	def checkUseArgsAgainstParameters(SpeciesReference reference) {
		val numParameters = reference.species.parameters.size
		if(numParameters != reference.arguments.size) {
				error("Incorrect number of arguments for species " 
						+ reference.species.name + "(" + reference.species.parameters.map[name].join(",") + ")"
						+ "; it cannot be parameterized with arguments " 
						+ "(" + reference.arguments.map[name].join(",") + ")",
					SpeadlPackage.Literals.SPECIES_REFERENCE__ARGUMENTS)
		}
	}
	
	@Check
	def checkUseArguments(SpeciesReference reference) {
		val argSize = reference.arguments.size
		val paramSize = reference.species.parameters.size
		if (argSize == paramSize) {
			var i = 0
			val part = reference.part
			while(i < argSize) {
				val typeFrom = reference.species.parameters.get(i).resolveType(part)
				val typeTo = reference.arguments.get(i).getTypeRef
				
				if(!typeFrom.isAssignableFrom(typeTo)) {
					error("Incompatible types: " +typeFrom +" is not the same or a supertype of "+typeTo, SpeadlPackage.Literals.SPECIES_REFERENCE__ARGUMENTS, i)
				}
				i = i + 1
			}
		}
	}
		 
	@Check
	def checkProvidesOverrideAreOk(ProvidedPort p) {
		val typeTo = p.typeReference.toLightweightTypeReference(p.eResource)
		val typeFrom = p.overridenPortTypeRef
		
		if(typeFrom != null && typeTo != null) {
			if(!typeFrom.isAssignableFrom(typeTo)) {
				error("Incompatible type override: " +typeFrom +" is not the same or a supertype of "+typeTo, SpeadlPackage.Literals.PORT__TYPE_REFERENCE)
			}
		}
	}
	
	@Check
	def checkNoNewReqWhenImpl(Ecosystem eco) {
		if(!eco.specializes.useless) {
			var index = 0
			for(RequiredPort p : eco.requires) {
				error("Requires can't be declared in a specialising component", SpeadlPackage.Literals.ABSTRACT_COMPONENT__REQUIRES, index)
				index = index + 1
			}
		}
	}
	
	@Check
	def checkSpecializeReference(Ecosystem ecosystem) {
		val superTypeRef = ecosystem.specializes
		if(!superTypeRef.useless) {
			val superType = superTypeRef.type.associatedEcosystem
			if (superType == null) {
				error(ecosystem.specializes.simpleName + " cannot be resolved", ecosystem.specializes, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE)
			} else {
				if(!superType.parts.empty) {
					error("Can only implements components without subcomponents", SpeadlPackage.Literals.ABSTRACT_COMPONENT__SPECIALIZES)
				}
				if (superType.hasCycleInHierarchy) {
					error("The inheritance hierarchy of " + ecosystem.name + " contains cycles",
							SpeadlPackage.Literals.ABSTRACT_COMPONENT__NAME);
				}
				if(superTypeRef.isInvalidWildcard) {
					error("The type "
						+ ecosystem.name 
						+ " cannot extend or implement "
						+ superTypeRef.getIdentifier() 
						+ ". A supertype may not specify any wildcard", SpeadlPackage.Literals.ABSTRACT_COMPONENT__SPECIALIZES)
					
				}
			}
		}
	}

	// copied from XtendJavaValidator	
	def isInvalidWildcard(JvmTypeReference typeRef) {
		if (typeRef instanceof JvmWildcardTypeReference)
			return true
		else if (typeRef instanceof JvmParameterizedTypeReference) {
			for(typeArgument: typeRef.getArguments()) {
				if(typeArgument instanceof JvmWildcardTypeReference) 
					return true
			}
		}
		return false
	}
	
	@Check
	def checkComponentReference(ComponentPart p) {
		val eco = p.componentReference.type.associatedEcosystem
		if(eco == null) {
			error(p.componentReference.simpleName + " cannot be resolved", p.componentReference, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE)
		}
	}
	
//	@Check(CheckType.NORMAL)
//	def checkImplementedBy(ImplementedBy ib) {
//		val eco = ib.eContainer as Ecosystem
//		val shouldBe = eco.associatedJvmClass.getTypeRef.toLightweightTypeReference(ib.eResource)
//		val is = ib.ref.toLightweightTypeReference(ib.eResource)
//		val argument = new TypeConformanceComputationArgument(true, false, true, true, false, true)
//		if (!shouldBe.isAssignableFrom(is, argument)) {
//			error(is.simpleName + " is not extending "+shouldBe.simpleName, SpeadlPackage.Literals.IMPLEMENTED_BY__REF)
//		} else {
//			val type = is.type as JvmGenericType
//			if (type.abstract) {
//				error(is.simpleName + " can't be instantiated (abstract)", SpeadlPackage.Literals.IMPLEMENTED_BY__REF)
//			} else {
//				val hasOkConstructor = type.declaredConstructors.empty || type.declaredConstructors.exists[parameters.empty]
//				if (!hasOkConstructor) {
//					error(is.simpleName + " does not have a parameter-less constructor", SpeadlPackage.Literals.IMPLEMENTED_BY__REF)
//				}
//			}
//		}
//	}
	
	@Check
	def checkTypeParameterForwardReferences(AbstractComponent c) {
		doCheckTypeParameterForwardReference(c.getTypeParameters())
	}
	
	@Check
	override checkTypeParameterNotUsedInStaticContext(JvmTypeReference ref) {
		// do nothing because this conflicts with our JvmModelInferrer and
		// we don't have such cases in our language
	}
	
}
