package com.classroommanager.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.classroommanager.controller.AllRoomsController;
import com.classroommanager.controller.LaboratoryController;
import com.classroommanager.exception.NegativeException;
import com.classroommanager.model.Laboratory;
import com.classroommanager.model.Room;

public class LaboratoryView implements BaseView<Laboratory> {

	private static Scanner sc= new Scanner(System.in);
	
	@Override
	public Laboratory input(Laboratory room) throws NegativeException {
		
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
			sc.nextLine();
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw new NegativeException("KÝ TỰ KHÔNG HỢP LỆ!!!");
		}
		
		System.out.println("Chuyên Ngành *:");
		String major = sc.nextLine();
		System.out.println("Sức Chứa *:");
		int capacity = sc.nextInt(); sc.nextLine();
		System.out.println("Bồn Rửa: <Nếu Có Nhấn Y>");
		String checkbath = sc.nextLine();
		boolean bath;
		if(checkbath.equalsIgnoreCase("y")) bath = true;
		else bath = false;
		
		if (code.isEmpty() || block.isEmpty() || major.isEmpty() || String.valueOf(capacity).isEmpty()) {
			throw new NegativeException("Không Được Bỏ Trống Các Trường Có Dấu *"); 
		}
		
		room.setCode(code);
		room.setBlock(block);
		room.setArea(area);
		room.setLights(lights);
		room.setMajor(major);
		room.setCapacity(capacity);
		room.setBath(bath);
		allrooms.add(room);
		
		return room;
	}

	@Override
	public void viewRoom(String code) {
		LaboratoryController labController = LaboratoryController.getInstance();
			for (Laboratory lab : labController.getAll()) {
				if (lab.getCode().equals(code)) {
					System.out.println("Phòng Thí Nghiệm Chuyên Ngành " + lab.getMajor());
					System.out.println("Mã Phòng: " + lab.getCode() + " "
									+ "Dãy Nhà: " + lab.getBlock() + " "
									+ "Diện Tích: " + lab.getArea() + " "
									+ "Sức Chứa: " + lab.getCapacity() + " "
									+ "Số Bóng Đèn: " + lab.getLights() + " "
									+ "Bồn Rửa: " + lab.getBath());
				}
			}
		
	}
	
	

}
