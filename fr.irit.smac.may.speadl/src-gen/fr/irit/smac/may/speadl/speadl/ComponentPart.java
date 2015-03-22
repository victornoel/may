/**
 */
package fr.irit.smac.may.speadl.speadl;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.ComponentPart#getComponentReference <em>Component Reference</em>}</li>
 * </ul>
 *
 * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getComponentPart()
 * @model
 * @generated
 */
public interface ComponentPart extends Part
{
  /**
   * Returns the value of the '<em><b>Component Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Component Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component Reference</em>' containment reference.
   * @see #setComponentReference(JvmParameterizedTypeReference)
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getComponentPart_ComponentReference()
   * @model containment="true"
   * @generated
   */
  JvmParameterizedTypeReference getComponentReference();

  /**
   * Sets the value of the '{@link fr.irit.smac.may.speadl.speadl.ComponentPart#getComponentReference <em>Component Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Component Reference</em>' containment reference.
   * @see #getComponentReference()
   * @generated
   */
  void setComponentReference(JvmParameterizedTypeReference value);

} // ComponentPart
