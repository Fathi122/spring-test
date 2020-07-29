package com.dev.test;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

	private final UserRepositery userRepositery;
	
	@GetMapping("/{id}")
	public Optional<User> GetUserById(@PathVariable long id){
		log.debug("GetUserById " + id);
		return userRepositery.findById(id);	
	}
	
	@PostMapping()
	public User CreateUser(@RequestBody User user){
		log.debug("CreateUser " + user);
		return userRepositery.save(user);
	}
	
	@PutMapping()
	public User UpdateUser(@RequestBody User user){
		log.debug("UpdateUser " + user);
		return userRepositery.save(user);
	}
	
	@DeleteMapping("/{id}")
	public void DeleteUser(@PathVariable long id){
		log.debug("DeleteUser " + id);
		userRepositery.deleteById(id);
	}
}
