package interview.ccti.linkedlists;

/**
 * Question 2.8
 * @author prashanth
 *
 */
public class LoopDetection {
	
	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(3);
		LinkedListNode n4 = new LinkedListNode(4);
		LinkedListNode n5 = new LinkedListNode(5);
		LinkedListNode n6 = new LinkedListNode(6);
		LinkedListNode n7 = new LinkedListNode(7);
		LinkedListNode n8 = new LinkedListNode(8);
		
		
		LinkedList l = new LinkedList();
		l.append(n1);
		l.append(n2);
		l.append(n3);
		l.append(n4);
		l.append(n5);
		l.append(n6);
		l.append(n7);
		l.append(n8);
		
		n8.setNext(n4);
		LinkedListNode loopStart = findLoopStart(l);
		System.out.println(loopStart.getData());
		
		n8.setNext(null);
		loopStart = findLoopStart(l);
		System.out.println(loopStart);
	}

	private static LinkedListNode findLoopStart(LinkedList list) {
		LinkedListNode fast = list.getHead();
		LinkedListNode slow = fast;
		
		while(fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast) {
				break;
			}
		}
		
		if(fast == null) {
			return null;
		}
		
		LinkedListNode n = list.getHead();
		
		while(n != slow) {
			n = n.getNext();
			slow = slow.getNext();
		}
				
		return n;
	}

}
