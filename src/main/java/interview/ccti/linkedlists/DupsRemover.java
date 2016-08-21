package interview.ccti.linkedlists;

/**
 * Question 2.1
 * @author prashanth
 *
 */
public class DupsRemover {
	private static void removeDups(LinkedList list) {
		if(list == null) {
			return;
		}
		
		LinkedListNode p1 = list.getHead();
		
		while(p1 != null) {
			LinkedListNode p2 = p1.getNext();
			LinkedListNode prev = p1;
			while(p2 != null) {
				if(p2.getData() == p1.getData()) {
					prev.setNext(p2.getNext());
				} else {
					prev = p2;
				}
				p2 = p2.getNext();
			}
			p1 = p1.getNext();
		}
		
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(2);
		list.append(2);
		list.append(1);
		list.append(3);
		list.append(1);
		list.append(3);
		
		
		list.print();
		
		removeDups(list);
		
		list.print();
	}
}
