package fr.irit.smac.may.speadl;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.compiler.IElementIssueProvider;
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
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.ConstraintAwareTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

@SuppressWarnings("all")
public class SpeADLUtils {
  @Inject
  @Extension
  private IJvmModelAssociations _iJvmModelAssociations;
  
  @Inject
  @Extension
  private TypeReferences _typeReferences;
  
  @Inject
  private IElementIssueProvider.Factory issueProviderFactory;
  
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
  
  protected JvmParameterizedTypeReference _ecosystemTypeReference(final ComponentPart part) {
    return part.getComponentReference();
  }
  
  protected JvmParameterizedTypeReference _ecosystemTypeReference(final SpeciesPart part) {
    SpeciesReference _speciesReference = part.getSpeciesReference();
    ComponentPart _part = _speciesReference.getPart();
    return _part.getComponentReference();
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
          _matched=true;
          EList<JvmTypeReference> _arguments = ((JvmParameterizedTypeReference)r).getArguments();
          _switchResult = this._typeReferences.createTypeRef(iType, ((JvmTypeReference[])Conversions.unwrapArray(_arguments, JvmTypeReference.class)));
        }
      }
      if (!_matched) {
        _switchResult = this._typeReferences.createTypeRef(iType);
      }
      _xblockexpression = (_switchResult);
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
          final Function1<JvmGenericType,Boolean> _function = new Function1<JvmGenericType,Boolean>() {
            public Boolean apply(final JvmGenericType t) {
              String _simpleName = t.getSimpleName();
              return Boolean.valueOf(Objects.equal(_simpleName, simpleName));
            }
          };
          _switchResult = IterableExtensions.<JvmGenericType>findFirst(_filter, _function);
        }
      }
      _xblockexpression = (_switchResult);
    }
    return _xblockexpression;
  }
  
  public JvmTypeReference substituteTypeParameters(final JvmTypeReference in, final List<JvmTypeParameter> from, final List<JvmTypeParameter> to, final Resource context) {
    JvmTypeReference _xblockexpression = null;
    {
      boolean _equals = Objects.equal(in, null);
      if (_equals) {
        return null;
      }
      JvmTypeReference _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (in instanceof JvmParameterizedTypeReference) {
          _matched=true;
          JvmTypeReference _xblockexpression_1 = null;
          {
            final LightweightTypeReference str = this.toLightweightTypeReference(in, context);
            if ((!(str instanceof ParameterizedTypeReference))) {
              return in;
            }
            LightweightTypeReference _substituteTypeParameters = this.substituteTypeParameters(str, from, to);
            _xblockexpression_1 = (_substituteTypeParameters.toJavaCompliantTypeReference());
          }
          _switchResult = _xblockexpression_1;
        }
      }
      if (!_matched) {
        _switchResult = in;
      }
      _xblockexpression = (_switchResult);
    }
    return _xblockexpression;
  }
  
  public LightweightTypeReference substituteTypeParameters(final LightweightTypeReference in, final List<JvmTypeParameter> from, final List<JvmTypeParameter> to) {
    LightweightTypeReference _xblockexpression = null;
    {
      ITypeReferenceOwner _owner = in.getOwner();
      final OwnedConverter converter = new OwnedConverter(_owner, false);
      final Function1<JvmTypeParameter,LightweightMergedBoundTypeArgument> _function = new Function1<JvmTypeParameter,LightweightMergedBoundTypeArgument>() {
        public LightweightMergedBoundTypeArgument apply(final JvmTypeParameter k) {
          LightweightMergedBoundTypeArgument _xblockexpression = null;
          {
            int _indexOf = from.indexOf(k);
            JvmTypeParameter _get = to.get(_indexOf);
            JvmParameterizedTypeReference _createTypeRef = SpeADLUtils.this._typeReferences.createTypeRef(_get);
            final LightweightTypeReference r = converter.toLightweightReference(_createTypeRef);
            _xblockexpression = (new LightweightMergedBoundTypeArgument(r, VarianceInfo.INVARIANT));
          }
          return _xblockexpression;
        }
      };
      final Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> mapping = IterableExtensions.<JvmTypeParameter, LightweightMergedBoundTypeArgument>toInvertedMap(from, _function);
      ITypeReferenceOwner _owner_1 = in.getOwner();
      StandardTypeParameterSubstitutor _standardTypeParameterSubstitutor = new StandardTypeParameterSubstitutor(mapping, _owner_1);
      final LightweightTypeReference res = _standardTypeParameterSubstitutor.substitute(in);
      _xblockexpression = (res);
    }
    return _xblockexpression;
  }
  
  public JvmParameterizedTypeReference getParameterizedTypeRefWith(final JvmType type, final List<JvmTypeParameter> typeParameters) {
    JvmParameterizedTypeReference _xblockexpression = null;
    {
      boolean _equals = Objects.equal(type, null);
      if (_equals) {
        return null;
      }
      final Function1<JvmTypeParameter,JvmParameterizedTypeReference> _function = new Function1<JvmTypeParameter,JvmParameterizedTypeReference>() {
        public JvmParameterizedTypeReference apply(final JvmTypeParameter it) {
          return SpeADLUtils.this._typeReferences.createTypeRef(it);
        }
      };
      List<JvmParameterizedTypeReference> _map = ListExtensions.<JvmTypeParameter, JvmParameterizedTypeReference>map(typeParameters, _function);
      JvmParameterizedTypeReference _createTypeRef = this._typeReferences.createTypeRef(type, ((JvmTypeReference[])Conversions.unwrapArray(_map, JvmTypeReference.class)));
      _xblockexpression = (((JvmParameterizedTypeReference) _createTypeRef));
    }
    return _xblockexpression;
  }
  
  public JvmParameterizedTypeReference getTypeRef(final JvmType type) {
    JvmParameterizedTypeReference _xblockexpression = null;
    {
      boolean _equals = Objects.equal(type, null);
      if (_equals) {
        return null;
      }
      JvmParameterizedTypeReference _createTypeRef = this._typeReferences.createTypeRef(type);
      _xblockexpression = (((JvmParameterizedTypeReference) _createTypeRef));
    }
    return _xblockexpression;
  }
  
  public boolean hasCycleInHierarchy(final Ecosystem ecosystem) {
    HashSet<Ecosystem> _newHashSet = CollectionLiterals.<Ecosystem>newHashSet();
    return this.hasCycleInHierarchy(ecosystem, _newHashSet);
  }
  
  public boolean hasCycleInHierarchy(final Ecosystem ecosystem, final Set<Ecosystem> processedSuperTypes) {
    boolean _contains = processedSuperTypes.contains(ecosystem);
    if (_contains) {
      return true;
    }
    processedSuperTypes.add(ecosystem);
    JvmParameterizedTypeReference _specializes = ecosystem.getSpecializes();
    JvmType _type = null;
    if (_specializes!=null) {
      _type=_specializes.getType();
    }
    Ecosystem _associatedEcosystem = null;
    if (_type!=null) {
      _associatedEcosystem=this.associatedEcosystem(_type);
    }
    final Ecosystem superType = _associatedEcosystem;
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
    processedSuperTypes.remove(ecosystem);
    return false;
  }
  
  /**
   * these give the requires and the provides
   * the most specialized for a component and its hierarchy
   */
  public Iterable<RequiredPort> getAllRequires(final AbstractComponent i) {
    EList<RequiredPort> _requires = i.getRequires();
    Iterable<RequiredPort> _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (i instanceof Ecosystem) {
        _matched=true;
        Iterable<RequiredPort> _xblockexpression = null;
        {
          JvmParameterizedTypeReference _specializes = ((Ecosystem)i).getSpecializes();
          JvmType _type = null;
          if (_specializes!=null) {
            _type=_specializes.getType();
          }
          Ecosystem _associatedEcosystem = null;
          if (_type!=null) {
            _associatedEcosystem=this.associatedEcosystem(_type);
          }
          final Ecosystem eco = _associatedEcosystem;
          Iterable<RequiredPort> _xifexpression = null;
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(eco, null));
          if (!_notEquals) {
            _and = false;
          } else {
            boolean _hasCycleInHierarchy = this.hasCycleInHierarchy(eco);
            boolean _not = (!_hasCycleInHierarchy);
            _and = _not;
          }
          if (_and) {
            Iterable<RequiredPort> _allRequires = this.getAllRequires(eco);
            final Function1<RequiredPort,Boolean> _function = new Function1<RequiredPort,Boolean>() {
              public Boolean apply(final RequiredPort ar) {
                EList<RequiredPort> _requires = ((Ecosystem)i).getRequires();
                final Function1<RequiredPort,Boolean> _function = new Function1<RequiredPort,Boolean>() {
                  public Boolean apply(final RequiredPort r) {
                    String _name = r.getName();
                    String _name_1 = ar.getName();
                    return Boolean.valueOf(Objects.equal(_name, _name_1));
                  }
                };
                boolean _exists = IterableExtensions.<RequiredPort>exists(_requires, _function);
                return Boolean.valueOf((!_exists));
              }
            };
            _xifexpression = IterableExtensions.<RequiredPort>filter(_allRequires, _function);
          } else {
            _xifexpression = Collections.<RequiredPort>unmodifiableList(Lists.<RequiredPort>newArrayList());
          }
          _xblockexpression = (_xifexpression);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      _switchResult = Collections.<RequiredPort>unmodifiableList(Lists.<RequiredPort>newArrayList());
    }
    return Iterables.<RequiredPort>concat(_requires, _switchResult);
  }
  
  public Iterable<ProvidedPort> getAllProvides(final AbstractComponent i) {
    EList<ProvidedPort> _provides = i.getProvides();
    Iterable<ProvidedPort> _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (i instanceof Ecosystem) {
        _matched=true;
        Iterable<ProvidedPort> _xblockexpression = null;
        {
          JvmParameterizedTypeReference _specializes = ((Ecosystem)i).getSpecializes();
          JvmType _type = null;
          if (_specializes!=null) {
            _type=_specializes.getType();
          }
          Ecosystem _associatedEcosystem = null;
          if (_type!=null) {
            _associatedEcosystem=this.associatedEcosystem(_type);
          }
          final Ecosystem eco = _associatedEcosystem;
          Iterable<ProvidedPort> _xifexpression = null;
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(eco, null));
          if (!_notEquals) {
            _and = false;
          } else {
            boolean _hasCycleInHierarchy = this.hasCycleInHierarchy(eco);
            boolean _not = (!_hasCycleInHierarchy);
            _and = _not;
          }
          if (_and) {
            Iterable<ProvidedPort> _allProvides = this.getAllProvides(eco);
            final Function1<ProvidedPort,Boolean> _function = new Function1<ProvidedPort,Boolean>() {
              public Boolean apply(final ProvidedPort ar) {
                EList<ProvidedPort> _provides = ((Ecosystem)i).getProvides();
                final Function1<ProvidedPort,Boolean> _function = new Function1<ProvidedPort,Boolean>() {
                  public Boolean apply(final ProvidedPort r) {
                    String _name = r.getName();
                    String _name_1 = ar.getName();
                    return Boolean.valueOf(Objects.equal(_name, _name_1));
                  }
                };
                boolean _exists = IterableExtensions.<ProvidedPort>exists(_provides, _function);
                return Boolean.valueOf((!_exists));
              }
            };
            _xifexpression = IterableExtensions.<ProvidedPort>filter(_allProvides, _function);
          } else {
            _xifexpression = Collections.<ProvidedPort>unmodifiableList(Lists.<ProvidedPort>newArrayList());
          }
          _xblockexpression = (_xifexpression);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      _switchResult = Collections.<ProvidedPort>unmodifiableList(Lists.<ProvidedPort>newArrayList());
    }
    return Iterables.<ProvidedPort>concat(_provides, _switchResult);
  }
  
  public LightweightTypeReference toLightweightTypeReference(final JvmTypeReference typeRef, final Resource context) {
    LightweightTypeReference _xblockexpression = null;
    {
      StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.services, context);
      final OwnedConverter converter = new OwnedConverter(_standardTypeReferenceOwner, false);
      _xblockexpression = (converter.toLightweightReference(typeRef));
    }
    return _xblockexpression;
  }
  
  public LightweightTypeReference resolveTypeFrom(final Binding binding) {
    RequiredPort _from = binding.getFrom();
    EObject _eContainer = binding.eContainer();
    return this.resolveType(_from, ((Part) _eContainer));
  }
  
  public LightweightTypeReference resolveType(final Feature f) {
    JvmTypeReference _parameterType = f.getParameterType();
    Resource _eResource = f.eResource();
    return this.toLightweightTypeReference(_parameterType, _eResource);
  }
  
  public LightweightTypeReference resolveType(final Feature f, final Part p) {
    LightweightTypeReference _xblockexpression = null;
    {
      final LightweightTypeReference ftr = this.resolveType(f);
      JvmParameterizedTypeReference _ecosystemTypeReference = this.ecosystemTypeReference(p);
      Resource _eResource = p.eResource();
      final LightweightTypeReference ptr = this.toLightweightTypeReference(_ecosystemTypeReference, _eResource);
      _xblockexpression = (this.resolveType(ftr, ptr));
    }
    return _xblockexpression;
  }
  
  public LightweightTypeReference resolveType(final PortRef ref) {
    LightweightTypeReference _xifexpression = null;
    Part _part = ref.getPart();
    boolean _equals = Objects.equal(_part, null);
    if (_equals) {
      Port _port = ref.getPort();
      JvmParameterizedTypeReference _typeReference = _port.getTypeReference();
      Resource _eResource = ref.eResource();
      _xifexpression = this.toLightweightTypeReference(_typeReference, _eResource);
    } else {
      Port _port_1 = ref.getPort();
      Part _part_1 = ref.getPart();
      _xifexpression = this.resolveType(_port_1, _part_1);
    }
    return _xifexpression;
  }
  
  public LightweightTypeReference resolveType(final Port port, final Part part) {
    LightweightTypeReference _xblockexpression = null;
    {
      JvmParameterizedTypeReference _typeReference = port.getTypeReference();
      Resource _eResource = port.eResource();
      final LightweightTypeReference portTypeRef = this.toLightweightTypeReference(_typeReference, _eResource);
      JvmParameterizedTypeReference _ecosystemTypeReference = this.ecosystemTypeReference(part);
      Resource _eResource_1 = part.eResource();
      final LightweightTypeReference partTypeRef = this.toLightweightTypeReference(_ecosystemTypeReference, _eResource_1);
      JvmParameterizedTypeReference _typeReference_1 = this.typeReference(part);
      JvmType _type = _typeReference_1.getType();
      Ecosystem _associatedEcosystem = this.associatedEcosystem(_type);
      _xblockexpression = (this.resolveType(portTypeRef, partTypeRef, port, _associatedEcosystem));
    }
    return _xblockexpression;
  }
  
  private LightweightTypeReference resolveType(final LightweightTypeReference portTypeRef, final LightweightTypeReference containerTypeRef, final Port port, final AbstractComponent ac) {
    LightweightTypeReference _xblockexpression = null;
    {
      LightweightTypeReference _xifexpression = null;
      boolean _and = false;
      boolean _and_1 = false;
      boolean _notEquals = (!Objects.equal(ac, null));
      if (!_notEquals) {
        _and_1 = false;
      } else {
        boolean _or = false;
        EList<ProvidedPort> _provides = ac.getProvides();
        boolean _contains = _provides.contains(port);
        if (_contains) {
          _or = true;
        } else {
          EList<RequiredPort> _requires = ac.getRequires();
          boolean _contains_1 = _requires.contains(port);
          _or = _contains_1;
        }
        boolean _not = (!_or);
        _and_1 = _not;
      }
      if (!_and_1) {
        _and = false;
      } else {
        JvmParameterizedTypeReference _specializes = ac.getSpecializes();
        boolean _notEquals_1 = (!Objects.equal(_specializes, null));
        _and = _notEquals_1;
      }
      if (_and) {
        LightweightTypeReference _xblockexpression_1 = null;
        {
          JvmParameterizedTypeReference _specializes_1 = ac.getSpecializes();
          Resource _eResource = ac.eResource();
          final LightweightTypeReference nptr = this.toLightweightTypeReference(_specializes_1, _eResource);
          JvmParameterizedTypeReference _specializes_2 = ac.getSpecializes();
          JvmType _type = _specializes_2.getType();
          Ecosystem _associatedEcosystem = this.associatedEcosystem(_type);
          _xblockexpression_1 = (this.resolveType(portTypeRef, nptr, port, _associatedEcosystem));
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = portTypeRef;
      }
      final LightweightTypeReference tr = _xifexpression;
      _xblockexpression = (this.resolveType(tr, containerTypeRef));
    }
    return _xblockexpression;
  }
  
  private LightweightTypeReference resolveType(final LightweightTypeReference tr, final LightweightTypeReference containerTypeRef) {
    LightweightTypeReference _xblockexpression = null;
    {
      ITypeReferenceOwner _owner = containerTypeRef.getOwner();
      ConstraintAwareTypeArgumentCollector _constraintAwareTypeArgumentCollector = new ConstraintAwareTypeArgumentCollector(_owner);
      final Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> mapping = _constraintAwareTypeArgumentCollector.getTypeParameterMapping(containerTypeRef);
      ITypeReferenceOwner _owner_1 = containerTypeRef.getOwner();
      StandardTypeParameterSubstitutor _standardTypeParameterSubstitutor = new StandardTypeParameterSubstitutor(mapping, _owner_1);
      _xblockexpression = (_standardTypeParameterSubstitutor.substitute(tr));
    }
    return _xblockexpression;
  }
  
  public boolean modelElementHasError(final EObject e, final boolean ignoreContent, final Function1<? super Issue,? extends Boolean> ignore, final boolean ignoreContentOfIgnored) {
    Resource _eResource = e.eResource();
    final IElementIssueProvider issueProvider = this.issueProviderFactory.get(_eResource);
    boolean ignored = false;
    Iterable<Issue> _issues = issueProvider.getIssues(e);
    for (final Issue i : _issues) {
      {
        Boolean _apply = ignore.apply(i);
        ignored = (_apply).booleanValue();
        boolean _and = false;
        Severity _severity = i.getSeverity();
        boolean _equals = Objects.equal(_severity, Severity.ERROR);
        if (!_equals) {
          _and = false;
        } else {
          _and = (!ignored);
        }
        if (_and) {
          return true;
        }
      }
    }
    if (((!ignoreContent) && (!(ignoreContentOfIgnored && ignored)))) {
      EList<EObject> _eContents = e.eContents();
      for (final EObject oe : _eContents) {
        boolean _modelElementHasError = this.modelElementHasError(oe, ignoreContent, ignore, ignoreContentOfIgnored);
        if (_modelElementHasError) {
          return true;
        }
      }
    }
    return false;
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
  
  public JvmParameterizedTypeReference ecosystemTypeReference(final Part part) {
    if (part instanceof ComponentPart) {
      return _ecosystemTypeReference((ComponentPart)part);
    } else if (part instanceof SpeciesPart) {
      return _ecosystemTypeReference((SpeciesPart)part);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(part).toString());
    }
  }
}
