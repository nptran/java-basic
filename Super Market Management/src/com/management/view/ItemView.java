package com.management.view;

import java.util.Scanner;

import com.management.controller.ItemController;
import com.management.model.Item;

public class ItemView implements BaseView<Item> {

	private static Scanner scanner = new Scanner(System.in);

	private ItemController itemController = ItemController.getInstance();
	
	@Override
	public void input() {
		Item item = new Item();
		
		System.out.println("Name Item: ");
		String name = scanner.nextLine();
		System.out.println("Group: ");
		String group = scanner.nextLine();
		System.out.println("Cost: ");
		int cost = scanner.nextInt();
		scanner.nextLine();
		
		item.setName(name);
		item.setGroup(group);
		item.setCost(cost);
		boolean check = false;
		for (Item i : itemController.getAll()) {
			if(item.getName().equals(i.getName())) {
					item.setCode(i.getCode());
					check = true;
			}
		}
		System.out.println(check);
		if (check==false) {
			++Item.code;
			item.setCode(Item.code);
		}
		
		itemController.add(item);
	}

	@Override
	public void showList() {
		for(Item item : itemController.getAll()) {
			System.out.printf("\nCODE: " + item.getCode() + "\nName Item: " + item.getName() + "\nGroup: " + item.getGroup() + "\nCost: " + item.getCost() + "\n");
		}
		
	}

}
