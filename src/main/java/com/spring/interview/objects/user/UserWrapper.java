package com.spring.interview.objects.user;



/**
 * 
 * 
 * @author n_mah
 * Used to wrap post request body
 *
 */
public class UserWrapper {

	private String name;
	private User user;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
