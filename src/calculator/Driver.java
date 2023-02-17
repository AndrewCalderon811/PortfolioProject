package calculator;

import java.math.BigDecimal;
import java.util.PriorityQueue;
import java.util.Queue;

public class Driver {

	
	public static void main(String[] args) {
		UserInterface instance = new UserInterface();
		Queue<BigDecimal> q = new PriorityQueue<BigDecimal>();
		BigDecimal x = new BigDecimal(5);
		
		for(int i = 0; i < 10; i++) {
			q.add(x);
		}
		Functions func = new Functions();
		func.loadNum(q);
		System.out.println(func.getNum());
		
		BigDecimal[] arr = new BigDecimal[2];
		arr[0] = x;
		arr[1] = x;
		func.setOperation('*');
		
		System.out.println(func.runCalculation(arr, func.getOperation()));
		instance.start();
	}
}
