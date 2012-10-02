package repn.util.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import repn.model.User;

public class UserValidator implements Validator{
	
	

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "empty");
		User user = (User) target;
		String password = user.getPassword().trim();
		
		//Password must be at least 8 characters
		if(password.length()<9){
			errors.rejectValue("password", "too.short");
		}
		
		//Password must contain at least a number and a letter
		if(!password.matches(".*\\d+.*") || !password.matches(".*\\D+.*")){
			errors.rejectValue("password", "too.weak");
		}
		 
	}

}