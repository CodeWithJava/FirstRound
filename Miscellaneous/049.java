public class Solution
{
	public List<List<String>> groupAnagrams(String [] strs)
	{
		List<List<String>> result = new ArrayList<>();

		if(strs == null || strs.length == 0)
			return result;

		Map<String,List<String>> map = new HashMap<>();

		for(String str: strs)
		{
			char [] x = str.toCharArray();
			Arrays.sort(x);
			String s = String.valueOf(x);

			if(map.containsKey(s))
			{
				List<String> t = map.get(s);
				t.add(str);
				Collections.sort(t);
			}
			else
			{
				List<String> t = new ArrayList<>();
				t.add(str);
				map.put(s,t);
			}
		}

		for(List<String> x: map.values())
			result.add(new ArrayList<>(x));

		return result;
	}
}