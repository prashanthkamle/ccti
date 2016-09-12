package interview.ccti.treesandgraphs;

public class BinarySearchTree extends BinaryTree {

	public void add(int data) {
		root = add(root, data, root);
	}


	private BinaryTreeNode add(BinaryTreeNode root, int data, BinaryTreeNode parent) {
		if(root == null) {
			root = new BinaryTreeNode(data);
			root.setParent(parent);
			return root;
		}
		int d = root.getData();
		if(data < d) {
			BinaryTreeNode n = add(root.getLeft(), data, root);
			root.setLeft(n);
		} else {
			BinaryTreeNode n = add(root.getRight(), data, root);
			root.setRight(n);
		}
		return root;
	}

}
