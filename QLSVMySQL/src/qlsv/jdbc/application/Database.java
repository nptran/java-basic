package qlsv.jdbc.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import qlsv.jdbc.model.Student;
import qlsv.jdbc.view.inputStudent;

public class Database {

	// JDBC driver name and database URL
	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost:3306/sample";

	private static Scanner scanner = new Scanner(System.in);
	// Database Credentials
	static final String USER = "root";
	static final String PASS = "31101998";

	private static void showMenu() {
		System.out.println("1. Add");
		System.out.println("2. Update");
		System.out.println("3. Delete");
		System.out.println("4. Exit");
	};

	private static void deleteChoice() {
		System.out.println("1. Delete by id");
		System.out.println("2. Delete by name");
		System.out.println("3. Delete by age");
		// System.out.println("4. Clear the table");
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Connection connector = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName(JDBC_DRIVER);
			connector = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		inputStudent input = new inputStudent();

		String sqlInsert = "INSERT INTO `sample`.`student`(`id`,`name`,`age`) VALUES(?, ?, ?)";
		String sqlUpdate = "UPDATE `sample`.`student` SET id = ?, name = ?, age = ? WHERE id = ?";
		String sqlUpsert = "INSERT INTO student(id, name, age) VALUES(?, ?, ?) ON DUPLICATE KEY UPDATE name = ?, age = ?";
		String sqlDelete = "DELETE FROM `sample`.`student` WHERE ? = ?";

		showMenu();
		int choice = 0;

		do {
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:

				System.out.println("Creating statement...");
				Student student = input.input();

				try {
					preparedStatement = connector.prepareStatement(sqlInsert);
					preparedStatement.setInt(1, student.getCode());
					preparedStatement.setString(2, student.getName());
					preparedStatement.setInt(3, student.getAge());

					preparedStatement.execute();
					System.out.println("ADDED!");

				} catch (SQLException e) {
					System.out.println("ID is exist. Overwrite it? Y/N");
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
				showMenu();
				break;

			case 2: // UPDATE
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
				showMenu();
				break;

			case 3: // DELETE
				deleteChoice();
				int delChoice = scanner.nextInt();
				scanner.nextLine();
				switch (delChoice) {
				case 1: // DELETE BY ID
					try {
						System.out.println("Enter id you want to delete: ");
						int id = scanner.nextInt();
						scanner.nextLine();

						preparedStatement = connector.prepareStatement(sqlDelete);
						preparedStatement.setString(1, "id");
						preparedStatement.setInt(2, id);
						System.out.println(
								"Sure you want to delete this ID? All datas of its will be deleted too. Press 'Y' to accept!");
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
					break;

				case 2: // DELETE BY NAME
					try {
						System.out.println("Enter name you want to delete: ");
						String name = scanner.nextLine();

						preparedStatement = connector.prepareStatement(sqlDelete);
						preparedStatement.setString(1, "name");
						preparedStatement.setString(2, name);

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
					break;

				case 3: // DELETE BY AGE
					try {
						System.out.println("Enter age you want to delete: ");
						int age = scanner.nextInt();
						scanner.nextLine();

						preparedStatement = connector.prepareStatement(sqlDelete);
						preparedStatement.setString(1, "age");
						preparedStatement.setInt(2, age);

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
					break;

				/*
				 * case 4: //CLEAR THE TABLE -- DISABLE SAFE MODE to do this try
				 * { preparedStatement =
				 * connector.prepareStatement("DELETE FROM `sample`.`student`");
				 * System.out.println("CLEARED!") } catch (SQLException e1) {
				 * e1.printStackTrace(); }
				 * 
				 * break;
				 */

				default:
					break;
				}

				showMenu();
				break;

			case 4:
				System.out.println("CLOSED!");
				if (connector != null) {
					try {
						connector.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				break;
			default:
				System.out.println("Wrong choice");
				showMenu();
				break;
			}

		} while (choice != 4);

	}

}
