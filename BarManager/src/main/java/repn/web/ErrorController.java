package repn.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	
	@RequestMapping(value="error404")
	public String handleError404(){
		System.out.println("Passing through error404 controller");
		return "error404";
	}
	
	@RequestMapping(value="error400")
	public String handleError400(HttpServletRequest servlet, Map<String,Object> model){
		System.out.println("Passing through error400 controller");
		return "error400";
	}
}
