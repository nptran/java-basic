/**
 * 
 */
package edu.ptit.java.generic;

import java.util.Collections;
import java.util.Scanner;

/**
 * @author Phuc Tran
 *
 */
public class PairCustom extends Pair<SinhVien, BTL>{

	/**
	 * @param first
	 * @param second
	 */

	private static Scanner scanner = new Scanner(System.in);
	
	public PairCustom() {	}
	
	public static void creat() {
		SinhVien s = new SinhVien();
		BTL b = new BTL();
		System.out.println("Nhập mã sinh viên: ");
		int codeS = scanner.nextInt();
		System.out.println("Nhập mã bài tập: ");
		int codeB = scanner.nextInt();
		
		for(SinhVien sv : s.getList()) {
			if(sv.getCode()==codeS);
		}
		
	}
	
	@Override
	public void create(SinhVien t, BTL s) {
		if(t.getList().contains(t) && s.getList().contains(s)) {
			super.create(t, s);
		}
	}
	
	@Override
	public void printList() {
		TimeComparator time = new TimeComparator();
		Collections.sort(getList(), time);
		for (Pair<SinhVien, BTL> e : getList()) {
			System.out.println(e);
		}
	}

}
