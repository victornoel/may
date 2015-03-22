/**
 */
package fr.irit.smac.may.speadl.speadl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Species Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.SpeciesReference#getPart <em>Part</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.SpeciesReference#getSpecies <em>Species</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.SpeciesReference#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getSpeciesReference()
 * @model
 * @generated
 */
public interface SpeciesReference extends EObject
{
  /**
   * Returns the value of the '<em><b>Part</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Part</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Part</em>' reference.
   * @see #setPart(ComponentPart)
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getSpeciesReference_Part()
   * @model
   * @generated
   */
  ComponentPart getPart();

  /**
   * Sets the value of the '{@link fr.irit.smac.may.speadl.speadl.SpeciesReference#getPart <em>Part</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Part</em>' reference.
   * @see #getPart()
   * @generated
   */
  void setPart(ComponentPart value);

  /**
   * Returns the value of the '<em><b>Species</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Species</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Species</em>' reference.
   * @see #setSpecies(Species)
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getSpeciesReference_Species()
   * @model
   * @generated
   */
  Species getSpecies();

  /**
   * Sets the value of the '{@link fr.irit.smac.may.speadl.speadl.SpeciesReference#getSpecies <em>Species</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Species</em>' reference.
   * @see #getSpecies()
   * @generated
   */
  void setSpecies(Species value);

  /**
   * Returns the value of the '<em><b>Arguments</b></em>' reference list.
   * The list contents are of type {@link fr.irit.smac.may.speadl.speadl.Feature}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arguments</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arguments</em>' reference list.
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getSpeciesReference_Arguments()
   * @model
   * @generated
   */
  EList<Feature> getArguments();

} // SpeciesReference
