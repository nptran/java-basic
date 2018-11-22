package com.techmaster.sample.controller;

import com.techmaster.sample.dao.StudentDao;
import com.techmaster.sample.model.Student;

public class StudentController {

	private StudentDao dao;

	public StudentController() {
		dao = new StudentDao();
	}

	public void insertStudent(Student student) {
		dao.insertStudent(student);
	}

}
