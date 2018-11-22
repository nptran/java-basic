package com.studentmanagement.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.studentmanagement.model.Person;
import com.studentmanagement.model.Student;
import com.studentmanagement.view.StudentView;

public class IOStudent {

	public void OStudent(List<Student> students) throws IOException{
		ObjectOutputStream obO = null;
		StudentView view = new StudentView();
		Student student = new Student();
		try {
			student = view.input(student);
			students.add(student);
			obO = new ObjectOutputStream(new FileOutputStream("C://Users//Admin//Desktop//student-details.txt", true));
			obO.writeObject(students);
			obO.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		obO.close();
	}
	
	@SuppressWarnings("resource")
	public void Clear() throws IOException {	
		Writer clear = null;	
		clear = new FileWriter("C://Users//Admin//Desktop//student-details.txt");
		clear.write("");
	}
	
	public List<Student> IStudent () throws IOException, ClassNotFoundException {
		List<Student> students = new ArrayList<>();
		Student student = null;
		ObjectInputStream obI = null;
		try {
			FileInputStream fis = new FileInputStream("C://Users//Admin//Desktop//student-details.txt");
			obI = new ObjectInputStream(fis);
		
			while (fis.available() != 0) {
				student = (Student) obI.readObject();
				students.add(student);
			}
		} catch (ClassNotFoundException | NullPointerException e) {
			e.printStackTrace();
		}
		obI.close();
		return students;
	}

//
//		    List<Student> students = new ArrayList<>(); 
//		    FileInputStream fis = new FileInputStream("C://Users//Admin//Desktop//student-details.txt");
//		    ObjectInputStream ois = new ObjectInputStream(fis);
//
//		    Object obj =null;
//
//		    boolean isExist = true;
//
//		    while(isExist) {
//		        if(fis.available() != 0){
//		        	obj = ois.readObject();
//		        	students.add((Student) obj);
//		        }
//		        else{
//		        isExist =false;
//		        }
//		    }
//		    ois.close();
//		    return students;     
//		}
	
	public void show(List<Student> students) {
		try {
			for (Student student : students) {
				System.out.println("Code:" + student.getCode() + "| Name: " + student.getName() 
								+ "| Gender:" + student.getGender() 
								+ "| Date of Birth: " + student.getDob() 
								+ "| Score: " + student.getScore());
			}
		}
		catch (NullPointerException e) {
			System.out.println("File is Empty.");
		}
	}
}
