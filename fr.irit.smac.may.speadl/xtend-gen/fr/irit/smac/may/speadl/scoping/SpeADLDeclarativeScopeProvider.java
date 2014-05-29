package fr.irit.smac.may.speadl.scoping;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import fr.irit.smac.may.speadl.SpeADLUtils;
import fr.irit.smac.may.speadl.speadl.AbstractComponent;
import fr.irit.smac.may.speadl.speadl.Binding;
import fr.irit.smac.may.speadl.speadl.ComponentPart;
import fr.irit.smac.may.speadl.speadl.Ecosystem;
import fr.irit.smac.may.speadl.speadl.Part;
import fr.irit.smac.may.speadl.speadl.Port;
import fr.irit.smac.may.speadl.speadl.PortRef;
import fr.irit.smac.may.speadl.speadl.ProvidedPort;
import fr.irit.smac.may.speadl.speadl.RequiredPort;
import fr.irit.smac.may.speadl.speadl.Species;
import fr.irit.smac.may.speadl.speadl.SpeciesReference;
import org.eclipse.emf.common.util.EList;
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
  protected IScope delegateGetScope(final EObject context, final EReference reference) {
    return null;
  }
  
  public IScope scope_SpeciesReference_part(final Ecosystem i, final EReference ref) {
    EList<Part> _parts = i.getParts();
    return Scopes.scopeFor(_parts);
  }
  
  public IScope scope_SpeciesReference_species(final SpeciesReference i, final EReference ref) {
    ComponentPart _part = i.getPart();
    AbstractComponent _abstractComponent = this._speADLUtils.abstractComponent(_part);
    EList<Species> _species = _abstractComponent.getSpecies();
    return Scopes.scopeFor(_species);
  }
  
  public IScope scope_Binding_from(final Part ctx, final EReference ref) {
    AbstractComponent _abstractComponent = this._speADLUtils.abstractComponent(ctx);
    Iterable<RequiredPort> _allRequires = this._speADLUtils.getAllRequires(_abstractComponent);
    return Scopes.scopeFor(_allRequires);
  }
  
  public IScope scope_PortRef_part(final ProvidedPort ctx, final EReference ref) {
    PortRef _bound = ctx.getBound();
    return this.scope_PortRef_part(_bound, ref);
  }
  
  public IScope scope_PortRef_part(final Binding ctx, final EReference ref) {
    PortRef _to = ctx.getTo();
    return this.scope_PortRef_part(_to, ref);
  }
  
  public IScope scope_PortRef_part(final PortRef ctx, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final AbstractComponent comp = EcoreUtil2.<AbstractComponent>getContainerOfType(ctx, AbstractComponent.class);
      IScope _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (comp instanceof Species) {
          boolean _isEcosystem = ctx.isEcosystem();
          if (_isEcosystem) {
            _matched=true;
            Ecosystem _parentEcosystem = this._speADLUtils.parentEcosystem(((Species)comp));
            EList<Part> _parts = _parentEcosystem.getParts();
            _switchResult = Scopes.scopeFor(_parts);
          }
        }
      }
      if (!_matched) {
        EList<Part> _parts = comp.getParts();
        _switchResult = Scopes.scopeFor(_parts);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public IScope scope_PortRef_port(final ProvidedPort ctx, final EReference ref) {
    PortRef _bound = ctx.getBound();
    return this.scope_PortRef_port(_bound, ref);
  }
  
  public IScope scope_PortRef_port(final Binding ctx, final EReference ref) {
    PortRef _to = ctx.getTo();
    return this.scope_PortRef_port(_to, ref);
  }
  
  public IScope scope_PortRef_port(final PortRef ctx, final EReference ref) {
    IScope _xifexpression = null;
    Part _part = ctx.getPart();
    boolean _notEquals = (!Objects.equal(_part, null));
    if (_notEquals) {
      Part _part_1 = ctx.getPart();
      AbstractComponent _abstractComponent = this._speADLUtils.abstractComponent(_part_1);
      Iterable<ProvidedPort> _allProvides = this._speADLUtils.getAllProvides(_abstractComponent);
      _xifexpression = Scopes.scopeFor(_allProvides);
    } else {
      IScope _xblockexpression = null;
      {
        final AbstractComponent comp = EcoreUtil2.<AbstractComponent>getContainerOfType(ctx, AbstractComponent.class);
        IScope _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (comp instanceof Species) {
            boolean _isEcosystem = ctx.isEcosystem();
            if (_isEcosystem) {
              _matched=true;
              IScope _xblockexpression_1 = null;
              {
                final Ecosystem eco = this._speADLUtils.parentEcosystem(((Species)comp));
                Iterable<ProvidedPort> _allProvides_1 = this._speADLUtils.getAllProvides(eco);
                Iterable<RequiredPort> _allRequires = this._speADLUtils.getAllRequires(eco);
                Iterable<Port> _plus = Iterables.<Port>concat(_allProvides_1, _allRequires);
                _xblockexpression_1 = Scopes.scopeFor(_plus);
              }
              _switchResult = _xblockexpression_1;
            }
          }
        }
        if (!_matched) {
          Iterable<ProvidedPort> _allProvides_1 = this._speADLUtils.getAllProvides(comp);
          Iterable<RequiredPort> _allRequires = this._speADLUtils.getAllRequires(comp);
          Iterable<Port> _plus = Iterables.<Port>concat(_allProvides_1, _allRequires);
          _switchResult = Scopes.scopeFor(_plus);
        }
        _xblockexpression = _switchResult;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
}
