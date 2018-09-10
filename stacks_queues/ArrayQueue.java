/**
 * Array implementation of queue
 */

public class ArrayQueue<T> implements Queue<T> {
	Object[] a = (T[]) new Object[10];
	int front = 0;
	int back = 0;

	public void enqueue(T data) {
		a[back++] = data;
	}

	public T dequeue() {
		return (T) a[front++];
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayQueue<>();
		for (int i = 1; i < 4; i++) {
			queue.enqueue(i);
		}

		for (int i = 1; i < 4; i++) {
			System.out.println(queue.dequeue());
		}
	}
}