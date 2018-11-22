package baitapso1;

public class Bai20 {
	
	private static final int MAX = 50;
	
	private static int position(int[] arr, int number) {
		int distance = 0;
		int position = 0;
		for (int i=0; i <arr.length; i++) {
			if (Function.isPrime(arr[i])) {
				distance = arr[i] - number;
				position = i;
				break;
			}
		}
		for (int i=0; i <arr.length; i++) {
			if (Function.isPrime(arr[i])) {
				if (distance > Math.abs(arr[i] - number)) {
					position = i;
				}
			}
		}
		return position;
	}
	
	private static void primeElement(int[] arr) {
		System.out.println("Các phần tử nguyên tố: ");
		for (int i=0; i<arr.length; i++) {
			if (Function.isPrime(arr[i]))
				System.out.println(i + ". " +arr[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = Function.random(MAX, 4);
		primeElement(arr);
		int x = Function.inputNum(0, 4);
		
		System.out.printf("Số nguyên tố gần nhất với %d là %d ở vị trí %d.", x, arr[position(arr, x)], position(arr, x));
	}
}
