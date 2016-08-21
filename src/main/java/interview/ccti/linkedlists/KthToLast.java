package interview.ccti.linkedlists;

/**
 * Question 2.2
 * @author prashanth
 *
 */
public class KthToLast {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(7);
		list.append(6);
		list.append(5);
		list.append(4);
		list.append(3);
		list.append(2);
		list.append(1);
		
		list.print();
		
		int k = 3; //3rd from last...must return 3
		LinkedListNode n = getKthToLast(list, k);		
		System.out.println(n.getData());
		
		k = 1; 
		n = getKthToLast(list, k);		
		System.out.println(n.getData());
		
		k = 0; 
		n = getKthToLast(list, k);		
		System.out.println(n);
		
		k = 9; 
		n = getKthToLast(list, k);		
		System.out.println(n);
	}

	private static LinkedListNode getKthToLast(LinkedList list, int k) {
		LinkedListNode p1 = list.getHead();
		LinkedListNode p2 = p1;
		
		int i = 0;
		while(p2 != null && i < k) {
			p2 = p2.getNext();
			i++;
		}
		if(i != k) {
			return null; //k is longer than length of list
		}
		
		while(p2 != null) {
			p1 = p1.getNext();
			p2 = p2.getNext();
		}
		
		return p1;
	}
}
