package com.marketmanager.product.view;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import com.marketmanager.product.controller.ElectronicController;
import com.marketmanager.product.exception.NegativeException;
import com.marketmanager.product.model.Electronic;

public class ElectronicView implements BaseView<Electronic> {

	private static Scanner sc = new Scanner(System.in);
	private ElectronicController eController = ElectronicController.getInstance();
	
	@Override
	public Electronic input() throws NegativeException {

		Electronic electronic = new Electronic();
		
		System.out.println("Mã Sản Phẩm:");
		String code = sc.nextLine();
		
		System.out.println("Tên Sản Phẩm:");
		String name = sc.nextLine();
				
		System.out.println("Nhãn Hiệu:");
		String brand = sc.nextLine();
		
		System.out.println("Màu sắc:");
		String color = sc.nextLine();
		
		int cost;
		try {
			System.out.println("Giá tiền:");
			cost = sc.nextInt();
			sc.nextLine();
		} catch (NumberFormatException e) {
			throw new NegativeException ("Định Dạng Không Đúng!!!");
		}
		
		if(code.isEmpty() || name.isEmpty() || brand.isEmpty() || color.isEmpty() || String.valueOf(cost).isEmpty()) {
			throw new NegativeException("Không được bỏ trống bất kỳ trường nào!!!");
		}
		
		electronic.setCode(code);
		electronic.setName(name);
		electronic.setBrand(brand);
		electronic.setColor(color);
		electronic.setCost(cost);
		
		return electronic;
	}

	@Override
	public void display(Electronic product) {
		
		Locale loc = new Locale("vi", "VN");
		NumberFormat vnd = NumberFormat.getCurrencyInstance(loc);
		
		System.out.println("_______DANH SÁCH MẶT HÀNG ĐIỆN TỬ_______");
		if(eController.getAll().isEmpty()) {
			System.out.println("TRỐNG!!!");
		}
		else {
			for (Electronic e : eController.getAll())
			System.out.println(e.getCode() + " "
							+ e.getName() + " "
							+ e.getBrand() + " "
							+ e.getColor() + " "
							+ vnd.format(e.getCost()) );
		}	
	}

}
