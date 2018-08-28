/**
 * Reverse an array.
 */

public class Reverse {
	/**
	 * Step through iteratively and swap outer pairs
	 * Time: O(N)
	 */
	public static void reverse(int[] a) {
		// Swap items until midpoint of array
		// Otherwise we swap twice and end up with original ordering
		for (int i = 0; i < a.length / 2; i++) { // O(N/2)
			int complement = a.length - 1 - i;
			
			int t = a[i];
			a[i] = a[complement];
			a[complement] = t;
		}
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6};

		reverse(a);
		for (Integer i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}