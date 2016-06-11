public class Solution
{
	public int maxSubArray(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int [] dp = new int [nums.length];
		dp[0] = nums[0];

		int max = nums[0];

		for(int i = 1;i < nums.length;i++)
		{
			dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]);
			max = Math.max(max,dp[i]);
		}

		return max;
	}
}