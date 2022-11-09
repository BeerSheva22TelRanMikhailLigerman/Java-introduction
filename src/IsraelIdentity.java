import java.util.Arrays;

public class IsraelIdentity {
	
	/**
	 * 
	 * @param id
	 * @return true for right id otherwise false
	 * number
	 * control sum should be multiple of 10 ( sum % 10 == 0)
	 * for even indexes (0, 2, 4, 6, 8) digits as is
	 * for odd indexes (1, 3, 5, 7) digit = digit * 2, if > 9 the sum of inner digits is taken
	 * example, 123456782 => 1 + 4(2*2) + 3 + 8(4*2) + 5 + 3(6*2=12=>1+2) + 7 + 7(8*2=16=>1+6) + 2
	 * 
	 */
	public static boolean verify(int id) {
		boolean res = false;
		if (Numbers.getNdigits(id) == 9) {int controlSum = 0;
			int[] array = Numbers.getArrayFromDigit(id);
			for (int i = 0; i < array.length; i += 2) { 
				controlSum += array[i];}
			for (int i = 1; i < array.length; i += 2) {
				if (array[i] * 2 > 9) {controlSum += Numbers.getSumDigits(array[i]*2);
				} else { controlSum += array[i]*2;}
			}
			res = controlSum % 10 == 0;
		}
		return res;
	}
	
	/**
	 * 
	 * @return random number of 9 digits matching Israel id
	 * cycle not more than 9 iterations
	 */
	public static int generateRandomID() {
		int res = 0;
		
		int id = SportlotoAppl.getUniqueRandomInt(100000000, 999999999);
		int controlSum = IsraelIdentity.getControlSum(id);
		int countIteration = 0;
		
		while (controlSum % 10 != 0) 
			 {
			int raznica = 10 - controlSum % 10;	
			int[] array = Numbers.getArrayFromDigit(id);
			int i = 0; 
			int changeControlSum = 0;
			
				
				while (changeControlSum != raznica)  {
						i = SportlotoAppl.getUniqueRandomInt(0, 8);
						if (i % 2 == 0 & array[i] < 9) {
							array[i]++;
							changeControlSum += 1;}
						if (i % 2 != 0 & array[i] < 4) {
							array[i]++;
							changeControlSum += 2;}
						if (i % 2 != 0 & array[i] >= 5 & array[i] <= 8) {
							array[i]++;
							changeControlSum += 2;}
						countIteration += 1;
				
				} 
			}
		
		
		
		
		return res;
	}
	
	
public static int getControlSum(int id) {
		
		int controlSum = 0;
		int[] array = Numbers.getArrayFromDigit(id);
		for (int i = 0; i < array.length; i += 2) { 
			controlSum += array[i];}
		for (int i = 1; i < array.length; i += 2) {
			if (array[i] * 2 > 9) {controlSum += Numbers.getSumDigits(array[i]*2);
			} else { controlSum += array[i]*2;}
		}
		return controlSum;
	}

}
