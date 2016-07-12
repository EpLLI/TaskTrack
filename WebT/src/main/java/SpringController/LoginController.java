package SpringController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class LoginController {
	
	@RequestMapping(value = "/menuLogin", method = { RequestMethod.POST,RequestMethod.GET })
	public String execute(ModelMap model) {
	return "NewIndex";
	}
	@RequestMapping(value="/login_error", method = {RequestMethod.POST, RequestMethod.GET})
	public String accessDeniedPage(ModelMap model, HttpServletRequest request) {
		model.addAttribute("error", "ACCESS DENIED. TRY AGAIN.<br> ДОСТУП ЗАКРЫТ. ПОПРОБУЙТЕ ЕЩЕ РАЗ.");
	    Exception exception = (Exception) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
		if(exception != null){
			model.addAttribute("exception", exception.getMessage());
		}
		return "NewIndex";
	}
}
