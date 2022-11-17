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
	 * not best solution
	 */ 
	
	public static int binarySearchFirstDigit(int[] arraySorted, int number) {
		int left = 0;
		int right = arraySorted.length;
		int middle = arraySorted.length / 2;
		
		while(left <= right && arraySorted[left] != number) {
			if (arraySorted[middle] >= number) {
				right = middle - 1;
			} else {
				left = middle + 1;				
			}
			middle = (left + right) / 2;			
		}
		return left < arraySorted.length && arraySorted[left] == number ? left : (-left -1) ;
	}
	
	/**
	 * 
	 * @param array
	 * @return true if the array is unsorted but only one swap between two numbers is required for getting a sorted array
	 * @return false if the array is sorted or more one swap required to get a sorted array
	 */
	public static boolean isOneSwapForSorted(int array[]) {

		// The method returns true if an given array is not sorted
		// but to do it sorted there should be done only one swap of any numbers (not
		// mandatory
		// that the being swapped numbers placed one after other)

		int index1 = -1;
		int index2 = -1;
		int length = array.length - 1;
		int equaledCount = 0;
		boolean res = true;
		int i = 0;
		while (i < length && res) {
			if (array[i] > array[i + 1]) {
				if (index1 == -1) {
					index1 = i - equaledCount;
					if (equaledCount > 0) {
						index2 = i + 1;
					}
				} else if (index2 != -1) {
					res = false;
				} else {
					index2 = i + 1;
				}
			} else if (array[i] == array[i + 1]) {
				equaledCount++;
			} else if (array[i] < array[i + 1]) {
				if (equaledCount != 0 && index1 != -1 && index2 == -1 && array[i] < array[index1]) {
					index2 = i;
				}
				equaledCount = 0;
			}
			i++;
		}
		return index1 != -1 && res ? checkIndexes(array, index1, index2) : false;

	}

	private static boolean checkIndexes(int[] array, int index1, int index2) {

		return index2 == -1 ? checkOneIndex(array, index1) : checkTwoIndexes(array, index1, index2);
	}

	private static boolean checkTwoIndexes(int[] array, int index1, int index2) {

		return (index2 == array.length - 1 || array[index1] <= array[index2 + 1]) 
				&& array[index2] <= array[index1 + 1]
				&& (index1 == 0 || array[index2] >= array[index1 - 1]);
		
	}

	private static boolean checkOneIndex(int[] array, int index) {

		return (index == array.length - 2 || array[index] <= array[index + 2])
				&& (index == 0 || array[index + 1] >= array[index - 1]);
	}
	
	/**
	 * 
	 * @param array (sorted or unsorted array)
	 * @return sorted array
	 */
	static public void bubbleSort(int[] array) { 
		int unsortedLength = array.length;
		do {
			unsortedLength = moveGreaterRight(array, unsortedLength - 1);
		} while (unsortedLength != 0) ;
	}

	static private int moveGreaterRight(int[] array, int length) {
		int res = 0;
		for (int i = 0; i < length; i++) {
			if(array[i] > array[i + 1]) {
				res = i + 1;
				swap(array, i, i + 1);
			}
		}
		return res;
	}

	static private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
		
	}
}
