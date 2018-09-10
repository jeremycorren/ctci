/**
 * List implementation of a queue
 */

public class ListQueue<T> implements Queue<T> {
	Node head;
	Node tail;
	int size = 0;

	private class Node {
		T data;
		Node next;

		Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	/**
	 * Add to back of list in O(1)
	 */
	public void enqueue(T data) {
		Node oldTail = tail;
		tail = new Node(data, null);
		if (size == 0) {
			head = tail;
		} else {
			oldTail.next = tail;
		}
		size++;
	}

	/**
	 * Remove from front of list in O(1)
	 */
	public T dequeue() {
		T data = head.data;
		head = head.next;
		return data;
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new ListQueue<>();
		for (int i = 1; i < 4; i++) {
			queue.enqueue(i);
		}

		for (int i = 1; i < 4; i++) {
			System.out.println(queue.dequeue());
		}
	}
}