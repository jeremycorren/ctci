import java.util.*;

/**
 * Determine if a string is a permutation of a palindrome.
 */

public class Palindrome {
	
	/**
	 * Infeasible brute force solution:
	 * Find all permutations of a string, takes O(N!)
	 * Check if any of the permutations is a palindrome
	 *
	 * Instead, examine properties of permutations of palindromes
	 */

	/**
	 * Palindrome of
	 *  (1) even length: each char must have even # of occurrences
	 *		Ex: "accbabbb" => "abcbbcba"
	 *	 (2)	odd length: same as above, plus a single middle char
	 *		Ex: "accbabddd" => "abdcdcbda"
	 * Time: O(len(s))
	 * Space: O(1) fixed array for char counts
	 */
	public static boolean isPermutationOfPalindrome(String s) {
		int[] chars = new int[128];
		int oddCount = 0;

		// Count occurrences per char
		for (int i = 0; i < s.length(); i++) { // O(len(s))
			char ch = s.charAt(i);
			chars[ch]++;
		}

		// Assert no more than one char with odd # of occurrences
		boolean foundOdd = false;
		for (int frequency : chars) { // O(1)
			if (!(frequency % 2 == 0)) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPermutationOfPalindrome("accbabbb"));
		System.out.println(isPermutationOfPalindrome("accbabddd"));
		System.out.println(isPermutationOfPalindrome("abbacddd"));
	}
}