/**
 * Array implementation of stack
 */

public class ArrayStack<T> implements Stack<T> {
	Object[] a = (T[]) new Object[10];
	int size = 0; //Points to top of the stack

	/**
	 * Insert into next empty array space in O(1)
	 */
	public void push(T data) {
		//Fill space and increment size
		a[size++] = data;
	}

	/**
	 * Remove item from end of array in O(1)
	 */
	public T pop() {
		return (T) a[--size];
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new ArrayStack<>();

		for (int i = 1; i < 4; i++) {
			stack.push(i);
		}

		for (int i = 1; i < 4; i++) {
			System.out.println(stack.pop());
		}
	}
}