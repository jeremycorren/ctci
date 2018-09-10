import java.util.*;

/**
 * Given an array, return all pairs whose difference is k.
 * 
 * Here we identify bottlenecks and optimize them.
 */

public class DifferencePairs {

	/**
	 * Find all pairs and check if diff is k
	 * Time: O(N^2)
	 * 
	 * Bottleneck: Finding the other half of pair
	 */
	public static List<List<Integer>> findPairsBruteForce(int[] a, int k) {
		List<List<Integer>> pairs = new ArrayList<List<Integer>>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[j] - a[i] == k) {
					pairs.add(makePair(a[i], a[j]));
				}
			}
		}
		return pairs;
	}

	/**
	 * Sort and for each item search for k complement
	 * Time: O(N log N)
	 *
	 * Insight: notice that in previous method, we want to
	 * search for a particular item for each item: use a Search algo
	 *
	 * Bottleneck: Sort takes too long
	 */
	public static List<List<Integer>> findPairsBinarySearch(int[] a, int k) {
		List<List<Integer>> pairs = new ArrayList<List<Integer>>();
		Arrays.sort(a); //O(N log N)
		for (Integer i : a) { // O(N)
			int compIdx = Arrays.binarySearch(a, i + k); //O(log N)
			if (compIdx >= 0) {
				pairs.add(makePair(i, a[compIdx]));
			}
		}
		return pairs;
	}

	/**
	 * Add all to set, step through and get k complement
	 * Time: O(N)
	 * Space: O(N)
	 *
	 * Insight: Hashmaps provide constant time lookup and retrieval,
	 * we tradeoff space for better time
	 */
	public static List<List<Integer>> findPairsHashMap(Integer[] a, int k) {
		List<List<Integer>> pairs = new ArrayList<List<Integer>>();

		Map<Integer, Integer> map = new HashMap<>();
		for (Integer i : a) { //O(N)
			map.put(i, i);
		}

		for (Integer i : a) { //O(N)
			if (map.containsKey(i + k)) { //O(1)
				pairs.add(makePair(i, map.get(i + k))); //O(1)
			}
		}
		return pairs;
	}

	/**
	 * Helper method
	 */
	private static List<Integer> makePair(int a, int b) {
		return new ArrayList<Integer>(Arrays.asList(a, b));
	}

	public static void main(String[] args) {
		Integer[] a = { 1, 7, 5, 9, 2, 12, 3 };
		for (List<Integer> pair : findPairsHashMap(a, 2)) {
			for (Integer i : pair) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}

	}
}