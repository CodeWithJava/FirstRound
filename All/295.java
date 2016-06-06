class MedianFinder
{
	Queue<Integer> maxHeap;
	Queue<Integer> minHeap;

	MedianFinder()
	{
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap = new PriorityQueue<>();
	}
	// Adds a number into the data struture.
	public void addNum(int num)
	{
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());

		if(maxHeap.size() < minHeap.size())
			maxHeap.offer(minHeap.poll());
	}

	// Returns the median of current data stream.
	public double findMedian()
	{
		if(maxHeap.size() == minHeap.size())
			return ((double)(maxHeap.peek()) + minHeap.peek()) / 2;
		else
			return maxHeap.peek();
	}
};