package fr.irit.smac.may.speadl;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import fr.irit.smac.may.speadl.speadl.AbstractComponent;
import fr.irit.smac.may.speadl.speadl.Binding;
import fr.irit.smac.may.speadl.speadl.ComponentPart;
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
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
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
  
  public Ecosystem parentEcosystem(final Species s) {
    EObject _eContainer = s.eContainer();
    return ((Ecosystem) _eContainer);
  }
  
  public JvmGenericType associatedJvmClass(final Ecosystem e) {
    Set<EObject> _jvmElements = this._iJvmModelAssociations.getJvmElements(e);
    EObject _head = IterableExtensions.<EObject>head(_jvmElements);
    return ((JvmGenericType) _head);
  }
  
  public Ecosystem associatedEcosystem(final JvmType type) {
    EObject _primarySourceElement = this._iJvmModelAssociations.getPrimarySourceElement(type);
    return ((Ecosystem) _primarySourceElement);
  }
  
  public JvmOperation associatedJvmOperation(final Port p) {
    Set<EObject> _jvmElements = this._iJvmModelAssociations.getJvmElements(p);
    EObject _head = IterableExtensions.<EObject>head(_jvmElements);
    return ((JvmOperation) _head);
  }
  
  public ProvidedPort associatedProvidedPort(final JvmOperation o) {
    EObject _primarySourceElement = this._iJvmModelAssociations.getPrimarySourceElement(o);
    return ((ProvidedPort) _primarySourceElement);
  }
  
  public RequiredPort associatedRequiredPort(final JvmOperation o) {
    EObject _primarySourceElement = this._iJvmModelAssociations.getPrimarySourceElement(o);
    return ((RequiredPort) _primarySourceElement);
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
      boolean _equals = Objects.equal(r, null);
      if (_equals) {
        return null;
      }
      JvmType _type = r.getType();
      final JvmGenericType iType = this.getInnerType(_type, simpleName);
      boolean _equals_1 = Objects.equal(iType, null);
      if (_equals_1) {
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
          boolean _equals_2 = (_size == _size_1);
          if (_equals_2) {
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
      boolean _equals = Objects.equal(in, null);
      if (_equals) {
        return null;
      }
      JvmGenericType _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (in instanceof JvmDeclaredType) {
          _matched=true;
          EList<JvmMember> _members = ((JvmDeclaredType)in).getMembers();
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
    boolean _equals = Objects.equal(type, null);
    if (_equals) {
      _xifexpression = null;
    } else {
      final Function1<JvmTypeParameter, JvmParameterizedTypeReference> _function = new Function1<JvmTypeParameter, JvmParameterizedTypeReference>() {
        public JvmParameterizedTypeReference apply(final JvmTypeParameter it) {
          return SpeADLUtils.this._typeReferences.createTypeRef(it);
        }
      };
      List<JvmParameterizedTypeReference> _map = ListExtensions.<JvmTypeParameter, JvmParameterizedTypeReference>map(typeParameters, _function);
      _xifexpression = this._typeReferences.createTypeRef(type, ((JvmTypeReference[])Conversions.unwrapArray(_map, JvmTypeReference.class)));
    }
    return _xifexpression;
  }
  
  public JvmParameterizedTypeReference getTypeRef(final JvmType type) {
    JvmParameterizedTypeReference _xifexpression = null;
    boolean _equals = Objects.equal(type, null);
    if (_equals) {
      _xifexpression = null;
    } else {
      _xifexpression = this._typeReferences.createTypeRef(type);
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
    boolean _isUseless = this.isUseless(_specializes);
    boolean _not = (!_isUseless);
    if (_not) {
      JvmParameterizedTypeReference _specializes_1 = ecosystem.getSpecializes();
      JvmType _type = _specializes_1.getType();
      final Ecosystem superType = this.associatedEcosystem(_type);
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(superType, null));
      if (!_notEquals) {
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
   * these give the requires the most specialized
   * for a component and its hierarchy
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
   * these give the provides the most specialized
   * for a component and its hierarchy
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
      if (i instanceof Ecosystem) {
        boolean _hasCycleInHierarchy = this.hasCycleInHierarchy(((Ecosystem)i));
        boolean _not = (!_hasCycleInHierarchy);
        if (_not) {
          _matched=true;
          ArrayList<P> _xblockexpression = null;
          {
            final ArrayList<P> res = CollectionLiterals.<P>newArrayList();
            this.<P>gatherPorts(((Ecosystem)i), getPorts, res);
            _xblockexpression = res;
          }
          _switchResult = _xblockexpression;
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
    boolean _isUseless = this.isUseless(_specializes);
    boolean _not = (!_isUseless);
    if (_not) {
      JvmParameterizedTypeReference _specializes_1 = i.getSpecializes();
      JvmType _type = _specializes_1.getType();
      final Ecosystem eco = this.associatedEcosystem(_type);
      boolean _notEquals = (!Objects.equal(eco, null));
      if (_notEquals) {
        this.<P>gatherPorts(eco, getPorts, ports);
      }
    }
  }
  
  public boolean isUseless(final JvmTypeReference typeReference) {
    boolean _or = false;
    boolean _or_1 = false;
    boolean _equals = Objects.equal(typeReference, null);
    if (_equals) {
      _or_1 = true;
    } else {
      JvmType _type = typeReference.getType();
      boolean _equals_1 = Objects.equal(_type, null);
      _or_1 = _equals_1;
    }
    if (_or_1) {
      _or = true;
    } else {
      JvmType _type_1 = typeReference.getType();
      _or = (_type_1 instanceof JvmVoid);
    }
    return _or;
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
    boolean _equals = Objects.equal(_part, null);
    if (_equals) {
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
        boolean _equals_1 = Objects.equal(otr, null);
        if (_equals_1) {
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
      JvmParameterizedTypeReference _typeReference = this.typeReference(part);
      JvmType _type = _typeReference.getType();
      Ecosystem _associatedEcosystem = this.associatedEcosystem(_type);
      LightweightTypeReference _overridenPortTypeRef = null;
      if (_associatedEcosystem!=null) {
        _overridenPortTypeRef=this.getOverridenPortTypeRef(_associatedEcosystem, port);
      }
      final LightweightTypeReference otr = _overridenPortTypeRef;
      LightweightTypeReference _xifexpression = null;
      boolean _equals = Objects.equal(otr, null);
      if (_equals) {
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
      boolean _isUseless = this.isUseless(in);
      if (_isUseless) {
        return null;
      }
      JvmType _type = in.getType();
      final Ecosystem comp = this.associatedEcosystem(_type);
      JvmTypeReference _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (in instanceof JvmParameterizedTypeReference) {
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(comp, null));
          if (!_notEquals) {
            _and = false;
          } else {
            JvmParameterizedTypeReference _specializes = comp.getSpecializes();
            boolean _isUseless_1 = this.isUseless(_specializes);
            boolean _not = (!_isUseless_1);
            _and = _not;
          }
          if (_and) {
            _matched=true;
            JvmTypeReference _xblockexpression_1 = null;
            {
              Resource _eResource = comp.eResource();
              final StandardTypeParameterSubstitutor substitutor = this.getSubstitutor(in, _eResource);
              JvmParameterizedTypeReference _specializes_1 = comp.getSpecializes();
              _xblockexpression_1 = this.substituteWith(_specializes_1, substitutor);
            }
            _switchResult = _xblockexpression_1;
          }
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
      boolean _isUseless = this.isUseless(_specializes);
      if (_isUseless) {
        return null;
      }
      JvmParameterizedTypeReference _specializes_1 = e.getSpecializes();
      JvmType _type = _specializes_1.getType();
      final Ecosystem se = this.associatedEcosystem(_type);
      boolean _equals = Objects.equal(se, null);
      if (_equals) {
        return null;
      }
      JvmParameterizedTypeReference _specializes_2 = e.getSpecializes();
      Resource _eResource = se.eResource();
      final StandardTypeParameterSubstitutor substitutor = this.getSubstitutor(_specializes_2, _eResource);
      Iterable<P> _apply = getPorts.apply(se);
      final Function1<P, Boolean> _function = new Function1<P, Boolean>() {
        public Boolean apply(final P p) {
          String _name = p.getName();
          return Boolean.valueOf(Objects.equal(_name, name));
        }
      };
      final P ov = IterableExtensions.<P>findFirst(_apply, _function);
      LightweightTypeReference _xifexpression = null;
      boolean _equals_1 = Objects.equal(ov, null);
      if (_equals_1) {
        _xifexpression = this.<P>getOverridenPortTypeRef(se, getPorts, name);
      } else {
        _xifexpression = this.substituteWith(
          this.toLightweightTypeReference(ov.getTypeReference(), ov.eResource()), substitutor);
      }
      _xblockexpression = _xifexpression;
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
