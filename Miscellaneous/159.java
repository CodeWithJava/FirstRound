public class Solution
{
	public int lengthOfLongestSubstringTwoDistinct(String s)
	{
		if(s == null || s.length() == 0)
			return 0;

		int start = 0;
		int maximum = 0;

		Map<Character,Integer> map = new HashMap<>();

		for(int i = 0;i < s.length();i++)
		{
			char x = s.charAt(i);

			if(map.size() == 2 && !map.containsKey(x))
			{
				char left = ' ';

				int minLast = s.length();

				for(char c: map.keySet())
				{
					int last = map.get(c);

					if(last < minLast)
					{
						minLast = last;
						left = c;
					}
				}

				map.remove(left);
				start = minLast + 1;
			}

			map.put(x,i);

			maximum = Math.max(maximum, i - start + 1);
		}

		return maximum;
	}
}