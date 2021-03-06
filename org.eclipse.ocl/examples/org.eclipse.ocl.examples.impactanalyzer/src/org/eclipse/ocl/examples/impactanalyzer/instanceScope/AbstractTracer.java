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
package org.eclipse.ocl.examples.impactanalyzer.instanceScope;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.CollectionRange;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.ecore.TupleLiteralPart;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.examples.impactanalyzer.impl.OperationBodyToCallMapper;
import org.eclipse.ocl.examples.impactanalyzer.util.AnnotatedEObject;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.util.OclHelper;



public abstract class AbstractTracer<T extends EObject> implements Tracer {
    private T expression;
    final private Stack<String> tuplePartNames;
    protected final OCLFactory oclFactory;

    /**
     * Creates a tracer with a <tt>null</tt> {@link #tuplePartNames} array, meaninig that this tracer is not looking for
     * {@link TupleLiteralPart} expressions on which to unroll a part access.
     * 
     * @param expression
     *            the OCL expression for which this tracer shall determine a navigation step
     */
    protected AbstractTracer(T expression, OCLFactory oclFactory) {
        this(expression, (Stack<String>)/* tuplePartNames */null, oclFactory);
    }

    /**
     * Specifies an explicit list of tuple part names to look for. Useful in combination with
     * {@link #getListOfTuplePartNamesWithFoundRemoved()}.
     */
    protected AbstractTracer(T expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
        this.expression = expression;
        this.tuplePartNames = tuplePartNames;
        this.oclFactory = oclFactory;
    }

    /**
     * Creates a tracer for OCL expression <tt>expression</tt> and adding another tuple part name to the list of tuple parts to
     * look for as already defined for the <tt>caller</tt> tracer. See also {@link #getExtendedListOfTuplePartNames(String)}.
     * @param additionalTuplePartNameToLookFor
     *            if along the chain of sub-expressions traversed there was an attribute access on a source expression of a tuple
     *            type that needs to be unwound when at some point a {@link TupleLiteralPart} is found. Must not be <tt>null</tt>.
     */
    protected AbstractTracer(T expression, AbstractTracer<?> caller, String additionalTuplePartNameToLookFor, OCLFactory oclFactory) {
        this(expression, getExtendedListOfTuplePartNames(caller.tuplePartNames, additionalTuplePartNameToLookFor), oclFactory);
    }

    protected T getExpression() {
        return expression;
    }

    protected boolean isLookingForTuplePart() {
        return tuplePartNames != null && tuplePartNames.size() > 0;
    }

    protected String getTuplePartNameLookedFor() {
        return tuplePartNames.peek();
    }
  
    private static Stack<String> getExtendedListOfTuplePartNames(Stack<String> oldTuplePartNames, String toAdd) {
        Stack<String> result;
        if (oldTuplePartNames == null || oldTuplePartNames.size() == 0) {
            result = new Stack<String>();
        } else {
            Object clone = oldTuplePartNames.clone();
            if(clone instanceof Stack<?>){
                @SuppressWarnings("unchecked")
                Stack<String> x = (Stack<String>) clone;
                result = x;
                
            }else{
                throw new ClassCastException("Cloning an instance of Stack<String> didn't return an instance of the same type.");
            }
        }
        result.add(toAdd);
        return result;
    }

    public Stack<String> getExtendedListOfTuplePartNames(String toAdd) {
        return getExtendedListOfTuplePartNames(tuplePartNames, toAdd);
    }

    /**
     * Returns {@link #tuplePartNames} with the first element at index 0 removed. If {@link #tuplePartNames} is <tt>null</tt> or
     * contains one or no element, <tt>null</tt> is returned.
     */
    protected Stack<String> getListOfTuplePartNamesWithFoundRemoved() {
        Stack<String> result;
        if (tuplePartNames == null || tuplePartNames.size() <= 1) {
            result = null;
        } else {
            Object clone = tuplePartNames.clone();
            if (clone instanceof Stack<?>){
                @SuppressWarnings("unchecked")
                Stack<String> x = (Stack<String>) clone;
                result = x;
                result.pop();
            }else{
                throw new ClassCastException("Cloning an instance of Stack<String> didn't return an instance of the same type.");
            }
        }
        return result;
    }

    public Stack<String> getTupleLiteralPartNamesToLookFor() {
        return tuplePartNames;
    }

    /**
     * There are a few known idiosyncrasies in the OCL "composition" hierarchy. A {@link TupleLiteralExp} does not contain its
     * {@link TupleLiteralExp#getPart() tuple parts} which are variable declarations, a {@link CollectionLiteralExp} does not
     * contain its {@link CollectionLiteralExp#getPart() parts}, and of those parts, none of {@link CollectionRange} nor
     * {@link CollectionItem} contains the expressions that it uses to describe itself.
     * <p>
     * 
     * We still need to be able to determine the scope of, e.g., <tt>self</tt> or operation parameters and therefore need to
     * ascend what may be called the "logical composition hierarchy" of an OCL expression. Therefore, this operation ascends the
     * real composition hierarchy until it finds a <tt>null</tt> parent or a parent of type constraint or EAnnotation.
     * 
     * In this case, it tries the aforementioned "logical compositions" one after the other. If for one such association another
     * element is found, ascending continues there.
     */
    protected OCLExpression getRootExpression() {
        return OclHelper.getRootExpression(getExpression());
    }

    /**
     * Checks if <tt>s</tt> conforms to the type of the {@link #getExpression()
     * expression} managed by this tracer. A mismatch may occur because of "reverse polymorphic traversal." In other
     * words, if an expression with a {@link ModelPropertyCallExpInternal#getSource(CoreConnection) source} traces back
     * to its source in order to find out the possible values for <tt>self</tt> that may have produced a specific value,
     * the actual source object may be of a more general type than the static type of the source expression of the
     * specific expression analyzed. This can happen because there may be multiple occurrences of attribute or
     * association end call expressions for the same attribute/association that occur in different expressions, where
     * navigation back to <tt>self</tt> is not always possible because of the actual type constraints.
     * <p>
     * 
     * All implementations of {@link Tracer#traceback(EClass, PathCache, OperationBodyToCallMapper)} must call this
     * operation to ensure they don't try to continue on a trace that type-wise is impossible.
     */
    protected boolean doesTypeMatch(EObject s) {
        return getExpression().eClass().isInstance(s);
    }

    public static boolean doesTypeMatch(EClass sourceType, AnnotatedEObject fromObject) {
        return sourceType.isInstance(fromObject.getAnnotatedObject());
    }

    /**
     * By default, many expression types which, e.g., result in a primitive result, return an {@link EmptyResultNavigationStep}
     * which is what this default implementation does.
     */
    public NavigationStep traceback(EClass context, PathCache pathCache, OperationBodyToCallMapper operationBodyToCallMapper) {
        NavigationStep result = new EmptyResultNavigationStep((OCLExpression) getExpression());
        applyScopesOnNavigationStep(result, operationBodyToCallMapper);
        return result;
    }

    /**
     * We assume a collection, possibly nested, that eventually has elements of a class-like type inside.
     */
    protected EClass getInnermostElementType(EClassifier type) {
        while (!(type instanceof EClass) && type instanceof CollectionType) {
            type = ((CollectionType) type).getElementType();
        }
        return (EClass) type;
    }
    
    /**
     * Calculates which scopes the {@link NavigationStep} this {@link Tracer} creates will leave when navigated.
     * @return the set of {@link OCLExpression}s representing the scopes the created {@link NavigationStep} will leave when navigated.
     */
    protected Set<Variable> calculateLeavingScopes(OperationBodyToCallMapper operationBodyToCallMapper){
        return Collections.emptySet();
    }
    
    /**
     * Calculates the scopes the {@link NavigationStep} this {@link Tracer} creates will enter when navigated.
     * @return the {@link OCLExpression}s representing the scope the created {@link NavigationStep} will enter when navigated. Always
     * non-<code>null</code>, but possibly empty
     */
    protected Set<Variable> calculateEnteringScope(OperationBodyToCallMapper operationBodyToCallMapper) {
        return Collections.emptySet();
    }
    
    protected void applyScopesOnNavigationStep(NavigationStep step, OperationBodyToCallMapper operationBodyToCallMapper){
        // TODO not only remember the variable scope changes but also record which unused checks need to be performed with the old/new scopes
        step.addEnteringScopes(calculateEnteringScope(operationBodyToCallMapper));
        step.addLeavingScopes(calculateLeavingScopes(operationBodyToCallMapper));
    }

    /**
     * This method returns all variables introduced by <code>parent</code> or any contained expression along the containment
     * hierarchy, down to <code>origin</code>.
     * 
     * @param origin
     *            The {@link OCLExpression} used as the origin of the search.
     * @param parent
     *            The {@link OCLExpression} that is a immediate or transitive containment parent of the origin (see
     *            {@link EObject#eContainer()})
     * @return A {@link Set} of {@link OCLExpression}s containing all scope creating expressions in the containment hierarchy
     *         between origin and parent.
     */
    protected Set<Variable> variablesIntroducedBetween(OCLExpression origin, OCLExpression parent, OperationBodyToCallMapper operationBodyToCallMapper) {
        EObject e = origin;
        Set<Variable> result = new HashSet<Variable>();
        while (e != parent) {
            if (e instanceof OCLExpression) {
                result.addAll(getVariablesScopedByExpression((OCLExpression) e, operationBodyToCallMapper));
            }
            e = e.eContainer();
        }
        return result;
    }
    
    protected static Set<Variable> getVariablesScopedByExpression(OCLExpression e, OperationBodyToCallMapper operationBodyToCallMapper) {
        EObject container = e.eContainer();
        Set<Variable> result = new HashSet<Variable>();
        if (container instanceof LoopExp && ((LoopExp) container).getBody() == e) {
            // body of a loop expression
            for (org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> v : ((LoopExp) container).getIterator()) {
                result.add((Variable) v);
            }
            if (container instanceof IterateExp) {
                Variable resultVariable = (Variable) ((IterateExp) container).getResult();
                if (resultVariable != null) {
                    result.add(resultVariable);
                }
            }
        } else if (container instanceof LetExp && ((LetExp) container).getIn() == e) {
            // in-expression of a let-expression
            result.add((Variable) ((LetExp) container).getVariable());
        } else {
            Set<OperationCallExp> calls = operationBodyToCallMapper.getCallsOf(e);
            if (!calls.isEmpty()) {
                // body of an operation
                result.addAll(operationBodyToCallMapper.getSelfVariablesUsedInBody(e));
                result.addAll(operationBodyToCallMapper.getParameterVariablesUsedInBody(e));
            }
            // TODO perform check for body of derived property
        }
        return result;
    }
    
    protected static Set<Variable> getAllVariablesInScope(OCLExpression e, OperationBodyToCallMapper operationBodyToCallMapper) {
        Set<Variable> result = new HashSet<Variable>();
        for (EObject cursor = e; cursor != null; cursor = cursor.eContainer()) {
            if (cursor instanceof OCLExpression) {
                result.addAll(getVariablesScopedByExpression((OCLExpression) cursor, operationBodyToCallMapper));
            }
        }
        return result;
    }

    /**
     * This method is a shortcut for {@link AbstractTracer#variablesIntroducedBetween(OCLExpression, OCLExpression, OperationBodyToCallMapper)} that uses {@link AbstractTracer#getExpression()} as the origin.
     * See {@link AbstractTracer#variablesIntroducedBetween(OCLExpression, OCLExpression, OperationBodyToCallMapper)} for description.
     * @param parent
     * @return a non-<code>null</code> set, possibly empty
     */
    protected Set<Variable> getVariablesIntroducedBetweenHereAnd(OCLExpression parent, OperationBodyToCallMapper operationBodyToCallMapper) {
        return variablesIntroducedBetween((OCLExpression)getExpression(), parent, operationBodyToCallMapper);
    }

    /**
     * This method finds the common composition parent of the two given {@link OCLExpression}s. If the two expressions
     * don't have a common container, <code>null</code> is returned.
     * 
     * @param first The first {@link OCLExpression}.
     * @param second The second {@link OCLExpression}.
     * @return The common composition parent or null, in case there is none.
     */
    protected static OCLExpression commonCompositionParent(OCLExpression first, OCLExpression second) {
        Set<OCLExpression> firstsContainersIncludingFirst = new HashSet<OCLExpression>();
        EObject firstsContainer = first;
        while (firstsContainer != null && firstsContainer instanceof OCLExpression) {
            firstsContainersIncludingFirst.add((OCLExpression) firstsContainer);
            firstsContainer = firstsContainer.eContainer();
        }
        EObject secondsContainer = second;
        OCLExpression result = null;
        while (result == null && secondsContainer != null && secondsContainer instanceof OCLExpression) {
            if (firstsContainersIncludingFirst.contains(secondsContainer)) {
                result = (OCLExpression) secondsContainer;
            } else {
                secondsContainer = secondsContainer.eContainer();
            }
        }
        return result;
    }
    
    /**
     * This method is a shortcut for {@link AbstractTracer#commonCompositionParent(OCLExpression, OCLExpression)} that uses {@link AbstractTracer#getExpression()} as the origin.
     * See {@link AbstractTracer#commonCompositionParent(OCLExpression, OCLExpression)} for description.
     * @param second
     */
    protected OCLExpression commonCompositionParent(OCLExpression second){
        return commonCompositionParent((OCLExpression) getExpression(), second);
    }
}
