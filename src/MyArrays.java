import java.util.Arrays;

public class MyArrays {

/**
 * 
 * @param array
 * @param number
 * @return new array with added at given number
 */
	public static int[] addsNumber(int[] array, int number) {
		int[] newArray = Arrays.copyOf(array, array.length + 1);
		newArray[newArray.length-1] = number;	
	return newArray;
}
	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array with no number at a given index in given array
	 * if index does not exist in given array it returns the same array
	 */
	public static int[] removeNumber(int[] array, int index) {
		if (index < array.length && index > -1) {
			int[] newArray = new int[array.length-1];
			System.arraycopy(array, 0, newArray, 0, index);	
			System.arraycopy(array, index+1, newArray, index, newArray.length-index);
			array = Arrays.copyOf(newArray, newArray.length);
			}
		return array;
	}
	
	/**
	 * 
	 * @param arraySorted sorted array
	 * @param number
	 * @return new array with inserted number at an index for keeping array sorted
	 */
	public static int[] insertSorted(int[] arraySorted, int number) {   //!!!!!????? Элемент 0, абсолютная величина -1, 
		int[] newArray = new int[arraySorted.length+1];
		int position = Math.abs(Arrays.binarySearch(arraySorted, number)); //if index < 0; index = -(index + 1)
		System.arraycopy(arraySorted, 0, newArray, 0, position-1);
		newArray[position-1] = number;
		System.arraycopy(arraySorted, position-1, newArray, position, newArray.length - position);
		
		return newArray;
	}
	
	private static int[] insertAtIndex(int[] array, int number, int index) {
		int res[] = new int[array.length+1];
		System.arraycopy(array, 0, res, 0, index);
		res[index] = number;
		System.arraycopy(array, 0, res, index+1, array.length - index);
		return res;
	}

	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return index value if number exist other -1
	 * O[N] - search number in unsorted array
	 * O[LogN] - search number in sorted (binary search)
	 */
	public static int binarySearch(int[] arraySorted, int number) {
	int left = 0;
	int right = arraySorted.length - 1;
	int middle = right / 2;
	
	while(left <= right && arraySorted[middle] != number) {
		if (number < arraySorted[middle]) {
			right = middle - 1;
		} else {
			left = middle + 1;
		}
		middle = (left + right) / 2;
	}
		
	return	 left > right ? -1 : middle;
	}
	
	//Home Work lesson 7 10.11.2022
	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return index of first value (if value repeat) if number exist other -1
	 */
	
	public static int binarySearchFirstDigit(int[] arraySorted, int number) {
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = right / 2;
		middle = moveMiddleToFirstTrueValue(arraySorted, middle);
		
		while(left <= right && arraySorted[middle] != number) {
			if (number < arraySorted[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
			middle = moveMiddleToFirstTrueValue(arraySorted, middle);
		}
			
		return	 left > right ? -1 : middle;
		}
	
	private static int moveMiddleToFirstTrueValue(int[] arraySorted, int middle) {
		while (middle > 0 && arraySorted[middle-1] == arraySorted[middle]) {
			middle--;
		}
		return middle;
	}
	
	/**
	 * 
	 * @param array
	 * @return true if the array is unsorted but only one swap between two numbers is required for getting a sorted array
	 * @return false if the array is sorted or more one swap required to get a sorted array
	 */
	public static boolean isOneSwapForSorted(int[] array) {
		int[] arraySorted = Arrays.copyOf(array, array.length);
		Arrays.sort(arraySorted);
		int swapQuantity = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != arraySorted[i]) {
				swapQuantity++;
			}
		}
		return (swapQuantity == 2) ? true : false;
	}
	
	/**
	 * 
	 * @param array (sorted or unsorted array)
	 * @return sorted array
	 */
	public static int[] bubbleSort(int[] array) {
	int numberOfPermutation = 0;
	do {
		numberOfPermutation = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				moveGreaterRight(array, i);
				numberOfPermutation++;
			}
		} 
	} while (numberOfPermutation != 0);
		
	return array;
	
}

private static void moveGreaterRight(int[] array, int i) {
	int temp = array[i];
	array[i] = array[i + 1];
	array[i + 1] = temp;
}	
	
}
