package calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Queue;
import java.util.Stack;

public class Functions {
	
	private BigDecimal result;
	private BigDecimal num1;
	private BigDecimal num2;
	private char operation = 'x';
	
	
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
	
	public BigDecimal runCalculation(BigDecimal[] array, char operation) {
		num1 = array[0];
		num2 = array[1];
		
		switch(operation) {
		case '+' : result = add(num1, num2);
		break;
		case '-' : result = subtract(num1, num2);
		break;
		case '*' : result = multiply(num1, num2);
		break;
		case '/' : result = divide(num1, num2);
		break;
		}
		return result;
	}
//	, Queue<BigDecimal> decimalNumQue
	public void loadNum(Queue<BigDecimal> wholeNumQueue) {
		int counterWholeNum = wholeNumQueue.size() - 1;
		BigDecimal powerOf = new BigDecimal(10);
		
		while(!wholeNumQueue.isEmpty()) {
			if(num1 != null) {
			num1 = (wholeNumQueue.poll().multiply(powerOf.pow(counterWholeNum))).add(num1);
			}
			else {
				num1 = (wholeNumQueue.poll().multiply(powerOf.pow(counterWholeNum)));
			}
			counterWholeNum--;
		}
	}
	
	public BigDecimal getNum() {
		return num1;
	}
	
	public void setOperation(char op) {
		operation = op;
	}
	
	public char getOperation() {
		return operation;
	}
}
