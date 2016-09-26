package interview.ccti.recursionanddp;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	private static List<String> permute1(String s) {
		ArrayList<String> result = new ArrayList<>();

		if(s.length() > 1) {
			String substr = s.substring(1, s.length());
			List<String> substrPerms = permute1(substr);

			for(String perm : substrPerms) {
				for(int i = 0; i <= perm.length(); i++) {
					String before = perm.substring(0, i);
					String after = perm.substring(i, perm.length());
					String p = before + s.charAt(0) + after;
					result.add(p);
				}
			}
		} else {
			result.add(s);
		}


		return result;
	}


	private static List<String> permute2(String s) {

		ArrayList<String> result = new ArrayList<>();

		if(s.length() == 1) {
			result.add(s);
		} else {
			for(int i = 0; i < s.length(); i++) {
				char item = s.charAt(i);
				String substr = s.substring(0, i) + s.substring(i+1, s.length());

				List<String> perms = permute2(substr);
				for(String perm : perms) {
					result.add(item + perm);
				}
			}
		}

		return result;
	}


	public static void main(String[] args) {
		String s = "abc";

		List<String> perms = permute1(s);
		System.out.println(perms.size());
		System.out.println(perms);

		System.out.println();
		
		perms = permute2(s);
		System.out.println(perms.size());
		System.out.println(perms);
	}

}
