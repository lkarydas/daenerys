import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * My solution to the sample Facebook programming challenge 'Hanoi Moves'. 
 * 
 * Description of the problem:
 * 
 * There are K pegs. Each peg can hold discs in decreasing order of radius when looked from bottom
 * to top of the peg. There are N discs which have radius 1 to N; Given the initial configuration of
 * the pegs and the final configuration of the pegs, output the moves required to transform from the
 * initial to final configuration. You are required to do the transformations in minimal number of
 * moves.
 * A move consists of picking the topmost disc of any one of the pegs and placing it on top of
 * anyother peg. At anypoint of time, the decreasing radius property of all the pegs must be
 * maintained.
 * Constraints: 1 <= N <= 8   3 <= K <= 5
 * 
 * Input Format: N K 2nd line contains N integers. Each integer in the second line is in the range 1
 * to K where the i-th integer denotes the peg to which disc of radius i is present in the initial
 * configuration. 3rd line denotes the final configuration in a format similar to the initial
 * configuration.
 * 
 * Output Format: The first line contains M - The minimal number of moves required to complete the
 * transformation. The following M lines describe a move, by a peg number to pick from and a peg
 * number to place on. If there are more than one solutions, it's sufficient to output any one of
 * them. You can assume, there is always a solution with less than 7 moves and the initial
 * confirguration will not be same as the final one.
 * 
 * Sample Input #00:
 * 2 3
 * 1 1
 * 2 2 
 * Sample Output #00:
 * 3
 * 1 3
 * 1 2
 * 3 2
 * Sample Input #01:
 * 6 4
 * 4 2 4 3 1 1
 * 1 1 1 1 1 1
 * Sample Output #01:
 * 5
 * 3 1
 * 4 3
 * 4 1
 * 2 1
 * 3 1
 * 
 * The current solution constructs a tree of all possible outcomes (nodes are configurations and
 * edges are moves). The path is found by searching the tree for the desired configuration using
 * BFS. The implementation passes all six test cases on the Facebook challenge website.
 * 
 * @author Lazaros Karydas
 * 
 */
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
		while(!queue.isEmpty()) {
			node = (Node) queue.remove();
			child = null;
			if (node.hasTheSameConfiguration(targetConfiguration)) {
				break;
			}
			children = node.getChildren();
			for (int i = 0; i < children.length; i++) {
				child = children[i];
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

	/**
	 * Parses a line of space separated integers.
	 * @param br An input {@link BufferedReader}. 
	 * @param count The number of integers to parse.
	 * @return An integer array with the numbers read.
	 */
	int[] parseSpaceSeparatedNumbers(BufferedReader br, int count) {
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		public void print() {
			System.out.println(src + " " + dst);
		}
	}

	private class Node {
		private int[] configuration;  	// Numbers represent peg number, positions represent disc radius.
		public int K; 					// Number of pegs.
		private Move move;			    // The move that takes us from the parent node to this.
		private Node parent;

		boolean hasTheSameConfiguration(int[] configuration) {
			return Arrays.equals(configuration, this.configuration);
		}

		Node(int[] configuration, int pegCount) {
			this.configuration = configuration;
			K = pegCount;
		}

		Node(int[] configuration, Move move, Node parent, int pegCount) {
			this.configuration = configuration;
			K = pegCount;
			this.move = move;
			this.parent = parent;
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