public class Solution
{
	public int minMeetingRooms(Interval [] intervals)
	{
		if(intervals == null || intervals.length == 0)
			return 0;
		Arrays.sort(intervals,new IntervalComparator());
		int room = 1;
		Queue<Integer> minHeap = new PriorityQueue<>();
		for(Interval interval: intervals)
		{
			if(minHeap.size() == 0)
			{
				minHeap.offer(interval.end);
				continue;
			}

			if(minHeap.peek() <= interval.start)
			{
				minHeap.poll();
				minHeap.offer(interval.end);
			}
			else
			{
				minHeap.offer(interval.end);
				room++;
			}
		}
		return room;
	}
}
class IntervalComparator implements Comparator<Interval>
{
	public int compare(Interval i1,Interval i2)
	{
		return i1.start - i2.start;
	}
}