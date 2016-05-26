public class Solution
{
	public List<Integer> findSubstring(String s, String [] words)
	{
		List<Integer> result = new ArrayList<>();

		if(s == null || s.length() == 0 || words == null || words.length == 0)
			return result;

		Map<String, Integer> map = new HashMap<>();
		for(String word: words)
		{
			if(map.containsKey(word))
				map.put(word, map.get(word) + 1);
			else
				map.put(word, 1);
		}

		int l = words[0].length();

		for(int j = 0;j < l;j++)
		{
			Map<String, Integer> currentMap = new HashMap<>();

			int start = j;
			int count = 0;

			for(int i = j;i <= s.length() - l;i += l)
			{
				String sub = s.substring(i,i+l);

				if(map.containsKey(sub))
				{
					if(currentMap.containsKey(sub))
						currentMap.put(sub, currentMap.get(sub) + 1);
					else
						currentMap.put(sub, 1);

					count++;

					while(currentMap.get(sub) > map.get(sub))
					{
						String left = s.substring(start, start + l);
						currentMap.put(left, currentMap.get(left) - 1);

						count--;
						start += l;
					}

					if(count == words.length)
					{
						result.add(start);

						String left = s.substring(start, start + l);
						currentMap.put(left, currentMap.get(left) - 1);

						count--;
						start += l;
					}
				}
				else
				{
					currentMap.clear();
					start = i + l;
					count = 0;
				}
			}
		}

		return result;
	}
}