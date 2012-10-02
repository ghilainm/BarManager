package repn.web;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import repn.model.User;
import repn.services.UserManager;
import repn.services.exception.UserAlreadyExistException;
import repn.services.impl.PasswordConvertionServiceImpl;
import repn.util.validator.UserValidator;

@Controller
public class NewUserController {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	UserManager userManager;
	
	@Autowired
	PasswordConvertionServiceImpl passwordConvertor;

	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
    }
	
	@RequestMapping(value = "newUserForm", method = RequestMethod.GET)
	public String NewUserHandler(){
		return "userForm";
	}
	
	@RequestMapping(value = "newUserForm", method = RequestMethod.POST)
	public String NewUserHandlerPost(@Valid User user, BindingResult result){
		
		if (result.hasErrors()) {
			logger.debug("User creation failed");
			return "userForm";
		}
		
		//Fill the user creation date.
		user.setCreatedOn(Calendar.getInstance());
		
		//Fill user password.
		try {
			user.setPassword(passwordConvertor.getPasswordSHA(user.getPassword()));
		} catch (UnsupportedEncodingException|NoSuchAlgorithmException e) {
			logger.fatal("Error could not create password hash!", e);
			return "userForm";
		}
		
		user.setActive(true);
		user.setRole("USER");
		
		try {
			userManager.save(user);
		} catch (UserAlreadyExistException e) {
			logger.debug("User creation failed, this user already exists.");
			result.rejectValue("login", "already.exists.user.login", "This login already exists, please choose another one!");
			return "userForm";
		}
		
		return "userCreated";
	}

}
