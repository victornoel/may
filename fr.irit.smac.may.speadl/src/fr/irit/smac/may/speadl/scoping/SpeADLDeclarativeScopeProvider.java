package fr.irit.smac.may.speadl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

import fr.irit.smac.may.speadl.SpeADLUtils;
import fr.irit.smac.may.speadl.speadl.AbstractComponent;
import fr.irit.smac.may.speadl.speadl.Binding;
import fr.irit.smac.may.speadl.speadl.ComponentPart;
import fr.irit.smac.may.speadl.speadl.Ecosystem;
import fr.irit.smac.may.speadl.speadl.PortRef;
import fr.irit.smac.may.speadl.speadl.ProvidedPort;
import fr.irit.smac.may.speadl.speadl.SpeciesPart;
import fr.irit.smac.may.speadl.speadl.SpeciesReference;
import fr.irit.smac.may.speadl.speadl.util.SpeadlSwitch;

public class SpeADLDeclarativeScopeProvider extends AbstractDeclarativeScopeProvider {
	
	@Inject
	private SpeADLUtils utils;
	
	@Override
	protected IScope delegateGetScope(EObject context, EReference reference) {
		// return null instead of the delegate set by the RuntimeModule because
		// it would create an infinite loop
		return null;
	}
	
	// SpeciesReference
	
	IScope scope_SpeciesReference_part(Ecosystem i, EReference ref) {
		return Scopes.scopeFor(i.getParts());
	}
	
	IScope scope_SpeciesReference_species(SpeciesReference i, EReference ref) {
		return Scopes.scopeFor(utils.associatedEcosystem(i.getPart().getComponentReference().getType()).getSpecies());
	}
	
	// FROM
	
	IScope scope_Binding_from(ComponentPart ctx, EReference ref) {
		return Scopes.scopeFor(utils.getAllRequires(utils.associatedEcosystem(ctx.getComponentReference().getType())));
	}
	IScope scope_Binding_from(SpeciesPart ctx, EReference ref) {
		return Scopes.scopeFor(utils.getAllRequires(ctx.getSpeciesReference().getSpecies()));
	}
	
	
	// TO
	
	IScope scope_PortRef_part(AbstractComponent ctx, EReference ref) {
		return Scopes.scopeFor(ctx.getParts());
	}
	
	IScope scope_PortRef_port(ProvidedPort ctx, EReference ref) {
		// needed because when completion is triggered, the context is ProvidedPort and not PortRef
		// if this is disabled scope_PortRef_port(PortRef) is not even triggered!
		return scope_PortRef_port(ctx.getBound(), ref);
	}
	
	IScope scope_PortRef_port(Binding ctx, EReference ref) {
		// needed because when completion is triggered, the context is Binding and not PortRef
		// if this is disabled scope_PortRef_port(PortRef) is not even triggered!
		return scope_PortRef_port(ctx.getTo(), ref);
	}
	
	IScope scope_PortRef_port(PortRef ctx, EReference ref) {
		if (ctx.getPart() != null) {
			return new SpeadlSwitch<IScope>() {
				@Override
				public IScope caseSpeciesPart(SpeciesPart object) {
					return Scopes.scopeFor(utils.getAllProvides(object.getSpeciesReference().getSpecies()));
				}
				@Override
				public IScope caseComponentPart(ComponentPart object) {
					return Scopes.scopeFor(utils.getAllProvides(utils.associatedEcosystem(object.getComponentReference().getType())));
				}
			}.doSwitch(ctx.getPart());
		} else {
			AbstractComponent containingComponent = EcoreUtil2.getContainerOfType(ctx, AbstractComponent.class);
			return Scopes.scopeFor(Iterables.concat(utils.getAllRequires(containingComponent), utils.getAllProvides(containingComponent)));
		}
	}
}
