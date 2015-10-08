package org.meltwater.java.datastructures;

import java.util.Arrays;

public class SinglyLinkedList<E> {

	private Node head;
	private int size;

	public SinglyLinkedList() {
		head = new Node(null);
		size = 0;
	}
	
	/**
	 * 
	 * Adds elements to the linkedlist at the specified position
	 * Return type: void
	 * Big O: O(N)
	 */
	public void add(int position, E element) {
		Node node = new Node(element);
		Node current = head;
		for (int i = 0; (i < position) && (current.getNext() != null); i++) {
			current = current.getNext();
		}

		node.setNext(current.getNext());
		current.setNext(node);
		size++;
	}
	/**
	 * 
	 * Inserts the specified elem1 before the elem2
	 * Return type: void
	 * Big O: O(N)
	 */
	public void insertBefore(E elem1, E elem2){
		Node temp = new Node(elem2);
		Node current = head;
		while(true){
			if((current.getNext().getData() == elem1) || (current.getNext().getData() == null)) break;
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		size++;
	}
	
	/**
	 * 
	 * Returns the head/first element of the linkedlist
	 * Return type: Node
	 * Big O: O(1)
	 */
	public Node head() {
		return head.getNext();
	}
	
	/**
	 * 
	 * Returns the tail/last element of the linkedlist
	 * Return type: Node
	 * Big O: O(1)
	 */
	public Node tail() {
		if (size <= 1) {
			return head.getNext();
		}
		Node current = head.getNext();
		while (true) {
			if (current.getNext() == null) {
				return current;
			}
			current = current.getNext();
		}
	}

	/**
	 * 
	 * Returns the size of the linkedlist
	 * Return type: Int
	 * Big O: O(1)
	 */
	public int size() {
		return size;
	}
	/**
	 * 
	 * Returns true if the linkedlist is empty, false otherwise.
	 * Return type: Boolean
	 * Big O: O(1)
	 */
	public boolean isEmpty() {
		return (size < 0) ? true : false;
	}
	
	/**
	 * 
	 * Returns the element that has been removed from the linkedlist
	 * Return type: Int
	 * Big O: O(1)
	 */
	private boolean remove(E element) {
		Node current = head;
		for (int i = 0; i < size; i++) {
			if (current.getNext() == null) {
				return false;
			}
			if (current.getNext().getData() == element) {
				current.setNext(current.getNext().getNext());
				size--;
			}
			current = current.getNext();
		}
		return true;
	}
	
	/**
	 * Returns the linkedlist as a String
	 * Return type: String
	 * Big O: O(N)
	 */
	public String toString() {
		Node current = head.getNext();
		String output = "{";
		while (current != null) {
			output += "[" + current.getData().toString() + "]";
			current = current.getNext();
		}
		output += "}";
		return output;
	}

	/**
	 * 
	 * Class node which contains the node and the value
	 *
	 */
	private class Node {
		private Node next;
		private E data;

		public Node(E dataValue) {
			next = null;
			data = dataValue;
		}

		public Node(E dataValue, Node nextValue) {
			next = nextValue;
			data = dataValue;
		}

		public E getData() {
			return data;
		}

		public void setData(E dataValue) {
			data = dataValue;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node nextValue) {
			next = nextValue;
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList single = new SinglyLinkedList();
		single.add(0, "hi");
		single.add(1, 2);
		single.add(2, "waddup");

		System.out.println(single.remove(2));
		System.out.println(single.toString());
	}
}