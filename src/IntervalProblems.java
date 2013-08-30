import java.util.Arrays;

public class IntervalProblems {
	
	/**
	 * Given a set of intervals, print the union.
	 * @param intervals the intervals to find the union of
	 */
	void findUnion(Interval[] intervals) {
		Interval[] sortedByStart = new Interval[intervals.length];
		System.arraycopy(intervals, 0, sortedByStart, 0, intervals.length);
		Arrays.sort(sortedByStart, new SortIntervalByStartPoint());
		Interval[] sortedByEnd = new Interval[intervals.length];
		System.arraycopy(intervals, 0, sortedByEnd, 0, intervals.length);
		Arrays.sort(sortedByEnd, new SortIntervalByEndPoint());
		
		System.out.println("Sorted by start:");
		for (int i = 0; i < sortedByStart.length; i++) {
			System.out.println(sortedByStart[i].toString());
		}
		int index = 0;
		int intervalStart;
		int maxEnd = 0; // Assume non-negative integers.
		while (index < intervals.length) {
			Interval interval = sortedByStart[index];
			intervalStart = interval.getStart();
			maxEnd = interval.getEnd();

			while(index + 1 < intervals.length && sortedByStart[index + 1].getStart() < maxEnd) {
				maxEnd = Math.max(maxEnd, sortedByStart[index + 1].getEnd());
				index++;
			}
			if (index < intervals.length) {
				System.out.println("_____ " + new Interval(intervalStart, maxEnd));
			}
			index++;
		}
	}
}