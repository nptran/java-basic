package baitapso1;

public class Bai22 {
	private static final int MAX = 50;
	
	public static void main(String[] args) {
		System.out.printf("\nNhập Mảng A\n");
		int[] arrA = Function.inputArray(MAX-1, 0);
		
		System.out.printf("\nNhập Mảng B\n");
		int[] arrB = Function.inputArray(MAX-2, 0);
		
		System.out.printf("\nNhập vị trí chèn\n");
		int p = Function.inputNum(MAX-3, 0);
		
		arrA = Function.insertArray(arrB, arrA, p);
		System.out.println();
		Function.showArray(arrA);
		
	}
}
