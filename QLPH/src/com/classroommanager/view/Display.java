package com.classroommanager.view;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.classroommanager.comparator.AreaComparator;
import com.classroommanager.comparator.BlockComparator;
import com.classroommanager.comparator.LightsComparator;
import com.classroommanager.controller.AllRoomsController;
import com.classroommanager.controller.ClassRoomController;
import com.classroommanager.controller.ComputerRoomController;
import com.classroommanager.controller.LaboratoryController;
import com.classroommanager.edit.DeleteRoom;
import com.classroommanager.exception.NegativeException;
import com.classroommanager.model.ClassRoom;
import com.classroommanager.model.ComputerRoom;
import com.classroommanager.model.Laboratory;
import com.classroommanager.model.Room;

public class Display {

	private static Scanner sc = new Scanner(System.in);
	
	private static void showMenu() {
		System.out.println("______________MENU______________");
		System.out.println("1. Thêm Phòng");
		System.out.println("2. Tìm Kiếm Phòng");
		System.out.println("3. Danh Sách Tất Cả Phòng Học");
		System.out.println("4. Danh Sách Phòng Học Đạt Chuẩn");
		System.out.println("5. Cập Nhật Thông Tin Phòng");
		System.out.println("6. Danh Sách Phòng Máy Có Trên 60 Máy Tính");
		System.out.println("7. Thoát");
		System.out.println("________________________________");
	}
	
	private static void showComparator() {
		System.out.println("HIỂN THỊ: 1.Theo Dãy Nhà  2.Theo Diện Tích  3.Theo Số Bóng Đèn  4.Mặc Định  5.Quay Lại Menu");
		System.out.println("____________________________________________________________________________________________");
	}
	
	private static void showAdd() {
		System.out.println("________________________________");
		System.out.println("1. Thêm Phòng Học Lý Thuyết");
		System.out.println("2. Thêm Phòng Máy Tính");
		System.out.println("3. Thêm Phòng Thí Nghiệm");
		System.out.println("4. Quay Lại Menu");
	}
	
	private static void showEdit() {
		System.out.println("________________________________");
		System.out.println("1. Xoá Phòng");
		System.out.println("2. Cập Nhật Số Máy Tính Cho Phòng Máy");
		System.out.println("3. Quay Lại Menu");
		
	}
	
	public void run() throws NegativeException {
		
				AllRoomsController allrooms = AllRoomsController.getInstance();
				ClassRoomController clrController= ClassRoomController.getInstance();
				LaboratoryController labController = LaboratoryController.getInstance();
				ComputerRoomController cprController = ComputerRoomController.getInstance();
				
				ClassRoomView clrView = new ClassRoomView();
				LaboratoryView labView = new LaboratoryView();
				ComputerRoomView cprView = new ComputerRoomView();
				
				showMenu();
				int choice;
				
				do {
			
					choice = sc.nextInt();
					sc.nextLine();

					switch (choice) {
					case 1: //Thêm Phòng
						showAdd();
						int choiceAdd;
						do {
							choiceAdd = sc.nextInt();
							sc.nextLine();
							switch(choiceAdd) {
							case 1: //thêm phòng lý thuyết
								ClassRoom classroom = new ClassRoom();
								try {
									clrView.input(classroom);
									clrController.add(classroom);
									System.out.println("==========THÊM THÀNH CÔNG==========");
								} catch (NegativeException e) {
									System.err.println(e.getMessage());
								}
								showAdd();
								break;

							case 2: //thêm phòng Máy tính
								ComputerRoom computerroom = new ComputerRoom();
								try {
									cprView.input(computerroom);
									cprController.add(computerroom);
									System.out.println("==========THÊM THÀNH CÔNG==========");
								} catch (NegativeException e) {
									System.err.println(e.getMessage());
								}
						
								showAdd();
								break;
							case 3: //thêm phòng thí nghiệm
								Laboratory lab = new Laboratory();
								try {
									labView.input(lab);
									labController.add(lab);
									System.out.println("==========THÊM THÀNH CÔNG==========");
								} catch (NegativeException e) {
									System.err.println(e.getMessage());
								}
								
								showAdd();
								break;
							case 4: //Trở về Menu
								break;
							default: System.err.println("WRONG CHOICE, TRY AGAIN!!!"); 
								showAdd();
								break;
							}
						} while (choiceAdd!=4);
						
						showMenu();
						break;
					case 2: //Tìm Kiếm Phòng
						System.out.println("Nhập Vào Mã Phòng: ");
						String code = sc.nextLine();						
						Search.showInfo(code);
						showMenu();
						break;
					case 3: //Hiển thị tất cả các phòng

						System.out.println("Tổng Số: " +allrooms.getAll().size()+ " phòng");
						showComparator();
						int choiceCompare;
						do {
							choiceCompare = sc.nextInt();
							sc.nextLine();
							switch (choiceCompare) {
							case 1: //SẮP XẾP THEO DÃY NHÀ
								BlockComparator blockcomparator = new BlockComparator();
								Collections.sort(allrooms.getAll(), blockcomparator);
								for (Room room : allrooms.getAll()) {
									System.out.println("Mã Phòng: " + room.getCode() + " "
													+ "Dãy Nhà: " + room.getBlock() + " "
													+ "Diện Tích: " + room.getArea() + " "
													+ "Bóng Đèn: " + room.getLights());
								}
								break;
							case 2: //SẮP XẾP THEO DIỆN TÍCH
								AreaComparator areacomparator = new AreaComparator();
								Collections.sort(allrooms.getAll(), areacomparator);
								for (Room room : allrooms.getAll()) {
									System.out.println("Mã Phòng: " + room.getCode() + " "
													+ "Dãy Nhà: " + room.getBlock() + " "
													+ "Diện Tích: " + room.getArea() + " "
													+ "Bóng Đèn: " + room.getLights());
								}
								break;
							case 3: //SẮP XẾP THEO SỐ BÓNG ĐÈN
								LightsComparator lightcomparator = new LightsComparator();
								Collections.sort(allrooms.getAll(), lightcomparator);
								for (Room room : allrooms.getAll()) {
									System.out.println("Mã Phòng: " + room.getCode() + " "
													+ "Dãy Nhà: " + room.getBlock() + " "
													+ "Diện Tích: " + room.getArea() + " "
													+ "Bóng Đèn: " + room.getLights());
								}
								break;
							case 4: //KHÔNG SẮP XẾP
								for (Room room : allrooms.getAll()) {
									System.out.println("Mã Phòng: " + room.getCode() + " "
													+ "Dãy Nhà: " + room.getBlock() + " "
													+ "Diện Tích: " + room.getArea() + " "
													+ "Bóng Đèn: " + room.getLights());
								}
								break;
							case 5: break;
							default: System.err.println("WRONG CHOICE, TRY AGAIN!!!");
								showComparator();
								break;
								
							}
						} while (choiceCompare !=5);
							
						
						showMenu();
						break;
					case 4: //Hiển thị phòng đạt chuẩn
						List<Room> temp = allrooms.getAll();
						List<Room> standardrooms = temp;
						
						for (ClassRoom classroom : clrController.getAll()) {
							if (!(classroom.getProjector().equals("Có")))
								standardrooms.remove(classroom);
						}
						for (ComputerRoom computerroom : cprController.getAll()) {
							if (!(computerroom.getNumberofcomputers()/(computerroom.getArea()) >= (2/3)))
								standardrooms.remove(computerroom);
						}
						for (Laboratory lab : labController.getAll()) {
							if (!(lab.getBath().equals("Có")))
								standardrooms.remove(lab);
						}
						
						if(standardrooms.isEmpty())
							System.out.println("Không Có Phòng Nào Đạt Chuẩn!!!");
						else {
							System.out.println("________Danh sách phòng học đạt chuẩn________ ");
							for (Room room : standardrooms) {
								if (room.getLights()/room.getArea() >= 0.1) 
									System.out.println("Mã Phòng: " + room.getCode() + " " 
													+ "Dãy Nhà: " + room.getBlock());
							}
						}
						showMenu();
						break;
					case 5: //Cập nhật thông tin phòng
						showEdit();
						int choiceEdit = 0;
						do {
							choiceEdit = sc.nextInt();
							sc.nextLine();
							
							switch (choiceEdit) {
							case 1:
								DeleteRoom del = new DeleteRoom();
								System.out.println("Nhập Mã Phòng:");
								String roomcode = sc.nextLine();
								del.delete(roomcode);
								showEdit();
								break;
							case 2:
								ComputerRoom editNumberofcomputers = null;
								System.out.println("Nhập Mã Phòng:");
								String codeToEdit = sc.nextLine();
								for (ComputerRoom pcroom : cprController.getAll()) {
									if (codeToEdit.equalsIgnoreCase(pcroom.getCode())) {
										editNumberofcomputers = pcroom;
									}
								}
									if (editNumberofcomputers != null) {
										System.out.println("Số Máy Tính Hiện Tại: " + editNumberofcomputers.getNumberofcomputers());
										System.out.println("Số Máy Tính Mới: ");
										editNumberofcomputers.setNumberofcomputers(sc.nextInt());
										System.out.println("Cập Nhật Thành Công!");
									} else System.err.println("MÃ PHÒNG KHÔNG CHÍNH XÁC!!!");
								showEdit();
								break;
							case 3: //back to Menu
								break;
							default:
								System.err.println("WRONG CHOICE, TRY AGAIN!!!");
								showEdit();
							}
							
						} while (choiceEdit != 3);
						
						showMenu();
						break;
					case 6: 
						for (ComputerRoom room : cprController.getAll()) {
							if (room.getNumberofcomputers() >= 60) {
									System.out.println("Phòng Máy Tính");
									System.out.println("Mã Phòng: " + room.getCode() + " "
													+ "Dãy Nhà: " + room.getBlock() + " "
													+ "Diện Tích: " + room.getArea() + " "
													+ "Số Bóng Đèn: " + room.getLights() + " "
													+ "Số Máy Tính: " + room.getNumberofcomputers());
								
							}
						}
						showMenu();
						break;
					case 7: //Thoát
						System.err.println("==========ĐÃ THOÁT=========");
						break;
					default: System.err.println("WRONG CHOICE, TRY AGAIN!!!");
						break;
					}
					
				} while (choice != 7);
		
	}
	
}
