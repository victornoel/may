package fr.irit.smac.may.speadl.scoping;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import fr.irit.smac.may.speadl.SpeADLUtils;
import fr.irit.smac.may.speadl.speadl.AbstractComponent;
import fr.irit.smac.may.speadl.speadl.Binding;
import fr.irit.smac.may.speadl.speadl.Ecosystem;
import fr.irit.smac.may.speadl.speadl.Part;
import fr.irit.smac.may.speadl.speadl.Port;
import fr.irit.smac.may.speadl.speadl.PortRef;
import fr.irit.smac.may.speadl.speadl.ProvidedPort;
import fr.irit.smac.may.speadl.speadl.RequiredPort;
import fr.irit.smac.may.speadl.speadl.Species;
import fr.irit.smac.may.speadl.speadl.SpeciesReference;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class SpeADLDeclarativeScopeProvider extends AbstractDeclarativeScopeProvider {
  @Inject
  @Extension
  private SpeADLUtils _speADLUtils;
  
  /**
   * return null instead of the delegate set by the RuntimeModule because
   * it would create an infinite loop as the delegate calls
   * the present class
   */
  @Override
  protected IScope delegateGetScope(final EObject context, final EReference reference) {
    return null;
  }
  
  public IScope scope_SpeciesReference_part(final Ecosystem i, final EReference ref) {
    return Scopes.scopeFor(i.getParts());
  }
  
  public IScope scope_SpeciesReference_species(final SpeciesReference i, final EReference ref) {
    return Scopes.scopeFor(this._speADLUtils.abstractComponent(i.getPart()).getSpecies());
  }
  
  public IScope scope_Binding_from(final Part ctx, final EReference ref) {
    return Scopes.scopeFor(this._speADLUtils.getAllRequires(this._speADLUtils.abstractComponent(ctx)));
  }
  
  public IScope scope_PortRef_part(final ProvidedPort ctx, final EReference ref) {
    return this.scope_PortRef_part(ctx.getBound(), ref);
  }
  
  public IScope scope_PortRef_part(final Binding ctx, final EReference ref) {
    return this.scope_PortRef_part(ctx.getTo(), ref);
  }
  
  public IScope scope_PortRef_part(final PortRef ctx, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final AbstractComponent comp = EcoreUtil2.<AbstractComponent>getContainerOfType(ctx, AbstractComponent.class);
      IScope _switchResult = null;
      boolean _matched = false;
      if (comp instanceof Species) {
        boolean _isEcosystem = ctx.isEcosystem();
        if (_isEcosystem) {
          _matched=true;
          _switchResult = Scopes.scopeFor(this._speADLUtils.parentEcosystem(((Species)comp)).getParts());
        }
      }
      if (!_matched) {
        _switchResult = Scopes.scopeFor(comp.getParts());
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public IScope scope_PortRef_port(final ProvidedPort ctx, final EReference ref) {
    return this.scope_PortRef_port(ctx.getBound(), ref);
  }
  
  public IScope scope_PortRef_port(final Binding ctx, final EReference ref) {
    return this.scope_PortRef_port(ctx.getTo(), ref);
  }
  
  public IScope scope_PortRef_port(final PortRef ctx, final EReference ref) {
    IScope _xifexpression = null;
    Part _part = ctx.getPart();
    boolean _tripleNotEquals = (_part != null);
    if (_tripleNotEquals) {
      _xifexpression = Scopes.scopeFor(this._speADLUtils.getAllProvides(this._speADLUtils.abstractComponent(ctx.getPart())));
    } else {
      IScope _xblockexpression = null;
      {
        final AbstractComponent comp = EcoreUtil2.<AbstractComponent>getContainerOfType(ctx, AbstractComponent.class);
        IScope _switchResult = null;
        boolean _matched = false;
        if (comp instanceof Species) {
          boolean _isEcosystem = ctx.isEcosystem();
          if (_isEcosystem) {
            _matched=true;
            IScope _xblockexpression_1 = null;
            {
              final Ecosystem eco = this._speADLUtils.parentEcosystem(((Species)comp));
              Iterable<ProvidedPort> _allProvides = this._speADLUtils.getAllProvides(eco);
              Iterable<RequiredPort> _allRequires = this._speADLUtils.getAllRequires(eco);
              Iterable<Port> _plus = Iterables.<Port>concat(_allProvides, _allRequires);
              _xblockexpression_1 = Scopes.scopeFor(_plus);
            }
            _switchResult = _xblockexpression_1;
          }
        }
        if (!_matched) {
          Iterable<ProvidedPort> _allProvides = this._speADLUtils.getAllProvides(comp);
          Iterable<RequiredPort> _allRequires = this._speADLUtils.getAllRequires(comp);
          Iterable<Port> _plus = Iterables.<Port>concat(_allProvides, _allRequires);
          _switchResult = Scopes.scopeFor(_plus);
        }
        _xblockexpression = _switchResult;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
}
