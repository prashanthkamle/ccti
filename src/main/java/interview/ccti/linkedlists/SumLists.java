package interview.ccti.linkedlists;

/**
 * Question 2.5
 * @author prashanth
 *
 */
public class SumLists {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.append(7);
		list1.append(1);
		list1.append(6);
		
		LinkedList list2 = new LinkedList();
		list2.append(5);
		list2.append(9);
		list2.append(2);
		list2.append(1);
		
		//617 + 1295
		LinkedList sum = add(list1, list2);
		sum.print();
		
	}

	private static LinkedList add(LinkedList list1, LinkedList list2) {
		LinkedList sum = new LinkedList();
		
		LinkedListNode p1 = list1.getHead();
		LinkedListNode p2 = list2.getHead();
		
		int carry = 0;
		while(true) {
			if(p1 == null && p2 == null) {
				break;
			}
			
			int partialSum = 0;
			if(p1 != null) {
				partialSum += p1.getData();
				p1 = p1.getNext();
			}
			if(p2 != null) {
				partialSum += p2.getData();
				p2 = p2.getNext();
			}
			
			partialSum += carry;
			
			LinkedListNode res = new LinkedListNode();
			res.setData(partialSum % 10);
			sum.append(res);
			
			carry = partialSum/10;
			
		}
		
		return sum;
	}
	
}
