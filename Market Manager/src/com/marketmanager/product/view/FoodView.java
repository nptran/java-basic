package com.marketmanager.product.view;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

import com.marketmanager.product.controller.FoodController;
import com.marketmanager.product.exception.NegativeException;
import com.marketmanager.product.model.Food;

public class FoodView implements BaseView <Food> {
	
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy");
	private Scanner sc = new Scanner(System.in);
	private FoodController fController = FoodController.getInstance();
	
	@Override
	public Food input() throws NegativeException {
		Food food = new Food();
		
		System.out.println("Mã Sản Phẩm");
		String code = sc.nextLine();
		
		System.out.println("Tên Sản Phẩm:");
		String name = sc.nextLine();
		
		LocalDate exp;
		try {
			System.out.println("Hạn Sử Dụng:");
			exp = LocalDate.parse(sc.nextLine(), DATE_FORMATTER);
		} catch (DateTimeParseException e) {
			throw new NegativeException ("Định Dạng Không Đúng!!!");
		}
		
		int cost;
		try { 
			System.out.println("Giá Tiền:");
			cost = sc.nextInt();
			sc.nextLine();
		} catch (NumberFormatException e) {
			throw new NegativeException("Định Dạng Không Đúng!!!");
		}
		
		if(code.isEmpty() || name.isEmpty() || String.valueOf(exp).isEmpty() || String.valueOf(cost).isEmpty()) {
			throw new NegativeException("KHÔNG ĐƯỢC BỎ TRỐNG BẤT KỲ TRƯỜNG NÀO!!!");
		}
		
		food.setCode(code);
		food.setName(name);
		food.setExp(exp);
		food.setCost(cost);
		
		return food;
	}
	@Override
	public void display(Food product) {
		
		Locale loc = new Locale("vi", "VN");
		NumberFormat vnd = NumberFormat.getCurrencyInstance(loc);
		
		System.out.println("______DANH SÁCH MẶT HÀNG THỰC PHẨM______");
		if(fController.getAll().isEmpty()){
			System.out.println("TRỐNG!!!");
		}
		else {
		for (Food f : fController.getAll())
			System.out.println(f.getCode() + " "
							+ f.getName() + " "
							+ f.getExp() + " "
							+ vnd.format(f.getCost()));
		}
	}
	
}
