package fr.irit.smac.may.speadl

import com.google.inject.Inject
import fr.irit.smac.may.speadl.speadl.AbstractComponent
import fr.irit.smac.may.speadl.speadl.Binding
import fr.irit.smac.may.speadl.speadl.ComponentPart
import fr.irit.smac.may.speadl.speadl.Ecosystem
import fr.irit.smac.may.speadl.speadl.Feature
import fr.irit.smac.may.speadl.speadl.Part
import fr.irit.smac.may.speadl.speadl.Port
import fr.irit.smac.may.speadl.speadl.PortRef
import fr.irit.smac.may.speadl.speadl.ProvidedPort
import fr.irit.smac.may.speadl.speadl.RequiredPort
import fr.irit.smac.may.speadl.speadl.Species
import fr.irit.smac.may.speadl.speadl.SpeciesPart
import java.util.Collection
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVoid
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.eclipse.xtext.xbase.typesystem.util.ConstraintAwareTypeArgumentCollector
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor

class SpeADLUtils {

	@Inject extension IJvmModelAssociations
	@Inject extension TypeReferences

	@Inject CommonTypeComputationServices services

	// Methods for exploring the model
	// and the inferred model
	
	def parentEcosystem(Species s) {
		s.eContainer as Ecosystem
	}

	def associatedJvmClass(Ecosystem e) {
		e.jvmElements.head as JvmGenericType
	}

	def associatedEcosystem(JvmType type) {
		type.primarySourceElement as Ecosystem
	}

	def associatedJvmOperation(Port p) {
		p.jvmElements.head as JvmOperation
	}

	def associatedProvidedPort(JvmOperation o) {
		o.primarySourceElement as ProvidedPort
	}

	def associatedRequiredPort(JvmOperation o) {
		o.primarySourceElement as RequiredPort
	}

	def dispatch abstractComponent(ComponentPart part) {
		part.componentReference.type.associatedEcosystem
	}

	def dispatch abstractComponent(SpeciesPart part) {
		part.speciesReference.species
	}

	def dispatch typeReference(ComponentPart part) {
		part.componentReference
	}

	def dispatch typeReference(SpeciesPart part) {
		part.speciesReference.part.componentReference.getInnerTypeReference(part.speciesReference.species.name)
	}
	
	def getInnerTypeReference(JvmTypeReference r, String simpleName) {
		if(r == null) return null
		val iType = r.type.getInnerType(simpleName)
		if(iType == null) return null
		switch r {
			JvmParameterizedTypeReference case iType.typeParameters.size == r.arguments.size: iType.
				createTypeRef(r.arguments)
			default: iType.createTypeRef
		}
	}

	def getInnerType(JvmType in, String simpleName) {
		if(in == null) return null
		switch in {
			JvmDeclaredType: in.members.filter(JvmGenericType).findFirst[t|t.simpleName == simpleName]
		}
	}

	// methods for creating references

	def getParameterizedTypeRefWith(JvmType type, List<JvmTypeParameter> typeParameters) {
		if(type == null) null else type.createTypeRef(typeParameters.map[createTypeRef])
	}

	def getTypeRef(JvmType type) {
		if(type == null) null else type.createTypeRef
	}
	
	// methods for AbstractComponents

	def hasCycleInHierarchy(Ecosystem ecosystem) {
		ecosystem.hasCycleInHierarchy(newHashSet)
	}

	// inspired from XtendJavaValidator
	private def boolean hasCycleInHierarchy(Ecosystem ecosystem, Set<Ecosystem> processedSuperTypes) {
		if (processedSuperTypes.contains(ecosystem)) {
			return true
		}
		processedSuperTypes.add(ecosystem)
		if (!ecosystem.specializes.useless) {
			val superType = ecosystem.specializes.type.associatedEcosystem
			if (superType != null && superType.hasCycleInHierarchy(processedSuperTypes)) {
				return true
			}
		}
		processedSuperTypes.remove(ecosystem)
		return false
	}

	/**
	 * these give the requires the most specialized
	 * for a component and its hierarchy
	 */
	def Iterable<RequiredPort> getAllRequires(AbstractComponent i) {
		i.getAllPorts([requires])
	}
	
	/**
	 * these give the provides the most specialized
	 * for a component and its hierarchy
	 */
	def Iterable<ProvidedPort> getAllProvides(AbstractComponent i) {
		i.getAllPorts([provides])
	}
	
	private def <P extends Port> Iterable<P> getAllPorts(AbstractComponent i, (AbstractComponent) => Iterable<P> getPorts) {
		switch i {
			Ecosystem case !i.hasCycleInHierarchy: {
				val res = newArrayList()
				i.gatherPorts(getPorts, res)
				res
			}
			default: getPorts.apply(i)
			
		}
	}
	
	private def <P extends Port> void gatherPorts(Ecosystem i, (Ecosystem) => Iterable<P> getPorts, Collection<P> ports) {
		ports += getPorts.apply(i).filter[ar|!ports.exists[r|r.name == ar.name]]
		if (!i.specializes.useless) {
			val eco = i.specializes.type.associatedEcosystem
			if (eco != null) {
				eco.gatherPorts(getPorts, ports)
			}
		}
	}

	def isUseless(JvmTypeReference typeReference) {
		typeReference == null || typeReference.type == null || typeReference.type instanceof JvmVoid
	}

	def toLightweightTypeReference(JvmTypeReference typeRef, Resource context) {
		val converter = new OwnedConverter(new StandardTypeReferenceOwner(services, context), false)
		converter.toLightweightReference(typeRef)
	}
	
	// typing: TODO maybe move all of this in a specialization
	// of XbaseWithAnnotationsTypeComputer...
	// I don't know how it works :)
	
	def getTypeRef(Feature f) {
		f.parameterType.toLightweightTypeReference(f.eResource)
	}
	
	def getTypeRef(Port p) {
		p.typeReference.toLightweightTypeReference(p.eResource)
	}

	def resolveTypeFrom(Binding binding) {
		binding.from.resolveType(binding.eContainer as Part)
	}

	def resolveType(PortRef ref) {
		if (ref.part == null) {
			// in that case the port is either:
			// in the component containing the portref (a species or an ecosystem)
			// (ecosystem case: in the ecosystem of the species containing the portref)
			// in a super-ecosystem of the ecosystem containing the portref
			// (ecosystem case: in a super-ecosystem of the ecosystem of the species containing the portref)
			// See SpeADLDeclarativeScopeProvider for disabled cases
			val comp = EcoreUtil2.getContainerOfType(ref, AbstractComponent)
			val otr = switch comp {
				Species case ref.ecosystem: {
					comp.parentEcosystem.getOverridenPortTypeRef(ref.port)
				}
				Species: {
					null
				}
				default: {
					comp.getOverridenPortTypeRef(ref.port)
				}
			}
			if (otr == null) ref.port.typeRef else otr
		} else {
			ref.port.resolveType(ref.part)
		}
	}

	def resolveType(Port port, Part part) {
		val partTypeRef = part.parameterizedEcosystemTypeRef
		// associatedEcosystem will be null if the part refers to a species
		val otr = part.typeReference.type.associatedEcosystem?.getOverridenPortTypeRef(port)
		val tr = if (otr == null) port.typeRef else otr
		partTypeRef.substitutor.substitute(tr)
	}

	// here we are obviously in a species
	// so no need to recurse in super…
	def resolveType(Feature f, Part p) {
		val ftr = f.typeRef
		val ptr = p.parameterizedEcosystemTypeRef
		
		ptr.substitutor.substitute(ftr)
	}
	
	private def dispatch getParameterizedEcosystemTypeRef(ComponentPart part) {
		part.componentReference.toLightweightTypeReference(part.eResource)
	}

	private def dispatch getParameterizedEcosystemTypeRef(SpeciesPart part) {
		part.speciesReference.part.componentReference.toLightweightTypeReference(part.eResource)
	}
	
	def JvmTypeReference rootSupertype(JvmTypeReference in) {
		if(in.useless) return null
		val comp = in.type.associatedEcosystem
		switch in {
			JvmParameterizedTypeReference case comp != null && !comp.specializes.useless: {
				val substitutor = in.getSubstitutor(comp.eResource)
				comp.specializes.substituteWith(substitutor)
			}
			default:
				in
		}
	}
	
	def LightweightTypeReference getOverridenPortTypeRef(Port p) {
		(p.eContainer as AbstractComponent).getOverridenPortTypeRef(p)
	}
	
	dispatch def LightweightTypeReference getOverridenPortTypeRef(Species c, Port p) {
		null
	}
	
	dispatch def LightweightTypeReference getOverridenPortTypeRef(Ecosystem c, ProvidedPort p) {
		c.getOverridenPortTypeRef([provides], p.name)
	}
	
	dispatch def LightweightTypeReference getOverridenPortTypeRef(Ecosystem c, RequiredPort p) {
		c.getOverridenPortTypeRef([requires], p.name)
	}
	
	private def <P extends Port> LightweightTypeReference getOverridenPortTypeRef(Ecosystem e, (Ecosystem) => Iterable<P> getPorts, String name) {
		if(e.specializes.useless) return null
		val se = e.specializes.type.associatedEcosystem
		if(se == null) return null

		val substitutor = e.specializes.getSubstitutor(se.eResource)

		val ov = getPorts.apply(se).findFirst[p|p.name == name]

		if (ov == null) {
			se.getOverridenPortTypeRef(getPorts, name)
		} else {
			ov.typeReference.toLightweightTypeReference(ov.eResource)
		}.substituteWith(substitutor)
	}

	def getSubstitutor(JvmTypeReference containerRef, Resource context) {
		containerRef.toLightweightTypeReference(context).substitutor
	}

	def getSubstitutor(LightweightTypeReference containerRef) {
		val mapping = new ConstraintAwareTypeArgumentCollector(containerRef.owner).getTypeParameterMapping(containerRef)
		new StandardTypeParameterSubstitutor(mapping, containerRef.owner)
	}

	def substituteWith(JvmTypeReference ref, TypeParameterSubstitutor<?> substitutor) {
		substitutor.substitute(ref).toJavaCompliantTypeReference
	}

	def substituteWith(LightweightTypeReference ref, TypeParameterSubstitutor<?> substitutor) {
		substitutor.substitute(ref)
	}
}