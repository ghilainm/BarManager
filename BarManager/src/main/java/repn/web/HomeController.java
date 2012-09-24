package repn.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("home")
	public String homeHandler(){
		System.out.println("Passing through home...");
		return "home";
	}
}
