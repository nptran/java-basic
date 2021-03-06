package baitapso1;

public class Bai19 {
	
	private static final int MAX = 1000;
	
	public static void mostAppear(int[] arr) {
		int index = 0;
		int appearMost = 0;
		int elementMost = 0;
		int[] appears = new int[arr.length];
		
		for (int i =0; i< arr.length; i++) {
			int appear =1;
			for (int j =i; j < arr.length; j++) {
				if(arr[j] == arr[i] && j!=i) {
					appear++;
				}
			}
			appears[index++] = appear;
		}
		
		for (int i =0; i<index; i++) {
			if (appears[i] > appearMost) {
				appearMost =appears[i];
				elementMost =arr[i];
			}
		}
		if (appearMost == 1) {
			System.out.println("Tần suất xuất hiện các phần tử như nhau.");
		}
		else {
			System.out.printf("Phần tử %d xuất hiện nhiều nhất với %d lần.", elementMost, appearMost);
		}
	}
	
	public static void main(String[] args) {
		int[] a = Function.random(MAX, 3);
		
		mostAppear(a);
	}

}
