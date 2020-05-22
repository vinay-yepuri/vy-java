/**
 * 
 */
package com.vinay.rest.webservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author VINAY
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
