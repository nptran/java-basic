package TCPSocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.Scanner;

public class Server {

	static BufferedWriter bw = null;
	static Socket socket = null;
	static BufferedReader br = null;

	public static void main(String[] args) {
		
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(3110);
			System.out.println("Waiting connection...");
			socket = serverSocket.accept();
			System.out.println("Connected!");
			
			new Thread(new Runnable(){
				public void run() {
					try {
						br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						while(true) {
							String readfromclient = br.readLine();
							System.out.println("From Client: "+ readfromclient);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();

			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				@SuppressWarnings("resource")
				String messtoclient = new Scanner(System.in).nextLine();
					bw.write(messtoclient);
					bw.newLine();
					bw.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
