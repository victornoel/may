/**
 */
package fr.irit.smac.may.speadl.speadl.impl;

import fr.irit.smac.may.speadl.speadl.ComponentPart;
import fr.irit.smac.may.speadl.speadl.Feature;
import fr.irit.smac.may.speadl.speadl.SpeadlPackage;
import fr.irit.smac.may.speadl.speadl.Species;
import fr.irit.smac.may.speadl.speadl.SpeciesReference;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Species Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.impl.SpeciesReferenceImpl#getPart <em>Part</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.impl.SpeciesReferenceImpl#getSpecies <em>Species</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.impl.SpeciesReferenceImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpeciesReferenceImpl extends MinimalEObjectImpl.Container implements SpeciesReference
{
  /**
   * The cached value of the '{@link #getPart() <em>Part</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPart()
   * @generated
   * @ordered
   */
  protected ComponentPart part;

  /**
   * The cached value of the '{@link #getSpecies() <em>Species</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecies()
   * @generated
   * @ordered
   */
  protected Species species;

  /**
   * The cached value of the '{@link #getArguments() <em>Arguments</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArguments()
   * @generated
   * @ordered
   */
  protected EList<Feature> arguments;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SpeciesReferenceImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return SpeadlPackage.Literals.SPECIES_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentPart getPart()
  {
    if (part != null && part.eIsProxy())
    {
      InternalEObject oldPart = (InternalEObject)part;
      part = (ComponentPart)eResolveProxy(oldPart);
      if (part != oldPart)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpeadlPackage.SPECIES_REFERENCE__PART, oldPart, part));
      }
    }
    return part;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentPart basicGetPart()
  {
    return part;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPart(ComponentPart newPart)
  {
    ComponentPart oldPart = part;
    part = newPart;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpeadlPackage.SPECIES_REFERENCE__PART, oldPart, part));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Species getSpecies()
  {
    if (species != null && species.eIsProxy())
    {
      InternalEObject oldSpecies = (InternalEObject)species;
      species = (Species)eResolveProxy(oldSpecies);
      if (species != oldSpecies)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpeadlPackage.SPECIES_REFERENCE__SPECIES, oldSpecies, species));
      }
    }
    return species;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Species basicGetSpecies()
  {
    return species;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpecies(Species newSpecies)
  {
    Species oldSpecies = species;
    species = newSpecies;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpeadlPackage.SPECIES_REFERENCE__SPECIES, oldSpecies, species));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Feature> getArguments()
  {
    if (arguments == null)
    {
      arguments = new EObjectResolvingEList<Feature>(Feature.class, this, SpeadlPackage.SPECIES_REFERENCE__ARGUMENTS);
    }
    return arguments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case SpeadlPackage.SPECIES_REFERENCE__PART:
        if (resolve) return getPart();
        return basicGetPart();
      case SpeadlPackage.SPECIES_REFERENCE__SPECIES:
        if (resolve) return getSpecies();
        return basicGetSpecies();
      case SpeadlPackage.SPECIES_REFERENCE__ARGUMENTS:
        return getArguments();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SpeadlPackage.SPECIES_REFERENCE__PART:
        setPart((ComponentPart)newValue);
        return;
      case SpeadlPackage.SPECIES_REFERENCE__SPECIES:
        setSpecies((Species)newValue);
        return;
      case SpeadlPackage.SPECIES_REFERENCE__ARGUMENTS:
        getArguments().clear();
        getArguments().addAll((Collection<? extends Feature>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case SpeadlPackage.SPECIES_REFERENCE__PART:
        setPart((ComponentPart)null);
        return;
      case SpeadlPackage.SPECIES_REFERENCE__SPECIES:
        setSpecies((Species)null);
        return;
      case SpeadlPackage.SPECIES_REFERENCE__ARGUMENTS:
        getArguments().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case SpeadlPackage.SPECIES_REFERENCE__PART:
        return part != null;
      case SpeadlPackage.SPECIES_REFERENCE__SPECIES:
        return species != null;
      case SpeadlPackage.SPECIES_REFERENCE__ARGUMENTS:
        return arguments != null && !arguments.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SpeciesReferenceImpl
