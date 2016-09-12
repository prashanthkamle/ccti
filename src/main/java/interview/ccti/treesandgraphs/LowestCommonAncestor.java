package interview.ccti.treesandgraphs;

import junit.framework.Assert;

/**
 * Question 4.8
 * @author prashanth
 *
 */
public class LowestCommonAncestor {
	public static void main(String[] args) {
		/*
		 *            5
		 *       3        8
		 *     2   4    7   9
		 *   1         6        
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
		
		n5.setLeft(n3);	n5.setRight(n8); n3.setParent(n5); n8.setParent(n5);
		n3.setLeft(n2);	n3.setRight(n4); n2.setParent(n3); n4.setParent(n3);
		n8.setLeft(n7);	n8.setRight(n9); n7.setParent(n8); n9.setParent(n8);
		n7.setLeft(n6); n6.setParent(n7);
		n2.setLeft(n1); n1.setParent(n2);
		
		BinaryTree tree = new BinaryTree();
		tree.setRoot(n5);
		
		Assert.assertEquals(n3, findLca(tree.root, n1, n4));
		Assert.assertEquals(n5, findLca(tree.root, n4, n6));
		Assert.assertEquals(n3, findLca(tree.root, n3, n3));
	}

	private static BinaryTreeNode findLca(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2) {
		
		if(root == null || root == n1 || root == n2) {
			return root;
		}
		
		BinaryTreeNode left = findLca(root.getLeft(), n1, n2);
		BinaryTreeNode right = findLca(root.getRight(), n1, n2);
		
		if(left != null && right != null && left != right) {
			return root;
		} else if(left != null) {
			return left;
		} else if(right != null) {
			return right;
		}
		
		return null;
	}
}
