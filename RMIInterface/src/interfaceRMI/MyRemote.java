package interfaceRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

import interfaceRMI.models.Student;

public interface MyRemote extends Remote {

	public int tinhTong(int a, int b) throws RemoteException;

	public Student deploy(Student student) throws RemoteException;

}
