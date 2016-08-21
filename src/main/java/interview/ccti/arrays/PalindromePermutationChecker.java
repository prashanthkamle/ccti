package interview.ccti.arrays;

import junit.framework.Assert;

/**
 * Question 1.4
 * @author prashanth
 *
 */
public class PalindromePermutationChecker {
	private static boolean isPalindromePermutation(String s) {
		int len = s.length();
		
		if(len <= 1) {
			return true;
		}
		
		int hist[] = new int[256];
		for(int i = 0; i < len; i++) {
			char c = s.charAt(i);
			hist[c]++;
		}
		
		boolean oddOccurred = false;
		for(int i = 0; i < hist.length; i++) {
			int n = hist[i];
			if(n % 2 != 0) {
				if(oddOccurred) {
					return false;
				}
				oddOccurred = true;
			}
		}
		
		return true;
	}
	
	private static boolean isPalindromePermutationZeroMem(String s) {
		int table = 0;
		
		int len = s.length();
		if(len <= 1) {
			return true;
		}
		
		for(int i = 0; i < len; i++) {
			char c = s.charAt(i);
			int posn = c - 'a';
			
			table = toggle(table, posn);
		}
		
		if(table == 0 || (table & (table - 1)) == 0) {
			return true;
		}
		
		return false;
	}
	
	private static int toggle(int table, int posn) {
		
		int bitVec = 1 << posn;
		
		int valAtPosn = table & bitVec;
		
		if(valAtPosn == 0) {
			table = table | bitVec;
		} else {
			table = table & ~bitVec;
		}
		
		return table;
	}

	public static void main(String[] args) {
		Assert.assertTrue(isPalindromePermutation("amass"));
		Assert.assertTrue(isPalindromePermutation("mississippi"));
		Assert.assertFalse(isPalindromePermutation("amazing"));
		
		Assert.assertTrue(isPalindromePermutationZeroMem("amass"));
		Assert.assertTrue(isPalindromePermutationZeroMem("mississippi"));
		Assert.assertFalse(isPalindromePermutationZeroMem("amazing"));
	}
}
