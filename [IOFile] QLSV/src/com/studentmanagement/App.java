package com.studentmanagement;

import java.io.IOException;

import com.studentmanagement.view.Display;

public class App {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Display display = new Display();
		display.run();
	}
}
