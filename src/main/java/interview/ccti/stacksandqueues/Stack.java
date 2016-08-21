package interview.ccti.stacksandqueues;

import interview.ccti.linkedlists.LinkedList;
import interview.ccti.linkedlists.LinkedListNode;

public class Stack implements IStack {
	private LinkedList list = new LinkedList();
	
	private int capacity = Integer.MAX_VALUE;
	private int numElements;
	
	public Stack() {
		
	}
	
	public Stack(int capacity) {		
		this.capacity = capacity;
	}
	
	public void push(int data) {
		if(numElements == capacity) {
			throw new StackException("Full");
		}
		numElements++;
		list.prepend(data);
	}
	
	public int pop() {
		LinkedListNode node = list.removeFront();
		if(node == null) {
			throw new StackException("Empty");
		}
		numElements--;
		return node.getData();
	}
	
	public int peek() {
		LinkedListNode n = list.getHead();
		if(n == null) {
			throw new StackException("Empty");
		}
		return n.getData();
	}
	
	public boolean isEmpty() {
		boolean isEmpty = (list.getHead() == null);
		return isEmpty;				
	}
	
	public boolean isFull() {
		boolean isFull = (numElements == capacity);
		return isFull;
	}
	
	public int getNumElements() {
		return numElements;
	}
	
	public void print() {
		LinkedListNode n = list.getHead();
		while(n != null) {
			System.out.println(n.getData());
			n = n.getNext();
		}
		System.out.println("---");
	}
}
