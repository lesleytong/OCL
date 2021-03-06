/*******************************************************************************
 * Copyright (c) 2009, 2018 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************
 */
package dataaccess.expressions.collectionexpressions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage
 * @generated
 */
public interface CollectionexpressionsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CollectionexpressionsFactory eINSTANCE = dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Including</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Including</em>'.
	 * @generated
	 */
	Including createIncluding();

	/**
	 * Returns a new object of class '<em>Excluding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Excluding</em>'.
	 * @generated
	 */
	Excluding createExcluding();

	/**
	 * Returns a new object of class '<em>Including At</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Including At</em>'.
	 * @generated
	 */
	IncludingAt createIncludingAt();

	/**
	 * Returns a new object of class '<em>Iterate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterate</em>'.
	 * @generated
	 */
	Iterate createIterate();

	/**
	 * Returns a new object of class '<em>Excluding At</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Excluding At</em>'.
	 * @generated
	 */
	ExcludingAt createExcludingAt();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CollectionexpressionsPackage getCollectionexpressionsPackage();

} //CollectionexpressionsFactory
