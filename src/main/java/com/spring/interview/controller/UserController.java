package com.spring.interview.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.interview.objects.user.User;
import com.spring.interview.objects.user.UserWrapper;
import com.spring.interview.service.UserService;

@RestController
public class UserController {
	
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/*
	 * Write a method that handles a RESTful GET request and returns users from UserService in the JSON format.
	 * Important: when returning users, the birthday date must not be included in the transfered data.
	 * 
	 * Add a path parameter for the company ID.
	 * Add an optional parameter to filter users based on user permissions (admin, manager or employee).
	 * Add an optional parameter to filter users based the active state.
	 * 
	 * @see UserService
	 * @see User.Permission
	 */
	
	
	/**
	 * 
	 * @param id
	 * @param state
	 * @param permission
	 * @return
	 * 
	 * @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	 *  Has to move to Interface API 
	 */
		
	@GetMapping(value = "/users/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE)
	//@ResponseBody
	public List<User> getUsers(@PathVariable Integer companyId,
			                   @RequestParam(required = false) Boolean state,  
			                   @RequestParam(required = false) User.Permission permission ){

		
			
		return userService.getUsers(companyId, state, permission);
	}
	
	
	
	/*
	 * Write a method that handles a RESTful POST request that adds a user using the UserService.
	 * 
	 * @see UserService
	 */
	
	
	@PostMapping(value = "/user/{companyId}" , produces = MediaType.APPLICATION_JSON_VALUE )
	public void addUser(@PathVariable Integer companyId, @RequestBody UserWrapper user) {
		userService.addUser(companyId, user.getUser());
	}
	
}
