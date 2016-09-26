package interview.ccti.recursionanddp;

/**
 * Question 8.1
 * @author prashanth
 *
 */
public class TripleStep {
	
	private static int countWays(int n) {
		int[] mem = new int[n + 1];
		return countWays(n, mem);
	}
	
	private static int countWays(int n, int[] mem) {
		if(n <= 0) {
			return 0;
		}
		
		if(mem[n] == 0) {
			mem[n] = 1 + countWays(n - 1, mem) + countWays(n - 2, mem) + countWays(n - 3, mem);
		}
			
		return mem[n];
	}
	
	public static void main(String[] args) {
		
		System.out.println(countWays(3));
	}
}
