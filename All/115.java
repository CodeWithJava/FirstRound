public class Solution
{
	public int numDistinct(String s, String t)
	{
		if(s == null && t == null)
			return 1;

		int m = s.length();
		int n = t.length();

		int [][] dp = new int [n + 1][m + 1];
		dp[0][0] = 1;

		for(int i = 1;i <= n;i++)
			dp[i][0] = 0;

		for(int j = 1;j <= m;j++)
			dp[0][j] = 1;

		for(int i = 1;i <= n;i++)
		{
			for(int j = 1;j <= m;j++)
			{
				dp[i][j] += dp[i][j - 1];

				if(t.charAt(i - 1) == s.charAt(j - 1))
					dp[i][j] += dp[i - 1][j - 1];
			}
		}

		return dp[n][m];
	}
}