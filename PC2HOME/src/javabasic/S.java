package javabasic;

import java.util.Scanner;

public class S {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		while (t-->0) {
			String s = scanner.nextLine();
			s = s.trim();
			s = s.replaceAll("\\s+"," ");
			String[] a = s.split("[ ]");
			System.out.println(a.length);
		}
		scanner.close();
	}
}
