import java.util.*;

/**
 * Reverse an array.
 */

public class Reverse {
	/**
	 * Step through iteratively and swap outer pairs
	 * Time: O(N)
	 */
	public static int[] reverse(int[] a) {
		// Swap items until midpoint of array
		// Otherwise we swap twice and end up with original ordering
		for (int i = 0; i < a.length / 2; i++) { // O(N/2)
			int complement = a.length - 1 - i;
			
			int t = a[i];
			a[i] = a[complement];
			a[complement] = t;
		}
		return a;
	}

	/**
	 * Push items onto stack and pop
	 * Time: O(N)
	 * Space: O(N)
	 */
	public static int[] reverseWithStack(int[] a) {
		Deque<Integer> stack = new ArrayDeque<>();
		for (Integer i : a) { //O(N)
			stack.push(i); //O(1)
		}

		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) { //O(N)
			b[i] = stack.pop(); //O(1)
		}
		return b;
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};

		for (Integer i : reverseWithStack(a)) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}