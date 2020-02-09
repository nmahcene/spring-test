package com.spring.interview.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.spring.interview.objects.user.User;


/**
 * Enum Converter
 * 
 * @author n_mah
 *
 */
public class MyCustomEnumConverter implements Converter<String, User.Permission> {
    @Override
    public User.Permission convert(String source) {
       try {
          return User.Permission.valueOf(source);
       } catch(Exception e) {
          return null; // or SortEnum.asc
       }
    }

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return null;
	}
}
