package interview.ccti.treesandgraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import junit.framework.Assert;

/**
 * Question 4.1
 * @author prashanth
 *
 */
public class RouteBetweenNodes {

	public static void main(String[] args) {
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		Node n12 = new Node(12);
		Node n13 = new Node(13);
		Node n14 = new Node(14);
		
		
		/*     3
		 *     ^
		 * 1 > 2 < 4 > 6
		 *     v       ^
		 * 8 < 5 > 7 > 9 > 10
		 * 
		 * 11 > 12 > 13
		 *       V
		 *      14 
		 */
		
		n1.addNeighbour(n2);
		n2.addNeighbour(n3);
		n2.addNeighbour(n5);
		n4.addNeighbour(n2);
		n4.addNeighbour(n6);
		n5.addNeighbour(n8);
		n5.addNeighbour(n7);
		n7.addNeighbour(n9);
		n9.addNeighbour(n10);
		n10.addNeighbour(n6);
		
		n11.addNeighbour(n12);
		n12.addNeighbour(n13);
		n13.addNeighbour(n14);
		
		Assert.assertTrue(hasPath(n1, n6));
		Assert.assertTrue(hasPath(n4, n8));
		Assert.assertFalse(hasPath(n1, n11));
		Assert.assertFalse(hasPath(n1, n4));
		
		
	}

	private static boolean hasPath(Node n1, Node n2) {
		HashSet<Node> visited = new HashSet<>();
		Queue<Node> toVisit = new LinkedList<>();
		toVisit.add(n1);
		
		while(!toVisit.isEmpty()) {
			Node n = toVisit.remove();
			if(n == n2) { 
				return true;
			}
			visited.add(n);
			Set<Node> neighbours = n.getNeighbours();
			for(Node neighbour : neighbours) {
				toVisit.add(neighbour);
			}			
		}
		return false;
	}
	
}
