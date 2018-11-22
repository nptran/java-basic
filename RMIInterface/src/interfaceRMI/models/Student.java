package interfaceRMI.models;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	private String name;
	
	private int age;
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}

}
