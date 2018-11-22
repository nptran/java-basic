package com.classroommanager.controller;
import java.util.ArrayList;
import java.util.List;

import com.classroommanager.model.Room;

public class AllRoomsController implements BaseController<Room> {
	
	private List<Room> allrooms;
	private static AllRoomsController instance;
	private AllRoomsController() {
		allrooms = new ArrayList<>();
	}


	public static AllRoomsController getInstance() {
		if (instance == null) {
			instance = new AllRoomsController();
		}
		return instance;
	}


	@Override
	public void add(Room room) {
		allrooms.add(room);		
	}

	@Override
	public List<Room> getAll() {
		return allrooms;
	}
	

}
