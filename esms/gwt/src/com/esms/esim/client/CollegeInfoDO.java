package com.esms.esim.client;

import com.google.gwt.core.client.JavaScriptObject;

public class CollegeInfoDO extends JavaScriptObject {
	protected CollegeInfoDO(){}
	
	public final native String getMessage() /*-{ this.message; }-*/;
}
