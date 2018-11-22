package com.swing.pane;

import javax.swing.JOptionPane;

public class OptionPane {
	public static void main(String[] args) {
		
		String fn = JOptionPane.showInputDialog("Enter first number here:");
		String sn = JOptionPane.showInputDialog("Enter second number here:");
		int title = JOptionPane.showConfirmDialog(null, "Are you wanna know sum of them?", "Confirm", 0);
		int num1 = Integer.parseInt(fn);
		int num2 = Integer.parseInt(sn);
		if(title != 1){
		int ans = num1 + num2;
		JOptionPane.showMessageDialog(null, "The answer is: " + ans, "Sum of them", JOptionPane.PLAIN_MESSAGE);
		}
	}

}
