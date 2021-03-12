/**
 */
package fr.irit.smac.may.speadl.speadl.impl;

import fr.irit.smac.may.speadl.speadl.Part;
import fr.irit.smac.may.speadl.speadl.Port;
import fr.irit.smac.may.speadl.speadl.PortRef;
import fr.irit.smac.may.speadl.speadl.SpeadlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.impl.PortRefImpl#isEcosystem <em>Ecosystem</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.impl.PortRefImpl#getPart <em>Part</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.impl.PortRefImpl#getPort <em>Port</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PortRefImpl extends MinimalEObjectImpl.Container implements PortRef
{
  /**
   * The default value of the '{@link #isEcosystem() <em>Ecosystem</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isEcosystem()
   * @generated
   * @ordered
   */
  protected static final boolean ECOSYSTEM_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isEcosystem() <em>Ecosystem</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isEcosystem()
   * @generated
   * @ordered
   */
  protected boolean ecosystem = ECOSYSTEM_EDEFAULT;

  /**
   * The cached value of the '{@link #getPart() <em>Part</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPart()
   * @generated
   * @ordered
   */
  protected Part part;

  /**
   * The cached value of the '{@link #getPort() <em>Port</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPort()
   * @generated
   * @ordered
   */
  protected Port port;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PortRefImpl()
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
    return SpeadlPackage.Literals.PORT_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isEcosystem()
  {
    return ecosystem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setEcosystem(boolean newEcosystem)
  {
    boolean oldEcosystem = ecosystem;
    ecosystem = newEcosystem;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpeadlPackage.PORT_REF__ECOSYSTEM, oldEcosystem, ecosystem));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Part getPart()
  {
    if (part != null && part.eIsProxy())
    {
      InternalEObject oldPart = (InternalEObject)part;
      part = (Part)eResolveProxy(oldPart);
      if (part != oldPart)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpeadlPackage.PORT_REF__PART, oldPart, part));
      }
    }
    return part;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Part basicGetPart()
  {
    return part;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPart(Part newPart)
  {
    Part oldPart = part;
    part = newPart;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpeadlPackage.PORT_REF__PART, oldPart, part));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Port getPort()
  {
    if (port != null && port.eIsProxy())
    {
      InternalEObject oldPort = (InternalEObject)port;
      port = (Port)eResolveProxy(oldPort);
      if (port != oldPort)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpeadlPackage.PORT_REF__PORT, oldPort, port));
      }
    }
    return port;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port basicGetPort()
  {
    return port;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPort(Port newPort)
  {
    Port oldPort = port;
    port = newPort;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpeadlPackage.PORT_REF__PORT, oldPort, port));
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
      case SpeadlPackage.PORT_REF__ECOSYSTEM:
        return isEcosystem();
      case SpeadlPackage.PORT_REF__PART:
        if (resolve) return getPart();
        return basicGetPart();
      case SpeadlPackage.PORT_REF__PORT:
        if (resolve) return getPort();
        return basicGetPort();
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
      case SpeadlPackage.PORT_REF__ECOSYSTEM:
        setEcosystem((Boolean)newValue);
        return;
      case SpeadlPackage.PORT_REF__PART:
        setPart((Part)newValue);
        return;
      case SpeadlPackage.PORT_REF__PORT:
        setPort((Port)newValue);
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
      case SpeadlPackage.PORT_REF__ECOSYSTEM:
        setEcosystem(ECOSYSTEM_EDEFAULT);
        return;
      case SpeadlPackage.PORT_REF__PART:
        setPart((Part)null);
        return;
      case SpeadlPackage.PORT_REF__PORT:
        setPort((Port)null);
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
      case SpeadlPackage.PORT_REF__ECOSYSTEM:
        return ecosystem != ECOSYSTEM_EDEFAULT;
      case SpeadlPackage.PORT_REF__PART:
        return part != null;
      case SpeadlPackage.PORT_REF__PORT:
        return port != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (ecosystem: ");
    result.append(ecosystem);
    result.append(')');
    return result.toString();
  }

} //PortRefImpl
