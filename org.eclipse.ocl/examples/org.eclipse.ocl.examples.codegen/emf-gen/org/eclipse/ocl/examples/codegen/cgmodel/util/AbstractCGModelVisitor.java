/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.ocl.examples.codegen/model/cgmodel.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.ocl.examples.codegen.cgmodel.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/*
 * An AbstractCGModelVisitor provides a default implementation of the visitor framework
 * but n implementations of the visitXXX methods..
 */
public abstract class AbstractCGModelVisitor<R, C>
	implements CGModelVisitor<R>
{
	/**
	 * Context for the AST visitation.
	 */
	protected final C context;

	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractCGModelVisitor(C context) {
		this.context = context;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <A> @Nullable A getAdapter(@NonNull Class<A> adapter) {
		if (adapter.isAssignableFrom(getClass())) {
			return (A) this;
		}
		else {
			return null;
		}
	}

	/**
	 * A null-safe visitation of the specified visitable.
	 *
	 * @param v a visitable, or <code>null</code>
	 * @return <code>null</code> if the visitable is <code>null</code>;
	 *	 otherwise, the result of visiting it
	 */
	public @Nullable R safeVisit(org.eclipse.ocl.examples.codegen.cgmodel.@Nullable CGElement v) {
		return (v == null) ? null : v.accept(this);
	}

	/**
	 * Perform a visit to the specified visitable.
	 *
	 * @param v a visitable, or <code>null</code>
	 * @return <code>null</code> if the visitable is <code>null</code>;
	 *	 otherwise, the result of visiting it
	 */
	public R visit(org.eclipse.ocl.examples.codegen.cgmodel.@NonNull CGElement v) {
		return v.accept(this);
	}

	//	public R visiting(org.eclipse.ocl.examples.codegen.cgmodel.@NonNull CGElement visitable) {
	//		return null;
	//	}
}
