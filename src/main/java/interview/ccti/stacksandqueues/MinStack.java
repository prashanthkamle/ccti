package interview.ccti.stacksandqueues;

/**
 * Question 3.2
 * @author prashanth
 *
 */

public class MinStack implements IStack {
	private Stack stack = new Stack();
	private Stack mins = new Stack();
	
	@Override
	public void push(int data) {
		stack.push(data);
		
		try {
			int min = mins.peek();
			if(data <= min) {
				mins.push(data);
			}
		} catch(StackException e) {
			mins.push(data);
		}
		
	}
	
	@Override
	public int pop() {
		
		int data = stack.pop();
		int min = mins.peek();
		
		if(min == data) {
			mins.pop();
		}		
		return data;
	}
	
	@Override
	public int peek() {
		return stack.peek();
	}
	
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public int min() {
		return mins.peek();
	}
	
	public void print() {
		stack.print();
	}
	
	public static void main(String[] args) {
		MinStack ms = new MinStack();
		
		ms.push(5);
		ms.print();
		System.out.println("min:" + ms.min());
		
		ms.push(6);
		ms.print();
		System.out.println("min:" +ms.min());
		
		ms.push(10);
		ms.print();
		System.out.println("min:" +ms.min());
		
		ms.push(4);
		ms.print();
		System.out.println("min:" +ms.min());
		
		ms.push(3);
		ms.print();
		System.out.println("min:" +ms.min());
		
		
		ms.push(5);
		ms.print();
		System.out.println("min:" +ms.min());
		
		ms.push(3);
		ms.print();
		System.out.println("min:" +ms.min());
		
		ms.pop();
		ms.print();
		System.out.println("min:" +ms.min());
		
		ms.pop();
		ms.print();
		System.out.println("min:" +ms.min());
		
		ms.pop();
		ms.print();
		System.out.println("min:" +ms.min());
		
		ms.pop();
		ms.print();
		System.out.println("min:" +ms.min());

		ms.pop();
		ms.print();
		System.out.println("min:" +ms.min());
		
		ms.pop();
		ms.print();
		System.out.println("min:" +ms.min());
		
		ms.pop();
		ms.print();
		System.out.println("min:" +ms.min());
		
		
	}
	
}
