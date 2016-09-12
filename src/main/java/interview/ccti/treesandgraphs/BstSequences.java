package interview.ccti.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Question 4.9
 * @author prashanth
 *
 */
public class BstSequences {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.add(2);
		tree.add(1);
		tree.add(3);
		tree.add(4);
		tree.add(0);
		List<LinkedList<Integer>> sequences = findSequences(tree.getRoot());
		
		for(List<Integer> sequence : sequences) {
			for(Integer data : sequence) {
				System.out.print(data + " ");
			}
			System.out.println();
		}
	}

	private static List<LinkedList<Integer>> findSequences(
			BinaryTreeNode node) {
		List<LinkedList<Integer>> result = new ArrayList<>();
		
		if(node != null) {
			List<LinkedList<Integer>> seqLeft = findSequences(node.getLeft());
			List<LinkedList<Integer>> seqRight = findSequences(node.getRight());

			weave(seqLeft, seqRight, result);
			
			for(LinkedList<Integer> list : result) {
				list.addFirst(node.getData());
			}
			
		} else {
			LinkedList<Integer> l = new LinkedList<>();
			result.add(l);
		}
		
		return result;
	}

	private static void weave(List<LinkedList<Integer>> seqLeft, 
			List<LinkedList<Integer>> seqRight,
			List<LinkedList<Integer>> result) {
		
		for(LinkedList<Integer> sl : seqLeft) {
			for(LinkedList<Integer> sr : seqRight) {
				List<LinkedList<Integer>> weaves = weave(sl, sr, new LinkedList<>());
				result.addAll(weaves);
			}
		}
		
	}

	private static List<LinkedList<Integer>> weave(LinkedList<Integer> l1, 
			LinkedList<Integer> l2, LinkedList<Integer> prefix) {
		
		List<LinkedList<Integer>> result = new ArrayList<>();
		
		if(l1.size() == 0  || l2.size() == 0) {
			LinkedList<Integer> res = new LinkedList<>();
			res.addAll(prefix);
			res.addAll(l1);
			res.addAll(l2);
			result.add(res);
		} else {			
			prefix.addLast(l1.removeFirst());
			List<LinkedList<Integer>> res1 = weave(l1, l2, prefix);
			l1.addFirst(prefix.removeLast());
			
			prefix.addLast(l2.removeFirst());
			List<LinkedList<Integer>> res2 = weave(l1, l2, prefix);
			l2.addFirst(prefix.removeLast());
			
			result.addAll(res1);
			result.addAll(res2);
		}
		return result;
	}

	
}
