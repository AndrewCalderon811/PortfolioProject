package calculator;

import java.math.BigDecimal;
import java.util.PriorityQueue;
import java.util.Queue;

public class Driver {

	
	public static void main(String[] args) {
		UserInterface instance = new UserInterface();
		Queue<BigDecimal> q = new PriorityQueue<BigDecimal>();
		BigDecimal x = new BigDecimal("10");
		
		for(int i = 0; i < 10; i++) {
			q.add(x);
		}
		Functions func = new Functions();
		func.loadFirstNum(q, false);
		System.out.println(func.getFirstNum());
		
		BigDecimal[] arr = new BigDecimal[2];
		arr[0] = x;
		arr[1] = x;
		func.setOperation("*");
		
//		System.out.println(func.runCalculation(arr, func.getOperation()));
		instance.start();
		
		
		BigDecimal a = new BigDecimal("-1");
		System.out.println(Math.pow(10, -4));
	}
}
