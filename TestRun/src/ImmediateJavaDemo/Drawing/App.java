package ImmediateJavaDemo.Drawing;

import javax.swing.JFrame;

public class App {
	
	public static void main(String[] args) {
		TheWindow w = new TheWindow();
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(240,280);
		w.setVisible(true);
	}

}
