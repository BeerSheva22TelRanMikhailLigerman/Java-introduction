/**
 * right nBit value [0, 63]
 * All methods will return -1 in the case of wrong nBit value
 *
 */
public class BitOperations {
private static final int N_BITS = 64;

/**
 * 
 * @param number - any number
 * @param nBit - number of bit
 * @return value of bit with number nBit
 */
	static public int getBitValue(long number, int nBit) {
		int res = -1;
	if (checkNbit(nBit)) {
		long mask = getMask(nBit); 	//all bits are 0 except bit with number nBit
	
	res = (number & mask) == 0 ? 0 : 1 ;
	}
	return res;
	}

private static long getMask(int nBit) {
	return 1l << nBit;
}
	
private static boolean checkNbit(int nBit) {
	
	return nBit < N_BITS && nBit >= 0;
}

/**
 * 	
 * @param number - any number
 * @param nBit - bit number
 * @param value - true for 1, false for 0 
 * @return new number in which value of nBit'h bit will have a given value
 */
	static public long setBitValue(long number, int nBit, boolean value) {
		long res = -1;
		if (checkNbit(nBit)) {
			long mask = getMask(nBit);
			res = value ? number | mask : number & ~mask;
		}
		
	/*
		{
			if (value == true) {
			long mask = 1 << nBit; //all bits are 0 except bit with number nBit
			res = mask | number; //set value true to nBit
			} else {
			long mask = 0xffffff; //long mask = 0xffffff; //all bits are 1
			long mask2 = 1 << nBit; //all bits are 0 except bit with number nBit 
			mask = mask ^ mask2; //all bits are 1 except bit with number nBit!!
			res = mask & number;
			}
			}
		*/
				return res;
	
	}
	
	/**
	 * 
	 * @param number - any number
	 * @param nBit - bit number
	 * @return new number in which nBit'h bit will be reverted (old value - 1, new value - 0)
	 */
	static public long revertBitValue(long number, int nBit) {
		long res = -1;
		if (checkNbit(nBit)) {
			long mask = 1 << nBit; //all bits are 0 except bit with number nBit
			res = mask ^ number;
			}
		
		return res;	}
	
	
	//03.11.2022 lesson 5
	
	static public int leadingZeros(long number) { //кол-во нулей до единицы
		int res = 0;
		int nBit = N_BITS - 1;
		while(nBit >= 0 && getBitValue(number, nBit) == 0) {
			nBit --;
			res ++;
		}
		return res;
	}
	
	public static int onesInNumber(long number) { //кол-во единиц в числе
		int res = 0;
		int nBit = N_BITS - 1;
		for (int i = 0; i <= nBit; i++) {
			res += getBitValue(number, i);		//вместо цикла  if (getBitValue(number, i) == 1 {res++;}
		}
		return res;
	}
	
	
}
