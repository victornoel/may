/**
 */
package fr.irit.smac.may.speadl.speadl.impl;

import fr.irit.smac.may.speadl.speadl.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpeadlFactoryImpl extends EFactoryImpl implements SpeadlFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SpeadlFactory init()
  {
    try
    {
      SpeadlFactory theSpeadlFactory = (SpeadlFactory)EPackage.Registry.INSTANCE.getEFactory(SpeadlPackage.eNS_URI);
      if (theSpeadlFactory != null)
      {
        return theSpeadlFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SpeadlFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpeadlFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case SpeadlPackage.MODEL: return createModel();
      case SpeadlPackage.NAMESPACE: return createNamespace();
      case SpeadlPackage.MODEL_ELEMENT: return createModelElement();
      case SpeadlPackage.ELEMENT: return createElement();
      case SpeadlPackage.ABSTRACT_COMPONENT: return createAbstractComponent();
      case SpeadlPackage.PORT: return createPort();
      case SpeadlPackage.CONTENT_ELEMENT: return createContentElement();
      case SpeadlPackage.PART: return createPart();
      case SpeadlPackage.FEATURE: return createFeature();
      case SpeadlPackage.IMPLEMENTED_BY: return createImplementedBy();
      case SpeadlPackage.ECOSYSTEM: return createEcosystem();
      case SpeadlPackage.SPECIES: return createSpecies();
      case SpeadlPackage.PROVIDED_PORT: return createProvidedPort();
      case SpeadlPackage.REQUIRED_PORT: return createRequiredPort();
      case SpeadlPackage.COMPONENT_PART: return createComponentPart();
      case SpeadlPackage.SPECIES_PART: return createSpeciesPart();
      case SpeadlPackage.BINDING: return createBinding();
      case SpeadlPackage.PORT_REF: return createPortRef();
      case SpeadlPackage.SPECIES_REFERENCE: return createSpeciesReference();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Namespace createNamespace()
  {
    NamespaceImpl namespace = new NamespaceImpl();
    return namespace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelElement createModelElement()
  {
    ModelElementImpl modelElement = new ModelElementImpl();
    return modelElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element createElement()
  {
    ElementImpl element = new ElementImpl();
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractComponent createAbstractComponent()
  {
    AbstractComponentImpl abstractComponent = new AbstractComponentImpl();
    return abstractComponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port createPort()
  {
    PortImpl port = new PortImpl();
    return port;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContentElement createContentElement()
  {
    ContentElementImpl contentElement = new ContentElementImpl();
    return contentElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Part createPart()
  {
    PartImpl part = new PartImpl();
    return part;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature createFeature()
  {
    FeatureImpl feature = new FeatureImpl();
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImplementedBy createImplementedBy()
  {
    ImplementedByImpl implementedBy = new ImplementedByImpl();
    return implementedBy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Ecosystem createEcosystem()
  {
    EcosystemImpl ecosystem = new EcosystemImpl();
    return ecosystem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Species createSpecies()
  {
    SpeciesImpl species = new SpeciesImpl();
    return species;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProvidedPort createProvidedPort()
  {
    ProvidedPortImpl providedPort = new ProvidedPortImpl();
    return providedPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RequiredPort createRequiredPort()
  {
    RequiredPortImpl requiredPort = new RequiredPortImpl();
    return requiredPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentPart createComponentPart()
  {
    ComponentPartImpl componentPart = new ComponentPartImpl();
    return componentPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpeciesPart createSpeciesPart()
  {
    SpeciesPartImpl speciesPart = new SpeciesPartImpl();
    return speciesPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Binding createBinding()
  {
    BindingImpl binding = new BindingImpl();
    return binding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PortRef createPortRef()
  {
    PortRefImpl portRef = new PortRefImpl();
    return portRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpeciesReference createSpeciesReference()
  {
    SpeciesReferenceImpl speciesReference = new SpeciesReferenceImpl();
    return speciesReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpeadlPackage getSpeadlPackage()
  {
    return (SpeadlPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SpeadlPackage getPackage()
  {
    return SpeadlPackage.eINSTANCE;
  }

} //SpeadlFactoryImpl
