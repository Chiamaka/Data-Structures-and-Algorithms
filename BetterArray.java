package org.meltwater.java.datastructures;

import java.util.Arrays;

public class BetterArray<E> {

	private E[] array;
	private int size;

	public BetterArray(int size) {
		array = (E[]) new Object[size];
		size = 0;
	}

	public void insert(int position, E element) {
		if (position < array.length) {
			this.array[position] = element;
			size++;
		}else{
			E[] newArray = (E[]) new Object[array.length* 2];
			if(newArray.length < array.length){throw new RuntimeException("cannot be copied");}
		    for(int i=0;i<array.length; i++){
		        newArray[i] = array[i];
		        array = newArray;
		    }   
		    
		}
	}

	public void shift(E element) {
		//put element at the beginning of the array
		if(isEmpty()){
			insert(0, element);
		}else {
			for(int i=size; i>=0;i--){
				array[i+1] = array[i];
			}
			insert(0,element);
		}
		
	}

	public void append(E element) {
		//put element at the end of the array
		if(isEmpty()){
			shift(element);
		}else {
			for(int i=1; i<=size;i++){
				array[i-1] = array[i];
			}
			size--;
			insert(size,element);
		}
	}

	public void index(E element) {
		for(E i: array){
			if(i == element) {
				
			}
		}
	}

	public void contains(E element) {
		
	}

	public E get(int index) {
		if(index >=size || index < 0){throw new RuntimeException("Invalid index");}
	    E element = (E) array[index];
	    return element;
	}

	public int size() {
		for (E i : array) {
			if (i != null) {
				return size;
			}
		}
		return -1;
	}

	public boolean isEmpty() {
		if (size() <= 0) {
			return true;
		}
		return false;
	}

	public E remove(int index) {
		if(index>=size || index < 0 ){throw new RuntimeException("Invalid index");}
	    E element = (E) array[index];
	    array[index] = null;
	    --size;
	    return element;
	}

	public void remove(E element) {
		for(E x: array){
			if(x == element){
				--size;
			}
		}
	}

	public void reverse() {

	}

	public String toString() {
		return Arrays.toString(array);

	}

	public static void main(String[] args) {
		BetterArray<Comparable> bt = new BetterArray(10);
		bt.insert(0, "a");
		bt.insert(1, "b");
		bt.insert(2, "c");
		bt.insert(3, "d");
		bt.insert(4, "e");
		bt.insert(5, "f");
		bt.insert(6, "g");
		bt.insert(7, "h");
		System.out.println(bt.get(3));
		//System.out.println(bt.remove("d"));
		System.out.println(bt.size());
		
		
		
		// bt.add(1,4);
		// bt.add(4);
		// bt.add("happy");
		System.out.println(bt.toString());
	}
}
