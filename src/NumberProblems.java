class NumberProblems {

	/**
	 * Check whether a number is a power of x.
	 */
	boolean isPower(float number, float x) {
		while (number > 1) {
			number /= x;
		}

		if (number == 1) {
			return true;
		}

		return false;
	}
	
	/**
	 * Compute the nth fibonacci number recursively.
	 * @param n
	 * @return
	 */
	int fibRec(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibRec(n - 1) + fibRec(n - 2);
	}
	
	/**
	 * Compute the nth Fibonacci number iteratively.
	 * @param n
	 * @return
	 */
	int fibIter(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int n1 = 0, n2 = 1, n3 = 0;
		for (int i = 0; i < n - 1; i++) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		return n3;
	}
}