package interview.gfg.moderate;

import java.io.*;


/**
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=1391
 * @author prashanth
 *
 */
public class Dieter {
	public static void main (String[] args) {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

		String line = null;
		try {
			line = r.readLine();
			int numTestCases = Integer.parseInt(line);

			for(int i = 0; i < numTestCases; i++) {
				line = r.readLine();
				line = r.readLine();
				String[] tokens = line.split(" ");
				int[] cals = new int[tokens.length];

				for(int j = 0; j < tokens.length; j++) {
					cals[j] = Integer.parseInt(tokens[j]);
				}

				//int result = computeMaxCals(cals);
				int result = computeMaxCalsDp(cals);
				
				System.out.println(result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int computeMaxCalsDp(int[] cals) {
		int[][] table = new int[3][cals.length + 1];

		for(int index = cals.length - 1; index >= 0; index--) {
			for(int numEats = 2; numEats >= 0; numEats--) {
				if(numEats == 2) {
					table[numEats][index] = table[0][index + 1];
				} else {
					int calsWithCurrent = cals[index] + table[numEats + 1][index + 1];
					int calsWithoutCurrent = table[numEats][index + 1];
					int maxEats = Math.max(calsWithCurrent, calsWithoutCurrent);
					table[numEats][index] = maxEats;
				}
			}
		}
		int max = -1;
		for(int i = 0; i < 3; i++) {
			if(table[i][0] > max) {
				max = table[i][0];
			}
		}
		return max;
	}
	
	private static int computeMaxCals(int[] cals) {
		int[][] memo = new int[3][cals.length];
		return computeMaxCals(cals, 0, 0, memo);
	}

	private static int computeMaxCals(int[] cals, int index, int numEats, int[][] memo) {
		if(index == cals.length) {
			return 0;
		}

		if(memo[numEats][index] != 0) {
			return memo[numEats][index];
		}
		if(numEats == 2) {
			return computeMaxCals(cals, index + 1, 0, memo);
		}

		int calsWithCurrent = cals[index] + computeMaxCals(cals, index + 1, numEats + 1, memo);
		int calsWithoutCurrent = computeMaxCals(cals, index + 1, numEats, memo);

		int maxEats = Math.max(calsWithCurrent, calsWithoutCurrent);
		memo[numEats][index] = maxEats;
		return maxEats;
	}
}
