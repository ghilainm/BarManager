package repn.web;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BarManagerController {
	
	@PostConstruct
	public void init() {
	   System.out.println("Bar Manager instanciated");
	}
	
	/**
	 * Default page when no mapping found.
	 * @return
	 */
    @RequestMapping()
    public String barManagerHandler() {
        System.out.println("BarManager: Passing through...");
        return "barManager";
    }
	
	
}
