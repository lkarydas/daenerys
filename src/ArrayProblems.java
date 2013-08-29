/**
 * 
 * Code practice with problems associated with arrays.
 * 
 * @author Lazaros Karydas
 *
 */
public class ArrayProblems {

	/**
	 * Rotate a matrix 90 degrees clockwise. Allocates memory space for an entire copy of the
	 * original, and the new array is returned.
	 * 
	 * @param mat The input matrix
	 * @return the output matrix
	 */
	static int[][] rotateNinety(int[][] mat) {
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