package baitapso1;

import baitapso1.model.Matrix;

public class Bai25 {
	
	public static void main(String[] args) {
		Matrix matrix1 = new Matrix();
		Matrix matrix2 = new Matrix();
		matrix1.input();
		matrix2.input();
		Matrix matrix3 = new Matrix();
		matrix3 = matrix1.mul(matrix2);
		matrix3.show();
	}
}
