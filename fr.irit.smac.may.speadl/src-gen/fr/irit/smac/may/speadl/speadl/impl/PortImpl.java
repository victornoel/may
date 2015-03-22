/**
 */
package fr.irit.smac.may.speadl.speadl.impl;

import fr.irit.smac.may.speadl.speadl.Port;
import fr.irit.smac.may.speadl.speadl.SpeadlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.impl.PortImpl#getTypeReference <em>Type Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PortImpl extends ContentElementImpl implements Port
{
  /**
   * The cached value of the '{@link #getTypeReference() <em>Type Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeReference()
   * @generated
   * @ordered
   */
  protected JvmParameterizedTypeReference typeReference;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PortImpl()
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
    return SpeadlPackage.Literals.PORT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmParameterizedTypeReference getTypeReference()
  {
    return typeReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeReference(JvmParameterizedTypeReference newTypeReference, NotificationChain msgs)
  {
    JvmParameterizedTypeReference oldTypeReference = typeReference;
    typeReference = newTypeReference;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpeadlPackage.PORT__TYPE_REFERENCE, oldTypeReference, newTypeReference);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeReference(JvmParameterizedTypeReference newTypeReference)
  {
    if (newTypeReference != typeReference)
    {
      NotificationChain msgs = null;
      if (typeReference != null)
        msgs = ((InternalEObject)typeReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpeadlPackage.PORT__TYPE_REFERENCE, null, msgs);
      if (newTypeReference != null)
        msgs = ((InternalEObject)newTypeReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpeadlPackage.PORT__TYPE_REFERENCE, null, msgs);
      msgs = basicSetTypeReference(newTypeReference, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpeadlPackage.PORT__TYPE_REFERENCE, newTypeReference, newTypeReference));
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
      case SpeadlPackage.PORT__TYPE_REFERENCE:
        return basicSetTypeReference(null, msgs);
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
      case SpeadlPackage.PORT__TYPE_REFERENCE:
        return getTypeReference();
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
      case SpeadlPackage.PORT__TYPE_REFERENCE:
        setTypeReference((JvmParameterizedTypeReference)newValue);
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
      case SpeadlPackage.PORT__TYPE_REFERENCE:
        setTypeReference((JvmParameterizedTypeReference)null);
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
      case SpeadlPackage.PORT__TYPE_REFERENCE:
        return typeReference != null;
    }
    return super.eIsSet(featureID);
  }

} //PortImpl
