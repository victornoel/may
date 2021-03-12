/**
 */
package fr.irit.smac.may.speadl.speadl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xtype.XImportSection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.Model#getImports <em>Imports</em>}</li>
 *   <li>{@link fr.irit.smac.may.speadl.speadl.Model#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference.
   * @see #setImports(XImportSection)
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getModel_Imports()
   * @model containment="true"
   * @generated
   */
  XImportSection getImports();

  /**
   * Sets the value of the '{@link fr.irit.smac.may.speadl.speadl.Model#getImports <em>Imports</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Imports</em>' containment reference.
   * @see #getImports()
   * @generated
   */
  void setImports(XImportSection value);

  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link fr.irit.smac.may.speadl.speadl.Namespace}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see fr.irit.smac.may.speadl.speadl.SpeadlPackage#getModel_Elements()
   * @model containment="true"
   * @generated
   */
  EList<Namespace> getElements();

} // Model
