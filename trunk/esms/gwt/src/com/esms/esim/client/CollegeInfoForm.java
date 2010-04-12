package com.esms.esim.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;


public class CollegeInfoForm extends Composite {

	private static CollegeInfoFormUiBinder uiBinder = GWT
			.create(CollegeInfoFormUiBinder.class);

	interface CollegeInfoFormUiBinder extends UiBinder<Widget, CollegeInfoForm> {
	}

	private final String JSON_URL = URL.encode("http://127.0.0.1:8080/mysite.fcgi/sim/");
	
	@UiField TextBox name;
	@UiField TextBox shortName;
	@UiField TextBox address1;
	@UiField TextBox address2;
	@UiField TextBox city;
	@UiField TextBox state;
	@UiField TextBox country;
	@UiField TextBox email;
	@UiField TextBox phone1;
	@UiField TextBox phone2;
	@UiField Button button;

	public CollegeInfoForm() {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText("Submit");
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		createCollege();
	}
	
	private void createCollege(){
		RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, JSON_URL);
		
		try{
			Request request = builder.sendRequest(null, new RequestCallback(){
				public void onError(Request request, Throwable exception){
					displayError("Can not process request at this time");
				}
				
				public void onResponseReceived(Request request, Response response){
					if(200 == response.getStatusCode()){
						processResponse(getJavaJsonObjectArray(response.getText()));
					} else {
						displayError("Error 200, can't process request at this time");
					}
				}
			});
		} catch (RequestException e){
			displayError("Unknow exception");
		}
	}
	
	private void displayError(String error) {
		
	}
	
	private final native JsArray<ServerResponseJson> getJavaJsonObjectArray(String json) /*-{
		return eval(json);
	}-*/;
	
	private void processResponse(JsArray<ServerResponseJson> responseJson) {
		ServerResponseJson response = responseJson.get(0);
		if (response.SUCCESS != response.getCode()) {
			
		}
	}
}
