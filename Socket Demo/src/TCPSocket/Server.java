package TCPSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Model.Student;

public class Server {

	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Student student = null;
		Socket socket = null;

		try {

			ServerSocket serverSocket = new ServerSocket(1230);

			System.err.println("Server waitting...");
			socket = serverSocket.accept();

			System.out.println("Connected!");
			ObjectInputStream serverobi = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream serverobo = new ObjectOutputStream(socket.getOutputStream());

			student = (Student) serverobi.readObject();

			student.setCode("new");
			student.setName("new");
			student.setGender("new");
			LocalDate dob = LocalDate.parse("31/10/98", DATE_FORMATTER);
			student.setDob(dob);
			
			serverobo.writeObject(student);
			System.out.println("Done!");

			serverobi.close();
			serverobo.close();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
