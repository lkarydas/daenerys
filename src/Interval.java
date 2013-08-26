


class Interval {
	private int start;
	private int end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	int getStart() {
		return start;
	}

	int getEnd() {
		return end;
	}
	
	@Override
	public String toString() {
		return "(" + start + ", " + end + ")";
		
	}
}
