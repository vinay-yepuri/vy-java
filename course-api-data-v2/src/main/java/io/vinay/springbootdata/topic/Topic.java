/**
 * 
 */
package io.vinay.springbootdata.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity Class
 * 
 * @author VINAY
 *
 */
/**
 * @author VINAY
 *
 */
@Entity
public class Topic {

	@Id
	private String id;
	
	private String name;
	
	private String description;
	
	/**
	 * 
	 */
	public Topic() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param desc
	 */
	public Topic(String id, String name, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.description = desc;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	
	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	
	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

		

}
