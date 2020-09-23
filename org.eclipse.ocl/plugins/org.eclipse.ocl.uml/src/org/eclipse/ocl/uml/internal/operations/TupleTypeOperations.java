/*******************************************************************************
 * Copyright (c) 2008, 2018 Zeligsoft Inc. and others.
 *  All rights reserved.   This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v20.html
 *  
 *  Contributors:
 *    Zeligsoft - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.uml.internal.operations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.uml.TupleType;

import org.eclipse.uml2.uml.Operation;

import org.eclipse.uml2.uml.internal.operations.DataTypeOperations;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Tuple Type</b></em>' model objects.
 * @since 2.0
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.utilities.PredefinedType#getName() <em>Get Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.utilities.PredefinedType#oclOperations() <em>Ocl Operations</em>}</li>
 * </ul>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class TupleTypeOperations
		extends DataTypeOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TupleTypeOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static String getName(TupleType tupleType) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static EList<Operation> oclOperations(TupleType tupleType) {
		throw new UnsupportedOperationException();
	}

} // TupleTypeOperations