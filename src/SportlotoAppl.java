import java.lang.reflect.Array;
import java.util.Arrays;

//03.11.2022 lesson 5

public class SportlotoAppl {

	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive
	 * numbers cann't be repeated in a sequence of 6 random numbers
	 * 
	 */
	static long mask = 0;
	
	public static void main(String[] args) {
		for (int i = 0 ; i < 6; i++) {
			System.out.print(getUniqueRandomInt(1, 49) +" ");
			}
		
		
	}
		
	
	public static int getUniqueRandomInt(int min, int max) {
		int res = 0;
		do {
			res = (int) (min + Math.random() * (max - min + 1)); //Math.random [0;1), +1 for max value
		} while (BitOperations.getBitValue(mask, res) == 1);
		mask = BitOperations.setBitValue(mask, res, true);
	return res;
	
	}
	
	
	
	

}
