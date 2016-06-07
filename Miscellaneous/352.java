class IntervalComparator implements Comparator<Interval>
{
	public int compare(Interval i1, Interval i2)
	{
		return i1.start - i2.start;
	}
}
public class SummaryRanges
{
	TreeSet<Interval> set;

	/** Initialize your data structure here.  */
	SummaryRanges()
	{
		set = new TreeSet<>(new IntervalComparator());
	}

	public void addNum(int val)
	{
		Interval newInterval = new Interval(val,val);

		Interval floor = set.floor(newInterval);
		if(floor != null)
		{
			if(floor.end >= val)
				return;
			else if(floor.end + 1 == val)
			{
				newInterval.start = floor.start;
				set.remove(floor);
			}
		}

		Interval higher = set.higher(newInterval);
		if(higher != null && higher.start == val + 1)
		{
			newInterval.end = higher.end;
			set.remove(higher);
		}

		set.add(newInterval);
	}

	public List<Interval> getIntervals()
	{
		return Arrays.asList(set.toArray(new Interval [0]));
	}
}