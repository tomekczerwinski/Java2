package com.example.jsfdemo.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("uniqueGameIdValidator")
public class PinValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		String id = (String) value;
		
		if (id.length() != 5) {
			FacesMessage message = new FacesMessage();
			message.setDetail("ID musi składać się z 5 cyfr");
			message.setSummary("ID musi składać się z 5 cyfr");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
}
