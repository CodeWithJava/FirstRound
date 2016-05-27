public class Solution
{
	public String minWindow(String s, String t)
	{
		if(t.length() > s.length())
			return "";

		Map<Character,Integer> target = new HashMap<>();
		for(int i = 0;i < t.length();i++)
		{
			char x = t.charAt(i);

			if(target.containsKey(x))
				target.put(x,target.get(x) + 1);
			else
				target.put(x,1);
		}

		String result = "";

		Map<Character,Integer> source = new HashMap<>();

		int l = 0;
		int minLength = s.length() + 1;
		int count = 0;

		for(int i =0;i < s.length();i++)
		{
			char c = s.charAt(i);

			if(target.containsKey(c))
			{
				if(source.containsKey(c))
				{
					if(source.get(c) < target.get(c))
						count++;
					source.put(c,source.get(c) + 1);
				}
				else
				{
					source.put(c,1);
					count++;
				}
			}

			if(count == t.length())
			{
				char x = s.charAt(l);

				while(!source.containsKey(x) || source.get(x) > target.get(x))
				{
					if(source.containsKey(x) && source.get(x) > target.get(x))
						source.put(x,source.get(x) - 1);

					l++;
					x = s.charAt(l);
				}

				if(i - l + 1 < minLength)
				{
					result = s.substring(l,i + 1);
					minLength = i - l + 1;
				}
			}
		}

		return result;
	}
}