package qlsv.jdbc.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import qlsv.jdbc.process.Add;
import qlsv.jdbc.process.Delete;
import qlsv.jdbc.process.Update;

public class Database {

	// JDBC driver name and database URL
	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost:3306/sample";

	// Database Credentials
	static final String USER = "root";
	static final String PASS = "31101998";

	private static Scanner scanner = new Scanner(System.in);

	private static void showMenu() {
		System.out.println("1. Add");
		System.out.println("2. Update");
		System.out.println("3. Delete");
		System.out.println("4. Exit");
	};

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

		showMenu();
		int choice = 0;

		do {
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {

			case 1: // ADD
				Add add = new Add();
				add.insert(connector, preparedStatement);
				showMenu();
				break;

			case 2: // UPDATE
				Update update = new Update();
				update.update(connector, preparedStatement);
				showMenu();
				break;

			case 3: // DELETE
				Delete delete = new Delete();

				delete.deleteChoice();
				int delChoice = scanner.nextInt();
				scanner.nextLine();

				switch (delChoice) {
				case 1:
					delete.deleteByID(connector, preparedStatement);
					break;
				case 2:
					delete.deleteByName(connector, preparedStatement);
					break;
				case 3:
					delete.deleteByAge(connector, preparedStatement);
					break;
				default:
					break;
				}

				showMenu();
				break;

			case 4:
				if (connector != null) {
					try {
						System.out.println("Disconnection...");
						connector.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				System.out.println("CLOSED!");
				break;
			default:
				System.out.println("Wrong choice");
				showMenu();
				break;
			}

		} while (choice != 4);

	}

}
