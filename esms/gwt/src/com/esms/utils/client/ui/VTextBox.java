package com.esms.utils.client.ui;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.TextBox;

public class VTextBox extends TextBox implements FocusHandler, ChangeHandler {
	
	private boolean checkMinLength = false;
		
	private int minLength;
	private String waterMark;
	
	public VTextBox() {
		this.addFocusHandler(this);
		this.addChangeHandler(this);
		//this.addStyleName("yellowBox");
	}
	
	@Override
	public void onFocus(FocusEvent e) {
		//TODO: use it for water-mark
	}
	
	@Override
	public void onChange(ChangeEvent event) {
		if( !isValid() ) {
			//this.removeStyleName("yellowBox");
			this.addStyleName("redBox");
			return;
		}
		this.removeStyleName("redBox");
		//this.addStyleName("yellowBox");
	}
	
	public void setWaterMark(String _waterMark) {
		this.waterMark = _waterMark;
		this.setText(waterMark);
	}
	
	public void setMinLength(int _length) {
		this.minLength = _length;
		checkMinLength = true;
	}
	
	private boolean isValid() {
		if(checkMinLength) {
			if(this.getText().length() < this.minLength ) {
				return false;
			}
		}
		return true;
	}
}
