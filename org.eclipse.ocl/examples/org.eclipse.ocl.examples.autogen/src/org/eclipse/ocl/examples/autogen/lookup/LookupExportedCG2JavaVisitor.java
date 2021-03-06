/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations, University of York and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Adolfo Sanchez-Barbudo Herrera (University of York)
 *******************************************************************************/
package org.eclipse.ocl.examples.autogen.lookup;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

public class LookupExportedCG2JavaVisitor extends LookupVisitorsCG2JavaVisitor<@NonNull LookupExportedVisitorCodeGenerator> {

	public LookupExportedCG2JavaVisitor(
			@NonNull LookupExportedVisitorCodeGenerator codeGenerator,
			@NonNull CGPackage cgPackage,
			@Nullable List<CGValuedElement> sortedGlobals) {
		super(codeGenerator, cgPackage, sortedGlobals);
	}

	@Override
	protected void doInternalVisiting(@NonNull CGClass cgClass) {
		// We we return the context
		js.append("\n");
		js.append("@Override\n");
		js.append("protected ");
		js.appendClassReference(false, context.getVisitorResultClass());
		js.append(" doVisiting(");
		js.appendClassReference(true, context.getVisitableClass());
		js.append(" visitable) {\n");
		js.pushIndentation(null);
		js.append("return context;\n");
		js.popIndentation();
		js.append("}\n");
	}

	@Override
	protected void doAdditionalConstructorParameters(
			@NonNull CGClass cgClass) {
		js.append(", ");
		js.appendClassReference(true, Object.class);
		js.append(" " + LookupVisitorsClassContext.INMPORTER_NAME);
	}

	@Override
	protected void doAdditionalFieldsInitialization(
			@NonNull CGClass cgClass) {
		js.append("this.");
		js.appendReferenceTo(context.getImporterProperty());
		js.append(" = " +  LookupVisitorsClassContext.INMPORTER_NAME + ";\n");
	}

	@Override
	protected void doAdditionalSuperLookupVisitorArgs(
			@NonNull CGClass cgClass) {
		js.append(",");
		js.appendReferenceTo(context.getImporterProperty());
	}

}
