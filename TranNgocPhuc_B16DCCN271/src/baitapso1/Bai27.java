package baitapso1;

public class Bai27 {
	public static void main(String[] args) {
//		int minVal = (int) Math.pow(10, 5);
//		int maxVal = (int) Math.pow(10,6)-1;
		int minVal = 100000;
		int maxVal = 999999;
		for (int i = minVal; i <=maxVal; i++) {
			if (Function.reversible(i)) {
				System.out.println(i);
			}
		}
		
	}
}
