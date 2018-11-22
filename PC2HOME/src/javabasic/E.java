package javabasic;

import java.util.Scanner;

import javabasic.view.Function;

public class E {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int test=scanner.nextInt();
		while (test-->0) {
			int a=scanner.nextInt(), b=scanner.nextInt(), count=0;
			for (int i=(b>a)?a:b; i<=((b>a)?b:a); i++) {
				if(Function.thuanNT(i)) count++;
			}
			System.out.println(count);
		}
		scanner.close();
	}
	
}
