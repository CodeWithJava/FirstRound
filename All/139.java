public class Solution
{
	public boolean wordBreak(String s, Set<String> wordDict)
	{
		if((s == null || s.length() == 0) && (wordDict == null || wordDict.size() == 0))
			return true;

		if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
			return false;

		boolean [] dp = new boolean [s.length() + 1];
		dp[0] = true;

		for(int i = 0;i < s.length();i++)
		{
			if(!dp[i])
				continue;

			for(String x: wordDict)
			{
				int length = x.length();

				int end = i + length;

				if(end > s.length())
					continue;

				if(dp[end])
					continue;

				if(s.substring(i,end).equals(x))
					dp[end] = true;
			}
		}

		return dp[s.length()];
	}
}