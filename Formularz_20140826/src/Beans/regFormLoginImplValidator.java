package Beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

public class regFormLoginImplValidator implements javax.faces.validator.Validator{

	@Override
	public void validate(FacesContext context, UIComponent arg1, Object object) throws ValidatorException {
		String str = (String)object;
		int limit = 10;
		FacesMessage fm = new FacesMessage();
		
		if(str.length()>limit){
			fm.setDetail("Maksymalna d³ugoœæ frazy to " + limit + " znaków.");
			context.addMessage("regForm:login", fm);
			throw new ValidatorException(fm);
		}else{
			fm.setDetail("OK");
			context.addMessage("regForm:login", fm);			
			throw new ValidatorException(fm);
		}
		
	}

}
