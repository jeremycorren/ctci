import java.util.*;

/**
 * Determine if list is a palindrome
 */ 

public class Palindrome {

	/**
	 * If palindrome, stack output should match list iteration
	 * Time: O(N)
	 * Space: O(N)
	 */
	public static boolean isPalindrome(Node list) {
		Deque<Integer> stack = new ArrayDeque<>();
		for (Node n = list; n != null; n = n.next) { //O(N)
			stack.push(n.data); //O(1)
		}

		//Since palindrome reads same forwards and backwards:
		//Stack, or reversed, output, should match forward input
		for (Node n = list; n != null; n = n.next) { //O(N)
			if (n.data != stack.pop()) { //O(1)
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Node list = new Node(1, new Node(2, new Node(2, new Node(1, null))));
		System.out.println(isPalindrome(list));
	}
}