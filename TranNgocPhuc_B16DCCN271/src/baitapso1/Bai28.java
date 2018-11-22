package baitapso1;

import java.util.Random;

public class Bai28 {
	public static void main(String[] args) {
		int[] num1 = Function.bigRandom(10, 15);
		System.out.println("Số thứ nhất đã được tạo:");
		Function.showBigNum(num1);
		System.out.println();
		
		int[] num2 = Function.bigRandom(10, 15);
		System.out.println("Số thứ hai đã được tạo:");
		Function.showBigNum(num2);
		System.out.println();
		
		System.out.println("Tổng 2 số trên là:");
		int[] ans = Function.sum(num1, num2);
		Function.showBigNum(ans);
		
	}
}
