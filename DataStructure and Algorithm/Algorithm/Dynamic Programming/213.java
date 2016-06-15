public class Solution
{
	public int rob(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
		if(nums.length == 2)
			return Math.max(nums[0],nums[1]);

		int [] dp = new int [nums.length];
		dp[0] = 0;
		dp[1] = nums[0];

		for(int i = 2;i < nums.length;i++)
			dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i-1]);
		
		int [] dq = new int [nums.length];
		dq[0] = 0;
		dq[1] = nums[1];

		for(int i = 2;i < nums.length;i++)
			dq[i] = Math.max(dq[i-1],dq[i-2] + nums[i]);

		return Math.max(dp[nums.length-1],dq[nums.length-1]);
	}
}