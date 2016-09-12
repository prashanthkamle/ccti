package interview.ccti.treesandgraphs;

import java.util.LinkedHashSet;
import java.util.Set;

public class Node {
	private int data;
	private Set<Node> neighbours;

	public Node(int data) {
		this.data = data;
		neighbours = new LinkedHashSet<>();
	}
	
	public void addNeighbour(Node n) {
		neighbours.add(n);
	}
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	public Set<Node> getNeighbours() {
		return neighbours;
	}

	@Override
	public String toString() {
		return Integer.toString(data);
	}
}
