//03.11.2022 lesson 5

public class Numbers {
public static int getNdigits(long number) {
	int res = 0;
	do {
		number /= 10;
		res++;
	} while (number != 0);
	
	return res;
}

public static boolean isHappyNumber(int number) {
	Boolean chekResult = false;
	if (number > 99999 && number < 1000000 ) {  	//check number contains 6 digits
	int digit1 = number % 10;						//check 1st digit
	int digit2 = number / 10 % 10;					//check 2st digit
	int digit3 = number / 100 % 10;					//check 3st digit
	int digit4 = number / 1000 % 10;				//check 4st digit
	int digit5 = number / 10000 % 10;				//check 5st digit
	int digit6 = number / 100000 % 10;				//check 6st digit
	chekResult = ((digit1 + digit2 + digit3) == (digit4 + digit5 + digit6));
	}
	return chekResult;
}

}
