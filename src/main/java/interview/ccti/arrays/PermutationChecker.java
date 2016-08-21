package interview.ccti.arrays;

import junit.framework.Assert;

/**
 * Question 1.2
 * @author prashanth
 *
 */
public class PermutationChecker {
	
	public static boolean isPermutation(String src, String target) {
		
		int lenSrc = src.length();
		int lenTar = target.length();
		
		if(lenSrc != lenTar) {
			return false;
		}
		
		int hist[] = new int[127];
		
		for(int i = 0; i < lenSrc; i++) {
			char c = src.charAt(i);
			hist[c]++;
		}
		
		for(int i = 0; i < lenTar; i++) {
			char c = target.charAt(i);
			hist[c]--;
			
			if(hist[c] < 0) {
				return false;
			}
		}
		
		return true;
				
	}
	
	
	public static void main(String[] args) {
		Assert.assertTrue(isPermutation("abcdefga", "aaefgdcb"));
		
		Assert.assertFalse(isPermutation("abcdefg", "aafgdcb"));
		
		Assert.assertFalse(isPermutation("abcdefg", "abcdefh"));
		
		Assert.assertTrue(isPermutation("abcdefg", "abcdefg"));
	}
}
