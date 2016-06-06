public class Solution
{
	public int lengthOfLongestSubstringKDistinct(String s, int k)
	{
		if(s == null || s.length() == 0 || k <= 0)
			return 0;

		int start = 0;
		int maximum = 0;

		Map<Character,Integer> map = new HashMap<>();

		for(int i = 0;i < s.length();i++)
		{
			char x = s.charAt(i);

			if(map.containsKey(x))
				map.put(x,map.get(x) + 1);
			else
			{
				map.put(x,1);

				while(map.size() > k)
				{
					char startChar = s.charAt(start++);

					int count = map.get(startChar);

					if(count > 1)
						map.put(startChar,count - 1);
					else
						map.remove(startChar);
				}
			}

			maximum = Math.max(maximum,i - start + 1);
		}

		return maximum;
	}
}