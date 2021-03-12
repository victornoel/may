/**
 */
package fr.irit.smac.may.speadl.speadl;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.Port#getTypeReference <em>Type Reference</em>}</li>
 * </ul>
 *
 * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getPort()
 * @model
 * @generated
 */
public interface Port extends ContentElement
{
  /**
   * Returns the value of the '<em><b>Type Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Reference</em>' containment reference.
   * @see #setTypeReference(JvmParameterizedTypeReference)
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getPort_TypeReference()
   * @model containment="true"
   * @generated
   */
  JvmParameterizedTypeReference getTypeReference();

  /**
   * Sets the value of the '{@link fr.irit.smac.may.speadl.speadl.Port#getTypeReference <em>Type Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Reference</em>' containment reference.
   * @see #getTypeReference()
   * @generated
   */
  void setTypeReference(JvmParameterizedTypeReference value);

} // Port
