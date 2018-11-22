package qlsv.jdbc.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import qlsv.jdbc.model.Student;
import qlsv.jdbc.view.inputStudent;

public class Add {
	
	static inputStudent input = new inputStudent();
	
	private static Scanner scanner = new Scanner(System.in);
	
	public void insert(Connection connector, PreparedStatement preparedStatement) {
		
		Student student = input.input();
		
		String sqlInsert = "INSERT INTO `sample`.`student`(`id`,`name`,`age`) VALUES(?, ?, ?)";
		String sqlUpsert = "INSERT INTO student(id, name, age) VALUES(?, ?, ?) ON DUPLICATE KEY UPDATE name = ?, age = ?";
		
		try {
			preparedStatement = connector.prepareStatement(sqlInsert);
			preparedStatement.setInt(1, student.getCode());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setInt(3, student.getAge());

			preparedStatement.execute();
			System.out.println("ADDED!");

		} catch (SQLException e) {
			System.out.println("ID already exists. Overwrite it? Y/N");
			String confirm = scanner.nextLine();

			if (confirm.equalsIgnoreCase("Y")) {
				try {
					preparedStatement = connector.prepareStatement(sqlUpsert);
					preparedStatement.setInt(1, student.getCode());
					preparedStatement.setString(2, student.getName());
					preparedStatement.setInt(3, student.getAge());
					preparedStatement.setString(4, student.getName());
					preparedStatement.setInt(5, student.getAge());

					preparedStatement.execute();
					System.out.println("OVERWRITED!");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
