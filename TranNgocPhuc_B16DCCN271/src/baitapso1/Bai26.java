package baitapso1;

import java.util.Random;

import baitapso1.model.Matrix;

public class Bai26 {
	
	private static final int MAX = 50;
	
	public static void main(String[] args) {
		Matrix mat = new Matrix();
		Random random = new Random();
		
		mat = mat.spiral(random.nextInt(MAX));
		mat.show();
	}

}
