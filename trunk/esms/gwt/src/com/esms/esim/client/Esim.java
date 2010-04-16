package com.esms.esim.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Esim implements EntryPoint {
	interface EsimLayoutUiBinder extends UiBinder<Widget, Esim> {}
	
	private static final EsimLayoutUiBinder uiBinder = GWT.create(EsimLayoutUiBinder.class);
	
	private static final String JSON_URL = "http://127.0.0.1:8080/mysite.fcgi/sim/";
	//private static final String JSON_URL = GWT.getModuleBaseURL() + "mysite.fcgi/sim/";
	
	@UiField ScrollPanel content;
	@UiField Label errorMsgLabel;
	
	public void onModuleLoad(){
		RootLayoutPanel.get().add(uiBinder.createAndBindUi(this));
		
		NewStudentEntryForm newForm = new NewStudentEntryForm();
		CollegeInfoForm college = new CollegeInfoForm();
		content.clear();
		content.add(college);
		
		errorMsgLabel.setVisible(true);
		//printCollegeInfo();
	}
	
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
	
	private final native JsArray<CollegeInfo> asArrayOfCollegeInfo(String json) /*-{
		return eval(json);
	}-*/;
	
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
		errorMsgLabel.setText("Error: " + error);
		errorMsgLabel.setVisible(true);
	}

}
