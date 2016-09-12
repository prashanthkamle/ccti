package interview.ccti.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Question 4.3
 * @author prashanth
 *
 */
public class ListOfDepths {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		/*
		 *           5
		 *       3       8
		 *     2   4   7   9
		 *   1        6  
		 */
		
		bst.add(5);
		bst.add(8);
		bst.add(3);
		bst.add(4);
		bst.add(2);
		bst.add(7);
		bst.add(9);
		bst.add(6);
		bst.add(1);
		
		List<LinkedList<BinaryTreeNode>> levelNodes = createListOfDepths(bst);
		
		for(LinkedList<BinaryTreeNode> level : levelNodes) {
			for(BinaryTreeNode n : level) {
				System.out.print(n.getData() + " ");
			}
			System.out.println();
		}
	}

	private static List<LinkedList<BinaryTreeNode>> createListOfDepths(BinaryTree tree) {
		ArrayList<LinkedList<BinaryTreeNode>> levelNodes = new ArrayList<>();
		
		BinaryTreeNode node = tree.getRoot();
		updateListOfDepths(node, levelNodes, 0);
		
		return levelNodes;
	}

	private static void updateListOfDepths(BinaryTreeNode node, ArrayList<LinkedList<BinaryTreeNode>> levelNodes, int level) {
		if(node == null) {
			return;
		}
		
		int size = levelNodes.size();
		if(size == level) {
			LinkedList<BinaryTreeNode> list = new LinkedList<>();
			levelNodes.add(list);
		}
		LinkedList<BinaryTreeNode> list = levelNodes.get(level);
		list.add(node);
		
		updateListOfDepths(node.getLeft(), levelNodes, level + 1);
		updateListOfDepths(node.getRight(), levelNodes, level + 1);
	}
}
