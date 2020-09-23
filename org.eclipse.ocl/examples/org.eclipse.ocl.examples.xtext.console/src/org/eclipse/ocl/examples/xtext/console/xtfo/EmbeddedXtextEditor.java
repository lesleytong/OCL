/*******************************************************************************
 * Copyright (c) 2010, 2019 ProxiAD and Others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *    itemis AG - source viewer configuration
 *    Sebastian Zarnekow (itemis AG) - synthetic resource creation and source viewer configuration
 *    Cedric Vidal (ProxiAD) - integration with global scope
 *    E.D.Willink - integration of XTFO code uder CQ 4866
 *    L.Goubert (Obeo) - generalize to XtextResource
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.console.xtfo;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.expressions.Expression;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.AnnotationPainter;
import org.eclipse.jface.text.source.AnnotationRulerColumn;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.IAnnotationAccess;
import org.eclipse.jface.text.source.IAnnotationAccessExtension;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.IVerticalRulerColumn;
import org.eclipse.jface.text.source.OverviewRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ocl.pivot.internal.resource.EnvironmentFactoryAdapter;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.ActiveShellExpression;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.IUpdate;
import org.eclipse.ui.texteditor.MarkerAnnotationPreferences;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.bracketmatching.BracketMatchingPreferencesInitializer;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.name.Named;

public class EmbeddedXtextEditor
{
	private static final String XTEXT_UI_FORMAT_ACTION = "org.eclipse.xtext.ui.FormatAction"; //$NON-NLS-1$
	private static final String XTEXT_UI_TOGGLE_SL_COMMENT_ACTION = "org.eclipse.xtext.ui.ToggleCommentAction"; //$NON-NLS-1$

	private Composite fControl;
	private int fStyle;

	private XtextSourceViewer fSourceViewer;
	private XtextResource fResource;
	private XtextDocument fDocument;

	@Inject
	@Named(Constants.FILE_EXTENSIONS)
	private String fFileExtension;

	private XtextSourceViewerConfiguration fViewerConfiguration;

	@Inject
	private HighlightingHelper fHighlightingHelper;

	@Inject
	private IResourceSetProvider fResourceSetProvider;

	@Inject
	private IGrammarAccess fGrammarAccess;

	@Inject
	private XtextSourceViewer.Factory fSourceViewerFactory;

	@Inject
	private Provider<XtextSourceViewerConfiguration> fSourceViewerConfigurationProvider;

	@Inject
	private Provider<XtextDocument> fDocumentProvider;

	@Inject
	private Provider<XtextResource> fXtextResourceProvider;
	@Inject
	private IResourceValidator fResourceValidator;

	@Inject
	private IPreferenceStoreAccess fPreferenceStoreAccess;

	@Inject
	private ICharacterPairMatcher characterPairMatcher;

	@Inject(optional = true)
	private AnnotationPainter.IDrawingStrategy projectionAnnotationDrawingStrategy;

//	private EmbeddedFoldingStructureProvider fFoldingStructureProvider;

	private IOverviewRuler fOverviewRuler;

	private IAnnotationAccess fAnnotationAccess;

	/**
	 * The ResourceSet containing the current selected EObject, null for no selection.
	 */
	private @Nullable ResourceSet contextResourceSet = null;

	/**
	 * The OCL facade/handle for the current contextResourceSet.
	 */
	private @NonNull OCLInternal ocl;

	/**
	 * Creates a new EmbeddedXtextEditor. It must have the SWT.V_SCROLL style at least not to
	 * throw NPE when computing overview ruler.
	 *
	 * @param control the parent composite that will contain the editor
	 * @param injector the Guice injector to get Xtext configuration elements
	 * @param style the SWT style of the {@link SourceViewer} of this editor.
	 */
	public EmbeddedXtextEditor(Composite control, Injector injector, int style) {
		fControl = control;
		fStyle = style;
		fAnnotationPreferences = new MarkerAnnotationPreferences();

		injector.injectMembers(this);
		ocl = OCLInternal.newInstance();
		ResourceSet xtextResourceSet = getResourceSet();
		if (xtextResourceSet != null) {
			ocl.getEnvironmentFactory().adapt(xtextResourceSet);
		}
		createEditor(fControl);
	}

	/**
	 * Creates a new EmbeddedXtextEditor.
	 *
	 * Equivalent to EmbeddedXtextEditor(control, injector, job, fileExtension, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
	 *
	 * @param control the parent composite that will contain the editor
	 * @param injector the Guice injector to get Xtext configuration elements
	 */
	public EmbeddedXtextEditor(Composite control, Injector injector) {
		this(control, injector, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
	}

	public Composite getControl() {
		return fControl;
	}

	public XtextSourceViewer getViewer() {
		return fSourceViewer;
	}

	public XtextResource getResource() {
		return fResource;
	}

	public IXtextDocument getDocument() {
		return fDocument;
	}

	/**
	 * Should be called only once, during initialization.
	 *
	 * Then, you should call {@link #update(String)};
	 */
	protected void setText(XtextDocument document, String text) {
		document.set(text);
		fResource = createResource(text);
		document.setInput(fResource);
		AnnotationModel annotationModel = new AnnotationModel();
		if (document instanceof ISynchronizable) {
			Object lock= ((ISynchronizable)document).getLockObject();
			if (lock == null) {
				lock= new Object();
				((ISynchronizable)document).setLockObject(lock);
			}
			((ISynchronizable) annotationModel).setLockObject(lock);
		}
		fSourceViewer.setDocument(document, annotationModel);
	}

	private XtextResource createResource(String content) {
		XtextResource result = createResource();
		try {
			result.load(new StringInputStream(content, result.getEncoding()), Collections.emptyMap());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	private void createEditor(Composite parent) {
		createViewer(parent);

		Control control = fSourceViewer.getControl();
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		control.setLayoutData(data);

		createActions();

		MenuManager manager = new MenuManager(null, null);
		manager.setRemoveAllWhenShown(true);
		manager.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager mgr) {
				EmbeddedXtextEditor.this.menuAboutToShow(mgr);
			}
		});

		StyledText text = fSourceViewer.getTextWidget();
		Menu menu = manager.createContextMenu(text);
		text.setMenu(menu);
	}

	private void menuAboutToShow(IMenuManager menu) {
		menu.add(new Separator(ITextEditorActionConstants.GROUP_EDIT));
		menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, fActions.get(ITextEditorActionConstants.CUT));
		menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, fActions.get(ITextEditorActionConstants.COPY));
		menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, fActions.get(ITextEditorActionConstants.PASTE));

		menu.add(new Separator(ICommonMenuConstants.GROUP_GENERATE));
		menu.appendToGroup(ICommonMenuConstants.GROUP_GENERATE, fActions.get(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS));
	}

	private void createViewer(Composite parent) {
		createSourceViewer(parent);
		installFoldingSupport(fSourceViewer);
		setText(fDocument, ""); //$NON-NLS-1$
		fHighlightingHelper.install(fViewerConfiguration, fSourceViewer);
	}

	/**
	 * Creates the vertical ruler to be used by this editor.
	 * Subclasses may re-implement this method.
	 *
	 * @return the vertical ruler
	 */
	private IVerticalRuler createVerticalRuler() {
		return new CompositeRuler();
	}

	/** The editor's vertical ruler. */
	private IVerticalRuler fVerticalRuler;

	/**
	 * Creates the annotation ruler column. Subclasses may re-implement or extend.
	 *
	 * @param ruler the composite ruler that the column will be added
	 * @return an annotation ruler column
	 */
	protected IVerticalRulerColumn createAnnotationRulerColumn(CompositeRuler ruler) {
		return new AnnotationRulerColumn(VERTICAL_RULER_WIDTH, getAnnotationAccess());
	}


	private void createSourceViewer(Composite parent) {
		fVerticalRuler = createVerticalRuler();
		fSourceViewer = fSourceViewerFactory.createSourceViewer(parent, fVerticalRuler, getOverviewRuler(), true, fStyle);
		fViewerConfiguration = fSourceViewerConfigurationProvider.get();
		fSourceViewer.configure(fViewerConfiguration);

		/*fProjectionSupport =*/ installProjectionSupport(fSourceViewer);

		// make sure the source viewer decoration support is initialized
		getSourceViewerDecorationSupport(fSourceViewer);

		fSourceViewer.getTextWidget().addFocusListener(new SourceViewerFocusListener());

		fSourceViewerDecorationSupport.install(fPreferenceStoreAccess.getPreferenceStore());
		parent.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				fSourceViewerDecorationSupport.dispose();
			}
		});
		fDocument = fDocumentProvider.get();

		IDocumentPartitioner partitioner = documentPartitioner.get();
		partitioner.connect(fDocument);
		fDocument.setDocumentPartitioner(partitioner);


		ValidationJob job = new ValidationJob(fResourceValidator, fDocument,
				new IValidationIssueProcessor() {
					private AnnotationIssueProcessor annotationIssueProcessor;

					@Override
					public void processIssues(List<Issue> issues, IProgressMonitor monitor) {
						if (annotationIssueProcessor == null) {
							annotationIssueProcessor = new AnnotationIssueProcessor(fDocument,
									fSourceViewer.getAnnotationModel(),
									new IssueResolutionProvider.NullImpl());
						}
						if (annotationIssueProcessor != null)
							annotationIssueProcessor.processIssues(issues, monitor);
					}
				}, CheckMode.FAST_ONLY);
		fDocument.setValidationJob(job);

		fSourceViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateSelectionDependentActions();
			}
		});
	}

//	private ProjectionSupport fProjectionSupport;
	@Inject
	private Provider<IDocumentPartitioner> documentPartitioner;

	private static final String ERROR_ANNOTATION_TYPE = "org.eclipse.xtext.ui.editor.error"; //$NON-NLS-1$
	private static final String WARNING_ANNOTATION_TYPE = "org.eclipse.xtext.ui.editor.warning"; //$NON-NLS-1$

	private ProjectionSupport installProjectionSupport(ProjectionViewer projectionViewer) {
		ProjectionSupport projectionSupport = new ProjectionSupport(projectionViewer, getAnnotationAccess(),
				getSharedColors());
		projectionSupport.addSummarizableAnnotationType(WARNING_ANNOTATION_TYPE);
		projectionSupport.addSummarizableAnnotationType(ERROR_ANNOTATION_TYPE);
		projectionSupport.setAnnotationPainterDrawingStrategy(projectionAnnotationDrawingStrategy);
		projectionSupport.install();
		return projectionSupport;
	}

	/**
	 * Helper for managing the decoration support of this editor's viewer.
	 *
	 * <p>This field should not be referenced by subclasses. It is <code>protected</code> for API
	 * compatibility reasons and will be made <code>private</code> soon. Use
	 * {@link #getSourceViewerDecorationSupport(ISourceViewer)} instead.</p>
	 */
	private SourceViewerDecorationSupport fSourceViewerDecorationSupport;

	private void installFoldingSupport(ProjectionViewer projectionViewer) {
//		fFoldingStructureProvider.install(this, projectionViewer);
//		projectionViewer.doOperation(ProjectionViewer.TOGGLE);
//		fFoldingStructureProvider.initialize();
	}

	/**
	 * Returns the source viewer decoration support.
	 *
	 * @param viewer the viewer for which to return a decoration support
	 * @return the source viewer decoration support
	 */
	private SourceViewerDecorationSupport getSourceViewerDecorationSupport(ISourceViewer viewer) {
		if (fSourceViewerDecorationSupport == null) {
			fSourceViewerDecorationSupport= new SourceViewerDecorationSupport(viewer, getOverviewRuler(), getAnnotationAccess(), getSharedColors());
			configureSourceViewerDecorationSupport(fSourceViewerDecorationSupport);
		}
		return fSourceViewerDecorationSupport;
	}

	/**
	 * Configures the decoration support for this editor's source viewer. Subclasses may override this
	 * method, but should call their superclass' implementation at some point.
	 *
	 * @param support the decoration support to configure
	 */
	private void configureSourceViewerDecorationSupport(SourceViewerDecorationSupport support) {

		Iterator<AnnotationPreference> e = Iterators.filter(fAnnotationPreferences.getAnnotationPreferences().iterator(), AnnotationPreference.class);
		while (e.hasNext())
			support.setAnnotationPreference(e.next());

		support.setCursorLinePainterPreferenceKeys(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_CURRENT_LINE, AbstractDecoratedTextEditorPreferenceConstants.EDITOR_CURRENT_LINE_COLOR);
		support.setMarginPainterPreferenceKeys(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN, AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN_COLOR, AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN_COLUMN);
//		support.setSymbolicFontName(getFontPropertyPreferenceKey());

		if (characterPairMatcher != null) {
			support.setCharacterPairMatcher(characterPairMatcher);
			support.setMatchingCharacterPainterPreferenceKeys(BracketMatchingPreferencesInitializer.IS_ACTIVE_KEY,
					BracketMatchingPreferencesInitializer.COLOR_KEY);
		}
	}

	/**
	 * Returns the overview ruler.
	 *
	 * @return the overview ruler
	 */
	private IOverviewRuler getOverviewRuler() {
		if (fOverviewRuler == null && (fStyle & SWT.V_SCROLL) != 0)
			fOverviewRuler= createOverviewRuler(getSharedColors());
		return fOverviewRuler;
	}

	/** The width of the vertical ruler. */
	private static final int VERTICAL_RULER_WIDTH= 12;

	/**
	 * Returns the annotation access.
	 *
	 * @return the annotation access
	 */
	private IAnnotationAccess getAnnotationAccess() {
		if (fAnnotationAccess == null)
			fAnnotationAccess= createAnnotationAccess();
		return fAnnotationAccess;
	}

	/**
	 * Creates the annotation access for this editor.
	 *
	 * @return the created annotation access
	 */
	private IAnnotationAccess createAnnotationAccess() {
		return new DefaultMarkerAnnotationAccess() {
			@Override
			public int getLayer(Annotation annotation) {
				if (annotation.isMarkedDeleted()) {
					return IAnnotationAccessExtension.DEFAULT_LAYER;
				}
				return super.getLayer(annotation);
			}
		};
	}

	/**
	 * The annotation preferences.
	 */
	private MarkerAnnotationPreferences fAnnotationPreferences;

	private IOverviewRuler createOverviewRuler(ISharedTextColors sharedColors) {
		IOverviewRuler ruler= new OverviewRuler(getAnnotationAccess(), VERTICAL_RULER_WIDTH, sharedColors);

		Iterator<?> e = fAnnotationPreferences.getAnnotationPreferences().iterator();
		while (e.hasNext()) {
			AnnotationPreference preference = (AnnotationPreference) e.next();
			if ((preference != null) && preference.contributesToHeader())
				ruler.addHeaderAnnotationType(preference.getAnnotationType());
		}
		return ruler;
	}

	private ISharedTextColors getSharedColors() {
		return EditorsUI.getSharedTextColors();
	}

	/**
	 * Updates the text of this editor with the given String
	 *
	 * @param text
	 */
	public void update(String text) {
		IDocument document = fSourceViewer.getDocument();

		fSourceViewer.setRedraw(false);
		document.set(text);
		fSourceViewer.setVisibleRegion(0, text.length());
		fSourceViewer.setRedraw(true);
	}

	private void createActions() {
		{
			TextViewerAction action= new TextViewerAction(fSourceViewer, ITextOperationTarget.CUT);
			action.setText("Cut"); //$NON-NLS-1$
			setAction(ITextEditorActionConstants.CUT, action);
			setAsSelectionDependantAction(action);
		}

		{
			TextViewerAction action= new TextViewerAction(fSourceViewer, ITextOperationTarget.COPY);
			action.setText("Copy"); //$NON-NLS-1$
			setAction(ITextEditorActionConstants.COPY, action);
			setAsSelectionDependantAction(action);
		}

		{
			TextViewerAction action= new TextViewerAction(fSourceViewer, ITextOperationTarget.PASTE);
			action.setText("Paste"); //$NON-NLS-1$
			setAction(ITextEditorActionConstants.PASTE, action);
			setAsSelectionDependantAction(action);
		}

		{
			TextViewerAction action = new TextViewerAction(fSourceViewer, ISourceViewer.CONTENTASSIST_PROPOSALS);
			action.setText("Content Assist"); //$NON-NLS-1$
			setAction(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS, action);
			setAsContextDependantAction(action);
		}

		if (fViewerConfiguration.getContentFormatter(fSourceViewer) != null) {
			TextViewerAction action = new TextViewerAction(fSourceViewer, ISourceViewer.FORMAT);
			action.setText("Format"); //$NON-NLS-1$
			setAction(XTEXT_UI_FORMAT_ACTION, action);
			setAsContextDependantAction(action);
		}

		{
			ToggleSLCommentAction action = new ToggleSLCommentAction(fSourceViewer);
			setAction(XTEXT_UI_TOGGLE_SL_COMMENT_ACTION, action);
			setAsContextDependantAction(action);
			action.configure(fSourceViewer, fViewerConfiguration);
		}
	}

	private void setAction(String actionID, IAction action) {
		if (action.getId() == null)
			action.setId(actionID); // make sure the action ID has been set

		fActions.put(actionID, action);
	}

	private void setAsContextDependantAction(IAction action) {
		fActionHandlers.add(new ActionHandler(action));
	}

	private void setAsSelectionDependantAction(IAction action) {
		fSelectionDependentActions.add(action);
	}

	private void updateSelectionDependentActions() {
		for(IAction action : fSelectionDependentActions) {
			if (action instanceof IUpdate) {
				((IUpdate) action).update();
			}
		}
	}

	protected void updateAction(IAction action) {

	}

	private Map<String, IAction> fActions = Maps.newHashMap();
	private List<IAction> fSelectionDependentActions = Lists.newArrayList();
	private List<ActionHandler> fActionHandlers = Lists.newArrayList();

	/**
	 * Source viewer focus listener that activates/deactivates action handlers on focus state change.
	 *
	 * @author Mikaël Barbero
	 *
	 */
	private final class SourceViewerFocusListener implements FocusListener {
		private static final String EMBEDEDXTEXT_EDITOR_CONTEXT = "org.eclipse.ocl.examples.xtext.console.xtext.embededxtextEditor.context"; //$NON-NLS-1$

		private final Expression fExpression;
		private final List<IHandlerActivation> fHandlerActivations;
		private IContextActivation fContextActivation;

		public SourceViewerFocusListener() {
			fExpression = new ActiveShellExpression(fSourceViewer.getControl().getShell());
			fHandlerActivations = Lists.newArrayList();

			fSourceViewer.getControl().addDisposeListener(new DisposeListener() {
				@Override
				public void widgetDisposed(DisposeEvent e) {
					IHandlerService handlerService = ClassUtil.getAdapter(PlatformUI.getWorkbench(), IHandlerService.class);
					if (handlerService != null) {
						handlerService.deactivateHandlers(fHandlerActivations);
					}
					fHandlerActivations.clear();
				}
			});
		}

		@Override
		public void focusLost(FocusEvent e) {
			if (fContextActivation != null) {
				IWorkbench workbench = PlatformUI.getWorkbench();
				IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
				if (activeWorkbenchWindow != null) {
					IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
					IEditorPart activeEditor = activePage.getActiveEditor();
					if (activeEditor != null) {
						IWorkbenchPartSite site = activeEditor.getSite();
						Object contextServiceAsObject = site.getService(IContextService.class);    // Needed for org.eclipse.ui.workbench < 3.107.0
						IContextService contextService = (IContextService)contextServiceAsObject;
						assert contextService != null;
						contextService.deactivateContext(fContextActivation);
					}
				}
			}
			@Nullable IHandlerService handlerService = ClassUtil.getAdapter(PlatformUI.getWorkbench(), IHandlerService.class);
			if (handlerService != null) {
				handlerService.deactivateHandlers(fHandlerActivations);
			}
		}

		@Override
		public void focusGained(FocusEvent e) {
			IWorkbench workbench = PlatformUI.getWorkbench();
			IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
			if (activeWorkbenchWindow != null) {
				IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
				IEditorPart activeEditor = activePage.getActiveEditor();
				if (activeEditor != null) {
					IWorkbenchPartSite site = activeEditor.getSite();
					Object contextServiceAsObject = site.getService(IContextService.class);    // Needed for org.eclipse.ui.workbench < 3.107.0
					IContextService contextService = (IContextService)contextServiceAsObject;
					assert contextService != null;
					fContextActivation = contextService.activateContext(EMBEDEDXTEXT_EDITOR_CONTEXT);
				}
				else {
					fContextActivation = null;
				}
			}
			IHandlerService handlerService = ClassUtil.getAdapter(workbench, IHandlerService.class);
			if (handlerService != null) {
				for (ActionHandler actionHandler : fActionHandlers) {
					fHandlerActivations.add(handlerService.activateHandler(actionHandler.getAction().getId(), actionHandler, fExpression));
				}
			}
		}
	}

	protected XtextResource createResource() {
		String dummyFileName = fGrammarAccess.getGrammar().getName() + "." + fFileExtension; //$NON-NLS-1$
		URI dummyURI = URI.createURI(dummyFileName);
		ResourceSet xtextResourceSet = getResourceSet();
//		XtextResource result = (XtextResource) resourceSet.createResource(
//				URI.createURI(fGrammarAccess.getGrammar().getName() + "." + fFileExtension));
		XtextResource result = fXtextResourceProvider.get();
		result.setURI(dummyURI);
		xtextResourceSet.getResources().add(result);
		return result;
	}

	public void dispose() {
		OCL ocl2 = ocl;
//		if (ocl2 != null) {
//			ocl = null;
			ocl2.dispose();
//		}
	}

	public ResourceSet getResourceSet() {
		return fResourceSetProvider.get(null);
	}

	public @NonNull OCL getOCL() {
		return ocl;
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return ocl.getEnvironmentFactory();
	}

	/**
	 * Reconfigure this editor to support editing with respect to any OCL provided by esResourceSet.
	 * The value of esResourceSet is cached so that repeated calls have no effect.
	 * If esResourceSet changes to null, a new OCL is created.
	 */
	public synchronized void setContext(@Nullable ResourceSet esResourceSet) {
		if (esResourceSet != this.contextResourceSet) {
			ProjectManager projectManager = ocl.getProjectManager();
			ResourceSet xtextResourceSet = getResourceSet();
			//
			//	Eliminate old OCL facade/handle
			//
			if (xtextResourceSet != null) {
				EnvironmentFactoryAdapter environmentFactoryAdapter = EnvironmentFactoryAdapter.find(xtextResourceSet);
				if (environmentFactoryAdapter != null) {
					xtextResourceSet.eAdapters().remove(environmentFactoryAdapter);
				}
				for (Resource resource : xtextResourceSet.getResources()) {
					if (resource instanceof BaseCSResource) {
						((BaseCSResource)resource).setParserContext(null);
					}
				}
			}
			ocl.dispose();
			//
			//	Create new OCL facade/handle
			//
			ocl = OCLInternal.newInstance(projectManager, esResourceSet);
			if (xtextResourceSet != null) {
				EnvironmentFactory environmentFactory = ocl.getEnvironmentFactory();
				environmentFactory.adapt(xtextResourceSet);
			}
			contextResourceSet = esResourceSet;
		}
	}
}
