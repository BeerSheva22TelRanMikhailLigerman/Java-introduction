package telran.text;

import java.util.Arrays;

public class Strings {

	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return true if str2 is an anagram of str1
	 * complexity O[N] two passes
	 * only one additional array
	 * only symbols or English letters
	 * 1. the same length
	 * 2. the same symbols just in different order
	 */
	public static boolean isAnagram(String str1, String str2) {
		boolean res = false;
		if (str1.length() == str2.length() && str1.length() > 1) {
			char[] str1Arr = str1.toCharArray();
			char[] str2Arr = str2.toCharArray();
			char[] helper = new char[Character.MAX_VALUE];
			int arrHelperSum = 0;
			int nonDifCounter = 0;
			
			for (int i = 0; i < str1Arr.length; i++) {
				helper[str1Arr[i]]++;
				helper[str2Arr[i]]--;
				if (str1Arr[i] != str2Arr[i]) {nonDifCounter++;}
			} 
			for (int i = 0; i < helper.length; i++) {
				arrHelperSum += Math.abs(helper[i]);
			}
			res = (arrHelperSum == 0 && nonDifCounter != 0);		
		}
		return res;
	}
	
	public static void sortStringNumbers(String[] str) {
		
		int[] helper = new int[256];
		for (int i = 0; i < str.length; i++) {
			helper[Byte.valueOf(str[i]) + 128]++;
		}
		int strPosition = 0;
		for (int i = 0; i < helper.length; i++) {
			while (helper[i] != 0) {
				str[strPosition] = Integer.toString(i - 128);
				strPosition++;
				helper[i]--;
			}
		}
	}
	
	public static String javaNameExp() {
		return "[a-zA-Z$][\\w$]*|_[\\w$]+";
	} 
	//regular expression for IP v4 octed
	public static String ipV4Octet( ) {
		return "([01]?\\d\\d?|2([0-4]\\d|5[0-5]))";
		 
	}
	//interpolation of regular expression
	public static String ipV4( ) {
		String octetExp = ipV4Octet();
		return String.format("(%1$s\\.){3}%1$s", octetExp);
	}
	
	//lesson 11
	private static String arithmeticExpression() {
		String operatorExp = operator();
		String operandExp = operand();
		
		
		return String.format("\\(*%1$s(%2$s\\(*%1$s\\)*)*", operandExp, operatorExp);		//checking only for the correct location of braces and according javaName
	}

	private static String operand() {
		// FIXME
		// adds possibility of using Java variables
		return "(\\d+\\.?\\d*|\\.\\d+|[a-zA-Z$][\\w$]*|_[\\w$]+)";
	}
	
	

	public static boolean isArithmeticExpression(String expression) {
		expression = expression.replaceAll("\\s+", "");
		return expression.matches(arithmeticExpression());
	}

	private static String operator() {

		return "([-+*/])";
	}

	/**
	 * 
	 * @param expression
	 * @param values
	 * @param namesSorted - variable names sorted
	 * @return computed value of a given expression or Double.NaN
	 */
	public static Double computeArithmenticExpression(String expression, double values[], String names[]) {	
		// 10 (* 2)
		// 10 * 2(())
		Double res = Double.NaN;
		if (isArithmeticExpression(expression) && checkBraces(expression)) {	//full braces checking
			expression = expression.replaceAll("[\\s()]+", "");					//braces and non printable symbols removed from expression!
			String operands[] = expression.split(operator());
			String operators[] = expression.split(operand());
			res = getOperandValue(operands[0], values, names);
			int index = 1;
			while (index < operands.length && !res.isNaN()) {
				double operandValue = getOperandValue(operands[index], values, names);
				res = computeOperation(res, operandValue, operators[index]);
				index++;
			}
			
		}

		return res;
	}

	private static Double computeOperation(Double operand1, double operand2, String operator) {
		Double res = Double.NaN;
		if(!Double.isNaN(operand2)) {
			switch(operator) {
			case "+": res = operand1 + operand2; break;
			case "-": res = operand1 - operand2; break;
			case "*": res = operand1 * operand2; break;
			case "/": res = operand1 / operand2; break;
			default: res = Double.NaN;
			}
		}
		return res;
	}

	private static Double getOperandValue(String operand, double[] values, String[] names) {
		double res = Double.NaN;
		if (operand.matches("\\d+\\.?\\d*|\\.\\d+")) {res =  Double.parseDouble(operand);}
		if (operand.matches(javaNameExp())) {
			int indexName = Arrays.binarySearch(names, operand);
			if (indexName >= 0) {res = values[indexName];}
			
		}
		return res;
	}

	public static boolean checkBraces(String expression) {				//parity check only
		char[] halper = expression.toCharArray();
		int bracesCounter = 0;
		for (int i = 0; i < halper.length; i++) {
			if (expression.charAt(i) == '(') {bracesCounter++;}
			if (expression.charAt(i) == ')') {bracesCounter--;}
			
		}
		return bracesCounter == 0 ? true : false;
	}
	
	
	
}
