/**
 * 
 */
package com.vinay.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author VINAY
 *
 */
@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return messageSource.getMessage("good.morning.message", null,LocaleContextHolder.getLocale());
	}

	@GetMapping("/hellow-world-bean")
	public HelloWorld helloWorldBean() {
		return new HelloWorld("Hello World");
	}
}
