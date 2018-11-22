package com.classroommanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.classroommanager.model.ComputerRoom;

public class ComputerRoomController implements BaseController <ComputerRoom>{

	private List<ComputerRoom> computerRooms;
	private static ComputerRoomController instance;
	private ComputerRoomController() {
		computerRooms = new ArrayList<>();
	}
	public static ComputerRoomController getInstance() {
		if(instance ==null) {
			instance = new ComputerRoomController();
		}
		return instance;
		
	}
	
	@Override	
	public void add(ComputerRoom room) {
		computerRooms.add(room);
	}

	@Override
	public List<ComputerRoom> getAll() {
		return computerRooms;
	}
	
}
