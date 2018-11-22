package baitapso1;

public class Bai16 {
	
	private static boolean checkDigits(int number) {
		int digit = 0;
		while (number!=0) {
			digit = number%10;
			number/=10;
			
			if(!Function.isPrime(digit)) {
				return false;
			}
		}
		
		return true;
	}
	
	private static void printNumber(int from, int to) {
		for (int i=from; i<=to; i++) {
			if(Function.isPrime(i) && Function.isPrime(Function.reverse(i)) && checkDigits(i)) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		printNumber(1000000, 9999999);
	}

}
