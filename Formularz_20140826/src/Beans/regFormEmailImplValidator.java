package Beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

public class regFormEmailImplValidator implements javax.faces.validator.Validator{

	@Override
	public void validate(FacesContext context, UIComponent arg1, Object object) throws ValidatorException {
		String str = (String)object;
		int minLenght = 5;
		FacesMessage fm = new FacesMessage();
		
		if(str.length() >= minLenght){
			
			String[] arr = str.split("@");
			if(arr.length == 2){
				
				String[] s = arr[1].split("\\.");
				if(s.length>=2){
					fm.setDetail("OK");
					context.addMessage("form:email", fm);
					throw new ValidatorException(fm);
				}else{
					fm.setDetail("Niepoprawny adres email. Brak poprawnej domeny. ");
					context.addMessage("regForm:email", fm);
					throw new ValidatorException(fm);
				}
				
			}else{
				fm.setDetail("Braku b¹dŸ wiêcej niz 1 znak @.");
				context.addMessage("regForm:email", fm);
				throw new ValidatorException(fm);
			}
			
		}else{
			fm.setDetail("Za krótki adres email.");
			context.addMessage("regForm:email", fm);
			throw new ValidatorException(fm);
		}
		
	}

}
