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
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
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
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedOperations;
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
  @Extension
  private OverrideHelper _overrideHelper;
  
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
            JvmParameterizedTypeReference _specializes_1 = comp.getSpecializes();
            JvmType _type_1 = ((JvmParameterizedTypeReference)in).getType();
            EList<JvmTypeParameter> _typeParameters = ((JvmGenericType) _type_1).getTypeParameters();
            EList<JvmTypeReference> _arguments = ((JvmParameterizedTypeReference)in).getArguments();
            Resource _eResource = comp.eResource();
            JvmTypeReference _substituteTypeParameters = this.substituteTypeParameters(_specializes_1, _typeParameters, _arguments, _eResource);
            _switchResult = this.rootSupertype(_substituteTypeParameters);
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
  
  public JvmTypeReference substituteTypeParameters(final JvmTypeReference in, final List<JvmTypeParameter> from, final List<? extends JvmTypeReference> to, final Resource context) {
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
            _xblockexpression_1 = _substituteTypeParameters.toJavaCompliantTypeReference();
          }
          _switchResult = _xblockexpression_1;
        }
      }
      if (!_matched) {
        _switchResult = in;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public LightweightTypeReference substituteTypeParameters(final LightweightTypeReference in, final List<JvmTypeParameter> from, final List<? extends JvmTypeReference> to) {
    LightweightTypeReference _xblockexpression = null;
    {
      ITypeReferenceOwner _owner = in.getOwner();
      final OwnedConverter converter = new OwnedConverter(_owner, false);
      final Function1<JvmTypeParameter, LightweightMergedBoundTypeArgument> _function = new Function1<JvmTypeParameter, LightweightMergedBoundTypeArgument>() {
        public LightweightMergedBoundTypeArgument apply(final JvmTypeParameter k) {
          LightweightMergedBoundTypeArgument _xblockexpression = null;
          {
            int _indexOf = from.indexOf(k);
            JvmTypeReference _get = to.get(_indexOf);
            final LightweightTypeReference r = converter.toLightweightReference(_get);
            _xblockexpression = new LightweightMergedBoundTypeArgument(r, VarianceInfo.INVARIANT);
          }
          return _xblockexpression;
        }
      };
      final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = IterableExtensions.<JvmTypeParameter, LightweightMergedBoundTypeArgument>toInvertedMap(from, _function);
      ITypeReferenceOwner _owner_1 = in.getOwner();
      StandardTypeParameterSubstitutor _standardTypeParameterSubstitutor = new StandardTypeParameterSubstitutor(mapping, _owner_1);
      final LightweightTypeReference res = _standardTypeParameterSubstitutor.substitute(in);
      _xblockexpression = res;
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
  
  public boolean hasCycleInHierarchy(final Ecosystem ecosystem, final Set<Ecosystem> processedSuperTypes) {
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
   * these give the requires and the provides
   * the most specialized for a component and its hierarchy
   */
  protected Iterable<RequiredPort> _getAllRequires(final Ecosystem i) {
    List<RequiredPort> _xifexpression = null;
    boolean _hasCycleInHierarchy = this.hasCycleInHierarchy(i);
    if (_hasCycleInHierarchy) {
      _xifexpression = i.getRequires();
    } else {
      ArrayList<RequiredPort> _xblockexpression = null;
      {
        final ArrayList<RequiredPort> res = CollectionLiterals.<RequiredPort>newArrayList();
        this.fillRequires(i, res);
        _xblockexpression = res;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected Iterable<RequiredPort> _getAllRequires(final Species i) {
    return i.getRequires();
  }
  
  private void fillRequires(final Ecosystem i, final ArrayList<RequiredPort> ports) {
    EList<RequiredPort> _requires = i.getRequires();
    final Function1<RequiredPort, Boolean> _function = new Function1<RequiredPort, Boolean>() {
      public Boolean apply(final RequiredPort ar) {
        final Function1<RequiredPort, Boolean> _function = new Function1<RequiredPort, Boolean>() {
          public Boolean apply(final RequiredPort r) {
            String _name = r.getName();
            String _name_1 = ar.getName();
            return Boolean.valueOf(Objects.equal(_name, _name_1));
          }
        };
        boolean _exists = IterableExtensions.<RequiredPort>exists(ports, _function);
        return Boolean.valueOf((!_exists));
      }
    };
    Iterable<RequiredPort> _filter = IterableExtensions.<RequiredPort>filter(_requires, _function);
    Iterables.<RequiredPort>addAll(ports, _filter);
    JvmParameterizedTypeReference _specializes = i.getSpecializes();
    boolean _isUseless = this.isUseless(_specializes);
    boolean _not = (!_isUseless);
    if (_not) {
      JvmParameterizedTypeReference _specializes_1 = i.getSpecializes();
      JvmType _type = _specializes_1.getType();
      final Ecosystem eco = this.associatedEcosystem(_type);
      boolean _notEquals = (!Objects.equal(eco, null));
      if (_notEquals) {
        this.fillRequires(eco, ports);
      }
    }
  }
  
  protected Iterable<ProvidedPort> _getAllProvides(final Ecosystem i) {
    List<ProvidedPort> _xifexpression = null;
    boolean _hasCycleInHierarchy = this.hasCycleInHierarchy(i);
    if (_hasCycleInHierarchy) {
      _xifexpression = i.getProvides();
    } else {
      ArrayList<ProvidedPort> _xblockexpression = null;
      {
        final ArrayList<ProvidedPort> res = CollectionLiterals.<ProvidedPort>newArrayList();
        this.fillProvides(i, res);
        _xblockexpression = res;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected Iterable<ProvidedPort> _getAllProvides(final Species i) {
    return i.getProvides();
  }
  
  private void fillProvides(final Ecosystem i, final ArrayList<ProvidedPort> ports) {
    EList<ProvidedPort> _provides = i.getProvides();
    final Function1<ProvidedPort, Boolean> _function = new Function1<ProvidedPort, Boolean>() {
      public Boolean apply(final ProvidedPort ar) {
        final Function1<ProvidedPort, Boolean> _function = new Function1<ProvidedPort, Boolean>() {
          public Boolean apply(final ProvidedPort r) {
            String _name = r.getName();
            String _name_1 = ar.getName();
            return Boolean.valueOf(Objects.equal(_name, _name_1));
          }
        };
        boolean _exists = IterableExtensions.<ProvidedPort>exists(ports, _function);
        return Boolean.valueOf((!_exists));
      }
    };
    Iterable<ProvidedPort> _filter = IterableExtensions.<ProvidedPort>filter(_provides, _function);
    Iterables.<ProvidedPort>addAll(ports, _filter);
    JvmParameterizedTypeReference _specializes = i.getSpecializes();
    boolean _isUseless = this.isUseless(_specializes);
    boolean _not = (!_isUseless);
    if (_not) {
      JvmParameterizedTypeReference _specializes_1 = i.getSpecializes();
      JvmType _type = _specializes_1.getType();
      final Ecosystem eco = this.associatedEcosystem(_type);
      boolean _notEquals = (!Objects.equal(eco, null));
      if (_notEquals) {
        this.fillProvides(eco, ports);
      }
    }
  }
  
  public ResolvedOperations myResolvedOperations(final JvmGenericType type, final Resource context) {
    ResolvedOperations _xblockexpression = null;
    {
      final StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(this.services, context);
      final ParameterizedTypeReference contextType = new ParameterizedTypeReference(owner, type);
      EList<JvmTypeParameter> _typeParameters = type.getTypeParameters();
      for (final JvmTypeParameter typeParameter : _typeParameters) {
        ParameterizedTypeReference _parameterizedTypeReference = new ParameterizedTypeReference(owner, typeParameter);
        contextType.addTypeArgument(_parameterizedTypeReference);
      }
      _xblockexpression = this._overrideHelper.getResolvedOperations(contextType);
    }
    return _xblockexpression;
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
      _xblockexpression = this.resolveType(ftr, ptr);
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
      _xblockexpression = this.resolveType(portTypeRef, partTypeRef, port, _associatedEcosystem);
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
        boolean _isUseless = this.isUseless(_specializes);
        boolean _not_1 = (!_isUseless);
        _and = _not_1;
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
          _xblockexpression_1 = this.resolveType(portTypeRef, nptr, port, _associatedEcosystem);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = portTypeRef;
      }
      final LightweightTypeReference tr = _xifexpression;
      _xblockexpression = this.resolveType(tr, containerTypeRef);
    }
    return _xblockexpression;
  }
  
  private LightweightTypeReference resolveType(final LightweightTypeReference tr, final LightweightTypeReference containerTypeRef) {
    LightweightTypeReference _xblockexpression = null;
    {
      ITypeReferenceOwner _owner = containerTypeRef.getOwner();
      ConstraintAwareTypeArgumentCollector _constraintAwareTypeArgumentCollector = new ConstraintAwareTypeArgumentCollector(_owner);
      final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = _constraintAwareTypeArgumentCollector.getTypeParameterMapping(containerTypeRef);
      ITypeReferenceOwner _owner_1 = containerTypeRef.getOwner();
      StandardTypeParameterSubstitutor _standardTypeParameterSubstitutor = new StandardTypeParameterSubstitutor(mapping, _owner_1);
      _xblockexpression = _standardTypeParameterSubstitutor.substitute(tr);
    }
    return _xblockexpression;
  }
  
  public boolean modelElementHasError(final EObject e, final boolean ignoreContent, final Function1<? super Issue, ? extends Boolean> ignore, final boolean ignoreContentOfIgnored) {
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
  
  public <A extends Object> List<A> vary(final List<? extends A> l) {
    return ((List<A>) l);
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
  
  public Iterable<RequiredPort> getAllRequires(final AbstractComponent i) {
    if (i instanceof Ecosystem) {
      return _getAllRequires((Ecosystem)i);
    } else if (i instanceof Species) {
      return _getAllRequires((Species)i);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(i).toString());
    }
  }
  
  public Iterable<ProvidedPort> getAllProvides(final AbstractComponent i) {
    if (i instanceof Ecosystem) {
      return _getAllProvides((Ecosystem)i);
    } else if (i instanceof Species) {
      return _getAllProvides((Species)i);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(i).toString());
    }
  }
}
