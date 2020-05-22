/**
 * 
 */
package com.vinay.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
public class UserJpaController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	// Retrieve all resources
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	// Retrieve an user with and ID
	@GetMapping("/jpa/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty())
			throw new UserNotFoundException("id - "+id);
		
		/*
		 * // HATEOAS EntityModel<User> entity = new EntityModel<>(user);
		 * WebMvcLinkBuilder link =
		 * linkTo(methodOn(this.getClass()).retrieveAllUsers());
		 * entity.add(link.withRel("all-users"));
		 */
		return user.get();
		//return entity;
	}
	// Create a user
	// Output : Created Status and URi of newly created resource
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUSer = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(savedUSer.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	// Delete User
	@DeleteMapping("/jpa/users/{id}")
	public void deleteById(@PathVariable int id) {
		 userRepository.deleteById(id);
	}
	
	// Retrieve all resources
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllPostsOfUser(@PathVariable int id){
		Optional<User> userOptional = userRepository.findById(id);
		
		if( !userOptional.isPresent()) {
			throw new UserNotFoundException("id - "+id);
		}
		return userOptional.get().getPosts();
	}
	
	// Create a user
	// Output : Created Status and URi of newly created resource
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost( @RequestBody Post post, @PathVariable int id) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if( !userOptional.isPresent()) {
			throw new UserNotFoundException("id - "+id);
		}
		User user = userOptional.get();
		post.setUser(user);
		postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
