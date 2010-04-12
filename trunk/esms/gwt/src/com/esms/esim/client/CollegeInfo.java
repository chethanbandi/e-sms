package com.esms.esim.client;

import com.google.gwt.core.client.JavaScriptObject;

public class CollegeInfo extends JavaScriptObject {
	
	protected CollegeInfo(){}

	public final native String getPk() /*-{ return this.pk; }-*/;
	public final native String getModel() /*-{ return this.model; }-*/;
	public final native String getName() /*-{ return this.fields.name; }-*/;
}
