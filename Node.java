import java.util.ArrayList;

public class Node {

	// Fields for the Node class
	public Node parent;
	public ArrayList<Node> adjacent; 
	public String name;
	public int startTime;
	public int endTime;
	public int distance;
	public ArrayList<Edge> edges;
	public int cost;
	
	// Constructor 
	public Node() {
		this.parent = null;
		this.adjacent = new ArrayList<Node>();
		this.name = "";
		this.startTime = 0;
		this.endTime = 0;
		this.distance = Integer.MAX_VALUE;
		this.cost = 0;
	}
	
	// Sets the adjacency list for the given vertex
	public void setAdjacent(ArrayList<Node> adjacent) {
		this.adjacent = adjacent;
	}
	
	// Sets the Edges connected to the given vertex
	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	
	public int getWeight(Node a) {
		for (Edge currentEdge : edges) {
			if (currentEdge.destination.name.equals(a.name)) {
				return currentEdge.weight;
			}
		}
		return -1;
	}
	
}

// Justin Calma CECS 328 - 14 F 8:00 AM - 12:45 PM