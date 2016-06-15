public class Solution
{
	public int findMin(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int l = 0;
		int r = nums.length - 1;

		while(l < r)
		{
			int m = l + (r - l) / 2;

			if(nums[m] < nums[r])
				r = m;
			else
				l = m + 1;
		}

		return nums[l];
	}
}