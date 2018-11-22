package com.classroommanager.view;

import com.classroommanager.controller.AllRoomsController;
import com.classroommanager.controller.ClassRoomController;
import com.classroommanager.controller.ComputerRoomController;
import com.classroommanager.controller.LaboratoryController;
//import com.classroommanager.exception.NegativeException;
//import com.classroommanager.controller.LaboratoryController;
import com.classroommanager.model.ClassRoom;
import com.classroommanager.model.ComputerRoom;
import com.classroommanager.model.Laboratory;
//import com.classroommanager.model.Laboratory;
import com.classroommanager.model.Room;

public class Search {
	
	private static boolean search(String code) {
		
		AllRoomsController rooms = AllRoomsController.getInstance();	
		boolean founder = false;	
		for (Room room : rooms.getAll()) {
			if (code.equalsIgnoreCase(room.getCode())) {
				founder = true;
			}
		}
		return founder;
	}
	
	public static String checkRoom (String code) {
		ClassRoomController clrController= ClassRoomController.getInstance();			boolean isclassroom = false;
		ComputerRoomController cprController = ComputerRoomController.getInstance();	boolean ispcroom = false;
		LaboratoryController labController = LaboratoryController.getInstance();		boolean islab = false;
		
		if(search(code) == true) {	
			for (ClassRoom room : clrController.getAll()) {
				if (room.getCode().equalsIgnoreCase(code))
					isclassroom = true;
			}
			for (ComputerRoom room : cprController.getAll()) {
				if (room.getCode().equalsIgnoreCase(code))
					ispcroom = true;
			}
			for (Laboratory room : labController.getAll()) {
				if (room.getCode().equalsIgnoreCase(code))
					islab = true;
			}
		}
		if (isclassroom == true) 
			return "Phòng Lý Thuyết";
		else if (ispcroom == true)
			return "Phòng Máy";
		else if (islab == true)
			return "Phòng LAB";
		else
			return "NOT FOUND";
	}
	
	public static void showInfo(String code) {
		ComputerRoomView pcroomview = new ComputerRoomView();
		ClassRoomView classview = new ClassRoomView();
		LaboratoryView labview = new LaboratoryView();
		
		if (checkRoom(code).equals("Phòng Lý Thuyết"))
			classview.viewRoom(code);
		else if (checkRoom(code).equals("Phòng Máy"))
			pcroomview.viewRoom(code);
		else if (checkRoom(code).equals("Phòng LAB"))
			labview.viewRoom(code);
		else
			System.out.println("KHÔNG TÌM THẤY!!!");
		
	}
	
}
