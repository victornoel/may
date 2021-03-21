package fr.irit.smac.may.speadl.jvmmodel;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import fr.irit.smac.may.speadl.SpeADLUtils;
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
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;

/**
 * <p>Infers a JVM model from the source model.</p>
 * 
 * <p>The JVM model should contain all elements that would appear in the Java code
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>
 */
@SuppressWarnings("all")
public class SpeADLJvmModelInferrer extends AbstractModelInferrer {
  public static final String REQUIRES_INTERFACE = "Requires";
  
  public static final String PROVIDES_INTERFACE = "Provides";
  
  public static final String REQUIRES_CLASS_PREFIX = "BridgeImpl";
  
  public static final String COMPONENT_INTERFACE = "Component";
  
  public static final String COMPONENT_CLASS = "ComponentImpl";
  
  public static final String PARTS_INTERFACE = "Parts";
  
  /**
   * convenience API to build and initialize JVM types and their members.
   */
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  @Extension
  private SpeADLUtils _speADLUtils;
  
  protected void _infer(final Ecosystem ecosystem, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    String _name = ecosystem.getName();
    boolean _tripleNotEquals = (_name != null);
    if (_tripleNotEquals) {
      final JvmGenericType clazz = this._jvmTypesBuilder.toClass(ecosystem, this._iQualifiedNameProvider.getFullyQualifiedName(ecosystem));
      this.initNowAbstractComponent(ecosystem, clazz, acceptor);
    }
  }
  
  public void initNowAbstractComponent(final AbstractComponent comp, final JvmGenericType clazz, final IJvmDeclaredTypeAcceptor acceptor) {
    boolean _notAbstract = this._speADLUtils.notAbstract(comp);
    boolean _not = (!_notAbstract);
    clazz.setAbstract(_not);
    Ecosystem _switchResult = null;
    boolean _matched = false;
    if (comp instanceof Ecosystem) {
      _matched=true;
      _switchResult = ((Ecosystem)comp);
    }
    if (!_matched) {
      if (comp instanceof Species) {
        _matched=true;
        _switchResult = this._speADLUtils.parentEcosystem(((Species)comp));
      }
    }
    final Ecosystem sourceParametersHolder = _switchResult;
    EList<JvmTypeParameter> _typeParameters = clazz.getTypeParameters();
    final Function1<JvmTypeParameter, JvmTypeParameter> _function = (JvmTypeParameter it) -> {
      return this._jvmTypesBuilder.<JvmTypeParameter>cloneWithProxies(it);
    };
    List<JvmTypeParameter> _map = ListExtensions.<JvmTypeParameter, JvmTypeParameter>map(sourceParametersHolder.getTypeParameters(), _function);
    this._jvmTypesBuilder.<JvmTypeParameter>operator_add(_typeParameters, _map);
    JvmParameterizedTypeReference _specializes = comp.getSpecializes();
    boolean _tripleEquals = (_specializes == null);
    if (_tripleEquals) {
      final Procedure1<JvmGenericType> _function_1 = (JvmGenericType it) -> {
        it.setStatic(true);
        EList<JvmTypeParameter> _typeParameters_1 = it.getTypeParameters();
        final Function1<JvmTypeParameter, JvmTypeParameter> _function_2 = (JvmTypeParameter it_1) -> {
          return this._jvmTypesBuilder.<JvmTypeParameter>cloneWithProxies(it_1);
        };
        List<JvmTypeParameter> _map_1 = ListExtensions.<JvmTypeParameter, JvmTypeParameter>map(sourceParametersHolder.getTypeParameters(), _function_2);
        this._jvmTypesBuilder.<JvmTypeParameter>operator_add(_typeParameters_1, _map_1);
      };
      final JvmGenericType requires = this._jvmTypesBuilder.toInterface(comp, SpeADLJvmModelInferrer.REQUIRES_INTERFACE, _function_1);
      EList<JvmMember> _members = clazz.getMembers();
      this._jvmTypesBuilder.<JvmGenericType>operator_add(_members, requires);
      final Procedure1<JvmGenericType> _function_2 = (JvmGenericType it) -> {
        this.initLaterRequires(comp, clazz, requires);
      };
      acceptor.<JvmGenericType>accept(requires, _function_2);
    }
    final Procedure1<JvmGenericType> _function_3 = (JvmGenericType it) -> {
      it.setStatic(true);
      EList<JvmTypeParameter> _typeParameters_1 = it.getTypeParameters();
      final Function1<JvmTypeParameter, JvmTypeParameter> _function_4 = (JvmTypeParameter it_1) -> {
        return this._jvmTypesBuilder.<JvmTypeParameter>cloneWithProxies(it_1);
      };
      List<JvmTypeParameter> _map_1 = ListExtensions.<JvmTypeParameter, JvmTypeParameter>map(sourceParametersHolder.getTypeParameters(), _function_4);
      this._jvmTypesBuilder.<JvmTypeParameter>operator_add(_typeParameters_1, _map_1);
    };
    final JvmGenericType componentClass = this._jvmTypesBuilder.toClass(comp, SpeADLJvmModelInferrer.COMPONENT_CLASS, _function_3);
    final Procedure1<JvmGenericType> _function_4 = (JvmGenericType it) -> {
      it.setStatic(true);
      EList<JvmTypeParameter> _typeParameters_1 = it.getTypeParameters();
      final Function1<JvmTypeParameter, JvmTypeParameter> _function_5 = (JvmTypeParameter it_1) -> {
        return this._jvmTypesBuilder.<JvmTypeParameter>cloneWithProxies(it_1);
      };
      List<JvmTypeParameter> _map_1 = ListExtensions.<JvmTypeParameter, JvmTypeParameter>map(sourceParametersHolder.getTypeParameters(), _function_5);
      this._jvmTypesBuilder.<JvmTypeParameter>operator_add(_typeParameters_1, _map_1);
    };
    final JvmGenericType parts = this._jvmTypesBuilder.toInterface(comp, SpeADLJvmModelInferrer.PARTS_INTERFACE, _function_4);
    final Procedure1<JvmGenericType> _function_5 = (JvmGenericType it) -> {
      it.setStatic(true);
      EList<JvmTypeParameter> _typeParameters_1 = it.getTypeParameters();
      final Function1<JvmTypeParameter, JvmTypeParameter> _function_6 = (JvmTypeParameter it_1) -> {
        return this._jvmTypesBuilder.<JvmTypeParameter>cloneWithProxies(it_1);
      };
      List<JvmTypeParameter> _map_1 = ListExtensions.<JvmTypeParameter, JvmTypeParameter>map(sourceParametersHolder.getTypeParameters(), _function_6);
      this._jvmTypesBuilder.<JvmTypeParameter>operator_add(_typeParameters_1, _map_1);
    };
    final JvmGenericType provides = this._jvmTypesBuilder.toInterface(comp, SpeADLJvmModelInferrer.PROVIDES_INTERFACE, _function_5);
    final Procedure1<JvmGenericType> _function_6 = (JvmGenericType it) -> {
      it.setStatic(true);
      EList<JvmTypeParameter> _typeParameters_1 = it.getTypeParameters();
      final Function1<JvmTypeParameter, JvmTypeParameter> _function_7 = (JvmTypeParameter it_1) -> {
        return this._jvmTypesBuilder.<JvmTypeParameter>cloneWithProxies(it_1);
      };
      List<JvmTypeParameter> _map_1 = ListExtensions.<JvmTypeParameter, JvmTypeParameter>map(sourceParametersHolder.getTypeParameters(), _function_7);
      this._jvmTypesBuilder.<JvmTypeParameter>operator_add(_typeParameters_1, _map_1);
    };
    final JvmGenericType componentIf = this._jvmTypesBuilder.toInterface(comp, SpeADLJvmModelInferrer.COMPONENT_INTERFACE, _function_6);
    EList<JvmMember> _members_1 = clazz.getMembers();
    this._jvmTypesBuilder.<JvmGenericType>operator_add(_members_1, componentIf);
    EList<JvmMember> _members_2 = clazz.getMembers();
    this._jvmTypesBuilder.<JvmGenericType>operator_add(_members_2, provides);
    EList<JvmMember> _members_3 = clazz.getMembers();
    this._jvmTypesBuilder.<JvmGenericType>operator_add(_members_3, parts);
    EList<JvmMember> _members_4 = clazz.getMembers();
    this._jvmTypesBuilder.<JvmGenericType>operator_add(_members_4, componentClass);
    final Procedure1<JvmGenericType> _function_7 = (JvmGenericType it) -> {
      this.initLaterProvides(comp, clazz, provides);
    };
    acceptor.<JvmGenericType>accept(provides, _function_7);
    final Procedure1<JvmGenericType> _function_8 = (JvmGenericType it) -> {
      this.initLaterComponent(comp, clazz, componentIf, provides);
    };
    acceptor.<JvmGenericType>accept(componentIf, _function_8);
    final Procedure1<JvmGenericType> _function_9 = (JvmGenericType it) -> {
      this.initLaterParts(comp, clazz, parts);
    };
    acceptor.<JvmGenericType>accept(parts, _function_9);
    final Procedure1<JvmGenericType> _function_10 = (JvmGenericType it) -> {
      this.initLaterComponentImpl(comp, clazz, componentClass);
    };
    acceptor.<JvmGenericType>accept(componentClass, _function_10);
    final Procedure1<JvmGenericType> _function_11 = (JvmGenericType it) -> {
      this.initLaterAbstractComponent(comp, clazz);
    };
    acceptor.<JvmGenericType>accept(clazz, _function_11);
    if ((comp instanceof Ecosystem)) {
      EList<Species> _species = ((Ecosystem)comp).getSpecies();
      for (final Species species : _species) {
        String _name = species.getName();
        boolean _tripleNotEquals = (_name != null);
        if (_tripleNotEquals) {
          final Procedure1<JvmGenericType> _function_12 = (JvmGenericType it) -> {
            it.setStatic(true);
          };
          final JvmGenericType sClazz = this._jvmTypesBuilder.toClass(species, species.getName(), _function_12);
          EList<JvmMember> _members_5 = clazz.getMembers();
          this._jvmTypesBuilder.<JvmGenericType>operator_add(_members_5, sClazz);
          this.initNowAbstractComponent(species, sClazz, acceptor);
        }
      }
    }
  }
  
  public void initLaterAbstractComponent(final AbstractComponent comp, final JvmGenericType clazz) {
    final EList<JvmTypeParameter> myTypeParameters = clazz.getTypeParameters();
    final StandardTypeParameterSubstitutor substitutor = this._speADLUtils.getSubstitutor(comp, clazz, comp.eResource());
    final Function1<JvmTypeParameter, EList<JvmTypeConstraint>> _function = (JvmTypeParameter it) -> {
      return it.getConstraints();
    };
    Iterable<JvmTypeConstraint> _flatten = Iterables.<JvmTypeConstraint>concat(ListExtensions.<JvmTypeParameter, EList<JvmTypeConstraint>>map(myTypeParameters, _function));
    for (final JvmTypeConstraint co : _flatten) {
      {
        final JvmTypeReference tr = this._speADLUtils.substituteWith(co.getTypeReference(), substitutor);
        co.setTypeReference(tr);
      }
    }
    JvmParameterizedTypeReference _specializes = comp.getSpecializes();
    boolean _tripleNotEquals = (_specializes != null);
    if (_tripleNotEquals) {
      final JvmTypeReference superType = this._speADLUtils.substituteWith(comp.getSpecializes(), substitutor);
      EList<JvmTypeReference> _superTypes = clazz.getSuperTypes();
      this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, superType);
    }
    final JvmTypeReference clazzRef = this._speADLUtils.getParameterizedTypeRefWith(clazz, myTypeParameters);
    final JvmTypeReference componentClassRef = this._speADLUtils.getInnerTypeReference(clazzRef, SpeADLJvmModelInferrer.COMPONENT_CLASS);
    final JvmTypeReference componentIfRef = this._speADLUtils.getInnerTypeReference(clazzRef, SpeADLJvmModelInferrer.COMPONENT_INTERFACE);
    final JvmTypeReference providesRef = this._speADLUtils.getInnerTypeReference(clazzRef, SpeADLJvmModelInferrer.PROVIDES_INTERFACE);
    final JvmTypeReference partsRef = this._speADLUtils.getInnerTypeReference(clazzRef, SpeADLJvmModelInferrer.PARTS_INTERFACE);
    JvmTypeReference _xifexpression = null;
    JvmParameterizedTypeReference _specializes_1 = comp.getSpecializes();
    boolean _tripleNotEquals_1 = (_specializes_1 != null);
    if (_tripleNotEquals_1) {
      _xifexpression = this._speADLUtils.rootSupertype(this._speADLUtils.substituteWith(comp.getSpecializes(), substitutor));
    } else {
      _xifexpression = clazzRef;
    }
    final JvmTypeReference requiresRef = this._speADLUtils.getInnerTypeReference(_xifexpression, SpeADLJvmModelInferrer.REQUIRES_INTERFACE);
    EList<JvmMember> _members = clazz.getMembers();
    final Procedure1<JvmField> _function_1 = (JvmField it) -> {
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("false;");
        }
      };
      this._jvmTypesBuilder.setInitializer(it, _client);
      it.setVisibility(JvmVisibility.PRIVATE);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Used to check that two components are not created from the same implementation,");
      _builder.newLine();
      _builder.append("that the component has been started to call requires(), provides() and parts()");
      _builder.newLine();
      _builder.append("and that the component is not started by hand.");
      _builder.newLine();
      this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
    };
    JvmField _field = this._jvmTypesBuilder.toField(comp, "init", this._typeReferenceBuilder.typeRef(boolean.class), _function_1);
    this._jvmTypesBuilder.<JvmField>operator_add(_members, _field);
    EList<JvmMember> _members_1 = clazz.getMembers();
    final Procedure1<JvmField> _function_2 = (JvmField it) -> {
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("false;");
        }
      };
      this._jvmTypesBuilder.setInitializer(it, _client);
      it.setVisibility(JvmVisibility.PRIVATE);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Used to check that the component is not started by hand.");
      _builder.newLine();
      this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
    };
    JvmField _field_1 = this._jvmTypesBuilder.toField(comp, "started", this._typeReferenceBuilder.typeRef(boolean.class), _function_2);
    this._jvmTypesBuilder.<JvmField>operator_add(_members_1, _field_1);
    EList<JvmMember> _members_2 = clazz.getMembers();
    final Procedure1<JvmField> _function_3 = (JvmField it) -> {
    };
    JvmField _field_2 = this._jvmTypesBuilder.toField(comp, "selfComponent", componentClassRef, _function_3);
    this._jvmTypesBuilder.<JvmField>operator_add(_members_2, _field_2);
    EList<JvmMember> _members_3 = clazz.getMembers();
    final Procedure1<JvmOperation> _function_4 = (JvmOperation it) -> {
      JvmParameterizedTypeReference _specializes_2 = comp.getSpecializes();
      boolean _tripleNotEquals_2 = (_specializes_2 != null);
      if (_tripleNotEquals_2) {
        EList<JvmAnnotationReference> _annotations = it.getAnnotations();
        JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
        this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      }
      it.setVisibility(JvmVisibility.PROTECTED);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Can be overridden by the implementation.");
      _builder.newLine();
      _builder.append("It will be called automatically after the component has been instantiated.");
      _builder.newLine();
      this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("if (!this.init || this.started) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("throw new RuntimeException(\"start() should not be called by hand: to create a new component, use newComponent().\");");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      this._jvmTypesBuilder.setBody(it, _client);
    };
    JvmOperation _method = this._jvmTypesBuilder.toMethod(comp, "start", this._typeReferenceBuilder.typeRef(void.class), _function_4);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_3, _method);
    EList<JvmMember> _members_4 = clazz.getMembers();
    final Procedure1<JvmOperation> _function_5 = (JvmOperation it) -> {
      JvmParameterizedTypeReference _specializes_2 = comp.getSpecializes();
      boolean _tripleNotEquals_2 = (_specializes_2 != null);
      if (_tripleNotEquals_2) {
        EList<JvmAnnotationReference> _annotations = it.getAnnotations();
        JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
        this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      }
      it.setVisibility(JvmVisibility.PROTECTED);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("This can be called by the implementation to access the provided ports.");
      _builder.newLine();
      this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("assert this.selfComponent != null: \"This is a bug.\";");
          _builder.newLine();
          _builder.append("if (!this.init) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("throw new RuntimeException(\"provides() can\'t be accessed until a component has been created from this implementation, use start() instead of the constructor if provides() is needed to initialise the component.\");");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          _builder.append("return this.selfComponent;");
          _builder.newLine();
        }
      };
      this._jvmTypesBuilder.setBody(it, _client);
    };
    JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(comp, "provides", providesRef, _function_5);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_4, _method_1);
    EList<ProvidedPort> _provides = comp.getProvides();
    for (final ProvidedPort port : _provides) {
      {
        LightweightTypeReference _overridenPortTypeRef = this._speADLUtils.getOverridenPortTypeRef(port);
        final boolean isOverride = (_overridenPortTypeRef != null);
        if (((port.getBound() == null) || isOverride)) {
          EList<JvmMember> _members_5 = clazz.getMembers();
          String _name = port.getName();
          String _plus = ("make_" + _name);
          final Procedure1<JvmOperation> _function_6 = (JvmOperation it) -> {
            it.setVisibility(JvmVisibility.PROTECTED);
            if (isOverride) {
              EList<JvmAnnotationReference> _annotations = it.getAnnotations();
              JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
              this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
            }
            PortRef _bound = port.getBound();
            boolean _tripleNotEquals_2 = (_bound != null);
            if (_tripleNotEquals_2) {
              it.setFinal(true);
              StringConcatenationClient _client = new StringConcatenationClient() {
                @Override
                protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                  _builder.append("throw new AssertionError(\"This is a bug\");");
                  _builder.newLine();
                }
              };
              this._jvmTypesBuilder.setBody(it, _client);
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("This will never be called because this component bind the provided port.");
              _builder.newLine();
              this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
            } else {
              it.setAbstract(true);
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("This should be overridden by the implementation to define the provided port.");
              _builder_1.newLine();
              _builder_1.append("This will be called once during the construction of the component to initialize the port.");
              _builder_1.newLine();
              this._jvmTypesBuilder.setDocumentation(it, _builder_1.toString());
            }
          };
          JvmOperation _method_2 = this._jvmTypesBuilder.toMethod(port, _plus, this._speADLUtils.substituteWith(port.getTypeReference(), substitutor), _function_6);
          this._jvmTypesBuilder.<JvmOperation>operator_add(_members_5, _method_2);
        }
      }
    }
    EList<JvmMember> _members_5 = clazz.getMembers();
    final Procedure1<JvmOperation> _function_6 = (JvmOperation it) -> {
      JvmParameterizedTypeReference _specializes_2 = comp.getSpecializes();
      boolean _tripleNotEquals_2 = (_specializes_2 != null);
      if (_tripleNotEquals_2) {
        EList<JvmAnnotationReference> _annotations = it.getAnnotations();
        JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
        this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      }
      it.setVisibility(JvmVisibility.PROTECTED);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("This can be called by the implementation to access the required ports.");
      _builder.newLine();
      this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("assert this.selfComponent != null: \"This is a bug.\";");
          _builder.newLine();
          _builder.append("if (!this.init) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("throw new RuntimeException(\"requires() can\'t be accessed until a component has been created from this implementation, use start() instead of the constructor if requires() is needed to initialise the component.\");");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          _builder.append("return this.selfComponent.bridge;");
          _builder.newLine();
        }
      };
      this._jvmTypesBuilder.setBody(it, _client);
    };
    JvmOperation _method_2 = this._jvmTypesBuilder.toMethod(comp, "requires", requiresRef, _function_6);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_5, _method_2);
    EList<JvmMember> _members_6 = clazz.getMembers();
    final Procedure1<JvmOperation> _function_7 = (JvmOperation it) -> {
      JvmParameterizedTypeReference _specializes_2 = comp.getSpecializes();
      boolean _tripleNotEquals_2 = (_specializes_2 != null);
      if (_tripleNotEquals_2) {
        EList<JvmAnnotationReference> _annotations = it.getAnnotations();
        JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
        this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      }
      it.setVisibility(JvmVisibility.PROTECTED);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("This can be called by the implementation to access the parts and their provided ports.");
      _builder.newLine();
      this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("assert this.selfComponent != null: \"This is a bug.\";");
          _builder.newLine();
          _builder.append("if (!this.init) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("throw new RuntimeException(\"parts() can\'t be accessed until a component has been created from this implementation, use start() instead of the constructor if parts() is needed to initialise the component.\");");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          _builder.append("return this.selfComponent;");
          _builder.newLine();
        }
      };
      this._jvmTypesBuilder.setBody(it, _client);
    };
    JvmOperation _method_3 = this._jvmTypesBuilder.toMethod(comp, "parts", partsRef, _function_7);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_6, _method_3);
    EList<Part> _parts = comp.getParts();
    for (final Part part : _parts) {
      {
        final JvmTypeReference ptr = this._speADLUtils.substituteWith(this._speADLUtils.typeReference(part), substitutor);
        boolean _matched = false;
        if (part instanceof ComponentPart) {
          _matched=true;
          EList<JvmMember> _members_7 = clazz.getMembers();
          String _name = ((ComponentPart)part).getName();
          String _plus = ("make_" + _name);
          final Procedure1<JvmOperation> _function_8 = (JvmOperation it) -> {
            it.setVisibility(JvmVisibility.PROTECTED);
            it.setAbstract(true);
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("This should be overridden by the implementation to define how to create this sub-component.");
            _builder.newLine();
            _builder.append("This will be called once during the construction of the component to initialize this sub-component.");
            _builder.newLine();
            this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
          };
          JvmOperation _method_4 = this._jvmTypesBuilder.toMethod(part, _plus, ptr, _function_8);
          this._jvmTypesBuilder.<JvmOperation>operator_add(_members_7, _method_4);
        }
        if (!_matched) {
          if (part instanceof SpeciesPart) {
            _matched=true;
            EList<JvmMember> _members_7 = clazz.getMembers();
            String _name = ((SpeciesPart)part).getName();
            String _plus = ("use_" + _name);
            final Procedure1<JvmField> _function_8 = (JvmField it) -> {
            };
            JvmField _field_3 = this._jvmTypesBuilder.toField(part, _plus, ptr, _function_8);
            this._jvmTypesBuilder.<JvmField>operator_add(_members_7, _field_3);
          }
        }
      }
    }
    EList<JvmMember> _members_7 = clazz.getMembers();
    final Procedure1<JvmOperation> _function_8 = (JvmOperation it) -> {
      JvmParameterizedTypeReference _specializes_2 = comp.getSpecializes();
      boolean _tripleNotEquals_2 = (_specializes_2 != null);
      if (_tripleNotEquals_2) {
        EList<JvmAnnotationReference> _annotations = it.getAnnotations();
        JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
        this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      }
      EList<JvmFormalParameter> _parameters = it.getParameters();
      JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(comp, "b", requiresRef);
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
      EList<JvmFormalParameter> _parameters_1 = it.getParameters();
      JvmFormalParameter _parameter_1 = this._jvmTypesBuilder.toParameter(comp, "start", this._typeReferenceBuilder.typeRef(boolean.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _parameter_1);
      it.setSynchronized(true);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Not meant to be used to manually instantiate components (except for testing).");
      _builder.newLine();
      this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("if (this.init) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("throw new RuntimeException(\"This instance of ");
          String _simpleName = clazz.getSimpleName();
          _builder.append(_simpleName, "\t");
          _builder.append(" has already been used to create a component, use another one.\");");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
          _builder.append("this.init = true;");
          _builder.newLine();
          _builder.append(componentClassRef);
          _builder.append("  _comp = new ");
          _builder.append(componentClassRef);
          _builder.append("(this, b, true);");
          _builder.newLineIfNotEmpty();
          _builder.append("if (start) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("_comp.start();");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          _builder.append("return _comp;");
          _builder.newLine();
        }
      };
      this._jvmTypesBuilder.setBody(it, _client);
    };
    JvmOperation _method_4 = this._jvmTypesBuilder.toMethod(comp, "_newComponent", componentIfRef, _function_8);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_7, _method_4);
    boolean _matched = false;
    if (comp instanceof Ecosystem) {
      _matched=true;
      EList<Species> _species = ((Ecosystem)comp).getSpecies();
      for (final Species species : _species) {
        {
          final JvmTypeReference str = this._speADLUtils.getParameterizedTypeRefWith(this._speADLUtils.getInnerType(clazz, species.getName()), myTypeParameters);
          boolean _notAbstract = this._speADLUtils.notAbstract(species);
          final boolean isAbstract = (!_notAbstract);
          EList<JvmMember> _members_8 = clazz.getMembers();
          String _name = species.getName();
          String _plus = ("make_" + _name);
          final Procedure1<JvmOperation> _function_9 = (JvmOperation it) -> {
            EList<JvmFormalParameter> _parameters = it.getParameters();
            final Function1<Feature, JvmFormalParameter> _function_10 = (Feature p) -> {
              return this._jvmTypesBuilder.toParameter(p, p.getName(), p.getParameterType());
            };
            List<JvmFormalParameter> _map = ListExtensions.<Feature, JvmFormalParameter>map(species.getParameters(), _function_10);
            this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _map);
            it.setVisibility(JvmVisibility.PROTECTED);
            it.setAbstract(isAbstract);
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("This should be overridden by the implementation to instantiate the implementation of the species.");
            _builder.newLine();
            this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
            if ((!isAbstract)) {
              StringConcatenationClient _client = new StringConcatenationClient() {
                @Override
                protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                  _builder.append("return new ");
                  _builder.append(str);
                  _builder.append("();");
                  _builder.newLineIfNotEmpty();
                }
              };
              this._jvmTypesBuilder.setBody(it, _client);
            }
          };
          JvmOperation _method_5 = this._jvmTypesBuilder.toMethod(species, _plus, str, _function_9);
          this._jvmTypesBuilder.<JvmOperation>operator_add(_members_8, _method_5);
          EList<JvmMember> _members_9 = clazz.getMembers();
          String _name_1 = species.getName();
          String _plus_1 = ("_createImplementationOf" + _name_1);
          final Procedure1<JvmOperation> _function_10 = (JvmOperation it) -> {
            EList<JvmFormalParameter> _parameters = it.getParameters();
            final Function1<Feature, JvmFormalParameter> _function_11 = (Feature p) -> {
              return this._jvmTypesBuilder.toParameter(p, p.getName(), p.getParameterType());
            };
            List<JvmFormalParameter> _map = ListExtensions.<Feature, JvmFormalParameter>map(species.getParameters(), _function_11);
            this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _map);
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Do not call, used by generated code.");
            _builder.newLine();
            this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
            final JvmOperation m = it;
            final Procedure1<ITreeAppendable> _function_12 = (ITreeAppendable it_1) -> {
              it_1.append(this._speADLUtils.toLightweightTypeReference(str, clazz.eResource()));
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append(" ");
              String _declareSyntheticVariable = it_1.declareSyntheticVariable(m, "implem");
              _builder_1.append(_declareSyntheticVariable, " ");
              _builder_1.append(" = make_");
              String _name_2 = species.getName();
              _builder_1.append(_name_2, " ");
              _builder_1.append("(");
              final Function1<Feature, String> _function_13 = (Feature it_2) -> {
                return it_2.getName();
              };
              String _join = IterableExtensions.join(ListExtensions.<Feature, String>map(species.getParameters(), _function_13), ",");
              _builder_1.append(_join, " ");
              _builder_1.append(");");
              _builder_1.newLineIfNotEmpty();
              it_1.append(_builder_1);
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append("if (");
              String _name_3 = it_1.getName(m);
              _builder_2.append(_name_3);
              _builder_2.append(" == null) {");
              _builder_2.newLineIfNotEmpty();
              _builder_2.append("\t");
              _builder_2.append("throw new RuntimeException(\"make_");
              String _name_4 = species.getName();
              _builder_2.append(_name_4, "\t");
              _builder_2.append("() in ");
              String _qualifiedName = clazz.getQualifiedName();
              _builder_2.append(_qualifiedName, "\t");
              _builder_2.append(" should not return null.\");");
              _builder_2.newLineIfNotEmpty();
              _builder_2.append("}");
              _builder_2.newLine();
              _builder_2.append("assert ");
              String _name_5 = it_1.getName(m);
              _builder_2.append(_name_5);
              _builder_2.append(".ecosystemComponent == null: \"This is a bug.\";");
              _builder_2.newLineIfNotEmpty();
              _builder_2.append("assert this.selfComponent != null: \"This is a bug.\";");
              _builder_2.newLine();
              String _name_6 = it_1.getName(m);
              _builder_2.append(_name_6);
              _builder_2.append(".ecosystemComponent = this.selfComponent;");
              _builder_2.newLineIfNotEmpty();
              it_1.append(_builder_2);
              Iterable<SpeciesPart> _filter = Iterables.<SpeciesPart>filter(species.getParts(), SpeciesPart.class);
              for (final SpeciesPart use : _filter) {
                StringConcatenation _builder_3 = new StringConcatenation();
                _builder_3.append("assert this.selfComponent.implem_");
                String _name_7 = use.getSpeciesReference().getPart().getName();
                _builder_3.append(_name_7);
                _builder_3.append(" != null: \"This is a bug.\";");
                _builder_3.newLineIfNotEmpty();
                _builder_3.append("assert ");
                String _name_8 = it_1.getName(m);
                _builder_3.append(_name_8);
                _builder_3.append(".use_");
                String _name_9 = use.getName();
                _builder_3.append(_name_9);
                _builder_3.append(" == null: \"This is a bug.\";");
                _builder_3.newLineIfNotEmpty();
                String _name_10 = it_1.getName(m);
                _builder_3.append(_name_10);
                _builder_3.append(".use_");
                String _name_11 = use.getName();
                _builder_3.append(_name_11);
                _builder_3.append(" = this.selfComponent.implem_");
                String _name_12 = use.getSpeciesReference().getPart().getName();
                _builder_3.append(_name_12);
                _builder_3.append("._createImplementationOf");
                String _name_13 = use.getSpeciesReference().getSpecies().getName();
                _builder_3.append(_name_13);
                _builder_3.append("(");
                final Function1<Feature, String> _function_14 = (Feature it_2) -> {
                  return it_2.getName();
                };
                String _join_1 = IterableExtensions.join(ListExtensions.<Feature, String>map(use.getSpeciesReference().getArguments(), _function_14), ",");
                _builder_3.append(_join_1);
                _builder_3.append(");");
                _builder_3.newLineIfNotEmpty();
                it_1.append(_builder_3);
              }
              StringConcatenation _builder_4 = new StringConcatenation();
              _builder_4.append("return ");
              String _name_14 = it_1.getName(m);
              _builder_4.append(_name_14);
              _builder_4.append(";");
              it_1.append(_builder_4);
            };
            this._jvmTypesBuilder.setBody(it, _function_12);
          };
          JvmOperation _method_6 = this._jvmTypesBuilder.toMethod(species, _plus_1, str, _function_10);
          this._jvmTypesBuilder.<JvmOperation>operator_add(_members_9, _method_6);
          boolean _isEmpty = IterableExtensions.isEmpty(this._speADLUtils.getAllRequires(species));
          if (_isEmpty) {
            EList<JvmMember> _members_10 = clazz.getMembers();
            String _name_2 = species.getName();
            String _plus_2 = ("new" + _name_2);
            final Procedure1<JvmOperation> _function_11 = (JvmOperation it) -> {
              EList<JvmFormalParameter> _parameters = it.getParameters();
              final Function1<Feature, JvmFormalParameter> _function_12 = (Feature p) -> {
                return this._jvmTypesBuilder.toParameter(p, p.getName(), p.getParameterType());
              };
              List<JvmFormalParameter> _map = ListExtensions.<Feature, JvmFormalParameter>map(species.getParameters(), _function_12);
              this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _map);
              it.setVisibility(JvmVisibility.PROTECTED);
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("This can be called to create an instance of the species from inside the implementation of the ecosystem.");
              _builder.newLine();
              this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
              StringConcatenationClient _client = new StringConcatenationClient() {
                @Override
                protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                  _builder.append(str);
                  _builder.append(" _implem = _createImplementationOf");
                  String _name = species.getName();
                  _builder.append(_name);
                  _builder.append("(");
                  final Function1<Feature, String> _function = (Feature it_1) -> {
                    return it_1.getName();
                  };
                  String _join = IterableExtensions.join(ListExtensions.<Feature, String>map(species.getParameters(), _function), ",");
                  _builder.append(_join);
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("return _implem._newComponent(new ");
                  JvmTypeReference _innerTypeReference = SpeADLJvmModelInferrer.this._speADLUtils.getInnerTypeReference(str, SpeADLJvmModelInferrer.REQUIRES_INTERFACE);
                  _builder.append(_innerTypeReference);
                  _builder.append("() {},true);");
                  _builder.newLineIfNotEmpty();
                }
              };
              this._jvmTypesBuilder.setBody(it, _client);
            };
            JvmOperation _method_7 = this._jvmTypesBuilder.toMethod(species, _plus_2, this._speADLUtils.getInnerTypeReference(str, SpeADLJvmModelInferrer.COMPONENT_INTERFACE), _function_11);
            this._jvmTypesBuilder.<JvmOperation>operator_add(_members_10, _method_7);
          }
        }
      }
      boolean _isEmpty = IterableExtensions.isEmpty(this._speADLUtils.getAllRequires(comp));
      if (_isEmpty) {
        EList<JvmMember> _members_8 = clazz.getMembers();
        final Procedure1<JvmOperation> _function_9 = (JvmOperation it) -> {
          JvmParameterizedTypeReference _specializes_2 = ((Ecosystem)comp).getSpecializes();
          boolean _tripleNotEquals_2 = (_specializes_2 != null);
          if (_tripleNotEquals_2) {
            EList<JvmAnnotationReference> _annotations = it.getAnnotations();
            JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
            this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
          }
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Use to instantiate a component from this implementation.");
          _builder.newLine();
          this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("return this._newComponent(new ");
              _builder.append(requiresRef);
              _builder.append("() {}, true);");
              _builder.newLineIfNotEmpty();
            }
          };
          this._jvmTypesBuilder.setBody(it, _client);
        };
        JvmOperation _method_5 = this._jvmTypesBuilder.toMethod(comp, "newComponent", componentIfRef, _function_9);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_8, _method_5);
      }
    }
    if (!_matched) {
      if (comp instanceof Species) {
        _matched=true;
        final Ecosystem parentEco = this._speADLUtils.parentEcosystem(((Species)comp));
        final JvmTypeReference parentRef = this._speADLUtils.getParameterizedTypeRefWith(this._speADLUtils.associatedJvmClass(parentEco), myTypeParameters);
        EList<JvmMember> _members_8 = clazz.getMembers();
        final Procedure1<JvmField> _function_9 = (JvmField it) -> {
        };
        JvmField _field_3 = this._jvmTypesBuilder.toField(comp, "ecosystemComponent", this._speADLUtils.getInnerTypeReference(parentRef, SpeADLJvmModelInferrer.COMPONENT_CLASS), _function_9);
        this._jvmTypesBuilder.<JvmField>operator_add(_members_8, _field_3);
        EList<JvmMember> _members_9 = clazz.getMembers();
        final Procedure1<JvmOperation> _function_10 = (JvmOperation it) -> {
          it.setVisibility(JvmVisibility.PROTECTED);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("This can be called by the species implementation to access the provided ports of its ecosystem.");
          _builder.newLine();
          this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("assert this.ecosystemComponent != null: \"This is a bug.\";");
              _builder.newLine();
              _builder.append("return this.ecosystemComponent;");
              _builder.newLine();
            }
          };
          this._jvmTypesBuilder.setBody(it, _client);
        };
        JvmOperation _method_5 = this._jvmTypesBuilder.toMethod(parentEco, "eco_provides", this._speADLUtils.getInnerTypeReference(parentRef, SpeADLJvmModelInferrer.PROVIDES_INTERFACE), _function_10);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_9, _method_5);
        EList<JvmMember> _members_10 = clazz.getMembers();
        final Procedure1<JvmOperation> _function_11 = (JvmOperation it) -> {
          it.setVisibility(JvmVisibility.PROTECTED);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("This can be called by the species implementation to access the required ports of its ecosystem.");
          _builder.newLine();
          this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("assert this.ecosystemComponent != null: \"This is a bug.\";");
              _builder.newLine();
              _builder.append("return this.ecosystemComponent.bridge;");
              _builder.newLine();
            }
          };
          this._jvmTypesBuilder.setBody(it, _client);
        };
        JvmOperation _method_6 = this._jvmTypesBuilder.toMethod(parentEco, "eco_requires", this._speADLUtils.getInnerTypeReference(this._speADLUtils.rootSupertype(parentRef), SpeADLJvmModelInferrer.REQUIRES_INTERFACE), _function_11);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_10, _method_6);
        EList<JvmMember> _members_11 = clazz.getMembers();
        final Procedure1<JvmOperation> _function_12 = (JvmOperation it) -> {
          it.setVisibility(JvmVisibility.PROTECTED);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("This can be called by the species implementation to access the parts of its ecosystem and their provided ports.");
          _builder.newLine();
          this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("assert this.ecosystemComponent != null: \"This is a bug.\";");
              _builder.newLine();
              _builder.append("return this.ecosystemComponent;");
              _builder.newLine();
            }
          };
          this._jvmTypesBuilder.setBody(it, _client);
        };
        JvmOperation _method_7 = this._jvmTypesBuilder.toMethod(parentEco, "eco_parts", this._speADLUtils.getInnerTypeReference(parentRef, SpeADLJvmModelInferrer.PARTS_INTERFACE), _function_12);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_11, _method_7);
      }
    }
  }
  
  public void initLaterRequires(final AbstractComponent comp, final JvmGenericType clazz, final JvmGenericType requires) {
    final StandardTypeParameterSubstitutor substitutor = this._speADLUtils.getSubstitutor(comp, requires, comp.eResource());
    final Function1<JvmTypeParameter, EList<JvmTypeConstraint>> _function = (JvmTypeParameter it) -> {
      return it.getConstraints();
    };
    Iterable<JvmTypeConstraint> _flatten = Iterables.<JvmTypeConstraint>concat(ListExtensions.<JvmTypeParameter, EList<JvmTypeConstraint>>map(requires.getTypeParameters(), _function));
    for (final JvmTypeConstraint c : _flatten) {
      {
        final JvmTypeReference tr = this._speADLUtils.substituteWith(c.getTypeReference(), substitutor);
        c.setTypeReference(tr);
      }
    }
    EList<RequiredPort> _requires = comp.getRequires();
    for (final RequiredPort port : _requires) {
      EList<JvmMember> _members = requires.getMembers();
      final Procedure1<JvmOperation> _function_1 = (JvmOperation it) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("This can be called by the implementation to access this required port.");
        _builder.newLine();
        this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
        it.setAbstract(true);
      };
      JvmOperation _method = this._jvmTypesBuilder.toMethod(port, port.getName(), this._speADLUtils.substituteWith(port.getTypeReference(), substitutor), _function_1);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
    }
  }
  
  public void initLaterProvides(final AbstractComponent comp, final JvmGenericType clazz, final JvmGenericType provides) {
    final StandardTypeParameterSubstitutor substitutor = this._speADLUtils.getSubstitutor(comp, provides, comp.eResource());
    final Function1<JvmTypeParameter, EList<JvmTypeConstraint>> _function = (JvmTypeParameter it) -> {
      return it.getConstraints();
    };
    Iterable<JvmTypeConstraint> _flatten = Iterables.<JvmTypeConstraint>concat(ListExtensions.<JvmTypeParameter, EList<JvmTypeConstraint>>map(provides.getTypeParameters(), _function));
    for (final JvmTypeConstraint c : _flatten) {
      {
        final JvmTypeReference tr = this._speADLUtils.substituteWith(c.getTypeReference(), substitutor);
        c.setTypeReference(tr);
      }
    }
    JvmParameterizedTypeReference _specializes = comp.getSpecializes();
    boolean _tripleNotEquals = (_specializes != null);
    if (_tripleNotEquals) {
      final JvmTypeReference nstr = this._speADLUtils.substituteWith(comp.getSpecializes(), substitutor);
      EList<JvmTypeReference> _superTypes = provides.getSuperTypes();
      JvmTypeReference _innerTypeReference = this._speADLUtils.getInnerTypeReference(nstr, SpeADLJvmModelInferrer.PROVIDES_INTERFACE);
      this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _innerTypeReference);
    }
    EList<ProvidedPort> _provides = comp.getProvides();
    for (final ProvidedPort port : _provides) {
      EList<JvmMember> _members = provides.getMembers();
      final Procedure1<JvmOperation> _function_1 = (JvmOperation it) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("This can be called to access the provided port.");
        _builder.newLine();
        this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
        it.setAbstract(true);
      };
      JvmOperation _method = this._jvmTypesBuilder.toMethod(port, port.getName(), this._speADLUtils.substituteWith(port.getTypeReference(), substitutor), _function_1);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
    }
  }
  
  public void initLaterParts(final AbstractComponent comp, final JvmGenericType clazz, final JvmGenericType parts) {
    final StandardTypeParameterSubstitutor substitutor = this._speADLUtils.getSubstitutor(comp, parts, comp.eResource());
    final Function1<JvmTypeParameter, EList<JvmTypeConstraint>> _function = (JvmTypeParameter it) -> {
      return it.getConstraints();
    };
    Iterable<JvmTypeConstraint> _flatten = Iterables.<JvmTypeConstraint>concat(ListExtensions.<JvmTypeParameter, EList<JvmTypeConstraint>>map(parts.getTypeParameters(), _function));
    for (final JvmTypeConstraint c : _flatten) {
      {
        final JvmTypeReference tr = this._speADLUtils.substituteWith(c.getTypeReference(), substitutor);
        c.setTypeReference(tr);
      }
    }
    JvmParameterizedTypeReference _specializes = comp.getSpecializes();
    boolean _tripleNotEquals = (_specializes != null);
    if (_tripleNotEquals) {
      final JvmTypeReference nstr = this._speADLUtils.substituteWith(comp.getSpecializes(), substitutor);
      EList<JvmTypeReference> _superTypes = parts.getSuperTypes();
      JvmTypeReference _innerTypeReference = this._speADLUtils.getInnerTypeReference(nstr, SpeADLJvmModelInferrer.PARTS_INTERFACE);
      this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _innerTypeReference);
    }
    EList<Part> _parts = comp.getParts();
    for (final Part part : _parts) {
      {
        final JvmTypeReference nptr = this._speADLUtils.substituteWith(this._speADLUtils.typeReference(part), substitutor);
        EList<JvmMember> _members = parts.getMembers();
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it) -> {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("This can be called by the implementation to access the part and its provided ports.");
          _builder.newLine();
          _builder.append("It will be initialized after the required ports are initialized and before the provided ports are initialized.");
          _builder.newLine();
          this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
          it.setAbstract(true);
        };
        JvmOperation _method = this._jvmTypesBuilder.toMethod(part, part.getName(), this._speADLUtils.getInnerTypeReference(nptr, SpeADLJvmModelInferrer.COMPONENT_INTERFACE), _function_1);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
      }
    }
  }
  
  public void initLaterComponent(final AbstractComponent comp, final JvmGenericType clazz, final JvmGenericType componentIf, final JvmGenericType provides) {
    final StandardTypeParameterSubstitutor substitutor = this._speADLUtils.getSubstitutor(comp, componentIf, comp.eResource());
    final Function1<JvmTypeParameter, EList<JvmTypeConstraint>> _function = (JvmTypeParameter it) -> {
      return it.getConstraints();
    };
    Iterable<JvmTypeConstraint> _flatten = Iterables.<JvmTypeConstraint>concat(ListExtensions.<JvmTypeParameter, EList<JvmTypeConstraint>>map(componentIf.getTypeParameters(), _function));
    for (final JvmTypeConstraint c : _flatten) {
      {
        final JvmTypeReference tr = this._speADLUtils.substituteWith(c.getTypeReference(), substitutor);
        c.setTypeReference(tr);
      }
    }
    JvmParameterizedTypeReference _specializes = comp.getSpecializes();
    boolean _tripleNotEquals = (_specializes != null);
    if (_tripleNotEquals) {
      final JvmTypeReference nstr = this._speADLUtils.substituteWith(comp.getSpecializes(), substitutor);
      EList<JvmTypeReference> _superTypes = componentIf.getSuperTypes();
      JvmTypeReference _innerTypeReference = this._speADLUtils.getInnerTypeReference(nstr, SpeADLJvmModelInferrer.COMPONENT_INTERFACE);
      this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _innerTypeReference);
    }
    EList<JvmTypeReference> _superTypes_1 = componentIf.getSuperTypes();
    JvmTypeReference _parameterizedTypeRefWith = this._speADLUtils.getParameterizedTypeRefWith(provides, componentIf.getTypeParameters());
    this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes_1, _parameterizedTypeRefWith);
  }
  
  public void initLaterComponentImpl(final AbstractComponent comp, final JvmGenericType clazz, final JvmGenericType componentClass) {
    final JvmTypeReference clazzRef = this._speADLUtils.getParameterizedTypeRefWith(clazz, componentClass.getTypeParameters());
    final StandardTypeParameterSubstitutor substitutor = this._speADLUtils.getSubstitutor(comp, componentClass, comp.eResource());
    final Function1<JvmTypeParameter, EList<JvmTypeConstraint>> _function = (JvmTypeParameter it) -> {
      return it.getConstraints();
    };
    Iterable<JvmTypeConstraint> _flatten = Iterables.<JvmTypeConstraint>concat(ListExtensions.<JvmTypeParameter, EList<JvmTypeConstraint>>map(componentClass.getTypeParameters(), _function));
    for (final JvmTypeConstraint c : _flatten) {
      {
        final JvmTypeReference tr = this._speADLUtils.substituteWith(c.getTypeReference(), substitutor);
        c.setTypeReference(tr);
      }
    }
    JvmParameterizedTypeReference _specializes = comp.getSpecializes();
    boolean _tripleNotEquals = (_specializes != null);
    if (_tripleNotEquals) {
      final JvmTypeReference nstr = this._speADLUtils.substituteWith(comp.getSpecializes(), substitutor);
      EList<JvmTypeReference> _superTypes = componentClass.getSuperTypes();
      JvmTypeReference _innerTypeReference = this._speADLUtils.getInnerTypeReference(nstr, SpeADLJvmModelInferrer.COMPONENT_CLASS);
      this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _innerTypeReference);
    }
    EList<JvmTypeReference> _superTypes_1 = componentClass.getSuperTypes();
    JvmTypeReference _innerTypeReference_1 = this._speADLUtils.getInnerTypeReference(clazzRef, SpeADLJvmModelInferrer.COMPONENT_INTERFACE);
    this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes_1, _innerTypeReference_1);
    EList<JvmTypeReference> _superTypes_2 = componentClass.getSuperTypes();
    JvmTypeReference _innerTypeReference_2 = this._speADLUtils.getInnerTypeReference(clazzRef, SpeADLJvmModelInferrer.PARTS_INTERFACE);
    this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes_2, _innerTypeReference_2);
    JvmTypeReference _xifexpression = null;
    JvmParameterizedTypeReference _specializes_1 = comp.getSpecializes();
    boolean _tripleNotEquals_1 = (_specializes_1 != null);
    if (_tripleNotEquals_1) {
      _xifexpression = this._speADLUtils.rootSupertype(this._speADLUtils.substituteWith(comp.getSpecializes(), substitutor));
    } else {
      _xifexpression = clazzRef;
    }
    final JvmTypeReference requiresRef = this._speADLUtils.getInnerTypeReference(_xifexpression, SpeADLJvmModelInferrer.REQUIRES_INTERFACE);
    EList<JvmMember> _members = componentClass.getMembers();
    final Procedure1<JvmField> _function_1 = (JvmField it) -> {
      it.setFinal(true);
    };
    JvmField _field = this._jvmTypesBuilder.toField(comp, "bridge", requiresRef, _function_1);
    this._jvmTypesBuilder.<JvmField>operator_add(_members, _field);
    EList<JvmMember> _members_1 = componentClass.getMembers();
    final Procedure1<JvmField> _function_2 = (JvmField it) -> {
      it.setFinal(true);
    };
    JvmField _field_1 = this._jvmTypesBuilder.toField(comp, "implementation", clazzRef, _function_2);
    this._jvmTypesBuilder.<JvmField>operator_add(_members_1, _field_1);
    EList<JvmMember> _members_2 = componentClass.getMembers();
    final Procedure1<JvmOperation> _function_3 = (JvmOperation it) -> {
      JvmParameterizedTypeReference _specializes_2 = comp.getSpecializes();
      boolean _tripleNotEquals_2 = (_specializes_2 != null);
      if (_tripleNotEquals_2) {
        EList<JvmAnnotationReference> _annotations = it.getAnnotations();
        JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
        this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      }
      it.setVisibility(JvmVisibility.PUBLIC);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          {
            JvmParameterizedTypeReference _specializes = comp.getSpecializes();
            boolean _tripleNotEquals = (_specializes != null);
            if (_tripleNotEquals) {
              _builder.append("super.start();");
              _builder.newLine();
            }
          }
          {
            EList<Part> _parts = comp.getParts();
            for(final Part part : _parts) {
              _builder.append("assert this.");
              String _name = part.getName();
              _builder.append(_name);
              _builder.append(" != null: \"This is a bug.\";");
              _builder.newLineIfNotEmpty();
              _builder.append("((");
              JvmTypeReference _innerTypeReference = SpeADLJvmModelInferrer.this._speADLUtils.getInnerTypeReference(SpeADLJvmModelInferrer.this._speADLUtils.substituteWith(SpeADLJvmModelInferrer.this._speADLUtils.typeReference(part), substitutor), SpeADLJvmModelInferrer.COMPONENT_CLASS);
              _builder.append(_innerTypeReference);
              _builder.append(") this.");
              String _name_1 = part.getName();
              _builder.append(_name_1);
              _builder.append(").start();");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("this.implementation.start();");
          _builder.newLine();
          _builder.append("this.implementation.started = true;");
          _builder.newLine();
        }
      };
      this._jvmTypesBuilder.setBody(it, _client);
    };
    JvmOperation _method = this._jvmTypesBuilder.toMethod(comp, "start", this._typeReferenceBuilder.typeRef(void.class), _function_3);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _method);
    EList<Part> _parts = comp.getParts();
    for (final Part part : _parts) {
      EList<JvmMember> _members_3 = componentClass.getMembers();
      String _name = part.getName();
      String _plus = ("init_" + _name);
      final Procedure1<JvmOperation> _function_4 = (JvmOperation it) -> {
        it.setVisibility(JvmVisibility.PRIVATE);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("assert this.");
            String _name = part.getName();
            _builder.append(_name);
            _builder.append(" == null: \"This is a bug.\";");
            _builder.newLineIfNotEmpty();
            {
              if ((part instanceof ComponentPart)) {
                _builder.append("assert this.implem_");
                String _name_1 = ((ComponentPart)part).getName();
                _builder.append(_name_1);
                _builder.append(" == null: \"This is a bug.\";");
                _builder.newLineIfNotEmpty();
                _builder.append("this.implem_");
                String _name_2 = ((ComponentPart)part).getName();
                _builder.append(_name_2);
                _builder.append(" = this.implementation.make_");
                String _name_3 = ((ComponentPart)part).getName();
                _builder.append(_name_3);
                _builder.append("();");
                _builder.newLineIfNotEmpty();
                _builder.append("if (this.implem_");
                String _name_4 = ((ComponentPart)part).getName();
                _builder.append(_name_4);
                _builder.append(" == null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("throw new RuntimeException(\"make_");
                String _name_5 = ((ComponentPart)part).getName();
                _builder.append(_name_5, "\t");
                _builder.append("() in ");
                String _qualifiedName = clazzRef.getQualifiedName();
                _builder.append(_qualifiedName, "\t");
                _builder.append(" should not return null.\");");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
                _builder.append("this.");
                String _name_6 = ((ComponentPart)part).getName();
                _builder.append(_name_6);
                _builder.append(" = this.implem_");
                String _name_7 = ((ComponentPart)part).getName();
                _builder.append(_name_7);
                _builder.append("._newComponent(new ");
                _builder.append(SpeADLJvmModelInferrer.REQUIRES_CLASS_PREFIX);
                _builder.append("_");
                String _name_8 = ((ComponentPart)part).getName();
                _builder.append(_name_8);
                _builder.append("(), false);");
                _builder.newLineIfNotEmpty();
              } else {
                if ((part instanceof SpeciesPart)) {
                  _builder.append("assert this.implementation.use_");
                  String _name_9 = ((SpeciesPart)part).getName();
                  _builder.append(_name_9);
                  _builder.append(" != null: \"This is a bug.\";");
                  _builder.newLineIfNotEmpty();
                  _builder.append("this.");
                  String _name_10 = ((SpeciesPart)part).getName();
                  _builder.append(_name_10);
                  _builder.append(" = this.implementation.use_");
                  String _name_11 = ((SpeciesPart)part).getName();
                  _builder.append(_name_11);
                  _builder.append("._newComponent(new ");
                  _builder.append(SpeADLJvmModelInferrer.REQUIRES_CLASS_PREFIX);
                  _builder.append("_");
                  String _name_12 = ((SpeciesPart)part).getSpeciesReference().getPart().getName();
                  _builder.append(_name_12);
                  _builder.append("_");
                  String _name_13 = ((SpeciesPart)part).getName();
                  _builder.append(_name_13);
                  _builder.append("(), false);");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        };
        this._jvmTypesBuilder.setBody(it, _client);
      };
      JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(part, _plus, this._typeReferenceBuilder.typeRef(void.class), _function_4);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members_3, _method_1);
    }
    EList<JvmMember> _members_4 = componentClass.getMembers();
    final Procedure1<JvmOperation> _function_5 = (JvmOperation it) -> {
      JvmParameterizedTypeReference _specializes_2 = comp.getSpecializes();
      boolean _tripleNotEquals_2 = (_specializes_2 != null);
      if (_tripleNotEquals_2) {
        EList<JvmAnnotationReference> _annotations = it.getAnnotations();
        JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
        this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      }
      it.setVisibility(JvmVisibility.PROTECTED);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          {
            JvmParameterizedTypeReference _specializes = comp.getSpecializes();
            boolean _tripleNotEquals = (_specializes != null);
            if (_tripleNotEquals) {
              _builder.append("super.initParts();");
              _builder.newLine();
            }
          }
          {
            EList<Part> _parts = comp.getParts();
            for(final Part part : _parts) {
              _builder.append("init_");
              String _name = part.getName();
              _builder.append(_name);
              _builder.append("();");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      };
      this._jvmTypesBuilder.setBody(it, _client);
    };
    JvmOperation _method_2 = this._jvmTypesBuilder.toMethod(comp, "initParts", this._typeReferenceBuilder.typeRef(void.class), _function_5);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_4, _method_2);
    EList<ProvidedPort> _provides = comp.getProvides();
    for (final ProvidedPort port : _provides) {
      {
        LightweightTypeReference _overridenPortTypeRef = this._speADLUtils.getOverridenPortTypeRef(port);
        final boolean isOverride = (_overridenPortTypeRef != null);
        EList<JvmMember> _members_5 = componentClass.getMembers();
        String _name_1 = port.getName();
        String _plus_1 = ("init_" + _name_1);
        final Procedure1<JvmOperation> _function_6 = (JvmOperation it) -> {
          it.setVisibility(JvmVisibility.PROTECTED);
          if (isOverride) {
            EList<JvmAnnotationReference> _annotations = it.getAnnotations();
            JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
            this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
          }
          PortRef _bound = port.getBound();
          boolean _tripleEquals = (_bound == null);
          if (_tripleEquals) {
            StringConcatenationClient _client = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                _builder.append("assert this.");
                String _name = port.getName();
                _builder.append(_name);
                _builder.append(" == null: \"This is a bug.\";");
                _builder.newLineIfNotEmpty();
                _builder.append("this.");
                String _name_1 = port.getName();
                _builder.append(_name_1);
                _builder.append(" = this.implementation.make_");
                String _name_2 = port.getName();
                _builder.append(_name_2);
                _builder.append("();");
                _builder.newLineIfNotEmpty();
                _builder.append("if (this.");
                String _name_3 = port.getName();
                _builder.append(_name_3);
                _builder.append(" == null) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("throw new RuntimeException(\"make_");
                String _name_4 = port.getName();
                _builder.append(_name_4, "\t");
                _builder.append("() in ");
                String _qualifiedName = clazzRef.getQualifiedName();
                _builder.append(_qualifiedName, "\t");
                _builder.append(" shall not return null.\");");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
              }
            };
            this._jvmTypesBuilder.setBody(it, _client);
          } else {
            StringConcatenationClient _client_1 = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                _builder.append("// nothing to do here");
                _builder.newLine();
              }
            };
            this._jvmTypesBuilder.setBody(it, _client_1);
          }
        };
        JvmOperation _method_3 = this._jvmTypesBuilder.toMethod(port, _plus_1, this._typeReferenceBuilder.typeRef(void.class), _function_6);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_5, _method_3);
      }
    }
    EList<JvmMember> _members_5 = componentClass.getMembers();
    final Procedure1<JvmOperation> _function_6 = (JvmOperation it) -> {
      JvmParameterizedTypeReference _specializes_2 = comp.getSpecializes();
      boolean _tripleNotEquals_2 = (_specializes_2 != null);
      if (_tripleNotEquals_2) {
        EList<JvmAnnotationReference> _annotations = it.getAnnotations();
        JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
        this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      }
      it.setVisibility(JvmVisibility.PROTECTED);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          {
            JvmParameterizedTypeReference _specializes = comp.getSpecializes();
            boolean _tripleNotEquals = (_specializes != null);
            if (_tripleNotEquals) {
              _builder.append("super.initProvidedPorts();");
              _builder.newLine();
            }
          }
          {
            final Function1<ProvidedPort, Boolean> _function = (ProvidedPort it_1) -> {
              LightweightTypeReference _overridenPortTypeRef = SpeADLJvmModelInferrer.this._speADLUtils.getOverridenPortTypeRef(it_1);
              return Boolean.valueOf((_overridenPortTypeRef == null));
            };
            Iterable<ProvidedPort> _filter = IterableExtensions.<ProvidedPort>filter(comp.getProvides(), _function);
            for(final ProvidedPort port : _filter) {
              _builder.append("init_");
              String _name = port.getName();
              _builder.append(_name);
              _builder.append("();");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      };
      this._jvmTypesBuilder.setBody(it, _client);
    };
    JvmOperation _method_3 = this._jvmTypesBuilder.toMethod(comp, "initProvidedPorts", this._typeReferenceBuilder.typeRef(void.class), _function_6);
    this._jvmTypesBuilder.<JvmOperation>operator_add(_members_5, _method_3);
    EList<JvmMember> _members_6 = componentClass.getMembers();
    final Procedure1<JvmConstructor> _function_7 = (JvmConstructor it) -> {
      EList<JvmFormalParameter> _parameters = it.getParameters();
      JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(comp, "implem", clazzRef);
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
      EList<JvmFormalParameter> _parameters_1 = it.getParameters();
      JvmFormalParameter _parameter_1 = this._jvmTypesBuilder.toParameter(comp, "b", requiresRef);
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _parameter_1);
      EList<JvmFormalParameter> _parameters_2 = it.getParameters();
      JvmFormalParameter _parameter_2 = this._jvmTypesBuilder.toParameter(comp, "doInits", this._typeReferenceBuilder.typeRef(boolean.class));
      this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_2, _parameter_2);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          {
            JvmParameterizedTypeReference _specializes = comp.getSpecializes();
            boolean _tripleNotEquals = (_specializes != null);
            if (_tripleNotEquals) {
              _builder.append("super(implem, b, false);");
              _builder.newLine();
            }
          }
          _builder.append("this.bridge = b;");
          _builder.newLine();
          _builder.append("this.implementation = implem;");
          _builder.newLine();
          _builder.newLine();
          _builder.append("assert implem.selfComponent == null: \"This is a bug.\";");
          _builder.newLine();
          _builder.append("implem.selfComponent = this;");
          _builder.newLine();
          _builder.newLine();
          _builder.append("// prevent them to be called twice if we are in");
          _builder.newLine();
          _builder.append("// a specialized component: only the last of the");
          _builder.newLine();
          _builder.append("// hierarchy will call them after everything is initialised");
          _builder.newLine();
          _builder.append("if (doInits) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("initParts();");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("initProvidedPorts();");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      this._jvmTypesBuilder.setBody(it, _client);
    };
    JvmConstructor _constructor = this._jvmTypesBuilder.toConstructor(comp, _function_7);
    this._jvmTypesBuilder.<JvmConstructor>operator_add(_members_6, _constructor);
    EList<ProvidedPort> _provides_1 = comp.getProvides();
    for (final ProvidedPort port_1 : _provides_1) {
      {
        final PortRef bound = port_1.getBound();
        final JvmTypeReference ptr = this._speADLUtils.substituteWith(port_1.getTypeReference(), substitutor);
        LightweightTypeReference _overridenPortTypeRef = this._speADLUtils.getOverridenPortTypeRef(port_1);
        final boolean isOverride = (_overridenPortTypeRef != null);
        final boolean isBound = (bound != null);
        if ((!isBound)) {
          EList<JvmMember> _members_7 = componentClass.getMembers();
          final Procedure1<JvmField> _function_8 = (JvmField it) -> {
          };
          JvmField _field_2 = this._jvmTypesBuilder.toField(port_1, port_1.getName(), ptr, _function_8);
          this._jvmTypesBuilder.<JvmField>operator_add(_members_7, _field_2);
        }
        EList<JvmMember> _members_8 = componentClass.getMembers();
        final Procedure1<JvmOperation> _function_9 = (JvmOperation it) -> {
          if (isOverride) {
            EList<JvmAnnotationReference> _annotations = it.getAnnotations();
            JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Override.class);
            this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
          }
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("return this.");
              {
                if (isBound) {
                  CharSequence _portRefCall = SpeADLJvmModelInferrer.this.portRefCall(bound, (comp instanceof Species));
                  _builder.append(_portRefCall);
                } else {
                  String _name = port_1.getName();
                  _builder.append(_name);
                }
              }
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          };
          this._jvmTypesBuilder.setBody(it, _client);
        };
        JvmOperation _method_4 = this._jvmTypesBuilder.toMethod(port_1, port_1.getName(), ptr, _function_9);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_8, _method_4);
      }
    }
    EList<Part> _parts_1 = comp.getParts();
    for (final Part part_1 : _parts_1) {
      {
        final JvmTypeReference tr = this._speADLUtils.typeReference(part_1);
        final JvmTypeReference nptr = this._speADLUtils.substituteWith(tr, substitutor);
        final JvmTypeReference ctr = this._speADLUtils.getInnerTypeReference(nptr, SpeADLJvmModelInferrer.COMPONENT_INTERFACE);
        EList<JvmMember> _members_7 = componentClass.getMembers();
        final Procedure1<JvmField> _function_8 = (JvmField it) -> {
        };
        JvmField _field_2 = this._jvmTypesBuilder.toField(part_1, part_1.getName(), ctr, _function_8);
        this._jvmTypesBuilder.<JvmField>operator_add(_members_7, _field_2);
        boolean _matched = false;
        if (part_1 instanceof ComponentPart) {
          _matched=true;
          EList<JvmMember> _members_8 = componentClass.getMembers();
          String _name_1 = ((ComponentPart)part_1).getName();
          String _plus_1 = ("implem_" + _name_1);
          final Procedure1<JvmField> _function_9 = (JvmField it) -> {
          };
          JvmField _field_3 = this._jvmTypesBuilder.toField(part_1, _plus_1, nptr, _function_9);
          this._jvmTypesBuilder.<JvmField>operator_add(_members_8, _field_3);
        }
        String _switchResult_1 = null;
        boolean _matched_1 = false;
        if (part_1 instanceof ComponentPart) {
          _matched_1=true;
          _switchResult_1 = ((ComponentPart)part_1).getName();
        }
        if (!_matched_1) {
          if (part_1 instanceof SpeciesPart) {
            _matched_1=true;
            String _name_1 = ((SpeciesPart)part_1).getSpeciesReference().getPart().getName();
            String _plus_1 = (_name_1 + "_");
            String _name_2 = ((SpeciesPart)part_1).getName();
            _switchResult_1 = (_plus_1 + _name_2);
          }
        }
        final String bridgePartName = _switchResult_1;
        EList<JvmMember> _members_8 = componentClass.getMembers();
        final Procedure1<JvmGenericType> _function_9 = (JvmGenericType it) -> {
          it.setVisibility(JvmVisibility.PRIVATE);
          it.setFinal(true);
          EList<JvmTypeReference> _superTypes_3 = it.getSuperTypes();
          JvmTypeReference _innerTypeReference_3 = this._speADLUtils.getInnerTypeReference(this._speADLUtils.rootSupertype(nptr), SpeADLJvmModelInferrer.REQUIRES_INTERFACE);
          this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes_3, _innerTypeReference_3);
          EList<Binding> _bindings = part_1.getBindings();
          for (final Binding binding : _bindings) {
            {
              final PortRef bound = binding.getTo();
              final JvmTypeReference rt = this._speADLUtils.substituteWith(this._speADLUtils.resolveTypeFrom(binding), substitutor).toJavaCompliantTypeReference();
              EList<JvmMember> _members_9 = it.getMembers();
              final Procedure1<JvmOperation> _function_10 = (JvmOperation it_1) -> {
                it_1.setFinal(true);
                StringConcatenationClient _client = new StringConcatenationClient() {
                  @Override
                  protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                    _builder.append("return ");
                    _builder.append(componentClass);
                    _builder.append(".this.");
                    CharSequence _portRefCall = SpeADLJvmModelInferrer.this.portRefCall(bound, (comp instanceof Species));
                    _builder.append(_portRefCall);
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  }
                };
                this._jvmTypesBuilder.setBody(it_1, _client);
              };
              JvmOperation _method_4 = this._jvmTypesBuilder.toMethod(binding, binding.getFrom().getName(), rt, _function_10);
              this._jvmTypesBuilder.<JvmOperation>operator_add(_members_9, _method_4);
            }
          }
        };
        JvmGenericType _class = this._jvmTypesBuilder.toClass(part_1, ((SpeADLJvmModelInferrer.REQUIRES_CLASS_PREFIX + "_") + bridgePartName), _function_9);
        this._jvmTypesBuilder.<JvmGenericType>operator_add(_members_8, _class);
        EList<JvmMember> _members_9 = componentClass.getMembers();
        final Procedure1<JvmOperation> _function_10 = (JvmOperation it) -> {
          it.setFinal(true);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("return this.");
              String _name = part_1.getName();
              _builder.append(_name);
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          };
          this._jvmTypesBuilder.setBody(it, _client);
        };
        JvmOperation _method_4 = this._jvmTypesBuilder.toMethod(part_1, part_1.getName(), ctr, _function_10);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_9, _method_4);
      }
    }
  }
  
  private CharSequence portRefCall(final PortRef bound, final boolean inSpecies) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Part _part = bound.getPart();
      boolean _tripleNotEquals = (_part != null);
      if (_tripleNotEquals) {
        {
          if ((inSpecies && (bound.getPart().eContainer() instanceof Ecosystem))) {
            _builder.append("implementation.ecosystemComponent.");
            _builder.newLine();
          }
        }
        String _name = bound.getPart().getName();
        _builder.append(_name);
        _builder.append("().");
        _builder.newLineIfNotEmpty();
      } else {
        {
          if ((inSpecies && (bound.getPort().eContainer() instanceof Ecosystem))) {
            _builder.append("implementation.ecosystemComponent.");
            _builder.newLine();
            _builder.append("\t\t\t");
          }
        }
        {
          Port _port = bound.getPort();
          if ((_port instanceof RequiredPort)) {
            _builder.append("bridge.");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    String _name_1 = bound.getPort().getName();
    _builder.append(_name_1);
    _builder.append("()");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public void infer(final EObject ecosystem, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    if (ecosystem instanceof Ecosystem) {
      _infer((Ecosystem)ecosystem, acceptor, isPreIndexingPhase);
      return;
    } else if (ecosystem != null) {
      _infer(ecosystem, acceptor, isPreIndexingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ecosystem, acceptor, isPreIndexingPhase).toString());
    }
  }
}
