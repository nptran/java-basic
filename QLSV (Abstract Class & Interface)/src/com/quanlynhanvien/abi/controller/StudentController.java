package com.quanlynhanvien.abi.controller;

import java.util.ArrayList;
import java.util.List;

import com.quanlynhanvien.abi.model.Person;
import com.quanlynhanvien.abi.model.Student;

public class StudentController implements Controller{
	
	private List<Student> students;
	
	public StudentController(){
		students = new ArrayList<>();
	}

	public List<Student> getAllStudents() {
		return students;
	}

	@Override
	public void add(Person student) {
	
		students.add((Student) student);
	}
	
	
	

}
