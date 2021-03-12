package fr.irit.smac.may.speadl;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import fr.irit.smac.may.speadl.speadl.AbstractComponent;
import fr.irit.smac.may.speadl.speadl.Binding;
import fr.irit.smac.may.speadl.speadl.ComponentPart;
import fr.irit.smac.may.speadl.speadl.ContentElement;
import fr.irit.smac.may.speadl.speadl.Ecosystem;
import fr.irit.smac.may.speadl.speadl.Feature;
import fr.irit.smac.may.speadl.speadl.Part;
import fr.irit.smac.may.speadl.speadl.Port;
import fr.irit.smac.may.speadl.speadl.PortRef;
import fr.irit.smac.may.speadl.speadl.ProvidedPort;
import fr.irit.smac.may.speadl.speadl.RequiredPort;
import fr.irit.smac.may.speadl.speadl.Species;
import fr.irit.smac.may.speadl.speadl.SpeciesPart;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.ConstraintAwareTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

@SuppressWarnings("all")
public class SpeADLUtils {
  @Inject
  @Extension
  private IJvmModelAssociations _iJvmModelAssociations;
  
  @Inject
  @Extension
  private TypeReferences _typeReferences;
  
  @Inject
  private CommonTypeComputationServices services;
  
  public boolean notAbstract(final AbstractComponent c) {
    return ((IterableExtensions.isEmpty(Iterables.<ComponentPart>filter(c.getParts(), ComponentPart.class)) && IterableExtensions.<ProvidedPort>forall(c.getProvides(), ((Function1<ProvidedPort, Boolean>) (ProvidedPort it) -> {
      PortRef _bound = it.getBound();
      return Boolean.valueOf((_bound != null));
    }))) && IterableExtensions.<Species>forall(c.getSpecies(), ((Function1<Species, Boolean>) (Species it) -> {
      return Boolean.valueOf(this.notAbstract(it));
    })));
  }
  
  public AbstractComponent containingAbstractComponent(final ContentElement p) {
    EObject _eContainer = p.eContainer();
    return ((AbstractComponent) _eContainer);
  }
  
  public Ecosystem parentEcosystem(final Species s) {
    EObject _eContainer = s.eContainer();
    return ((Ecosystem) _eContainer);
  }
  
  public JvmGenericType associatedJvmClass(final AbstractComponent e) {
    final Function1<JvmGenericType, Boolean> _function = (JvmGenericType t) -> {
      String _simpleName = t.getSimpleName();
      String _name = e.getName();
      return Boolean.valueOf(Objects.equal(_simpleName, _name));
    };
    return IterableExtensions.<JvmGenericType>findFirst(Iterables.<JvmGenericType>filter(this._iJvmModelAssociations.getJvmElements(e), JvmGenericType.class), _function);
  }
  
  public Ecosystem associatedEcosystem(final JvmType type) {
    Ecosystem _xblockexpression = null;
    {
      final EObject source = this._iJvmModelAssociations.getPrimarySourceElement(type);
      Ecosystem _xifexpression = null;
      if ((source instanceof Ecosystem)) {
        _xifexpression = ((Ecosystem)source);
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public Species associatedSpecies(final JvmType type) {
    Species _xblockexpression = null;
    {
      final EObject source = this._iJvmModelAssociations.getPrimarySourceElement(type);
      Species _xifexpression = null;
      if ((source instanceof Species)) {
        _xifexpression = ((Species)source);
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public AbstractComponent associatedAbstractComponent(final JvmType type) {
    AbstractComponent _xblockexpression = null;
    {
      final EObject source = this._iJvmModelAssociations.getPrimarySourceElement(type);
      AbstractComponent _xifexpression = null;
      if ((source instanceof AbstractComponent)) {
        _xifexpression = ((AbstractComponent)source);
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected AbstractComponent _abstractComponent(final ComponentPart part) {
    return this.associatedEcosystem(part.getComponentReference().getType());
  }
  
  protected AbstractComponent _abstractComponent(final SpeciesPart part) {
    return part.getSpeciesReference().getSpecies();
  }
  
  protected JvmParameterizedTypeReference _typeReference(final ComponentPart part) {
    return part.getComponentReference();
  }
  
  protected JvmParameterizedTypeReference _typeReference(final SpeciesPart part) {
    return this.getInnerTypeReference(part.getSpeciesReference().getPart().getComponentReference(), part.getSpeciesReference().getSpecies().getName());
  }
  
  public JvmParameterizedTypeReference getInnerTypeReference(final JvmTypeReference r, final String simpleName) {
    JvmParameterizedTypeReference _xblockexpression = null;
    {
      if ((r == null)) {
        return null;
      }
      final JvmGenericType iType = this.getInnerType(r.getType(), simpleName);
      if ((iType == null)) {
        return null;
      }
      JvmParameterizedTypeReference _switchResult = null;
      boolean _matched = false;
      if (r instanceof JvmParameterizedTypeReference) {
        int _size = iType.getTypeParameters().size();
        int _size_1 = ((JvmParameterizedTypeReference)r).getArguments().size();
        boolean _equals = (_size == _size_1);
        if (_equals) {
          _matched=true;
          _switchResult = this._typeReferences.createTypeRef(iType, ((JvmTypeReference[])Conversions.unwrapArray(((JvmParameterizedTypeReference)r).getArguments(), JvmTypeReference.class)));
        }
      }
      if (!_matched) {
        _switchResult = this._typeReferences.createTypeRef(iType);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public JvmGenericType getInnerType(final JvmType in, final String simpleName) {
    JvmGenericType _xblockexpression = null;
    {
      if ((in == null)) {
        return null;
      }
      JvmGenericType _switchResult = null;
      boolean _matched = false;
      if (in instanceof JvmGenericType) {
        _matched=true;
        final Function1<JvmGenericType, Boolean> _function = (JvmGenericType t) -> {
          String _simpleName = t.getSimpleName();
          return Boolean.valueOf(Objects.equal(_simpleName, simpleName));
        };
        _switchResult = IterableExtensions.<JvmGenericType>findFirst(Iterables.<JvmGenericType>filter(((JvmGenericType)in).getMembers(), JvmGenericType.class), _function);
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public JvmParameterizedTypeReference getParameterizedTypeRefWith(final JvmType type, final List<JvmTypeParameter> typeParameters) {
    JvmParameterizedTypeReference _xifexpression = null;
    if ((type == null)) {
      _xifexpression = null;
    } else {
      JvmParameterizedTypeReference _xblockexpression = null;
      {
        final Function1<JvmTypeParameter, JvmParameterizedTypeReference> _function = (JvmTypeParameter it) -> {
          return this._typeReferences.createTypeRef(it);
        };
        final JvmParameterizedTypeReference tr = this._typeReferences.createTypeRef(type, ((JvmTypeReference[])Conversions.unwrapArray(ListExtensions.<JvmTypeParameter, JvmParameterizedTypeReference>map(typeParameters, _function), JvmTypeReference.class)));
        _xblockexpression = tr;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public boolean hasCycleInHierarchy(final Ecosystem ecosystem) {
    return this.hasCycleInHierarchy(ecosystem, CollectionLiterals.<Ecosystem>newHashSet());
  }
  
  private boolean hasCycleInHierarchy(final Ecosystem ecosystem, final Set<Ecosystem> processedSuperTypes) {
    boolean _contains = processedSuperTypes.contains(ecosystem);
    if (_contains) {
      return true;
    }
    processedSuperTypes.add(ecosystem);
    JvmParameterizedTypeReference _specializes = ecosystem.getSpecializes();
    boolean _tripleNotEquals = (_specializes != null);
    if (_tripleNotEquals) {
      final Ecosystem superType = this.associatedEcosystem(ecosystem.getSpecializes().getType());
      if (((superType != null) && this.hasCycleInHierarchy(superType, processedSuperTypes))) {
        return true;
      }
    }
    processedSuperTypes.remove(ecosystem);
    return false;
  }
  
  /**
   * these give the most specialized requires
   * for a component and its hierarchy
   * (WITHOUT substituting parameters)
   */
  public Iterable<RequiredPort> getAllRequires(final AbstractComponent i) {
    final Function1<AbstractComponent, Iterable<RequiredPort>> _function = (AbstractComponent it) -> {
      return it.getRequires();
    };
    return this.<RequiredPort>getAllPorts(i, _function);
  }
  
  /**
   * these give the most specialized provides
   * for a component and its hierarchy
   * (WITHOUT substituting parameters)
   */
  public Iterable<ProvidedPort> getAllProvides(final AbstractComponent i) {
    final Function1<AbstractComponent, Iterable<ProvidedPort>> _function = (AbstractComponent it) -> {
      return it.getProvides();
    };
    return this.<ProvidedPort>getAllPorts(i, _function);
  }
  
  private <P extends Port> Iterable<P> getAllPorts(final AbstractComponent i, final Function1<? super AbstractComponent, ? extends Iterable<P>> getPorts) {
    Iterable<P> _switchResult = null;
    boolean _matched = false;
    if ((i == null)) {
      _matched=true;
      _switchResult = CollectionLiterals.<P>newArrayList();
    }
    if (!_matched) {
      if (i instanceof Ecosystem) {
        boolean _hasCycleInHierarchy = this.hasCycleInHierarchy(((Ecosystem)i));
        boolean _not = (!_hasCycleInHierarchy);
        if (_not) {
          _matched=true;
          ArrayList<P> _newArrayList = CollectionLiterals.<P>newArrayList();
          final Procedure1<ArrayList<P>> _function = (ArrayList<P> it) -> {
            this.<P>gatherPorts(((Ecosystem)i), getPorts, it);
          };
          _switchResult = ObjectExtensions.<ArrayList<P>>operator_doubleArrow(_newArrayList, _function);
        }
      }
    }
    if (!_matched) {
      _switchResult = getPorts.apply(i);
    }
    return _switchResult;
  }
  
  private <P extends Port> void gatherPorts(final Ecosystem i, final Function1<? super Ecosystem, ? extends Iterable<P>> getPorts, final Collection<P> ports) {
    final Function1<P, Boolean> _function = (P ar) -> {
      final Function1<P, Boolean> _function_1 = (P r) -> {
        String _name = r.getName();
        String _name_1 = ar.getName();
        return Boolean.valueOf(Objects.equal(_name, _name_1));
      };
      boolean _exists = IterableExtensions.<P>exists(ports, _function_1);
      return Boolean.valueOf((!_exists));
    };
    Iterable<P> _filter = IterableExtensions.<P>filter(getPorts.apply(i), _function);
    Iterables.<P>addAll(ports, _filter);
    JvmParameterizedTypeReference _specializes = i.getSpecializes();
    boolean _tripleNotEquals = (_specializes != null);
    if (_tripleNotEquals) {
      final Ecosystem eco = this.associatedEcosystem(i.getSpecializes().getType());
      if ((eco != null)) {
        this.<P>gatherPorts(eco, getPorts, ports);
      }
    }
  }
  
  public LightweightTypeReference toLightweightTypeReference(final JvmTypeReference typeRef, final Resource context) {
    return new StandardTypeReferenceOwner(this.services, context).toLightweightTypeReference(typeRef);
  }
  
  public LightweightTypeReference getTypeRef(final Feature f) {
    return this.toLightweightTypeReference(f.getParameterType(), f.eResource());
  }
  
  public LightweightTypeReference getTypeRef(final Port p) {
    return this.toLightweightTypeReference(p.getTypeReference(), p.eResource());
  }
  
  public LightweightTypeReference resolveTypeFrom(final Binding binding) {
    EObject _eContainer = binding.eContainer();
    return this.resolveType(binding.getFrom(), ((Part) _eContainer));
  }
  
  public LightweightTypeReference resolveType(final PortRef ref) {
    LightweightTypeReference _xifexpression = null;
    Part _part = ref.getPart();
    boolean _tripleEquals = (_part == null);
    if (_tripleEquals) {
      LightweightTypeReference _xblockexpression = null;
      {
        final AbstractComponent comp = EcoreUtil2.<AbstractComponent>getContainerOfType(ref, AbstractComponent.class);
        LightweightTypeReference _switchResult = null;
        boolean _matched = false;
        if (comp instanceof Species) {
          boolean _isEcosystem = ref.isEcosystem();
          if (_isEcosystem) {
            _matched=true;
            _switchResult = this.getOverridenPortTypeRef(this.parentEcosystem(((Species)comp)), ref.getPort());
          }
        }
        if (!_matched) {
          if (comp instanceof Species) {
            _matched=true;
            _switchResult = null;
          }
        }
        if (!_matched) {
          _switchResult = this.getOverridenPortTypeRef(comp, ref.getPort());
        }
        final LightweightTypeReference otr = _switchResult;
        LightweightTypeReference _xifexpression_1 = null;
        if ((otr == null)) {
          _xifexpression_1 = this.getTypeRef(ref.getPort());
        } else {
          _xifexpression_1 = otr;
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = this.resolveType(ref.getPort(), ref.getPart());
    }
    return _xifexpression;
  }
  
  public LightweightTypeReference resolveType(final Port port, final Part part) {
    LightweightTypeReference _xblockexpression = null;
    {
      final LightweightTypeReference partTypeRef = this.getParameterizedEcosystemTypeRef(part);
      LightweightTypeReference _switchResult = null;
      AbstractComponent _associatedAbstractComponent = this.associatedAbstractComponent(this.typeReference(part).getType());
      final AbstractComponent c = _associatedAbstractComponent;
      boolean _matched = false;
      if (c instanceof Ecosystem) {
        _matched=true;
        _switchResult = this.getOverridenPortTypeRef(c, port);
      }
      if (!_matched) {
        _switchResult = null;
      }
      final LightweightTypeReference otr = _switchResult;
      LightweightTypeReference _xifexpression = null;
      if ((otr == null)) {
        _xifexpression = this.getTypeRef(port);
      } else {
        _xifexpression = otr;
      }
      final LightweightTypeReference tr = _xifexpression;
      _xblockexpression = this.getSubstitutor(partTypeRef).substitute(tr);
    }
    return _xblockexpression;
  }
  
  public LightweightTypeReference resolveType(final Feature f, final Part p) {
    LightweightTypeReference _xblockexpression = null;
    {
      final LightweightTypeReference ftr = this.getTypeRef(f);
      final LightweightTypeReference ptr = this.getParameterizedEcosystemTypeRef(p);
      _xblockexpression = this.getSubstitutor(ptr).substitute(ftr);
    }
    return _xblockexpression;
  }
  
  private LightweightTypeReference _getParameterizedEcosystemTypeRef(final ComponentPart part) {
    return this.toLightweightTypeReference(part.getComponentReference(), part.eResource());
  }
  
  private LightweightTypeReference _getParameterizedEcosystemTypeRef(final SpeciesPart part) {
    return this.toLightweightTypeReference(part.getSpeciesReference().getPart().getComponentReference(), part.eResource());
  }
  
  public JvmTypeReference rootSupertype(final JvmTypeReference in) {
    JvmTypeReference _xblockexpression = null;
    {
      if ((in == null)) {
        return null;
      }
      JvmTypeReference _switchResult = null;
      AbstractComponent _associatedAbstractComponent = this.associatedAbstractComponent(in.getType());
      final AbstractComponent comp = _associatedAbstractComponent;
      boolean _matched = false;
      if (comp instanceof Ecosystem) {
        _matched=true;
        JvmTypeReference _switchResult_1 = null;
        boolean _matched_1 = false;
        if (in instanceof JvmParameterizedTypeReference) {
          if (((comp != null) && (((Ecosystem)comp).getSpecializes() != null))) {
            _matched_1=true;
            JvmTypeReference _xblockexpression_1 = null;
            {
              final StandardTypeParameterSubstitutor substitutor = this.getSubstitutor(in, ((Ecosystem)comp).eResource());
              _xblockexpression_1 = this.substituteWith(((Ecosystem)comp).getSpecializes(), substitutor);
            }
            _switchResult_1 = _xblockexpression_1;
          }
        }
        if (!_matched_1) {
          _switchResult_1 = in;
        }
        _switchResult = _switchResult_1;
      }
      if (!_matched) {
        _switchResult = in;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public LightweightTypeReference getOverridenPortTypeRef(final Port p) {
    EObject _eContainer = p.eContainer();
    return this.getOverridenPortTypeRef(((AbstractComponent) _eContainer), p);
  }
  
  protected LightweightTypeReference _getOverridenPortTypeRef(final Species c, final Port p) {
    return null;
  }
  
  protected LightweightTypeReference _getOverridenPortTypeRef(final Ecosystem c, final ProvidedPort p) {
    final Function1<Ecosystem, EList<ProvidedPort>> _function = (Ecosystem it) -> {
      return it.getProvides();
    };
    return this.<ProvidedPort>getOverridenPortTypeRef(c, _function, p.getName());
  }
  
  protected LightweightTypeReference _getOverridenPortTypeRef(final Ecosystem c, final RequiredPort p) {
    final Function1<Ecosystem, EList<RequiredPort>> _function = (Ecosystem it) -> {
      return it.getRequires();
    };
    return this.<RequiredPort>getOverridenPortTypeRef(c, _function, p.getName());
  }
  
  private <P extends Port> LightweightTypeReference getOverridenPortTypeRef(final Ecosystem e, final Function1<? super Ecosystem, ? extends Iterable<P>> getPorts, final String name) {
    LightweightTypeReference _xblockexpression = null;
    {
      JvmParameterizedTypeReference _specializes = e.getSpecializes();
      boolean _tripleEquals = (_specializes == null);
      if (_tripleEquals) {
        return null;
      }
      final Ecosystem se = this.associatedEcosystem(e.getSpecializes().getType());
      if ((se == null)) {
        return null;
      }
      final Function1<P, Boolean> _function = (P p) -> {
        String _name = p.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      };
      final P ov = IterableExtensions.<P>findFirst(getPorts.apply(se), _function);
      LightweightTypeReference _xifexpression = null;
      if ((ov == null)) {
        _xifexpression = this.<P>getOverridenPortTypeRef(se, getPorts, name);
      } else {
        _xifexpression = this.toLightweightTypeReference(ov.getTypeReference(), ov.eResource());
      }
      final LightweightTypeReference ov2 = _xifexpression;
      if ((ov2 == null)) {
        return null;
      }
      final StandardTypeParameterSubstitutor substitutor = this.getSubstitutor(e.getSpecializes(), se.eResource());
      _xblockexpression = this.substituteWith(ov2, substitutor);
    }
    return _xblockexpression;
  }
  
  public StandardTypeParameterSubstitutor getSubstitutor(final AbstractComponent parametersHolder, final JvmTypeParameterDeclarator to, final Resource context) {
    StandardTypeParameterSubstitutor _xblockexpression = null;
    {
      JvmGenericType _switchResult = null;
      boolean _matched = false;
      if (parametersHolder instanceof Ecosystem) {
        _matched=true;
        _switchResult = this.associatedJvmClass(parametersHolder);
      }
      if (!_matched) {
        if (parametersHolder instanceof Species) {
          _matched=true;
          JvmDeclaredType _declaringType = this.associatedJvmClass(parametersHolder).getDeclaringType();
          _switchResult = ((JvmGenericType) _declaringType);
        }
      }
      final JvmGenericType realParameterHolder = _switchResult;
      _xblockexpression = this.getSubstitutor(realParameterHolder, to, context);
    }
    return _xblockexpression;
  }
  
  public StandardTypeParameterSubstitutor getSubstitutor(final JvmGenericType parametersHolder, final JvmTypeParameterDeclarator to, final Resource context) {
    StandardTypeParameterSubstitutor _xblockexpression = null;
    {
      final JvmParameterizedTypeReference containerRef = this.getParameterizedTypeRefWith(parametersHolder, to.getTypeParameters());
      _xblockexpression = this.getSubstitutor(containerRef, context);
    }
    return _xblockexpression;
  }
  
  public StandardTypeParameterSubstitutor getSubstitutor(final JvmTypeReference containerRef, final Resource context) {
    return this.getSubstitutor(this.toLightweightTypeReference(containerRef, context));
  }
  
  public StandardTypeParameterSubstitutor getSubstitutor(final LightweightTypeReference containerRef) {
    StandardTypeParameterSubstitutor _xblockexpression = null;
    {
      ITypeReferenceOwner _owner = containerRef.getOwner();
      final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = new ConstraintAwareTypeArgumentCollector(_owner).getTypeParameterMapping(containerRef);
      ITypeReferenceOwner _owner_1 = containerRef.getOwner();
      _xblockexpression = new StandardTypeParameterSubstitutor(mapping, _owner_1);
    }
    return _xblockexpression;
  }
  
  public JvmTypeReference substituteWith(final JvmTypeReference ref, final TypeParameterSubstitutor<?> substitutor) {
    return substitutor.substitute(ref).toJavaCompliantTypeReference();
  }
  
  public LightweightTypeReference substituteWith(final LightweightTypeReference ref, final TypeParameterSubstitutor<?> substitutor) {
    return substitutor.substitute(ref);
  }
  
  public AbstractComponent abstractComponent(final Part part) {
    if (part instanceof ComponentPart) {
      return _abstractComponent((ComponentPart)part);
    } else if (part instanceof SpeciesPart) {
      return _abstractComponent((SpeciesPart)part);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(part).toString());
    }
  }
  
  public JvmParameterizedTypeReference typeReference(final Part part) {
    if (part instanceof ComponentPart) {
      return _typeReference((ComponentPart)part);
    } else if (part instanceof SpeciesPart) {
      return _typeReference((SpeciesPart)part);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(part).toString());
    }
  }
  
  private LightweightTypeReference getParameterizedEcosystemTypeRef(final Part part) {
    if (part instanceof ComponentPart) {
      return _getParameterizedEcosystemTypeRef((ComponentPart)part);
    } else if (part instanceof SpeciesPart) {
      return _getParameterizedEcosystemTypeRef((SpeciesPart)part);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(part).toString());
    }
  }
  
  public LightweightTypeReference getOverridenPortTypeRef(final AbstractComponent c, final Port p) {
    if (c instanceof Ecosystem
         && p instanceof ProvidedPort) {
      return _getOverridenPortTypeRef((Ecosystem)c, (ProvidedPort)p);
    } else if (c instanceof Ecosystem
         && p instanceof RequiredPort) {
      return _getOverridenPortTypeRef((Ecosystem)c, (RequiredPort)p);
    } else if (c instanceof Species
         && p != null) {
      return _getOverridenPortTypeRef((Species)c, p);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(c, p).toString());
    }
  }
}
