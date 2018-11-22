package com.classroommanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.classroommanager.model.Laboratory;

public class LaboratoryController implements BaseController<Laboratory> {
	
	private List<Laboratory> labs;
	private static LaboratoryController instance;
	private LaboratoryController() {
		labs = new ArrayList<>();
	}
	
	public static LaboratoryController getInstance() {
		if (instance == null) 
			instance = new LaboratoryController();
		
		return instance;
	}

	@Override
	public void add(Laboratory room) {
		labs.add(room);
	}

	@Override
	public List<Laboratory> getAll() {
		return labs;
	}

	
}
