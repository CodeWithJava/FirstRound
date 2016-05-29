public class Solution
{
	public List<String> findRepeatedDnaSequences(String s)
	{
		List<String> result = new ArrayList<>();

		if(s.length() < 10)
			return result;

		Map<Character,Integer> map = new HashMap<>();

		map.put('A',0);
		map.put('C',1);
		map.put('G',2);
		map.put('T',3);

		Set<Integer> t = new HashSet<>();
		Set<Integer> added = new HashSet<>();

		int hash = 0;

		for(int i = 0;i < s.length();i++)
		{
			if(i < 9)
				hash = (hash << 2) + map.get(s.charAt(i));
			else
			{
				hash = (hash << 2) + map.get(s.charat(i));
				hash = hash & (1 << 20) - 1;

				if(t.contains(hash) && !added.contains(hash))
				{
					result.add(s.substring(i - 9,i + 1));
					added.add(hash);
				}
				else
					t.add(hash);
			}
		}

		return result;
	}
}