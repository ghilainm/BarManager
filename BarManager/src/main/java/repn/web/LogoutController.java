package repn.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	@RequestMapping(value = "/logout*")
	public String LogoutHandler(){
		return "logout";
	}

}
