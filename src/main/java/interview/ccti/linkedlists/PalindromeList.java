package interview.ccti.linkedlists;

import java.util.Stack;

/**
 * Question 2.6
 * @author prashanth
 *
 */
public class PalindromeList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(3);
		list.append(2);
		list.append(1);
				
		list.print();
		
		boolean res = isPalindrome(list);
		System.out.println(res);
		
		LinkedList list2 = new LinkedList();
		list2.append(1);
		list2.append(2);
		list2.append(3);
		list2.append(3);
		list2.append(2);
		list2.append(1);
		
		list2.print();
		res = isPalindrome(list2);
		System.out.println(res);
	
		list2.prepend(0);
		list2.print();
		res = isPalindrome(list2);
		System.out.println(res);
	
	}

	private static boolean isPalindrome(LinkedList list) {
		Stack<Integer> stack = new Stack<>();
		
		LinkedListNode slow = list.getHead();
		LinkedListNode fast = slow;
		
		while(fast != null) {
			stack.push(slow.getData());
			fast = fast.getNext();
			if(fast != null) {
				fast = fast.getNext();
				slow = slow.getNext();
			}
			
		}
		
		
		while(slow != null) {
			if(slow.getData() != stack.pop().intValue()) {
				return false;
			}
			slow = slow.getNext();
		}
		
		
		return true;
	}

}
