package com.hilti_application.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hilti_application.jee.UserValidationService;

@Controller
public class LoginController {
	
	@Autowired
	UserValidationService loginService;
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String showLoginPage() {
		return "Login";
	}
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name,@RequestParam String password, ModelMap model) {
		
		if (!loginService.isUserValid(name, password)) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}
}