package baitapso1;

public class Bai14 {
	
	private static void printNumber(int from, int to) {
		for(int i=from; i<=to; i++) {
			if (Function.reversible(i) && Function.sumOfDigits(i, 0)%10==0) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		printNumber(100000, 999999);
	}

}
