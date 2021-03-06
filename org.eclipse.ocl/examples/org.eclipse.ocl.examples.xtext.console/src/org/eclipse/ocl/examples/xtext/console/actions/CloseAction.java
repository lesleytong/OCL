/*******************************************************************************
 * Copyright (c) 2010, 2018 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - rework of LPG OCL Console for Xtext
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.console.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ocl.examples.xtext.console.OCLConsole;
import org.eclipse.ocl.examples.xtext.console.messages.ConsoleMessages;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * An action that closes the Interactive OCL console.
 */
public class CloseAction extends Action {
	private final String tip;
	
	/**
	 * Initializes me.
	 */
	public CloseAction() {
		super(
			ConsoleMessages.CloseAction_Label,
			PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
				ISharedImages.IMG_TOOL_DELETE));
		
		tip = ConsoleMessages.CloseAction_Tip;
	}
	
	@Override
    public String getToolTipText() {
		return tip;
	}
	
	@Override
    public void run() {
		OCLConsole.getInstance().close();
	}
}