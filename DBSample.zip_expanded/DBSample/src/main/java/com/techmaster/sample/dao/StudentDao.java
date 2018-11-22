package com.techmaster.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.techmaster.sample.model.Student;
import com.techmaster.sample.utils.DBUtils;

public class StudentDao {
	private Connection connection;

	public StudentDao() {
		connection = DBUtils.getConnection();
	}

	public void insertStudent(Student student) {
		try {
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO student(name, class_id) VALUES (?, ?)");
			stmt.setString(1, student.getName());
			stmt.setInt(2, student.getStudentClass().getId());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
