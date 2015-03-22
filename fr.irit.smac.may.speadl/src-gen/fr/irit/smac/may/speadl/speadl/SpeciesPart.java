/**
 */
package fr.irit.smac.may.speadl.speadl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Species Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.SpeciesPart#getSpeciesReference <em>Species Reference</em>}</li>
 * </ul>
 *
 * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getSpeciesPart()
 * @model
 * @generated
 */
public interface SpeciesPart extends Part
{
  /**
   * Returns the value of the '<em><b>Species Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Species Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Species Reference</em>' containment reference.
   * @see #setSpeciesReference(SpeciesReference)
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getSpeciesPart_SpeciesReference()
   * @model containment="true"
   * @generated
   */
  SpeciesReference getSpeciesReference();

  /**
   * Sets the value of the '{@link fr.irit.smac.may.speadl.speadl.SpeciesPart#getSpeciesReference <em>Species Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Species Reference</em>' containment reference.
   * @see #getSpeciesReference()
   * @generated
   */
  void setSpeciesReference(SpeciesReference value);

} // SpeciesPart
