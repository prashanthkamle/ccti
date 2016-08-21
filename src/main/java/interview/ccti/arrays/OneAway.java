package interview.ccti.arrays;

import junit.framework.Assert;

/**
 * Question 1.5
 * @author prashanth
 *
 */
public class OneAway {
	
	private static boolean isOneAway(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		
		if(Math.abs(len1 - len2) > 1) {
			return false;
		}
		
		if(len1 < len2) {
			return checkOneAway(s2, s1);
		} else {
			return checkOneAway(s1, s2);
		}
		
	}
	
	private static boolean checkOneAway(String longer, String shorter) {
		int l = 0, s = 0;
		int lenL = longer.length();
		int lenS = shorter.length();

		int numDiff = 0;
		while(l < lenL && s < lenS && (l - s) <= 1) {
			if(longer.charAt(l) != shorter.charAt(s)) {
				if(lenL == lenS) {
					s++;
				}
				l++;
				numDiff++;
				if(numDiff > 1) {
					return false;
				}
			} else {
				l++;
				s++;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		Assert.assertTrue(isOneAway("abcde", "abde"));
		Assert.assertTrue(isOneAway("abcde", "abcdef"));
		Assert.assertTrue(isOneAway("abcdef", "abHdef"));
		Assert.assertTrue(isOneAway("abcde", "abcde"));
		
		Assert.assertFalse(isOneAway("abcde", "abcdefg"));
		Assert.assertFalse(isOneAway("abcde", "aBCde"));
			
	}
	
}
