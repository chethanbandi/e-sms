package com.esms.esim.client;

import com.google.gwt.http.client.URL;

public final class Config {
	public static final String JSON_URL = URL.encode("http://127.0.0.1:8080/mysite.fcgi/sim/");
	public static final String FORM_URL = URL.encode("http://127.0.0.1:8080/mysite.fcgi/sim_form/");
	//public static final String JSON_URL = GWT.getModuleBaseURL() + "mysite.fcgi/sim/"; 
}
