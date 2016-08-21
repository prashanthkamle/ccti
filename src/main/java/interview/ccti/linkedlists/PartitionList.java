package interview.ccti.linkedlists;

/**
 * Question 2.4
 * @author prashanth
 *
 */
public class PartitionList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(3);
		list.append(5);
		list.append(8);
		list.append(5);
		list.append(10);
		list.append(2);
		list.append(1);
				
		list.print();
		
		partitionStable(list, 5);
		
		list.print();
	}

	private static void partitionStable(LinkedList list, int k) {		
		LinkedList before = new LinkedList();
		LinkedList after = new LinkedList();
		
		LinkedListNode n = list.getHead();
		
		while(n != null) {
			LinkedListNode next = n.getNext();
			if(n.getData() < k) {
				before.append(n);
			} else {
				after.append(n);
			}
			n = next;
		}
		
		list.setHead(before.getHead());
		before.getTail().setNext(after.getHead());
		
	}
	
}
