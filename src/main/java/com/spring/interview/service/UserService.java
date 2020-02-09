package com.spring.interview.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.spring.interview.objects.UserFilter;
import com.spring.interview.objects.user.User;
import com.spring.interview.objects.user.User.Permission;
import com.spring.interview.registry.UserRegistry;

@Service
public class UserService {
	
	/**
	 * The user registry instance that contains users.
	 */

	
	private UserRegistry userRegistry;

	public UserService(UserRegistry userRegistry ) {
		this.userRegistry = userRegistry;
	}
	
	/*
	 * Add method(s) to return users from the UserRegistry. This class shall support filtering based in specified user permissions and the active state.
	 */
	
	
	public List<User> getUsers(int compagnieId,  Boolean active , Permission permission ) {
	  UserFilter userFilter = new UserFilter(active, permission);	
	  Predicate<User> userPredicate = userFilter.userPredicate();
      return userRegistry.getUsers(compagnieId,userPredicate);
	}
	
	
	/*
	 * Add method to add a user into the UserRegistry.
	 */

	public boolean addUser(int companyId , User user) {
		//UserFactory.getUser(user.getPermission());
		return userRegistry.addUser(companyId,user);
	}
}
