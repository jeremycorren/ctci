/**
 * List implementation of a stack
 */

public class ListStack<T> implements Stack<T> {
	Node head;

	private class Node {
		T data;
		Node next;

		Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	/**
	 * Add to front of list in O(1)
	 */
	public void push(T data) {
		Node oldHead = head;
		head = new Node(data, oldHead);
	}

	/**
	 * Remove from front of list in O(1)
	 */
	public T pop() {
		T data = head.data;
		head = head.next;
		return data;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new ListStack<>();

		for (int i = 1; i < 4; i++) {
			stack.push(i);
		}

		for (int i = 1; i < 4; i++) {
			System.out.println(stack.pop());
		}
	}
}