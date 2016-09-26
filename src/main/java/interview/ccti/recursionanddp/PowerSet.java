package interview.ccti.recursionanddp;

import java.util.ArrayList;
import java.util.List;


public class PowerSet {


	private static List<List<Integer>> powerSet(List<Integer> set, int index) {
		ArrayList<List<Integer>> sol = new ArrayList<>();
		
		if(index == set.size()) {			
			ArrayList<Integer> subset = new ArrayList<>();
			sol.add(subset);		
		} else {
			Integer item = set.get(index);
			List<List<Integer>> subsets = powerSet(set, index + 1);
			sol.addAll(subsets);
			
			for(List<Integer> subset : subsets) {
				ArrayList<Integer> newSubset = new ArrayList<>();
				newSubset.add(item);
				newSubset.addAll(subset);
				sol.add(newSubset);
			}
		}
		
		return sol;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> set = new ArrayList<>();
		
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		
		List<List<Integer>> powerset = powerSet(set, 0);
		
		for(List<Integer> s : powerset) {
			for(Integer i : s) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
 	}

}
