package rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaceRMI.MyRemote;
import interfaceRMI.models.Student;

public class RMIClient {

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
			System.out.println("Sercurity Installed");
		}
		
		String host = "localhost";
		int port = 1230;
		try {
			System.out.println("Connecting to server...");
			Registry reg = LocateRegistry.getRegistry(host, port);
			System.out.println("Connected");
			
			MyRemote server = (MyRemote) reg.lookup("tinhtong");
			System.out.println("Answer from server: " + server.tinhTong(5, 5));
			Student student = server.deploy(new Student ("Nam", 19));
			System.out.println("Your name is: " + student.getName() + " " + student.getAge() + " tuoi.");
			
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
