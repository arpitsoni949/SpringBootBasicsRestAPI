package com.example.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController("/UserResource")
public class UserResource {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("users")
	public List<User> retriveAllUser() {
		return userDaoService.findAll();
	}
	
	@GetMapping("user/{id}")
	public EntityModel<User> retriveUserById(@PathVariable Integer id) {
		System.out.println("retriveUserById: ");
		User user=userDaoService.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id: "+id);
		}
		EntityModel<User> model=EntityModel.of(user);
		WebMvcLinkBuilder linkBuilder=linkTo(methodOn(this.getClass(), retriveAllUser()));
		model.add(linkBuilder.withRel("all-users"));
		return model;
	}
	
	@PostMapping("create-user")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser=userDaoService.save(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		User user=userDaoService.delete(id);
		if(user==null) {
			throw new UserNotFoundException("id: "+id);
		}
	}
	
}
