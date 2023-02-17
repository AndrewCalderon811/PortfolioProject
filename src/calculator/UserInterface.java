package calculator;

import java.awt.BorderLayout;

import javax.swing.*;

public class UserInterface {

	public void start() {
		
		int FRAME_SIZE_X = 700;
		int FRAME_SIZE_Y = 900;
		
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_SIZE_X, FRAME_SIZE_Y);
		
		
		JPanel panel = new JPanel();
		
		JButton[] buttonArray = new JButton[10];
		for(int i = 0; i < 10; i++) {
			buttonArray[i] = new JButton(ActionEvent e);
			panel.add(buttonArray[i]);
		}
		
		
		
		frame.add(panel);
		frame.getContentPane().add(BorderLayout.SOUTH, panel);
		frame.setVisible(true);
	}
}
