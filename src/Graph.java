import java.util.HashMap;


class Graph {
	HashMap<Integer, GraphEdge> adj;

	/**
	 * Empty graph constructor.
	 */
	Graph() {
		adj = new HashMap<Integer, GraphEdge>();
	}

	void addEdge(int sourceNode, int targetNode, int weight) {
		addDirectedEdge(sourceNode, targetNode, weight);
		addDirectedEdge(targetNode, sourceNode, weight);
	}

	void addDirectedEdge(int sourceNode, int targetNode, int weight) {
		if (adj.containsKey(sourceNode)) {
			// Find the last edge in the linked list.
			GraphEdge edge = adj.get(sourceNode);
			while (edge.hasNext()) {
				edge = edge.getNext();
			}
			edge.setNext(new GraphEdge(targetNode, weight));
		} else {
			adj.put(sourceNode, new GraphEdge(targetNode, weight));
		}
	}

	int getVertexCount() {
		return adj.size();
	}

	void print() {
		for (int i = 0; i < getVertexCount(); i++) {
			System.out.print("Node " + i + ": ");
			if (adj.get(i) == null) {
				System.err.println("<Unconnected Node!>");
			} else {
				GraphEdge edge = adj.get(i);
				System.out.print(edge.toString() + " ");
				while (edge.hasNext()) {
					edge = edge.getNext();
					System.out.print(edge.toString() + " ");
				}
				System.out.println("");
			}
		}
	}

}