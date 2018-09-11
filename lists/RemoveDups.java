import java.util.*;

/**
 * Remove duplicates from list
 */ 

public class RemoveDups {

	/**
	 * Compare each Node to all subsequent Nodes
	 * Time: O(N^2)
	 */
	public static void removeDups(Node list) {
		for (Node m = list; m != null; m = m.next) {
			Node prev = m;
			for (Node n = m.next; n != null; n = n.next) {
				if (m.data == n.data) {
					prev.next = n.next;
				}
				prev = n;
			}
		}
	}

	/**
	 * Add to set while stepping through, remove dups if match
	 * Time: O(N)
	 * Space: O(N)
	 */
	public static void removeDupsSet(Node list) {
		Set<Integer> set = new HashSet<>();

		Node prev = null;
		for (Node n = list; n != null; n = n.next) { //O(N)
			if (set.contains(n.data)) { //O(1)
				prev.next = n.next; //O(1)
			} else {
				set.add(n.data); //O(1)
			}
			prev = n;
		}
	}

	public static void main(String[] args) {
		Node list = new Node(3, new Node(3, new Node(2, null)));
		removeDups(list);
		System.out.println(asString(list));
	}
}