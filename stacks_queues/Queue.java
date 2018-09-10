/**
 * Queue
 */

public interface Queue<T> {
	public void enqueue(T data);

	public T dequeue();
}