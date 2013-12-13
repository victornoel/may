package fr.irit.smac.may.speadl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.scoping.XbaseQualifiedNameProvider;

public class SpeADLQualifiedNameProvider extends XbaseQualifiedNameProvider {
	
	/* avoid to show JvmTypeParameter in completion
	 * because they are shown as global and appears everywhere (see TODO list)
	 */
	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof JvmTypeParameter) {
			return null;
		}
		return super.getFullyQualifiedName(obj);
	}
}
