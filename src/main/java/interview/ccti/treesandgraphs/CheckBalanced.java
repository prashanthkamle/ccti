package interview.ccti.treesandgraphs;

import junit.framework.Assert;

/**
 * Question 4.4
 * @author prashanth
 *
 */
public class CheckBalanced {

	public static void main(String[] args) {
		BinarySearchTree balanced = new BinarySearchTree();
		
		/*
		 *           5
		 *       3       8
		 *     2   4   7   9
		 *   1        6  
		 */
		
		balanced.add(5);
		balanced.add(8);
		balanced.add(3);
		balanced.add(4);
		balanced.add(2);
		balanced.add(7);
		balanced.add(9);
		balanced.add(6);
		balanced.add(1);
		
		BinarySearchTree unbalanced = new BinarySearchTree();
		unbalanced.add(1);
		unbalanced.add(2);
		unbalanced.add(3);
		unbalanced.add(4);
		
		
		BinarySearchTree unbalanced2 = new BinarySearchTree();
		
		/*
		 *           5
		 *       3       8
		 *     2   4   7   
		 *   1        6  
		 */
		
		unbalanced2.add(5);
		unbalanced2.add(8);
		unbalanced2.add(3);
		unbalanced2.add(4);
		unbalanced2.add(2);
		unbalanced2.add(7);
		unbalanced2.add(6);
		unbalanced2.add(1);
		
		
		Assert.assertTrue(isBalanced(balanced));
		Assert.assertFalse(isBalanced(unbalanced));
		Assert.assertFalse(isBalanced(unbalanced2));		
	}

	
	private static boolean isBalanced(BinarySearchTree tree) {		
		BinaryTreeNode root = tree.getRoot();
		
		int h = checkHeight(root);
		
		return (h != Integer.MIN_VALUE);		
	}
	
	private static int checkHeight(BinaryTreeNode node) {
		if(node == null) {
			return 0;
		}
		
		int lh = checkHeight(node.getLeft());
		if(lh == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		
		int rh = checkHeight(node.getRight());
		if(rh == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		
		int diff = Math.abs(lh - rh);
		if(diff > 1) {
			return Integer.MIN_VALUE;
		}
		
		int h = Math.max(lh, rh) + 1;		
		return h;
	}

	
}
