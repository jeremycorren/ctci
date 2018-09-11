/**
 * Reverse a list
 */

public class Reverse {
	public static Node reverse(Node list) {
		Node head = null;
		while (list != null) {
			//Prepend new node and set as head
			Node n = new Node(list.data, head);
			head = n;
			list = list.next;
		}
		return head;
	}

	public static void main(String[] args) {
		Node list = new Node(1, 
			new Node(2, 
				new Node(3, null)));
		System.out.println(Node.asString(reverse(list)));
	}
}