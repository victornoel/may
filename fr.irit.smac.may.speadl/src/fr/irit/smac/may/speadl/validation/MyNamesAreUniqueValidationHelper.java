package fr.irit.smac.may.speadl.validation;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.validation.NamesAreUniqueValidationHelper;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.google.common.collect.ImmutableSet;

import fr.irit.smac.may.speadl.speadl.SpeadlPackage;

public class MyNamesAreUniqueValidationHelper extends
		NamesAreUniqueValidationHelper {

	private ImmutableSet<EClass> clusterTypes = ImmutableSet.of(SpeadlPackage.Literals.ABSTRACT_COMPONENT, SpeadlPackage.Literals.CONTENT_ELEMENT);
	
	@Override
	protected ImmutableSet<EClass> getClusterTypes() {
		return clusterTypes;
	}

	@Override
	protected void checkDescriptionForDuplicatedName(
			IEObjectDescription description,
			Map<EClass, Map<QualifiedName, IEObjectDescription>> clusterTypeToName,
			ValidationMessageAcceptor acceptor) {
		// only check if it is one of the cluster
		if (getAssociatedClusterType(description.getEClass()) != null) {
			super.checkDescriptionForDuplicatedName(description,
					clusterTypeToName, acceptor);
		}
	}
	
	@Override
	protected EClass getAssociatedClusterType(EClass eClass) {
		for (EClass c: clusterTypes) {
			if (c.isSuperTypeOf(eClass)) {
				return c;
			}
		}
		return null;
	}
	
	@Override
	protected String getTypeLabel(EClass eClass) {
		return "element";
	}
	
	@Override
	protected boolean isContainerInformationHelpful(
			IEObjectDescription description, String shortName) {
		return false;
	}
}
