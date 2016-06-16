public class Solution
{
	public boolean canAttendMeetings(Interval [] intervals)
	{
		if(intervals == null || intervals.length == 0)
			return true;

		Arrays.sort(intervals,new IntervalComparator());

		Interval pre = intervals[0];
		for(int i = 1;i < intervals.length;i++)
		{
			Interval cur = intervals[i];
			if(pre.end <= cur.start)
				pre = cur;
			else
				return false;
		}

		return true;
	}
}
class IntervalComparator implements Comparator<Interval>
{
	public int compare(Interval i1,Interval i2)
	{
		return i1.start - i2.start;
	}
}