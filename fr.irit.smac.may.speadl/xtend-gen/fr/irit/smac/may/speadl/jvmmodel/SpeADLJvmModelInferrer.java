package fr.irit.smac.may.speadl.jvmmodel;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import fr.irit.smac.may.speadl.SpeADLUtils;
import fr.irit.smac.may.speadl.jvmmodel.SpeADLJvmTypesBuilder;
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
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
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
  public final static String REQUIRES_INTERFACE = "Requires";
  
  public final static String PROVIDES_INTERFACE = "Provides";
  
  public final static String REQUIRES_CLASS_PREFIX = "BridgeImpl";
  
  public final static String COMPONENT_INTERFACE = "Component";
  
  public final static String COMPONENT_CLASS = "ComponentImpl";
  
  public final static String PARTS_INTERFACE = "Parts";
  
  /**
   * convenience API to build and initialize JVM types and their members.
   */
  @Inject
  @Extension
  private SpeADLJvmTypesBuilder _speADLJvmTypesBuilder;
  
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
      QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(ecosystem);
      final JvmGenericType clazz = this._speADLJvmTypesBuilder.toClass(ecosystem, _fullyQualifiedName);
      this.initNowAbstractComponent(ecosystem, clazz, acceptor);
    }
  }
  
  public void initNowAbstractComponent(final AbstractComponent comp, final JvmGenericType clazz, final IJvmDeclaredTypeAcceptor acceptor) {
    boolean _notAbstract = this._speADLUtils.notAbstract(comp);
    boolean _not = (!_notAbstract);
    clazz.setAbstract(_not);
    Ecosystem _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (comp instanceof Ecosystem) {
        _matched=true;
        _switchResult = ((Ecosystem)comp);
      }
    }
    if (!_matched) {
      if (comp instanceof Species) {
        _matched=true;
        _switchResult = this._speADLUtils.parentEcosystem(((Species)comp));
      }
    }
    final Ecosystem sourceParametersHolder = _switchResult;
    EList<JvmTypeParameter> _typeParameters = clazz.getTypeParameters();
    EList<JvmTypeParameter> _typeParameters_1 = sourceParametersHolder.getTypeParameters();
    final Function1<JvmTypeParameter, JvmTypeParameter> _function = new Function1<JvmTypeParameter, JvmTypeParameter>() {
      public JvmTypeParameter apply(final JvmTypeParameter it) {
        return SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmTypeParameter>cloneWithProxies(it);
      }
    };
    List<JvmTypeParameter> _map = ListExtensions.<JvmTypeParameter, JvmTypeParameter>map(_typeParameters_1, _function);
    this._speADLJvmTypesBuilder.<JvmTypeParameter>operator_add(_typeParameters, _map);
    JvmParameterizedTypeReference _specializes = comp.getSpecializes();
    boolean _tripleEquals = (_specializes == null);
    if (_tripleEquals) {
      final Procedure1<JvmGenericType> _function_1 = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          it.setStatic(true);
          EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
          EList<JvmTypeParameter> _typeParameters_1 = sourceParametersHolder.getTypeParameters();
          final Function1<JvmTypeParameter, JvmTypeParameter> _function = new Function1<JvmTypeParameter, JvmTypeParameter>() {
            public JvmTypeParameter apply(final JvmTypeParameter it) {
              return SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmTypeParameter>cloneWithProxies(it);
            }
          };
          List<JvmTypeParameter> _map = ListExtensions.<JvmTypeParameter, JvmTypeParameter>map(_typeParameters_1, _function);
          SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmTypeParameter>operator_add(_typeParameters, _map);
        }
      };
      final JvmGenericType requires = this._speADLJvmTypesBuilder.toInterface(comp, SpeADLJvmModelInferrer.REQUIRES_INTERFACE, _function_1);
      EList<JvmMember> _members = clazz.getMembers();
      this._speADLJvmTypesBuilder.<JvmGenericType>operator_add(_members, requires);
      final Procedure1<JvmGenericType> _function_2 = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          SpeADLJvmModelInferrer.this.initLaterRequires(comp, clazz, requires);
        }
      };
      acceptor.<JvmGenericType>accept(requires, _function_2);
    }
    final Procedure1<JvmGenericType> _function_3 = new Procedure1<JvmGenericType>() {
      public void apply(final JvmGenericType it) {
        it.setStatic(true);
        EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
        EList<JvmTypeParameter> _typeParameters_1 = sourceParametersHolder.getTypeParameters();
        final Function1<JvmTypeParameter, JvmTypeParameter> _function = new Function1<JvmTypeParameter, JvmTypeParameter>() {
          public JvmTypeParameter apply(final JvmTypeParameter it) {
            return SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmTypeParameter>cloneWithProxies(it);
          }
        };
        List<JvmTypeParameter> _map = ListExtensions.<JvmTypeParameter, JvmTypeParameter>map(_typeParameters_1, _function);
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmTypeParameter>operator_add(_typeParameters, _map);
      }
    };
    final JvmGenericType componentClass = this._speADLJvmTypesBuilder.toClass(comp, SpeADLJvmModelInferrer.COMPONENT_CLASS, _function_3);
    final Procedure1<JvmGenericType> _function_4 = new Procedure1<JvmGenericType>() {
      public void apply(final JvmGenericType it) {
        it.setStatic(true);
        EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
        EList<JvmTypeParameter> _typeParameters_1 = sourceParametersHolder.getTypeParameters();
        final Function1<JvmTypeParameter, JvmTypeParameter> _function = new Function1<JvmTypeParameter, JvmTypeParameter>() {
          public JvmTypeParameter apply(final JvmTypeParameter it) {
            return SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmTypeParameter>cloneWithProxies(it);
          }
        };
        List<JvmTypeParameter> _map = ListExtensions.<JvmTypeParameter, JvmTypeParameter>map(_typeParameters_1, _function);
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmTypeParameter>operator_add(_typeParameters, _map);
      }
    };
    final JvmGenericType parts = this._speADLJvmTypesBuilder.toInterface(comp, SpeADLJvmModelInferrer.PARTS_INTERFACE, _function_4);
    final Procedure1<JvmGenericType> _function_5 = new Procedure1<JvmGenericType>() {
      public void apply(final JvmGenericType it) {
        it.setStatic(true);
        EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
        EList<JvmTypeParameter> _typeParameters_1 = sourceParametersHolder.getTypeParameters();
        final Function1<JvmTypeParameter, JvmTypeParameter> _function = new Function1<JvmTypeParameter, JvmTypeParameter>() {
          public JvmTypeParameter apply(final JvmTypeParameter it) {
            return SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmTypeParameter>cloneWithProxies(it);
          }
        };
        List<JvmTypeParameter> _map = ListExtensions.<JvmTypeParameter, JvmTypeParameter>map(_typeParameters_1, _function);
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmTypeParameter>operator_add(_typeParameters, _map);
      }
    };
    final JvmGenericType provides = this._speADLJvmTypesBuilder.toInterface(comp, SpeADLJvmModelInferrer.PROVIDES_INTERFACE, _function_5);
    final Procedure1<JvmGenericType> _function_6 = new Procedure1<JvmGenericType>() {
      public void apply(final JvmGenericType it) {
        it.setStatic(true);
        EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
        EList<JvmTypeParameter> _typeParameters_1 = sourceParametersHolder.getTypeParameters();
        final Function1<JvmTypeParameter, JvmTypeParameter> _function = new Function1<JvmTypeParameter, JvmTypeParameter>() {
          public JvmTypeParameter apply(final JvmTypeParameter it) {
            return SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmTypeParameter>cloneWithProxies(it);
          }
        };
        List<JvmTypeParameter> _map = ListExtensions.<JvmTypeParameter, JvmTypeParameter>map(_typeParameters_1, _function);
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmTypeParameter>operator_add(_typeParameters, _map);
      }
    };
    final JvmGenericType componentIf = this._speADLJvmTypesBuilder.toInterface(comp, SpeADLJvmModelInferrer.COMPONENT_INTERFACE, _function_6);
    EList<JvmMember> _members_1 = clazz.getMembers();
    this._speADLJvmTypesBuilder.<JvmGenericType>operator_add(_members_1, componentIf);
    EList<JvmMember> _members_2 = clazz.getMembers();
    this._speADLJvmTypesBuilder.<JvmGenericType>operator_add(_members_2, provides);
    EList<JvmMember> _members_3 = clazz.getMembers();
    this._speADLJvmTypesBuilder.<JvmGenericType>operator_add(_members_3, parts);
    EList<JvmMember> _members_4 = clazz.getMembers();
    this._speADLJvmTypesBuilder.<JvmGenericType>operator_add(_members_4, componentClass);
    final Procedure1<JvmGenericType> _function_7 = new Procedure1<JvmGenericType>() {
      public void apply(final JvmGenericType it) {
        SpeADLJvmModelInferrer.this.initLaterProvides(comp, clazz, provides);
      }
    };
    acceptor.<JvmGenericType>accept(provides, _function_7);
    final Procedure1<JvmGenericType> _function_8 = new Procedure1<JvmGenericType>() {
      public void apply(final JvmGenericType it) {
        SpeADLJvmModelInferrer.this.initLaterComponent(comp, clazz, componentIf, provides);
      }
    };
    acceptor.<JvmGenericType>accept(componentIf, _function_8);
    final Procedure1<JvmGenericType> _function_9 = new Procedure1<JvmGenericType>() {
      public void apply(final JvmGenericType it) {
        SpeADLJvmModelInferrer.this.initLaterParts(comp, clazz, parts);
      }
    };
    acceptor.<JvmGenericType>accept(parts, _function_9);
    final Procedure1<JvmGenericType> _function_10 = new Procedure1<JvmGenericType>() {
      public void apply(final JvmGenericType it) {
        SpeADLJvmModelInferrer.this.initLaterComponentImpl(comp, clazz, componentClass);
      }
    };
    acceptor.<JvmGenericType>accept(componentClass, _function_10);
    final Procedure1<JvmGenericType> _function_11 = new Procedure1<JvmGenericType>() {
      public void apply(final JvmGenericType it) {
        SpeADLJvmModelInferrer.this.initLaterAbstractComponent(comp, clazz);
      }
    };
    acceptor.<JvmGenericType>accept(clazz, _function_11);
    if ((comp instanceof Ecosystem)) {
      EList<Species> _species = ((Ecosystem)comp).getSpecies();
      for (final Species species : _species) {
        String _name = species.getName();
        boolean _tripleNotEquals = (_name != null);
        if (_tripleNotEquals) {
          String _name_1 = species.getName();
          final Procedure1<JvmGenericType> _function_12 = new Procedure1<JvmGenericType>() {
            public void apply(final JvmGenericType it) {
              it.setStatic(true);
            }
          };
          final JvmGenericType sClazz = this._speADLJvmTypesBuilder.toClass(species, _name_1, _function_12);
          EList<JvmMember> _members_5 = clazz.getMembers();
          this._speADLJvmTypesBuilder.<JvmGenericType>operator_add(_members_5, sClazz);
          this.initNowAbstractComponent(species, sClazz, acceptor);
        }
      }
    }
  }
  
  public void initLaterAbstractComponent(final AbstractComponent comp, final JvmGenericType clazz) {
    final EList<JvmTypeParameter> myTypeParameters = clazz.getTypeParameters();
    Resource _eResource = comp.eResource();
    final StandardTypeParameterSubstitutor substitutor = this._speADLUtils.getSubstitutor(comp, clazz, _eResource);
    final Function1<JvmTypeParameter, EList<JvmTypeConstraint>> _function = new Function1<JvmTypeParameter, EList<JvmTypeConstraint>>() {
      public EList<JvmTypeConstraint> apply(final JvmTypeParameter it) {
        return it.getConstraints();
      }
    };
    List<EList<JvmTypeConstraint>> _map = ListExtensions.<JvmTypeParameter, EList<JvmTypeConstraint>>map(myTypeParameters, _function);
    Iterable<JvmTypeConstraint> _flatten = Iterables.<JvmTypeConstraint>concat(_map);
    for (final JvmTypeConstraint co : _flatten) {
      {
        JvmTypeReference _typeReference = co.getTypeReference();
        final JvmTypeReference tr = this._speADLUtils.substituteWith(_typeReference, substitutor);
        co.setTypeReference(tr);
      }
    }
    JvmParameterizedTypeReference _specializes = comp.getSpecializes();
    boolean _tripleNotEquals = (_specializes != null);
    if (_tripleNotEquals) {
      JvmParameterizedTypeReference _specializes_1 = comp.getSpecializes();
      final JvmTypeReference superType = this._speADLUtils.substituteWith(_specializes_1, substitutor);
      EList<JvmTypeReference> _superTypes = clazz.getSuperTypes();
      this._speADLJvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, superType);
    }
    final JvmParameterizedTypeReference clazzRef = this._speADLUtils.getParameterizedTypeRefWith(clazz, myTypeParameters);
    final JvmParameterizedTypeReference componentClassRef = this._speADLUtils.getInnerTypeReference(clazzRef, SpeADLJvmModelInferrer.COMPONENT_CLASS);
    final JvmParameterizedTypeReference componentIfRef = this._speADLUtils.getInnerTypeReference(clazzRef, SpeADLJvmModelInferrer.COMPONENT_INTERFACE);
    final JvmParameterizedTypeReference providesRef = this._speADLUtils.getInnerTypeReference(clazzRef, SpeADLJvmModelInferrer.PROVIDES_INTERFACE);
    final JvmParameterizedTypeReference partsRef = this._speADLUtils.getInnerTypeReference(clazzRef, SpeADLJvmModelInferrer.PARTS_INTERFACE);
    JvmTypeReference _xifexpression = null;
    JvmParameterizedTypeReference _specializes_2 = comp.getSpecializes();
    boolean _tripleNotEquals_1 = (_specializes_2 != null);
    if (_tripleNotEquals_1) {
      JvmParameterizedTypeReference _specializes_3 = comp.getSpecializes();
      JvmTypeReference _substituteWith = this._speADLUtils.substituteWith(_specializes_3, substitutor);
      _xifexpression = this._speADLUtils.rootSupertype(_substituteWith);
    } else {
      _xifexpression = clazzRef;
    }
    final JvmParameterizedTypeReference requiresRef = this._speADLUtils.getInnerTypeReference(_xifexpression, SpeADLJvmModelInferrer.REQUIRES_INTERFACE);
    EList<JvmMember> _members = clazz.getMembers();
    JvmTypeReference _typeRef = this._typeReferenceBuilder.typeRef(boolean.class);
    final Procedure1<JvmField> _function_1 = new Procedure1<JvmField>() {
      public void apply(final JvmField it) {
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("false;");
          }
        };
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setInitializer(it, _client);
        it.setVisibility(JvmVisibility.PRIVATE);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Used to check that two components are not created from the same implementation,");
        _builder.newLine();
        _builder.append("that the component has been started to call requires(), provides() and parts()");
        _builder.newLine();
        _builder.append("and that the component is not started by hand.");
        _builder.newLine();
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
      }
    };
    JvmField _newField = this._speADLJvmTypesBuilder.newField("init", _typeRef, _function_1);
    this._speADLJvmTypesBuilder.<JvmField>operator_add(_members, _newField);
    EList<JvmMember> _members_1 = clazz.getMembers();
    JvmTypeReference _typeRef_1 = this._typeReferenceBuilder.typeRef(boolean.class);
    final Procedure1<JvmField> _function_2 = new Procedure1<JvmField>() {
      public void apply(final JvmField it) {
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("false;");
          }
        };
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setInitializer(it, _client);
        it.setVisibility(JvmVisibility.PRIVATE);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Used to check that the component is not started by hand.");
        _builder.newLine();
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
      }
    };
    JvmField _newField_1 = this._speADLJvmTypesBuilder.newField("started", _typeRef_1, _function_2);
    this._speADLJvmTypesBuilder.<JvmField>operator_add(_members_1, _newField_1);
    EList<JvmMember> _members_2 = clazz.getMembers();
    final Procedure1<JvmField> _function_3 = new Procedure1<JvmField>() {
      public void apply(final JvmField it) {
      }
    };
    JvmField _newField_2 = this._speADLJvmTypesBuilder.newField("selfComponent", componentClassRef, _function_3);
    this._speADLJvmTypesBuilder.<JvmField>operator_add(_members_2, _newField_2);
    EList<JvmMember> _members_3 = clazz.getMembers();
    JvmTypeReference _typeRef_2 = this._typeReferenceBuilder.typeRef(void.class);
    final Procedure1<JvmOperation> _function_4 = new Procedure1<JvmOperation>() {
      public void apply(final JvmOperation it) {
        JvmParameterizedTypeReference _specializes = comp.getSpecializes();
        boolean _tripleNotEquals = (_specializes != null);
        if (_tripleNotEquals) {
          EList<JvmAnnotationReference> _annotations = it.getAnnotations();
          JvmAnnotationReference _annotationRef = SpeADLJvmModelInferrer.this._annotationTypesBuilder.annotationRef(Override.class);
          SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
        }
        it.setVisibility(JvmVisibility.PROTECTED);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Can be overridden by the implementation.");
        _builder.newLine();
        _builder.append("It will be called automatically after the component has been instantiated.");
        _builder.newLine();
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
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
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
      }
    };
    JvmOperation _method = this._speADLJvmTypesBuilder.toMethod(comp, "start", _typeRef_2, _function_4);
    this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_3, _method);
    EList<JvmMember> _members_4 = clazz.getMembers();
    final Procedure1<JvmOperation> _function_5 = new Procedure1<JvmOperation>() {
      public void apply(final JvmOperation it) {
        JvmParameterizedTypeReference _specializes = comp.getSpecializes();
        boolean _tripleNotEquals = (_specializes != null);
        if (_tripleNotEquals) {
          EList<JvmAnnotationReference> _annotations = it.getAnnotations();
          JvmAnnotationReference _annotationRef = SpeADLJvmModelInferrer.this._annotationTypesBuilder.annotationRef(Override.class);
          SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
        }
        it.setVisibility(JvmVisibility.PROTECTED);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("This can be called by the implementation to access the provided ports.");
        _builder.newLine();
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
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
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
      }
    };
    JvmOperation _method_1 = this._speADLJvmTypesBuilder.toMethod(comp, "provides", providesRef, _function_5);
    this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_4, _method_1);
    EList<ProvidedPort> _provides = comp.getProvides();
    for (final ProvidedPort port : _provides) {
      PortRef _bound = port.getBound();
      boolean _tripleEquals = (_bound == null);
      if (_tripleEquals) {
        EList<JvmMember> _members_5 = clazz.getMembers();
        String _name = port.getName();
        String _plus = ("make_" + _name);
        JvmParameterizedTypeReference _typeReference = port.getTypeReference();
        JvmTypeReference _substituteWith_1 = this._speADLUtils.substituteWith(_typeReference, substitutor);
        final Procedure1<JvmOperation> _function_6 = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            it.setAbstract(true);
            it.setVisibility(JvmVisibility.PROTECTED);
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("This should be overridden by the implementation to define the provided port.");
            _builder.newLine();
            _builder.append("This will be called once during the construction of the component to initialize the port.");
            _builder.newLine();
            SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
          }
        };
        JvmOperation _method_2 = this._speADLJvmTypesBuilder.toMethod(port, _plus, _substituteWith_1, _function_6);
        this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_5, _method_2);
      }
    }
    EList<JvmMember> _members_6 = clazz.getMembers();
    final Procedure1<JvmOperation> _function_7 = new Procedure1<JvmOperation>() {
      public void apply(final JvmOperation it) {
        JvmParameterizedTypeReference _specializes = comp.getSpecializes();
        boolean _tripleNotEquals = (_specializes != null);
        if (_tripleNotEquals) {
          EList<JvmAnnotationReference> _annotations = it.getAnnotations();
          JvmAnnotationReference _annotationRef = SpeADLJvmModelInferrer.this._annotationTypesBuilder.annotationRef(Override.class);
          SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
        }
        it.setVisibility(JvmVisibility.PROTECTED);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("This can be called by the implementation to access the required ports.");
        _builder.newLine();
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
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
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
      }
    };
    JvmOperation _method_3 = this._speADLJvmTypesBuilder.toMethod(comp, "requires", requiresRef, _function_7);
    this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_6, _method_3);
    EList<JvmMember> _members_7 = clazz.getMembers();
    final Procedure1<JvmOperation> _function_8 = new Procedure1<JvmOperation>() {
      public void apply(final JvmOperation it) {
        JvmParameterizedTypeReference _specializes = comp.getSpecializes();
        boolean _tripleNotEquals = (_specializes != null);
        if (_tripleNotEquals) {
          EList<JvmAnnotationReference> _annotations = it.getAnnotations();
          JvmAnnotationReference _annotationRef = SpeADLJvmModelInferrer.this._annotationTypesBuilder.annotationRef(Override.class);
          SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
        }
        it.setVisibility(JvmVisibility.PROTECTED);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("This can be called by the implementation to access the parts and their provided ports.");
        _builder.newLine();
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
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
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
      }
    };
    JvmOperation _method_4 = this._speADLJvmTypesBuilder.toMethod(comp, "parts", partsRef, _function_8);
    this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_7, _method_4);
    EList<Part> _parts = comp.getParts();
    for (final Part part : _parts) {
      {
        JvmParameterizedTypeReference _typeReference_1 = this._speADLUtils.typeReference(part);
        final JvmTypeReference ptr = this._speADLUtils.substituteWith(_typeReference_1, substitutor);
        boolean _matched = false;
        if (!_matched) {
          if (part instanceof ComponentPart) {
            _matched=true;
            EList<JvmMember> _members_8 = clazz.getMembers();
            String _name_1 = ((ComponentPart)part).getName();
            String _plus_1 = ("make_" + _name_1);
            final Procedure1<JvmOperation> _function_9 = new Procedure1<JvmOperation>() {
              public void apply(final JvmOperation it) {
                it.setVisibility(JvmVisibility.PROTECTED);
                it.setAbstract(true);
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("This should be overridden by the implementation to define how to create this sub-component.");
                _builder.newLine();
                _builder.append("This will be called once during the construction of the component to initialize this sub-component.");
                _builder.newLine();
                SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
              }
            };
            JvmOperation _method_5 = this._speADLJvmTypesBuilder.toMethod(part, _plus_1, ptr, _function_9);
            this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_8, _method_5);
          }
        }
        if (!_matched) {
          if (part instanceof SpeciesPart) {
            _matched=true;
            EList<JvmMember> _members_8 = clazz.getMembers();
            String _name_1 = ((SpeciesPart)part).getName();
            String _plus_1 = ("use_" + _name_1);
            final Procedure1<JvmField> _function_9 = new Procedure1<JvmField>() {
              public void apply(final JvmField it) {
              }
            };
            JvmField _newField_3 = this._speADLJvmTypesBuilder.newField(_plus_1, ptr, _function_9);
            this._speADLJvmTypesBuilder.<JvmField>operator_add(_members_8, _newField_3);
          }
        }
      }
    }
    EList<JvmMember> _members_8 = clazz.getMembers();
    final Procedure1<JvmOperation> _function_9 = new Procedure1<JvmOperation>() {
      public void apply(final JvmOperation it) {
        JvmParameterizedTypeReference _specializes = comp.getSpecializes();
        boolean _tripleNotEquals = (_specializes != null);
        if (_tripleNotEquals) {
          EList<JvmAnnotationReference> _annotations = it.getAnnotations();
          JvmAnnotationReference _annotationRef = SpeADLJvmModelInferrer.this._annotationTypesBuilder.annotationRef(Override.class);
          SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
        }
        EList<JvmFormalParameter> _parameters = it.getParameters();
        JvmFormalParameter _newParameter = SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.newParameter("b", requiresRef);
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _newParameter);
        EList<JvmFormalParameter> _parameters_1 = it.getParameters();
        JvmTypeReference _typeRef = SpeADLJvmModelInferrer.this._typeReferenceBuilder.typeRef(boolean.class);
        JvmFormalParameter _newParameter_1 = SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.newParameter("start", _typeRef);
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _newParameter_1);
        it.setSynchronized(true);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Not meant to be used to manually instantiate components (except for testing).");
        _builder.newLine();
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
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
            _builder.append(componentClassRef, "");
            _builder.append("  _comp = new ");
            _builder.append(componentClassRef, "");
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
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
      }
    };
    JvmOperation _method_5 = this._speADLJvmTypesBuilder.toMethod(comp, "_newComponent", componentIfRef, _function_9);
    this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_8, _method_5);
    boolean _matched = false;
    if (!_matched) {
      if (comp instanceof Ecosystem) {
        _matched=true;
        EList<Species> _species = ((Ecosystem)comp).getSpecies();
        for (final Species species : _species) {
          {
            String _name_1 = species.getName();
            JvmGenericType _innerType = this._speADLUtils.getInnerType(clazz, _name_1);
            final JvmParameterizedTypeReference str = this._speADLUtils.getParameterizedTypeRefWith(_innerType, myTypeParameters);
            boolean _notAbstract = this._speADLUtils.notAbstract(species);
            final boolean isAbstract = (!_notAbstract);
            EList<JvmMember> _members_9 = clazz.getMembers();
            String _name_2 = species.getName();
            String _plus_1 = ("make_" + _name_2);
            final Procedure1<JvmOperation> _function_10 = new Procedure1<JvmOperation>() {
              public void apply(final JvmOperation it) {
                EList<JvmFormalParameter> _parameters = it.getParameters();
                EList<Feature> _parameters_1 = species.getParameters();
                final Function1<Feature, JvmFormalParameter> _function = new Function1<Feature, JvmFormalParameter>() {
                  public JvmFormalParameter apply(final Feature p) {
                    String _name = p.getName();
                    JvmTypeReference _parameterType = p.getParameterType();
                    return SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.newParameter(_name, _parameterType);
                  }
                };
                List<JvmFormalParameter> _map = ListExtensions.<Feature, JvmFormalParameter>map(_parameters_1, _function);
                SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _map);
                it.setVisibility(JvmVisibility.PROTECTED);
                it.setAbstract(isAbstract);
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("This should be overridden by the implementation to instantiate the implementation of the species.");
                _builder.newLine();
                SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
                if ((!isAbstract)) {
                  StringConcatenationClient _client = new StringConcatenationClient() {
                    @Override
                    protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                      _builder.append("return new ");
                      _builder.append(str, "");
                      _builder.append("();");
                      _builder.newLineIfNotEmpty();
                    }
                  };
                  SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
                }
              }
            };
            JvmOperation _method_6 = this._speADLJvmTypesBuilder.toMethod(species, _plus_1, str, _function_10);
            this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_9, _method_6);
            EList<JvmMember> _members_10 = clazz.getMembers();
            String _name_3 = species.getName();
            String _plus_2 = ("_createImplementationOf" + _name_3);
            final Procedure1<JvmOperation> _function_11 = new Procedure1<JvmOperation>() {
              public void apply(final JvmOperation it) {
                EList<JvmFormalParameter> _parameters = it.getParameters();
                EList<Feature> _parameters_1 = species.getParameters();
                final Function1<Feature, JvmFormalParameter> _function = new Function1<Feature, JvmFormalParameter>() {
                  public JvmFormalParameter apply(final Feature p) {
                    String _name = p.getName();
                    JvmTypeReference _parameterType = p.getParameterType();
                    return SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.newParameter(_name, _parameterType);
                  }
                };
                List<JvmFormalParameter> _map = ListExtensions.<Feature, JvmFormalParameter>map(_parameters_1, _function);
                SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _map);
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("Do not call, used by generated code.");
                _builder.newLine();
                SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
                final JvmOperation m = it;
                final Procedure1<ITreeAppendable> _function_1 = new Procedure1<ITreeAppendable>() {
                  public void apply(final ITreeAppendable it) {
                    Resource _eResource = clazz.eResource();
                    LightweightTypeReference _lightweightTypeReference = SpeADLJvmModelInferrer.this._speADLUtils.toLightweightTypeReference(str, _eResource);
                    it.append(_lightweightTypeReference);
                    StringConcatenation _builder = new StringConcatenation();
                    _builder.append(" ");
                    String _declareSyntheticVariable = it.declareSyntheticVariable(m, "implem");
                    _builder.append(_declareSyntheticVariable, " ");
                    _builder.append(" = make_");
                    String _name = species.getName();
                    _builder.append(_name, " ");
                    _builder.append("(");
                    EList<Feature> _parameters = species.getParameters();
                    final Function1<Feature, String> _function = new Function1<Feature, String>() {
                      public String apply(final Feature it) {
                        return it.getName();
                      }
                    };
                    List<String> _map = ListExtensions.<Feature, String>map(_parameters, _function);
                    String _join = IterableExtensions.join(_map, ",");
                    _builder.append(_join, " ");
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                    it.append(_builder);
                    StringConcatenation _builder_1 = new StringConcatenation();
                    _builder_1.append("if (");
                    String _name_1 = it.getName(m);
                    _builder_1.append(_name_1, "");
                    _builder_1.append(" == null) {");
                    _builder_1.newLineIfNotEmpty();
                    _builder_1.append("\t");
                    _builder_1.append("throw new RuntimeException(\"make_");
                    String _name_2 = species.getName();
                    _builder_1.append(_name_2, "\t");
                    _builder_1.append("() in ");
                    String _qualifiedName = clazz.getQualifiedName();
                    _builder_1.append(_qualifiedName, "\t");
                    _builder_1.append(" should not return null.\");");
                    _builder_1.newLineIfNotEmpty();
                    _builder_1.append("}");
                    _builder_1.newLine();
                    _builder_1.append("assert ");
                    String _name_3 = it.getName(m);
                    _builder_1.append(_name_3, "");
                    _builder_1.append(".ecosystemComponent == null: \"This is a bug.\";");
                    _builder_1.newLineIfNotEmpty();
                    _builder_1.append("assert this.selfComponent != null: \"This is a bug.\";");
                    _builder_1.newLine();
                    String _name_4 = it.getName(m);
                    _builder_1.append(_name_4, "");
                    _builder_1.append(".ecosystemComponent = this.selfComponent;");
                    _builder_1.newLineIfNotEmpty();
                    it.append(_builder_1);
                    EList<Part> _parts = species.getParts();
                    Iterable<SpeciesPart> _filter = Iterables.<SpeciesPart>filter(_parts, SpeciesPart.class);
                    for (final SpeciesPart use : _filter) {
                      StringConcatenation _builder_2 = new StringConcatenation();
                      _builder_2.append("assert this.selfComponent.implem_");
                      SpeciesReference _speciesReference = use.getSpeciesReference();
                      ComponentPart _part = _speciesReference.getPart();
                      String _name_5 = _part.getName();
                      _builder_2.append(_name_5, "");
                      _builder_2.append(" != null: \"This is a bug.\";");
                      _builder_2.newLineIfNotEmpty();
                      _builder_2.append("assert ");
                      String _name_6 = it.getName(m);
                      _builder_2.append(_name_6, "");
                      _builder_2.append(".use_");
                      String _name_7 = use.getName();
                      _builder_2.append(_name_7, "");
                      _builder_2.append(" == null: \"This is a bug.\";");
                      _builder_2.newLineIfNotEmpty();
                      String _name_8 = it.getName(m);
                      _builder_2.append(_name_8, "");
                      _builder_2.append(".use_");
                      String _name_9 = use.getName();
                      _builder_2.append(_name_9, "");
                      _builder_2.append(" = this.selfComponent.implem_");
                      SpeciesReference _speciesReference_1 = use.getSpeciesReference();
                      ComponentPart _part_1 = _speciesReference_1.getPart();
                      String _name_10 = _part_1.getName();
                      _builder_2.append(_name_10, "");
                      _builder_2.append("._createImplementationOf");
                      SpeciesReference _speciesReference_2 = use.getSpeciesReference();
                      Species _species = _speciesReference_2.getSpecies();
                      String _name_11 = _species.getName();
                      _builder_2.append(_name_11, "");
                      _builder_2.append("(");
                      SpeciesReference _speciesReference_3 = use.getSpeciesReference();
                      EList<Feature> _arguments = _speciesReference_3.getArguments();
                      final Function1<Feature, String> _function_1 = new Function1<Feature, String>() {
                        public String apply(final Feature it) {
                          return it.getName();
                        }
                      };
                      List<String> _map_1 = ListExtensions.<Feature, String>map(_arguments, _function_1);
                      String _join_1 = IterableExtensions.join(_map_1, ",");
                      _builder_2.append(_join_1, "");
                      _builder_2.append(");");
                      _builder_2.newLineIfNotEmpty();
                      it.append(_builder_2);
                    }
                    StringConcatenation _builder_3 = new StringConcatenation();
                    _builder_3.append("return ");
                    String _name_12 = it.getName(m);
                    _builder_3.append(_name_12, "");
                    _builder_3.append(";");
                    it.append(_builder_3);
                  }
                };
                SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _function_1);
              }
            };
            JvmOperation _method_7 = this._speADLJvmTypesBuilder.toMethod(species, _plus_2, str, _function_11);
            this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_10, _method_7);
            Iterable<RequiredPort> _allRequires = this._speADLUtils.getAllRequires(species);
            boolean _isEmpty = IterableExtensions.isEmpty(_allRequires);
            if (_isEmpty) {
              EList<JvmMember> _members_11 = clazz.getMembers();
              String _name_4 = species.getName();
              String _plus_3 = ("new" + _name_4);
              JvmParameterizedTypeReference _innerTypeReference = this._speADLUtils.getInnerTypeReference(str, SpeADLJvmModelInferrer.COMPONENT_INTERFACE);
              final Procedure1<JvmOperation> _function_12 = new Procedure1<JvmOperation>() {
                public void apply(final JvmOperation it) {
                  EList<JvmFormalParameter> _parameters = it.getParameters();
                  EList<Feature> _parameters_1 = species.getParameters();
                  final Function1<Feature, JvmFormalParameter> _function = new Function1<Feature, JvmFormalParameter>() {
                    public JvmFormalParameter apply(final Feature p) {
                      String _name = p.getName();
                      JvmTypeReference _parameterType = p.getParameterType();
                      return SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.newParameter(_name, _parameterType);
                    }
                  };
                  List<JvmFormalParameter> _map = ListExtensions.<Feature, JvmFormalParameter>map(_parameters_1, _function);
                  SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _map);
                  it.setVisibility(JvmVisibility.PROTECTED);
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("This can be called to create an instance of the species from inside the implementation of the ecosystem.");
                  _builder.newLine();
                  SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
                  StringConcatenationClient _client = new StringConcatenationClient() {
                    @Override
                    protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                      _builder.append(str, "");
                      _builder.append(" _implem = _createImplementationOf");
                      String _name = species.getName();
                      _builder.append(_name, "");
                      _builder.append("(");
                      EList<Feature> _parameters = species.getParameters();
                      final Function1<Feature, String> _function = new Function1<Feature, String>() {
                        public String apply(final Feature it) {
                          return it.getName();
                        }
                      };
                      List<String> _map = ListExtensions.<Feature, String>map(_parameters, _function);
                      String _join = IterableExtensions.join(_map, ",");
                      _builder.append(_join, "");
                      _builder.append(");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("return _implem._newComponent(new ");
                      JvmParameterizedTypeReference _innerTypeReference = SpeADLJvmModelInferrer.this._speADLUtils.getInnerTypeReference(str, SpeADLJvmModelInferrer.REQUIRES_INTERFACE);
                      _builder.append(_innerTypeReference, "");
                      _builder.append("() {},true);");
                      _builder.newLineIfNotEmpty();
                    }
                  };
                  SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
                }
              };
              JvmOperation _method_8 = this._speADLJvmTypesBuilder.toMethod(species, _plus_3, _innerTypeReference, _function_12);
              this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_11, _method_8);
            }
          }
        }
        Iterable<RequiredPort> _allRequires = this._speADLUtils.getAllRequires(comp);
        boolean _isEmpty = IterableExtensions.isEmpty(_allRequires);
        if (_isEmpty) {
          EList<JvmMember> _members_9 = clazz.getMembers();
          final Procedure1<JvmOperation> _function_10 = new Procedure1<JvmOperation>() {
            public void apply(final JvmOperation it) {
              JvmParameterizedTypeReference _specializes = ((Ecosystem)comp).getSpecializes();
              boolean _tripleNotEquals = (_specializes != null);
              if (_tripleNotEquals) {
                EList<JvmAnnotationReference> _annotations = it.getAnnotations();
                JvmAnnotationReference _annotationRef = SpeADLJvmModelInferrer.this._annotationTypesBuilder.annotationRef(Override.class);
                SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
              }
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Use to instantiate a component from this implementation.");
              _builder.newLine();
              SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
              StringConcatenationClient _client = new StringConcatenationClient() {
                @Override
                protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                  _builder.append("return this._newComponent(new ");
                  _builder.append(requiresRef, "");
                  _builder.append("() {}, true);");
                  _builder.newLineIfNotEmpty();
                }
              };
              SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
            }
          };
          JvmOperation _method_6 = this._speADLJvmTypesBuilder.toMethod(comp, "newComponent", componentIfRef, _function_10);
          this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_9, _method_6);
        }
      }
    }
    if (!_matched) {
      if (comp instanceof Species) {
        _matched=true;
        final Ecosystem parentEco = this._speADLUtils.parentEcosystem(((Species)comp));
        JvmGenericType _associatedJvmClass = this._speADLUtils.associatedJvmClass(parentEco);
        final JvmParameterizedTypeReference parentRef = this._speADLUtils.getParameterizedTypeRefWith(_associatedJvmClass, myTypeParameters);
        EList<JvmMember> _members_9 = clazz.getMembers();
        JvmParameterizedTypeReference _innerTypeReference = this._speADLUtils.getInnerTypeReference(parentRef, SpeADLJvmModelInferrer.COMPONENT_CLASS);
        final Procedure1<JvmField> _function_10 = new Procedure1<JvmField>() {
          public void apply(final JvmField it) {
          }
        };
        JvmField _newField_3 = this._speADLJvmTypesBuilder.newField("ecosystemComponent", _innerTypeReference, _function_10);
        this._speADLJvmTypesBuilder.<JvmField>operator_add(_members_9, _newField_3);
        EList<JvmMember> _members_10 = clazz.getMembers();
        JvmParameterizedTypeReference _innerTypeReference_1 = this._speADLUtils.getInnerTypeReference(parentRef, SpeADLJvmModelInferrer.PROVIDES_INTERFACE);
        final Procedure1<JvmOperation> _function_11 = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            it.setVisibility(JvmVisibility.PROTECTED);
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("This can be called by the species implementation to access the provided ports of its ecosystem.");
            _builder.newLine();
            SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
            StringConcatenationClient _client = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                _builder.append("assert this.ecosystemComponent != null: \"This is a bug.\";");
                _builder.newLine();
                _builder.append("return this.ecosystemComponent;");
                _builder.newLine();
              }
            };
            SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
          }
        };
        JvmOperation _method_6 = this._speADLJvmTypesBuilder.toMethod(parentEco, "eco_provides", _innerTypeReference_1, _function_11);
        this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_10, _method_6);
        EList<JvmMember> _members_11 = clazz.getMembers();
        JvmTypeReference _rootSupertype = this._speADLUtils.rootSupertype(parentRef);
        JvmParameterizedTypeReference _innerTypeReference_2 = this._speADLUtils.getInnerTypeReference(_rootSupertype, SpeADLJvmModelInferrer.REQUIRES_INTERFACE);
        final Procedure1<JvmOperation> _function_12 = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            it.setVisibility(JvmVisibility.PROTECTED);
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("This can be called by the species implementation to access the required ports of its ecosystem.");
            _builder.newLine();
            SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
            StringConcatenationClient _client = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                _builder.append("assert this.ecosystemComponent != null: \"This is a bug.\";");
                _builder.newLine();
                _builder.append("return this.ecosystemComponent.bridge;");
                _builder.newLine();
              }
            };
            SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
          }
        };
        JvmOperation _method_7 = this._speADLJvmTypesBuilder.toMethod(parentEco, "eco_requires", _innerTypeReference_2, _function_12);
        this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_11, _method_7);
        EList<JvmMember> _members_12 = clazz.getMembers();
        JvmParameterizedTypeReference _innerTypeReference_3 = this._speADLUtils.getInnerTypeReference(parentRef, SpeADLJvmModelInferrer.PARTS_INTERFACE);
        final Procedure1<JvmOperation> _function_13 = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            it.setVisibility(JvmVisibility.PROTECTED);
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("This can be called by the species implementation to access the parts of its ecosystem and their provided ports.");
            _builder.newLine();
            SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
            StringConcatenationClient _client = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                _builder.append("assert this.ecosystemComponent != null: \"This is a bug.\";");
                _builder.newLine();
                _builder.append("return this.ecosystemComponent;");
                _builder.newLine();
              }
            };
            SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
          }
        };
        JvmOperation _method_8 = this._speADLJvmTypesBuilder.toMethod(parentEco, "eco_parts", _innerTypeReference_3, _function_13);
        this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_12, _method_8);
      }
    }
  }
  
  public void initLaterRequires(final AbstractComponent comp, final JvmGenericType clazz, final JvmGenericType requires) {
    Resource _eResource = comp.eResource();
    final StandardTypeParameterSubstitutor substitutor = this._speADLUtils.getSubstitutor(comp, requires, _eResource);
    EList<JvmTypeParameter> _typeParameters = requires.getTypeParameters();
    final Function1<JvmTypeParameter, EList<JvmTypeConstraint>> _function = new Function1<JvmTypeParameter, EList<JvmTypeConstraint>>() {
      public EList<JvmTypeConstraint> apply(final JvmTypeParameter it) {
        return it.getConstraints();
      }
    };
    List<EList<JvmTypeConstraint>> _map = ListExtensions.<JvmTypeParameter, EList<JvmTypeConstraint>>map(_typeParameters, _function);
    Iterable<JvmTypeConstraint> _flatten = Iterables.<JvmTypeConstraint>concat(_map);
    for (final JvmTypeConstraint c : _flatten) {
      {
        JvmTypeReference _typeReference = c.getTypeReference();
        final JvmTypeReference tr = this._speADLUtils.substituteWith(_typeReference, substitutor);
        c.setTypeReference(tr);
      }
    }
    EList<RequiredPort> _requires = comp.getRequires();
    for (final RequiredPort port : _requires) {
      EList<JvmMember> _members = requires.getMembers();
      String _name = port.getName();
      JvmParameterizedTypeReference _typeReference = port.getTypeReference();
      JvmTypeReference _substituteWith = this._speADLUtils.substituteWith(_typeReference, substitutor);
      final Procedure1<JvmOperation> _function_1 = new Procedure1<JvmOperation>() {
        public void apply(final JvmOperation it) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("This can be called by the implementation to access this required port.");
          _builder.newLine();
          SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
        }
      };
      JvmOperation _method = this._speADLJvmTypesBuilder.toMethod(port, _name, _substituteWith, _function_1);
      this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
    }
  }
  
  public void initLaterProvides(final AbstractComponent comp, final JvmGenericType clazz, final JvmGenericType provides) {
    Resource _eResource = comp.eResource();
    final StandardTypeParameterSubstitutor substitutor = this._speADLUtils.getSubstitutor(comp, provides, _eResource);
    EList<JvmTypeParameter> _typeParameters = provides.getTypeParameters();
    final Function1<JvmTypeParameter, EList<JvmTypeConstraint>> _function = new Function1<JvmTypeParameter, EList<JvmTypeConstraint>>() {
      public EList<JvmTypeConstraint> apply(final JvmTypeParameter it) {
        return it.getConstraints();
      }
    };
    List<EList<JvmTypeConstraint>> _map = ListExtensions.<JvmTypeParameter, EList<JvmTypeConstraint>>map(_typeParameters, _function);
    Iterable<JvmTypeConstraint> _flatten = Iterables.<JvmTypeConstraint>concat(_map);
    for (final JvmTypeConstraint c : _flatten) {
      {
        JvmTypeReference _typeReference = c.getTypeReference();
        final JvmTypeReference tr = this._speADLUtils.substituteWith(_typeReference, substitutor);
        c.setTypeReference(tr);
      }
    }
    JvmParameterizedTypeReference _specializes = comp.getSpecializes();
    boolean _tripleNotEquals = (_specializes != null);
    if (_tripleNotEquals) {
      JvmParameterizedTypeReference _specializes_1 = comp.getSpecializes();
      final JvmTypeReference nstr = this._speADLUtils.substituteWith(_specializes_1, substitutor);
      EList<JvmTypeReference> _superTypes = provides.getSuperTypes();
      JvmParameterizedTypeReference _innerTypeReference = this._speADLUtils.getInnerTypeReference(nstr, SpeADLJvmModelInferrer.PROVIDES_INTERFACE);
      this._speADLJvmTypesBuilder.<JvmParameterizedTypeReference>operator_add(_superTypes, _innerTypeReference);
    }
    EList<ProvidedPort> _provides = comp.getProvides();
    for (final ProvidedPort port : _provides) {
      EList<JvmMember> _members = provides.getMembers();
      String _name = port.getName();
      JvmParameterizedTypeReference _typeReference = port.getTypeReference();
      JvmTypeReference _substituteWith = this._speADLUtils.substituteWith(_typeReference, substitutor);
      final Procedure1<JvmOperation> _function_1 = new Procedure1<JvmOperation>() {
        public void apply(final JvmOperation it) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("This can be called to access the provided port.");
          _builder.newLine();
          SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
        }
      };
      JvmOperation _method = this._speADLJvmTypesBuilder.toMethod(port, _name, _substituteWith, _function_1);
      this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
    }
  }
  
  public void initLaterParts(final AbstractComponent comp, final JvmGenericType clazz, final JvmGenericType parts) {
    Resource _eResource = comp.eResource();
    final StandardTypeParameterSubstitutor substitutor = this._speADLUtils.getSubstitutor(comp, parts, _eResource);
    EList<JvmTypeParameter> _typeParameters = parts.getTypeParameters();
    final Function1<JvmTypeParameter, EList<JvmTypeConstraint>> _function = new Function1<JvmTypeParameter, EList<JvmTypeConstraint>>() {
      public EList<JvmTypeConstraint> apply(final JvmTypeParameter it) {
        return it.getConstraints();
      }
    };
    List<EList<JvmTypeConstraint>> _map = ListExtensions.<JvmTypeParameter, EList<JvmTypeConstraint>>map(_typeParameters, _function);
    Iterable<JvmTypeConstraint> _flatten = Iterables.<JvmTypeConstraint>concat(_map);
    for (final JvmTypeConstraint c : _flatten) {
      {
        JvmTypeReference _typeReference = c.getTypeReference();
        final JvmTypeReference tr = this._speADLUtils.substituteWith(_typeReference, substitutor);
        c.setTypeReference(tr);
      }
    }
    JvmParameterizedTypeReference _specializes = comp.getSpecializes();
    boolean _tripleNotEquals = (_specializes != null);
    if (_tripleNotEquals) {
      JvmParameterizedTypeReference _specializes_1 = comp.getSpecializes();
      final JvmTypeReference nstr = this._speADLUtils.substituteWith(_specializes_1, substitutor);
      EList<JvmTypeReference> _superTypes = parts.getSuperTypes();
      JvmParameterizedTypeReference _innerTypeReference = this._speADLUtils.getInnerTypeReference(nstr, SpeADLJvmModelInferrer.PARTS_INTERFACE);
      this._speADLJvmTypesBuilder.<JvmParameterizedTypeReference>operator_add(_superTypes, _innerTypeReference);
    }
    EList<Part> _parts = comp.getParts();
    for (final Part part : _parts) {
      {
        JvmParameterizedTypeReference _typeReference = this._speADLUtils.typeReference(part);
        final JvmTypeReference nptr = this._speADLUtils.substituteWith(_typeReference, substitutor);
        EList<JvmMember> _members = parts.getMembers();
        String _name = part.getName();
        JvmParameterizedTypeReference _innerTypeReference_1 = this._speADLUtils.getInnerTypeReference(nptr, SpeADLJvmModelInferrer.COMPONENT_INTERFACE);
        final Procedure1<JvmOperation> _function_1 = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("This can be called by the implementation to access the part and its provided ports.");
            _builder.newLine();
            _builder.append("It will be initialized after the required ports are initialized and before the provided ports are initialized.");
            _builder.newLine();
            SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setDocumentation(it, _builder.toString());
          }
        };
        JvmOperation _method = this._speADLJvmTypesBuilder.toMethod(part, _name, _innerTypeReference_1, _function_1);
        this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
      }
    }
  }
  
  public void initLaterComponent(final AbstractComponent comp, final JvmGenericType clazz, final JvmGenericType componentIf, final JvmGenericType provides) {
    Resource _eResource = comp.eResource();
    final StandardTypeParameterSubstitutor substitutor = this._speADLUtils.getSubstitutor(comp, componentIf, _eResource);
    EList<JvmTypeParameter> _typeParameters = componentIf.getTypeParameters();
    final Function1<JvmTypeParameter, EList<JvmTypeConstraint>> _function = new Function1<JvmTypeParameter, EList<JvmTypeConstraint>>() {
      public EList<JvmTypeConstraint> apply(final JvmTypeParameter it) {
        return it.getConstraints();
      }
    };
    List<EList<JvmTypeConstraint>> _map = ListExtensions.<JvmTypeParameter, EList<JvmTypeConstraint>>map(_typeParameters, _function);
    Iterable<JvmTypeConstraint> _flatten = Iterables.<JvmTypeConstraint>concat(_map);
    for (final JvmTypeConstraint c : _flatten) {
      {
        JvmTypeReference _typeReference = c.getTypeReference();
        final JvmTypeReference tr = this._speADLUtils.substituteWith(_typeReference, substitutor);
        c.setTypeReference(tr);
      }
    }
    JvmParameterizedTypeReference _specializes = comp.getSpecializes();
    boolean _tripleNotEquals = (_specializes != null);
    if (_tripleNotEquals) {
      JvmParameterizedTypeReference _specializes_1 = comp.getSpecializes();
      final JvmTypeReference nstr = this._speADLUtils.substituteWith(_specializes_1, substitutor);
      EList<JvmTypeReference> _superTypes = componentIf.getSuperTypes();
      JvmParameterizedTypeReference _innerTypeReference = this._speADLUtils.getInnerTypeReference(nstr, SpeADLJvmModelInferrer.COMPONENT_INTERFACE);
      this._speADLJvmTypesBuilder.<JvmParameterizedTypeReference>operator_add(_superTypes, _innerTypeReference);
    }
    EList<JvmTypeReference> _superTypes_1 = componentIf.getSuperTypes();
    EList<JvmTypeParameter> _typeParameters_1 = componentIf.getTypeParameters();
    JvmParameterizedTypeReference _parameterizedTypeRefWith = this._speADLUtils.getParameterizedTypeRefWith(provides, _typeParameters_1);
    this._speADLJvmTypesBuilder.<JvmParameterizedTypeReference>operator_add(_superTypes_1, _parameterizedTypeRefWith);
  }
  
  public void initLaterComponentImpl(final AbstractComponent comp, final JvmGenericType clazz, final JvmGenericType componentClass) {
    EList<JvmTypeParameter> _typeParameters = componentClass.getTypeParameters();
    final JvmParameterizedTypeReference clazzRef = this._speADLUtils.getParameterizedTypeRefWith(clazz, _typeParameters);
    Resource _eResource = comp.eResource();
    final StandardTypeParameterSubstitutor substitutor = this._speADLUtils.getSubstitutor(comp, componentClass, _eResource);
    EList<JvmTypeParameter> _typeParameters_1 = componentClass.getTypeParameters();
    final Function1<JvmTypeParameter, EList<JvmTypeConstraint>> _function = new Function1<JvmTypeParameter, EList<JvmTypeConstraint>>() {
      public EList<JvmTypeConstraint> apply(final JvmTypeParameter it) {
        return it.getConstraints();
      }
    };
    List<EList<JvmTypeConstraint>> _map = ListExtensions.<JvmTypeParameter, EList<JvmTypeConstraint>>map(_typeParameters_1, _function);
    Iterable<JvmTypeConstraint> _flatten = Iterables.<JvmTypeConstraint>concat(_map);
    for (final JvmTypeConstraint c : _flatten) {
      {
        JvmTypeReference _typeReference = c.getTypeReference();
        final JvmTypeReference tr = this._speADLUtils.substituteWith(_typeReference, substitutor);
        c.setTypeReference(tr);
      }
    }
    JvmParameterizedTypeReference _specializes = comp.getSpecializes();
    boolean _tripleNotEquals = (_specializes != null);
    if (_tripleNotEquals) {
      JvmParameterizedTypeReference _specializes_1 = comp.getSpecializes();
      final JvmTypeReference nstr = this._speADLUtils.substituteWith(_specializes_1, substitutor);
      EList<JvmTypeReference> _superTypes = componentClass.getSuperTypes();
      JvmParameterizedTypeReference _innerTypeReference = this._speADLUtils.getInnerTypeReference(nstr, SpeADLJvmModelInferrer.COMPONENT_CLASS);
      this._speADLJvmTypesBuilder.<JvmParameterizedTypeReference>operator_add(_superTypes, _innerTypeReference);
    }
    EList<JvmTypeReference> _superTypes_1 = componentClass.getSuperTypes();
    JvmParameterizedTypeReference _innerTypeReference_1 = this._speADLUtils.getInnerTypeReference(clazzRef, SpeADLJvmModelInferrer.COMPONENT_INTERFACE);
    this._speADLJvmTypesBuilder.<JvmParameterizedTypeReference>operator_add(_superTypes_1, _innerTypeReference_1);
    EList<JvmTypeReference> _superTypes_2 = componentClass.getSuperTypes();
    JvmParameterizedTypeReference _innerTypeReference_2 = this._speADLUtils.getInnerTypeReference(clazzRef, SpeADLJvmModelInferrer.PARTS_INTERFACE);
    this._speADLJvmTypesBuilder.<JvmParameterizedTypeReference>operator_add(_superTypes_2, _innerTypeReference_2);
    JvmTypeReference _xifexpression = null;
    JvmParameterizedTypeReference _specializes_2 = comp.getSpecializes();
    boolean _tripleNotEquals_1 = (_specializes_2 != null);
    if (_tripleNotEquals_1) {
      JvmParameterizedTypeReference _specializes_3 = comp.getSpecializes();
      JvmTypeReference _substituteWith = this._speADLUtils.substituteWith(_specializes_3, substitutor);
      _xifexpression = this._speADLUtils.rootSupertype(_substituteWith);
    } else {
      _xifexpression = clazzRef;
    }
    final JvmParameterizedTypeReference requiresRef = this._speADLUtils.getInnerTypeReference(_xifexpression, SpeADLJvmModelInferrer.REQUIRES_INTERFACE);
    EList<JvmMember> _members = componentClass.getMembers();
    final Procedure1<JvmField> _function_1 = new Procedure1<JvmField>() {
      public void apply(final JvmField it) {
        it.setFinal(true);
      }
    };
    JvmField _newField = this._speADLJvmTypesBuilder.newField("bridge", requiresRef, _function_1);
    this._speADLJvmTypesBuilder.<JvmField>operator_add(_members, _newField);
    EList<JvmMember> _members_1 = componentClass.getMembers();
    final Procedure1<JvmField> _function_2 = new Procedure1<JvmField>() {
      public void apply(final JvmField it) {
        it.setFinal(true);
      }
    };
    JvmField _newField_1 = this._speADLJvmTypesBuilder.newField("implementation", clazzRef, _function_2);
    this._speADLJvmTypesBuilder.<JvmField>operator_add(_members_1, _newField_1);
    EList<JvmMember> _members_2 = componentClass.getMembers();
    JvmTypeReference _typeRef = this._typeReferenceBuilder.typeRef(void.class);
    final Procedure1<JvmOperation> _function_3 = new Procedure1<JvmOperation>() {
      public void apply(final JvmOperation it) {
        JvmParameterizedTypeReference _specializes = comp.getSpecializes();
        boolean _tripleNotEquals = (_specializes != null);
        if (_tripleNotEquals) {
          EList<JvmAnnotationReference> _annotations = it.getAnnotations();
          JvmAnnotationReference _annotationRef = SpeADLJvmModelInferrer.this._annotationTypesBuilder.annotationRef(Override.class);
          SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
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
                _builder.append(_name, "");
                _builder.append(" != null: \"This is a bug.\";");
                _builder.newLineIfNotEmpty();
                _builder.append("((");
                JvmParameterizedTypeReference _typeReference = SpeADLJvmModelInferrer.this._speADLUtils.typeReference(part);
                JvmTypeReference _substituteWith = SpeADLJvmModelInferrer.this._speADLUtils.substituteWith(_typeReference, substitutor);
                JvmParameterizedTypeReference _innerTypeReference = SpeADLJvmModelInferrer.this._speADLUtils.getInnerTypeReference(_substituteWith, SpeADLJvmModelInferrer.COMPONENT_CLASS);
                _builder.append(_innerTypeReference, "");
                _builder.append(") this.");
                String _name_1 = part.getName();
                _builder.append(_name_1, "");
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
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
      }
    };
    JvmOperation _method = this._speADLJvmTypesBuilder.toMethod(comp, "start", _typeRef, _function_3);
    this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_2, _method);
    EList<Part> _parts = comp.getParts();
    for (final Part part : _parts) {
      EList<JvmMember> _members_3 = componentClass.getMembers();
      String _name = part.getName();
      String _plus = ("init_" + _name);
      JvmTypeReference _typeRef_1 = this._typeReferenceBuilder.typeRef(void.class);
      final Procedure1<JvmOperation> _function_4 = new Procedure1<JvmOperation>() {
        public void apply(final JvmOperation it) {
          it.setVisibility(JvmVisibility.PRIVATE);
          final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
            public void apply(final ITreeAppendable it) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("assert this.");
              String _name = part.getName();
              _builder.append(_name, "");
              _builder.append(" == null: \"This is a bug.\";");
              _builder.newLineIfNotEmpty();
              it.append(_builder);
              boolean _matched = false;
              if (!_matched) {
                if (part instanceof ComponentPart) {
                  _matched=true;
                  StringConcatenation _builder_1 = new StringConcatenation();
                  _builder_1.append("assert this.implem_");
                  String _name_1 = ((ComponentPart)part).getName();
                  _builder_1.append(_name_1, "");
                  _builder_1.append(" == null: \"This is a bug.\";");
                  _builder_1.newLineIfNotEmpty();
                  _builder_1.append("this.implem_");
                  String _name_2 = ((ComponentPart)part).getName();
                  _builder_1.append(_name_2, "");
                  _builder_1.append(" = this.implementation.make_");
                  String _name_3 = ((ComponentPart)part).getName();
                  _builder_1.append(_name_3, "");
                  _builder_1.append("();");
                  _builder_1.newLineIfNotEmpty();
                  _builder_1.append("if (this.implem_");
                  String _name_4 = ((ComponentPart)part).getName();
                  _builder_1.append(_name_4, "");
                  _builder_1.append(" == null) {");
                  _builder_1.newLineIfNotEmpty();
                  _builder_1.append("\t");
                  _builder_1.append("throw new RuntimeException(\"make_");
                  String _name_5 = ((ComponentPart)part).getName();
                  _builder_1.append(_name_5, "\t");
                  _builder_1.append("() in ");
                  String _qualifiedName = clazzRef.getQualifiedName();
                  _builder_1.append(_qualifiedName, "\t");
                  _builder_1.append(" should not return null.\");");
                  _builder_1.newLineIfNotEmpty();
                  _builder_1.append("}");
                  _builder_1.newLine();
                  _builder_1.append("this.");
                  String _name_6 = ((ComponentPart)part).getName();
                  _builder_1.append(_name_6, "");
                  _builder_1.append(" = this.implem_");
                  String _name_7 = ((ComponentPart)part).getName();
                  _builder_1.append(_name_7, "");
                  _builder_1.append("._newComponent(new ");
                  _builder_1.append(SpeADLJvmModelInferrer.REQUIRES_CLASS_PREFIX, "");
                  _builder_1.append("_");
                  String _name_8 = ((ComponentPart)part).getName();
                  _builder_1.append(_name_8, "");
                  _builder_1.append("(), false);");
                  _builder_1.newLineIfNotEmpty();
                  it.append(_builder_1);
                }
              }
              if (!_matched) {
                if (part instanceof SpeciesPart) {
                  _matched=true;
                  StringConcatenation _builder_1 = new StringConcatenation();
                  _builder_1.append("assert this.implementation.use_");
                  String _name_1 = ((SpeciesPart)part).getName();
                  _builder_1.append(_name_1, "");
                  _builder_1.append(" != null: \"This is a bug.\";");
                  _builder_1.newLineIfNotEmpty();
                  _builder_1.append("this.");
                  String _name_2 = ((SpeciesPart)part).getName();
                  _builder_1.append(_name_2, "");
                  _builder_1.append(" = this.implementation.use_");
                  String _name_3 = ((SpeciesPart)part).getName();
                  _builder_1.append(_name_3, "");
                  _builder_1.append("._newComponent(new ");
                  _builder_1.append(SpeADLJvmModelInferrer.REQUIRES_CLASS_PREFIX, "");
                  _builder_1.append("_");
                  SpeciesReference _speciesReference = ((SpeciesPart)part).getSpeciesReference();
                  ComponentPart _part = _speciesReference.getPart();
                  String _name_4 = _part.getName();
                  _builder_1.append(_name_4, "");
                  _builder_1.append("_");
                  String _name_5 = ((SpeciesPart)part).getName();
                  _builder_1.append(_name_5, "");
                  _builder_1.append("(), false);");
                  _builder_1.newLineIfNotEmpty();
                  it.append(_builder_1);
                }
              }
            }
          };
          SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _function);
        }
      };
      JvmOperation _method_1 = this._speADLJvmTypesBuilder.toMethod(part, _plus, _typeRef_1, _function_4);
      this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_3, _method_1);
    }
    EList<JvmMember> _members_4 = componentClass.getMembers();
    JvmTypeReference _typeRef_2 = this._typeReferenceBuilder.typeRef(void.class);
    final Procedure1<JvmOperation> _function_5 = new Procedure1<JvmOperation>() {
      public void apply(final JvmOperation it) {
        JvmParameterizedTypeReference _specializes = comp.getSpecializes();
        boolean _tripleNotEquals = (_specializes != null);
        if (_tripleNotEquals) {
          EList<JvmAnnotationReference> _annotations = it.getAnnotations();
          JvmAnnotationReference _annotationRef = SpeADLJvmModelInferrer.this._annotationTypesBuilder.annotationRef(Override.class);
          SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
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
                _builder.append(_name, "");
                _builder.append("();");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        };
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
      }
    };
    JvmOperation _method_2 = this._speADLJvmTypesBuilder.toMethod(comp, "initParts", _typeRef_2, _function_5);
    this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_4, _method_2);
    EList<ProvidedPort> _provides = comp.getProvides();
    final Function1<ProvidedPort, Boolean> _function_6 = new Function1<ProvidedPort, Boolean>() {
      public Boolean apply(final ProvidedPort it) {
        boolean _and = false;
        PortRef _bound = it.getBound();
        boolean _tripleEquals = (_bound == null);
        if (!_tripleEquals) {
          _and = false;
        } else {
          LightweightTypeReference _overridenPortTypeRef = SpeADLJvmModelInferrer.this._speADLUtils.getOverridenPortTypeRef(it);
          boolean _tripleEquals_1 = (_overridenPortTypeRef == null);
          _and = _tripleEquals_1;
        }
        return Boolean.valueOf(_and);
      }
    };
    final Iterable<ProvidedPort> providesToInit = IterableExtensions.<ProvidedPort>filter(_provides, _function_6);
    for (final ProvidedPort port : providesToInit) {
      EList<JvmMember> _members_5 = componentClass.getMembers();
      String _name_1 = port.getName();
      String _plus_1 = ("init_" + _name_1);
      JvmTypeReference _typeRef_3 = this._typeReferenceBuilder.typeRef(void.class);
      final Procedure1<JvmOperation> _function_7 = new Procedure1<JvmOperation>() {
        public void apply(final JvmOperation it) {
          it.setVisibility(JvmVisibility.PRIVATE);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("assert this.");
              String _name = port.getName();
              _builder.append(_name, "");
              _builder.append(" == null: \"This is a bug.\";");
              _builder.newLineIfNotEmpty();
              _builder.append("this.");
              String _name_1 = port.getName();
              _builder.append(_name_1, "");
              _builder.append(" = this.implementation.make_");
              String _name_2 = port.getName();
              _builder.append(_name_2, "");
              _builder.append("();");
              _builder.newLineIfNotEmpty();
              _builder.append("if (this.");
              String _name_3 = port.getName();
              _builder.append(_name_3, "");
              _builder.append(" == null) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("throw new RuntimeException(\"make_");
              String _name_4 = port.getName();
              _builder.append(_name_4, "\t");
              _builder.append("() in ");
              String _qualifiedName = clazzRef.getQualifiedName();
              _builder.append(_qualifiedName, "\t");
              _builder.append(" should not return null.\");");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
            }
          };
          SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
        }
      };
      JvmOperation _method_3 = this._speADLJvmTypesBuilder.toMethod(port, _plus_1, _typeRef_3, _function_7);
      this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_5, _method_3);
    }
    EList<JvmMember> _members_6 = componentClass.getMembers();
    JvmTypeReference _typeRef_4 = this._typeReferenceBuilder.typeRef(void.class);
    final Procedure1<JvmOperation> _function_8 = new Procedure1<JvmOperation>() {
      public void apply(final JvmOperation it) {
        JvmParameterizedTypeReference _specializes = comp.getSpecializes();
        boolean _tripleNotEquals = (_specializes != null);
        if (_tripleNotEquals) {
          EList<JvmAnnotationReference> _annotations = it.getAnnotations();
          JvmAnnotationReference _annotationRef = SpeADLJvmModelInferrer.this._annotationTypesBuilder.annotationRef(Override.class);
          SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
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
              for(final ProvidedPort port : providesToInit) {
                _builder.append("init_");
                String _name = port.getName();
                _builder.append(_name, "");
                _builder.append("();");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        };
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
      }
    };
    JvmOperation _method_4 = this._speADLJvmTypesBuilder.toMethod(comp, "initProvidedPorts", _typeRef_4, _function_8);
    this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_6, _method_4);
    EList<JvmMember> _members_7 = componentClass.getMembers();
    final Procedure1<JvmConstructor> _function_9 = new Procedure1<JvmConstructor>() {
      public void apply(final JvmConstructor it) {
        EList<JvmFormalParameter> _parameters = it.getParameters();
        JvmFormalParameter _newParameter = SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.newParameter("implem", clazzRef);
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _newParameter);
        EList<JvmFormalParameter> _parameters_1 = it.getParameters();
        JvmFormalParameter _newParameter_1 = SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.newParameter("b", requiresRef);
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _newParameter_1);
        EList<JvmFormalParameter> _parameters_2 = it.getParameters();
        JvmTypeReference _typeRef = SpeADLJvmModelInferrer.this._typeReferenceBuilder.typeRef(boolean.class);
        JvmFormalParameter _newParameter_2 = SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.newParameter("doInits", _typeRef);
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_2, _newParameter_2);
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
        SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
      }
    };
    JvmConstructor _newConstructor = this._speADLJvmTypesBuilder.newConstructor(_function_9);
    this._speADLJvmTypesBuilder.<JvmConstructor>operator_add(_members_7, _newConstructor);
    EList<ProvidedPort> _provides_1 = comp.getProvides();
    for (final ProvidedPort port_1 : _provides_1) {
      {
        final PortRef bound = port_1.getBound();
        JvmParameterizedTypeReference _typeReference = port_1.getTypeReference();
        final JvmTypeReference ptr = this._speADLUtils.substituteWith(_typeReference, substitutor);
        LightweightTypeReference _overridenPortTypeRef = this._speADLUtils.getOverridenPortTypeRef(port_1);
        final boolean isOverride = (_overridenPortTypeRef != null);
        boolean _and = false;
        boolean _tripleEquals = (bound == null);
        if (!_tripleEquals) {
          _and = false;
        } else {
          _and = (!isOverride);
        }
        if (_and) {
          EList<JvmMember> _members_8 = componentClass.getMembers();
          String _name_2 = port_1.getName();
          final Procedure1<JvmField> _function_10 = new Procedure1<JvmField>() {
            public void apply(final JvmField it) {
            }
          };
          JvmField _newField_2 = this._speADLJvmTypesBuilder.newField(_name_2, ptr, _function_10);
          this._speADLJvmTypesBuilder.<JvmField>operator_add(_members_8, _newField_2);
        }
        EList<JvmMember> _members_9 = componentClass.getMembers();
        String _name_3 = port_1.getName();
        final Procedure1<JvmOperation> _function_11 = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            if (isOverride) {
              EList<JvmAnnotationReference> _annotations = it.getAnnotations();
              JvmAnnotationReference _annotationRef = SpeADLJvmModelInferrer.this._annotationTypesBuilder.annotationRef(Override.class);
              SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
              StringConcatenationClient _client = new StringConcatenationClient() {
                @Override
                protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                  _builder.append("// it\'s ok to cast because make_");
                  String _name = port_1.getName();
                  _builder.append(_name, "");
                  _builder.append("()");
                  _builder.newLineIfNotEmpty();
                  _builder.append("// fill the parent class ");
                  String _name_1 = port_1.getName();
                  _builder.append(_name_1, "");
                  _builder.append(" field with the correct type");
                  _builder.newLineIfNotEmpty();
                  _builder.append("return (");
                  _builder.append(ptr, "");
                  _builder.append(") super.");
                  String _name_2 = port_1.getName();
                  _builder.append(_name_2, "");
                  _builder.append("();");
                  _builder.newLineIfNotEmpty();
                }
              };
              SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
            } else {
              final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
                public void apply(final ITreeAppendable it) {
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("return this.");
                  it.append(_builder);
                  boolean _tripleEquals = (bound == null);
                  if (_tripleEquals) {
                    String _name = port_1.getName();
                    it.append(_name);
                  } else {
                    SpeADLJvmModelInferrer.this.appendPortRefCall(it, bound, (comp instanceof Species));
                  }
                  it.append(";");
                }
              };
              SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _function);
            }
          }
        };
        JvmOperation _method_5 = this._speADLJvmTypesBuilder.toMethod(port_1, _name_3, ptr, _function_11);
        this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_9, _method_5);
      }
    }
    EList<Part> _parts_1 = comp.getParts();
    for (final Part part_1 : _parts_1) {
      {
        final JvmParameterizedTypeReference tr = this._speADLUtils.typeReference(part_1);
        final JvmTypeReference nptr = this._speADLUtils.substituteWith(tr, substitutor);
        final JvmParameterizedTypeReference ctr = this._speADLUtils.getInnerTypeReference(nptr, SpeADLJvmModelInferrer.COMPONENT_INTERFACE);
        EList<JvmMember> _members_8 = componentClass.getMembers();
        String _name_2 = part_1.getName();
        final Procedure1<JvmField> _function_10 = new Procedure1<JvmField>() {
          public void apply(final JvmField it) {
          }
        };
        JvmField _newField_2 = this._speADLJvmTypesBuilder.newField(_name_2, ctr, _function_10);
        this._speADLJvmTypesBuilder.<JvmField>operator_add(_members_8, _newField_2);
        boolean _matched = false;
        if (!_matched) {
          if (part_1 instanceof ComponentPart) {
            _matched=true;
            EList<JvmMember> _members_9 = componentClass.getMembers();
            String _name_3 = ((ComponentPart)part_1).getName();
            String _plus_2 = ("implem_" + _name_3);
            final Procedure1<JvmField> _function_11 = new Procedure1<JvmField>() {
              public void apply(final JvmField it) {
              }
            };
            JvmField _newField_3 = this._speADLJvmTypesBuilder.newField(_plus_2, nptr, _function_11);
            this._speADLJvmTypesBuilder.<JvmField>operator_add(_members_9, _newField_3);
          }
        }
        String _switchResult_1 = null;
        boolean _matched_1 = false;
        if (!_matched_1) {
          if (part_1 instanceof ComponentPart) {
            _matched_1=true;
            _switchResult_1 = ((ComponentPart)part_1).getName();
          }
        }
        if (!_matched_1) {
          if (part_1 instanceof SpeciesPart) {
            _matched_1=true;
            SpeciesReference _speciesReference = ((SpeciesPart)part_1).getSpeciesReference();
            ComponentPart _part = _speciesReference.getPart();
            String _name_3 = _part.getName();
            String _plus_2 = (_name_3 + "_");
            String _name_4 = ((SpeciesPart)part_1).getName();
            _switchResult_1 = (_plus_2 + _name_4);
          }
        }
        final String bridgePartName = _switchResult_1;
        EList<JvmMember> _members_9 = componentClass.getMembers();
        final Procedure1<JvmGenericType> _function_11 = new Procedure1<JvmGenericType>() {
          public void apply(final JvmGenericType it) {
            it.setVisibility(JvmVisibility.PRIVATE);
            it.setFinal(true);
            EList<JvmTypeReference> _superTypes = it.getSuperTypes();
            JvmTypeReference _rootSupertype = SpeADLJvmModelInferrer.this._speADLUtils.rootSupertype(nptr);
            JvmParameterizedTypeReference _innerTypeReference = SpeADLJvmModelInferrer.this._speADLUtils.getInnerTypeReference(_rootSupertype, SpeADLJvmModelInferrer.REQUIRES_INTERFACE);
            SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmParameterizedTypeReference>operator_add(_superTypes, _innerTypeReference);
            EList<Binding> _bindings = part_1.getBindings();
            for (final Binding binding : _bindings) {
              {
                final PortRef bound = binding.getTo();
                LightweightTypeReference _resolveTypeFrom = SpeADLJvmModelInferrer.this._speADLUtils.resolveTypeFrom(binding);
                LightweightTypeReference _substituteWith = SpeADLJvmModelInferrer.this._speADLUtils.substituteWith(_resolveTypeFrom, substitutor);
                final JvmTypeReference rt = _substituteWith.toJavaCompliantTypeReference();
                EList<JvmMember> _members = it.getMembers();
                RequiredPort _from = binding.getFrom();
                String _name = _from.getName();
                final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                  public void apply(final JvmOperation it) {
                    it.setFinal(true);
                    final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
                      public void apply(final ITreeAppendable it) {
                        it.append("return ");
                        it.append(componentClass);
                        it.append(".this.");
                        SpeADLJvmModelInferrer.this.appendPortRefCall(it, bound, (comp instanceof Species));
                        it.append(";");
                      }
                    };
                    SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _function);
                  }
                };
                JvmOperation _method = SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.toMethod(binding, _name, rt, _function);
                SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
              }
            }
          }
        };
        JvmGenericType _newClass = this._speADLJvmTypesBuilder.newClass(((SpeADLJvmModelInferrer.REQUIRES_CLASS_PREFIX + "_") + bridgePartName), _function_11);
        this._speADLJvmTypesBuilder.<JvmGenericType>operator_add(_members_9, _newClass);
        EList<JvmMember> _members_10 = componentClass.getMembers();
        String _name_3 = part_1.getName();
        final Procedure1<JvmOperation> _function_12 = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            it.setFinal(true);
            StringConcatenationClient _client = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                _builder.append("return this.");
                String _name = part_1.getName();
                _builder.append(_name, "");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            };
            SpeADLJvmModelInferrer.this._speADLJvmTypesBuilder.setBody(it, _client);
          }
        };
        JvmOperation _method_5 = this._speADLJvmTypesBuilder.toMethod(part_1, _name_3, ctr, _function_12);
        this._speADLJvmTypesBuilder.<JvmOperation>operator_add(_members_10, _method_5);
      }
    }
  }
  
  private void appendPortRefCall(final IAppendable it, final PortRef bound, final boolean inSpecies) {
    Part _part = bound.getPart();
    boolean _tripleNotEquals = (_part != null);
    if (_tripleNotEquals) {
      boolean _and = false;
      if (!inSpecies) {
        _and = false;
      } else {
        Part _part_1 = bound.getPart();
        EObject _eContainer = _part_1.eContainer();
        _and = (_eContainer instanceof Ecosystem);
      }
      if (_and) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("implementation.ecosystemComponent.");
        it.append(_builder);
      }
      StringConcatenation _builder_1 = new StringConcatenation();
      Part _part_2 = bound.getPart();
      String _name = _part_2.getName();
      _builder_1.append(_name, "");
      _builder_1.append("().");
      it.append(_builder_1);
    } else {
      boolean _and_1 = false;
      if (!inSpecies) {
        _and_1 = false;
      } else {
        Port _port = bound.getPort();
        EObject _eContainer_1 = _port.eContainer();
        _and_1 = (_eContainer_1 instanceof Ecosystem);
      }
      if (_and_1) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("implementation.ecosystemComponent.");
        it.append(_builder_2);
      }
      Port _port_1 = bound.getPort();
      boolean _matched = false;
      if (!_matched) {
        if (_port_1 instanceof RequiredPort) {
          _matched=true;
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("bridge.");
          it.append(_builder_3);
        }
      }
    }
    StringConcatenation _builder_3 = new StringConcatenation();
    Port _port_2 = bound.getPort();
    String _name_1 = _port_2.getName();
    _builder_3.append(_name_1, "");
    _builder_3.append("()");
    it.append(_builder_3);
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
