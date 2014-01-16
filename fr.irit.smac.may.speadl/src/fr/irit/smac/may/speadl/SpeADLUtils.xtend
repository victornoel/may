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
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.xbase.compiler.IElementIssueProvider
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.eclipse.xtext.xbase.typesystem.util.ConstraintAwareTypeArgumentCollector
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo
import java.util.Set

class SpeADLUtils {
	
	@Inject extension IJvmModelAssociations
	@Inject extension TypeReferences
	
	@Inject IElementIssueProvider.Factory issueProviderFactory
	@Inject CommonTypeComputationServices services
	
	def parentEcosystem(Species s) {
		s.eContainer as Ecosystem
	}
	
	def associatedJvmClass(Ecosystem e) {
		e.jvmElements.head as JvmGenericType
	}
	
	def associatedEcosystem(JvmType type) {
		type.primarySourceElement as Ecosystem
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
	
	def dispatch ecosystemTypeReference(ComponentPart part) {
		part.componentReference
	}
	
	def dispatch ecosystemTypeReference(SpeciesPart part) {
		part.speciesReference.part.componentReference 
	}
	
	def getInnerTypeReference(JvmTypeReference r, String simpleName) {
		if (r == null) return null
		val iType = r.type.getInnerType(simpleName)
		if (iType == null) return null
		switch r {
			JvmParameterizedTypeReference: iType.createTypeRef(r.arguments)
			default: iType.createTypeRef
		}
	}
	
	def getInnerType(JvmType in, String simpleName) {
		if (in == null) return null
		switch in {
			JvmDeclaredType : in.members.filter(JvmGenericType).findFirst[t|t.simpleName == simpleName]
		}
	}
	
	def substituteTypeParameters(JvmTypeReference in, List<JvmTypeParameter> from, List<JvmTypeParameter> to, Resource context) {
		if (in == null) return null
		switch in {
			JvmParameterizedTypeReference: {
				val str = in.toLightweightTypeReference(context)
				// happens with broken ref when there is errors in the document
				if (!(str instanceof ParameterizedTypeReference)) return in
				substituteTypeParameters(str, from, to).toJavaCompliantTypeReference
			}
			default: in
		}
	}
	
	def substituteTypeParameters(LightweightTypeReference in, List<JvmTypeParameter> from, List<JvmTypeParameter> to) {
		val converter = new OwnedConverter(in.owner, false)
		val mapping = from.toInvertedMap [ k |
			val r = converter.toLightweightReference(to.get(from.indexOf(k)).createTypeRef)
			new LightweightMergedBoundTypeArgument(r, VarianceInfo.INVARIANT)
		]
		val res = new StandardTypeParameterSubstitutor(mapping, in.owner).substitute(in)
		res
	}
	
	def getParameterizedTypeRefWith(JvmType type, List<JvmTypeParameter> typeParameters) {
		if (type == null) return null
		type.createTypeRef(typeParameters.map[createTypeRef]) as JvmParameterizedTypeReference
	}
	
	def getTypeRef(JvmType type) {
		if (type == null) return null
		type.createTypeRef as JvmParameterizedTypeReference
	}
	
	def hasCycleInHierarchy(Ecosystem ecosystem) {
		ecosystem.hasCycleInHierarchy(newHashSet)
	}
	
	// inspired from XtendJavaValidator
	def boolean hasCycleInHierarchy(Ecosystem ecosystem, Set<Ecosystem> processedSuperTypes) {
		if (processedSuperTypes.contains(ecosystem)) {
			return true
		}
		processedSuperTypes.add(ecosystem)
		val superType = ecosystem.specializes?.type?.associatedEcosystem
		if (superType != null && superType.hasCycleInHierarchy(processedSuperTypes)) {
			return true
		}
		processedSuperTypes.remove(ecosystem)
		return false
	}
	
	/*
	 * these give the requires and the provides
	 * the most specialized for a component and its hierarchy
	 * 
	 */
	
	// TODO we should clarify what are the rules for specializing!
	def Iterable<RequiredPort> getAllRequires(AbstractComponent i) {
		i.requires + switch i {
			Ecosystem: {
				val eco = i.specializes?.type?.associatedEcosystem
				if (eco != null && !eco.hasCycleInHierarchy) {
					eco.allRequires.filter[ar|!i.requires.exists[r|r.name == ar.name]]
				} else {
					#[]
				}
			}
			default: {
				#[]
			}
		}
	}
	
	def Iterable<ProvidedPort> getAllProvides(AbstractComponent i) {
		i.provides + switch i {
			Ecosystem: {
				val eco = i.specializes?.type?.associatedEcosystem
				if (eco != null && !eco.hasCycleInHierarchy) {
					eco.allProvides.filter[ar|!i.provides.exists[r|r.name == ar.name]]
				} else {
					#[]
				}
			}
			default: {
				#[]
			}
		}
	}
	
	// utils
	
	def toLightweightTypeReference(JvmTypeReference typeRef, Resource context) {
		val converter = new OwnedConverter(new StandardTypeReferenceOwner(services, context), false)
		converter.toLightweightReference(typeRef)
	}
	
	// typing: TODO maybe move all of this in a specialization of XbaseWithAnnotationsTypeComputer
	
	def resolveTypeFrom(Binding binding) {
		binding.from.resolveType(binding.eContainer as Part)
	}
	
	def resolveType(Feature f) {
		f.parameterType.toLightweightTypeReference(f.eResource)
	}
	
	// here we are obviously in a species
	def resolveType(Feature f, Part p) {
		val ftr = f.resolveType
		// same as in resolveType(Port, Part)
		val ptr = p.ecosystemTypeReference.toLightweightTypeReference(p.eResource)
		ftr.resolveType(ptr)
	}
	
	def resolveType(PortRef ref) {
		if (ref.part == null) {
			ref.port.typeReference.toLightweightTypeReference(ref.eResource)
		} else {
			ref.port.resolveType(ref.part)
		}
	}
	
	def resolveType(Port port, Part part) {
		val portTypeRef = port.typeReference.toLightweightTypeReference(port.eResource)
		// TODO if this is a SpeciesPart, we need the type parameters from
		// the ecosystem type, since they are thw type parameters used in the port type.
		// here we are using the type parameter from the species class, this is wrong
		// BUT that's not normal, as typeReference uses the part ref type param to build the ref...
		// THAT should be checked!
		// the problem is that the mappind created is done wrt the species class!
		// but we still need to have the link to the abstractcomponent to check port/specialize ownership
		val partTypeRef = part.ecosystemTypeReference.toLightweightTypeReference(part.eResource)
		resolveType(portTypeRef, partTypeRef, port, part.typeReference.type.associatedEcosystem)
	}
	
	private def LightweightTypeReference resolveType(LightweightTypeReference portTypeRef, LightweightTypeReference containerTypeRef, Port port, AbstractComponent ac) {
		// ac is null if it is a species but then there is no need to recurse
		// can use also eContainer to check!
		val tr = if (ac != null && !(ac.provides.contains(port) || ac.requires.contains(port)) && ac.specializes != null) {
			val nptr = ac.specializes.toLightweightTypeReference(ac.eResource)
			resolveType(portTypeRef, nptr, port, ac.specializes.type.associatedEcosystem)
		} else {
			portTypeRef
		}
		resolveType(tr, containerTypeRef)
	}
	
	private def LightweightTypeReference resolveType(LightweightTypeReference tr, LightweightTypeReference containerTypeRef) {
		val mapping = new ConstraintAwareTypeArgumentCollector(containerTypeRef.owner).getTypeParameterMapping(containerTypeRef)
		new StandardTypeParameterSubstitutor(mapping, containerTypeRef.owner).substitute(tr)
	}
	
	def boolean modelElementHasError(EObject e, boolean ignoreContent, (Issue) => Boolean ignore, boolean ignoreContentOfIgnored) {
		val issueProvider = issueProviderFactory.get(e.eResource)
		var ignored = false
		for(i: issueProvider.getIssues(e)) {
			ignored = ignore.apply(i)
			if (i.severity == Severity.ERROR && !ignored) return true
		}
		if (!ignoreContent && !(ignoreContentOfIgnored && ignored)) {
			for(oe: e.eContents) {
				if (oe.modelElementHasError(ignoreContent, ignore, ignoreContentOfIgnored)) return true
			}
		}
		return false
	}
	
}