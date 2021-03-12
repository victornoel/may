/**
 */
package fr.irit.smac.may.speadl.speadl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Provided Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.ProvidedPort#getBound <em>Bound</em>}</li>
 * </ul>
 *
 * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getProvidedPort()
 * @model
 * @generated
 */
public interface ProvidedPort extends Port
{
  /**
   * Returns the value of the '<em><b>Bound</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bound</em>' containment reference.
   * @see #setBound(PortRef)
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getProvidedPort_Bound()
   * @model containment="true"
   * @generated
   */
  PortRef getBound();

  /**
   * Sets the value of the '{@link fr.irit.smac.may.speadl.speadl.ProvidedPort#getBound <em>Bound</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bound</em>' containment reference.
   * @see #getBound()
   * @generated
   */
  void setBound(PortRef value);

} // ProvidedPort
