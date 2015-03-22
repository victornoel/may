/**
 */
package fr.irit.smac.may.speadl.speadl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.Binding#getFrom <em>From</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.Binding#getTo <em>To</em>}</li>
 * </ul>
 *
 * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getBinding()
 * @model
 * @generated
 */
public interface Binding extends EObject
{
  /**
   * Returns the value of the '<em><b>From</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>From</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>From</em>' reference.
   * @see #setFrom(RequiredPort)
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getBinding_From()
   * @model
   * @generated
   */
  RequiredPort getFrom();

  /**
   * Sets the value of the '{@link fr.irit.smac.may.speadl.speadl.Binding#getFrom <em>From</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>From</em>' reference.
   * @see #getFrom()
   * @generated
   */
  void setFrom(RequiredPort value);

  /**
   * Returns the value of the '<em><b>To</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To</em>' containment reference.
   * @see #setTo(PortRef)
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getBinding_To()
   * @model containment="true"
   * @generated
   */
  PortRef getTo();

  /**
   * Sets the value of the '{@link fr.irit.smac.may.speadl.speadl.Binding#getTo <em>To</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To</em>' containment reference.
   * @see #getTo()
   * @generated
   */
  void setTo(PortRef value);

} // Binding
