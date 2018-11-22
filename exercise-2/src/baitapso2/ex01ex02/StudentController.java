package baitapso2.ex01ex02;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
	
	private List<Student> students;
	private static StudentController instance;
	
	private StudentController() {
		students = new ArrayList<>();
	}
	
	public static StudentController getInstance() {
		if(instance==null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	public void add(Student student) {
		students.add(student);
	}
	
	//lay danh sach toan bo sinh vien
	public List<Student> getAll() {
		return students;
	}
	
}
