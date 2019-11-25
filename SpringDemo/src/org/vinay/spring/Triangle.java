/**
 * 
 */
package org.vinay.spring;

/**
 * @author VINAY
 *
 */
public class Triangle {
	
	private String type;
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public void draw() {
		System.out.println(getType() +" Traingle Draw ");
	}

}
