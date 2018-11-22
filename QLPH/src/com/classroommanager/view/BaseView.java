package com.classroommanager.view;

import com.classroommanager.exception.NegativeException;
import com.classroommanager.model.Room;

public interface BaseView <T extends Room> {
	
	T input(T room) throws NegativeException;
	void viewRoom(String code);
	
}
