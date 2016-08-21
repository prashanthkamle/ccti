package interview.ccti.arrays;

import junit.framework.Assert;

/**
 * Question 1.1
 * @author prashanth
 *
 */
public class Unique {
	
	/**
	 * Assumes string contains only ascii lowercase chars
	 * This enables us to use a single int instead of multiple ints
	 * @param s
	 * @return
	 */
	private static boolean areCharsUnique(String s) {
		if(s == null) {
			return true;
		}
		
		int len = s.length();
		
		if(len > 26) {
			return false;
		}
		
		int table = 0;
		for(int i = 0; i < len; i++) {
			char c = s.charAt(i);
			int posn = c - 'a';
			int bitVec = 1;
			bitVec = bitVec << posn;
			
			System.out.println("char: " + c);			
			System.out.println(Integer.toBinaryString(bitVec));
			if((bitVec & table) > 0) {
				return false;
			}
			
			table = table | bitVec;
			System.out.println(Integer.toBinaryString(table));
			System.out.println("-------------------");
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Assert.assertTrue(areCharsUnique("abcdef"));
		Assert.assertFalse(areCharsUnique("abdbf"));
		Assert.assertFalse(areCharsUnique("abcdefghijklmnopqrstuvwxyza"));
	}
}
