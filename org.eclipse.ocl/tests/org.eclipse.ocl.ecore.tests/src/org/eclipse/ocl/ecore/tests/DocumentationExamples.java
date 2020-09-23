/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *  E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.ecore.tests;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.FeatureMapUtil.BasicValidator;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Query;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.EcoreEnvironmentFactoryWithHiddenOpposites;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.ecore.tests.extlibrary.Book;
import org.eclipse.ocl.ecore.tests.extlibrary.BookCategory;
import org.eclipse.ocl.ecore.tests.extlibrary.EXTLibraryFactory;
import org.eclipse.ocl.ecore.tests.extlibrary.EXTLibraryPackage;
import org.eclipse.ocl.ecore.tests.extlibrary.Library;
import org.eclipse.ocl.ecore.util.EcoreValidator;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.pivot.internal.labels.LabelSubstitutionLabelProvider;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.validation.ComposedEValidator;
import org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLEObjectValidator;

/**
 * Tests for the OCL delegate implementations.
 */
@SuppressWarnings("nls")
public class DocumentationExamples
		extends AbstractTestSuite {

	public InputStream getInputStream(String fileName)
			throws MalformedURLException, IOException {
		URI uri = getTestModelURI(fileName);
		return resourceSet.getURIConverter().createInputStream(uri);
	}

	private List<Library> getLibraries() {
		return Collections.emptyList();
	}

	public Library getLibrary() {
		Library library = EXTLibraryFactory.eINSTANCE.createLibrary();
		Book aBook = EXTLibraryFactory.eINSTANCE.createBook();
		aBook.setTitle("Bleak House");
		library.getBooks().add(aBook);

		// lyt: 测试unique_title
		Book bBook = EXTLibraryFactory.eINSTANCE.createBook();
		bBook.setTitle("Bleak House");
		library.getBooks().add(bBook);

		return library;
	}

	/*
	 * This 'test' provides the source text for the 'Parsing OCL Document'
	 * example in org.eclipse.ocl.doc/doc/5120-parsing-constraints.textile
	 */
	public void test_parsingConstraintsExample()
			throws IOException, ParserException {
		// create an OCL instance for Ecore
		OCL ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);

		// create an OCL helper object
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper = ocl
			.createOCLHelper();

		// set the OCL context classifier
		helper.setContext(EXTLibraryPackage.Literals.LIBRARY);

		Constraint invariant = helper.createInvariant(
			"books->forAll(b1, b2 | b1 <> b2 implies b1.title <> b2.title)");

		OCLExpression<EClassifier> query = helper
			.createQuery("books->collect(b : Book | b.category)->asSet()");

		EOperation oper = null;
		for (EOperation next : EcorePackage.Literals.EMODEL_ELEMENT
			.getEOperations()) {
			if ("getEAnnotation".equals(next.getName())) {
				oper = next;
				break;
			}
		}

		// define a post-condition specifying the value of
		// EModelElement::getEAnnotation(EString).
		// This operation environment includes variables representing the
		// operation
		// parameters (in this case, only "source : String") and the operation
		// result
		helper.setOperationContext(EcorePackage.Literals.ECLASS, oper);
		Constraint body = helper.createPostcondition(
			"result = self.eAnnotations->any(ann | ann.source = source)");

		// define a derivation constraint for the EReference::eReferenceType
		// property
		helper.setAttributeContext(EcorePackage.Literals.EREFERENCE,
			EcorePackage.Literals.EREFERENCE__EREFERENCE_TYPE);
		Constraint derive = helper.createDerivedValueExpression(
			"self.eType->any(true).oclAsType(EClass)");

		if ((body == derive) && (invariant == query)) {
			/* the yellow markers go away */ }
	}

	/*
	 * This 'test' provides the source text for the 'Parsing OCL Document'
	 * example in org.eclipse.ocl.doc/doc/5115-evaluating-constraints.textile
	 */
	public void test_evaluatingConstraintsExample()
			throws IOException, ParserException {
		OCL ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		OCLHelper<EClassifier, ?, ?, Constraint> helper = ocl.createOCLHelper();

		helper.setContext(EXTLibraryPackage.Literals.LIBRARY);
		Constraint invariant = helper.createInvariant(
			"books->forAll(b1, b2 | b1 <> b2 implies b1.title <> b2.title)");
		OCLExpression<EClassifier> query = helper
			.createQuery("books->collect(b : Book | b.category)->asSet()");

		// create a Query to evaluate our query expression
		Query queryEval = ocl.createQuery(query);

		// create another to check our constraint
		Query constraintEval = ocl.createQuery(invariant);

		List<Library> libraries = getLibraries(); // hypothetical source of
													// libraries

		// only print the set of book categories for valid libraries
		for (Library next : libraries) {
			if (constraintEval.check(next)) {
				// the OCL result type of our query expression is
				// Set(BookCategory)
				@SuppressWarnings("unchecked")
				Set<BookCategory> categories = (Set<BookCategory>) queryEval
					.evaluate(next);

				if (!noDebug)
					System.out.printf("%s: %s\n", next.getName(), categories);
			}
		}

		// Check one

		// check a single library

		Library lib = getLibrary(); // hypothetical source of a library
		// check whether it satisfies the constraint
		// lyt: 之前有if(!noDebug)
		System.out.printf("%s valid: %b\n", lib.getName(),
			ocl.check(lib, invariant));

		// lyt: print the diagnostics
		Diagnostic validation = Diagnostician.INSTANCE.validate(lib);
		System.out.println("getSeverity(): " + validation.getSeverity());	// why return 0(OK)?
		
		// lyt: maybe the book
		System.out.println("how many books: " + lib.getBooks().size());
		Book book = lib.getBooks().get(0);
		Diagnostic validation2 = Diagnostician.INSTANCE.validate(book);
		System.out.println("getSeverity(): " + validation2.getSeverity()); // return 4(ERROR)
		System.out.println("getMessage(): " + validation2.getMessage());
		if (validation2.getSeverity() != Diagnostic.OK) {
			String formattedDiagnostics = PivotUtil
				.formatDiagnostics(validation2, "\n");
			System.out.println(formattedDiagnostics);
		}

		// MoreSuccinct

		// only print the set of book categories for valid libraries
		for (Library next : constraintEval.select(libraries)) {
			@SuppressWarnings("unchecked")
			Set<BookCategory> categories = (Set<BookCategory>) queryEval
				.evaluate(next);

			if (!noDebug)
				System.out.printf("%s: %s%n", next.getName(), categories);
		}
	}

	/*
	 * This 'test' provides the source text for the 'Parsing OCL Document'
	 * example in org.eclipse.ocl.doc/doc/5120-parsing-documents.textile
	 */
	public void test_parsingDocumentsExample()
			throws IOException, ParserException {
		// -------------------------------------------------------------------------
		// The OCL Input
		// -------------------------------------------------------------------------
		EPackage.Registry registry = new EPackageRegistryImpl();
		registry.put(EXTLibraryPackage.eNS_URI, EXTLibraryPackage.eINSTANCE);
		EcoreEnvironmentFactory environmentFactory = new EcoreEnvironmentFactory(
			registry);
		OCL ocl = OCL.newInstance(environmentFactory);

		// get an OCL text file via some hypothetical API
		InputStream in = getInputStream("/model/parsingDocumentsExample.ocl");

		Map<String, Constraint> constraintMap = new HashMap<String, Constraint>();

		// parse the contents as an OCL document
		try {
			OCLInput document = new OCLInput(in);

			List<Constraint> constraints = ocl.parse(document);
			for (Constraint next : constraints) {
				constraintMap.put(next.getName(), next);

				OCLExpression<EClassifier> body = next.getSpecification()
					.getBodyExpression();
				if (!noDebug)
					System.out.printf("%s: %s%n", next.getName(), body);
			}
		} finally {
			in.close();
		}

		// -------------------------------------------------------------------------
		// Accessing the Constraints
		// -------------------------------------------------------------------------
		Library library = getLibrary(); // get library from a hypothetical
										// source

		OCLHelper<EClassifier, ?, ?, Constraint> helper = ocl.createOCLHelper();

		// use the constraints defined in the OCL document

		// use the getBooks() additional operation to find a book
		helper.setContext(EXTLibraryPackage.Literals.LIBRARY);
		OCLExpression<EClassifier> query = helper
			.createQuery("getBooks('Bleak House')->asSequence()->first()");

		Book book = (Book) ocl.evaluate(library, query);
		// lyt: 原来还有if(!noDebug)
		System.out.printf("Got book: %s%n", book);

		// use the unique_title constraint to validate the book
		System.out.printf("Validate book: %b%n",
			ocl.check(book, constraintMap.get("unique_title")));

		// lyt: use the unique_title constraint to validate the library
		// why return true??
		Constraint constraint = constraintMap.get("unique_title");
		System.out.printf("Validate library: %b%n",
			ocl.check(library, constraint));

		for (Book b : library.getBooks()) {
			System.out.println(b);
		}

		// lyt: 		
		// 还没有Validator
		
		Resource resource = library.eResource();	// --return null
		MyDiagnostician diagnostician = new MyDiagnostician();
		Diagnostic diagnostics = diagnostician.validate(resource);

		// Print the diagnostics
		if (diagnostics.getSeverity() != Diagnostic.OK) {
			String formattedDiagnostics = PivotUtil
				.formatDiagnostics(diagnostics, "\n");
			System.out.println(formattedDiagnostics);
		}

	}

	/**
	 * The following is documented in
	 * doc/org.eclipse.ocl.doc/doc/5160-customization.textile in section
	 * "Customizing Hidden Opposite Lookup and Navigation"
	 */
	public void testCustomizingOppositeEndFinder() {
		OppositeEndFinder oef = new MyOppositeEndFinder();
		OCL ocl = OCL
			.newInstance(new EcoreEnvironmentFactoryWithHiddenOpposites(
				EPackage.Registry.INSTANCE, oef));
		assertSame(oef,
			((EcoreEnvironment) ocl.getEnvironment()).getOppositeEndFinder());
	}

	private class MyOppositeEndFinder
			extends DefaultOppositeEndFinder {

		public MyOppositeEndFinder() {
			super(EPackage.Registry.INSTANCE);
		}
	}

	public class MyDiagnostician
			extends Diagnostician {

		@Override
		public Map<Object, Object> createDefaultContext() {
			Map<Object, Object> context = super.createDefaultContext();
			context.put(EValidator.SubstitutionLabelProvider.class,
				new LabelSubstitutionLabelProvider());
			return context;
		}

		public BasicDiagnostic createDefaultDiagnostic(Resource resource) {
			return new BasicDiagnostic(EObjectValidator.DIAGNOSTIC_SOURCE, 0,
				EMFEditUIPlugin.INSTANCE.getString(
					"_UI_DiagnosisOfNObjects_message", new String[]{"1"}),
				new Object[]{resource});
		}

		public Diagnostic validate(Resource resource) {
			BasicDiagnostic diagnostics = createDefaultDiagnostic(resource);
			Map<Object, Object> context = createDefaultContext();
			for (EObject eObject : resource.getContents()) {
				validate(eObject, diagnostics, context);
			}
			return diagnostics;
		}
	}
	
	public URI getInputURI(String fileName) throws MalformedURLException, IOException {
		return getTestModelURI(fileName);
	}
}
