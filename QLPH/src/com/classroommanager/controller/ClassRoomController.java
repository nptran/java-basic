package com.classroommanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.classroommanager.model.ClassRoom;

public class ClassRoomController implements BaseController<ClassRoom> {
	
	private List<ClassRoom> classRooms;
	private static ClassRoomController instance;
	private ClassRoomController() {
		classRooms = new ArrayList<>();
	}


	public static ClassRoomController getInstance() {
		if (instance == null) {
			instance = new ClassRoomController();
		}
		return instance;
	}
	
	@Override
	public void add(ClassRoom room) {
		classRooms.add(room);
	}

	@Override
	public List<ClassRoom> getAll() {	
		return classRooms;
	}

}

