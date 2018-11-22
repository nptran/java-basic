package com.classroommanager.view;


import java.util.InputMismatchException;
import java.util.Scanner;

import com.classroommanager.controller.AllRoomsController;
import com.classroommanager.controller.ClassRoomController;
import com.classroommanager.exception.NegativeException;
import com.classroommanager.model.ClassRoom;
import com.classroommanager.model.Room;

public class ClassRoomView implements BaseView<ClassRoom>{

	private static Scanner sc= new Scanner(System.in);
	
	@Override
	public ClassRoom input(ClassRoom room) throws NegativeException {
		AllRoomsController allrooms = AllRoomsController.getInstance();
		String code = null;

		System.out.println("Mã Phòng *:");
		code = sc.nextLine();
				for (Room r : allrooms.getAll()) {
					if (r.getCode().equalsIgnoreCase(code)) 
						throw new NegativeException("Mã Này Đã Tồn Tại!!!");
				}
			
		System.out.println("Dãy Nhà *:");
		String block = sc.nextLine();
			
		double area = 0;
			try {
				System.out.println("Diện Tích:");
				area = sc.nextDouble();
			} catch (InputMismatchException e) {
				sc.nextLine();
				throw new NegativeException("KÝ TỰ KHÔNG HỢP LỆ!!!");
			}
				
		int lights = 0;
			try {
				System.out.println("Số Bóng Đèn:");
				lights = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				sc.nextLine();
				throw new NegativeException("KÝ TỰ KHÔNG HỢP LỆ!!!");
			}
				
		System.out.println("Máy Chiếu: <Nếu Có Nhấn Y>");
		String checkprojector = sc.nextLine();
		boolean projector;
		if(checkprojector.equalsIgnoreCase("y")) projector = true;
		else projector = false;
		
		if (code.isEmpty() || block.isEmpty()) {
			throw new NegativeException("Không Được Bỏ Trống Các Trường Có Dấu *"); 
		}
			
		room.setCode(code);
		room.setBlock(block);
		room.setArea(area);
		room.setLights(lights);
		room.setProjector(projector);
		allrooms.add(room);
		
		return room;
	}

	@Override
	public void viewRoom(String code) {
		ClassRoomController clrController= ClassRoomController.getInstance();
			for (ClassRoom classroom : clrController.getAll()) {
				if (classroom.getCode().equalsIgnoreCase(code)) {
					System.out.println("Phòng Học Lý Thuyết");
					System.out.println("Mã Phòng: " + classroom.getCode() + " "
									+ "Dãy Nhà: " + classroom.getBlock() + " "
									+ "Diện Tích: " + classroom.getArea() + " "
									+ "Số Bóng Đèn: " + classroom.getLights() + " "
									+ "Máy Chiếu: " + classroom.getProjector());
				}
			}
	}


}
