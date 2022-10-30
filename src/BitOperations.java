/**
 * right nBit value [0, 63]
 * All methods will return -1 in the case of wrong nBit value
 *
 */
public class BitOperations {
/**
 * 
 * @param number - any number
 * @param nBit - number of bit
 * @return value of bit with number nBit
 */
	static public int getBitValue(long number, int nBit) {
		int res = -1;
	if (checkNbit(nBit)) {
		long mask = 1 << nBit; //all bits are 0 except bit with number nBit
		if ((number & mask) > 0) {
			res = 1;
		} else {
			res = 0;
		}
	}
	return res;
	}
	
private static boolean checkNbit(int nBit) {
	
	return nBit < 64 && nBit >= 0;
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
			if (value == true) {
			long mask = 1 << nBit; //all bits are 0 except bit with number nBit
			res = mask | number; //set value true to nBit
			} else {
			long mask = 0xffffff; //long mask = 0xffffff; //all bits are 1
			long mask2 = 1 << nBit; //all bits are 0 except bit with number nBit //all bits are 1 except bit with number nBit
			mask = mask ^ mask2;
			res = mask & number;
			}
			}
		
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
		
		return res;
	}
	
}
