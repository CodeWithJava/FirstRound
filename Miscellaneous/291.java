public class Solution
{
	Map<Character,String> map;
	Set<String> set;
	boolean result;

	public boolean wordPatternMatch(String pattern, String str)
	{
		if(pattern == null && str == null || pattern.length() == 0 && str.length() == 0)
			return true;
		if(pattern == null || pattern.length() == 0 || str == null || str.length() == 0)
			return false;

		map = new HashMap<>();
		set = new HashSet<>();

		wordPatternMatch(pattern,str,0,0);

		return result;
	}

	private void wordPatternMatch(String pattern, String str, int i, int j)
	{
		if(i == pattern.length() && j == str.length())
			result = true;
		else
		{
			if(i >= pattern.length() || j >= str.length())
				return;

			char c = pattern.charAt(i);

			for(int cut = j + 1;cut <= str.length();cut++)
			{
				String sub = str.substring(j,cut);

				if(!set.contains(sub) && !map.containsKey(c))
				{
					map.put(c,sub);
					set.add(sub);

					wordPatternMatch(pattern,str,i + 1,cut);

					map.remove(c);
					set.remove(sub);
				}
				else if(map.containsKey(c) && map.get(c).equals(sub))
					wordPatternMatch(pattern,str,i + 1,cut);
			}
		}
	}
}