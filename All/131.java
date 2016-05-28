// Depth First Search
public class Solution
{
	public List<List<String>> partition(String s)
	{
		List<List<String>> result = new ArrayList<>();

		if(s == null || s.length() == 0)
			return result;

		List<String> t = new ArrayList<>();

		partition(s,0,t,result);

		return result;
	}

	private void partition(String s, int start, List<String> t, List<List<String>> result)
	{
		if(start == s.length())
			result.add(new ArrayList<>(t));
		else
		{
			for(int i = start + 1;i <= s.length();i++)
			{
				String str = s.substring(start,i);
				if(isPalindrome(str))
				{
					t.add(str);
					partition(s,i,t,result);
					t.remove(t.size() - 1);
				}
			}
		}
	}

	private boolean isPalindrome(String str)
	{
		int l = 0;
		int r = str.length() - 1;

		while(l < r)
		{
			if(str.charAt(l) != str.charAt(r))
				return false;

			l++;
			r--;
		}

		return true;
	}
}

// Dynamic Programming
public class Solution
{
	public List<List<String>> partition(String s)
	{
		List<List<String>> [] result = new ArrayList [s.length() + 1];
		result[0] = new ArrayList<>();
		result[0].add(new ArrayList<>());

		if(s == null || s.length() == 0)
			return result[0];

		int [][] dp = new int [s.length()][s.length()];

		for(int r = 0;r < s.length();r++)
		{
			result[r + 1] = new ArrayList<>();

			for(int l = 0;l <= r;l++)
			{
				if(s.charAt(l) == s.charAt(r) && (r - l < 2 || dp[l + 1][r - 1] == 1))
				{
					dp[l][r] = 1;

					String str = s.substring(l,r + 1);

					for(List<String> x: result[l])
					{
						List<String> t = new ArrayList<>(x);
						t.add(str);
						result[r + 1].add(t);
					}
				}
			}
		}

		return result[s.length()];
	}
}