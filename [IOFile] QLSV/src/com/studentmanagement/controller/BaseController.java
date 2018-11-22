package com.studentmanagement.controller;

import java.util.List;

import com.studentmanagement.model.Person;

public interface BaseController <T extends Person> {

	void add(T person);
	List<T> getAll();
	
}
