package com.marketmanager.product.comparator;

import java.util.Comparator;

import com.marketmanager.product.model.Electronic;

public class NameComparator implements Comparator<Electronic> {

	@Override
	public int compare(Electronic o1, Electronic o2) {
		return (o1.getName().compareTo(o2.getName()));
	}
	
}
