package com.example.jsp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JSPController {
	
	//model only
	@GetMapping("/testModelAndView")
	public String testModelAndView(Model model) { 
		Map<String, String> map = new HashMap<String, String>();
	    map.put("spring", "mvc");

		model.addAttribute("value", "arpit");
		model.mergeAttributes(map);
		return "hello";
	}
	
	//ModelAndView only
	@GetMapping("/helloView")
	public ModelAndView helloView(ModelAndView modelAndView) {
		modelAndView.setViewName("hello");
		return modelAndView;
	}
	
	//ModelAndMap only
	@GetMapping("/modelMap")
	public String modelAndMap(ModelMap modelMap) {
		modelMap.addAttribute("welcomeMessage", "welcome");
		modelMap.addAttribute("message", "Baeldung");
		return "hello";
	}
}
