package UDPSocket;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import Model.InputStudent;
import Model.Student;

class Client {
	public static void main(String args[]) throws Exception {
		//Create a Student
		Student student = InputStudent.input();
		
		//Create an Address and Socket
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("LocalHost");

		//Serialized Student
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		ObjectOutput oo = new ObjectOutputStream(bs); 
		oo.writeObject(student);
		oo.close();
		//Convert Student to byte for sending
		byte[] serializedStudent = bs.toByteArray();
		
		//Send to Server
		DatagramPacket sendPacket = new DatagramPacket(serializedStudent, serializedStudent.length, IPAddress, 9876);		
		System.out.println("Sending to server...");
		clientSocket.send(sendPacket);
		
		
		//Receive from Server
		byte[] studentfromserver = new byte[1024]; //Create new byte array to contain data receive from server 
		DatagramPacket receivePacket = new DatagramPacket(studentfromserver, studentfromserver.length); //Create DatagramPacket
		ByteArrayInputStream is = new ByteArrayInputStream(studentfromserver); //input data from server and contain it to byte array.
		
		clientSocket.receive(receivePacket);
		studentfromserver = receivePacket.getData();
		
		//Deserialize Data Receive from Server
		Student deStudent =  (Student) deserialize(studentfromserver);
		System.out.println("FROM SERVER: " + deStudent.getCode() + " | " + deStudent.getName() + " | " + deStudent.getGender() + " | " + deStudent.getDob());

		clientSocket.close();
		bs.close();
		is.close();
	}
	
	public static byte[] serialize(Object obj) throws IOException {
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ObjectOutputStream os = new ObjectOutputStream(out);
	    os.writeObject(obj);
	    return out.toByteArray();
	}
	public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
	    ByteArrayInputStream in = new ByteArrayInputStream(data);
	    ObjectInputStream is = new ObjectInputStream(in);
	    return is.readObject();
	}
}
