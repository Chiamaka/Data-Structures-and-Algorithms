package org.meltwater.java.datastructures;

import java.util.Arrays;

public class SinglyLinkedList<E> {

}

class LinkedList<E> {
	private Node head;
	private int listCount;

	public LinkedList() {
		head = new Node(null);
		listCount = 0;
	}

	public void add(int position, E element) {
		Node LinkedListTemp = new Node(element);
		Node firstLink = head;

		for (int i = 1; i < position && firstLink.getNext() != null; i++) {
			firstLink = firstLink.getNext();
		}

		LinkedListTemp.setNext(firstLink.getNext());

		firstLink.setNext(LinkedListTemp);
		listCount++;
	}

	

	public int size() {
		return listCount;
	}

	public String toString() {
		Node currentLink = head.getNext();
		String output = "";
		while (currentLink != null) {
			output += "[" + currentLink.getData().toString() + "]";
			currentLink = currentLink.getNext();
		}
		return output;
	}

	private class Node {
		Node next;
		E data;

		public Node(E dataValue) {
			next = null;
			data = dataValue;
		}

		public Node(E dataValue, Node nextValue) {
			next = nextValue;
			data = dataValue;
		}

		public Object getData() {
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
}