/**
 * 
 */
package com.vinay.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author VINAY
 *
 */
@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<User>();
	
	private static int userCount = 3;
	
	static {
		users.add(new User(1, "Vinay", new Date()));
		users.add(new User(2, "Manya", new Date()));
		users.add(new User(3, "Rajesh", new Date()));
	}
	
	/**
	 * @return
	 */
	public List<User> findAll(){
		return users;
	}
	
	/**
	 * @param user
	 * @return
	 */
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	/**
	 * @param id
	 * @return
	 */
	public User findOne(int id) {
		for(User user : users) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}
	
	public User deleteById(int id) {
		
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
		
	}
}
