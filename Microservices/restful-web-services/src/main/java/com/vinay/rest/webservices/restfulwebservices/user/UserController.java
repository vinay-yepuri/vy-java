/**
 * 
 */
package com.vinay.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author VINAY
 *
 */
@RestController
public class UserController {
	
	@Autowired
	private UserDaoService userDaoService;
	
	// Retrieve all resources
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDaoService.findAll();
	}
	
	// Retrieve an user with and ID
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = userDaoService.findOne(id);
		if(user == null)
			throw new UserNotFoundException("id - "+id);
		
		/*
		 * // HATEOAS EntityModel<User> entity = new EntityModel<>(user);
		 * WebMvcLinkBuilder link =
		 * linkTo(methodOn(this.getClass()).retrieveAllUsers());
		 * entity.add(link.withRel("all-users"));
		 */
		return user;
		//return entity;
	}
	// Create a user
	// Output : Created Status and URi of newly created resource
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUSer = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(savedUSer.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	// Delete User
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable int id) {
		User deleteById = userDaoService.deleteById(id);
		if( deleteById == null)
			throw new UserNotFoundException("Id - "+id);
	}
}
