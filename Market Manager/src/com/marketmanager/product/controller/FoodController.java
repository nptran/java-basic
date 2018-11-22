package com.marketmanager.product.controller;

import java.util.ArrayList;
import java.util.List;

import com.marketmanager.product.model.Food;

public class FoodController implements BaseController<Food>{

	private List<Food> foods;
	private static FoodController instance;
	
	private FoodController() {
		foods = new ArrayList<>();
	}
	
	public static FoodController getInstance() {
		if (instance == null) {
			instance = new FoodController();
		}
		return instance;
	}
	
	@Override
	public void add(Food product) {
		foods.add(product);
	}

	@Override
	public List<Food> getAll() {
		return foods;
	}

}
