/**
 * Find kth to last element in a list
 */

public class KtoLast {

	/**
	 * Use two pointers k items apart
	 */
	public static int kToLast(Node list, int k) {
		//Place a pointer at kth item
		Node p1 = list;
		for (int i = 0; i < k; i++) {
			p1 = p1.next;
		}

		//Place another at front, iterate both simultaneously
		//When p1 at end, p2 will be at kth-to-last item
		Node p2 = list;
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2.data;
	}

	public static void main(String[] args) {
		Node list = new Node(10, 
			new Node(20, 
				new Node(30, 
					new Node(40, 
						new Node(50, null)))));
		System.out.println(kToLast(list, 2));
	}
}