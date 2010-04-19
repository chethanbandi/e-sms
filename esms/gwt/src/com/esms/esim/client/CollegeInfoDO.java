package com.esms.esim.client;

import com.google.gwt.core.client.JavaScriptObject;

public class CollegeInfoDO extends JavaScriptObject {
	protected CollegeInfoDO(){}
	
	public final native String getMessage() /*-{ this.message; }-*/;
	
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
