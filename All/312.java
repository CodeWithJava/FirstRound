public class Solution
{
	public int maxCoins(int [] iNums)
	{
		if(iNums == null || iNums.length == 0)
			return 0;

		int l = iNums.length;
		int [] nums = new int [l + 2];
		nums[0] = 1;
		nums[l + 1] = 1;
		for(int i = 0;i < l;i++)
			nums[i + 1] = iNums[i];

		int [][] dp = new int [l + 2][l + 2];

		return dynamicProgramming(1,l,nums,dp);
	}

	private int dynamicProgramming(int i, int j, int [] nums, int [][] dp)
	{
		if(dp[i][j] > 0)
			return dp[i][j];

		for(int x = i;x <= j;x++)
			dp[i][j] = Math.max(dp[i][j], dynamicProgramming(i,x - 1,nums,dp) + nums[i - 1] * nums[x] * nums[j + 1] + dynamicProgramming(x + 1,j,nums,dp));

		 return dp[i][j];
	}
}