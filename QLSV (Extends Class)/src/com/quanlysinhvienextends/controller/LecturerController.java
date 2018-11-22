package com.quanlysinhvienextends.controller;

import java.util.ArrayList;
import java.util.List;

import com.quanlysinhvienextends.model.Lecturer;

public class LecturerController {
	
	private List<Lecturer> lecturers;
	
	public LecturerController() {
		lecturers = new ArrayList<>();
	}
	
	public List<Lecturer> getLecturer() {
		return lecturers;
	}
	
	public void addLecturer(Lecturer lecturer) {
		lecturers.add(lecturer);
	}

}
