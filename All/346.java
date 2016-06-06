public class MovingAverage
{
	Queue<Integer> q;
	int size;

	/** Initialize your data structure here. */
	MovingAverage(int size)
	{
		this.q = new LinkedList<>();
		this.size = size;
	}

	public double next(int val)
	{
		q.offer(val);

		if(q.size() > size)
			q.poll();

		int sum = 0;

		for(int x: q)
			sum += x;

			return (double)sum / q.size();
	}
}