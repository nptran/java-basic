package com.quanlysinhvienextends.controller;

import java.util.ArrayList;
import java.util.List;

import com.quanlysinhvienextends.model.Student;

public class StudentController {
	
	private List<Student> students;
	
	public StudentController() {
		students = new ArrayList<>();
	}
	
	public List<Student> getStudent() {
		return students;
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}

}
