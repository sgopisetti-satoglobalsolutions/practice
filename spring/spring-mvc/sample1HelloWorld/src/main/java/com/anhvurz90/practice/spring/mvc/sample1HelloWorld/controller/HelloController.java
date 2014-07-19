package com.anhvurz90.practice.spring.mvc.sample1HelloWorld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcome")
public class HelloController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String pringWelcome(ModelMap model) {
		model.addAttribute("message", "hello");
		return "hello";
	}

}
