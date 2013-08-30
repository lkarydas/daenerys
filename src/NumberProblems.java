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
	int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}