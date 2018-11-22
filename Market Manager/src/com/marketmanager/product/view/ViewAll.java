package com.marketmanager.product.view;

import java.util.ArrayList;
import java.util.List;
import com.marketmanager.product.controller.ElectronicController;
import com.marketmanager.product.controller.FoodController;
import com.marketmanager.product.model.Product;

public class ViewAll {

	public void displayAll() {
		
		System.out.println("_______DANH SÁCH TẤT CẢ MẶT HÀNG_______");
		if(getAll().isEmpty()) System.out.println("TRỐNG!!!");
		else {
		for(Product product : getAll())
			System.out.println(product.getCode() + " "
					+ product.getName());
		}
	}

	public List<Product> getAll() {
		ElectronicController ec = ElectronicController.getInstance();
		FoodController fc = FoodController.getInstance();
		List<Product> products = new ArrayList<>();
		products.addAll(ec.getAll());
		products.addAll(fc.getAll());
		return products;
	}
	
}
