/**
 */
package fr.irit.smac.may.speadl.speadl.impl;

import fr.irit.smac.may.speadl.speadl.SpeadlPackage;
import fr.irit.smac.may.speadl.speadl.SpeciesPart;
import fr.irit.smac.may.speadl.speadl.SpeciesReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Species Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.impl.SpeciesPartImpl#getSpeciesReference <em>Species Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpeciesPartImpl extends PartImpl implements SpeciesPart
{
  /**
   * The cached value of the '{@link #getSpeciesReference() <em>Species Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpeciesReference()
   * @generated
   * @ordered
   */
  protected SpeciesReference speciesReference;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SpeciesPartImpl()
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
    return SpeadlPackage.Literals.SPECIES_PART;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpeciesReference getSpeciesReference()
  {
    return speciesReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSpeciesReference(SpeciesReference newSpeciesReference, NotificationChain msgs)
  {
    SpeciesReference oldSpeciesReference = speciesReference;
    speciesReference = newSpeciesReference;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpeadlPackage.SPECIES_PART__SPECIES_REFERENCE, oldSpeciesReference, newSpeciesReference);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpeciesReference(SpeciesReference newSpeciesReference)
  {
    if (newSpeciesReference != speciesReference)
    {
      NotificationChain msgs = null;
      if (speciesReference != null)
        msgs = ((InternalEObject)speciesReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpeadlPackage.SPECIES_PART__SPECIES_REFERENCE, null, msgs);
      if (newSpeciesReference != null)
        msgs = ((InternalEObject)newSpeciesReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpeadlPackage.SPECIES_PART__SPECIES_REFERENCE, null, msgs);
      msgs = basicSetSpeciesReference(newSpeciesReference, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpeadlPackage.SPECIES_PART__SPECIES_REFERENCE, newSpeciesReference, newSpeciesReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SpeadlPackage.SPECIES_PART__SPECIES_REFERENCE:
        return basicSetSpeciesReference(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case SpeadlPackage.SPECIES_PART__SPECIES_REFERENCE:
        return getSpeciesReference();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SpeadlPackage.SPECIES_PART__SPECIES_REFERENCE:
        setSpeciesReference((SpeciesReference)newValue);
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
      case SpeadlPackage.SPECIES_PART__SPECIES_REFERENCE:
        setSpeciesReference((SpeciesReference)null);
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
      case SpeadlPackage.SPECIES_PART__SPECIES_REFERENCE:
        return speciesReference != null;
    }
    return super.eIsSet(featureID);
  }

} //SpeciesPartImpl
