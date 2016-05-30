// Way One
// Dynamic Programming
public class Solution
{
	public int integerBreak(int n)
	{
		if(n <= 0)
			throw new IllegalArgumentException("Input must be non-positive");

		int [] dp = new int [n + 1];

		for(int i = 1;i < n;i++)
		{
			for(int j = 1;j <= i;j++)
			{
				if(i + j <= n)
					dp[i + j] = Math.max(dp[i + j], Math.max(dp[i],i) * Math.max(dp[j],j));
			}
		}

		return dp[n];
	}
}

// Way Two
// Mathematic Method
public class Solution
{
	public int integerBreak(int n)
	{
		if(n <= 0)
			throw new IllegalArgumentException("Input must be non-negative");

		if(n == 1 || n == 2)	return 1;
		if(n == 3)	return 2;
		if(n == 4) 	return 4;

		int result = 1;

		if(n % 3 == 0)
			result = (int) Math.pow(3,n / 3);
		else if(n % 3 == 2)
			result = (int) Math.pow(3,n / 3) * 2;
		else if(n % 3 == 1)
			result = (int) Math.pow(3,(n - 4) / 3) * 4;

		return result;
	}
}