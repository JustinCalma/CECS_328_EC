import java.util.ArrayList;

public class Prim {
	
	public static void main(String[] args) {
		Prim prim = new Prim();
		
		System.out.println("THE GRAPH G = { {a,b}, {a,c}, {a,d}, {b,a}, {b,d}, {b,e}, {c,a}, {c,d}, {d,a}, {d,b}, {d,c}, {d,e}, {d,f}, {e,b}, {e,d}, {e,f}, {e,g}, {f,d}, {f,e}, {f,g} }");
		
		Node a = new Node();
		a.name = "a";
		
		Node b = new Node();
		b.name = "b";
		
		Node c = new Node();
		c.name = "c";
		
		Node d = new Node();
		d.name = "d";
		
		Node e = new Node();
		e.name = "e";
		
		Node f = new Node();
		f.name = "f";
		
		Node g = new Node();
		g.name = "g";
		
		Node h = new Node();
		h.name = "h";

		// NODE A:
		ArrayList<Node> a_Adjacent = new ArrayList<Node>();
		a_Adjacent.add(b);
		a_Adjacent.add(c);
		a_Adjacent.add(d);
		a.setAdjacent(a_Adjacent);
		
		ArrayList<Edge> a_Edges =  new ArrayList<Edge>();
		Edge a_Edge1 = new Edge(a, b, 1);
		Edge a_Edge2 = new Edge(a, c, 2);
		Edge a_Edge3 = new Edge(a, d, 10);
		
		a_Edges.add(a_Edge1);
		a_Edges.add(a_Edge2);
		a_Edges.add(a_Edge3);
		a.setEdges(a_Edges);
		
		// NODE B:
		ArrayList<Node> b_Adjacent = new ArrayList<Node>();
		b_Adjacent.add(a);
		b_Adjacent.add(d);
		b_Adjacent.add(e);
		b.setAdjacent(b_Adjacent);
		
		ArrayList<Edge> b_Edges = new ArrayList<Edge>();
		Edge b_Edge1 = new Edge(b, a, 1);
		Edge b_Edge2 = new Edge(b, d, 2);
		Edge b_Edge3 = new Edge(b, e, 6);
		
		b_Edges.add(b_Edge1);
		b_Edges.add(b_Edge2);
		b_Edges.add(b_Edge3);
		b.setEdges(b_Edges);
		
		// NODE C:
		ArrayList<Node> c_Adjacent = new ArrayList<Node>();
		c_Adjacent.add(a);
		c_Adjacent.add(d);
		c.setAdjacent(c_Adjacent);
		
		ArrayList<Edge> c_Edges = new ArrayList<Edge>();
		Edge c_Edge1 = new Edge(c, a, 2);
		Edge c_Edge2 = new Edge(c, d, 5);
		
		c_Edges.add(c_Edge1);
		c_Edges.add(c_Edge2);
		c.setEdges(c_Edges);
		
		// NODE D:
		ArrayList<Node> d_Adjacent = new ArrayList<Node>();
		d_Adjacent.add(a);
		d_Adjacent.add(b);
		d_Adjacent.add(c);
		d_Adjacent.add(e);
		d_Adjacent.add(f);
		d.setAdjacent(d_Adjacent);
		
		ArrayList<Edge> d_Edges = new ArrayList<Edge>();
		Edge d_Edge1 = new Edge(d, a, 10);
		Edge d_Edge2 = new Edge(d, b, 3);
		Edge d_Edge3 = new Edge(d, c, 5);
		Edge d_Edge4 = new Edge(d, e, 4);
		Edge d_Edge5 = new Edge(d, f, 9);
		
		d_Edges.add(d_Edge1);
		d_Edges.add(d_Edge2);
		d_Edges.add(d_Edge3);
		d_Edges.add(d_Edge4);
		d_Edges.add(d_Edge5);
		d.setEdges(d_Edges);

		// NODE E:
		ArrayList<Node> e_Adjacent = new ArrayList<Node>();
		e_Adjacent.add(b);
		e_Adjacent.add(d);
		e_Adjacent.add(f);
		e_Adjacent.add(g);
		e.setAdjacent(e_Adjacent);
		
		ArrayList<Edge> e_Edges = new ArrayList<Edge>();
		Edge e_Edge1 = new Edge(e, b, 6);
		Edge e_Edge2 = new Edge(e, d, 4);
		Edge e_Edge3 = new Edge(e, f, 1);
		Edge e_Edge4 = new Edge(e, g, 2);
		
		e_Edges.add(e_Edge1);
		e_Edges.add(e_Edge2);
		e_Edges.add(e_Edge3);
		e_Edges.add(e_Edge4);
		e.setEdges(e_Edges);

		// NODE F:
		ArrayList<Node> f_Adjacent = new ArrayList<Node>();
		f_Adjacent.add(d);
		f_Adjacent.add(e);
		f_Adjacent.add(g);
		f.setAdjacent(f_Adjacent);
		
		ArrayList<Edge> f_Edges = new ArrayList<Edge>();
		Edge f_Edge1 = new Edge(f, d, 9);
		Edge f_Edge2 = new Edge(f, e, 1);
		Edge f_Edge3 = new Edge(f, g, 8);
		
		f_Edges.add(f_Edge1);
		f_Edges.add(f_Edge2);
		f_Edges.add(f_Edge3);
		f.setEdges(f_Edges);
		
		// Adds each vertex into an ArrayList 
		ArrayList<Node> Vertices = new ArrayList<Node>();
		Vertices.add(a);
		Vertices.add(b);
		Vertices.add(c);
		Vertices.add(d);
		Vertices.add(e);
		Vertices.add(f);
		
		prim.Prim(a, Vertices);

	}
	
	// Prim Method
	public void Prim(Node vertex, ArrayList<Node> Vertices) {
		
		// Initializes the starting vertex's parent and cost
		vertex.parent = vertex;
		vertex.cost = 0;
		
		// Calls min heap and puts the smallest cost as the root
		build_MinHeap(Vertices);
		
		// While the heap is not empty keep iterating through the array
		while(Vertices.size() > 0) {
			
			// Remove the root and save the node
			Node u = Vertices.remove(0);
			
			// Iterate through the removed node's adjacency list
			for (Node n : u.adjacent) {
				
				// If the cost is greater than the weight of the edge enter
				if (n.cost > u.getWeight(n)) {
					
					// Set the cost of the node to be the weight
					n.cost = u.getWeight(n);
					
					// Set the parent pointer of the current node to be the removed node
					n.parent = u;
					
					// Update the costs by calling min Heapify
					min_Heapify(Vertices, 0, Vertices.size());
					
					// Print the output 
					System.out.println(n.cost);
				}
			}
		}		
	}
	
	
	// Build Min Heap Method
	public void build_MinHeap(ArrayList<Node> a) { // Build Min heap function. Only takes in the passed array as a parameter
		
		int arrLength = 0; // Instantiates the variable for array length
		
		arrLength = a.size(); // Gets the length of the array and saves it into a variable
		
		for (int i = arrLength / 2; i >= 0; i--) {
			min_Heapify(a, i , arrLength); // Calls Min Heapify function and passes in the array, index, and length
		}
		
	}
	
	// Min Heapify Method
	public void min_Heapify(ArrayList<Node> a, int i, int arrLength) {
		
		int leftIdx = 2*i + 1; // Finds the index of the left child and the parent is index i
		
		int rightIdx = 2*i + 2; // Finds the index of the right child and the parent is index i
		
		int midIdx = i; // Index of the parent
		
		if (leftIdx < arrLength && a.get(leftIdx).cost < a.get(midIdx).cost) { // Compares if the left child is less than the parent
			midIdx = leftIdx;
		}
		if (rightIdx < arrLength && a.get(rightIdx).cost < a.get(midIdx).cost) { // Compares if the right child is less than parent
			midIdx = rightIdx;
		}
		if (midIdx != i) {
			// Call swap helper method to switch the element at index i and the mid element
			swap(a, i, midIdx);
			min_Heapify(a, midIdx, arrLength);
		}
		
	}
	
	// Helper method to set the inital distances of each vertex to INF
	public void setCost(ArrayList<Node> Vertices) {
		for (Node node : Vertices) {
			node.cost = Integer.MAX_VALUE;
		}
	}
	
	// Helper method to swap two elements in the array
	public void swap(ArrayList<Node> a, int x, int y) { 
		Node temp = a.get(x);
		a.set(x, a.get(y));
		a.set(y, temp);
		
	}
	
}

// Justin Calma CECS 328 - 14 F 8:00 AM - 12:45 PM