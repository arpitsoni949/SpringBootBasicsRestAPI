package com.example.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "hello arpit";
	}
	
	@GetMapping("/hello-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello bean");
	}
	
	@GetMapping("/hello-bean/pathVar/{name}")
	public HelloWorldBean helloWorldBeanWithPathVar(@PathVariable String name) {
		return new HelloWorldBean("Hello bean, "+name);
	}
	
	@GetMapping("/hello-internationalization")
	public String helloWorldInternationalization(@RequestHeader(name="Accept-Language",required=false)Locale locale) {
		return messageSource.getMessage("good.morning.message", null,"default", locale);
	}
	
}
