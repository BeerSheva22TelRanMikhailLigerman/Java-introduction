
public class Strings {

	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return true if str2 is an anagram of str1
	 * complexity O[N] two passes
	 * only one additional array
	 * only symbols or English letters
	 * 1. the same length
	 * 2. the same symbols just in different order
	 */
	public static boolean isAnagram(String str1, String str2) {
		boolean res = false;
		if (str1.length() == str2.length() && str1.length() > 1) {
			char[] str1Arr = str1.toCharArray();
			char[] str2Arr = str2.toCharArray();
			char[] helper = new char[Character.MAX_VALUE];
			int arrHelperSum = 0;
			int nonDifCounter = 0;
			
			for (int i = 0; i < str1Arr.length; i++) {
				helper[str1Arr[i]]++;
				helper[str2Arr[i]]--;
				if (str1Arr[i] != str2Arr[i]) {nonDifCounter++;}
			} 
			for (int i = 0; i < helper.length; i++) {
				arrHelperSum += Math.abs(helper[i]);
			}
			res = (arrHelperSum == 0 && nonDifCounter != 0);		
		}
		return res;
	}
	
	public static boolean isAnagram2(String str1, String str2) {
		boolean res = false;
		if (str1.length() == str2.length() && str1.length() > 1) {
		char[] str1Arr = str1.toCharArray();
		char[] str2Arr = str2.toCharArray();
		boolean[] helper = new boolean[Character.MAX_VALUE];
		int nonDifCounter = 0;
			
			for (int i = 0; i < str1Arr.length; i++) {
				helper[(int)str1Arr[i]] = !helper[(int)str1Arr[i]];
				helper[(int)str2Arr[i]] = !helper[(int)str2Arr[i]];
				if (str1Arr[i] != str2Arr[i]) {nonDifCounter++;}
			} 
			for (int i = 0; i < helper.length; i++) {
				res = res | helper[i];
			}
			res = !res && nonDifCounter != 0;
		}
		return res;
	}
	
}
