package algorithms.search;

import java.util.Arrays;

public class TheStack<E> {

	private E[] stackArray;
	private E[] firstPart;
	private int stackSize;
	private int topOfStack = -1;

	TheStack(int size) {
		stackSize = size;
		stackArray = (E[]) new Object[size];
	}

	public void push(E input) {
		if (topOfStack + 1 < stackSize) {
			topOfStack++;
			stackArray[topOfStack] = input;
			System.out.println("the input " + input + " was added to the stack");
		} else {
			System.out.println("Sorry but the stack is full");
		}
	}

	public E pop() {
		if (topOfStack >= 0) {
			//stackArray[topOfStack] = (E) "-1";
			return stackArray[topOfStack--];
		} else {
			System.out.println("Sorry but the stack is empty");
			return (E) "-1";
		}
	}
	
	public E peek() {
		return stackArray[topOfStack];
	}

	public void reverse(){
		for (int i = 0; i < topOfStack/2; i++) {
            E temp = stackArray[i];
            stackArray[i] = stackArray[stackArray.length-(1+i)];
            stackArray[stackArray.length-(1+i)] = temp;
          }
		
	}
	public static void main(String[] args) {
		TheStack stack = new TheStack(5);
//		stack.push("me");
//		stack.push("you");
//		stack.push("us");
		
		System.out.println(stack.pop());
//		System.out.println(stack.peek());
	}

}
