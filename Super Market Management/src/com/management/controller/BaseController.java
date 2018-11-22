package com.management.controller;

import java.util.List;

public interface BaseController <T> {
	
	public void add(T obj);
	
	public List<T> getAll();
	
}
