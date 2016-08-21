package interview.ccti.stacksandqueues;

/**
 * Question 3.4
 * @author prashanth
 *
 */
public class QueueViaStack {

	private Stack s1 = new Stack();
	private Stack s2 = new Stack();
	
	public void enqueue(int data) {
		s1.push(data);
	}
	
	public int dequeue() {
		if(s2.isEmpty()) {
			moveToS2();
		}
		return s2.pop();
	}
	
	public int peek() {
		if(s2.isEmpty()) {
			moveToS2();
		}
		return s2.peek();
	}

	private void moveToS2() {
		while(!s1.isEmpty()) {
			int data = s1.pop();
			s2.push(data);
		}
	}
	
	public static void main(String[] args) {
		QueueViaStack q = new QueueViaStack();
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.peek());
		q.enqueue(4);
		System.out.println(q.dequeue());
		System.out.println(q.peek());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		
		
	}


}
