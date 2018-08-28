import java.util.*;

/**
 * Determine if two strings are permutations of one another.
 * Def'n of permutation: two strings with same char frequencies
 */

public class Permutation {
	
	/**
	 * Sort strings and compare for equality
	 * Time: O(N log N)
	 */
	public static boolean arePermutationsSort(String s1, String s2) {
		// Permutations must have same amount of chars
		if (s1.length() != s2.length()) {
			return false;
		}

		char[] a = s1.toCharArray();
		Arrays.sort(a); // O(N log N)

		char[] b = s2.toCharArray();
		Arrays.sort(b); // O(N log N)

		return Arrays.equals(a, b); // O(N)
	}

	/**
	 * Use array to mark char frequency by unique ASCII value
	 * Time: O(max(len(a), len(b)))
	 * Space: O(1) since char array is fixed at length 128
	 */
	public static boolean arePermutationsFrequency(String a, String b) {
		// Permutations must have same amount of chars
		if (a.length() != b.length()) {
			return false;
		}

		int[] chars = new int[128];

		// Increment array index by ASCII value for occurrence
		for (int i = 0; i < a.length(); i++) { // O(len(a))
			chars[a.charAt(i)]++;
		}

		// If same # of occurrences, should decrement back to 0
		// If negative, either
		// 	(1) Different # of occurrences of a char shared by both str's
		// 	(2) A char appeared in str b but not in str a (-1)
		for (int i = 0; i < b.length(); i++) { // O(len(b))
			chars[b.charAt(i)]--;
			if (chars[b.charAt(i)] < 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "abc";
		String t = "bac";
		String u = "abd";

		System.out.println(arePermutationsSort(s, t));
		System.out.println(arePermutationsSort(s, u));

		System.out.println(arePermutationsFrequency(s, t));
		System.out.println(arePermutationsFrequency(s, u));		
	}
}