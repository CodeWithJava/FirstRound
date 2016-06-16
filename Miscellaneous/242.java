// Way One
public class Solution
{
	public boolean isAnagram(String s,String t)
	{
		if(s.length() != t.length())
			return false;
		char [] x = s.toCharArray();
		char [] y = t.toCharArray();
		Arrays.sort(x);
		Arrays.sort(y);

		for(int i = 0;i < s.length();i++)
		{
			if(x[i] != y[i])
				return false;
		}
		return true;
	}
}

// Way Two
public class Solution
{
	public boolean isAnagram(String s, String t)
	{
		if(s.length() != t.length())
			return false;

		int [] duplicates = new int [26];

		for(int i = 0;i < s.length();i++)
			duplicates[s.charAt(i) - 'a']++;

		for(int i = 0;i < t.length();i++)
		{
			if(--duplicates[t.charAt(i) - 'a'] < 0)
				return false;
		}

		return true;
	}
}