package com.esms.esim.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;

public class Menu extends Composite {

	private static MenuUiBinder uiBinder = GWT.create(MenuUiBinder.class);

	interface MenuUiBinder extends UiBinder<Widget, Menu> {
	}

	@UiField Tree root;
	
	private TreeItem collegeInfo;
	private TreeItem studentInfo;
	private ScrollPanel centerContent;
	private SelectionHandler<TreeItem> selectionHandler;
	
	public Menu(ScrollPanel center) {
		initWidget(uiBinder.createAndBindUi(this));
		this.centerContent = center;
	
		addCollegeInfo();
		addStudentInfo();
		setupEventHandling();
	}
	
	private void addCollegeInfo() {
		collegeInfo = new TreeItem("College Information");
		collegeInfo.setState(true);
		
		collegeInfo.addItem("College Info");
		collegeInfo.addItem("Management Info");
		collegeInfo.addItem("General Info");
		
		root.addItem(collegeInfo);		
	}
	
	private void addStudentInfo() {
		studentInfo = new TreeItem("Student Information");
		studentInfo.addItem("new");
		studentInfo.addItem("search");
		
		root.addItem(studentInfo);
	}
	
	private void setupEventHandling() {
		selectionHandler = new SelectionHandler<TreeItem>() {
			
			@Override
			public void onSelection(SelectionEvent<TreeItem> event) {
				String parent = new String(event.getSelectedItem().getParentItem().getText());
				String child = new String(event.getSelectedItem().getText());
				
				handleEvents(parent, child);
			}
		};
		
		root.addSelectionHandler(selectionHandler);		
	}
	
	private void handleEvents(String parent, String child) {
		if (parent.equals("College Information")) {
			if (child.equals("College Info")) {
				CollegeInfoForm college = new CollegeInfoForm();
				centerContent.clear();
				centerContent.add(college);
			} else {
				Label underConstruction = new Label(parent + "/" + child + " - Page is under construction");
				centerContent.clear();
				centerContent.add(underConstruction);				
			}
//		} else if (parent.equals("Student Information")) {
//			
		} else {
			Label underConstruction = new Label(parent + "/" + child + " - Page is under construction");
			centerContent.clear();
			centerContent.add(underConstruction);			
		}
	}
}
