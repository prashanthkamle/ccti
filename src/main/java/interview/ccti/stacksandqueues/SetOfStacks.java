package interview.ccti.stacksandqueues;

/**
 * Question 3.3
 * @author prashanth
 *
 */
public class SetOfStacks implements IStack {

	private Stack[] stacks;
	
	private int curr = 0;
	
	public SetOfStacks(int numStacks, int capacity) {
		stacks = new Stack[numStacks];
		
		for(int i = 0; i < numStacks; i++) {
			stacks[i] = new Stack(capacity);
		}
	}

	@Override
	public void push(int data) {
		if(stacks[curr].isFull()) {
			curr++;
			if(curr == stacks.length) {
				curr--;
				throw new StackException("Full");
			}
		}
		System.out.println("Pushing to stack " + curr);
		stacks[curr].push(data);
	}

	@Override
	public int pop() {
		if(stacks[curr].isEmpty()) {
			curr--;
			if(curr < 0) {
				curr++;
				throw new StackException("Empty");
			}
		}
		System.out.println("Popping from stack " + curr);
		int val = stacks[curr].pop();
		return val;
	}

	@Override
	public int peek() {		
		return stacks[curr].peek();
	}

	@Override
	public boolean isEmpty() {
		return stacks[0].isEmpty();
	}
	
	
	public void print() {
		for(int i = 0; i < stacks.length; i++) {
			stacks[i].print();
		}
		System.out.println("----------");
	}
	
	public static void main(String[] args) {
		SetOfStacks set = new SetOfStacks(3, 3);
		
		set.push(1);
		set.push(2);
		set.push(3);
		set.push(4);
		set.push(5);
		set.push(6);
		set.push(7);
		set.print();
		
		System.out.println(set.peek());
		
		System.out.println(set.pop());
		System.out.println(set.pop());
		System.out.println(set.pop());
		System.out.println(set.pop());
		System.out.println(set.pop());
		System.out.println(set.pop());
		System.out.println(set.pop());
		System.out.println(set.pop());
		
		System.out.println(set.peek());
		
	}

}
