package com.marketmanager.product.comparator;

import java.util.Comparator;

import com.marketmanager.product.model.Food;
public class CostComparator implements Comparator<Food> {

	@Override
	public int compare(Food o1, Food o2) {
		if(o1.getCost() > o2.getCost())
			return -1;
		else if(o1.getCost() == o2.getCost())
			return 0;
		else 
			return 1;
	}

}
