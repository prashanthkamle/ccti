package interview.ccti.treesandgraphs;

public class BinaryTreeNode {
	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	private BinaryTreeNode parent;
	private int subtreeSize = 1;
	
	public BinaryTreeNode(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	
	public BinaryTreeNode getLeft() {
		return left;
	}
	
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	
	public BinaryTreeNode getRight() {
		return right;
	}
	
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public BinaryTreeNode getParent() {
		return parent;
	}

	public void setParent(BinaryTreeNode parent) {
		this.parent = parent;
	}

	public int getSubtreeSize() {
		return subtreeSize;
	}

	public void setSubtreeSize(int subtreeSize) {
		this.subtreeSize = subtreeSize;
	}	
}
