/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo Herrera (University of York) - Lookup Environment/Visitor
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.lookup;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.autogen.java.AutoVisitorsCG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.pivot.utilities.ClassUtil;


/**
 * LookupCG2JavaVisitor refines the regular generation of Java code from an optimized Auto CG transformation tree
 * to add contributions that are inadequately represented by the CG model.
 */
public abstract class LookupVisitorsCG2JavaVisitor<@NonNull C extends LookupVisitorsCodeGenerator> extends AutoVisitorsCG2JavaVisitor<C>
{

	public LookupVisitorsCG2JavaVisitor(@NonNull C codeGenerator, @NonNull CGPackage cgPackage,
			@Nullable List<CGValuedElement> sortedGlobals) {
		super(codeGenerator, cgPackage, sortedGlobals);
	}

	@Override
	protected void doConstructor(@NonNull CGClass cgClass) {
		js.append("public " + cgClass.getName() + "(");
		js.appendClassReference(true, context.getEnvironmentClass());
		js.append(" " + LookupVisitorsClassContext.CONTEXT_NAME);
		doAdditionalConstructorParameters(cgClass);
		js.append(") {\n");
		js.pushIndentation(null);
		js.append("super(" + LookupVisitorsClassContext.CONTEXT_NAME + ");\n");
		js.append("this." + JavaConstants.EXECUTOR_NAME + " = ");
		js.appendClassReference(null, ClassUtil.class);
		js.append(".nonNull(" + LookupVisitorsClassContext.CONTEXT_NAME + ".getExecutor());\n");
		js.append("this." + JavaConstants.ID_RESOLVER_NAME + " = " + JavaConstants.EXECUTOR_NAME + ".getIdResolver();\n");
		doAdditionalFieldsInitialization(cgClass);
		js.popIndentation();
		js.append("}\n");


	}

	@Override
	protected void doVisiting(@NonNull CGClass cgClass) {
		/* visiting(Visitable) will be generated by the super AbstractXXXCommonVisitorLookup which delegates
		 * to a protected doVisiting(Visitable) method. The latter will have to be generated by the specific
		 * lookup visitor */
		doInternalVisiting(cgClass);
	}

	@Override
	protected void doMoreClassMethods(@NonNull CGClass cgClass) {
		doVisiting(cgClass); // We will do the doVisiting for all languages (also derived ones)
		if (!context.isBaseVisitorsGeneration()) {
			doCreateSuperLangVisitor(cgClass);
		}
	}

	protected void doCreateSuperLangVisitor(@NonNull CGClass cgClass) {
		String superLookupVisitorClassName = getSuperLookupVisitorClassName();
		js.append("@Override\n");
		js.append("protected ");
		js.appendClassReference(null, superLookupVisitorClassName);
		js.append(" createSuperLangVisitor() {\n");
		js.pushIndentation(null);
		js.append("return new ");
		js.appendClassReference(null, superLookupVisitorClassName);
		js.append("("+LookupVisitorsClassContext.CONTEXT_NAME);
		doAdditionalSuperLookupVisitorArgs(cgClass);
		js.append(");");
		js.popIndentation();
		js.append("}\n");
	}

	protected String getSuperLookupVisitorClassName() {
		return context.getSuperLookupVisitorClassName();
	}

	protected void doAdditionalConstructorParameters(@NonNull CGClass cgClass) {
		// by default no additional parameters
	}

	protected void doAdditionalFieldsInitialization(@NonNull CGClass cgClass) {
		// by default no additional field initialization
	}

	protected void doAdditionalSuperLookupVisitorArgs(@NonNull CGClass cgClass) {
		// by default no additional super lookup visitor constructor args
	}

	/**
	 * Every specific lookup visitor will its own behaviour for the default visiting
	 * @param cgClass
	 */
	abstract protected void doInternalVisiting(@NonNull CGClass cgClass);
}
