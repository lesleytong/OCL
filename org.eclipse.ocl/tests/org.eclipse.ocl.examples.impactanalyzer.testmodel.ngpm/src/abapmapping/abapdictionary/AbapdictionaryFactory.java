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
package abapmapping.abapdictionary;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see abapmapping.abapdictionary.AbapdictionaryPackage
 * @generated
 */
public interface AbapdictionaryFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AbapdictionaryFactory eINSTANCE = abapmapping.abapdictionary.impl.AbapdictionaryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Xsd Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xsd Type</em>'.
	 * @generated
	 */
	XsdType createXsdType();

	/**
	 * Returns a new object of class '<em>Unstructured Abap Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unstructured Abap Type</em>'.
	 * @generated
	 */
	UnstructuredAbapType createUnstructuredAbapType();

	/**
	 * Returns a new object of class '<em>Code Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Code Value</em>'.
	 * @generated
	 */
	CodeValue createCodeValue();

	/**
	 * Returns a new object of class '<em>Code</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Code</em>'.
	 * @generated
	 */
	Code createCode();

	/**
	 * Returns a new object of class '<em>Data Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Element</em>'.
	 * @generated
	 */
	DataElement createDataElement();

	/**
	 * Returns a new object of class '<em>Abap Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abap Type</em>'.
	 * @generated
	 */
	AbapType createAbapType();

	/**
	 * Returns a new object of class '<em>Abap Structure Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abap Structure Type</em>'.
	 * @generated
	 */
	AbapStructureType createAbapStructureType();

	/**
	 * Returns a new object of class '<em>Abap Structure Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abap Structure Field</em>'.
	 * @generated
	 */
	AbapStructureField createAbapStructureField();

	/**
	 * Returns a new object of class '<em>Abap Primtive Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abap Primtive Type</em>'.
	 * @generated
	 */
	AbapPrimtiveType createAbapPrimtiveType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AbapdictionaryPackage getAbapdictionaryPackage();

} //AbapdictionaryFactory
