//03.11.2022 lesson 5

public class Numbers {
	
public static final int N_HAPPY_NUMBER_DIGITS = 6;

public static int getNdigits(long number) {
	int res = 0;
	do {
		number /= 10;
		res++;
	} while (number != 0);
	
	return res;
}

public static boolean isHappyNumber(int number) {
	boolean res = false;
	number = Math.abs(number);
	if (getNdigits(number) == N_HAPPY_NUMBER_DIGITS) {
		int halfDigits = N_HAPPY_NUMBER_DIGITS / 2;
		int numberPartDivider = (int) Math.pow(10, halfDigits);
		int sumFirstPart = getSumDigits(number / numberPartDivider);
		res = sumFirstPart == getSumDigits(number % numberPartDivider);
	}
	return res;
	
	
		
}

public static int getSumDigits(int number) {
	int res = 0;
	do {
		res += (number % 10);
		number /= 10;
	} while (number != 0);
	return res;
}

public static int[] getArrayFromDigit(int number) {   //from int digit to array
	int res[] = new int[getNdigits(number)];
	for (int i = res.length - 1; i >= 0; i--) {
		res[i] = number % 10;
		number /= 10;
	}
	return res;
}

public static int getNumberFromDigits(int[] digits) {   //from array to digit
	int res = 0;
	for (int i = 0; i < digits.length; i++) {
		res = res * 10 + digits[i];
	}
	return res;
}

public static long getRandomNumber(long min, long max) {
	return (long) (min + Math.random() * (max - min + 1));
}
}
