/**
 */
package fr.irit.smac.may.speadl.speadl.impl;

import fr.irit.smac.may.speadl.speadl.ComponentPart;
import fr.irit.smac.may.speadl.speadl.SpeadlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.impl.ComponentPartImpl#getComponentReference <em>Component Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentPartImpl extends PartImpl implements ComponentPart
{
  /**
   * The cached value of the '{@link #getComponentReference() <em>Component Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponentReference()
   * @generated
   * @ordered
   */
  protected JvmParameterizedTypeReference componentReference;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComponentPartImpl()
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
    return SpeadlPackage.Literals.COMPONENT_PART;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmParameterizedTypeReference getComponentReference()
  {
    return componentReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetComponentReference(JvmParameterizedTypeReference newComponentReference, NotificationChain msgs)
  {
    JvmParameterizedTypeReference oldComponentReference = componentReference;
    componentReference = newComponentReference;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpeadlPackage.COMPONENT_PART__COMPONENT_REFERENCE, oldComponentReference, newComponentReference);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComponentReference(JvmParameterizedTypeReference newComponentReference)
  {
    if (newComponentReference != componentReference)
    {
      NotificationChain msgs = null;
      if (componentReference != null)
        msgs = ((InternalEObject)componentReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpeadlPackage.COMPONENT_PART__COMPONENT_REFERENCE, null, msgs);
      if (newComponentReference != null)
        msgs = ((InternalEObject)newComponentReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpeadlPackage.COMPONENT_PART__COMPONENT_REFERENCE, null, msgs);
      msgs = basicSetComponentReference(newComponentReference, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpeadlPackage.COMPONENT_PART__COMPONENT_REFERENCE, newComponentReference, newComponentReference));
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
      case SpeadlPackage.COMPONENT_PART__COMPONENT_REFERENCE:
        return basicSetComponentReference(null, msgs);
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
      case SpeadlPackage.COMPONENT_PART__COMPONENT_REFERENCE:
        return getComponentReference();
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
      case SpeadlPackage.COMPONENT_PART__COMPONENT_REFERENCE:
        setComponentReference((JvmParameterizedTypeReference)newValue);
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
      case SpeadlPackage.COMPONENT_PART__COMPONENT_REFERENCE:
        setComponentReference((JvmParameterizedTypeReference)null);
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
      case SpeadlPackage.COMPONENT_PART__COMPONENT_REFERENCE:
        return componentReference != null;
    }
    return super.eIsSet(featureID);
  }

} //ComponentPartImpl
