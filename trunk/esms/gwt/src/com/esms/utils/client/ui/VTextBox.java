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
	}
	
	@Override
	public void onFocus(FocusEvent e) {
		//TODO: use it for water-mark
	}
	
	@Override
	public void onChange(ChangeEvent event) {
		// TODO Auto-generated method stub
		if( !isValid() ) {
			this.setText("Invalid values");
			//this.addStyleName("background-color:pink; border: 1px solid red;");
		}		
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
			int length = this.getText().length();
			if(length < this.minLength ) {
				return false;
			}
		}
		return true;
	}
}
