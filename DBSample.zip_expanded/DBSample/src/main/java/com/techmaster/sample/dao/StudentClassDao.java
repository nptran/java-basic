package com.techmaster.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.techmaster.sample.model.StudentClass;
import com.techmaster.sample.utils.DBUtils;

public class StudentClassDao {

	private Connection connection;

	public StudentClassDao() {
		connection = DBUtils.getConnection();
	}

	public void addClass(StudentClass studentClass) {
		try {
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO student_class(name) VALUES (?)");
			stmt.setString(1, studentClass.getName());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public StudentClass getByName(String name) {
		StudentClass stdClass = null;
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM student_class WHERE name = ?");
			stmt.setString(1, name);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				stdClass = new StudentClass();
				stdClass.setId(rs.getInt("id"));
				stdClass.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stdClass;
	}

}
