package com.marketmanager.product.view;

import com.marketmanager.product.exception.NegativeException;
import com.marketmanager.product.model.Product;

public interface BaseView <T extends Product> {
	
	T input() throws NegativeException;
	void display(T product);

}
