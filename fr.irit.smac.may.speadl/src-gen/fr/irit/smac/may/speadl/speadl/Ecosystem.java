/**
 */
package fr.irit.smac.may.speadl.speadl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ecosystem</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.Ecosystem#getImplementedBy <em>Implemented By</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getEcosystem()
 * @model
 * @generated
 */
public interface Ecosystem extends Element, AbstractComponent
{
  /**
   * Returns the value of the '<em><b>Implemented By</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Implemented By</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Implemented By</em>' containment reference.
   * @see #setImplementedBy(ImplementedBy)
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getEcosystem_ImplementedBy()
   * @model containment="true"
   * @generated
   */
  ImplementedBy getImplementedBy();

  /**
   * Sets the value of the '{@link fr.irit.smac.may.speadl.speadl.Ecosystem#getImplementedBy <em>Implemented By</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Implemented By</em>' containment reference.
   * @see #getImplementedBy()
   * @generated
   */
  void setImplementedBy(ImplementedBy value);

} // Ecosystem
