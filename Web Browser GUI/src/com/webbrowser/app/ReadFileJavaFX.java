package com.webbrowser.app;


import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class ReadFileJavaFX extends Application {
	
	static Stage window;
	private TextField addressBar;
	private Scene scene;
	private JEditorPane display;

	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window.setTitle("Zossy Browser");

		addressBar = new TextField();
		addressBar.setPromptText("Enter URL here!");
		addressBar.setOnAction(event -> {
			loadCrap(addressBar.getText());
		});
		
		add(addressBar, BorderLayout.NORTH);
		
		Pane pane = new Pane();
		scene = new Scene(addressBar);
		window.setOnCloseRequest(event -> {
            event.consume();
            window.close();
        });
		
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
		
		pane.getChildren().addAll(addressBar);
		
		
	}

	private void loadCrap(String url) {
		try {
			display.setPage(url);
			addressBar.setText(url);
		} catch (Exception e) {
			System.out.println("CRAP: " +e.getMessage());
		}
	}

}
