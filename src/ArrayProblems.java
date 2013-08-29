
public class ArrayProblems {

	static int[][] rotateNintyDegreesClockwise(int[][] mat) {
		
		// Preconditions: Matrix must be square.
		
		if (mat.length != mat[0].length) {
			System.err.println("Matrix must be square.");
		}
		int M = mat.length;
		int[][] out = new int[M][M];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				out[j][M - i - 1] = mat[i][j];
			}
		}
		return out;
	}
}
