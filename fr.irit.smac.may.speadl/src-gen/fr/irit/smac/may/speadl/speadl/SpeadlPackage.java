/**
 */
package fr.irit.smac.may.speadl.speadl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.irit.smac.may.speadl.speadl.SpeadlFactory
 * @model kind="package"
 * @generated
 */
public interface SpeadlPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "speadl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.irit.fr/smac/may/speadl/SpeADL";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "speadl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SpeadlPackage eINSTANCE = fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl.init();

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.ModelImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__IMPORTS = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ELEMENTS = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.ModelElementImpl <em>Model Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.ModelElementImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getModelElement()
   * @generated
   */
  int MODEL_ELEMENT = 2;

  /**
   * The number of structural features of the '<em>Model Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.NamespaceImpl <em>Namespace</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.NamespaceImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getNamespace()
   * @generated
   */
  int NAMESPACE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMESPACE__NAME = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMESPACE__ELEMENTS = MODEL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Namespace</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMESPACE_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.ElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.ElementImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getElement()
   * @generated
   */
  int ELEMENT = 3;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.AbstractComponentImpl <em>Abstract Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.AbstractComponentImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getAbstractComponent()
   * @generated
   */
  int ABSTRACT_COMPONENT = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_COMPONENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_COMPONENT__PARAMETERS = 1;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_COMPONENT__TYPE_PARAMETERS = 2;

  /**
   * The feature id for the '<em><b>Specializes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_COMPONENT__SPECIALIZES = 3;

  /**
   * The feature id for the '<em><b>Provides</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_COMPONENT__PROVIDES = 4;

  /**
   * The feature id for the '<em><b>Requires</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_COMPONENT__REQUIRES = 5;

  /**
   * The feature id for the '<em><b>Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_COMPONENT__PARTS = 6;

  /**
   * The feature id for the '<em><b>Species</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_COMPONENT__SPECIES = 7;

  /**
   * The number of structural features of the '<em>Abstract Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_COMPONENT_FEATURE_COUNT = 8;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.ContentElementImpl <em>Content Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.ContentElementImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getContentElement()
   * @generated
   */
  int CONTENT_ELEMENT = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTENT_ELEMENT__NAME = 0;

  /**
   * The number of structural features of the '<em>Content Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTENT_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.PortImpl <em>Port</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.PortImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getPort()
   * @generated
   */
  int PORT = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__NAME = CONTENT_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Type Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__TYPE_REFERENCE = CONTENT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Port</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FEATURE_COUNT = CONTENT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.PartImpl <em>Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.PartImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getPart()
   * @generated
   */
  int PART = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PART__NAME = CONTENT_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PART__BINDINGS = CONTENT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PART_FEATURE_COUNT = CONTENT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.FeatureImpl <em>Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.FeatureImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getFeature()
   * @generated
   */
  int FEATURE = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__NAME = 0;

  /**
   * The feature id for the '<em><b>Parameter Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__PARAMETER_TYPE = 1;

  /**
   * The number of structural features of the '<em>Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.ImplementedByImpl <em>Implemented By</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.ImplementedByImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getImplementedBy()
   * @generated
   */
  int IMPLEMENTED_BY = 9;

  /**
   * The feature id for the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTED_BY__REF = 0;

  /**
   * The number of structural features of the '<em>Implemented By</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTED_BY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.EcosystemImpl <em>Ecosystem</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.EcosystemImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getEcosystem()
   * @generated
   */
  int ECOSYSTEM = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECOSYSTEM__NAME = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECOSYSTEM__PARAMETERS = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECOSYSTEM__TYPE_PARAMETERS = ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Specializes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECOSYSTEM__SPECIALIZES = ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Provides</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECOSYSTEM__PROVIDES = ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Requires</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECOSYSTEM__REQUIRES = ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECOSYSTEM__PARTS = ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Species</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECOSYSTEM__SPECIES = ELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Implemented By</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECOSYSTEM__IMPLEMENTED_BY = ELEMENT_FEATURE_COUNT + 8;

  /**
   * The number of structural features of the '<em>Ecosystem</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECOSYSTEM_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 9;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.SpeciesImpl <em>Species</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeciesImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getSpecies()
   * @generated
   */
  int SPECIES = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES__NAME = ABSTRACT_COMPONENT__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES__PARAMETERS = ABSTRACT_COMPONENT__PARAMETERS;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES__TYPE_PARAMETERS = ABSTRACT_COMPONENT__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Specializes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES__SPECIALIZES = ABSTRACT_COMPONENT__SPECIALIZES;

  /**
   * The feature id for the '<em><b>Provides</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES__PROVIDES = ABSTRACT_COMPONENT__PROVIDES;

  /**
   * The feature id for the '<em><b>Requires</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES__REQUIRES = ABSTRACT_COMPONENT__REQUIRES;

  /**
   * The feature id for the '<em><b>Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES__PARTS = ABSTRACT_COMPONENT__PARTS;

  /**
   * The feature id for the '<em><b>Species</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES__SPECIES = ABSTRACT_COMPONENT__SPECIES;

  /**
   * The number of structural features of the '<em>Species</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES_FEATURE_COUNT = ABSTRACT_COMPONENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.ProvidedPortImpl <em>Provided Port</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.ProvidedPortImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getProvidedPort()
   * @generated
   */
  int PROVIDED_PORT = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVIDED_PORT__NAME = PORT__NAME;

  /**
   * The feature id for the '<em><b>Type Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVIDED_PORT__TYPE_REFERENCE = PORT__TYPE_REFERENCE;

  /**
   * The feature id for the '<em><b>Bound</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVIDED_PORT__BOUND = PORT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Provided Port</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVIDED_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.RequiredPortImpl <em>Required Port</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.RequiredPortImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getRequiredPort()
   * @generated
   */
  int REQUIRED_PORT = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRED_PORT__NAME = PORT__NAME;

  /**
   * The feature id for the '<em><b>Type Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRED_PORT__TYPE_REFERENCE = PORT__TYPE_REFERENCE;

  /**
   * The number of structural features of the '<em>Required Port</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRED_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.ComponentPartImpl <em>Component Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.ComponentPartImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getComponentPart()
   * @generated
   */
  int COMPONENT_PART = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_PART__NAME = PART__NAME;

  /**
   * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_PART__BINDINGS = PART__BINDINGS;

  /**
   * The feature id for the '<em><b>Component Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_PART__COMPONENT_REFERENCE = PART_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Component Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_PART_FEATURE_COUNT = PART_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.SpeciesPartImpl <em>Species Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeciesPartImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getSpeciesPart()
   * @generated
   */
  int SPECIES_PART = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES_PART__NAME = PART__NAME;

  /**
   * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES_PART__BINDINGS = PART__BINDINGS;

  /**
   * The feature id for the '<em><b>Species Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES_PART__SPECIES_REFERENCE = PART_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Species Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES_PART_FEATURE_COUNT = PART_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.BindingImpl <em>Binding</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.BindingImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getBinding()
   * @generated
   */
  int BINDING = 16;

  /**
   * The feature id for the '<em><b>From</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINDING__FROM = 0;

  /**
   * The feature id for the '<em><b>To</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINDING__TO = 1;

  /**
   * The number of structural features of the '<em>Binding</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINDING_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.PortRefImpl <em>Port Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.PortRefImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getPortRef()
   * @generated
   */
  int PORT_REF = 17;

  /**
   * The feature id for the '<em><b>Part</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_REF__PART = 0;

  /**
   * The feature id for the '<em><b>Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_REF__PORT = 1;

  /**
   * The number of structural features of the '<em>Port Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_REF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.irit.smac.may.speadl.speadl.impl.SpeciesReferenceImpl <em>Species Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeciesReferenceImpl
   * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getSpeciesReference()
   * @generated
   */
  int SPECIES_REFERENCE = 18;

  /**
   * The feature id for the '<em><b>Part</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES_REFERENCE__PART = 0;

  /**
   * The feature id for the '<em><b>Species</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES_REFERENCE__SPECIES = 1;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES_REFERENCE__ARGUMENTS = 2;

  /**
   * The number of structural features of the '<em>Species Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIES_REFERENCE_FEATURE_COUNT = 3;


  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link fr.irit.smac.may.speadl.speadl.Model#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Imports</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Model#getImports()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link fr.irit.smac.may.speadl.speadl.Model#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Model#getElements()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Elements();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.Namespace <em>Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Namespace</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Namespace
   * @generated
   */
  EClass getNamespace();

  /**
   * Returns the meta object for the attribute '{@link fr.irit.smac.may.speadl.speadl.Namespace#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Namespace#getName()
   * @see #getNamespace()
   * @generated
   */
  EAttribute getNamespace_Name();

  /**
   * Returns the meta object for the containment reference list '{@link fr.irit.smac.may.speadl.speadl.Namespace#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Namespace#getElements()
   * @see #getNamespace()
   * @generated
   */
  EReference getNamespace_Elements();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.ModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Element</em>'.
   * @see fr.irit.smac.may.speadl.speadl.ModelElement
   * @generated
   */
  EClass getModelElement();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Element
   * @generated
   */
  EClass getElement();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.AbstractComponent <em>Abstract Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Component</em>'.
   * @see fr.irit.smac.may.speadl.speadl.AbstractComponent
   * @generated
   */
  EClass getAbstractComponent();

  /**
   * Returns the meta object for the attribute '{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.irit.smac.may.speadl.speadl.AbstractComponent#getName()
   * @see #getAbstractComponent()
   * @generated
   */
  EAttribute getAbstractComponent_Name();

  /**
   * Returns the meta object for the containment reference list '{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see fr.irit.smac.may.speadl.speadl.AbstractComponent#getParameters()
   * @see #getAbstractComponent()
   * @generated
   */
  EReference getAbstractComponent_Parameters();

  /**
   * Returns the meta object for the containment reference list '{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getTypeParameters <em>Type Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
   * @see fr.irit.smac.may.speadl.speadl.AbstractComponent#getTypeParameters()
   * @see #getAbstractComponent()
   * @generated
   */
  EReference getAbstractComponent_TypeParameters();

  /**
   * Returns the meta object for the containment reference '{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getSpecializes <em>Specializes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Specializes</em>'.
   * @see fr.irit.smac.may.speadl.speadl.AbstractComponent#getSpecializes()
   * @see #getAbstractComponent()
   * @generated
   */
  EReference getAbstractComponent_Specializes();

  /**
   * Returns the meta object for the containment reference list '{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getProvides <em>Provides</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Provides</em>'.
   * @see fr.irit.smac.may.speadl.speadl.AbstractComponent#getProvides()
   * @see #getAbstractComponent()
   * @generated
   */
  EReference getAbstractComponent_Provides();

  /**
   * Returns the meta object for the containment reference list '{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getRequires <em>Requires</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Requires</em>'.
   * @see fr.irit.smac.may.speadl.speadl.AbstractComponent#getRequires()
   * @see #getAbstractComponent()
   * @generated
   */
  EReference getAbstractComponent_Requires();

  /**
   * Returns the meta object for the containment reference list '{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getParts <em>Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parts</em>'.
   * @see fr.irit.smac.may.speadl.speadl.AbstractComponent#getParts()
   * @see #getAbstractComponent()
   * @generated
   */
  EReference getAbstractComponent_Parts();

  /**
   * Returns the meta object for the containment reference list '{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getSpecies <em>Species</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Species</em>'.
   * @see fr.irit.smac.may.speadl.speadl.AbstractComponent#getSpecies()
   * @see #getAbstractComponent()
   * @generated
   */
  EReference getAbstractComponent_Species();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.Port <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Port
   * @generated
   */
  EClass getPort();

  /**
   * Returns the meta object for the containment reference '{@link fr.irit.smac.may.speadl.speadl.Port#getTypeReference <em>Type Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type Reference</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Port#getTypeReference()
   * @see #getPort()
   * @generated
   */
  EReference getPort_TypeReference();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.ContentElement <em>Content Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Content Element</em>'.
   * @see fr.irit.smac.may.speadl.speadl.ContentElement
   * @generated
   */
  EClass getContentElement();

  /**
   * Returns the meta object for the attribute '{@link fr.irit.smac.may.speadl.speadl.ContentElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.irit.smac.may.speadl.speadl.ContentElement#getName()
   * @see #getContentElement()
   * @generated
   */
  EAttribute getContentElement_Name();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.Part <em>Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Part</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Part
   * @generated
   */
  EClass getPart();

  /**
   * Returns the meta object for the containment reference list '{@link fr.irit.smac.may.speadl.speadl.Part#getBindings <em>Bindings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Bindings</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Part#getBindings()
   * @see #getPart()
   * @generated
   */
  EReference getPart_Bindings();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.Feature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Feature
   * @generated
   */
  EClass getFeature();

  /**
   * Returns the meta object for the attribute '{@link fr.irit.smac.may.speadl.speadl.Feature#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Feature#getName()
   * @see #getFeature()
   * @generated
   */
  EAttribute getFeature_Name();

  /**
   * Returns the meta object for the containment reference '{@link fr.irit.smac.may.speadl.speadl.Feature#getParameterType <em>Parameter Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parameter Type</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Feature#getParameterType()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_ParameterType();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.ImplementedBy <em>Implemented By</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Implemented By</em>'.
   * @see fr.irit.smac.may.speadl.speadl.ImplementedBy
   * @generated
   */
  EClass getImplementedBy();

  /**
   * Returns the meta object for the containment reference '{@link fr.irit.smac.may.speadl.speadl.ImplementedBy#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ref</em>'.
   * @see fr.irit.smac.may.speadl.speadl.ImplementedBy#getRef()
   * @see #getImplementedBy()
   * @generated
   */
  EReference getImplementedBy_Ref();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.Ecosystem <em>Ecosystem</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ecosystem</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Ecosystem
   * @generated
   */
  EClass getEcosystem();

  /**
   * Returns the meta object for the containment reference '{@link fr.irit.smac.may.speadl.speadl.Ecosystem#getImplementedBy <em>Implemented By</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Implemented By</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Ecosystem#getImplementedBy()
   * @see #getEcosystem()
   * @generated
   */
  EReference getEcosystem_ImplementedBy();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.Species <em>Species</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Species</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Species
   * @generated
   */
  EClass getSpecies();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.ProvidedPort <em>Provided Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Provided Port</em>'.
   * @see fr.irit.smac.may.speadl.speadl.ProvidedPort
   * @generated
   */
  EClass getProvidedPort();

  /**
   * Returns the meta object for the containment reference '{@link fr.irit.smac.may.speadl.speadl.ProvidedPort#getBound <em>Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Bound</em>'.
   * @see fr.irit.smac.may.speadl.speadl.ProvidedPort#getBound()
   * @see #getProvidedPort()
   * @generated
   */
  EReference getProvidedPort_Bound();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.RequiredPort <em>Required Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Required Port</em>'.
   * @see fr.irit.smac.may.speadl.speadl.RequiredPort
   * @generated
   */
  EClass getRequiredPort();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.ComponentPart <em>Component Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component Part</em>'.
   * @see fr.irit.smac.may.speadl.speadl.ComponentPart
   * @generated
   */
  EClass getComponentPart();

  /**
   * Returns the meta object for the containment reference '{@link fr.irit.smac.may.speadl.speadl.ComponentPart#getComponentReference <em>Component Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Component Reference</em>'.
   * @see fr.irit.smac.may.speadl.speadl.ComponentPart#getComponentReference()
   * @see #getComponentPart()
   * @generated
   */
  EReference getComponentPart_ComponentReference();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.SpeciesPart <em>Species Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Species Part</em>'.
   * @see fr.irit.smac.may.speadl.speadl.SpeciesPart
   * @generated
   */
  EClass getSpeciesPart();

  /**
   * Returns the meta object for the containment reference '{@link fr.irit.smac.may.speadl.speadl.SpeciesPart#getSpeciesReference <em>Species Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Species Reference</em>'.
   * @see fr.irit.smac.may.speadl.speadl.SpeciesPart#getSpeciesReference()
   * @see #getSpeciesPart()
   * @generated
   */
  EReference getSpeciesPart_SpeciesReference();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.Binding <em>Binding</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binding</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Binding
   * @generated
   */
  EClass getBinding();

  /**
   * Returns the meta object for the reference '{@link fr.irit.smac.may.speadl.speadl.Binding#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>From</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Binding#getFrom()
   * @see #getBinding()
   * @generated
   */
  EReference getBinding_From();

  /**
   * Returns the meta object for the containment reference '{@link fr.irit.smac.may.speadl.speadl.Binding#getTo <em>To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>To</em>'.
   * @see fr.irit.smac.may.speadl.speadl.Binding#getTo()
   * @see #getBinding()
   * @generated
   */
  EReference getBinding_To();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.PortRef <em>Port Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Ref</em>'.
   * @see fr.irit.smac.may.speadl.speadl.PortRef
   * @generated
   */
  EClass getPortRef();

  /**
   * Returns the meta object for the reference '{@link fr.irit.smac.may.speadl.speadl.PortRef#getPart <em>Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Part</em>'.
   * @see fr.irit.smac.may.speadl.speadl.PortRef#getPart()
   * @see #getPortRef()
   * @generated
   */
  EReference getPortRef_Part();

  /**
   * Returns the meta object for the reference '{@link fr.irit.smac.may.speadl.speadl.PortRef#getPort <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Port</em>'.
   * @see fr.irit.smac.may.speadl.speadl.PortRef#getPort()
   * @see #getPortRef()
   * @generated
   */
  EReference getPortRef_Port();

  /**
   * Returns the meta object for class '{@link fr.irit.smac.may.speadl.speadl.SpeciesReference <em>Species Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Species Reference</em>'.
   * @see fr.irit.smac.may.speadl.speadl.SpeciesReference
   * @generated
   */
  EClass getSpeciesReference();

  /**
   * Returns the meta object for the reference '{@link fr.irit.smac.may.speadl.speadl.SpeciesReference#getPart <em>Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Part</em>'.
   * @see fr.irit.smac.may.speadl.speadl.SpeciesReference#getPart()
   * @see #getSpeciesReference()
   * @generated
   */
  EReference getSpeciesReference_Part();

  /**
   * Returns the meta object for the reference '{@link fr.irit.smac.may.speadl.speadl.SpeciesReference#getSpecies <em>Species</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Species</em>'.
   * @see fr.irit.smac.may.speadl.speadl.SpeciesReference#getSpecies()
   * @see #getSpeciesReference()
   * @generated
   */
  EReference getSpeciesReference_Species();

  /**
   * Returns the meta object for the reference list '{@link fr.irit.smac.may.speadl.speadl.SpeciesReference#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Arguments</em>'.
   * @see fr.irit.smac.may.speadl.speadl.SpeciesReference#getArguments()
   * @see #getSpeciesReference()
   * @generated
   */
  EReference getSpeciesReference_Arguments();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SpeadlFactory getSpeadlFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.ModelImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__IMPORTS = eINSTANCE.getModel_Imports();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ELEMENTS = eINSTANCE.getModel_Elements();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.NamespaceImpl <em>Namespace</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.NamespaceImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getNamespace()
     * @generated
     */
    EClass NAMESPACE = eINSTANCE.getNamespace();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMESPACE__NAME = eINSTANCE.getNamespace_Name();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMESPACE__ELEMENTS = eINSTANCE.getNamespace_Elements();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.ModelElementImpl <em>Model Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.ModelElementImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getModelElement()
     * @generated
     */
    EClass MODEL_ELEMENT = eINSTANCE.getModelElement();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.ElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.ElementImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getElement()
     * @generated
     */
    EClass ELEMENT = eINSTANCE.getElement();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.AbstractComponentImpl <em>Abstract Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.AbstractComponentImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getAbstractComponent()
     * @generated
     */
    EClass ABSTRACT_COMPONENT = eINSTANCE.getAbstractComponent();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_COMPONENT__NAME = eINSTANCE.getAbstractComponent_Name();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_COMPONENT__PARAMETERS = eINSTANCE.getAbstractComponent_Parameters();

    /**
     * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_COMPONENT__TYPE_PARAMETERS = eINSTANCE.getAbstractComponent_TypeParameters();

    /**
     * The meta object literal for the '<em><b>Specializes</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_COMPONENT__SPECIALIZES = eINSTANCE.getAbstractComponent_Specializes();

    /**
     * The meta object literal for the '<em><b>Provides</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_COMPONENT__PROVIDES = eINSTANCE.getAbstractComponent_Provides();

    /**
     * The meta object literal for the '<em><b>Requires</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_COMPONENT__REQUIRES = eINSTANCE.getAbstractComponent_Requires();

    /**
     * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_COMPONENT__PARTS = eINSTANCE.getAbstractComponent_Parts();

    /**
     * The meta object literal for the '<em><b>Species</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_COMPONENT__SPECIES = eINSTANCE.getAbstractComponent_Species();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.PortImpl <em>Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.PortImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getPort()
     * @generated
     */
    EClass PORT = eINSTANCE.getPort();

    /**
     * The meta object literal for the '<em><b>Type Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT__TYPE_REFERENCE = eINSTANCE.getPort_TypeReference();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.ContentElementImpl <em>Content Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.ContentElementImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getContentElement()
     * @generated
     */
    EClass CONTENT_ELEMENT = eINSTANCE.getContentElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTENT_ELEMENT__NAME = eINSTANCE.getContentElement_Name();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.PartImpl <em>Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.PartImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getPart()
     * @generated
     */
    EClass PART = eINSTANCE.getPart();

    /**
     * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PART__BINDINGS = eINSTANCE.getPart_Bindings();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.FeatureImpl <em>Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.FeatureImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getFeature()
     * @generated
     */
    EClass FEATURE = eINSTANCE.getFeature();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

    /**
     * The meta object literal for the '<em><b>Parameter Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__PARAMETER_TYPE = eINSTANCE.getFeature_ParameterType();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.ImplementedByImpl <em>Implemented By</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.ImplementedByImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getImplementedBy()
     * @generated
     */
    EClass IMPLEMENTED_BY = eINSTANCE.getImplementedBy();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPLEMENTED_BY__REF = eINSTANCE.getImplementedBy_Ref();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.EcosystemImpl <em>Ecosystem</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.EcosystemImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getEcosystem()
     * @generated
     */
    EClass ECOSYSTEM = eINSTANCE.getEcosystem();

    /**
     * The meta object literal for the '<em><b>Implemented By</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ECOSYSTEM__IMPLEMENTED_BY = eINSTANCE.getEcosystem_ImplementedBy();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.SpeciesImpl <em>Species</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeciesImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getSpecies()
     * @generated
     */
    EClass SPECIES = eINSTANCE.getSpecies();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.ProvidedPortImpl <em>Provided Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.ProvidedPortImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getProvidedPort()
     * @generated
     */
    EClass PROVIDED_PORT = eINSTANCE.getProvidedPort();

    /**
     * The meta object literal for the '<em><b>Bound</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROVIDED_PORT__BOUND = eINSTANCE.getProvidedPort_Bound();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.RequiredPortImpl <em>Required Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.RequiredPortImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getRequiredPort()
     * @generated
     */
    EClass REQUIRED_PORT = eINSTANCE.getRequiredPort();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.ComponentPartImpl <em>Component Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.ComponentPartImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getComponentPart()
     * @generated
     */
    EClass COMPONENT_PART = eINSTANCE.getComponentPart();

    /**
     * The meta object literal for the '<em><b>Component Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_PART__COMPONENT_REFERENCE = eINSTANCE.getComponentPart_ComponentReference();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.SpeciesPartImpl <em>Species Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeciesPartImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getSpeciesPart()
     * @generated
     */
    EClass SPECIES_PART = eINSTANCE.getSpeciesPart();

    /**
     * The meta object literal for the '<em><b>Species Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIES_PART__SPECIES_REFERENCE = eINSTANCE.getSpeciesPart_SpeciesReference();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.BindingImpl <em>Binding</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.BindingImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getBinding()
     * @generated
     */
    EClass BINDING = eINSTANCE.getBinding();

    /**
     * The meta object literal for the '<em><b>From</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINDING__FROM = eINSTANCE.getBinding_From();

    /**
     * The meta object literal for the '<em><b>To</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINDING__TO = eINSTANCE.getBinding_To();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.PortRefImpl <em>Port Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.PortRefImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getPortRef()
     * @generated
     */
    EClass PORT_REF = eINSTANCE.getPortRef();

    /**
     * The meta object literal for the '<em><b>Part</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_REF__PART = eINSTANCE.getPortRef_Part();

    /**
     * The meta object literal for the '<em><b>Port</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_REF__PORT = eINSTANCE.getPortRef_Port();

    /**
     * The meta object literal for the '{@link fr.irit.smac.may.speadl.speadl.impl.SpeciesReferenceImpl <em>Species Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeciesReferenceImpl
     * @see fr.irit.smac.may.speadl.speadl.impl.SpeadlPackageImpl#getSpeciesReference()
     * @generated
     */
    EClass SPECIES_REFERENCE = eINSTANCE.getSpeciesReference();

    /**
     * The meta object literal for the '<em><b>Part</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIES_REFERENCE__PART = eINSTANCE.getSpeciesReference_Part();

    /**
     * The meta object literal for the '<em><b>Species</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIES_REFERENCE__SPECIES = eINSTANCE.getSpeciesReference_Species();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIES_REFERENCE__ARGUMENTS = eINSTANCE.getSpeciesReference_Arguments();

  }

} //SpeadlPackage
