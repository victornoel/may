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
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
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
    if (((pr.getPort() == null) || pr.getPort().eIsProxy())) {
      return;
    }
    if (((pr.getPart() != null) && pr.getPart().eIsProxy())) {
      return;
    }
    final LightweightTypeReference typeTo = this._speADLUtils.resolveType(pr);
    LightweightTypeReference _switchResult = null;
    EObject _eContainer = pr.eContainer();
    final EObject cont = _eContainer;
    boolean _matched = false;
    if (cont instanceof Binding) {
      _matched=true;
      _switchResult = this._speADLUtils.resolveTypeFrom(((Binding)cont));
    }
    if (!_matched) {
      if (cont instanceof ProvidedPort) {
        _matched=true;
        _switchResult = this._speADLUtils.toLightweightTypeReference(((ProvidedPort)cont).getTypeReference(), pr.eResource());
      }
    }
    final LightweightTypeReference typeFrom = _switchResult;
    if (((typeFrom != null) && (typeTo != null))) {
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
    if ((pr.isEcosystem() && (!(comp instanceof Species)))) {
      this.warning("The keyword \'eco\' is meant to be used in a Species", SpeadlPackage.Literals.PORT_REF__ECOSYSTEM);
    }
  }
  
  @Check
  public void checkStartsWithCapital(final AbstractComponent ne) {
    boolean _isUpperCase = Character.isUpperCase(ne.getName().charAt(0));
    boolean _not = (!_isUpperCase);
    if (_not) {
      String _switchResult = null;
      boolean _matched = false;
      if (ne instanceof Ecosystem) {
        _matched=true;
        _switchResult = "Ecosystem";
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
    boolean _isUpperCase = Character.isUpperCase(ne.getName().charAt(0));
    boolean _not = (!_isUpperCase);
    if (_not) {
      this.error("Type parameter name must start with a capital", 
        TypesPackage.Literals.JVM_TYPE_PARAMETER__NAME);
    }
  }
  
  @Check
  public void checkStartsWithoutCapital(final ContentElement ne) {
    boolean _isLowerCase = Character.isLowerCase(ne.getName().charAt(0));
    boolean _not = (!_isLowerCase);
    if (_not) {
      String _switchResult = null;
      boolean _matched = false;
      if (ne instanceof Part) {
        _matched=true;
        _switchResult = "Part";
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
    final Set<RequiredPort> toBind = IterableExtensions.<RequiredPort>toSet(this._speADLUtils.getAllRequires(this._speADLUtils.abstractComponent(ci)));
    final Function1<Binding, RequiredPort> _function = (Binding it) -> {
      return it.getFrom();
    };
    final Set<RequiredPort> bound = IterableExtensions.<RequiredPort>toSet(ListExtensions.<Binding, RequiredPort>map(ci.getBindings(), _function));
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
    final int numParameters = reference.getSpecies().getParameters().size();
    int _size = reference.getArguments().size();
    boolean _notEquals = (numParameters != _size);
    if (_notEquals) {
      String _name = reference.getSpecies().getName();
      String _plus = ("Incorrect number of arguments for species " + _name);
      String _plus_1 = (_plus + "(");
      final Function1<Feature, String> _function = (Feature it) -> {
        return it.getName();
      };
      String _join = IterableExtensions.join(ListExtensions.<Feature, String>map(reference.getSpecies().getParameters(), _function), ",");
      String _plus_2 = (_plus_1 + _join);
      String _plus_3 = (_plus_2 + ")");
      String _plus_4 = (_plus_3 + "; it cannot be parameterized with arguments ");
      String _plus_5 = (_plus_4 + "(");
      final Function1<Feature, String> _function_1 = (Feature it) -> {
        return it.getName();
      };
      String _join_1 = IterableExtensions.join(ListExtensions.<Feature, String>map(reference.getArguments(), _function_1), ",");
      String _plus_6 = (_plus_5 + _join_1);
      String _plus_7 = (_plus_6 + ")");
      this.error(_plus_7, 
        SpeadlPackage.Literals.SPECIES_REFERENCE__ARGUMENTS);
    }
  }
  
  @Check
  public void checkUseArguments(final SpeciesReference reference) {
    final int argSize = reference.getArguments().size();
    final int paramSize = reference.getSpecies().getParameters().size();
    if ((argSize == paramSize)) {
      int i = 0;
      final ComponentPart part = reference.getPart();
      while ((i < argSize)) {
        {
          final LightweightTypeReference typeFrom = this._speADLUtils.resolveType(reference.getSpecies().getParameters().get(i), part);
          final LightweightTypeReference typeTo = this._speADLUtils.getTypeRef(reference.getArguments().get(i));
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
    final LightweightTypeReference typeTo = this._speADLUtils.toLightweightTypeReference(p.getTypeReference(), p.eResource());
    final LightweightTypeReference typeFrom = this._speADLUtils.getOverridenPortTypeRef(p);
    if (((typeFrom != null) && (typeTo != null))) {
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
    final Function1<Part, Pair<ContentElement, String>> _function = (Part it) -> {
      String _name = it.getName();
      return Pair.<ContentElement, String>of(((ContentElement) it), _name);
    };
    List<Pair<ContentElement, String>> _map = ListExtensions.<Part, Pair<ContentElement, String>>map(ac.getParts(), _function);
    Iterables.<Pair<ContentElement, String>>addAll(names, _map);
    final Function1<ProvidedPort, Pair<ContentElement, String>> _function_1 = (ProvidedPort it) -> {
      String _name = it.getName();
      return Pair.<ContentElement, String>of(((ContentElement) it), _name);
    };
    List<Pair<ContentElement, String>> _map_1 = ListExtensions.<ProvidedPort, Pair<ContentElement, String>>map(ac.getProvides(), _function_1);
    Iterables.<Pair<ContentElement, String>>addAll(names, _map_1);
    final Function1<RequiredPort, Pair<ContentElement, String>> _function_2 = (RequiredPort it) -> {
      String _name = it.getName();
      return Pair.<ContentElement, String>of(((ContentElement) it), _name);
    };
    List<Pair<ContentElement, String>> _map_2 = ListExtensions.<RequiredPort, Pair<ContentElement, String>>map(ac.getRequires(), _function_2);
    Iterables.<Pair<ContentElement, String>>addAll(names, _map_2);
    final HashSet<Pair<ContentElement, String>> superNames = CollectionLiterals.<Pair<ContentElement, String>>newHashSet();
    final Function1<RequiredPort, Pair<ContentElement, String>> _function_3 = (RequiredPort it) -> {
      String _name = it.getName();
      return Pair.<ContentElement, String>of(((ContentElement) it), _name);
    };
    Iterable<Pair<ContentElement, String>> _map_3 = IterableExtensions.<RequiredPort, Pair<ContentElement, String>>map(this._speADLUtils.getAllRequires(ac), _function_3);
    Iterables.<Pair<ContentElement, String>>addAll(superNames, _map_3);
    final Function1<ProvidedPort, Pair<ContentElement, String>> _function_4 = (ProvidedPort it) -> {
      String _name = it.getName();
      return Pair.<ContentElement, String>of(((ContentElement) it), _name);
    };
    Iterable<Pair<ContentElement, String>> _map_4 = IterableExtensions.<ProvidedPort, Pair<ContentElement, String>>map(this._speADLUtils.getAllProvides(ac), _function_4);
    Iterables.<Pair<ContentElement, String>>addAll(superNames, _map_4);
    final Procedure2<Pair<ContentElement, String>, Integer> _function_5 = (Pair<ContentElement, String> pn, Integer index) -> {
      final ContentElement p = pn.getKey();
      final Function1<Pair<ContentElement, String>, Boolean> _function_6 = (Pair<ContentElement, String> it) -> {
        return Boolean.valueOf(((it.getKey() != p) && Objects.equal(it.getValue(), p.getName())));
      };
      boolean _exists = IterableExtensions.<Pair<ContentElement, String>>exists(names, _function_6);
      if (_exists) {
        String _name = p.getName();
        String _plus = ("Duplicate name \'" + _name);
        String _plus_1 = (_plus + "\'");
        this.error(_plus_1, p, SpeadlPackage.Literals.CONTENT_ELEMENT__NAME);
      } else {
        final Function1<Pair<ContentElement, String>, Boolean> _function_7 = (Pair<ContentElement, String> it) -> {
          return Boolean.valueOf(((it.getKey() != p) && Objects.equal(it.getValue(), p.getName())));
        };
        boolean _exists_1 = IterableExtensions.<Pair<ContentElement, String>>exists(superNames, _function_7);
        if (_exists_1) {
          String _name_1 = p.getName();
          String _plus_2 = ("Duplicate name \'" + _name_1);
          String _plus_3 = (_plus_2 + "\' in specialized component");
          this.error(_plus_3, p, SpeadlPackage.Literals.CONTENT_ELEMENT__NAME);
        }
      }
    };
    IterableExtensions.<Pair<ContentElement, String>>forEach(names, _function_5);
  }
  
  @Check
  public void checkSpecializeReference(final Ecosystem ecosystem) {
    final JvmParameterizedTypeReference superTypeRef = ecosystem.getSpecializes();
    if ((superTypeRef != null)) {
      final Ecosystem superType = this._speADLUtils.associatedEcosystem(superTypeRef.getType());
      if ((superType == null)) {
        String _simpleName = ecosystem.getSpecializes().getSimpleName();
        String _plus = (_simpleName + " cannot be resolved");
        this.error(_plus, ecosystem.getSpecializes(), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
      } else {
        boolean _isEmpty = superType.getParts().isEmpty();
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
        final Procedure2<RequiredPort, Integer> _function = (RequiredPort p, Integer index) -> {
          this.error("Requires can\'t be declared in a specialising component", SpeadlPackage.Literals.ABSTRACT_COMPONENT__REQUIRES, (index).intValue());
        };
        IterableExtensions.<RequiredPort>forEach(ecosystem.getRequires(), _function);
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
    final Ecosystem eco = this._speADLUtils.associatedEcosystem(p.getComponentReference().getType());
    if ((eco == null)) {
      String _simpleName = p.getComponentReference().getSimpleName();
      String _plus = (_simpleName + " cannot be resolved");
      this.error(_plus, p.getComponentReference(), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
    }
  }
  
  @Check
  public void checkTypeParameterForwardReferences(final AbstractComponent c) {
    this.doCheckTypeParameterForwardReference(c.getTypeParameters());
  }
  
  @Check
  @Override
  public void checkTypeParameterNotUsedInStaticContext(final JvmTypeReference ref) {
  }
}
