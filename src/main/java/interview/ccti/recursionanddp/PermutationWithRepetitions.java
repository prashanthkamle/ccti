package interview.ccti.recursionanddp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class PermutationWithRepetitions {
	
	private static List<String> permute(String s) {
		HashMap<Character, Integer> histogram = createHistogram(s);		
		List<String> result = permute(histogram);
		return result;
	}
	
	private static List<String> permute(HashMap<Character, Integer> histogram) {
		ArrayList<String> perms = new ArrayList<>();
		
		Set<Entry<Character, Integer>> entries = histogram.entrySet();
		for(Entry<Character, Integer> entry : entries) {
			int freq = entry.getValue();
			Character c = entry.getKey();
			if(freq == 0) {
				continue;
			} else {
				histogram.put(c, freq - 1);
				List<String> subperms = permute(histogram);
				histogram.put(c, freq);
				
				for(String sp : subperms) {
					perms.add(c + sp);
				}
			}
		}
		if(perms.isEmpty()) {
			perms.add("");
		}
		
		return perms;
	}
	
	private static HashMap<Character, Integer> createHistogram(String s) {
		HashMap<Character, Integer> histogram = new HashMap<>();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Integer count = histogram.get(c);
			if(count == null) {
				count = 1;
			} else {
				count++;
			}
			histogram.put(c, count);
		}
		return histogram;
	}
	
	

	public static void main(String[] args) {
		String s = "aba";
		//aab aba baa
		List<String> perms = permute(s);
		System.out.println(perms);
	}

	

}
