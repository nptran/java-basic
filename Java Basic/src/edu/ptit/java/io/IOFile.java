/**
 * 
 */
package edu.ptit.java.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Phuc Tran
 *
 */
public class IOFile {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input= new Scanner(new File("C:\\Users\\Admin\\Desktop\\logs\\testlog.log"));
		//doc du lieu tu file theo dong (line-based)
		while(input.hasNextLine()) {
			String n = input.nextLine();
			System.out.println(n);
		}
		File file = new File("C:\\Users\\Admin\\Desktop\\logs\\testio.txt");
		
		//Viet du lieu ra file
//		PrintWriter writer = new PrintWriter(new File("data.txt"));
//		writer.close(); //must be closed
	}

}
