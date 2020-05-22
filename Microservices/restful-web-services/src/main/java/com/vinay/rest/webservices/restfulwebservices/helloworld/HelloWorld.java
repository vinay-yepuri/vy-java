/**
 * 
 */
package com.vinay.rest.webservices.restfulwebservices.helloworld;

/**
 * @author VINAY
 *
 */
public class HelloWorld {
	
	private String message;

	/**
	 * @param message
	 */
	public HelloWorld(String message) {
		super();
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
