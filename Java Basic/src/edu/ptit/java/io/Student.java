/**
 * 
 */
package edu.ptit.java.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Phuc Tran
 *
 */
public class Student {
	
	private int id;
	
	private String name; 
	
	private String group;
	
	private double mark;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	public void doc(Scanner in) throws FileNotFoundException {
			setName(in.next());
			setGroup(in.next());
			setMark(in.nextDouble());
	}
	
	public void ghi(PrintWriter out) {
		 out.println(id);
		 out.println(name);
		 out.println(group);
		 out.println(mark);
		 out.println();
	}
	
	
}
