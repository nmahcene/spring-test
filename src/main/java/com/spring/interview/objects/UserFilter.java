package com.spring.interview.objects;

import java.util.function.Predicate;

import com.spring.interview.objects.user.User;
import com.spring.interview.objects.user.User.Permission;


public class UserFilter {
	
	
	/**
	 * Defines the user active state to filter.
	 * 
     * null:   No filter, all users returned
     * True:   Only active users returned
     * False:  Only inactive users returned
	 */
	
    private final Boolean active;
    
    /**
     * Defines the user permission to filter.
     * 
     * Employee:   All users returned (including managers and admins)
     * Manager:    All admins and managers returned.
     * Admin:      All admins returned.
     */

    private final Permission permission;
    
    
    /**
     * 
     * @return predicate on incoming values
     *  
     *     Need to be refined ( Logic has to be reviewed )  
     * 
     */
 
    public Predicate<User> userPredicate() {
    	
    	if(permission == null && active == null) return null;
    	
    	Predicate<User> predicate = u -> u.getPermission().equals(getPermission()) && u.isActive() == isActive().booleanValue();
    	
    	if(permission == null )
	         predicate = u ->  u.isActive() == isActive().booleanValue();
	    
        if(active == null )        
	       predicate = u -> u.getPermission().equals(getPermission());
        
    	return predicate;
	}
	
 	
    public UserFilter(Boolean active, Permission permission) {
  	    this.active = active;
        this.permission = permission;
    }

    public Boolean isActive() {
        return this.active;
    }

    public Permission getPermission() {
        return this.permission;
    }
}
