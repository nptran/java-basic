package TCPSocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.Scanner;

public class Client {

	static Socket clientSocket = null;
	static BufferedReader bis = null;
	static BufferedWriter bw = null;

	public static void main(String[] args) {
		try {
			System.out.println("Connecting to server...");
			clientSocket = new Socket("LocalHost",3110);
			System.out.println("Connected!");
			
			new Thread(new Runnable(){
				public void run() {
					try {
						bw = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
						while(true) {
							@SuppressWarnings("resource")
							String messtoclient = new Scanner(System.in).nextLine();
								bw.write(messtoclient);
								bw.newLine();
								bw.flush();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
			
			bis = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));			
			while(true) {	
				String readfromserver = bis.readLine();
				System.out.println("From Server:" + readfromserver);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
