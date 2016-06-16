public class Solution
{
	public List<List<String>> groupStrings(String [] strings)
	{
		List<List<String>> result = new ArrayList<>();

		if(strings == null || strings.length == 0)
			return result;

		for(String string: strings)
		{
			boolean newGroup = true;

			for(List<String> group: result)
			{
				if(isSameGroup(group.get(0),string))
				{
					group.add(string);
					newGroup = false;
					break;
				}
			}

			if(newGroup)
			{
				List<String> temp = new ArrayList<>();
				temp.add(string);
				result.add(temp);
			}
		}

		for(List<String> group: result)
			Collections.sort(group);
		return result;
	}

	private boolean isSameGroup(String s1,String s2)
	{
		if(s1.length() != s2.length())
			return false;

		for(int i = 0;i < s1.length() - 1;i++)
		{
			int delta1 = s1.charAt(i) - s2.charAt(i);
			delta1 = delta1 < 0 ? delta1 + 26: delta1;

			int delta2 = s1.charAt(i + 1) - s2.charAt(i + 1);
			delta2 = delta2 < 0 ? delta2 + 26: delta2;

			if(delta1 != delta2)
				return false;
		}

		return true;
	}
}
