/** 
 * Partition items in list around k
 */

public class Partition {
	/**
	 * Add items around k in new list
	 * Time: O(N)
	 */ 
	public static Node partition(Node list, int k) {
		Node head = new Node(k, null);
		Node tail = head;
		for (Node n = list; n != null; n = n.next) { //O(N)
			if (n.data < k) { //O(1)
				//Prepend
				Node node = new Node(n.data, head);
				head = node;
			} else if (n.data > k) { //O(1)
				//Append
				Node node = new Node(n.data, null);
				tail.next = node;
				tail = node;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		Node list = new Node(2, new Node(5, new Node(1, new Node(4, null))));
		System.out.println(Node.asString(partition(list, 3)));
	}
}