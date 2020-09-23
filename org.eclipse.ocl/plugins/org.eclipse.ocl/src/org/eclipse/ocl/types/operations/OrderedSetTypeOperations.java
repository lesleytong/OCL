/*******************************************************************************
 * Copyright (c) 2008, 2018 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 *******************************************************************************/
package org.eclipse.ocl.types.operations;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.types.OrderedSetType;

import org.eclipse.ocl.types.util.TypesValidator;
import org.eclipse.ocl.util.OCLUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Ordered Set Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.types.OrderedSetType#checkCollectionTypeName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Collection Type Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OrderedSetTypeOperations
		extends CollectionTypeOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrderedSetTypeOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.name = 'OrderedSet(' + self.elementType.name + ')'
	 * @param orderedSetType The receiving '<em><b>Ordered Set Type</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static <C, O> boolean checkCollectionTypeName(
			OrderedSetType<C, O> orderedSetType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		boolean result = true;
		Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
			.getValidationEnvironment(orderedSetType, context);

		if (env != null) {
			String name = orderedSetType.getName();
			C elementType = orderedSetType.getElementType();

			if (elementType != null) {
				String elementTypeName = env.getUMLReflection()
					.getName(elementType);

				result = ("OrderedSet(" + elementTypeName + ")").equals(name); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		if (!result) {
			if (diagnostics != null) {
				// TODO: Specific message
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
					TypesValidator.DIAGNOSTIC_SOURCE,
					TypesValidator.ORDERED_SET_TYPE__COLLECTION_TYPE_NAME,
					org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE.getString(
						"_UI_GenericInvariant_diagnostic", //$NON-NLS-1$
						new Object[]{"checkCollectionTypeName", //$NON-NLS-1$
							org.eclipse.emf.ecore.util.EObjectValidator
								.getObjectLabel(orderedSetType, context)}),
					new Object[]{orderedSetType}));
			}
		}
		return result;
	}

} // OrderedSetTypeOperations