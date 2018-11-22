package com.studentmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import com.studentmanagement.model.Student;

public class StudentController implements BaseController <Student>{

	private List<Student> students;
	private static StudentController instance;
	private StudentController() {
		students = new ArrayList<>();
	}
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	@Override
	public void add(Student person) {
		students.add(person);
	}

	@Override
	public List<Student> getAll() {
		return students;
	}

}
