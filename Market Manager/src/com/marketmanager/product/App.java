package com.marketmanager.product;

import com.marketmanager.product.exception.NegativeException;
import com.marketmanager.product.view.Display;

public class App {

	public static void main(String[] args) throws NegativeException {
		
		Display display = new Display();
		display.run();

	}

}
