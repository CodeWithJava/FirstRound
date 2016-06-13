public class Solution
{
	public int calculateMinimumHP(int [][] dungeon)
	{
		if(dungeon == null || dungeon.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int r = dungeon.length;
		int c = dungeon[0].length;

		int [][] dp = new int [r][c];

		dp[r - 1][c - 1] = Math.max(1 - dungeon[r - 1][c - 1],1);

		for(int i = r - 2;i >= 0;i--)
			dp[i][c - 1] = Math.max(dp[i + 1][c - 1] - dungeon[i][c - 1],1);

		for(int j = c - 2;j >= 0;j--)
			dp[r - 1][j] = Math.max(dp[r - 1][j + 1] - dungeon[r - 1][j],1);

		for(int i = r - 2;i >= 0;i--)
		{
			for(int j = c - 2;j >= 0;j--)
			{
				int down = Math.max(dp[i + 1][j] - dungeon[i][j],1);
				int right = Math.max(dp[i][j + 1] - dungeon[i][j],1);

				dp[i][j] = Math.min(down,right);
			}
		}

		return dp[0][0];
	}
}