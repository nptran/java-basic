package rmi.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import interfaceRMI.MyRemote;
import interfaceRMI.models.Student;

public class RMIServer extends UnicastRemoteObject implements MyRemote {

	private static final long serialVersionUID = 1L;

	public RMIServer() throws RemoteException {

	}

	@Override
	public int tinhTong(int a, int b) throws RemoteException {
		return a + b;
	}

	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
			System.out.println("Sercurity Installed");
		}
		
		try {
			RMIServer server = new RMIServer();
			LocateRegistry.createRegistry(1230);
			System.out.println("Server is waiting...");
			Registry reg = LocateRegistry.getRegistry(1230);
			reg.bind("tinhtong", server);
			
		} catch (RemoteException | AlreadyBoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Student deploy(Student student) throws RemoteException {
		return student;
	}

}
