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
import fr.irit.smac.may.speadl.speadl.SpeciesReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
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
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
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
    boolean _and = false;
    boolean _and_1 = false;
    EList<Part> _parts = c.getParts();
    boolean _isEmpty = _parts.isEmpty();
    if (!_isEmpty) {
      _and_1 = false;
    } else {
      EList<ProvidedPort> _provides = c.getProvides();
      final Function1<ProvidedPort, Boolean> _function = new Function1<ProvidedPort, Boolean>() {
        public Boolean apply(final ProvidedPort it) {
          PortRef _bound = it.getBound();
          return Boolean.valueOf((_bound != null));
        }
      };
      boolean _forall = IterableExtensions.<ProvidedPort>forall(_provides, _function);
      _and_1 = _forall;
    }
    if (!_and_1) {
      _and = false;
    } else {
      EList<Species> _species = c.getSpecies();
      final Function1<Species, Boolean> _function_1 = new Function1<Species, Boolean>() {
        public Boolean apply(final Species it) {
          return Boolean.valueOf(SpeADLUtils.this.notAbstract(it));
        }
      };
      boolean _forall_1 = IterableExtensions.<Species>forall(_species, _function_1);
      _and = _forall_1;
    }
    return _and;
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
    Set<EObject> _jvmElements = this._iJvmModelAssociations.getJvmElements(e);
    Iterable<JvmGenericType> _filter = Iterables.<JvmGenericType>filter(_jvmElements, JvmGenericType.class);
    final Function1<JvmGenericType, Boolean> _function = new Function1<JvmGenericType, Boolean>() {
      public Boolean apply(final JvmGenericType t) {
        String _simpleName = t.getSimpleName();
        String _name = e.getName();
        return Boolean.valueOf(Objects.equal(_simpleName, _name));
      }
    };
    return IterableExtensions.<JvmGenericType>findFirst(_filter, _function);
  }
  
  public Ecosystem associatedEcosystem(final JvmType type) {
    EObject _primarySourceElement = this._iJvmModelAssociations.getPrimarySourceElement(type);
    return ((Ecosystem) _primarySourceElement);
  }
  
  public Species associatedSpecies(final JvmType type) {
    EObject _primarySourceElement = this._iJvmModelAssociations.getPrimarySourceElement(type);
    return ((Species) _primarySourceElement);
  }
  
  public AbstractComponent associatedAbstractComponent(final JvmType type) {
    EObject _primarySourceElement = this._iJvmModelAssociations.getPrimarySourceElement(type);
    return ((AbstractComponent) _primarySourceElement);
  }
  
  protected AbstractComponent _abstractComponent(final ComponentPart part) {
    JvmParameterizedTypeReference _componentReference = part.getComponentReference();
    JvmType _type = _componentReference.getType();
    return this.associatedEcosystem(_type);
  }
  
  protected AbstractComponent _abstractComponent(final SpeciesPart part) {
    SpeciesReference _speciesReference = part.getSpeciesReference();
    return _speciesReference.getSpecies();
  }
  
  protected JvmParameterizedTypeReference _typeReference(final ComponentPart part) {
    return part.getComponentReference();
  }
  
  protected JvmParameterizedTypeReference _typeReference(final SpeciesPart part) {
    SpeciesReference _speciesReference = part.getSpeciesReference();
    ComponentPart _part = _speciesReference.getPart();
    JvmParameterizedTypeReference _componentReference = _part.getComponentReference();
    SpeciesReference _speciesReference_1 = part.getSpeciesReference();
    Species _species = _speciesReference_1.getSpecies();
    String _name = _species.getName();
    return this.getInnerTypeReference(_componentReference, _name);
  }
  
  public JvmParameterizedTypeReference getInnerTypeReference(final JvmTypeReference r, final String simpleName) {
    JvmParameterizedTypeReference _xblockexpression = null;
    {
      boolean _tripleEquals = (r == null);
      if (_tripleEquals) {
        return null;
      }
      JvmType _type = r.getType();
      final JvmGenericType iType = this.getInnerType(_type, simpleName);
      boolean _tripleEquals_1 = (iType == null);
      if (_tripleEquals_1) {
        return null;
      }
      JvmParameterizedTypeReference _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (r instanceof JvmParameterizedTypeReference) {
          EList<JvmTypeParameter> _typeParameters = iType.getTypeParameters();
          int _size = _typeParameters.size();
          EList<JvmTypeReference> _arguments = ((JvmParameterizedTypeReference)r).getArguments();
          int _size_1 = _arguments.size();
          boolean _equals = (_size == _size_1);
          if (_equals) {
            _matched=true;
            EList<JvmTypeReference> _arguments_1 = ((JvmParameterizedTypeReference)r).getArguments();
            _switchResult = this._typeReferences.createTypeRef(iType, ((JvmTypeReference[])Conversions.unwrapArray(_arguments_1, JvmTypeReference.class)));
          }
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
      boolean _tripleEquals = (in == null);
      if (_tripleEquals) {
        return null;
      }
      JvmGenericType _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (in instanceof JvmGenericType) {
          _matched=true;
          EList<JvmMember> _members = ((JvmGenericType)in).getMembers();
          Iterable<JvmGenericType> _filter = Iterables.<JvmGenericType>filter(_members, JvmGenericType.class);
          final Function1<JvmGenericType, Boolean> _function = new Function1<JvmGenericType, Boolean>() {
            public Boolean apply(final JvmGenericType t) {
              String _simpleName = t.getSimpleName();
              return Boolean.valueOf(Objects.equal(_simpleName, simpleName));
            }
          };
          _switchResult = IterableExtensions.<JvmGenericType>findFirst(_filter, _function);
        }
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public JvmParameterizedTypeReference getParameterizedTypeRefWith(final JvmType type, final List<JvmTypeParameter> typeParameters) {
    JvmParameterizedTypeReference _xifexpression = null;
    boolean _tripleEquals = (type == null);
    if (_tripleEquals) {
      _xifexpression = null;
    } else {
      JvmParameterizedTypeReference _xblockexpression = null;
      {
        final Function1<JvmTypeParameter, JvmParameterizedTypeReference> _function = new Function1<JvmTypeParameter, JvmParameterizedTypeReference>() {
          public JvmParameterizedTypeReference apply(final JvmTypeParameter it) {
            return SpeADLUtils.this._typeReferences.createTypeRef(it);
          }
        };
        List<JvmParameterizedTypeReference> _map = ListExtensions.<JvmTypeParameter, JvmParameterizedTypeReference>map(typeParameters, _function);
        final JvmParameterizedTypeReference tr = this._typeReferences.createTypeRef(type, ((JvmTypeReference[])Conversions.unwrapArray(_map, JvmTypeReference.class)));
        _xblockexpression = tr;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public boolean hasCycleInHierarchy(final Ecosystem ecosystem) {
    HashSet<Ecosystem> _newHashSet = CollectionLiterals.<Ecosystem>newHashSet();
    return this.hasCycleInHierarchy(ecosystem, _newHashSet);
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
      JvmParameterizedTypeReference _specializes_1 = ecosystem.getSpecializes();
      JvmType _type = _specializes_1.getType();
      final Ecosystem superType = this.associatedEcosystem(_type);
      boolean _and = false;
      boolean _tripleNotEquals_1 = (superType != null);
      if (!_tripleNotEquals_1) {
        _and = false;
      } else {
        boolean _hasCycleInHierarchy = this.hasCycleInHierarchy(superType, processedSuperTypes);
        _and = _hasCycleInHierarchy;
      }
      if (_and) {
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
    final Function1<AbstractComponent, EList<RequiredPort>> _function = new Function1<AbstractComponent, EList<RequiredPort>>() {
      public EList<RequiredPort> apply(final AbstractComponent it) {
        return it.getRequires();
      }
    };
    return this.<RequiredPort>getAllPorts(i, _function);
  }
  
  /**
   * these give the most specialized provides
   * for a component and its hierarchy
   * (WITHOUT substituting parameters)
   */
  public Iterable<ProvidedPort> getAllProvides(final AbstractComponent i) {
    final Function1<AbstractComponent, EList<ProvidedPort>> _function = new Function1<AbstractComponent, EList<ProvidedPort>>() {
      public EList<ProvidedPort> apply(final AbstractComponent it) {
        return it.getProvides();
      }
    };
    return this.<ProvidedPort>getAllPorts(i, _function);
  }
  
  private <P extends Port> Iterable<P> getAllPorts(final AbstractComponent i, final Function1<? super AbstractComponent, ? extends Iterable<P>> getPorts) {
    Iterable<P> _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      boolean _tripleEquals = (i == null);
      if (_tripleEquals) {
        _matched=true;
        _switchResult = CollectionLiterals.<P>newArrayList();
      }
    }
    if (!_matched) {
      if (i instanceof Ecosystem) {
        boolean _hasCycleInHierarchy = this.hasCycleInHierarchy(((Ecosystem)i));
        boolean _not = (!_hasCycleInHierarchy);
        if (_not) {
          _matched=true;
          ArrayList<P> _newArrayList = CollectionLiterals.<P>newArrayList();
          final Procedure1<ArrayList<P>> _function = new Procedure1<ArrayList<P>>() {
            public void apply(final ArrayList<P> it) {
              SpeADLUtils.this.<P>gatherPorts(((Ecosystem)i), getPorts, it);
            }
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
    Iterable<P> _apply = getPorts.apply(i);
    final Function1<P, Boolean> _function = new Function1<P, Boolean>() {
      public Boolean apply(final P ar) {
        final Function1<P, Boolean> _function = new Function1<P, Boolean>() {
          public Boolean apply(final P r) {
            String _name = r.getName();
            String _name_1 = ar.getName();
            return Boolean.valueOf(Objects.equal(_name, _name_1));
          }
        };
        boolean _exists = IterableExtensions.<P>exists(ports, _function);
        return Boolean.valueOf((!_exists));
      }
    };
    Iterable<P> _filter = IterableExtensions.<P>filter(_apply, _function);
    Iterables.<P>addAll(ports, _filter);
    JvmParameterizedTypeReference _specializes = i.getSpecializes();
    boolean _tripleNotEquals = (_specializes != null);
    if (_tripleNotEquals) {
      JvmParameterizedTypeReference _specializes_1 = i.getSpecializes();
      JvmType _type = _specializes_1.getType();
      final Ecosystem eco = this.associatedEcosystem(_type);
      boolean _tripleNotEquals_1 = (eco != null);
      if (_tripleNotEquals_1) {
        this.<P>gatherPorts(eco, getPorts, ports);
      }
    }
  }
  
  public LightweightTypeReference toLightweightTypeReference(final JvmTypeReference typeRef, final Resource context) {
    LightweightTypeReference _xblockexpression = null;
    {
      StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.services, context);
      final OwnedConverter converter = new OwnedConverter(_standardTypeReferenceOwner, false);
      _xblockexpression = converter.toLightweightReference(typeRef);
    }
    return _xblockexpression;
  }
  
  public LightweightTypeReference getTypeRef(final Feature f) {
    JvmTypeReference _parameterType = f.getParameterType();
    Resource _eResource = f.eResource();
    return this.toLightweightTypeReference(_parameterType, _eResource);
  }
  
  public LightweightTypeReference getTypeRef(final Port p) {
    JvmParameterizedTypeReference _typeReference = p.getTypeReference();
    Resource _eResource = p.eResource();
    return this.toLightweightTypeReference(_typeReference, _eResource);
  }
  
  public LightweightTypeReference resolveTypeFrom(final Binding binding) {
    RequiredPort _from = binding.getFrom();
    EObject _eContainer = binding.eContainer();
    return this.resolveType(_from, ((Part) _eContainer));
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
        if (!_matched) {
          if (comp instanceof Species) {
            boolean _isEcosystem = ref.isEcosystem();
            if (_isEcosystem) {
              _matched=true;
              Ecosystem _parentEcosystem = this.parentEcosystem(((Species)comp));
              Port _port = ref.getPort();
              _switchResult = this.getOverridenPortTypeRef(_parentEcosystem, _port);
            }
          }
        }
        if (!_matched) {
          if (comp instanceof Species) {
            _matched=true;
            _switchResult = null;
          }
        }
        if (!_matched) {
          Port _port = ref.getPort();
          _switchResult = this.getOverridenPortTypeRef(comp, _port);
        }
        final LightweightTypeReference otr = _switchResult;
        LightweightTypeReference _xifexpression_1 = null;
        boolean _tripleEquals_1 = (otr == null);
        if (_tripleEquals_1) {
          Port _port_1 = ref.getPort();
          _xifexpression_1 = this.getTypeRef(_port_1);
        } else {
          _xifexpression_1 = otr;
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    } else {
      Port _port = ref.getPort();
      Part _part_1 = ref.getPart();
      _xifexpression = this.resolveType(_port, _part_1);
    }
    return _xifexpression;
  }
  
  public LightweightTypeReference resolveType(final Port port, final Part part) {
    LightweightTypeReference _xblockexpression = null;
    {
      final LightweightTypeReference partTypeRef = this.getParameterizedEcosystemTypeRef(part);
      LightweightTypeReference _switchResult = null;
      JvmParameterizedTypeReference _typeReference = this.typeReference(part);
      JvmType _type = _typeReference.getType();
      AbstractComponent _associatedAbstractComponent = this.associatedAbstractComponent(_type);
      final AbstractComponent c = _associatedAbstractComponent;
      boolean _matched = false;
      if (!_matched) {
        if (c instanceof Ecosystem) {
          _matched=true;
          _switchResult = this.getOverridenPortTypeRef(c, port);
        }
      }
      if (!_matched) {
        _switchResult = null;
      }
      final LightweightTypeReference otr = _switchResult;
      LightweightTypeReference _xifexpression = null;
      boolean _tripleEquals = (otr == null);
      if (_tripleEquals) {
        _xifexpression = this.getTypeRef(port);
      } else {
        _xifexpression = otr;
      }
      final LightweightTypeReference tr = _xifexpression;
      StandardTypeParameterSubstitutor _substitutor = this.getSubstitutor(partTypeRef);
      _xblockexpression = _substitutor.substitute(tr);
    }
    return _xblockexpression;
  }
  
  public LightweightTypeReference resolveType(final Feature f, final Part p) {
    LightweightTypeReference _xblockexpression = null;
    {
      final LightweightTypeReference ftr = this.getTypeRef(f);
      final LightweightTypeReference ptr = this.getParameterizedEcosystemTypeRef(p);
      StandardTypeParameterSubstitutor _substitutor = this.getSubstitutor(ptr);
      _xblockexpression = _substitutor.substitute(ftr);
    }
    return _xblockexpression;
  }
  
  private LightweightTypeReference _getParameterizedEcosystemTypeRef(final ComponentPart part) {
    JvmParameterizedTypeReference _componentReference = part.getComponentReference();
    Resource _eResource = part.eResource();
    return this.toLightweightTypeReference(_componentReference, _eResource);
  }
  
  private LightweightTypeReference _getParameterizedEcosystemTypeRef(final SpeciesPart part) {
    SpeciesReference _speciesReference = part.getSpeciesReference();
    ComponentPart _part = _speciesReference.getPart();
    JvmParameterizedTypeReference _componentReference = _part.getComponentReference();
    Resource _eResource = part.eResource();
    return this.toLightweightTypeReference(_componentReference, _eResource);
  }
  
  public JvmTypeReference rootSupertype(final JvmTypeReference in) {
    JvmTypeReference _xblockexpression = null;
    {
      boolean _tripleEquals = (in == null);
      if (_tripleEquals) {
        return null;
      }
      JvmTypeReference _switchResult = null;
      JvmType _type = in.getType();
      AbstractComponent _associatedAbstractComponent = this.associatedAbstractComponent(_type);
      final AbstractComponent comp = _associatedAbstractComponent;
      boolean _matched = false;
      if (!_matched) {
        if (comp instanceof Ecosystem) {
          _matched=true;
          JvmTypeReference _switchResult_1 = null;
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (in instanceof JvmParameterizedTypeReference) {
              boolean _and = false;
              boolean _tripleNotEquals = (comp != null);
              if (!_tripleNotEquals) {
                _and = false;
              } else {
                JvmParameterizedTypeReference _specializes = ((Ecosystem)comp).getSpecializes();
                boolean _tripleNotEquals_1 = (_specializes != null);
                _and = _tripleNotEquals_1;
              }
              if (_and) {
                _matched_1=true;
                JvmTypeReference _xblockexpression_1 = null;
                {
                  Resource _eResource = ((Ecosystem)comp).eResource();
                  final StandardTypeParameterSubstitutor substitutor = this.getSubstitutor(in, _eResource);
                  JvmParameterizedTypeReference _specializes_1 = ((Ecosystem)comp).getSpecializes();
                  _xblockexpression_1 = this.substituteWith(_specializes_1, substitutor);
                }
                _switchResult_1 = _xblockexpression_1;
              }
            }
          }
          if (!_matched_1) {
            _switchResult_1 = in;
          }
          _switchResult = _switchResult_1;
        }
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
    final Function1<Ecosystem, EList<ProvidedPort>> _function = new Function1<Ecosystem, EList<ProvidedPort>>() {
      public EList<ProvidedPort> apply(final Ecosystem it) {
        return it.getProvides();
      }
    };
    String _name = p.getName();
    return this.<ProvidedPort>getOverridenPortTypeRef(c, _function, _name);
  }
  
  protected LightweightTypeReference _getOverridenPortTypeRef(final Ecosystem c, final RequiredPort p) {
    final Function1<Ecosystem, EList<RequiredPort>> _function = new Function1<Ecosystem, EList<RequiredPort>>() {
      public EList<RequiredPort> apply(final Ecosystem it) {
        return it.getRequires();
      }
    };
    String _name = p.getName();
    return this.<RequiredPort>getOverridenPortTypeRef(c, _function, _name);
  }
  
  private <P extends Port> LightweightTypeReference getOverridenPortTypeRef(final Ecosystem e, final Function1<? super Ecosystem, ? extends Iterable<P>> getPorts, final String name) {
    LightweightTypeReference _xblockexpression = null;
    {
      JvmParameterizedTypeReference _specializes = e.getSpecializes();
      boolean _tripleEquals = (_specializes == null);
      if (_tripleEquals) {
        return null;
      }
      JvmParameterizedTypeReference _specializes_1 = e.getSpecializes();
      JvmType _type = _specializes_1.getType();
      final Ecosystem se = this.associatedEcosystem(_type);
      boolean _tripleEquals_1 = (se == null);
      if (_tripleEquals_1) {
        return null;
      }
      Iterable<P> _apply = getPorts.apply(se);
      final Function1<P, Boolean> _function = new Function1<P, Boolean>() {
        public Boolean apply(final P p) {
          String _name = p.getName();
          return Boolean.valueOf(Objects.equal(_name, name));
        }
      };
      final P ov = IterableExtensions.<P>findFirst(_apply, _function);
      LightweightTypeReference _xifexpression = null;
      boolean _tripleEquals_2 = (ov == null);
      if (_tripleEquals_2) {
        _xifexpression = this.<P>getOverridenPortTypeRef(se, getPorts, name);
      } else {
        JvmParameterizedTypeReference _typeReference = ov.getTypeReference();
        Resource _eResource = ov.eResource();
        _xifexpression = this.toLightweightTypeReference(_typeReference, _eResource);
      }
      final LightweightTypeReference ov2 = _xifexpression;
      boolean _tripleEquals_3 = (ov2 == null);
      if (_tripleEquals_3) {
        return null;
      }
      JvmParameterizedTypeReference _specializes_2 = e.getSpecializes();
      Resource _eResource_1 = se.eResource();
      final StandardTypeParameterSubstitutor substitutor = this.getSubstitutor(_specializes_2, _eResource_1);
      _xblockexpression = this.substituteWith(ov2, substitutor);
    }
    return _xblockexpression;
  }
  
  public StandardTypeParameterSubstitutor getSubstitutor(final AbstractComponent parametersHolder, final JvmTypeParameterDeclarator to, final Resource context) {
    StandardTypeParameterSubstitutor _xblockexpression = null;
    {
      JvmGenericType _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (parametersHolder instanceof Ecosystem) {
          _matched=true;
          _switchResult = this.associatedJvmClass(parametersHolder);
        }
      }
      if (!_matched) {
        if (parametersHolder instanceof Species) {
          _matched=true;
          JvmGenericType _associatedJvmClass = this.associatedJvmClass(parametersHolder);
          JvmDeclaredType _declaringType = _associatedJvmClass.getDeclaringType();
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
      EList<JvmTypeParameter> _typeParameters = to.getTypeParameters();
      final JvmParameterizedTypeReference containerRef = this.getParameterizedTypeRefWith(parametersHolder, _typeParameters);
      _xblockexpression = this.getSubstitutor(containerRef, context);
    }
    return _xblockexpression;
  }
  
  public StandardTypeParameterSubstitutor getSubstitutor(final JvmTypeReference containerRef, final Resource context) {
    LightweightTypeReference _lightweightTypeReference = this.toLightweightTypeReference(containerRef, context);
    return this.getSubstitutor(_lightweightTypeReference);
  }
  
  public StandardTypeParameterSubstitutor getSubstitutor(final LightweightTypeReference containerRef) {
    StandardTypeParameterSubstitutor _xblockexpression = null;
    {
      ITypeReferenceOwner _owner = containerRef.getOwner();
      ConstraintAwareTypeArgumentCollector _constraintAwareTypeArgumentCollector = new ConstraintAwareTypeArgumentCollector(_owner);
      final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = _constraintAwareTypeArgumentCollector.getTypeParameterMapping(containerRef);
      ITypeReferenceOwner _owner_1 = containerRef.getOwner();
      _xblockexpression = new StandardTypeParameterSubstitutor(mapping, _owner_1);
    }
    return _xblockexpression;
  }
  
  public JvmTypeReference substituteWith(final JvmTypeReference ref, final TypeParameterSubstitutor<?> substitutor) {
    LightweightTypeReference _substitute = substitutor.substitute(ref);
    return _substitute.toJavaCompliantTypeReference();
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
