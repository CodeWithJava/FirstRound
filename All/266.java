public class Solution
{
	public boolean canPermutePalindrome(String s)
	{
		if(s == null || s.length() == 0)
			return true;

		Set<Character> set = new HashSet<>();

		for(char x: s.toCharArray())
		{
			if(set.contains(x))
				set.remove(x);
			else
				set.add(x);
		}

		return set.size() <= 1;
	}
}
