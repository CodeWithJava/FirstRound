public class Solution
{
	public int minSubArrayLen(int s, int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int i = 0;
		int j = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;

		while(i < nums.length && j < nums.length)
		{
			while(sum < s && j < nums.length)
				sum += nums[j++];

			while(sum >= s && i <= j)
			{
				min = Math.min(min,j - i);
				sum -= nums[i++];
			}
		}

		return min == Integer.MAX_VALUE ? 0:min;
	}
}