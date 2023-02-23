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
		result = new BigDecimal("0");
		num1 = new BigDecimal("0");
		num2 = new BigDecimal("0");
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
			MathContext mc = new MathContext(16);
			result = num1.divide(num2, mc);
			}
		num2 = null;
		num1 = result;
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
	}
	
	public void loadFirstNum(Queue<BigDecimal> wholeNumQueue, boolean n, int index) {
		int counterWholeNum = index - 1;
		BigDecimal powerOf = new BigDecimal("10");
		MathContext mc = new MathContext(6);
		
		while(!wholeNumQueue.isEmpty()) {
			if(num1 != null) {
			num1 = (wholeNumQueue.poll().multiply(powerOf.pow(counterWholeNum, mc))).add(num1);
			}
			else {
				num1 = (wholeNumQueue.poll().multiply(powerOf.pow(counterWholeNum, mc)));
			}
			counterWholeNum--;
		}
		if(n == true) {
			num1.negate();
		}
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
	}
	
	public void loadSecondNum(Queue<BigDecimal> wholeNumQueue, boolean n, int index) {
		int counterWholeNum = index - 1;
		BigDecimal powerOf = new BigDecimal("10");
		MathContext mc = new MathContext(6);
		
		while(!wholeNumQueue.isEmpty()) {
			if(num2 != null) {
			num2 = (wholeNumQueue.poll().multiply(powerOf.pow(counterWholeNum, mc))).add(num2);
			}
			else {
				num2 = (wholeNumQueue.poll().multiply(powerOf.pow(counterWholeNum, mc)));
			}
			counterWholeNum--;
		}
		if(n == true) {
			num2.negate();
		}
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
	
	public String resultToString() {
		return String.valueOf(result);
	}
	
	public String firstNumToString() {
		return String.valueOf(num1);
	}
	
	public String secondNumToString() {
		return String.valueOf(num2);
	}
}
