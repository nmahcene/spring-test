package com.spring.interview.objects.user;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY , property = "type")
@JsonSubTypes({ 
	 @Type(value = Admin.class, name ="admin"), 
	 @Type(value = Manager.class, name = "manager"), 
	 @Type(value = Employee.class, name = "employee" )
})
public interface User {

	public enum Permission {
		EMPLOYEE, MANAGER, ADMIN
	}

	public UUID getUuid();

	public Permission getPermission();

	public String getName();

	public void setName(String name);

	public boolean isActive();

	public void setActive(boolean active);

	@JsonIgnore // Do not return in the response
	public LocalDate getBirthDay();

	public void setBirthDay(LocalDate birthDay);
}
