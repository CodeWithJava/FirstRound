public class Solution
{
	public List<Interval> insert(List<Interval> intervals, Interval newInterval)
	{
		List<Interval> result = new ArrayList<>();

		Collections.sort(intervals, new IntervalComparator());

		for(int i = 0;i < intervals.size();i++)
		{
			Interval interval = intervals.get(i);

			if(interval.end < newInterval.start)
				result.add(interval);
			else if(newInterval.end < interval.start)
			{
				result.add(newInterval);
				newInterval = interval;
			}
			else
				newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
		}

		result.add(newInterval);

		return result;
	}
}
class IntervalComparator implements Comparator<Interval>
{
	public int compare(Interval i1, Interval i2)
	{
		return i1.start - i2.start;
	}
}