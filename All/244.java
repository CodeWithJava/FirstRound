public class WordDistance
{
	Map<String,List<Integer>> map;

	WordDistance(String [] words)
	{
		if(words == null || words.length == 0)
			return;

		map = new HashMap<>();

		for(int i = 0;i < words.length;i++)
		{
			String word = words[i];

			if(map.containsKey(word))
				map.get(word).add(i);
			else
			{
				List<Integer> t = new ArrayList<>();
				t.add(i);
				map.put(word,t);
			}
		}
	}

	public int shortest(String word1, String word2)
	{
		List<Integer> p = map.get(word1);
		List<Integer> q = map.get(word2);

		int miniDistance = Integer.MAX_VALUE;

		for(int i: p)
		{
			for(int j: q)
				miniDistance = Math.min(miniDistance, Math.abs(i - j));
		}

		return miniDistance;
	}
}