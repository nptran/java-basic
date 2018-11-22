package com.classroommanager;

import com.classroommanager.exception.NegativeException;
import com.classroommanager.view.Display;

public class App {
	public static void main(String[] args) throws NegativeException {
		Display display = new Display();
		display.run();
		
	}
}
