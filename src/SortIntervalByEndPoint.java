import java.util.Comparator;


class SortIntervalByEndPoint implements Comparator<Interval> {

	@Override
	public int compare(Interval arg0, Interval arg1) {
		if (arg0.getEnd() < arg1.getEnd()) {
			return -1;
		} else if (arg0.getEnd() > arg1.getEnd()) {
			return 1;
		}
		return 0;
	}

}
