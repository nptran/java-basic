package edu.ptit.java.generic;

import java.util.Scanner;

/**
 * @author Phuc Tran
 *
 */
public class SinhVien extends BaseInfo<SinhVien>{

	private static Scanner scanner = new Scanner(System.in);
	private String group;
	
	public SinhVien(int code, String name, String group) {
		this.code = code;
		this.name = name;
		this.group = group;
	}

	public SinhVien() {	}

	@Override
	public void input() {
		System.out.println("Mã SV: ");
		int code = scanner.nextInt(); scanner.nextLine();
		System.out.println("Tên: ");
		String name = scanner.nextLine();
		System.out.println("Lớp: ");
		String group = scanner.nextLine();
		SinhVien sv = new SinhVien(code, name, group);
		add(sv);
	}
	
	@Override
	public String toString() {
		return "MSV: " + code +" | Tên: "+name+" | Lớp: "+group;
	}

}
