/**
 * 
 */
package org.javabrains.vinay.dto;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author VINAY
 *
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
//@NamedQuery(name="UserDetails.byId", query = "from UserDetails where userId=?1")
//@NamedNativeQuery(name="UserDetails.byName", query = "select * from USER_DETAILS where userName = ?1", resultClass = UserDetails.class)
@Table(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue // (strategy = GenerationType.AUTO)
	private int userId;

	private String userName;

//	@Temporal(TemporalType.TIME)
//	private Date joiningDate;

//	@Lob
//	private String description;

	//@OneToMany(mappedBy = "userDetails")
	/*
	 * @JoinTable(name="USER_VEHICLE",joinColumns = @JoinColumn(name="USER_ID"),
	 * inverseJoinColumns = @JoinColumn(name="VEHICLE_ID"))
	 */
	// @JoinColumn(name="VEHICLE_ID")
	// private Vehicle vehicle;
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinTable(name="USER_VEHICLE",joinColumns = @JoinColumn(name="USER_ID"),
//				inverseJoinColumns = @JoinColumn(name="VEHICLE_ID"))
	//private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();

	/*
	 * @ElementCollection(fetch = FetchType.EAGER)
	 * 
	 * @JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name =
	 * "USER_ID"))
	 * 
	 * @GenericGenerator(name = "increment-gen", strategy = "increment")
	 * 
	 * @CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator =
	 * "increment-gen", type = @Type(type="long"))
	 * 
	 * private Collection<Addess> setOfAddresses = new ArrayList<Addess>();
	 */

	/*
	 * @ElementCollection
	 * 
	 * @JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name =
	 * "USER_ID")) private Collection<Addess> setOfAddresses = new ArrayList();
	 */

	/*
	 * @Embedded
	 * 
	 * @AttributeOverrides({
	 * 
	 * @AttributeOverride(name = "street",column=@Column(name="HOME_STREET")),
	 * 
	 * @AttributeOverride(name = "city",column=@Column(name="HOME_CITY")),
	 * 
	 * @AttributeOverride(name = "state",column=@Column(name="HOME_STATE")),
	 * 
	 * @AttributeOverride(name = "pincode",column=@Column(name="HOME_PINCODE")) })
	 * private Addess homeAddress;
	 * 
	 * @Embedded private Addess officeAddress;
	 */

	/**
	 * @return the homeAddress
	 */
	/*
	 * public Addess getHomeAddress() { return homeAddress; }
	 * 
	 *//**
		 * @param homeAddress the homeAddress to set
		 */
	/*
	 * public void setHomeAddress(Addess homeAddress) { this.homeAddress =
	 * homeAddress; }
	 * 
	 *//**
		 * @return the officeAddress
		 */
	/*
	 * public Addess getOfficeAddress() { return officeAddress; }
	 * 
	 *//**
		 * @param officeAddress the officeAddress to set
		 */
	/*
	 * public void setOfficeAddress(Addess officeAddress) { this.officeAddress =
	 * officeAddress; }
	 * 
	 *//**
		 * @return the address
		 */

	/*	*//**
			 * @return the setOfAddresses
			 *//*
				 * public Set<Addess> getSetOfAddresses() { return setOfAddresses; }
				 */

	/*	*//**
			 * @return the setOfAddresses
			 */
	/*
	 * public Collection<Addess> getSetOfAddresses() { return setOfAddresses; }
	 * 
	 *//**
		 * @param setOfAddresses the setOfAddresses to set
		 *//*
			 * public void setSetOfAddresses(Collection<Addess> setOfAddresses) {
			 * this.setOfAddresses = setOfAddresses; }
			 */

	/*	*//**
			 * @param setOfAddresses the setOfAddresses to set
			 *//*
				 * public void setSetOfAddresses(Set<Addess> setOfAddresses) {
				 * this.setOfAddresses = setOfAddresses; }
				 */

	/*	*//**
			 * @return the vehicle
			 */
	/*
	 * public Vehicle getVehicle() { return vehicle; }
	 * 
	 *//**
		 * @param vehicle the vehicle to set
		 *//*
			 * public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
			 */

	/*
	 * public Addess getAddress() { return homeAddress; }
	 * 
	 *//**
		 * @param address the address to set
		 *//*
			 * public void setAddress(Addess homeAddress) { this.homeAddress = homeAddress;
			 * }
			 */
//	public Date getJoiningDate() {
//		return joiningDate;
//	}
//
//	/**
//	 * @return the vehicle
//	 */
//	public Collection<Vehicle> getVehicle() {
//		return vehicle;
//	}
//
//	/**
//	 * @param vehicle the vehicle to set
//	 */
//	public void setVehicle(Collection<Vehicle> vehicle) {
//		this.vehicle = vehicle;
//	}
//
//	public void setJoiningDate(Date joiningDate) {
//		this.joiningDate = joiningDate;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
