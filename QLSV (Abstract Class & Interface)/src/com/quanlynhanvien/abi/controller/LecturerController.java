package com.quanlynhanvien.abi.controller;

import java.util.ArrayList;
import java.util.List;

import com.quanlynhanvien.abi.model.Lecturer;
import com.quanlynhanvien.abi.model.Person;

public class LecturerController implements Controller {
	
	private List<Lecturer> lecturers;
	
	public LecturerController() {
		lecturers  = new ArrayList<>();	
	}

	public List<Lecturer> getAllLecturers() {
		return lecturers;
	}

	@Override
	public void add(Person lecturer) {
		lecturers.add((Lecturer) lecturer);
	}

}
