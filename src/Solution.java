import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {

	public static void main(String[] args) {
		Solution mySolution = new Solution();
		mySolution.solve();
	}


	void solve() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Parse N and K.
		int[] NK = parseSpaceSeparatedNumbers(br, 2);
		int N = NK[0];
		int K = NK[1];
		// Parse input configuration
		int[] inputConfig = parseSpaceSeparatedNumbers(br, N);
		// Parse input configuration
		int[] outputConfig = parseSpaceSeparatedNumbers(br, N);
		// Create the root node.
		Node root = new Node(inputConfig, K);
		breadthFirstSearch(root, outputConfig);
	}

	void breadthFirstSearch(Node root, int[] targetConfiguration)
	{
		Node node = null, child;
		Node[] children;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		root.visited = true;

		while(!queue.isEmpty()) {
			node = (Node) queue.remove();
			child = null;

			if (node.hasTheSameConfiguration(targetConfiguration)) {
				break;
			}
			children = node.getChildren();
			for (int i = 0; i < children.length; i++) {
				child = children[i];
				child.visited = true;
				queue.add(child);
			}

		}
		// Reconstruct the path of nodes by following the parents.
		ArrayList<Node> path = new ArrayList<Node>();
		path.add(node);
		while (node.getParent() != null) {
			node = node.getParent();
			path.add(node);
		}
		// Reverse the order of nodes in the path.
		Collections.reverse(path);
		// Print the number of moves.
		System.out.println(path.size() - 1);
		// Print the move of every node in the path.
		for (Node n : path) {
			if (n.getMove() == null) continue;
			n.getMove().print();
		}
	}

	int[] parseSpaceSeparatedNumbers(BufferedReader br, int count) {
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (line == null) {
			System.err.println("Couldn't read line from input.");
		} else {
			System.err.println("Line: " + line);
		}

		String[] parts = line.split(" ");
		if (parts.length != count) {
			System.err.println("Second line has to have exactly " + count + " numbers.");
		}
		int[] numbers = new int[parts.length];
		for(int n = 0; n < parts.length; n++) {
			numbers[n] = Integer.parseInt(parts[n]);
		}
		return numbers;
	} 
	/**
	 * Represents the move as source peg number to destination peg number.
	 */
	private class Move {
		int src;
		int dst;
		Move(int src, int dst) {
			this.src = src;
			this.dst = dst;
		}
		int getSrc() {
			return this.src;
		}
		int getDst() {
			return this.dst;
		}
		public void print() {
			System.out.println(src + " " + dst);
		}
	}

	private class Node {

		private int[] configuration;  	// Numbers represent peg number, positions represent disc radius.
		public int K; 					// Number of pegs.
		private Move move;			    // The move that takes us from the parent node to this.
		private Node parent;
		public boolean visited;

		boolean hasTheSameConfiguration(int[] configuration) {
			return Arrays.equals(configuration, this.configuration);
		}

		public void print() {
			System.out.println("Node:");
			for (int i = 0; i < configuration.length; i++) {
				System.out.print(configuration[i] +" ");
			}
			System.out.println("");
			System.out.println("(" + this.move.getSrc() + ", " + this.move.getDst() + ")");
			System.out.println("Parent: " + this.parent);

		}

		Node(int[] configuration, int pegCount) {
			this.configuration = configuration;
			K = pegCount;
			visited = false;
		}

		Node(int[] configuration, Move move, Node parent, int pegCount) {
			this.configuration = configuration;
			K = pegCount;
			this.move = move;
			this.parent = parent;
			visited = false;
		}

		Node[] getChildren() {
			ArrayList<Node> children = new ArrayList<Node>();
			for (int i = 1; i <= K; i++) {
				for (int j = 1; j <= K; j++) {
					if (i == j) continue;
					if (isMoveValid(i, j)) {
						// Add child
						children.add(getChild(i, j));
					}

				}
			}

			if (children.isEmpty()) {
				System.err.println("No children!");
			}

			return children.toArray(new Node[children.size()]);
		}

		Node getParent() {
			return this.parent;
		}

		Move getMove() {
			return this.move;
		}

		Node getChild(int pegA, int pegB) {
			// TODO: We shouldn't recalculate this.
			int discRadiusA = getTopDiscRadiusAtPeg(pegA);
			int[] newConfiguration = new int[configuration.length];
			System.arraycopy(this.configuration, 0, newConfiguration, 0, configuration.length);
			newConfiguration[discRadiusA] = pegB;
			return new Node(newConfiguration, new Move(pegA, pegB), this, this.K);
		}

		boolean isMoveValid(int pegA, int pegB) {
			int discRadiusA = getTopDiscRadiusAtPeg(pegA);
			if (discRadiusA > configuration.length) {
				return false;
			}
			int discRadiusB = getTopDiscRadiusAtPeg(pegB);
			return discRadiusA < discRadiusB;
		}

		int getTopDiscRadiusAtPeg(int peg) {
			for (int disc = 0; disc < configuration.length; disc++) {
				if (configuration[disc] == peg)
				{
					return disc;
				}
			}
			return Integer.MAX_VALUE;
		}

	}
}