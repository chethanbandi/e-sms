package com.esms.esim.client;

import com.esms.utils.client.ui.VTextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;

public class CollegeInfoForm extends Composite {
	private static CollegeInfoFormUiBinder uiBinder = GWT.create(CollegeInfoFormUiBinder.class);

	interface CollegeInfoFormUiBinder extends UiBinder<Widget, CollegeInfoForm> {
	}
	
	@UiField FormPanel form;
	@UiField VTextBox name;
	@UiField VTextBox shortName;
	@UiField VTextBox address1;
	@UiField VTextBox address2;
	@UiField VTextBox city;
	@UiField VTextBox state;
	@UiField VTextBox country;
	@UiField VTextBox email;
	@UiField VTextBox phone1;
	@UiField VTextBox phone2;
	@UiField SubmitButton button;
	
	public CollegeInfoForm() {
		initWidget(uiBinder.createAndBindUi(this));
		form.setAction(Config.FORM_URL);
		form.setMethod(FormPanel.METHOD_POST);
		
		name.setMaxLength(6);
		name.setMinLength(3);
		
		form.addSubmitHandler(new FormPanel.SubmitHandler() {
			public void onSubmit(SubmitEvent event) {
				//TODO: Perform custom validations
			}
		});
		
		form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
			public void onSubmitComplete(SubmitCompleteEvent event) {
				//TODO: On submission of the form the results are handled here
				Window.alert(event.getResults());
			}
		});
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		form.submit();
	}
}
