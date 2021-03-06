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
package persistence.actions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see persistence.actions.ActionsPackage
 * @generated
 */
public interface ActionsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActionsFactory eINSTANCE = persistence.actions.impl.ActionsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Store</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Store</em>'.
	 * @generated
	 */
	Store createStore();

	/**
	 * Returns a new object of class '<em>Delete</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete</em>'.
	 * @generated
	 */
	Delete createDelete();

	/**
	 * Returns a new object of class '<em>Statement With Entity Argument</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statement With Entity Argument</em>'.
	 * @generated
	 */
	StatementWithEntityArgument createStatementWithEntityArgument();

	/**
	 * Returns a new object of class '<em>Rollback</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rollback</em>'.
	 * @generated
	 */
	Rollback createRollback();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ActionsPackage getActionsPackage();

} //ActionsFactory
