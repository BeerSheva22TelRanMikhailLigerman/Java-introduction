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
	@Disabled
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
	@Disabled
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
	@Disabled
	void digitsNumberTest() {
	assertEquals(1, Numbers.getNdigits(0));
	assertEquals(1, Numbers.getNdigits(1));
	assertEquals(5, Numbers.getNdigits(12345));
	}

	@Test 
	@Disabled
	void leadingZerosTest() {
	assertEquals(63, BitOperations.leadingZeros(1));
	assertEquals(64, BitOperations.leadingZeros(0));
	assertEquals(60, BitOperations.leadingZeros(10));
	}
	
	
	@Test
	@Disabled
	void isHappyNumberTest() {
		int expectedTrue = 123321;
		int expectedFalse = 123467;
		assertTrue(Numbers.isHappyNumber(expectedTrue));
		assertFalse(Numbers.isHappyNumber(expectedFalse));	
	}
	
	@Test
	@Disabled
	void getArrayFromDigitTest() {
		int expected[] = {1, 2, 3, 4};
		Numbers.getArrayFromDigit(1234);
		assertArrayEquals(expected, Numbers.getArrayFromDigit(1234));
	}
	
	@Test
	@Disabled
	void getNumberFromDigitsTest() {
		int expectedNumber = 1234;
		assertEquals(expectedNumber, Numbers.getNumberFromDigits(new int[] {1, 2, 3, 4}));
	}
	
	@Test
	@Disabled
	void addsNumberToArrayTest() {
		int[] array = new int[] {1, 2, 3, 4};
		assertArrayEquals(array, MyArrays.addsNumber(new int[] {1, 2, 3}, 4));
	}
	
	@Test
	@Disabled
	void removeNumberFromArrayTest() {
		int[] array = new int[] {1, 2, 3, 4};
		assertArrayEquals(new int[] {2, 3, 4}, MyArrays.removeNumber(array, 0));
		assertArrayEquals(new int[] {1, 3, 4}, MyArrays.removeNumber(array, 1));
		assertArrayEquals(new int[] {1, 2, 4}, MyArrays.removeNumber(array, 2));
		assertArrayEquals(new int[] {1, 2, 3}, MyArrays.removeNumber(array, 3));
		assertArrayEquals(array, MyArrays.removeNumber(array, 4));
	}
		
	@Test
	@Disabled
	void insertSortedTest() {
		int[] array = new int[] {10, 20, 30, 40, 50};
		assertArrayEquals(new int[] {10, 20, 25, 30, 40, 50}, MyArrays.insertSorted(array, 25));
		assertArrayEquals(new int[] {0, 10, 20, 30, 40, 50}, MyArrays.insertSorted(array, 0));
		assertArrayEquals(new int[] {10, 20, 30, 40, 50, 60}, MyArrays.insertSorted(array, 60));
		
	}
	
	@Test
	@Disabled
	void verifyID() {
		assertTrue(IsraelIdentity.verify(346820574));
		assertFalse(IsraelIdentity.verify(346820000));
		assertFalse(IsraelIdentity.verify(34682057));
	}
		
	@Test 
	@Disabled
	void generateID () {
		assertTrue(IsraelIdentity.verify(IsraelIdentity.generateRandomID()));	
	}
	
	
	@Test
	@Disabled
	void binarySearchTest() {
		int[] array = new int[] {10, 20, 30, 40, 50};
		int[] array2 = new int[] {10, 20, 20, 20, 50};
		assertEquals(-1, MyArrays.binarySearch(array, 0));
		assertEquals(0, MyArrays.binarySearch(array, 10));
		assertEquals(4, MyArrays.binarySearch(array, 50));
		assertEquals(-1, MyArrays.binarySearch(array, 51));
		assertEquals(-1, MyArrays.binarySearch(array, 15));
		assertEquals(2, MyArrays.binarySearch(array2, 20));
				
	}
	
	//Home Work lesson 7 10.11.2022
	
	@Test
	void binarySearchFirstDigit() {
		assertEquals(0, MyArrays.binarySearchFirstDigit((new int[] {10, 10, 10, 40, 50, 60}), 10));
		assertEquals(2, MyArrays.binarySearchFirstDigit((new int[] {10, 20, 30, 30, 30, 60}), 30));
		assertEquals(4, MyArrays.binarySearchFirstDigit((new int[] {10, 20, 30, 40, 50, 50}), 50));
	}
	
	@Test
	void isOneSwapTestFalse() {
		int ar1[] = { 1, 2, 3, 10, -1, 5, 6 };
		int ar2[] = { 1, 2, 3, 4, 5, 10 };
		int ar3[] = { 5, 1, 2, 4, 6, 10 };
		int ar4[] = { 1, 5, 2, 4, 3, 10 };
		int ar5[] = { 1, 3, 2, 5, 4, 10, 8 };
		int ar6[] = {1, 3, 20, 4, 5, 6, 10};
		int ar7[] = {1, 3, 20, 4, 5, 11, 2};
		assertFalse(MyArrays.isOneSwapForSorted(ar1));
		assertFalse(MyArrays.isOneSwapForSorted(ar2));
		assertFalse(MyArrays.isOneSwapForSorted(ar3));
		assertFalse(MyArrays.isOneSwapForSorted(ar4));
		assertFalse(MyArrays.isOneSwapForSorted(ar5));
		assertFalse(MyArrays.isOneSwapForSorted(ar6));
		assertFalse(MyArrays.isOneSwapForSorted(ar7));
		}
	
	@Test
	void isOneSwapTestTrue() {
		int ar1[] = { 10, 2, 3, 4, 1 };
		int ar2[] = { 1, 2, 4, 3, 5, 10 };
		int ar3[] = { 1, 2, 3, 10, 5, 4 };
		int ar4[] = { 1, 5, 3, 4, 2, 10 };
		int ar5[] = { 1, 2, 3, 4, 10, 5 };
		int ar6[] = { 2, 1, -3, 4, 5, 10 };
		int ar7[] = { 3, 2, 1, 4, 5, 6 };
		assertTrue(MyArrays.isOneSwapForSorted(ar1));
		assertTrue(MyArrays.isOneSwapForSorted(ar2));
		assertTrue(MyArrays.isOneSwapForSorted(ar3));
		assertTrue(MyArrays.isOneSwapForSorted(ar4));
		assertTrue(MyArrays.isOneSwapForSorted(ar5));
		assertTrue(MyArrays.isOneSwapForSorted(ar6));
		assertTrue(MyArrays.isOneSwapForSorted(ar7));
		}

	@Test
	void bubbleSortTest() {
		assertArrayEquals(new int[] {10, 20, 25, 30, 40, 50}, MyArrays.bubbleSort(new int[] {10, 20, 25, 30, 50, 40}));	
		assertArrayEquals(new int[] {10}, MyArrays.bubbleSort(new int[] {10}));
		assertArrayEquals(new int[] {}, MyArrays.bubbleSort(new int[] {}));
		
	}
	
}
