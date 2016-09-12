package interview.ccti.treesandgraphs;

/**
 * Question 4.2
 * @author prashanth
 *
 */
public class MinimalTree {
	public static void main(String[] args) {
		int sortedArr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		BinaryTree tree = createTree(sortedArr);
		tree.print();
	}

	private static BinaryTree createTree(int[] sortedArr) {		
		BinaryTreeNode root = createTree(sortedArr, 0, sortedArr.length);
		BinaryTree tree = new BinaryTree();
		tree.setRoot(root);
		return tree;
	}

	private static BinaryTreeNode createTree(int[] sortedArr, int start, int end) {
		
		if(start >= end) {
			return null;
		}
		
		
		int mid = (start + end)/2;
		BinaryTreeNode n = new BinaryTreeNode(sortedArr[mid]);
		BinaryTreeNode left = createTree(sortedArr, start, mid);
		BinaryTreeNode right = createTree(sortedArr, mid + 1, end);
		
		n.setLeft(left);
		n.setRight(right);
		
		return n;
	}
}
