/**
 * Remove middle item from singly-linked list
 */

public class RemoveMiddle {

	/**
	 * 1->2->3->4, drop 2 given 2:
	 *	1->3->3->4
	 *	1->3---->4
	 */
	public static void removeMiddle(Node n) {
		Node next = n.next;
		n.data = next.data; //Copy next data to n
		n.next = next.next; //Leapfrog n.next over next to drop next from list
	}

	public static void main(String[] args) {
		Node list = new Node(10, null);
		Node second = new Node(20, null);
		list.next = second;
		Node third = new Node(30, null);
		second.next = third;

		removeMiddle(second);
		System.out.println(Node.asString(list));
	}
}