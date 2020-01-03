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
//@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {
	
	private String steeringHandle;

	/**
	 * @return the steeringHandle
	 */
	public String getSteeringHandle() {
		return steeringHandle;
	}

	/**
	 * @param steeringHandle the steeringHandle to set
	 */
	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

}
