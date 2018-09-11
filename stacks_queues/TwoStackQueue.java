import java.util.*;

/**
 * Implement a queue with two stacks
 */

public class TwoStackQueue {
	Deque<Integer> inStack = new ArrayDeque<>();
	Deque<Integer> outStack = new ArrayDeque<>();

	public void enqueue(Integer data) {
		inStack.push(data);
	}

	public Integer dequeue() {
		for (Integer item : inStack) {
			outStack.push(inStack.pop());
		}
		return outStack.pop();
	}

	public static void main(String[] args) {
		TwoStackQueue q = new TwoStackQueue();
		for (int i = 1; i < 4; i++) {
			q.enqueue(i);
		}
		for (int i = 1; i < 4; i++) {
			System.out.println(q.dequeue());
		}
	}
}