package calculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.*;

public class UserInterface {
	
	private int currentArrayLocation = 0;
	
	private boolean setNegative = false;
	
	private Functions func = new Functions();
	
	private Queue<BigDecimal> numQueue = new PriorityQueue<BigDecimal>();
	

	public void start() {
		
		
		int FRAME_SIZE_X = 400;
		int FRAME_SIZE_Y = 500;
		
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_SIZE_X, FRAME_SIZE_Y);
		

		int gridHeight = 5;
		int gridWidth = 4;
		int numButtons = 7;
		
		int increment = (int)FRAME_SIZE_X/numButtons;
		
		JButton[] buttonArray = new JButton[gridHeight*gridWidth];
		JPanel panel = new JPanel();
		
		HashMap<Integer, String> hash = new HashMap<>();
				hash.put(0, "+/-"); hash.put(1, "0"); hash.put(2, "."); hash.put(3, "="); hash.put(4, "1"); hash.put(5, "2"); 
				hash.put(6, "3"); hash.put(7, "+"); hash.put(8, "4"); hash.put(9, "5"); hash.put(10, "6"); hash.put(11, "-"); 
				hash.put(12, "7"); hash.put(13, "8"); hash.put(14, "9"); hash.put(15, "*"); hash.put(16, "del"); hash.put(17, "CE"); 
				hash.put(18, "C"); hash.put(19, "/");
		
		
		
		for(int i = 0; i < buttonArray.length; i++) {
			buttonArray[i] = new JButton(hash.get(i));
			buttonArray[i].setName(hash.get(i));
			buttonArray[i].setLayout(null);
			buttonArray[i].setBounds(((i%gridWidth)*increment), (FRAME_SIZE_Y-((i/gridWidth)*increment))-increment-35, increment, increment);
			
			panel.add(buttonArray[i]);
			
			buttonArray[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					
					try {
						BigDecimal num = new BigDecimal(event.getActionCommand());
					
					
						switch(event.getActionCommand()) {
						case "0" : 
							numQueue.add(num);
						break;
						case "1" : 
							numQueue.add(num);
						break;
						case "2" : 
							numQueue.add(num);
						break;
						case "3" : 
							numQueue.add(num);
						break;
						case "4" : 
							numQueue.add(num);
						break;
						case "5" : 
							numQueue.add(num);
						break;
						case "6" : 
							numQueue.add(num);
						break;
						case "7" :
							numQueue.add(num);
						break;
						case "8" : 
							numQueue.add(num);
						break;
						case "9" : 
							numQueue.add(num);
						break;
						}
					}
					catch(NumberFormatException e) {
					}
					finally {
						switch(event.getActionCommand()) {
						case "+/-" : setNegative = !setNegative;
						System.out.println("setNegative : " + setNegative);
						break;
						case "del" : 
							Queue<BigDecimal> helper = new PriorityQueue<BigDecimal>();
							while(true) {
								if(numQueue.size() > 1) {
									helper.add(numQueue.poll());
								}
								else {
									break;
								}
								numQueue = helper;
							}
						break;
						case "CE" : 
							setNegative = false;
							numQueue.clear();
						break;
						case "C" : 
							setNegative = false;
							numQueue.clear();
							func.reset();
						break;
						case "/" : 
							func.loadFirstNum(numQueue, setNegative);
							func.setOperation(event.getActionCommand());
							numQueue.clear();
							setNegative = false;
						break;
						case "*" : 
							func.loadFirstNum(numQueue, setNegative);
							func.setOperation(event.getActionCommand());
							numQueue.clear();
							setNegative = false;
						break;
						case "-" : 
							func.loadFirstNum(numQueue, setNegative);
							func.setOperation(event.getActionCommand());
							numQueue.clear();
							setNegative = false;
						break;
						case "+" : 
							func.loadFirstNum(numQueue, setNegative);
							func.setOperation(event.getActionCommand());
							numQueue.clear();
							setNegative = false;
						break;
						case "=" : 
							func.loadSecondNum(numQueue, setNegative);
							func.runCalculation();
							numQueue.clear();
							setNegative = false;
						break;
						}
					}
					
				}
			});
		}
		
		panel.setLayout(null);
		panel.setBackground(Color.green);
		frame.add(panel);
		
		frame.setVisible(true);
	}
	
	
}
