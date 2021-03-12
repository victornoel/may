/**
 */
package fr.irit.smac.may.speadl.speadl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.Part#getBindings <em>Bindings</em>}</li>
 * </ul>
 *
 * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getPart()
 * @model
 * @generated
 */
public interface Part extends ContentElement
{
  /**
   * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
   * The list contents are of type {@link fr.irit.smac.may.speadl.speadl.Binding}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bindings</em>' containment reference list.
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getPart_Bindings()
   * @model containment="true"
   * @generated
   */
  EList<Binding> getBindings();

} // Part
