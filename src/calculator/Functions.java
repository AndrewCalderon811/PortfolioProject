package calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Queue;
import java.util.Stack;

public class Functions {
	
	private BigDecimal result;
	private BigDecimal num1;
	private BigDecimal num2;
	private String operation = "x";
	
	
	public Functions() {
		result = null;
		num1 = null;
		num2 = null;
	}
	
	public Functions(BigDecimal r, BigDecimal n1, BigDecimal n2) {
		result = r;
		num1 = n1;
		num2 = n2;
	}

	private BigDecimal add(BigDecimal x, BigDecimal y) {
		return x.add(y);
	}
	
	private BigDecimal subtract(BigDecimal x, BigDecimal y) {
		return x.subtract(y);
	}
	
	private BigDecimal multiply(BigDecimal x, BigDecimal y) {
		return x.multiply(y);
	}
	
	private BigDecimal divide(BigDecimal x, BigDecimal y) {
		return x.divide(y);
	}
	
	public void runCalculation() {
		
		try {
			switch(operation) {
				case "+" : result = add(num1, num2);
				break;
				case "-" : result = subtract(num1, num2);
				break;
				case "*" : result = multiply(num1, num2);
				break;
				case "/" : result = divide(num1, num2);
				break;
			}
		}
		catch(ArithmeticException e) {
			MathContext mc = new MathContext();
			System.out.println(mc.getRoundingMode());
//			result = num1.divide(num2, null);
			}
		System.out.println(result);
	}

	public void loadFirstNum(Queue<BigDecimal> wholeNumQueue, boolean n) {
		int counterWholeNum = wholeNumQueue.size() - 1;
		BigDecimal powerOf = new BigDecimal("10");
		
		while(!wholeNumQueue.isEmpty()) {
			if(num1 != null) {
			num1 = (wholeNumQueue.poll().multiply(powerOf.pow(counterWholeNum))).add(num1);
			}
			else {
				num1 = (wholeNumQueue.poll().multiply(powerOf.pow(counterWholeNum)));
			}
			counterWholeNum--;
		}
		if(n == true) {
			num1.negate();
		}
		System.out.println(num1);
	}
	
	public void loadSecondNum(Queue<BigDecimal> wholeNumQueue, boolean n) {
		int counterWholeNum = wholeNumQueue.size() - 1;
		BigDecimal powerOf = new BigDecimal("10");
		
		while(!wholeNumQueue.isEmpty()) {
			if(num2 != null) {
			num2 = (wholeNumQueue.poll().multiply(powerOf.pow(counterWholeNum))).add(num2);
			}
			else {
				num2 = (wholeNumQueue.poll().multiply(powerOf.pow(counterWholeNum)));
			}
			counterWholeNum--;
		}
		if(n == true) {
			num2.negate();
		}
		
		System.out.println(num2);
	}
	
	public BigDecimal getFirstNum() {
		return num1;
	}
	
	public BigDecimal getSecondNum() {
		return num2;
	}
	
	public void setOperation(String op) {
		operation = op;
	}
	
	public String getOperation() {
		return operation;
	}
	
	public void reset() {
		num1 = null;
		num2 = null;
		operation = "x";
		result = null;
	}
}
