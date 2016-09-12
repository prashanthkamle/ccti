package interview.ccti.treesandgraphs;

import junit.framework.Assert;

/**
 * Question 4.6 
 * @author prashanth
 *
 */
public class InorderSuccessor {
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

		
		Assert.assertEquals(5, findInorderSuccessor(n4).getData());
		Assert.assertEquals(8, findInorderSuccessor(n7).getData());
		Assert.assertEquals(6, findInorderSuccessor(n5).getData());
		Assert.assertNull(findInorderSuccessor(n9));
	}

	private static BinaryTreeNode findInorderSuccessor(BinaryTreeNode n) {
		BinaryTreeNode successor = null;
		
		//if right subtree exists, successor is leftmost node in right sub tree
		if(n.getRight() != null) {
			BinaryTreeNode tmp = n.getRight();
			while(tmp != null) {
				successor = tmp;
				tmp = tmp.getLeft();
			}
		} else {
			//no right subtree exists, look up till moving from left
			BinaryTreeNode parent = n.getParent();
			BinaryTreeNode prev = n;
			while(parent != null && parent.getLeft() != prev) {
				prev = parent;
				parent = parent.getParent();
			}
			if(parent != null) {
				successor = parent;
			}
		}
		
		return successor;
	}

}
