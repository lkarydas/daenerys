import java.util.Comparator;


class SortIntervalByStartPoint implements Comparator<Interval> {

	@Override
	public int compare(Interval arg0, Interval arg1) {
		if (arg0.getStart() < arg1.getStart()) {
			return -1;
		} else if (arg0.getStart() > arg1.getStart()) {
			return 1;
		}
		return 0;
	}

}
