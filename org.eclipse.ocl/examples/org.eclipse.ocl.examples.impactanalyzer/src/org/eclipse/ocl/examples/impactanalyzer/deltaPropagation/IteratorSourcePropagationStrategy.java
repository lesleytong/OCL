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

import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.examples.impactanalyzer.util.OclHelper;
import org.eclipse.ocl.examples.impactanalyzer.util.Tuple.Pair;



public class IteratorSourcePropagationStrategy extends DeltaPropagationStrategyWithTargetExpressionAndPartialEvaluator {

    public IteratorSourcePropagationStrategy(IteratorExp loopExp, PartialEvaluatorImpl evaluator) {
        super(loopExp, evaluator);
    }

    public Collection<Pair<OCLExpression, Collection<Object>>> mapDelta(OCLExpression sourceOfIterator, Collection<Object> delta) {
        return PartialEvaluatorImpl.getResultCollectionFromSingleDelta(getPropagatesTo(), OclHelper.flatten(
                getEvaluator().evaluate(null, (CallExp) getPropagatesTo(), delta)));
    }

}
