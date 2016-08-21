package interview.ccti.linkedlists;

public class Intersection {
	public static void main(String[] args) {
		
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(3);
		LinkedListNode n4 = new LinkedListNode(4);
		LinkedListNode n5 = new LinkedListNode(5);
		LinkedListNode n6 = new LinkedListNode(6);
		LinkedListNode n7 = new LinkedListNode(7);
		LinkedListNode n8 = new LinkedListNode(8);
		
		
		LinkedList l1 = new LinkedList();
		l1.append(n1);
		l1.append(n2);
		l1.append(n3);
		l1.append(n4);
		
		LinkedList l2 = new LinkedList();
		l2.append(n5);
		l2.append(n6);
		l2.getTail().setNext(n3);
		
		LinkedList l3 = new LinkedList();
		l3.append(n7);
		l3.append(n8);
		
		
		l1.print();
		l2.print();
		l3.print();
		
		LinkedListNode n = findIntersection(l1, l2);
		System.out.println(n.getData());
		
		n = findIntersection(l2, l1);
		System.out.println(n.getData());
		
		
		n = findIntersection(l1, l3);
		System.out.println(n);
		
		
	}

	private static LinkedListNode findIntersection(LinkedList l1, LinkedList l2) {
		int len1 = findLength(l1);
		int len2 = findLength(l2);
		
		if(len2 > len1) {
			LinkedList tmp = l2;
			l2 = l1;
			l1 = tmp;
		}
		
		int diff = Math.abs(len1 - len2);
		
		LinkedListNode n1 = l1.getHead();
		while(diff > 0) {
			n1 = n1.getNext();
			diff--;
		}
		
		LinkedListNode n2 = l2.getHead();
		while(n1 != null) {
			if(n1 == n2) {
				return n1;
			}
			n1 = n1.getNext();
			n2 = n2.getNext();
		}
		
		return null;
	}

	private static int findLength(LinkedList l1) {
		int len1 = 0;
		
		LinkedListNode t = l1.getHead();
		while(t != null) {
			len1++;
			t = t.getNext();
		}
		return len1;
	}

}
