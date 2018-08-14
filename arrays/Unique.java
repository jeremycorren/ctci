import java.util.*;

/**
 * Determine whether an array has all unique items.
 */

public class Unique {
	/**
 	 * Brute force: compare all pairs, if any match, has dups
 	 * Time: O(N^2)
 	 */
	public static boolean allUnique(int[] a) { 	// O(N * (N-1)/2) = O(N^2)
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
		Arrays.sort(a);									// O(N log N)
		for (int i = 0; i < a.length - 1; i++) {	// O(N)
			if (a[i] == a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Add values to set, check if new item in set as key, has dups
	 * Time: O(N)
	 * Space: O(N)
	 */
	public static boolean allUniqueWithSet(int[] a) {
		Set<Integer> set = new HashSet<>();
		for (Integer i : a) {	// O(N)
			if (!set.add(i)) {	// O(1)
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] unique = {1, 2, 3};
		int[] dups = {1, 2, 1};

		System.out.println(allUnique(unique));
		System.out.println(allUnique(dups));
		
		System.out.println(allUniqueWithSet(unique));
		System.out.println(allUniqueWithSet(dups));

		System.out.println(allUniqueSorted(unique));
		System.out.println(allUniqueSorted(dups));
	}
}