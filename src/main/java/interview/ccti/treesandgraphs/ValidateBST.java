package interview.ccti.treesandgraphs;

import junit.framework.Assert;

/**
 * Question 4.5
 * @author prashanth
 *
 */
public class ValidateBST {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		/*
		 *           5
		 *       3       8
		 *     2   4   7   
		 *   1        6  7
		 */
		
		bst.add(5);
		bst.add(8);
		bst.add(3);
		bst.add(4);
		bst.add(2);
		bst.add(7);
		bst.add(7);
		bst.add(6);
		bst.add(1);
		
		/*
		 *            5
		 *       3        8
		 *     2   4    7   6
		 *   1       9   
		 */
		
		
		BinaryTreeNode n1 = new BinaryTreeNode(1);
		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);
		BinaryTreeNode n4 = new BinaryTreeNode(4);
		BinaryTreeNode n5 = new BinaryTreeNode(5);
		BinaryTreeNode n6 = new BinaryTreeNode(6);
		BinaryTreeNode n7 = new BinaryTreeNode(7);
		BinaryTreeNode n8 = new BinaryTreeNode(8);
		BinaryTreeNode n9 = new BinaryTreeNode(9);
		
		n5.setLeft(n3);	n5.setRight(n8);
		n3.setLeft(n2);	n3.setRight(n4);
		n8.setLeft(n7);	n8.setRight(n6);
		n2.setLeft(n1);
		n4.setRight(n9);
		
		BinaryTree tree = new BinaryTree();
		tree.setRoot(n5);
		
		Assert.assertTrue(isBst1(bst));
		Assert.assertFalse(isBst1(tree));
		

		Assert.assertTrue(isBst2(bst));
		Assert.assertFalse(isBst2(tree));
		
	}



	/**
	 * Inorder traversal based approach
	 * @param tree
	 * @return
	 */
	private static boolean isBst1(BinaryTree tree) {
		
		BinaryTreeNode root = tree.getRoot();
		
		IntWrap prev = new IntWrap();
		prev.val = Integer.MIN_VALUE;
		return isBst1(root, prev);		
	}
	
	private static boolean isBst1(BinaryTreeNode root, IntWrap prev) {
		if(root == null) {
			return true;
		}
		
		boolean leftOk = isBst1(root.getLeft(), prev);
		
		if(leftOk) {
			int data = root.getData();
			
			if(data < prev.val) {
				return false;
			}
			prev.val = data;
		}
				
		return isBst1(root.getRight(), prev);
		
	}

	static class IntWrap {
		int val;
	}


	/**
	 * Min-max based approach
	 * @param bst
	 * @return
	 */
	private static boolean isBst2(BinaryTree tree) {
		BinaryTreeNode root = tree.getRoot();
		
		return isBst2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
	}



	private static boolean isBst2(BinaryTreeNode root, int min, int max) {
		if(root == null) {
			return true;
		}
		
		int data = root.getData();

		return (data >= min && data < max ) 
				&& isBst2(root.getLeft(), min, data)
				&& isBst2(root.getRight(), data, max);
	}
	
	

}
 