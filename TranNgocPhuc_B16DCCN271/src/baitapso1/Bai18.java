package baitapso1;

public class Bai18 {
	
	private static final int MAX = 50;
	
	private static void output(int[] arr) {
		System.out.print("KẾT LUẬN: ");
		if (Function.reversible(arr)) {
			System.out.println("Mảng đối xứng");
		}
		else System.out.println("Mảng không đối xứng");
	}
	
	public static void main(String[] args) {
		int[] a = Function.random(MAX, 3);
	
		output(a);
	}
}
