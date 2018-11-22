package com.techmaster.sample.controller;

import com.techmaster.sample.dao.StudentClassDao;
import com.techmaster.sample.model.StudentClass;

public class StudentClassController {

	private StudentClassDao dao;

	public StudentClassController() {
		dao = new StudentClassDao();
	}

	public void insertClass(StudentClass stdClass) {
		dao.addClass(stdClass);
	}

	public StudentClass getByName(String name) {
		return dao.getByName(name);
	}

}
