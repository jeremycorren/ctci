import java.util.*;
import java.lang.*;

/**
 * Doubly-linked list implementation
 */

public class List<T> {

	/**
	 * Keep refs to front and back of list
	 */
	private Node head;
	private Node tail;
	private int size = 0;

	/**
	 * Inner class: only enclosing class List can access fields
	 */
	private class Node {
		T data;
		Node next;
		Node prev;
	}

	/**
	 * Add to front of list in O(1)
	 */
	public void addLeft(T data) {
		Node oldHead = head; //Save ref to list
		head = new Node();
		head.data = data;
		head.next = oldHead; //Append list to new head
		head.prev = null;
		
		if (isEmpty()) {
			tail = head;
		}
		size++;
	}

	/**
	 * Add to back of list in O(1)
	 */
	public void addRight(T data) {
		Node oldTail = tail; //Save tail ref
		tail = new Node();
		tail.data = data;
		
		if (isEmpty()) {
			head = tail; //Single node in list
		} else {
			tail.prev = oldTail; //Point back to list
			oldTail.next = tail; //Append new tail to list
		}
		size++;
	}

	/**
	 * Remove from front of list in O(1)
	 */
	public T removeLeft() {
		T data = head.data;
		head = head.next; //Shift head ref forward
		head.prev = null; //Toss ref to removed head

		if (isEmpty()) {
			head = tail;
		}
		size--;
		return data;
	}

	/**
	 * Remove from back of list in O(1)
	 */
	public T removeRight() {
		T data = tail.data;
		tail = tail.prev;
		tail.next = null;

		if (isEmpty()) {
			head = tail;
		}
		size--;
		return data;
	}

	/**
	 * Delete the kth node in O(N)
	 * Based on position, step through from head or tail
	 */
	public T delete(int k) {
		if (k < 0 || k > size - 1) throw new UnsupportedOperationException("Index out of bounds.");
		if (k == 0) return removeLeft();
		if (k == size - 1) return removeRight();

		int i = 0;
		for (Node n = head; n != null; n = n.next) {
			if (i == k) {
				//Leapfrog from n.prev to n.next and vice versa to drop n
				n.prev.next = n.next;
				n.next.prev = n.prev;
				return n.data;
			}
			i++;
		}
		return null;
	}

	/**
	 * Traverse links and print Node data in list in O(N)
	 */
	public String asString() {
		StringBuilder sb = new StringBuilder();
		for (Node n = head; n != null; n = n.next) {
			sb.append(n.data);
			sb.append(" ");
		}
		return sb.toString();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		List<Integer> list = new List<>();
		for (int i = 0; i < 4; i++) {
			list.addRight(i);
		}
		System.out.println(list.asString());
	}
}