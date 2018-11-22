package qlsv.jdbc.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import qlsv.jdbc.model.Student;
import qlsv.jdbc.view.inputStudent;

public class Update {
	
	static String sqlUpdate = "UPDATE `sample`.`student` SET id = ?, name = ?, age = ? WHERE id = ?";
	
	static inputStudent input = new inputStudent();
	
	private static Scanner scanner = new Scanner(System.in);
	
	public void update(Connection connector, PreparedStatement preparedStatement) {
		
		System.out.println("Enter id you want to update: ");
		int updateId = scanner.nextInt();
		scanner.nextLine();

		try {
			String check = "SELECT * FROM `sample`.`student` WHERE id = ?";
			preparedStatement = connector.prepareStatement(check);
			preparedStatement.setInt(1, updateId);
			preparedStatement.execute();

			ResultSet rs = preparedStatement.executeQuery("SELECT id FROM `sample`.`student`");
			String resultUpdate = null;
			while (rs.next()) {

				if (updateId == rs.getInt("id")) {
					System.out.println("==============Enter New Information Below===============");
					Student updateStudent = input.input();

					preparedStatement = connector.prepareStatement(sqlUpdate);
					preparedStatement.setInt(1, updateStudent.getCode());
					preparedStatement.setString(2, updateStudent.getName());
					preparedStatement.setInt(3, updateStudent.getAge());
					preparedStatement.setInt(4, updateId);

					preparedStatement.execute();
					resultUpdate = "UPDATED";
					System.out.println(resultUpdate);
				}
			}
			if (resultUpdate == null) {
				System.out.println("ID is NOT exist!!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
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
