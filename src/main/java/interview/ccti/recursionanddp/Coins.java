package interview.ccti.recursionanddp;

import java.util.HashMap;
import java.util.Map;

public class Coins {
	
	
	
	public static void main(String[] args) {
		int[] denoms = { 1, 2, 3};
		int numWays = countWays(denoms, 4);
		System.out.println(numWays);
	}

	
	private static int countWays(int[] denoms, int total) {
		HashMap<String, Integer> memo = new HashMap<>();
		return countWays(denoms, total, 0, memo);
	}
	
	private static int countWays(int[] denoms, int total, int index, Map<String, Integer> memo) {
		if(total == 0) {
			return 1;
		}
		
		Integer numWays = 0;
		if(index < denoms.length) {
			String key = index + "-" + total;
			
			numWays = memo.get(key);
			if(numWays == null) {
				//System.out.println(total + ":" + index);

				numWays = 0;
				int denom = denoms[index];
				for(int i = 0; i * denom <= total; i++) {
					numWays += countWays(denoms, total - i * denom, index + 1, memo);
				}
				memo.put(key, numWays);
			}
		}		
		
		return numWays.intValue();
	}

}
