package com.management.controller;

import java.util.ArrayList;
import java.util.List;

import com.management.model.Item;

public class ItemController implements BaseController<Item> {

	public static ItemController instance;
	
	private List<Item> items;
	private ItemController() {
		items = new ArrayList<>();
	}
	
	public static ItemController getInstance() {
		if(instance == null) {
			instance = new ItemController();
		}
		return instance;
	}
	
	@Override
	public void add(Item item) {
		items.add(item);
	}

	@Override
	public List<Item> getAll() {
		return items;
	}

}
