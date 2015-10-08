package org.meltwater.java.datastructures;

import java.util.Arrays;

public class BetterArray<E> {

	private E[] array;
	private int size;

	public BetterArray(int size) {
		array = (E[]) new Object[size];
		size = 0;
	}

	/**
	 * Inserts the specified element in the specified position
	 * Input: Integer, Generic element
	 * Return type: void ; Big-O analysis: O(N)
	 */
	public void insert(int position, E element) {
		if (position < array.length) {
			this.array[position] = element;
			size++;
		} else {
			E[] newArray = (E[]) new Object[array.length * 2];
			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];		
			}
			array = newArray;
			this.array[size++] = element;
		}
		
	}

	/**
	 * Inserts the specified element at the beginning of the array and pushes all other elements back.
	 * Input: Generic element
	 *  Return type: void ; Big-O analysis: O(N)
	 */
	public void shift(E element) {
		if (isEmpty()) {
			insert(0, element);
		} else {
			for (int i = size; i >= 0; i--) {
				array[i + 1] = array[i];
			}
			insert(0, element);
		}

	}

	/**
	 * Inserts the specified element at the end of the array and moves all other elements forward.
	 * Input: Generic element
	 * Return type: void ; Big-O analysis: O(N)
	 */

	public void append(E element) {
		if (isEmpty()) {
			shift(element);
		} else {
			for (int i = 1; i <= size; i++) {
				array[i - 1] = array[i];
			}
			size--;
			insert(size, element);
		}
	}

	/**
	 * Returns the index of the specified element.
	 * Input: Generic element
	 * Return type: Integer ; Big-O analysis: O(N)
	 */
	public int index(E element) {
		for (E i : array) {
			if (i == element) {
				return Arrays.asList(array).indexOf(i);
			}
		}
		return -1;
	}

	/**
	 * Returns true if element is in array, false otherwise
	 * Input: Generic element 
	 * Return type: boolean ; Big-O analysis: O(N)
	 */
	public boolean contains(E element) {
		for(E i: array){
			if(i == element){
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns element from the array at the specified position
	 * Input: Integer 
	 * Return type: E ; Big-O analysis: O(1)
	 */
	public E get(int index) {
		if (index >= size || index < 0) {
			throw new RuntimeException("Invalid index");
		}
		E element = (E) array[index];
		return element;
	}

	/**
	 * Returns the total number of elements in the array.
	 * Input: void
	 * Return type: Integer ; Big-O analysis: O(1)
	 */
	public int size() {
		
		return size;
	}

	/**
	 * Returns true if array has no elements, false otherwise.
	 * Input: void
	 * Return type: void Big-O analysis: O(1)
	 */
	public boolean isEmpty() {
		if (size() <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * Removes the element of the specified index from the array
	 * Input: Integer
	 * Return type: Generic Element E ; Big-O analysis: O(1)
	 */
	public E remove(int index) {
		if (index >= size || index < 0) {
			throw new RuntimeException("Invalid index");
		}
		E element = (E) array[index];
		array[index] = null;
		--size;
		return element;
	}

	/**
	 * Removes the specified element from the array 
	 * Input: Generic element
	 * Return type: void ; Big-O analysis: O(N)
	 */
	public void remove(E element) {
		for (E x : array) {
			if (x == element) {
				remove(Arrays.asList(array).indexOf(x));
			}
		}
	}

	/**
	 * Reverse the array 
	 * Input: void
	 * Return type: void ; Big-O analysis: O(N)
	 */
	public void reverse() {
		for (int i = 0; i < array.length/2; i++) {
            E temp = array[i];
            array[i] = array[array.length-(1+i)];
            array[array.length-(1+i)] = temp;
          }
	}

	/**
	 * Returns a string of the elements in the array 
	 * Input: void
	 * Return type: String ; Big-O analysis: O(1)
	 */
	public String toString() {
		return Arrays.toString(array);
	}

	public static void main(String[] args) {
		BetterArray<Comparable> bt = new BetterArray(5);
		bt.insert(0, "a");
		bt.insert(1, "b");
		bt.insert(2, "c");
		bt.insert(3, "d");
		bt.insert(4, "e");
		bt.insert(5, "f");
		bt.insert(6, "g");
		bt.insert(7, "h");
		bt.insert(8, "a");
		bt.insert(9, "b");
		bt.insert(10, "c");
		bt.insert(11, "d");
		bt.insert(12, "e");
		bt.insert(13, "f");
		bt.insert(14, "g");
		//bt.shift(3);
		//bt.remove("f");
		//bt.reverse();
		System.out.println(bt.contains(4));
		System.out.println("Size: " + bt.size());

		// bt.add(1,4);
		// bt.add(4);
		// bt.add("happy");
		System.out.println(bt.toString());
	}
}
