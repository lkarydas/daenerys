
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
	
}
