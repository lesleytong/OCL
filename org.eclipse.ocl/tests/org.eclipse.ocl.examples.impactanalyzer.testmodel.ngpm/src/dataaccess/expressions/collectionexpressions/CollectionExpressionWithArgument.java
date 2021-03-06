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

import dataaccess.expressions.ExpressionWithArgument;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Expression With Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage#getCollectionExpressionWithArgument()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ArgumentTypeMustConformToCollectionExpressionType='let snl : Integer = source.getType().getNestingLevel() in let anl : Integer = argument.getType().getNestingLevel() in\r\n    if snl = anl then\r\n      source.getType().conformsToIgnoringMultiplicity(argument.getType())\r\n    else\r\n      if snl = (anl + 1) then\r\n        source.getType().oclAsType(data::classes::NestedTypeDefinition).type.conformsToIgnoringMultiplicity(argument.getType())\r\n      else\r\n        if (snl + 1) = anl then\r\n          source.getType().conformsToIgnoringMultiplicity(argument.getType().oclAsType(data::classes::NestedTypeDefinition).type)\r\n        else\r\n          false\r\n        endif\r\n      endif\r\n    endif'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ArgumentTypeMustConformToCollectionExpressionType'"
 * @generated
 */
public interface CollectionExpressionWithArgument extends CollectionExpression, ExpressionWithArgument {
} // CollectionExpressionWithArgument
