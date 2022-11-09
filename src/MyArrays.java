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
		if (index <= array.length - 1 & index >= 0) {
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
	public static int[] insertSorted(int[] arraySorted, int number) {
		int[] newArray = new int[arraySorted.length+1];
		int position = Math.abs(Arrays.binarySearch(arraySorted, number));
		System.arraycopy(arraySorted, 0, newArray, 0, position-1);
		newArray[position-1] = number;
		System.arraycopy(arraySorted, position-1, newArray, position, newArray.length - position);
		
		return newArray;
	}

}
