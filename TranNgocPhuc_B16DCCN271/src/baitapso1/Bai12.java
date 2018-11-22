package baitapso1;

public class Bai12 {
	

	//to print reversible numbers
	private static void printNumber(int from, int to) {
		for (int i = from; i<=to; i++) {
			if (Function.reversible(i))
				System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		printNumber(100000, 999999);
	}

}
