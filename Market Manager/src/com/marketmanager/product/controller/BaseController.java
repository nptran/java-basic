package com.marketmanager.product.controller;

import java.util.List;
import com.marketmanager.product.model.Product;

public interface BaseController<T extends Product> {

	void add(T product);
	List<T> getAll();
	
}
