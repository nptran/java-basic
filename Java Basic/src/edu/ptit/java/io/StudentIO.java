/**
 * 
 */
package edu.ptit.java.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Phuc Tran
 *
 */
public class StudentIO {
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("C:\\Users\\Admin\\Desktop\\logs\\student.txt"));
		PrintWriter out = new PrintWriter("C:\\Users\\Admin\\Desktop\\logs\\newstudent.txt");
		Student ds[] = new Student[100];
		int i =0, index=1000;
		
		while(scanner.hasNextLine()) {
			ds[i] = new Student();
			ds[i].doc(scanner);
			ds[i].setId(index++);
			ds[i].ghi(out);
			i++;
		}
		out.close();
		
	}

}
