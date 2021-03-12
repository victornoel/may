/**
 */
package fr.irit.smac.may.speadl.speadl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getName <em>Name</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getParameters <em>Parameters</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getSpecializes <em>Specializes</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getProvides <em>Provides</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getRequires <em>Requires</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getParts <em>Parts</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getSpecies <em>Species</em>}</li>
 * </ul>
 *
 * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getAbstractComponent()
 * @model
 * @generated
 */
public interface AbstractComponent extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getAbstractComponent_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link fr.irit.smac.may.speadl.speadl.Feature}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getAbstractComponent_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Feature> getParameters();

  /**
   * Returns the value of the '<em><b>Type Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeParameter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Parameters</em>' containment reference list.
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getAbstractComponent_TypeParameters()
   * @model containment="true"
   * @generated
   */
  EList<JvmTypeParameter> getTypeParameters();

  /**
   * Returns the value of the '<em><b>Specializes</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Specializes</em>' containment reference.
   * @see #setSpecializes(JvmParameterizedTypeReference)
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getAbstractComponent_Specializes()
   * @model containment="true"
   * @generated
   */
  JvmParameterizedTypeReference getSpecializes();

  /**
   * Sets the value of the '{@link fr.irit.smac.may.speadl.speadl.AbstractComponent#getSpecializes <em>Specializes</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Specializes</em>' containment reference.
   * @see #getSpecializes()
   * @generated
   */
  void setSpecializes(JvmParameterizedTypeReference value);

  /**
   * Returns the value of the '<em><b>Provides</b></em>' containment reference list.
   * The list contents are of type {@link fr.irit.smac.may.speadl.speadl.ProvidedPort}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Provides</em>' containment reference list.
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getAbstractComponent_Provides()
   * @model containment="true"
   * @generated
   */
  EList<ProvidedPort> getProvides();

  /**
   * Returns the value of the '<em><b>Requires</b></em>' containment reference list.
   * The list contents are of type {@link fr.irit.smac.may.speadl.speadl.RequiredPort}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requires</em>' containment reference list.
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getAbstractComponent_Requires()
   * @model containment="true"
   * @generated
   */
  EList<RequiredPort> getRequires();

  /**
   * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
   * The list contents are of type {@link fr.irit.smac.may.speadl.speadl.Part}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parts</em>' containment reference list.
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getAbstractComponent_Parts()
   * @model containment="true"
   * @generated
   */
  EList<Part> getParts();

  /**
   * Returns the value of the '<em><b>Species</b></em>' containment reference list.
   * The list contents are of type {@link fr.irit.smac.may.speadl.speadl.Species}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Species</em>' containment reference list.
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getAbstractComponent_Species()
   * @model containment="true"
   * @generated
   */
  EList<Species> getSpecies();

} // AbstractComponent
