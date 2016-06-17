public class Solution
{
	public int minCostII(int[][] costs)
	{
		if(costs == null || costs.length == 0)
			return 0;
		int n = costs.length;
		int k = costs[0].length;
		
		int [] dp = new int [k];
		int min1 = 0;
		int min2 = 0;
		for(int i = 0;i < n;i++)
		{
			int t1 = min1;
			int t2 = min2;
			min1 = Integer.MAX_VALUE;
			min2 = Integer.MAX_VALUE;

			for(int j = 0;j < k;j++)
			{
				if(dp[j] != t1 || t1 == t2)
					dp[j] = t1 + costs[i][j];
				else
					dp[j] = t2 + costs[i][j];

				if(min1 <= dp[j])
					min2 = Math.min(min2,dp[j]);
				else
				{
					min2 = min1;
					min1 = dp[j];
				}
			}
		}

		return min1;
	}
}