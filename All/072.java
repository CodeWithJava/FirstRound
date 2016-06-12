public class Solution
{
	public int minDistance(String word1, String word2)
	{
		if(word1 == null && word2 == null)
			return 0;

		if(word1 == null || word1.length() == 0)
			return word2.length();

		if(word2 == null || word2.length() == 0)
			return word1.length();

		int m = word1.length();
		int n = word2.length();

		int [][] dp = new int [m + 1][n + 1];
		dp[0][0] = 0;

		for(int i = 1;i <= m;i++)
			dp[i][0] = i;

		for(int j = 1;j <= n;j++)
			dp[0][j] = j;

		for(int i = 0;i < m;i++)
		{
			char p = word1.charAt(i);

			for(int j = 0;j < n;j++)
			{
				char q = word2.charAt(j);

				if(p == q)
					dp[i + 1][j + 1] = dp[i][j];
				else
				{
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;

					dp[i + 1][j + 1] = Math.min(replace,Math.min(insert,delete));
				}
			}
		}

		return dp[m][n];
	}
}