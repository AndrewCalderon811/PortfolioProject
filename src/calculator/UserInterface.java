package calculator;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class UserInterface {

	public void start() {
		
		int FRAME_SIZE_X = 700;
		int FRAME_SIZE_Y = 900;
		
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_SIZE_X, FRAME_SIZE_Y);
		

		int gridHeight = 3;
		int gridWidth = 3;
		int numButtons = 7;
		
		int increment = (int)FRAME_SIZE_X/numButtons;
		
		JButton[] buttonArray = new JButton[gridHeight*gridWidth];
		JPanel panel = new JPanel();
		
		for(int i = 0; i < buttonArray.length; i++) {
			buttonArray[i] = new JButton(String.valueOf(i+1));
			buttonArray[i].setLayout(null);
			buttonArray[i].setBounds(((i%gridWidth)*increment), (FRAME_SIZE_Y-(i/gridHeight)*increment)-increment-35, increment, increment);
			
			panel.add(buttonArray[i]);
		}
		
		panel.setLayout(null);
		panel.setBackground(Color.green);
		frame.add(panel);
		
		frame.setVisible(true);
	}
}
