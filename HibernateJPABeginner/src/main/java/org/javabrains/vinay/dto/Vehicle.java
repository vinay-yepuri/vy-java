/**
 * 
 */
package org.javabrains.vinay.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author VINAY
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// DiscriminatorColumn is required for SINGLE TABLE Inheritance Strategy
//@DiscriminatorColumn(name = "VEHICLE_TYPE",
//					discriminatorType = DiscriminatorType.STRING)
public class Vehicle {

	@Id
	@GeneratedValue
	private int vehicleId;

	private String vehicleName;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="USER_ID")
	 */
//	@ManyToMany(mappedBy = "vehicle")
//	private Collection<UserDetails> userDetails = new ArrayList<UserDetails>();

	/*	*//**
			 * @return the userDetails
			 */
	/*
	 * public UserDetails getUserDetails() { return userDetails; }
	 * 
	 *//**
		 * @param userDetails the userDetails to set
		 *//*
			 * public void setUserDetails(UserDetails userDetails) { this.userDetails =
			 * userDetails; }
			 */

	/**
	 * @return the vehicleId
	 */
	public int getVehicleId() {
		return vehicleId;
	}

//	/**
//	 * @return the userDetails
//	 */
//	public Collection<UserDetails> getUserDetails() {
//		return userDetails;
//	}
//
//	/**
//	 * @param userDetails the userDetails to set
//	 */
//	public void setUserDetails(Collection<UserDetails> userDetails) {
//		this.userDetails = userDetails;
//	}

	/**
	 * @param vehicleId the vehicleId to set
	 */
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * @return the vehicleName
	 */
	public String getVehicleName() {
		return vehicleName;
	}

	/**
	 * @param vehicleName the vehicleName to set
	 */
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

}
