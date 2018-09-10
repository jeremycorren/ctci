import java.util.*;

/**
 * Determine if a *sorted* array contains two items that sum to k.
 */

public class TwoSum {

	/**
	 * Compare all pairs to check if any sum to k
	 * Time: O(N^2)
	 */
	public static boolean twoSumBruteForce(int[] a, int k) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] + a[j] == k) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Sort and for each item, search for k complement
	 * Time: O(N log N)
	 */
	public static boolean twoSumSearch(int[] a, int k) {
		for (int i = 0; i < a.length; i++) { //O(N)
			int idx = Arrays.binarySearch(a, k - a[i]); //O(log N)

			//Cannot sum val at same index w/ itself!
			if (idx >= 0 && idx != i) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Walk two pointers inward, comparing sums
	 * Time: O(N)
	 */
	public static boolean twoSumPointers(int[] a, int k) {
		int i = 0;
		int j = a.length - 1;

		//Until pointers meet
		while (i < j) {
			int sum = a[i] + a[j];
			if (sum < k) { 
				i++; //Replace left member of pair => larger sum
			} else if (sum > k) {
				j--; //Replace right member of pair => smaller sum
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] a = { 3, 7, 10, 15 };
		int k = 17;

		System.out.println(twoSumBruteForce(a, k));
		System.out.println(twoSumSearch(a, k));
		System.out.println(twoSumPointers(a, k));
	}
}