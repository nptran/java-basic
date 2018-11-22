/**
 * 
 */
package edu.ptit.java.generic;

import java.util.Scanner;

/**
 * @author Phuc Tran
 *
 */
public class QuanLyBTL {
	
	private static Scanner scanner = new Scanner(System.in);
	private static void showMenu() {
		System.out.println("1. Thêm sinh viên");
		System.out.println("2. Thêm BTL");
		System.out.println("3. Ghép sinh viên với BTL");
		System.out.println("4. Hiển thị danh sách sinh viên với BTL");
		System.out.println("5. Thoát");
	}
	
	public static void main(String[] args) {
		SinhVien sv = new SinhVien();
		BTL btl = new BTL();
		PairCustom pairCustom = new PairCustom();
		int choice = 0;
		
		while(choice!=5) {
			showMenu();
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				sv.input();
				break;
			case 2:
				btl.input();
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				System.out.println("===============ĐÃ THOÁT===============");
				break;
			default:
				System.out.println("Lựa chọn sai!!!");
				break;
			}
		}
		
		sv.input();
		
	}
	
}
