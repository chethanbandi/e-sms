/**
 * 
 */
package com.esms.esim.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Chethan Bandi
 *
 */
public class NewStudentEntryForm extends Composite {

	private static NewStudentEntryFormUiBinder uiBinder = GWT
			.create(NewStudentEntryFormUiBinder.class);

	interface NewStudentEntryFormUiBinder extends
			UiBinder<Widget, NewStudentEntryForm> {
	}

	@UiField Button button;
	@UiField Label firstNameLabel;
	@UiField TextBox firstName;
	@UiField Label lastNameLabel;
	@UiField TextBox lastName;
	
	public NewStudentEntryForm() {
		initWidget(uiBinder.createAndBindUi(this));

		// Can access @UiField after calling createAndBindUi
		firstNameLabel.setText("First Name");
		lastNameLabel.setText("Last Name abcd");
		firstName.setFocus(true);
		
		button.setText("submit");
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		Window.alert(firstName.getText());
	}

}
