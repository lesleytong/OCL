/**
 * <copyright>
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.tests.company.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.xtext.tests.company.Bug418716;
import org.eclipse.ocl.examples.xtext.tests.company.Company;
import org.eclipse.ocl.examples.xtext.tests.company.CompanyFactory;
import org.eclipse.ocl.examples.xtext.tests.company.CompanyPackage;
import org.eclipse.ocl.examples.xtext.tests.company.CompanySizeKind;
import org.eclipse.ocl.examples.xtext.tests.company.Employee;
import org.eclipse.ocl.examples.xtext.tests.company.util.CompanyValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompanyPackageImpl extends EPackageImpl implements CompanyPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass companyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass employeeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bug418716EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum companySizeKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.ocl.examples.xtext.tests.company.CompanyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CompanyPackageImpl() {
		super(eNS_URI, CompanyFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link CompanyPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CompanyPackage init() {
		if (isInited) return (CompanyPackage)EPackage.Registry.INSTANCE.getEPackage(CompanyPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredCompanyPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		CompanyPackageImpl theCompanyPackage = registeredCompanyPackage instanceof CompanyPackageImpl ? (CompanyPackageImpl)registeredCompanyPackage : new CompanyPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theCompanyPackage.createPackageContents();

		// Initialize created meta-data
		theCompanyPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theCompanyPackage,
			 new EValidator.Descriptor() {
				 @Override
				 public EValidator getEValidator() {
					 return CompanyValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theCompanyPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CompanyPackage.eNS_URI, theCompanyPackage);
		return theCompanyPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompany() {
		return companyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCompany_Name() {
		return (EAttribute)companyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompany_Employees() {
		return (EReference)companyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCompany_Size() {
		return (EAttribute)companyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getCompany__DummyInvariant__DiagnosticChain_Map() {
		return companyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEmployee() {
		return employeeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEmployee_Name() {
		return (EAttribute)employeeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEmployee_Manager() {
		return (EReference)employeeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEmployee_Company() {
		return (EReference)employeeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEmployee_DirectReports() {
		return (EReference)employeeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEmployee_AllReports() {
		return (EReference)employeeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEmployee_ReportingChain() {
		return (EReference)employeeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEmployee_HasNameAsAttribute() {
		return (EAttribute)employeeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEmployee__ReportsTo__Employee() {
		return employeeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEmployee__NoManagerImpliesDirectReports__DiagnosticChain_Map() {
		return employeeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBug418716() {
		return bug418716EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBug418716_AttributeWithInitital() {
		return (EAttribute)bug418716EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBug418716_AttributeWithoutInitital() {
		return (EAttribute)bug418716EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getEmployee__HasNameAsOperation() {
		return employeeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getCompanySizeKind() {
		return companySizeKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompanyFactory getCompanyFactory() {
		return (CompanyFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		companyEClass = createEClass(0);
		createEAttribute(companyEClass, 0);
		createEReference(companyEClass, 1);
		createEAttribute(companyEClass, 2);
		createEOperation(companyEClass, 0);

		employeeEClass = createEClass(1);
		createEAttribute(employeeEClass, 0);
		createEReference(employeeEClass, 1);
		createEReference(employeeEClass, 2);
		createEReference(employeeEClass, 3);
		createEReference(employeeEClass, 4);
		createEReference(employeeEClass, 5);
		createEAttribute(employeeEClass, 6);
		createEOperation(employeeEClass, 0);
		createEOperation(employeeEClass, 1);
		createEOperation(employeeEClass, 2);

		bug418716EClass = createEClass(2);
		createEAttribute(bug418716EClass, 0);
		createEAttribute(bug418716EClass, 1);

		// Create enums
		companySizeKindEEnum = createEEnum(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(companyEClass, Company.class, "Company", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getCompany_Name(), ecorePackage.getEString(), "name", null, 1, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCompany_Employees(), this.getEmployee(), this.getEmployee_Company(), "employees", null, 0, -1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getCompany_Size(), this.getCompanySizeKind(), "size", null, 1, 1, Company.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		EOperation op = initEOperation(getCompany__DummyInvariant__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "dummyInvariant", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(employeeEClass, Employee.class, "Employee", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getEmployee_Name(), ecorePackage.getEString(), "name", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getEmployee_Manager(), this.getEmployee(), null, "manager", null, 0, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getEmployee_Company(), this.getCompany(), this.getCompany_Employees(), "company", null, 1, 1, Employee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getEmployee_DirectReports(), this.getEmployee(), null, "directReports", null, 0, -1, Employee.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getEmployee_AllReports(), this.getEmployee(), null, "allReports", null, 0, -1, Employee.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getEmployee_ReportingChain(), this.getEmployee(), null, "reportingChain", null, 0, -1, Employee.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEmployee_HasNameAsAttribute(), ecorePackage.getEBoolean(), "hasNameAsAttribute", null, 1, 1, Employee.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getEmployee__ReportsTo__Employee(), ecorePackage.getEBoolean(), "reportsTo", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getEmployee(), "manager", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEOperation(getEmployee__HasNameAsOperation(), ecorePackage.getEBoolean(), "hasNameAsOperation", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getEmployee__NoManagerImpliesDirectReports__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "noManagerImpliesDirectReports", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(bug418716EClass, Bug418716.class, "Bug418716", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getBug418716_AttributeWithInitital(), ecorePackage.getEInt(), "AttributeWithInitital", null, 1, 1, Bug418716.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBug418716_AttributeWithoutInitital(), ecorePackage.getEInt(), "AttributeWithoutInitital", null, 1, 1, Bug418716.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(companySizeKindEEnum, CompanySizeKind.class, "CompanySizeKind"); //$NON-NLS-1$
		addEEnumLiteral(companySizeKindEEnum, CompanySizeKind.SMALL);
		addEEnumLiteral(companySizeKindEEnum, CompanySizeKind.MEDIUM);
		addEEnumLiteral(companySizeKindEEnum, CompanySizeKind.LARGE);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import"; //$NON-NLS-1$
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "ecore", "http://www.eclipse.org/emf/2002/Ecore" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore"; //$NON-NLS-1$
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", //$NON-NLS-1$ //$NON-NLS-2$
			   "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", //$NON-NLS-1$ //$NON-NLS-2$
			   "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (employeeEClass,
		   source,
		   new String[] {
			   "constraints", "mustHaveName mustHaveNonEmptyName" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"; //$NON-NLS-1$
		addAnnotation
		  (getCompany__DummyInvariant__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "true" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (getCompany_Size(),
		   source,
		   new String[] {
			   "derivation", "let table = Set{Tuple{range = Sequence{0..49}, size = CompanySizeKind::small}, Tuple{range = Sequence{50..999}, size = CompanySizeKind::medium}, Tuple{range = Sequence{1000..1000000}, size = CompanySizeKind::large}} in table->any(range->includes(employees->size())).size" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (employeeEClass,
		   source,
		   new String[] {
			   "mustHaveName", "Tuple {\n\tmessage : String = \'Employee must have a name\',\n\tstatus : Boolean = not name.oclIsUndefined() and hasNameAsAttribute and hasNameAsOperation()\n}.status", //$NON-NLS-1$ //$NON-NLS-2$
			   "mustHaveNonEmptyName", "name->notEmpty() implies name.size() > 0" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (getEmployee__ReportsTo__Employee(),
		   source,
		   new String[] {
			   "body", "self.reportingChain->includes(manager)" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (getEmployee__HasNameAsOperation(),
		   source,
		   new String[] {
			   "body", "name <> null" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (getEmployee__NoManagerImpliesDirectReports__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "manager.oclIsUndefined() implies directReports->size() > 0" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (getEmployee_DirectReports(),
		   source,
		   new String[] {
			   "derivation", "company.employees->select(manager = self)" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (getEmployee_AllReports(),
		   source,
		   new String[] {
			   "derivation", "Employee.allInstances()->select(reportsTo(self))" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (getEmployee_ReportingChain(),
		   source,
		   new String[] {
			   "derivation", "if manager.oclIsUndefined() then OrderedSet{} else manager?.reportingChain->prepend(manager) endif" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (getEmployee_HasNameAsAttribute(),
		   source,
		   new String[] {
			   "derivation", "name <> null" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (getBug418716_AttributeWithInitital(),
		   source,
		   new String[] {
			   "derivation", "100" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //CompanyPackageImpl
