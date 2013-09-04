
public class GraphEdge {
	private int y;
	private int weight;
	private GraphEdge next;
	
	public GraphEdge(int targetNode, int weight) {
		y = targetNode;
		this.weight = weight;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean hasNext() {
		return next != null;
	}
	
	public GraphEdge getNext() {
		return next;
	}

	public void setNext(GraphEdge next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "(" + y + ", " + weight + ")"; 
	}
	
}
