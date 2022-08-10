package com.spring.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class registerController {
	@RequestMapping("/register/add")
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}
	
	@RequestMapping("/register/save")
	public String save() {
		return "registerInfo";
	}
}
