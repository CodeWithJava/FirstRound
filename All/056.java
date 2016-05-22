public class Solution
{
	public List<Interval> merge(List<Interval> intervals)
	{
		if(intervals == null || intervals.size() < 2)
			return intervals;

		List<Interval> result = new ArrayList<>();
		Collections.sort(intervals,new IntervalComparator());

		Interval pre = intervals.get(0);

		for(int i = 1;i < intervals.size();i++)
		{
			Interval cur = intervals.get(i);

			if(pre.end < cur.start)
			{
				result.add(pre);
				pre = cur;
			}
			else
				pre = new Interval(pre.start,Math.max(pre.end,cur.end));
		}

		result.add(pre);

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