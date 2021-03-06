/*******************************************************************************
 * Copyright (c) 2009, 2018 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.deltaPropagation;

import java.util.Collection;

import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.examples.impactanalyzer.util.Tuple.Pair;


public class IdentityPropagationStrategy extends DeltaPropagationStrategyWithTargetExpression {

    public IdentityPropagationStrategy(OCLExpression propagatesTo) {
        super(propagatesTo);
    }

    public Collection<Pair<OCLExpression, Collection<Object>>> mapDelta(OCLExpression e, Collection<Object> delta) {
        return PartialEvaluatorImpl.getResultCollectionFromSingleDelta(getPropagatesTo(), delta);
    }

}
