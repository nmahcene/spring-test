package com.spring.interview.registry;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.spring.interview.factories.UserFactory;
import com.spring.interview.objects.user.User;

/**
 * The UserRegistryImpl class is used to manage the users persistence in the application.
 */

@Repository
public class UserRegistryImpl implements UserRegistry {
	
	/**
	 * This is the data structure that contains all users by company ID.
	 * Important: for each company, the user list must always remain sorted by the users' name.
	 */
	public static final Map<Integer, List<User>> REGISTRY = Collections.synchronizedMap(new HashMap<>());
	
	public static final int compagny_one = 111;
	public static final int compagny_two = 333;
	
	static {
		
		List<User> users1 = UserFactory.generateUsers();
		REGISTRY.put(compagny_one, users1);

		List<User> users2 = UserFactory.generateUsers();
		REGISTRY.put(compagny_two, users2);
		
		/*
		 * Important: fill the map registry statically for 2 companies (ID 111 and 333).
		 * 
		 * The user list must use the UserFactory. The factory should be able to generate a user regardless of the defined parameters.
         * Use this factory to generate a list of at least 20 users, 5 of them managers and 2 admins. 
         * Random names should generated for users. It is important to have both active and inactive users of each type.
		 */
	}
	
	/**
	 * Returns an ordered and filtered list of users related to the specified company ID.
	 * @param companyId the company ID.
	 * @param filter the predicate that will be used to filter users. If null is specified, no filter will be used.
	 * @return a list of users.
	 */
	
	
	@Override
	public List<User> getUsers(int companyId, Predicate<User> filter) {
		
		if (filter == null) {
			
			final List<User> userList = REGISTRY.get(Integer.valueOf(companyId));
			
			if (userList != null)
				return Collections.unmodifiableList(userList);
		}
		
		/*
		 * Complete the method to return a filtered list based on the specified filter predicate
		 */
		
		final List<User> userList = REGISTRY.get(Integer.valueOf(companyId));
		
		final List<User> userListToReturn = (userList != null ) ? userList.stream()
   		                                                              	  .filter(filter)
   		                                                              	  .collect(Collectors.toList()) 
   		                                                        : Collections.emptyList() ;
		
		return  Collections.unmodifiableList(userListToReturn);
		
	}
	
	/**
	 * Adds a user to the related company ID user list.
	 * @param companyId the company ID .
	 * @param user the user to add.
	 * @return true if the user was successfully added.
	 */
	@Override
	public boolean addUser(int companyId, User user) {
		
		if (user == null)
			throw new IllegalArgumentException("Invalid user (null).");
		
		/*
		 * Complete the method to add the specified user into the registry
		 */
		List<User> users = REGISTRY.get(companyId);
		if(users != null) {
			users.add(user);
		   	return true;
		}
		return false;
	}
	
}
