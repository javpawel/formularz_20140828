package Beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

public class regFormAgreeImplValidator implements javax.faces.validator.Validator {

	@Override
	public void validate(FacesContext context, UIComponent arg1, Object object) throws ValidatorException {
		FacesMessage fm = new FacesMessage();
		
		Boolean b = (Boolean)object;
		if(b.booleanValue() == true){
			fm.setDetail("");
			context.addMessage("regForm:agree", fm);
		}else{
			fm.setDetail("Wymagana jest akceptacja regulaminu");
			context.addMessage("regForm:agree", fm);
		}
		
	}



}
