package algorithms.search;

public class TheQueue {
	private String[] queueArray;
	
	private int queueSize;
	
	private int front, back, numberOfItems=0;
	
	TheQueue(int size){
		queueSize = size;
		queueArray = new String[size];
	}
	
	public void enqueue(String input){
		if(numberOfItems+1 <= queueSize){
			queueArray[back] = input;
			back++;
			numberOfItems++;
			System.out.println("the input " + input + " was added to the queue");
		}else {
			System.out.println("Sorry but the queue is full");
		}
	}
	
	public void dequeue(){
		if(numberOfItems > 0){
			System.out.println("The value " + queueArray[front] + " was removed from the array");
			queueArray[front] = "-1";
			front++;
			numberOfItems--;
		}else {
			System.out.println("Sorry but the queue is empty");
		}
	}
	
	public String peek() {
		return queueArray[front];
	}
	public static void main(String[] args){
		TheQueue queue = new TheQueue(10);
		queue.enqueue("12");
		queue.enqueue("hello");
		queue.enqueue("12345");
		
		queue.dequeue();
		//System.out.println(queue.d());
		
	}

}
