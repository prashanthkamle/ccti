package interview.ccti.treesandgraphs;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Question 4.11
 * @author prashanth
 *
 */
public class BinarySearchTreeWithGetRandom extends BinaryTree {
	
	public void add(int data) {
		root = add(root, data);
	}
	
	public BinaryTreeNode getRandom() {
		int nodeNum = ThreadLocalRandom.current().nextInt(root.getSubtreeSize()) + 1;
		System.out.println("picking node " + nodeNum);
		BinaryTreeNode node = getNthNode(nodeNum, root);
		return node;
	}
	
	private BinaryTreeNode getNthNode(int nodeNum, BinaryTreeNode root) {
		if(root == null) {
			return null;
		}
		
		int leftSize = 0;
		
		BinaryTreeNode ln = root.getLeft();
		if(ln != null) {
			leftSize = ln.getSubtreeSize();			
		}		
		
		//System.out.println(nodeNum + "|"  + leftSize  + "|" + root.getData());
		
		if(nodeNum == (leftSize + 1)) {
			return root;
		} else if(nodeNum <= leftSize) {
			return getNthNode(nodeNum, ln);
		} else {
			return getNthNode(nodeNum - (leftSize + 1) , root.getRight());
		}
		
	}

	@Override
	public void print() {
		printNode(root, 0);
	}

	private BinaryTreeNode add(BinaryTreeNode root, int data) {
		if(root == null) {
			root = new BinaryTreeNode(data);
			return root;
		}
		int d = root.getData();
		if(data < d) {
			BinaryTreeNode n = add(root.getLeft(), data);
			root.setLeft(n);			
		} else {
			BinaryTreeNode n = add(root.getRight(), data);
			root.setRight(n);
		}
		root.setSubtreeSize(root.getSubtreeSize() + 1);
		return root;
	}
	

	private void printNode(BinaryTreeNode node, int level) {
		if(node == null) {
			return;
		}
		
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < level; i++) {
			s.append(" ");
		}
		s.append(node.getData() + "/" + node.getSubtreeSize());
		System.out.println(s);
		
		printNode(node.getLeft(), level + 1);
		printNode(node.getRight(), level + 1);
	}
	
	public static void main(String[] args) {
		BinarySearchTreeWithGetRandom tree = new BinarySearchTreeWithGetRandom();
		
		/*
		 *           5
		 *       3       8
		 *     2   4   7   9
		 *   1        6  
		 */
		
		tree.add(5);
		tree.add(8);
		tree.add(3);
		tree.add(4);
		tree.add(2);
		tree.add(7);
		tree.add(9);
		tree.add(6);
		tree.add(1);
		
		//tree.print();
		
		for(int i = 0; i < 10; i++) {
			BinaryTreeNode n = tree.getRandom();
			System.out.println(n.getData());
		}
		
	}
}
