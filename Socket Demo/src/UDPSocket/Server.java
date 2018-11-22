package UDPSocket;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import Model.Student;

class Server {
	public static void main(String args[]) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(9876);
		System.out.println("Waiting Connection...");
		byte[] receiveData = new byte[1024];

		while (true) {

			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);

			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			
			ObjectInputStream iStream = new ObjectInputStream(new ByteArrayInputStream(receivePacket.getData()));
			Student student = (Student) iStream.readObject();
//			student = InputStudent.input();
			System.out.println(student.getCode() + " | " + student.getName() + " | " + student.getGender() + " | " + student.getDob());
			ByteArrayOutputStream bStream = new ByteArrayOutputStream();
			ObjectOutput oo = new ObjectOutputStream(bStream); 
			oo.writeObject(student);
			oo.close();

			byte[] serializedStudent = bStream.toByteArray();
			iStream.close();
			
			DatagramPacket sendPacket = new DatagramPacket(serializedStudent, serializedStudent.length, IPAddress, port);
			serverSocket.send(sendPacket);
			
			serverSocket.close();
		}
	}
}
