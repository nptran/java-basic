package process;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Client extends JFrame {
	
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private String message = "";
	private String serverIP;
	private Socket connection;
	
	public Client(String host) {
		super("Zosy Messenger");
		serverIP = host;
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
		add(new JScrollPane(chatWindow), BorderLayout.CENTER);
		setSize(300,150);
		setVisible(true);
	}
	
	//connect to server
	public void startRunning() {
		try {
			connectToServer();
			setupStreams();
			whileChatting();
		} catch (EOFException e) {
			showMessage("\nClient terminated connection");
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			closeCrap();
		}
	}
	
	//connect to server
	public void connectToServer() throws IOException {
		showMessage("\nĐang kết nối...\n");
		connection = new Socket(InetAddress.getByName(serverIP), 6789);
		showMessage("ĐÃ KẾT NỐI ĐẾN:" + connection.getInetAddress().getHostName());
	}
	
	//set up streams to send and receive message
	private void setupStreams() throws IOException {
		oos = new ObjectOutputStream(connection.getOutputStream());
		oos.flush();
		ois = new ObjectInputStream(connection.getInputStream());
		showMessage("\nDude your streams are now good to go! \n");
	}
	
	//while chatting with server 
	private void whileChatting() throws IOException {
		ableToType(true);
		do {
			try {
				message = (String) ois.readObject();
				showMessage("\n" + message);
			} catch (ClassNotFoundException e) {
				showMessage("\n IDK that obj type");
			}
		} while (!message.equalsIgnoreCase("SERVER:  END"));
	}
	
	//close the streams and sockets
	private void closeCrap() {
		showMessage("\nClosing crap down...");
		ableToType(false);
		try {
			oos.close();
			ois.close();
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//send messages to server
	private void sendMessage(String message) {
		try {
			oos.writeObject("CLIENT:  " + message);
			oos.flush();
			showMessage("\nCLIENT:  " + message);
		} catch (IOException e) {
			chatWindow.append("\nSomething wrongs were sending!\n");
		}
	}
	
	//update chatWindow
	private void showMessage(final String m) {
		SwingUtilities.invokeLater(
				new Runnable() {
					@Override
					public void run() {
						chatWindow.append(m);
					}
				}
		);
	}
	
	//gives user permission to type into the box
	private void ableToType(final boolean tof) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				userText.setEditable(tof);
			}
		});
	}
}
