// Way One
public class Solution
{
	public int [] maxSlidingWindow(int [] nums, int k)
	{
		if(nums == null || nums.length == 0 || k < 0 || k > nums.length)
			return new int [0];

		LinkedList<Integer> q = new LinkedList<>();
		int [] result = new int [nums.length - k + 1];

		for(int i = 0;i < nums.length;i++)
		{
			if(!q.isEmpty() && q.peek() == i - k)
				q.poll();

			while(!q.isEmpty() && nums[q.peekLast()] < nums[i])
				q.removeLast();

			q.offer(i);

			if(i + 1 >= k)
				result[i + 1 - k] = nums[q.peek()];
		}

		return result;
	}
}

// Way Two
public class Solution
{
	public int [] maxSlidingWindow(int [] nums, int k)
	{
		if(nums == null || nums.length == 0 || k < 0 || k > nums.length)
			return new int [0];

		Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		int [] result = new int [nums.length - k + 1];

		for(int i = 0;i < nums.length;i++)
		{
			if(i >= k)
				maxHeap.remove(nums[i - k]);

			maxHeap.offer(nums[i]);

			if(i + 1 >= k)
				result[i + 1 - k] = maxHeap.peek();
		}

		return result;
	}
}