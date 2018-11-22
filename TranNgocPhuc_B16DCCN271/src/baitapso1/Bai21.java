package baitapso1;

public class Bai21 {
	
	private static final int MAX = 500;
	
	public static void main(String[] args) {
		int[] arr = Function.random(MAX, 3);
		arr = Function.sort(arr, 1);
		arr = Function.toUnique(arr);
		Function.showArray(arr);
	}
	
}
