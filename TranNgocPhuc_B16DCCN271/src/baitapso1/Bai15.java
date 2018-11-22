package baitapso1;

public class Bai15 {
	
	//to check a number only with digits 0,6,8
	private static boolean checkDigits(int number) {
		int digit = 0;
		while (number!=0) {
			digit = number%10;
			number/=10;
			
			if(digit!=0 && digit!=6 && digit!=8) {
				return false;
			}
		}
		
		return true;
	}
	
	private static void printNumber(int from, int to) {
		for (int i=from; i<=to; i++) {
			if (Function.reversible(i) && checkDigits(i) && Function.sumOfDigits(i, 0)%10==0) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		printNumber(1000000, 999999999);
	}
	
}
