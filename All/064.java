public class Solution
{
	public int minPathSum(int [][] grid)
	{
		if(grid == null || grid.length == 0)
			return 0;

		int r = grid.length;
		int c = grid[0].length;

		int [][] dp = new int [r][c];
		dp[0][0] = grid[0][0];

		for(int i = 1;i < r;i++)
			dp[i][0] = dp[i - 1][0] + grid[i][0];

		for(int i = 1;i < c;i++)
			dp[0][i] = dp[0][i - 1] + grid[0][i];

		for(int i = 1;i < r;i++)
		{
			for(int j = 1;j < c;j++)
			{
				if(dp[i - 1][j] > dp[i][j - 1])
					dp[i][j] = dp[i][j - 1] + grid[i][j];
				else
					dp[i][j] = dp[i - 1][j] + grid[i][j];
			}
		}

		return dp[r - 1][c - 1];
	}
}