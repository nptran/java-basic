package com.marketmanager.product.view;

import java.util.Collections;
import java.util.Scanner;

import com.marketmanager.product.comparator.CostComparator;
import com.marketmanager.product.comparator.NameComparator;
import com.marketmanager.product.controller.ElectronicController;
import com.marketmanager.product.controller.FoodController;
import com.marketmanager.product.exception.NegativeException;
import com.marketmanager.product.model.Electronic;
import com.marketmanager.product.model.Food;

public class Display {
	
	private static Scanner sc = new Scanner(System.in);
	private static void showMenu() {
		System.out.println("_________MENU_________");
		System.out.println("1. Thêm hàng");
		System.out.println("2. Danh sách mặt hàng");
		System.out.println("3. Thoát");
		System.out.println("______________________");
	}
	private static void showAdd() {
		System.out.println("1. Hàng điện tử");
		System.out.println("2. Hàng thực phẩm");
		System.out.println("3. Quay lại Menu");
	}
	private static void showView() {
		System.out.println("1. Hàng điện tử");
		System.out.println("2. Hàng thực phẩm");
		System.out.println("3. Tất cả mặt hàng");
		System.out.println("4. Quay lại Menu");
		
	}
	
	public void run() throws NegativeException {
		
		ElectronicView eView = new ElectronicView();
		FoodView fView = new FoodView();
		FoodController fControll = FoodController.getInstance();
		ElectronicController eControll = ElectronicController.getInstance();
		showMenu();
		int choice = 0;

		do {
			choice = sc.nextInt();
			sc.nextLine();
						
			switch (choice) {
				
			case 1: //thêm
				showAdd();
				int choiceAdd = 0;
				while (choiceAdd != 3) {
					choiceAdd = sc.nextInt();
					sc.nextLine();
					switch (choiceAdd) {
					case 1: //thêm hàng điện tử
						try {
							Electronic electronic = new Electronic();
							electronic = eView.input();
							eControll.add(electronic);
							System.out.println("Thêm thành công!");
							showAdd();
							break;
						} catch (NegativeException e) {
							System.err.println(e.getMessage());
							showAdd();
							break;
						}
						
					case 2: //thêm hàng thực phẩm
						try {
							Food food = new Food();
							food = fView.input();
							fControll.add(food);
							System.out.println("Thêm thành công!");
							showAdd();
							break;
						} catch (NegativeException e) {
							System.err.println(e.getMessage());
							showAdd();
							break;
						}
					case 3: break;
					default:
						System.out.println("Wrong Choice! Try Again!");
						showAdd();
						break;
					}
				};
				showMenu();
				break;
				
			case 2: //hiển thị
				int choiceView = 0;
				showView();
				while (choiceView != 4) {
					choiceView = sc.nextInt();
					sc.nextLine();
					switch (choiceView) {
					
					case 1: //Hiển thị hàng điện tử
						NameComparator nameComparator = new NameComparator();
						Collections.sort(eControll.getAll(), nameComparator);
						Electronic electronic = new Electronic();
						eView.display(electronic);
						showView();
						break;
					case 2: //Hiển thị hàng thực phẩm
						CostComparator costComparator = new CostComparator();
						Collections.sort(fControll.getAll(), costComparator);
						Food food = new Food();
						fView.display(food);
						showView();
						break;
					case 3: //hiển thị tất cả
						ViewAll viewAll = new ViewAll();
						viewAll.displayAll();
						showView();
						break;
					case 4: break;
					default:
						System.out.println("Wrong Choice! Try Again!");
						showView();
						break;	
					}
				};
				showMenu();
				break;
			case 3:
				System.out.println("ĐÃ THOÁT!");
				break;
			default:
				System.err.println("Wrong Choice! Try Again!");
				showMenu();
				break;
			}			
		
		} while (choice != 3);
		
	}

}
