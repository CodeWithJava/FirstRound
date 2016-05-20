public class Solution
{
	public int lengthOfLongestSubstring(String s)
	{
		if(s == null || s.length() == 0)
			return 0;
		int max = 0;
		Map<Character,Integer> map  = new HashMap<>();

		for(int i = 0;i < s.length();i++)
		{
			char x = s.charAt(i);
			if(map.containsKey(x))
			{
				max = Math.max(max,map.size());
				i = map.get(x);
				map.clear();
			}
			else
				map.put(x,i);
		}

		return Math.max(max,map.size());
	}
}