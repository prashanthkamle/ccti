package interview.ccti.treesandgraphs;

public class BinaryTree {
	
	protected BinaryTreeNode root;
	
	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	
	public void print() {
		printNode(root, 0);
	}

	private void printNode(BinaryTreeNode node, int level) {
		if(node == null) {
			return;
		}
		
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < level; i++) {
			s.append(" ");
		}
		s.append(node.getData());
		System.out.println(s);
		
		printNode(node.getLeft(), level + 1);
		printNode(node.getRight(), level + 1);
	}

}
