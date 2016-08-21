package interview.ccti.stacksandqueues;

/**
 * Question 3.5
 * @author prashanth
 *
 */
public class StackSort {

	public static void sort(Stack stack) {
		Stack tmp = new Stack();
		
		while(!stack.isEmpty()) {
			int data = stack.pop();
			
			while((!tmp.isEmpty()) && tmp.peek() > data) {
				stack.push(tmp.pop());
			}
			tmp.push(data);
		}
		
		while(!tmp.isEmpty()) {
			stack.push(tmp.pop());
		}
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(3);
		stack.push(1);
		stack.push(5);
		
		stack.print();
		
		StackSort.sort(stack);
		
		stack.print();
	}

}
