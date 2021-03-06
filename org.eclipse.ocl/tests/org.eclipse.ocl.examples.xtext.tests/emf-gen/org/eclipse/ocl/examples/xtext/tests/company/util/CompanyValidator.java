/**
 * <copyright>
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.tests.company.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.examples.xtext.tests.company.*;
import org.eclipse.ocl.xtext.oclinecore.validation.OCLinEcoreEObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.tests.company.CompanyPackage
 * @generated not
 */
public class CompanyValidator extends OCLinEcoreEObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final CompanyValidator INSTANCE = new CompanyValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.ocl.examples.xtext.tests.company"; //$NON-NLS-1$

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Dummy Invariant' of 'Company'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COMPANY__DUMMY_INVARIANT = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'No Manager Implies Direct Reports' of 'Employee'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EMPLOYEE__NO_MANAGER_IMPLIES_DIRECT_REPORTS = 2;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 2;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Delegates evaluation of the given invariant expression against the object in the given context.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context, String validationDelegate, EOperation invariant, String expression, int severity, String source, int code) {
		return EObjectValidator.validate(eClass, eObject, diagnostics, context, validationDelegate, invariant, expression, severity, source, code);
	}

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompanyValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return CompanyPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case 0:
				return validateCompany((Company)value, diagnostics, context);
			case 1:
				return validateEmployee((Employee)value, diagnostics, context);
			case 2:
				return validateBug418716((Bug418716)value, diagnostics, context);
			case 3:
				return validateCompanySizeKind((CompanySizeKind)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompany(Company company, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(company, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(company, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(company, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(company, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(company, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(company, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(company, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(company, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(company, diagnostics, context);
		if (result || diagnostics != null) result &= validateCompany_dummyInvariant(company, diagnostics, context);
		return result;
	}

	/**
	 * Validates the dummyInvariant constraint of '<em>Company</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompany_dummyInvariant(Company company, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return company.dummyInvariant(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEmployee(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(employee, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(employee, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(employee, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(employee, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(employee, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(employee, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(employee, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(employee, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(employee, diagnostics, context);
		if (result || diagnostics != null) result &= validateEmployee_mustHaveName(employee, diagnostics, context);
		if (result || diagnostics != null) result &= validateEmployee_mustHaveNonEmptyName(employee, diagnostics, context);
		if (result || diagnostics != null) result &= validateEmployee_noManagerImpliesDirectReports(employee, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the mustHaveName constraint of '<em>Employee</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String EMPLOYEE__MUST_HAVE_NAME__EEXPRESSION = "Tuple {\n" + //$NON-NLS-1$
		"\tmessage : String = 'Employee must have a name',\n" + //$NON-NLS-1$
		"\tstatus : Boolean = not name.oclIsUndefined() and hasNameAsAttribute and hasNameAsOperation()\n" + //$NON-NLS-1$
		"}.status"; //$NON-NLS-1$

	/**
	 * Validates the mustHaveName constraint of '<em>Employee</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEmployee_mustHaveName(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(CompanyPackage.Literals.EMPLOYEE,
				 employee,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", //$NON-NLS-1$
				 "mustHaveName", //$NON-NLS-1$
				 EMPLOYEE__MUST_HAVE_NAME__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the mustHaveNonEmptyName constraint of '<em>Employee</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String EMPLOYEE__MUST_HAVE_NON_EMPTY_NAME__EEXPRESSION = "name->notEmpty() implies name.size() > 0"; //$NON-NLS-1$

	/**
	 * Validates the mustHaveNonEmptyName constraint of '<em>Employee</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEmployee_mustHaveNonEmptyName(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(CompanyPackage.Literals.EMPLOYEE,
				 employee,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", //$NON-NLS-1$
				 "mustHaveNonEmptyName", //$NON-NLS-1$
				 EMPLOYEE__MUST_HAVE_NON_EMPTY_NAME__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * Validates the noManagerImpliesDirectReports constraint of '<em>Employee</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEmployee_noManagerImpliesDirectReports(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return employee.noManagerImpliesDirectReports(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBug418716(Bug418716 bug418716, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(bug418716, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompanySizeKind(CompanySizeKind companySizeKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //CompanyValidator
