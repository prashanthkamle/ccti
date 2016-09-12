package interview.ccti.treesandgraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Question 4.7
 * @author prashanth
 *
 */
public class BuildOrder {
	public static void main(String[] args) {
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		Graph graph = new Graph();
		graph.addNode(n1);
		graph.addNode(n2);
		graph.addNode(n3);
		graph.addNode(n4);
		graph.addNode(n5);
		graph.addNode(n6);
		graph.addDirectedEdge(n1, n4);
		graph.addDirectedEdge(n6, n2);
		graph.addDirectedEdge(n2, n4);
		graph.addDirectedEdge(n6, n1);
		graph.addDirectedEdge(n4, n3);

		List<Node> order = computeBuildOrder(graph);
		for(Node n : order) {
			System.out.print(n.getData() + " > ");
		}
	}

	private static List<Node> computeBuildOrder(Graph graph) {
		
		Set<Node> nodes = graph.getNodes();
		
		HashMap<Node, Integer> indegrees = computeIndegrees(nodes);
		
		Queue<Node> toProcess = new LinkedList<>();
		HashSet<Node> isVisited = new HashSet<>();
		
		for(Node n : nodes) {
			int deg = indegrees.get(n);
			if(deg == 0) {
				toProcess.add(n);
				isVisited.add(n);
			}
		}
		
		ArrayList<Node> buildOrder = new ArrayList<>();
		while(!toProcess.isEmpty()) {

			Node n = toProcess.remove();
			buildOrder.add(n);
			
			Set<Node> neighbours = n.getNeighbours();
			for(Node neighbour : neighbours) {
				if(!isVisited.contains(neighbour)) {
					toProcess.add(neighbour);
					isVisited.add(neighbour);
				}
			}			
		}
		
		//contains a cycle?
		if(isVisited.size() != nodes.size()) {
			return null;
		}
	
		return buildOrder;
	}

	private static HashMap<Node, Integer> computeIndegrees(Set<Node> nodes) {
		HashMap<Node, Integer> indegrees = new HashMap<>();
		for(Node n : nodes) {
			indegrees.put(n, 0);
		}
		for(Node n : nodes) {
			Set<Node> neighbours = n.getNeighbours();
			for(Node neighbour : neighbours) {
				Integer indeg = indegrees.get(neighbour);
				indeg++;
				indegrees.put(neighbour, indeg);
			}
		}
		return indegrees;
	}
}
