package com.webbrowser.app;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.*;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class ReadFile extends JFrame {
	private JTextField addressBar;
	private JEditorPane display;
	
	//constructor
	public ReadFile() {
		super("Zossy Browser");
		
		addressBar = new JTextField("Enter a URL host!");
		addressBar.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						loadCrap(e.getActionCommand()); // =))) holly crap
					}
				}
		);
		add(addressBar, BorderLayout.NORTH);
		
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(
				new HyperlinkListener() {
					
					@Override
					public void hyperlinkUpdate(HyperlinkEvent e) {
						if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED) {
							loadCrap(e.getURL().toString());
						}
					}
				}
		);
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(500, 300);
		setVisible(true);
	}
	
	//loadCrap to display on the screen
	private void loadCrap(String url) {
		try {
			display.setPage(url);
			addressBar.setText(url);
		} catch (Exception e) {
			System.out.println("CRAP: " +e.getMessage());
		}
	}
	
}