package interview.ccti.linkedlists;

/**
 * Question 2.5
 * @author prashanth
 *
 */
public class SumListsReverse {
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.append(9);
		list1.append(1);
		list1.append(7);
		
		LinkedList list2 = new LinkedList();
		list2.append(1);
		list2.append(2);
		list2.append(9);
		list2.append(5);
		
		//917 + 1295
		LinkedList sum = add(list1, list2);
		sum.print();
		
	}

	
	private static LinkedList add(LinkedList list1, LinkedList list2) {
		makeSameLength(list1, list2);
		LinkedList sum = new LinkedList();
		addNodes(list1.getHead(), list2.getHead(), new SumListsReverse.Carry(), sum);
		return sum;
	}


	private static void makeSameLength(LinkedList list1, LinkedList list2) {
		LinkedListNode p1 = list1.getHead();
		LinkedListNode p2 = list2.getHead();
		
		while(p1 != null || p2 != null) {
			if(p1 == null && p2 != null) {
				list1.prepend(0);
				p2 = p2.getNext();
			} else if(p1 != null && p2 == null) {
				list2.prepend(0);
				p1 = p1.getNext();
			} else {
				p1 = p1.getNext();
				p2 = p2.getNext();
			}
		}
	}

	
	
	private static void addNodes(LinkedListNode n1, LinkedListNode n2, Carry carry, LinkedList result) {
		if(n1 == null) {
			if(carry.value > 0) {
				LinkedListNode n = new LinkedListNode();
				n.setData(carry.value);
				result.prepend(n);
			}
			return;
		}		
		
		addNodes(n1.getNext(), n2.getNext(), carry, result);
		
		int sum = n1.getData() + n2.getData() + carry.value;
		
		LinkedListNode res = new LinkedListNode();
		res.setData(sum % 10);
		carry.value = sum/10;
		result.prepend(res);
		
	}
	
	static class Carry {
		int value = 0;
	}
	

}
