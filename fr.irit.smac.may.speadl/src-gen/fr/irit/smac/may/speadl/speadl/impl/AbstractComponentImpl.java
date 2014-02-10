/**
 */
package fr.irit.smac.may.speadl.speadl.impl;

import fr.irit.smac.may.speadl.speadl.AbstractComponent;
import fr.irit.smac.may.speadl.speadl.Feature;
import fr.irit.smac.may.speadl.speadl.Part;
import fr.irit.smac.may.speadl.speadl.ProvidedPort;
import fr.irit.smac.may.speadl.speadl.RequiredPort;
import fr.irit.smac.may.speadl.speadl.SpeadlPackage;
import fr.irit.smac.may.speadl.speadl.Species;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.impl.AbstractComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.impl.AbstractComponentImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.impl.AbstractComponentImpl#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.impl.AbstractComponentImpl#getSpecializes <em>Specializes</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.impl.AbstractComponentImpl#getProvides <em>Provides</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.impl.AbstractComponentImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.impl.AbstractComponentImpl#getParts <em>Parts</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.impl.AbstractComponentImpl#getSpecies <em>Species</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractComponentImpl extends MinimalEObjectImpl.Container implements AbstractComponent
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<Feature> parameters;

  /**
   * The cached value of the '{@link #getTypeParameters() <em>Type Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeParameters()
   * @generated
   * @ordered
   */
  protected EList<JvmTypeParameter> typeParameters;

  /**
   * The cached value of the '{@link #getSpecializes() <em>Specializes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecializes()
   * @generated
   * @ordered
   */
  protected JvmParameterizedTypeReference specializes;

  /**
   * The cached value of the '{@link #getProvides() <em>Provides</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProvides()
   * @generated
   * @ordered
   */
  protected EList<ProvidedPort> provides;

  /**
   * The cached value of the '{@link #getRequires() <em>Requires</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequires()
   * @generated
   * @ordered
   */
  protected EList<RequiredPort> requires;

  /**
   * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParts()
   * @generated
   * @ordered
   */
  protected EList<Part> parts;

  /**
   * The cached value of the '{@link #getSpecies() <em>Species</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecies()
   * @generated
   * @ordered
   */
  protected EList<Species> species;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractComponentImpl()
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
    return SpeadlPackage.Literals.ABSTRACT_COMPONENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpeadlPackage.ABSTRACT_COMPONENT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Feature> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<Feature>(Feature.class, this, SpeadlPackage.ABSTRACT_COMPONENT__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<JvmTypeParameter> getTypeParameters()
  {
    if (typeParameters == null)
    {
      typeParameters = new EObjectContainmentEList<JvmTypeParameter>(JvmTypeParameter.class, this, SpeadlPackage.ABSTRACT_COMPONENT__TYPE_PARAMETERS);
    }
    return typeParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmParameterizedTypeReference getSpecializes()
  {
    return specializes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSpecializes(JvmParameterizedTypeReference newSpecializes, NotificationChain msgs)
  {
    JvmParameterizedTypeReference oldSpecializes = specializes;
    specializes = newSpecializes;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpeadlPackage.ABSTRACT_COMPONENT__SPECIALIZES, oldSpecializes, newSpecializes);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpecializes(JvmParameterizedTypeReference newSpecializes)
  {
    if (newSpecializes != specializes)
    {
      NotificationChain msgs = null;
      if (specializes != null)
        msgs = ((InternalEObject)specializes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpeadlPackage.ABSTRACT_COMPONENT__SPECIALIZES, null, msgs);
      if (newSpecializes != null)
        msgs = ((InternalEObject)newSpecializes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpeadlPackage.ABSTRACT_COMPONENT__SPECIALIZES, null, msgs);
      msgs = basicSetSpecializes(newSpecializes, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpeadlPackage.ABSTRACT_COMPONENT__SPECIALIZES, newSpecializes, newSpecializes));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ProvidedPort> getProvides()
  {
    if (provides == null)
    {
      provides = new EObjectContainmentEList<ProvidedPort>(ProvidedPort.class, this, SpeadlPackage.ABSTRACT_COMPONENT__PROVIDES);
    }
    return provides;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RequiredPort> getRequires()
  {
    if (requires == null)
    {
      requires = new EObjectContainmentEList<RequiredPort>(RequiredPort.class, this, SpeadlPackage.ABSTRACT_COMPONENT__REQUIRES);
    }
    return requires;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Part> getParts()
  {
    if (parts == null)
    {
      parts = new EObjectContainmentEList<Part>(Part.class, this, SpeadlPackage.ABSTRACT_COMPONENT__PARTS);
    }
    return parts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Species> getSpecies()
  {
    if (species == null)
    {
      species = new EObjectContainmentEList<Species>(Species.class, this, SpeadlPackage.ABSTRACT_COMPONENT__SPECIES);
    }
    return species;
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
      case SpeadlPackage.ABSTRACT_COMPONENT__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
      case SpeadlPackage.ABSTRACT_COMPONENT__TYPE_PARAMETERS:
        return ((InternalEList<?>)getTypeParameters()).basicRemove(otherEnd, msgs);
      case SpeadlPackage.ABSTRACT_COMPONENT__SPECIALIZES:
        return basicSetSpecializes(null, msgs);
      case SpeadlPackage.ABSTRACT_COMPONENT__PROVIDES:
        return ((InternalEList<?>)getProvides()).basicRemove(otherEnd, msgs);
      case SpeadlPackage.ABSTRACT_COMPONENT__REQUIRES:
        return ((InternalEList<?>)getRequires()).basicRemove(otherEnd, msgs);
      case SpeadlPackage.ABSTRACT_COMPONENT__PARTS:
        return ((InternalEList<?>)getParts()).basicRemove(otherEnd, msgs);
      case SpeadlPackage.ABSTRACT_COMPONENT__SPECIES:
        return ((InternalEList<?>)getSpecies()).basicRemove(otherEnd, msgs);
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
      case SpeadlPackage.ABSTRACT_COMPONENT__NAME:
        return getName();
      case SpeadlPackage.ABSTRACT_COMPONENT__PARAMETERS:
        return getParameters();
      case SpeadlPackage.ABSTRACT_COMPONENT__TYPE_PARAMETERS:
        return getTypeParameters();
      case SpeadlPackage.ABSTRACT_COMPONENT__SPECIALIZES:
        return getSpecializes();
      case SpeadlPackage.ABSTRACT_COMPONENT__PROVIDES:
        return getProvides();
      case SpeadlPackage.ABSTRACT_COMPONENT__REQUIRES:
        return getRequires();
      case SpeadlPackage.ABSTRACT_COMPONENT__PARTS:
        return getParts();
      case SpeadlPackage.ABSTRACT_COMPONENT__SPECIES:
        return getSpecies();
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
      case SpeadlPackage.ABSTRACT_COMPONENT__NAME:
        setName((String)newValue);
        return;
      case SpeadlPackage.ABSTRACT_COMPONENT__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends Feature>)newValue);
        return;
      case SpeadlPackage.ABSTRACT_COMPONENT__TYPE_PARAMETERS:
        getTypeParameters().clear();
        getTypeParameters().addAll((Collection<? extends JvmTypeParameter>)newValue);
        return;
      case SpeadlPackage.ABSTRACT_COMPONENT__SPECIALIZES:
        setSpecializes((JvmParameterizedTypeReference)newValue);
        return;
      case SpeadlPackage.ABSTRACT_COMPONENT__PROVIDES:
        getProvides().clear();
        getProvides().addAll((Collection<? extends ProvidedPort>)newValue);
        return;
      case SpeadlPackage.ABSTRACT_COMPONENT__REQUIRES:
        getRequires().clear();
        getRequires().addAll((Collection<? extends RequiredPort>)newValue);
        return;
      case SpeadlPackage.ABSTRACT_COMPONENT__PARTS:
        getParts().clear();
        getParts().addAll((Collection<? extends Part>)newValue);
        return;
      case SpeadlPackage.ABSTRACT_COMPONENT__SPECIES:
        getSpecies().clear();
        getSpecies().addAll((Collection<? extends Species>)newValue);
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
      case SpeadlPackage.ABSTRACT_COMPONENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SpeadlPackage.ABSTRACT_COMPONENT__PARAMETERS:
        getParameters().clear();
        return;
      case SpeadlPackage.ABSTRACT_COMPONENT__TYPE_PARAMETERS:
        getTypeParameters().clear();
        return;
      case SpeadlPackage.ABSTRACT_COMPONENT__SPECIALIZES:
        setSpecializes((JvmParameterizedTypeReference)null);
        return;
      case SpeadlPackage.ABSTRACT_COMPONENT__PROVIDES:
        getProvides().clear();
        return;
      case SpeadlPackage.ABSTRACT_COMPONENT__REQUIRES:
        getRequires().clear();
        return;
      case SpeadlPackage.ABSTRACT_COMPONENT__PARTS:
        getParts().clear();
        return;
      case SpeadlPackage.ABSTRACT_COMPONENT__SPECIES:
        getSpecies().clear();
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
      case SpeadlPackage.ABSTRACT_COMPONENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SpeadlPackage.ABSTRACT_COMPONENT__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case SpeadlPackage.ABSTRACT_COMPONENT__TYPE_PARAMETERS:
        return typeParameters != null && !typeParameters.isEmpty();
      case SpeadlPackage.ABSTRACT_COMPONENT__SPECIALIZES:
        return specializes != null;
      case SpeadlPackage.ABSTRACT_COMPONENT__PROVIDES:
        return provides != null && !provides.isEmpty();
      case SpeadlPackage.ABSTRACT_COMPONENT__REQUIRES:
        return requires != null && !requires.isEmpty();
      case SpeadlPackage.ABSTRACT_COMPONENT__PARTS:
        return parts != null && !parts.isEmpty();
      case SpeadlPackage.ABSTRACT_COMPONENT__SPECIES:
        return species != null && !species.isEmpty();
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

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //AbstractComponentImpl
