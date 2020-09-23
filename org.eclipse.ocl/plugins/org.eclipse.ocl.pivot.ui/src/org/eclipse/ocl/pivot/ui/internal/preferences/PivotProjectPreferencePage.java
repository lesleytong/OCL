/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.ui.internal.preferences;

import java.util.List;

import org.eclipse.ocl.common.ui.internal.preferences.AbstractProjectPreferencePage;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.options.PivotConsoleOptions;
import org.eclipse.ocl.pivot.options.PivotValidationOptions;
import org.eclipse.ocl.pivot.ui.messages.PivotUIMessages;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * The Project/Property preference page for the UML Bindings.
 */
public class PivotProjectPreferencePage extends AbstractProjectPreferencePage
{
	protected static final String[][] SEVERITY_MODES = new String[][] {
		{ PivotUIMessages.Pivot_Severity_Ignore, StatusCodes.Severity.IGNORE.toString() },
		{ PivotUIMessages.Pivot_Severity_Info, StatusCodes.Severity.INFO.toString() },
		{ PivotUIMessages.Pivot_Severity_Warning, StatusCodes.Severity.WARNING.toString() },
		{ PivotUIMessages.Pivot_Severity_Error, StatusCodes.Severity.ERROR.toString() }
	};

	public PivotProjectPreferencePage() {
		super(PivotPlugin.PLUGIN_ID, PivotUIMessages.Pivot_PageTitle);
	}

	@Override
	protected AbstractProjectPreferencePage createClonePage() {
		return new PivotProjectPreferencePage();
	}

	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	@Override
	protected void createFieldEditors(Composite fieldEditorParent, List<IFieldEditor> fields) {
		Label horizontalLine= new Label(fieldEditorParent, SWT.SEPARATOR | SWT.HORIZONTAL);
		horizontalLine.setLayoutData(new GridData(GridData.FILL, GridData.FILL, false, false, 2, 1));
		horizontalLine.setFont(fieldEditorParent.getFont());
		fields.add(new MyComboFieldEditor(PivotValidationOptions.EcoreValidation,
				PivotUIMessages.Pivot_EcoreValidation, SEVERITY_MODES, fieldEditorParent));
		fields.add(new MyComboFieldEditor(PivotValidationOptions.MissingSafeNavigation,
				PivotUIMessages.Pivot_MissingSafeNavigation, SEVERITY_MODES, fieldEditorParent));
		fields.add(new MyComboFieldEditor(PivotValidationOptions.RedundantSafeNavigation,
				PivotUIMessages.Pivot_RedundantSafeNavigation, SEVERITY_MODES, fieldEditorParent));
		horizontalLine = new Label(fieldEditorParent, SWT.SEPARATOR | SWT.HORIZONTAL);
		horizontalLine.setLayoutData(new GridData(GridData.FILL, GridData.FILL, false, false, 2, 1));
		horizontalLine.setFont(fieldEditorParent.getFont());
		fields.add(new MyComboFieldEditor(PivotConsoleOptions.ConsoleModeltypesInformation,
				PivotUIMessages.Pivot_ModelTypeSelection, BOOLEANS, fieldEditorParent));
	}
}