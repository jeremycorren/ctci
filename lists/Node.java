public class Node {
	int data;
	Node next;
	Node prev;

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	public static String asString(Node list) {
		StringBuilder sb = new StringBuilder();
		for (Node n = list; n != null; n = n.next) {
			sb.append(n.data + " ");
		}
		return sb.toString();
	}
}