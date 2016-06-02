// Way One
// Pigeonhole Principle
// https://en.wikipedia.org/wiki/Pigeonhole_principle
public class Solution
{
	public int findDuplicate(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int l = 0;
		int r = nums.length - 1;

		while(l <= r)
		{
			int m = l + (r - l) / 2;
			int count = 0;

			for(int i = 0;i < nums.length;i++)
			{
				if(nums[i] <= m)
					count++;
			}

			if(count > m)
				r = m - 1;
			else
				l = m + 1;
		}

		return l;
	}
}

// Way Two
// Find the node where the cycle begins
// Quote from 142.Linked List Cycle II
public class Solution
{
	public int findDuplicate(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int fast = 0;
		int slow = 0;

		do
		{
			fast = nums[nums[fast]];
			slow = nums[slow];
		}
		while(fast != slow);

		fast = 0;

		while(fast != slow)
		{
			fast = nums[fast];
			slow = nums[slow];
		}

		return fast;
	}
}