package qlsv.jdbc.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
	
	
	private static Scanner scanner = new Scanner(System.in);
	
	public void deleteChoice() {
		System.out.println("1. Delete by id");
		System.out.println("2. Delete by name");
		System.out.println("3. Delete by age");
		// System.out.println("4. Clear the table");
	}
	
	static String sqlDelete = "DELETE FROM `sample`.`student` WHERE id = ? OR name = ? OR age = ?";

	public void deleteByID(Connection connector, PreparedStatement preparedStatement) {
		try {
			System.out.println("Enter id you want to delete: ");
			int id = scanner.nextInt();
			scanner.nextLine();

			preparedStatement = connector.prepareStatement(sqlDelete);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, null);
			preparedStatement.setInt(3, 0);
		
				preparedStatement.execute();
				System.out.println("DELETED!");
			
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
	
	public void deleteByName(Connection connector, PreparedStatement preparedStatement) {	
		try {
			System.out.println("Enter name you want to delete: ");
			String name = scanner.nextLine();

			preparedStatement = connector.prepareStatement(sqlDelete);
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, 0);

			System.out.println(
					"Sure you want to delete these names? All datas of its will be deleted too. Press 'Y' to accept!");
			String confirm = scanner.nextLine();
			if (confirm.equalsIgnoreCase("Y")) {
				preparedStatement.execute();
				System.out.println("DELETED!");
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
	
	public void deleteByAge(Connection connector, PreparedStatement preparedStatement) {
		try {
			System.out.println("Enter age you want to delete: ");
			int age = scanner.nextInt();
			scanner.nextLine();

			preparedStatement = connector.prepareStatement(sqlDelete);
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, null);
			preparedStatement.setInt(3, age);

			System.out.println(
					"All the students are " + age + " will be deleted. Are you sure? Press 'Y' to accept!");
			String confirm = scanner.nextLine();
			if (confirm.equalsIgnoreCase("Y")) {
				preparedStatement.execute();
				System.out.println("DELETED!");
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
	
	/*
	 * //CLEAR THE TABLE -- DISABLE SAFE MODE to do this try
	 * { preparedStatement =
	 * connector.prepareStatement("DELETE FROM `sample`.`student`");
	 * System.out.println("CLEARED!") } catch (SQLException e1) {
	 * e1.printStackTrace(); }
	 * 
	 * break;
	 */
	
}
