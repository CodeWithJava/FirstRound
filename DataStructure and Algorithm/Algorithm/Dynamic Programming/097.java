// Way One
// 1D Dynamic Programming
// It is hard to understand it
public class Solution
{
	public boolean isInterleave(String s1, String s2, String s3)
	{
		if((s1 == null || s1.length() == 0) && (s2 == null || s2.length() == 0) && (s3 == null || s3.length() == 0))
			return true;

		if(s3 == null || s3.length() == 0)
			return false;

		if((s1 == null || s1.length() == 0) && (s2 == null || s2.length() == 0))
			return false;

		if((s1 == null || s1.length() == 0) && s2.equals(s3))
			return true;

		if((s2 == null || s2.length() == 0) && s1.equals(s3))
			return true;

		if(s1.length() + s2.length() != s3.length())
			return false;

		char [] x = s1.toCharArray();
		char [] y = s2.toCharArray();
		char [] z = s3.toCharArray();

		boolean [] dp = new boolean[x.length + 1];
		dp[0] = true;

		for(int i = 1;i < dp.length;i++)
			dp[i] = dp[i - 1] && x[i - 1] == z[i - 1];

		for(int i = 1;i <= y.length;i++)
		{
			dp[0] = dp[0] && y[i - 1] == z[i - 1];

			for(int j = 1;j <= x.length;j++)
				dp[j] = dp[j - 1] && x[j - 1] == z[i + j - 1] || dp[j] && y[i - 1] == z[j + i - 1];
		}

		return dp[x.length];
	}
}

// Way Two
// 2D Dynamic Programming
// It is easy to understand it

public class Solution
{
	public boolean isInterleave(String s1, String s2, String s3)
	{
		if((s1 == null || s1.length() == 0) && (s2 == null || s2.length() == 0) && (s3 == null || s3.length() == 0))
			return true;

		if(s3 == null || s3.length() == 0)
			return false;

		if((s1 == null || s1.length() == 0) && (s2 == null || s2.length() == 0))
			return false;

		if((s1 == null || s1.length() == 0) && s2.equals(s3))
			return true;

		if((s2 == null || s2.length() == 0) && s1.equals(s3))
			return true;

		if(s1.length() + s2.length() != s3.length())
			return false;

		int x = s1.length();
		int y = s2.length();

		boolean [][] dp = new boolean [x + 1][y + 1];
		dp[0][0] = true;

		for(int i = 1;i <= x && s1.charAt(i -1) == s3.charAt(i - 1);i++)
			dp[i][0] = true;

		for(int j = 1;j <= y && s2.charAt(j - 1) == s3.charAt(j - 1);j++)
			dp[0][j] = true;

		for(int i = 1;i <= x;i++)
		{
			for(int j = 1;j <= y;j++)
			{
				char c = s3.charAt(i + j - 1);

				if(c == s1.charAt(i - 1) && dp[i - 1][j])
					dp[i][j] = true;

				if(c == s2.charAt(j - 1) && dp[i][j - 1])
					dp[i][j] = true;
			}
		}

		return dp[x][y];
	}
}