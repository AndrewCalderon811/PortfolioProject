package calculator;

import java.math.BigDecimal;
import java.math.MathContext;

public class Functions {
	
	private double result;
	private double num1;
	private double num2;
	
	
	public Functions() {
		result = 0;
		num1 = 0;
		num2 = 0;
	}
	
	public Functions(double r, double n1, double n2) {
		result = r;
		num1 = n1;
		num2 = n2;
	}

	private double add(double x, double y) {
		MathContext mc = MathContext.DECIMAL128;
		BigDecimal num1 = new BigDecimal(x, mc);
		BigDecimal num2 = new BigDecimal(y, mc);
		
		return num1.doubleValue() + num2.doubleValue();
	}
	
	private double subtract(double x, double y) {
		MathContext mc = MathContext.DECIMAL128;
		BigDecimal num1 = new BigDecimal(x, mc);
		BigDecimal num2 = new BigDecimal(y, mc);
		
		return num1.doubleValue() - num2.doubleValue();
	}
	
	private double multiply(double x, double y) {
		MathContext mc = MathContext.DECIMAL128;
		BigDecimal num1 = new BigDecimal(x, mc);
		BigDecimal num2 = new BigDecimal(y, mc);
		
		return num1.doubleValue() * num2.doubleValue();
	}
	
	private double divide(double x, double y) {
		MathContext mc = MathContext.DECIMAL128;
		BigDecimal num1 = new BigDecimal(x, mc);
		BigDecimal num2 = new BigDecimal(y, mc);
		
		return num1.doubleValue() / num2.doubleValue();
	}
	
	public double runCalculation(Double[] array, char operation) {
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
}
