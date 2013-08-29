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
	
	/**
	 * Rotate the input matrix 90 degrees clockwise without using extra space.
	 * Note: We are still using a temporary integer variable but O(1) space is negligible.
	 * @param mat the matrix to rotate in place.
	 */
	static void rotateNinetyInPlace(int[][] mat) {
		// Preconditions: Matrix must be square.
		if (mat.length != mat[0].length) {
			System.err.println("Matrix must be square.");
		}
		int M = mat.length;
		int m = M/2;
		int temp;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m + 1; j++) {
				temp = mat[i][j];
				mat[i][j] = mat[M - 1 - j][i];
				mat[M - 1 - j][i] = mat[M - 1 - i][M - 1 - j];
				mat[M - 1 - i][M - 1 - j] = mat[j][M - 1 - i];
				mat[j][M - 1 - i] = temp;
			}
		}
	}
}