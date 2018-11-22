package com.chatapp.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Server extends JFrame{
	
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private ServerSocket server;
	private Socket connection;
	
	public Server() {
		super("Zossy Messenger");
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						sendMessage(e.getActionCommand());
						userText.setText("");
					}
				}
		);
		add(userText, BorderLayout.SOUTH);
		chatWindow = new JTextArea();
		chatWindow.setEditable(false);
		add(new JScrollPane(chatWindow));
		setSize(300,150);
		setVisible(true);
	}
	
	public void startRunning() {
		try {
			server = new ServerSocket(6789, 100);
			while(true) {
				try {
					//connect and have conversation
					waitForConnection();			
					setupStreams();
					whileChatting();
				} catch (EOFException e) {
					showMessage("\n Server đã thoát! ");
				} finally {
					closeCrap(); //holly crap again =)))
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//wait for connection. then display connection information
	private void waitForConnection() throws IOException {
		showMessage("Đợi ai đó kết nối đến...\n");
		connection = server.accept();
		showMessage("ĐÃ KẾT NỐI VỚI: " + connection.getInetAddress().getHostName());
	}
	
	//get stream to send and receive data
	private void setupStreams() throws IOException {
		oos = new ObjectOutputStream(connection.getOutputStream());
		oos.flush();
		ois = new ObjectInputStream(connection.getInputStream());
		showMessage("\nStreams are now setup! \n");
	}
	
	//during the chat conversation
	private void whileChatting() throws IOException {
		String message = "Xin chào!";
		sendMessage(message);
		ableToType(true);
		do {
			//have conversation 
			try {
				message = (String) ois.readObject();
				showMessage("\n" + message);
				
			} catch (ClassNotFoundException e) {
				showMessage("\n IDK WTF that guy sent! \n");
			}
		} while (!message.equalsIgnoreCase("CLIENT:  END"));
	}
	
	//close streams and socket after you are done chatting
	private void closeCrap() {
		showMessage("\nCLIENT ĐÃ THOÁT! \n");
		ableToType(false);
		try{
			oos.close();
			ois.close();
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//send a message to client
	private void sendMessage(String message) {
		try {
			oos.writeObject("SERVER:  " + message);
			oos.flush();
			showMessage("\nSERVER:  " + message);
		} catch (IOException e) {
			chatWindow.append("\n ERROR: DUDE I CAN'T SEND THAT MESSAGE.");
		}
	}
	
	//update chatwindow
	private void showMessage(final String text) {
		SwingUtilities.invokeLater(
				new Runnable() {
					@Override
					public void run() {
						chatWindow.append(text);
					}
				}
		);
	}
	
	//let the user type stuff into the box
	private void ableToType(final boolean tof) {
		SwingUtilities.invokeLater(
				new Runnable() {
					@Override
					public void run() {
						userText.setEditable(tof);
						chatWindow.setEditable(tof);
					}
				}
		);
	}
	
}
