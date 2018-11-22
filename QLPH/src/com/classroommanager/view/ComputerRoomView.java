package com.classroommanager.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.classroommanager.controller.AllRoomsController;
import com.classroommanager.controller.ComputerRoomController;
import com.classroommanager.exception.NegativeException;
import com.classroommanager.model.ComputerRoom;
import com.classroommanager.model.Room;

public class ComputerRoomView implements BaseView<ComputerRoom> {

	private static Scanner sc = new Scanner(System.in);
	@Override
	public ComputerRoom input(ComputerRoom room) throws NegativeException {
		
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
			System.out.println("Diện Tích *:");
			area = sc.nextDouble();
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw new NegativeException("KÝ TỰ KHÔNG HỢP LỆ!!!");
		}
		
		int lights = 0;
		try {
			System.out.println("Số Bóng Đèn *:");
			lights = sc.nextInt();
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw new NegativeException("KÝ TỰ KHÔNG HỢP LỆ!!!");
		}
	
		
		System.out.println("Số Lượng Máy Tính:");
		int numberofcomputers = sc.nextInt();
		sc.nextLine();
	
		if (code.isEmpty() || block.isEmpty()) {
			throw new NegativeException("KHÔNG ĐƯỢC BỎ TRỐNG CÁC TRƯỜNG CÓ DẤU *"); 
		}
		
		room.setCode(code);
		room.setBlock(block);
		room.setArea(area);
		room.setLights(lights);
		room.setNumberofcomputers(numberofcomputers);
		allrooms.add(room);
		
		return room;
	}
	
	@Override
	public void viewRoom(String code) {
		ComputerRoomController cprController = ComputerRoomController.getInstance();
			for (ComputerRoom pcroom : cprController.getAll()) {
				if (pcroom.getCode().equals(code)) {
					System.out.println("Phòng Máy Tính");
					System.out.println("Mã Phòng: " + pcroom.getCode() + " "
									+ "Dãy Nhà: " + pcroom.getBlock() + " "
									+ "Diện Tích: " + pcroom.getArea() + " "
									+ "Số Bóng Đèn: " + pcroom.getLights() + " "
									+ "Số Máy Tính: " + pcroom.getNumberofcomputers());
				}
			}
	}
	
}
