package interview.ccti.linkedlists;

public class LinkedList {
	private LinkedListNode head;
	private LinkedListNode tail;
	
	public LinkedListNode getHead() {
		return head;
	}

	public void setHead(LinkedListNode head) {
		this.head = head;
	}

	public LinkedListNode getTail() {
		return tail;
	}

	public void setTail(LinkedListNode tail) {
		this.tail = tail;
	}

	public void append(LinkedListNode node) {
		node.setNext(null);
		if(head == null) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}
		
	}
	
	public void append(int data) {
		LinkedListNode n = new LinkedListNode();
		n.setData(data);
		append(n);
	}
	
	public void prepend(int data) {
		LinkedListNode n = new LinkedListNode();
		n.setData(data);
		prepend(n);
	}
	
	public void prepend(LinkedListNode node) {
		if(head == null) {
			head = node;
			tail = node;
		} else {
			node.setNext(head);
			head = node;
		}
	}
	
	public LinkedListNode removeFront() {
		LinkedListNode removed = null;
		if(head != null) {
			removed = head;
			head = head.getNext();			
		}
		return removed;			
	}
	
	public void print() {
		LinkedListNode t = head;
		while(t != null) {
			System.out.print(t.getData() + " -> ");
			t = t.getNext();
		}
		System.out.println();
	}
	
}
