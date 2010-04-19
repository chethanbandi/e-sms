package com.esms.esim.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Esim implements EntryPoint {
	interface EsimLayoutUiBinder extends UiBinder<Widget, Esim> {}
	
	private static final EsimLayoutUiBinder uiBinder = GWT.create(EsimLayoutUiBinder.class);
	
	@UiField ScrollPanel content;
	@UiField ScrollPanel menu;

	public void onModuleLoad(){
		RootLayoutPanel.get().add(uiBinder.createAndBindUi(this));
		
		// Add menu to the DockLayoutPanel
		menu.add(new Menu(content));
		
		content.clear();
		// TODO: add a static page which displays some text.
		content.add(new Welcome());
	}
}