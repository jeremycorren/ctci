import java.util.*;

/**
 * Determine whether an array has all unique items.
 */

public class Unique {
	/**
 	 * Brute force: compare all pairs, if any match, has dups
 	 * Time: O(N^2)
 	 */
	public static boolean allUnique(int[] a) { // O(N * (N-1)/2) = O(N^2)
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Sort, compare neighbors, if match, has dups
	 * Time: O(N log N)
	 */
	public static boolean allUniqueSorted(int[] a) {
		Arrays.sort(a); // O(N log N)
		for (int i = 0; i < a.length - 1; i++) { // O(N)
			if (a[i] == a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Add values to set, check if new item in set has key, has dups
	 * Time: O(N)
	 * Space: O(N)
	 */
	public static boolean allUniqueWithSet(int[] a) {
		Set<Integer> set = new HashSet<>();
		for (Integer i : a) { // O(N)
			if (!set.add(i)) { // O(1)
				return false;
			}
		}
		return true;
	}

	/**
	 * Variant: check if chars in a string are unique
	 * Every ASCII char has a correspondent unique int value
	 * Use array indices to track whether a char has appeared in str
	 * Time: O(1) since loop steps over max input string of length 128
	 * Space: O(1) since char array is fixed at length 128
	 */
	public static boolean allUniqueString(String s) {
		// Largest ASCII string w/ unique chars has max 128 length
		if (s.length() > 128) {
			return false;
		}

		boolean[] charSet = new boolean[128];
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i);

			// If char present, has dups, otherwise mark present
			if (charSet[val]) {
				return false;
			}
			charSet[val] = true;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] unique = {1, 2, 3};
		int[] dups = {1, 2, 1};

		String uniqueStr = "abc";
		String dupStr = "aba";

		System.out.println(allUnique(unique));
		System.out.println(allUnique(dups));

		System.out.println(allUniqueWithSet(unique));
		System.out.println(allUniqueWithSet(dups));

		System.out.println(allUniqueSorted(unique));
		System.out.println(allUniqueSorted(dups));

		System.out.println(allUniqueString(uniqueStr));
		System.out.println(allUniqueString(dupStr));
	}
}