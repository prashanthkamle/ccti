package interview.ccti.treesandgraphs;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	private Set<Node> nodes;
	
	public Graph() {
		nodes = new HashSet<>();
	}
	
	public void addNode(Node n) {
		nodes.add(n);
	}

	public Set<Node> getNodes() {
		return nodes;
	}
	
	public void addDirectedEdge(Node n1, Node n2) {
		addNode(n1);
		addNode(n2);
		n1.addNeighbour(n2);
	}
	
	public void addUndirectedEdge(Node n1, Node n2) {
		addDirectedEdge(n1, n2);
		addDirectedEdge(n2, n1);
	}
}
