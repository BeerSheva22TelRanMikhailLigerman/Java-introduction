import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	
	@Test
	@Disabled
	void dataTypeTest() {
		int b = 10;
		short a = 20000;
		char c = 'd';
		long l = (long) 10.1;
		byte b1 = (byte) 1000;
		a = (short) l;
		float f = 10.2f;
		int b2 = 0xfffffff1;
		
		assertEquals(-15, b2);
	}
	
	@Test
	@Disabled
	void operatorsTest() {
		int a = 10;
		assertEquals(13,a + 3);
		assertEquals(1, a % 3);
		int number = 123;
		assertEquals(3, getThirdDigit(number));
		assertEquals(2, getSecondDigit(number));
		assertEquals(1, getFirstDigit(number));
	}
	private int getFirstDigit(int number) {
	return number / 100 % 10;	
	}
	
	@Test
	@Disabled
	private int getSecondDigit(int number) {
		return number / 10 % 10;	
		}
	
	private int getThirdDigit(int number) {
		return number % 10;	
		}

	@Test
	
	void getBitValueTest() {
		long num = 0x3ab7f5; //001110101011011111_1_10101
		assertEquals(1, BitOperations.getBitValue(num, 5));
		assertEquals(0, BitOperations.getBitValue(num, 11));
		assertEquals(0, BitOperations.getBitValue(num, 1));
		assertEquals(1, BitOperations.getBitValue(num, 2));
		assertEquals(-1, BitOperations.getBitValue(num, 64));
		assertEquals(-1, BitOperations.getBitValue(num, -1));
		
	}
	@Test 
	
		void setBitValueTest() {
		long number = 0x3ab7f5; //001110101011011111_1_10101
		assertEquals(0x3ab7d5, BitOperations.setBitValue(number, 5, false));	
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 5, true));
	}
	@Test 
	@Disabled
		void revertBitValueTest() {
		long number = 0x3ab7f5; //001110101011011111_1_10101
		assertEquals(0x3ab7d5, BitOperations.revertBitValue(number, 5));	
		assertEquals(0x3ab7f4, BitOperations.revertBitValue(number, 0));
	}
	
	//03.11.2022 lesson 5
	
	@Test
	@Disabled
		void onesInNumberTest() {
		assertEquals(1, BitOperations.onesInNumber(1));
		assertEquals(0, BitOperations.onesInNumber(0));
		assertEquals(3, BitOperations.onesInNumber(7));
		assertEquals(3, BitOperations.onesInNumber(100));
	}
	
	
	//Home Work 03.11.2022
	
	@Test
	void digitsNumberTest() {
	assertEquals(1, Numbers.getNdigits(0));
	assertEquals(1, Numbers.getNdigits(1));
	assertEquals(5, Numbers.getNdigits(12345));
	}

	@Test 
	void leadingZerosTest() {
	assertEquals(63, BitOperations.leadingZeros(1));
	assertEquals(64, BitOperations.leadingZeros(0));
	assertEquals(60, BitOperations.leadingZeros(10));
	}
	
	
	@Test
	void isHappyNumberTest() {
		assertEquals(true, Numbers.isHappyNumber(123321));
		assertEquals(false, Numbers.isHappyNumber(123324));
		assertEquals(false, Numbers.isHappyNumber(12345));
		assertEquals(false, Numbers.isHappyNumber(1234567));
	}
	
	
	
}
