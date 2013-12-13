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
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.ComposedChecks
import org.eclipse.xtext.validation.NamesAreUniqueValidator
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.typesystem.^override.OverrideHelper

/**
 * Custom validation rules. 
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
@ComposedChecks(validators=#[SpeADLXtendXtextInspiredValidator, SpeADLJvmTypeReferenceValidator, NamesAreUniqueValidator])
class SpeADLValidator extends AbstractSpeADLValidator {
	
	@Inject extension IJvmModelAssociations
	@Inject extension OverrideHelper
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
		val typeTo = pr.resolveType
		
		val cont = pr.eContainer
		
		val typeFrom = switch cont {
			Binding: cont.resolveTypeFrom
			ProvidedPort: cont.typeReference.toLightweightTypeReference(pr.eResource)
			default: throw new RuntimeException("should not happen")
		}
		
		if(typeFrom != null && typeTo != null) {
			if(!typeFrom.isAssignableFrom(typeTo)) {
				error("Incompatible types: " +typeFrom +" is not the same or a supertype of "+typeTo, SpeadlPackage.Literals.PORT_REF__PORT)
			}
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
				val typeTo = reference.arguments.get(i).resolveType
				
				if(!typeFrom.isAssignableFrom(typeTo)) {
					error("Incompatible types: " +typeFrom +" is not the same or a supertype of "+typeTo, SpeadlPackage.Literals.SPECIES_REFERENCE__ARGUMENTS, i)
				}
				i = i + 1
			}
		}
	}
	
	@Check
	def checkNoNewProvWhenImpl(Ecosystem eco) {
		if (eco.specializes != null) {
			var index = 0
			for(ProvidedPort p: eco.provides) {
				error("Provides can't be declared in a specialising component", SpeadlPackage.Literals.ABSTRACT_COMPONENT__PROVIDES, index)
				index = index + 1
			}
		}
	}
	
//	@Check
//	def checkNoNewProvWhenImpl(Ecosystem eco) {
//		val superInfra = eco.specializes
//		if(superInfra != null) {
//			val provides = eco.provides.map[name]
//			val ecoOperations = eco.associatedJvmClass.resolvedOperations.declaredOperations.filter[provides.contains(declaration.simpleName)]
//			val superInfraOperations = superInfra.type.associatedEcosystem.provides.map[jvmElements.head as JvmOperation]
//			
//			var index = 0
//			for(operation: ecoOperations) {
//				var isOverridenWithoutProblem = false
//				var i = 0
//				while(i < superInfraOperations.size && !isOverridenWithoutProblem) {
//					val superOperation = superInfraOperations.get(i)
//					val result = operation.isOverridingOrImplementing(superOperation)
//					isOverridenWithoutProblem = result.overridingOrImplementing && !result.hasProblems
//					i = i + 1
//				}
//				
//				if(!isOverridenWithoutProblem) {
//					error("Provides can't be declared in a specialising component", SpeadlPackage.Literals.ABSTRACT_COMPONENT__PROVIDES, index)
//				}
//				index = index + 1
//			}
//		}
//	}
	
	@Check
	def checkNoNewReqWhenImpl(Ecosystem eco) {
		if(eco.specializes != null) {
			var index = 0
			for(RequiredPort p : eco.requires) {
				error("Requires can't be declared in a specialising component", SpeadlPackage.Literals.ABSTRACT_COMPONENT__REQUIRES, index)
				index = index + 1
			}
		}
	}
	
	@Check
	def checkNoSubInImpl(Ecosystem i) {
		val superInfra = i.specializes
		if(superInfra != null) {
			if(!superInfra.type.associatedEcosystem.parts.empty) {
				error("Can only implements components without subcomponents", SpeadlPackage.Literals.ABSTRACT_COMPONENT__SPECIALIZES)
			}
		}
	}
	
	@Check
	def checkSpecializeReference(Ecosystem ecosystem) {
		if(ecosystem.specializes != null && ecosystem.specializes.type.associatedEcosystem == null) {
			error(ecosystem.specializes.simpleName + " cannot be resolved", ecosystem.specializes, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE)
		}
	}
	
	@Check
	def checkComponentReference(ComponentPart p) {
		if(p.componentReference.type.associatedEcosystem == null) {
			error(p.componentReference.simpleName + " cannot be resolved", p.componentReference, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE)
		}
	}
}
