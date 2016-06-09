public class Solution
{
	public String longestPalindrome(String s)
	{
		if(s == null || s.length() == 0)
			return "";

		String longest = "";

		for(int i = 0;i < s.length();i++)
		{
			String t = longestPalindrome(s,i,i);
			if(t.length() > longest.length())
				longest = t;
			t = longestPalindrome(s,i,i+1);
			if(t.length() > longest.length())
				longest = t;
		}

		return longest;
	}

	private String longestPalindrome(String s, int i, int j)
	{
		while(i >= 0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j))
		{
			i--;
			j++;
		}
		return s.substring(i+1,j);
	}
}