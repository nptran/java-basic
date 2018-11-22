package com.studentmanagement.view;

import com.studentmanagement.model.Person;

public interface BaseView <T extends Person> {
	
	T input(T person);

}
