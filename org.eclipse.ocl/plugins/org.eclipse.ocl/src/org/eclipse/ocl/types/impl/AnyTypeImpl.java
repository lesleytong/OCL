/*******************************************************************************
 * Copyright (c) 2006, 2018 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 *******************************************************************************/
package org.eclipse.ocl.types.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.types.AnyType;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Any Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AnyTypeImpl<O>
		extends EObjectImpl
		implements AnyType<O> {

	private EList<O> operations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnyTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.ANY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		return SINGLETON_NAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<O> oclOperations() {
		if (operations == null) {
			Environment<?, ?, O, ?, ?, ?, ?, ?, ?, ?, ?, ?> env = Environment.Registry.INSTANCE
				.getEnvironmentFor(this);

			operations = new BasicEList<O>(
				OCLStandardLibraryUtil.createAnyTypeOperations(env));
		}

		return operations;
	}

} //AnyTypeImpl
