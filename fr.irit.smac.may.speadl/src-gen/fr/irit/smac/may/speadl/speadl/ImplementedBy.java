/**
 */
package fr.irit.smac.may.speadl.speadl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Implemented By</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.ImplementedBy#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getImplementedBy()
 * @model
 * @generated
 */
public interface ImplementedBy extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' containment reference.
   * @see #setRef(JvmParameterizedTypeReference)
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getImplementedBy_Ref()
   * @model containment="true"
   * @generated
   */
  JvmParameterizedTypeReference getRef();

  /**
   * Sets the value of the '{@link fr.irit.smac.may.speadl.speadl.ImplementedBy#getRef <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' containment reference.
   * @see #getRef()
   * @generated
   */
  void setRef(JvmParameterizedTypeReference value);

} // ImplementedBy
