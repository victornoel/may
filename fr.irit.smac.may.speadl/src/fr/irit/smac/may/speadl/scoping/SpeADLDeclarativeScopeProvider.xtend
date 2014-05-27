package fr.irit.smac.may.speadl.scoping

import com.google.inject.Inject
import fr.irit.smac.may.speadl.SpeADLUtils
import fr.irit.smac.may.speadl.speadl.AbstractComponent
import fr.irit.smac.may.speadl.speadl.Binding
import fr.irit.smac.may.speadl.speadl.Ecosystem
import fr.irit.smac.may.speadl.speadl.Part
import fr.irit.smac.may.speadl.speadl.PortRef
import fr.irit.smac.may.speadl.speadl.ProvidedPort
import fr.irit.smac.may.speadl.speadl.Species
import fr.irit.smac.may.speadl.speadl.SpeciesReference
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider

class SpeADLDeclarativeScopeProvider extends AbstractDeclarativeScopeProvider {
	
	@Inject extension SpeADLUtils
	
	/**
	 * return null instead of the delegate set by the RuntimeModule because
	 * it would create an infinite loop as the delegate calls
	 * the present class
	 */
	override protected delegateGetScope(EObject context, EReference reference) {
		null
	}
	
	// SpeciesReference
	
	def IScope scope_SpeciesReference_part(Ecosystem i, EReference ref) {
		Scopes.scopeFor(i.parts)
	}
	
	def IScope scope_SpeciesReference_species(SpeciesReference i, EReference ref) {
		Scopes.scopeFor(i.part.abstractComponent.species)
	}
	
	// BINDING FROM
	
	def IScope scope_Binding_from(Part ctx, EReference ref) {
		Scopes.scopeFor(ctx.abstractComponent.allRequires)
	}
	
	// BINDING TO
	
	def IScope scope_PortRef_part(ProvidedPort ctx, EReference ref) {
		// needed because when completion is triggered, the context is ProvidedPort and not PortRef
		// if this is disabled scope_PortRef_port(PortRef) is not even triggered!
		scope_PortRef_part(ctx.bound, ref)
	}
	
	def IScope scope_PortRef_part(Binding ctx, EReference ref) {
		// needed because when completion is triggered, the context is Binding and not PortRef
		// if this is disabled scope_PortRef_part(PortRef) is not even triggered!
		scope_PortRef_part(ctx.to, ref)
	}
	
	def IScope scope_PortRef_part(PortRef ctx, EReference ref) {
		val comp = EcoreUtil2.getContainerOfType(ctx, AbstractComponent)
		
		switch comp {
			Species case ctx.ecosystem: Scopes.scopeFor(comp.parentEcosystem.parts)
			default: Scopes.scopeFor(comp.parts)
		}
	}
	
	def IScope scope_PortRef_port(ProvidedPort ctx, EReference ref) {
		// needed because when completion is triggered, the context is ProvidedPort and not PortRef
		// if this is disabled scope_PortRef_port(PortRef) is not even triggered!
		scope_PortRef_port(ctx.bound, ref)
	}
	
	def IScope scope_PortRef_port(Binding ctx, EReference ref) {
		// needed because when completion is triggered, the context is Binding and not PortRef
		// if this is disabled scope_PortRef_port(PortRef) is not even triggered!
		scope_PortRef_port(ctx.to, ref)
	}
	
	def IScope scope_PortRef_port(PortRef ctx, EReference ref) {
		if (ctx.part != null) {
			Scopes.scopeFor(ctx.part.abstractComponent.allProvides)
		} else {
			val comp = EcoreUtil2.getContainerOfType(ctx, AbstractComponent)
			switch comp {
				Species case ctx.ecosystem: {
					val eco = comp.parentEcosystem
					Scopes.scopeFor(eco.allProvides + eco.allRequires)
				}
				default: Scopes.scopeFor(comp.allProvides + comp.allRequires)
			}
		}
	}
}