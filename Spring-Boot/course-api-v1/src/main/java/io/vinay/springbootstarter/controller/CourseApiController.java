/**
 * 
 */
package io.vinay.springbootstarter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author VINAY
 *
 */
@RestController
public class CourseApiController {
	
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hello";
	}

}
