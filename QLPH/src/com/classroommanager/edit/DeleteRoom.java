package com.classroommanager.edit;

import java.util.Scanner;

import com.classroommanager.controller.AllRoomsController;
import com.classroommanager.model.Room;
import com.classroommanager.view.Search;

public class DeleteRoom {
	
	private static Scanner sc = new Scanner(System.in);
	public void delete(String code) {
		
		AllRoomsController all = AllRoomsController.getInstance();
		if (Search.checkRoom(code).equals("NOT FOUND"))
			Search.showInfo(code);
		else {
			Search.showInfo(code);
			System.err.printf("CẢNH BÁO: Tất cả thông tin liên quan đến phòng này sẽ bị xoá.\n");
			System.out.println("Bạn Có Chắc Chắn Xoá? <Nhấn Y Để Xoá>");
			
			String cf = sc.nextLine();
			if (cf.equalsIgnoreCase("Y")) {
				Room thisroominall = null; 
				for (Room room : all.getAll()) {
					if (room.getCode().equalsIgnoreCase(code)) {
						thisroominall = room;
					}
				}
				if (thisroominall != null) {
					all.getAll().remove(thisroominall);
					System.out.println("===========ĐÃ XOÁ===========");
				}
				
			}
		}
	}
		
}
