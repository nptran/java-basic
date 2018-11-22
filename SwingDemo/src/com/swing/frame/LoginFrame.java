package com.swing.frame;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
	
	JLabel jlUsername;
	JLabel jlPass;
	JTextField jtfUsername;
	JPasswordField jpfPass;
	JButton jbLogin;
	JButton jbReset;
	
	public LoginFrame() {
		
		jlUsername = new JLabel("Username: ");
		jlPass = new JLabel("Password: ");
		jtfUsername = new JTextField(10);
		jpfPass = new JPasswordField(10);
		jbLogin = new JButton("Login");
		jbReset = new JButton("Reset");
		
		
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setSize(400, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(3, 2));
		this.getContentPane().add(jlUsername);
		this.getContentPane().add(jtfUsername);
		this.getContentPane().add(jlPass);
		this.getContentPane().add(jpfPass);
		this.getContentPane().add(jbLogin);
		this.getContentPane().add(jbReset);
		
	}
	
	public static void main(String[] args) {
		new LoginFrame(); 
	}

}
