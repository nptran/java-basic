package TCPSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Model.InputStudent;
import Model.Student;

public class Client {

	static Socket clientsocket = null;

	public static void main(String[] args) {
		Student student = InputStudent.input();
		System.out.println(
				student.getCode() + " | " + student.getName() + " | " + student.getGender() + " | " + student.getDob());

		try {
			System.err.println("Connecting to server...");
			clientsocket = new Socket("LocalHost", 1230);

			System.out.println("Connected!");
			
			ObjectOutputStream clientoutputstream = new ObjectOutputStream(clientsocket.getOutputStream());			
			ObjectInputStream clientinputstream = new ObjectInputStream(clientsocket.getInputStream());

			clientoutputstream.writeObject(student);
			
			student = (Student) clientinputstream.readObject();

			System.out.println("Back from server: ");
			System.out.println(student.getCode() + " | " + student.getName() + " | " + student.getGender() + " | "
					+ student.getDob());

			
			clientoutputstream.close();
			clientinputstream.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				clientsocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
