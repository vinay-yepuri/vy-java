/**
 * 
 */
package org.javabrains.vinay.dto;

import javax.persistence.Entity;

/**
 * @author VINAY
 *
 */
@Entity
//@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {
	
	private String steeringWheel;

	/**
	 * @return the steeringWheel
	 */
	public String getSteeringWheel() {
		return steeringWheel;
	}

	/**
	 * @param steeringWheel the steeringWheel to set
	 */
	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

}
