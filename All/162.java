public class Solution
{
	public int findPeakElement(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int max = nums[0];
		int index = 0;

		for(int i = 1;i < nums.length - 1;i++)
		{
			int prev = nums[i - 1];
			int curr = nums[i];
			int next = nums[i + 1];

			if(prev < curr && curr > next && curr > max)
			{
				max = curr;
				index = i;
			}
		}

		if(nums[nums.length - 1] > max)
			return nums.length - 1;

		return index;
	}
}