//03.11.2022 lesson 5

public class SportlotoAppl {

	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive
	 * numbers cann't be repeated in a sequence of 6 random numbers
	 * 
	 */
	public static void main(String[] args) {
		
		int digit1 = getRandomInt(1, 49);	//it works but look not well
		int digit2 = getRandomInt(1, 49);
			while (digit1 == digit2) digit2 = getRandomInt(1, 49);
		int digit3 = getRandomInt(1, 49);
			while ((digit1 == digit3) || (digit2 == digit3)) digit3 = getRandomInt(1, 49);
		int digit4 = getRandomInt(1, 49);
			while ((digit1 == digit4) || (digit2 == digit4) || (digit3 == digit4)) digit4 = getRandomInt(1, 49);
		int digit5 = getRandomInt(1, 49);
			while ((digit1 == digit5) || (digit2 == digit5) || (digit3 == digit5) || (digit4 == digit5)) digit5 = getRandomInt(1, 49);
		int digit6 = getRandomInt(1, 49);
			while ((digit1 == digit6) || (digit2 == digit6) || (digit3 == digit6) || (digit4 == digit6) || (digit5 == digit6)) digit6 = getRandomInt(1, 49);
						
		System.out.print(digit1 + " " + digit2 + " " + digit3 + " " + digit4 + " " + digit5 + " " + digit6);
		
	}
	
	public static int getRandomInt(int min, int max) {
	return (int) (min + Math.random() * (max - min + 1)); //Math.random [0;1), +1 for max value
	}
	
	

}