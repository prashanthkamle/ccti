package interview.ccti.recursionanddp;

import java.util.ArrayList;
import java.util.List;

public class ParenthesisPermutation {

	public static void main(String[] args) {
		List<String> perms = generatePerms(3);
		System.out.println(perms);
	}

	private static List<String> generatePerms(int numParens) {
		
		ArrayList<String> result = new ArrayList<>();
		
		char[] perm = new char[numParens * 2];
		
		populatePerms(numParens, numParens, perm, 0, result);
		
		return result;
	}

	private static void populatePerms(int numLeftRemaining, int numRightRemaining, 
			char[] perm, int index, ArrayList<String> result) {
		
		if(numLeftRemaining == 0  && numRightRemaining == 0) {
			result.add(String.valueOf(perm));
		} else if(numLeftRemaining > 0) {
			perm[index] = '(';
			populatePerms(numLeftRemaining - 1, numRightRemaining, perm, index + 1, result);
		}
		
		if(numRightRemaining > numLeftRemaining) {
			perm[index] = ')';
			populatePerms(numLeftRemaining, numRightRemaining - 1, perm, index + 1, result);
		}
	}
}
