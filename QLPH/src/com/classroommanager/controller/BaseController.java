package com.classroommanager.controller;

import java.util.List;
import com.classroommanager.model.Room;

public interface BaseController <T extends Room> {
	
	void add(T room);
	List<T> getAll();
	
	
}
