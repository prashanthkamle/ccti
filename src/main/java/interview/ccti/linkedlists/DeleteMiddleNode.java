package interview.ccti.linkedlists;

/**
 * Question 2.3
 * @author prashanth
 *
 */
public class DeleteMiddleNode {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(2);
		
		LinkedListNode n = new LinkedListNode();
		n.setData(3);
		
		list.append(n);
		list.append(4);
		list.append(5);
		list.append(6);
		list.append(7);
		
		
		list.print();
		
		
		deleteMiddleNode(n);
		
				
		list.print();
	}

	private static void deleteMiddleNode(LinkedListNode n) {
		LinkedListNode next = n.getNext();
		n.setData(next.getData());
		n.setNext(next.getNext());		
	}
}
