package telran.digital.numbers;

public class DigitalNumbersPrinting {
private static final String SYMBOL = "*";
public static void displayDigitalNumber(String number, int offset, int width, int height) {
	char[] numberArray = number.toCharArray();
	String masterArray[] = newArrayPict(numberArray[0], offset, width, height);
	
	for (int i = 1; i < numberArray.length; i++) {
		addArray(masterArray, newArrayPict(numberArray[i], offset, width, height)); 
	}
	displayStrings(masterArray);
}

private static String[] newArrayPict(char number, int offset, int width, int height) {
	String newDigit[] = new String[height];
	switch(number) {
	case '0': newDigit = zero(offset, width, height); break;
	case '1': newDigit = one(offset, width, height); break;
	case '2': newDigit = two(offset, width, height); break;
	case '3': newDigit = three(offset, width, height); break;
	case '4': newDigit = didgitFor(offset, width, height); break;
	case '5': newDigit = five(offset, width, height); break;
	case '6': newDigit = six(offset, width, height); break;
	case '7': newDigit = seven(offset, width, height); break;
	case '8': newDigit = eight(offset, width, height); break;
	case '9': newDigit = nine(offset, width, height); break;
	
	}
	return newDigit;
}
	




private static String[] addArray(String[] masterArray, String arrayToAdd[]) {
	for (int i = 0; i < masterArray.length; i++) {
		masterArray[i] = masterArray[i] + arrayToAdd[i];
	}
	return masterArray;
	
}



public static String line(int offset, int length) {
	return " ".repeat(offset) + SYMBOL.repeat(length);
}
public static String[] verticalLine(int offset, int height) {
	String [] res = new String[height];
	for (int i = 0; i < res.length; i++) {
		res[i] = " ".repeat(offset) + SYMBOL;
	}
	return res;
}
public static String[] twoVerticalLines(int offset, int width, int height) {
	String [] res = new String[height];
	for (int i = 0; i < res.length; i++) {
		res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
	}
	return res;
}
	
public static String[] makeUpLeftLine(String array[], int offset, int width, int height) {
	for (int i = 0; i <= array.length / 2; i++) {
		array[i] = " ".repeat(offset) +  SYMBOL + " ".repeat(width-1);
	}
	return array;
}
public static String[] makeUpRightLine(String array[], int offset, int width, int height) {
	for (int i = 0; i <= array.length / 2; i++) {
		array[i] = " ".repeat(offset) +  " ".repeat(width - 1) + SYMBOL;
	}
	return array;
}
	public static String[] makeUpRightLeftLine(String array[], int offset, int width, int height) {
		for (int i = 0; i <= array.length / 2; i++) {
			array[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
		}
		return array;
}
public static String[] makeDownLeftLine(String array[], int offset, int width, int height) {
	for (int i = array.length /2 + 1; i < array.length; i++) {
		array[i] = " ".repeat(offset) +  SYMBOL + " ".repeat(width-1);
	}
	return array;
}
public static String[] makeDownRightLine(String array[], int offset, int width, int height) {
	for (int i = array.length /2 + 1; i < array.length; i++) {
		array[i] = " ".repeat(offset) +  " ".repeat(width - 1) + SYMBOL;
	}
	return array;
}
public static String[] makeDownRightLeftLine(String array[], int offset, int width, int height) {
	for (int i = array.length /2 + 1; i < array.length; i++) {
		array[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
	}
	return array;
}
public static String[] zero(int offset, int width, int height) {
	String res[] = new String[height];
	String [] lines = twoVerticalLines(offset, width, height - 2);
	System.arraycopy(lines, 0, res, 1, lines.length);
	res[0] = line(offset, width);
	res[height-1] = line(offset, width);
	return res;
}
public static String [] one(int offset, int width, int height) {
	String res[] = new String[height];
	makeUpRightLine(res, offset, width, height);
	makeDownRightLine(res, offset, width, height);
	return res;
}

private static String[] two(int offset, int width, int height) {
	String res[] = new String[height];
	makeUpRightLine(res, offset, width, height);
	makeDownLeftLine(res, offset, width, height);
	res[0] = line(offset, width);
	res[height / 2] = line(offset, width);
	res[height-1] = line(offset, width);
	return res;
}

private static String[] three(int offset, int width, int height) {
	String res[] = new String[height];
	makeUpRightLine(res, offset, width, height);
	makeDownRightLine(res, offset, width, height);
	res[0] = line(offset, width);
	res[height / 2] = line(offset, width);
	res[height-1] = line(offset, width);
	return res;
}

private static String[] didgitFor(int offset, int width, int height) {
	String res[] = new String[height];
	makeUpRightLeftLine(res, offset, width, height);
	makeDownRightLine(res, offset, width, height);
	res[height / 2] = line(offset, width);
	return res;
}

private static String[] five(int offset, int width, int height) {
	String res[] = new String[height];
	makeUpLeftLine(res, offset, width, height);
	makeDownRightLine(res, offset, width, height);
	res[0] = line(offset, width);
	res[height / 2] = line(offset, width);
	res[height-1] = line(offset, width);
	return res;
}

private static String[] six(int offset, int width, int height) {
	String res[] = new String[height];
	makeUpLeftLine(res, offset, width, height);
	makeDownRightLeftLine(res, offset, width, height);
	res[0] = line(offset, width);
	res[height / 2] = line(offset, width);
	res[height-1] = line(offset, width);
	return res;
}

private static String[] seven(int offset, int width, int height) {
	String res[] = new String[height];
	makeUpRightLine(res, offset, width, height);
	makeDownRightLine(res, offset, width, height);
	res[0] = line(offset, width);
	return res;
}

private static String[] eight(int offset, int width, int height) {
	String res[] = new String[height];
	String [] lines = twoVerticalLines(offset, width, height - 2);
	System.arraycopy(lines, 0, res, 1, lines.length);
	res[0] = line(offset, width);
	res[height / 2] = line(offset, width);
	res[height-1] = line(offset, width);
	return res;
}

private static String[] nine(int offset, int width, int height) {
	String res[] = new String[height];
	makeUpRightLeftLine(res, offset, width, height);
	makeDownRightLine(res, offset, width, height);
	res[0] = line(offset, width);
	res[height / 2] = line(offset, width);
	res[height-1] = line(offset, width);
	return res;
}
public static  void displayStrings(String[] strings) {
	for(int i = 0; i < strings.length; i++) {
		System.out.println(strings[i]);
	}
	
}
}