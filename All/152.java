public class Solution
{
	public int maxProduct(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return Integer.MAX_VALUE;

		int partMax = nums[0];
		int partMin = nums[0];
		int max = nums[0];

		for(int i = 1;i < nums.length;i++)
		{
			int t = partMax;
			partMax = Math.max(Math.max(partMax * nums[i],nums[i]),partMin * nums[i]);
			partMin = Math.min(Math.min(t * nums[i],nums[i]),partMin * nums[i]);

			max = Math.max(max,partMax);
		}

		return max;
	}
}