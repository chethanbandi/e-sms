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

	//printCollegeInfo();
	/*	
	private void updateContent(JsArray<CollegeInfo> collegeinfo){
		CollegeInfo college = collegeinfo.get(0);
		
		Label pk = new Label(college.getPk());
		Label model = new Label(college.getModel() + college.getName());
		VerticalPanel jsonData = new VerticalPanel();
		
		jsonData.add(pk);
		jsonData.add(model);
		
		displayError("After adding the objects to the panel");
		content.clear();
		content.add(jsonData);
		displayError("After adding the widget to the center");
	}
*/	
//	private final native JsArray<CollegeInfo> asArrayOfCollegeInfo(String json) /*-{
//		return eval(json);
//	}-*/;
/*	
	private void printCollegeInfo(){
		String url = JSON_URL;
		url = URL.encode(url);
		
		//send request to server and catch any errors
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		
		try{
			Request request = builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {
					displayError("Cound not retrive JSON object");
				}
				
				public void onResponseReceived(Request request, Response response){
					if (200 == response.getStatusCode()){
						displayError(response.getText());
						updateContent(asArrayOfCollegeInfo(response.getText()));
					} else {
						displayError("Cound not retrive JSON (" + response.getStatusText() + ")");
					}
				}
			});
		} catch (RequestException e){
			displayError("Could not retrive JSON object");
		}
	}
	
	private void displayError(String error) {
	}
*/
}
