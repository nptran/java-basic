package edu.ptit.java.generic;

import java.util.Scanner;

/**
 * @author Phuc Tran
 *
 */
public class BTL extends BaseInfo<BTL>{

	private static Scanner scanner = new Scanner(System.in);
	private int time;	
	
	public BTL() {}
	
	public int getTime() {
		return time;
	}

	private BTL(int code, String name, int time) {
		this.code = code;
		this.name = name;
		this.time = time;
	}
	
	@Override
	public void input() {
		System.out.println("Mã BT: ");
		int code = scanner.nextInt(); scanner.nextLine();
		System.out.println("Tên BT: ");
		String name = scanner.nextLine();
		System.out.println("Thời hạn (ngày): ");
		int time = scanner.nextInt(); scanner.nextLine();
		BTL btl = new BTL(code, name, time);
		add(btl);
	}
	
	@Override
	public String toString() {
		return "MBT: "+code+" | Tên BT: "+name+" | Thời hạn: "+time+" ngày";
	}

}
