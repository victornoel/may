package fr.irit.smac.may.speadl.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import fr.irit.smac.may.speadl.SpeADLUtils;
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
import fr.irit.smac.may.speadl.speadl.SpeadlPackage;
import fr.irit.smac.may.speadl.speadl.Species;
import fr.irit.smac.may.speadl.speadl.SpeciesReference;
import fr.irit.smac.may.speadl.validation.AbstractSpeADLValidator;
import fr.irit.smac.may.speadl.validation.SpeADLJvmTypeReferenceValidator;
import fr.irit.smac.may.speadl.validation.SpeADLXtendXtextInspiredValidator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.NamesAreUniqueValidator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@ComposedChecks(validators = { SpeADLXtendXtextInspiredValidator.class, SpeADLJvmTypeReferenceValidator.class, NamesAreUniqueValidator.class })
@SuppressWarnings("all")
public class SpeADLValidator extends AbstractSpeADLValidator {
  @Inject
  @Extension
  private SpeADLUtils _speADLUtils;
  
  /**
   * See checkLocalUsageOfDeclaredFields for hilighting unbinded part!
   * And checkNonInitializedFieldsHaveAType if we want to infer type of already bound provides, would be nice...
   */
  @Check
  public void checkPortRef(final PortRef pr) {
    boolean _or = false;
    Port _port = pr.getPort();
    boolean _tripleEquals = (_port == null);
    if (_tripleEquals) {
      _or = true;
    } else {
      Port _port_1 = pr.getPort();
      boolean _eIsProxy = _port_1.eIsProxy();
      _or = _eIsProxy;
    }
    if (_or) {
      return;
    }
    boolean _and = false;
    Part _part = pr.getPart();
    boolean _tripleNotEquals = (_part != null);
    if (!_tripleNotEquals) {
      _and = false;
    } else {
      Part _part_1 = pr.getPart();
      boolean _eIsProxy_1 = _part_1.eIsProxy();
      _and = _eIsProxy_1;
    }
    if (_and) {
      return;
    }
    final LightweightTypeReference typeTo = this._speADLUtils.resolveType(pr);
    LightweightTypeReference _switchResult = null;
    EObject _eContainer = pr.eContainer();
    final EObject cont = _eContainer;
    boolean _matched = false;
    if (!_matched) {
      if (cont instanceof Binding) {
        _matched=true;
        _switchResult = this._speADLUtils.resolveTypeFrom(((Binding)cont));
      }
    }
    if (!_matched) {
      if (cont instanceof ProvidedPort) {
        _matched=true;
        JvmParameterizedTypeReference _typeReference = ((ProvidedPort)cont).getTypeReference();
        Resource _eResource = pr.eResource();
        _switchResult = this._speADLUtils.toLightweightTypeReference(_typeReference, _eResource);
      }
    }
    final LightweightTypeReference typeFrom = _switchResult;
    boolean _and_1 = false;
    boolean _tripleNotEquals_1 = (typeFrom != null);
    if (!_tripleNotEquals_1) {
      _and_1 = false;
    } else {
      boolean _tripleNotEquals_2 = (typeTo != null);
      _and_1 = _tripleNotEquals_2;
    }
    if (_and_1) {
      boolean _isAssignableFrom = typeFrom.isAssignableFrom(typeTo);
      boolean _not = (!_isAssignableFrom);
      if (_not) {
        this.error(((("Incompatible types: " + typeFrom) + " is not the same or a supertype of ") + typeTo), SpeadlPackage.Literals.PORT_REF__PORT);
      }
    }
  }
  
  @Check
  public void checkPortRefEco(final PortRef pr) {
    final AbstractComponent comp = EcoreUtil2.<AbstractComponent>getContainerOfType(pr, AbstractComponent.class);
    boolean _and = false;
    boolean _isEcosystem = pr.isEcosystem();
    if (!_isEcosystem) {
      _and = false;
    } else {
      _and = (!(comp instanceof Species));
    }
    if (_and) {
      this.warning("The keyword \'eco\' is meant to be used in a Species", SpeadlPackage.Literals.PORT_REF__ECOSYSTEM);
    }
  }
  
  @Check
  public void checkStartsWithCapital(final AbstractComponent ne) {
    String _name = ne.getName();
    char _charAt = _name.charAt(0);
    boolean _isUpperCase = Character.isUpperCase(_charAt);
    boolean _not = (!_isUpperCase);
    if (_not) {
      String _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (ne instanceof Ecosystem) {
          _matched=true;
          _switchResult = "Ecosystem";
        }
      }
      if (!_matched) {
        if (ne instanceof Species) {
          _matched=true;
          _switchResult = "Species";
        }
      }
      final String what = _switchResult;
      this.error((what + " name must start with a capital"), 
        SpeadlPackage.Literals.ABSTRACT_COMPONENT__NAME);
    }
  }
  
  @Check
  public void checkStartsWithCapital(final JvmTypeParameter ne) {
    String _name = ne.getName();
    char _charAt = _name.charAt(0);
    boolean _isUpperCase = Character.isUpperCase(_charAt);
    boolean _not = (!_isUpperCase);
    if (_not) {
      this.error("Type parameter name must start with a capital", 
        TypesPackage.Literals.JVM_TYPE_PARAMETER__NAME);
    }
  }
  
  @Check
  public void checkStartsWithoutCapital(final ContentElement ne) {
    String _name = ne.getName();
    char _charAt = _name.charAt(0);
    boolean _isLowerCase = Character.isLowerCase(_charAt);
    boolean _not = (!_isLowerCase);
    if (_not) {
      String _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (ne instanceof Part) {
          _matched=true;
          _switchResult = "Part";
        }
      }
      if (!_matched) {
        if (ne instanceof Port) {
          _matched=true;
          _switchResult = "Port";
        }
      }
      final String what = _switchResult;
      this.error((what + " name must not start with a capital"), 
        SpeadlPackage.Literals.CONTENT_ELEMENT__NAME);
    }
  }
  
  @Check
  public void checkBound(final Part ci) {
    AbstractComponent _abstractComponent = this._speADLUtils.abstractComponent(ci);
    Iterable<RequiredPort> _allRequires = this._speADLUtils.getAllRequires(_abstractComponent);
    final Set<RequiredPort> toBind = IterableExtensions.<RequiredPort>toSet(_allRequires);
    EList<Binding> _bindings = ci.getBindings();
    final Function1<Binding, RequiredPort> _function = new Function1<Binding, RequiredPort>() {
      public RequiredPort apply(final Binding it) {
        return it.getFrom();
      }
    };
    List<RequiredPort> _map = ListExtensions.<Binding, RequiredPort>map(_bindings, _function);
    final Set<RequiredPort> bound = IterableExtensions.<RequiredPort>toSet(_map);
    toBind.removeAll(bound);
    boolean _isEmpty = toBind.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.error("Missing bindings for required ports", 
        SpeadlPackage.Literals.CONTENT_ELEMENT__NAME);
    }
  }
  
  @Check
  public void checkUseArgsAgainstParameters(final SpeciesReference reference) {
    Species _species = reference.getSpecies();
    EList<Feature> _parameters = _species.getParameters();
    final int numParameters = _parameters.size();
    EList<Feature> _arguments = reference.getArguments();
    int _size = _arguments.size();
    boolean _notEquals = (numParameters != _size);
    if (_notEquals) {
      Species _species_1 = reference.getSpecies();
      String _name = _species_1.getName();
      String _plus = ("Incorrect number of arguments for species " + _name);
      String _plus_1 = (_plus + "(");
      Species _species_2 = reference.getSpecies();
      EList<Feature> _parameters_1 = _species_2.getParameters();
      final Function1<Feature, String> _function = new Function1<Feature, String>() {
        public String apply(final Feature it) {
          return it.getName();
        }
      };
      List<String> _map = ListExtensions.<Feature, String>map(_parameters_1, _function);
      String _join = IterableExtensions.join(_map, ",");
      String _plus_2 = (_plus_1 + _join);
      String _plus_3 = (_plus_2 + ")");
      String _plus_4 = (_plus_3 + "; it cannot be parameterized with arguments ");
      String _plus_5 = (_plus_4 + "(");
      EList<Feature> _arguments_1 = reference.getArguments();
      final Function1<Feature, String> _function_1 = new Function1<Feature, String>() {
        public String apply(final Feature it) {
          return it.getName();
        }
      };
      List<String> _map_1 = ListExtensions.<Feature, String>map(_arguments_1, _function_1);
      String _join_1 = IterableExtensions.join(_map_1, ",");
      String _plus_6 = (_plus_5 + _join_1);
      String _plus_7 = (_plus_6 + ")");
      this.error(_plus_7, 
        SpeadlPackage.Literals.SPECIES_REFERENCE__ARGUMENTS);
    }
  }
  
  @Check
  public void checkUseArguments(final SpeciesReference reference) {
    EList<Feature> _arguments = reference.getArguments();
    final int argSize = _arguments.size();
    Species _species = reference.getSpecies();
    EList<Feature> _parameters = _species.getParameters();
    final int paramSize = _parameters.size();
    if ((argSize == paramSize)) {
      int i = 0;
      final ComponentPart part = reference.getPart();
      while ((i < argSize)) {
        {
          Species _species_1 = reference.getSpecies();
          EList<Feature> _parameters_1 = _species_1.getParameters();
          Feature _get = _parameters_1.get(i);
          final LightweightTypeReference typeFrom = this._speADLUtils.resolveType(_get, part);
          EList<Feature> _arguments_1 = reference.getArguments();
          Feature _get_1 = _arguments_1.get(i);
          final LightweightTypeReference typeTo = this._speADLUtils.getTypeRef(_get_1);
          boolean _isAssignableFrom = typeFrom.isAssignableFrom(typeTo);
          boolean _not = (!_isAssignableFrom);
          if (_not) {
            this.error(((("Incompatible types: " + typeFrom) + " is not the same or a supertype of ") + typeTo), SpeadlPackage.Literals.SPECIES_REFERENCE__ARGUMENTS, i);
          }
          i = (i + 1);
        }
      }
    }
  }
  
  @Check
  public void checkProvidesOverrideAreOk(final ProvidedPort p) {
    JvmParameterizedTypeReference _typeReference = p.getTypeReference();
    Resource _eResource = p.eResource();
    final LightweightTypeReference typeTo = this._speADLUtils.toLightweightTypeReference(_typeReference, _eResource);
    final LightweightTypeReference typeFrom = this._speADLUtils.getOverridenPortTypeRef(p);
    boolean _and = false;
    boolean _tripleNotEquals = (typeFrom != null);
    if (!_tripleNotEquals) {
      _and = false;
    } else {
      boolean _tripleNotEquals_1 = (typeTo != null);
      _and = _tripleNotEquals_1;
    }
    if (_and) {
      boolean _isAssignableFrom = typeFrom.isAssignableFrom(typeTo);
      boolean _not = (!_isAssignableFrom);
      if (_not) {
        this.error(((("Incompatible type override: " + typeFrom) + " is not the same or a supertype of ") + typeTo), SpeadlPackage.Literals.PORT__TYPE_REFERENCE);
      }
    }
  }
  
  @Check
  public void checkContentElementDuplicates(final AbstractComponent ac) {
    final HashSet<Pair<ContentElement, String>> names = CollectionLiterals.<Pair<ContentElement, String>>newHashSet();
    EList<Part> _parts = ac.getParts();
    final Function1<Part, Pair<ContentElement, String>> _function = new Function1<Part, Pair<ContentElement, String>>() {
      public Pair<ContentElement, String> apply(final Part it) {
        String _name = it.getName();
        return Pair.<ContentElement, String>of(((ContentElement) it), _name);
      }
    };
    List<Pair<ContentElement, String>> _map = ListExtensions.<Part, Pair<ContentElement, String>>map(_parts, _function);
    Iterables.<Pair<ContentElement, String>>addAll(names, _map);
    EList<ProvidedPort> _provides = ac.getProvides();
    final Function1<ProvidedPort, Pair<ContentElement, String>> _function_1 = new Function1<ProvidedPort, Pair<ContentElement, String>>() {
      public Pair<ContentElement, String> apply(final ProvidedPort it) {
        String _name = it.getName();
        return Pair.<ContentElement, String>of(((ContentElement) it), _name);
      }
    };
    List<Pair<ContentElement, String>> _map_1 = ListExtensions.<ProvidedPort, Pair<ContentElement, String>>map(_provides, _function_1);
    Iterables.<Pair<ContentElement, String>>addAll(names, _map_1);
    EList<RequiredPort> _requires = ac.getRequires();
    final Function1<RequiredPort, Pair<ContentElement, String>> _function_2 = new Function1<RequiredPort, Pair<ContentElement, String>>() {
      public Pair<ContentElement, String> apply(final RequiredPort it) {
        String _name = it.getName();
        return Pair.<ContentElement, String>of(((ContentElement) it), _name);
      }
    };
    List<Pair<ContentElement, String>> _map_2 = ListExtensions.<RequiredPort, Pair<ContentElement, String>>map(_requires, _function_2);
    Iterables.<Pair<ContentElement, String>>addAll(names, _map_2);
    final HashSet<Pair<ContentElement, String>> superNames = CollectionLiterals.<Pair<ContentElement, String>>newHashSet();
    Iterable<RequiredPort> _allRequires = this._speADLUtils.getAllRequires(ac);
    final Function1<RequiredPort, Pair<ContentElement, String>> _function_3 = new Function1<RequiredPort, Pair<ContentElement, String>>() {
      public Pair<ContentElement, String> apply(final RequiredPort it) {
        String _name = it.getName();
        return Pair.<ContentElement, String>of(((ContentElement) it), _name);
      }
    };
    Iterable<Pair<ContentElement, String>> _map_3 = IterableExtensions.<RequiredPort, Pair<ContentElement, String>>map(_allRequires, _function_3);
    Iterables.<Pair<ContentElement, String>>addAll(superNames, _map_3);
    Iterable<ProvidedPort> _allProvides = this._speADLUtils.getAllProvides(ac);
    final Function1<ProvidedPort, Pair<ContentElement, String>> _function_4 = new Function1<ProvidedPort, Pair<ContentElement, String>>() {
      public Pair<ContentElement, String> apply(final ProvidedPort it) {
        String _name = it.getName();
        return Pair.<ContentElement, String>of(((ContentElement) it), _name);
      }
    };
    Iterable<Pair<ContentElement, String>> _map_4 = IterableExtensions.<ProvidedPort, Pair<ContentElement, String>>map(_allProvides, _function_4);
    Iterables.<Pair<ContentElement, String>>addAll(superNames, _map_4);
    final Procedure2<Pair<ContentElement, String>, Integer> _function_5 = new Procedure2<Pair<ContentElement, String>, Integer>() {
      public void apply(final Pair<ContentElement, String> pn, final Integer index) {
        final ContentElement p = pn.getKey();
        final Function1<Pair<ContentElement, String>, Boolean> _function = new Function1<Pair<ContentElement, String>, Boolean>() {
          public Boolean apply(final Pair<ContentElement, String> it) {
            boolean _and = false;
            ContentElement _key = it.getKey();
            boolean _tripleNotEquals = (_key != p);
            if (!_tripleNotEquals) {
              _and = false;
            } else {
              String _value = it.getValue();
              String _name = p.getName();
              boolean _equals = Objects.equal(_value, _name);
              _and = _equals;
            }
            return Boolean.valueOf(_and);
          }
        };
        boolean _exists = IterableExtensions.<Pair<ContentElement, String>>exists(names, _function);
        if (_exists) {
          String _name = p.getName();
          String _plus = ("Duplicate name \'" + _name);
          String _plus_1 = (_plus + "\'");
          SpeADLValidator.this.error(_plus_1, p, SpeadlPackage.Literals.CONTENT_ELEMENT__NAME);
        } else {
          final Function1<Pair<ContentElement, String>, Boolean> _function_1 = new Function1<Pair<ContentElement, String>, Boolean>() {
            public Boolean apply(final Pair<ContentElement, String> it) {
              boolean _and = false;
              ContentElement _key = it.getKey();
              boolean _tripleNotEquals = (_key != p);
              if (!_tripleNotEquals) {
                _and = false;
              } else {
                String _value = it.getValue();
                String _name = p.getName();
                boolean _equals = Objects.equal(_value, _name);
                _and = _equals;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists_1 = IterableExtensions.<Pair<ContentElement, String>>exists(superNames, _function_1);
          if (_exists_1) {
            String _name_1 = p.getName();
            String _plus_2 = ("Duplicate name \'" + _name_1);
            String _plus_3 = (_plus_2 + "\' in specialized component");
            SpeADLValidator.this.error(_plus_3, p, SpeadlPackage.Literals.CONTENT_ELEMENT__NAME);
          }
        }
      }
    };
    IterableExtensions.<Pair<ContentElement, String>>forEach(names, _function_5);
  }
  
  @Check
  public void checkSpecializeReference(final Ecosystem ecosystem) {
    final JvmParameterizedTypeReference superTypeRef = ecosystem.getSpecializes();
    boolean _tripleNotEquals = (superTypeRef != null);
    if (_tripleNotEquals) {
      JvmType _type = superTypeRef.getType();
      final Ecosystem superType = this._speADLUtils.associatedEcosystem(_type);
      boolean _tripleEquals = (superType == null);
      if (_tripleEquals) {
        JvmParameterizedTypeReference _specializes = ecosystem.getSpecializes();
        String _simpleName = _specializes.getSimpleName();
        String _plus = (_simpleName + " cannot be resolved");
        JvmParameterizedTypeReference _specializes_1 = ecosystem.getSpecializes();
        this.error(_plus, _specializes_1, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
      } else {
        EList<Part> _parts = superType.getParts();
        boolean _isEmpty = _parts.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          this.error("Can only implements components without subcomponents", SpeadlPackage.Literals.ABSTRACT_COMPONENT__SPECIALIZES);
        }
        boolean _hasCycleInHierarchy = this._speADLUtils.hasCycleInHierarchy(superType);
        if (_hasCycleInHierarchy) {
          String _name = ecosystem.getName();
          String _plus_1 = ("The inheritance hierarchy of " + _name);
          String _plus_2 = (_plus_1 + " contains cycles");
          this.error(_plus_2, 
            SpeadlPackage.Literals.ABSTRACT_COMPONENT__NAME);
        }
        boolean _isInvalidWildcard = this.isInvalidWildcard(superTypeRef);
        if (_isInvalidWildcard) {
          String _name_1 = ecosystem.getName();
          String _plus_3 = ("The type " + _name_1);
          String _plus_4 = (_plus_3 + " cannot extend or implement ");
          String _identifier = superTypeRef.getIdentifier();
          String _plus_5 = (_plus_4 + _identifier);
          String _plus_6 = (_plus_5 + ". A supertype may not specify any wildcard");
          this.error(_plus_6, SpeadlPackage.Literals.ABSTRACT_COMPONENT__SPECIALIZES);
        }
        EList<RequiredPort> _requires = ecosystem.getRequires();
        final Procedure2<RequiredPort, Integer> _function = new Procedure2<RequiredPort, Integer>() {
          public void apply(final RequiredPort p, final Integer index) {
            SpeADLValidator.this.error("Requires can\'t be declared in a specialising component", SpeadlPackage.Literals.ABSTRACT_COMPONENT__REQUIRES, (index).intValue());
          }
        };
        IterableExtensions.<RequiredPort>forEach(_requires, _function);
      }
    }
  }
  
  public boolean isInvalidWildcard(final JvmTypeReference typeRef) {
    if ((typeRef instanceof JvmWildcardTypeReference)) {
      return true;
    } else {
      if ((typeRef instanceof JvmParameterizedTypeReference)) {
        EList<JvmTypeReference> _arguments = ((JvmParameterizedTypeReference)typeRef).getArguments();
        for (final JvmTypeReference typeArgument : _arguments) {
          if ((typeArgument instanceof JvmWildcardTypeReference)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  @Check
  public void checkComponentReference(final ComponentPart p) {
    JvmParameterizedTypeReference _componentReference = p.getComponentReference();
    JvmType _type = _componentReference.getType();
    final Ecosystem eco = this._speADLUtils.associatedEcosystem(_type);
    boolean _tripleEquals = (eco == null);
    if (_tripleEquals) {
      JvmParameterizedTypeReference _componentReference_1 = p.getComponentReference();
      String _simpleName = _componentReference_1.getSimpleName();
      String _plus = (_simpleName + " cannot be resolved");
      JvmParameterizedTypeReference _componentReference_2 = p.getComponentReference();
      this.error(_plus, _componentReference_2, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
    }
  }
  
  @Check
  public void checkTypeParameterForwardReferences(final AbstractComponent c) {
    EList<JvmTypeParameter> _typeParameters = c.getTypeParameters();
    this.doCheckTypeParameterForwardReference(_typeParameters);
  }
  
  @Check
  public void checkTypeParameterNotUsedInStaticContext(final JvmTypeReference ref) {
  }
}
