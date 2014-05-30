package fr.irit.smac.may.speadl.validation;

import com.google.common.base.Objects;
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
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * Custom validation rules.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 * 
 * Carefull, NORMAL check rules are not taken into account to prevent generation
 * The idea is that there valiation rules are relying on the generated code to be valid...
 */
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
    boolean _equals = Objects.equal(_port, null);
    if (_equals) {
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
    boolean _notEquals = (!Objects.equal(_part, null));
    if (!_notEquals) {
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
    boolean _notEquals_1 = (!Objects.equal(typeFrom, null));
    if (!_notEquals_1) {
      _and_1 = false;
    } else {
      boolean _notEquals_2 = (!Objects.equal(typeTo, null));
      _and_1 = _notEquals_2;
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
      this.warning("The keyword eco is meant to be used from inside a Species", SpeadlPackage.Literals.PORT_REF__ECOSYSTEM);
    }
  }
  
  @Check
  public void checkStartsWithCapital(final AbstractComponent ne) {
    String _name = ne.getName();
    char _charAt = _name.charAt(0);
    boolean _isUpperCase = Character.isUpperCase(_charAt);
    boolean _not = (!_isUpperCase);
    if (_not) {
      this.error("Name must start with a capital", 
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
      this.error("Name must start with a capital", 
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
      this.error("Name must not start with a capital", 
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
      this.error("Missing bindings for required ports.", 
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
      boolean _while = (i < argSize);
      while (_while) {
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
        _while = (i < argSize);
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
    boolean _notEquals = (!Objects.equal(typeFrom, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(typeTo, null));
      _and = _notEquals_1;
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
  public void checkNoNewReqWhenImpl(final Ecosystem eco) {
    JvmParameterizedTypeReference _specializes = eco.getSpecializes();
    boolean _isUseless = this._speADLUtils.isUseless(_specializes);
    boolean _not = (!_isUseless);
    if (_not) {
      int index = 0;
      EList<RequiredPort> _requires = eco.getRequires();
      for (final RequiredPort p : _requires) {
        {
          this.error("Requires can\'t be declared in a specialising component", SpeadlPackage.Literals.ABSTRACT_COMPONENT__REQUIRES, index);
          index = (index + 1);
        }
      }
    }
  }
  
  @Check
  public void checkSpecializeReference(final Ecosystem ecosystem) {
    final JvmParameterizedTypeReference superTypeRef = ecosystem.getSpecializes();
    boolean _isUseless = this._speADLUtils.isUseless(superTypeRef);
    boolean _not = (!_isUseless);
    if (_not) {
      JvmType _type = superTypeRef.getType();
      final Ecosystem superType = this._speADLUtils.associatedEcosystem(_type);
      boolean _equals = Objects.equal(superType, null);
      if (_equals) {
        JvmParameterizedTypeReference _specializes = ecosystem.getSpecializes();
        String _simpleName = _specializes.getSimpleName();
        String _plus = (_simpleName + " cannot be resolved");
        JvmParameterizedTypeReference _specializes_1 = ecosystem.getSpecializes();
        this.error(_plus, _specializes_1, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
      } else {
        EList<Part> _parts = superType.getParts();
        boolean _isEmpty = _parts.isEmpty();
        boolean _not_1 = (!_isEmpty);
        if (_not_1) {
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
    boolean _equals = Objects.equal(eco, null);
    if (_equals) {
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
