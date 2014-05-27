/**
 */
package fr.irit.smac.may.speadl.speadl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.PortRef#isEcosystem <em>Ecosystem</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.PortRef#getPart <em>Part</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.PortRef#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getPortRef()
 * @model
 * @generated
 */
public interface PortRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Ecosystem</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ecosystem</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ecosystem</em>' attribute.
   * @see #setEcosystem(boolean)
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getPortRef_Ecosystem()
   * @model
   * @generated
   */
  boolean isEcosystem();

  /**
   * Sets the value of the '{@link fr.irit.smac.may.speadl.speadl.PortRef#isEcosystem <em>Ecosystem</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ecosystem</em>' attribute.
   * @see #isEcosystem()
   * @generated
   */
  void setEcosystem(boolean value);

  /**
   * Returns the value of the '<em><b>Part</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Part</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Part</em>' reference.
   * @see #setPart(Part)
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getPortRef_Part()
   * @model
   * @generated
   */
  Part getPart();

  /**
   * Sets the value of the '{@link fr.irit.smac.may.speadl.speadl.PortRef#getPart <em>Part</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Part</em>' reference.
   * @see #getPart()
   * @generated
   */
  void setPart(Part value);

  /**
   * Returns the value of the '<em><b>Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Port</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Port</em>' reference.
   * @see #setPort(Port)
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getPortRef_Port()
   * @model
   * @generated
   */
  Port getPort();

  /**
   * Sets the value of the '{@link fr.irit.smac.may.speadl.speadl.PortRef#getPort <em>Port</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Port</em>' reference.
   * @see #getPort()
   * @generated
   */
  void setPort(Port value);

} // PortRef
