// Memory and Recursion
public class Solution
{
	Map<String,List<String>> map = new HashMap<>();

	public List<String> wordBreak(String s, Set<String> wordDict)
	{
		List<String> result = new ArrayList<>();

		if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
			return result;

		if(map.get(s) != null)
			return map.get(s);

		if(wordDict.contains(s))
			result.add(s);

		for(int i = 1;i < s.length();i++)
		{
			String word = s.substring(0,i);

			if(wordDict.contains(word))
			{
				List<String> t = wordBreak(s.substring(i),wordDict);

				for(String str: t)
					result.add(word + " " + str);
			}
		}

		map.put(s,result);

		return result;
	}
}

// Old Accepted Answer
// Now Time Limitation Exceed
// By special case
// String s: "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
// Set<String> wordDict: ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
public class Solution
{
	public List<String> wordBreak(String s, Set<String> wordDict)
	{
		List<String> result = new ArrayList<>();

		if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
			return result;

		for(int i = s.length() - 1;i >= 0;i--)
		{
			if(wordDict.contains(s.substring(i)))
				break;
			else
			{
				if(i == 0)
					return result;
			}
		}

		wordBreak(s,wordDict,"",result);

		return result;
	}

	private void wordBreak(String s, Set<String> wordDict, String t, List<String> result)
	{
		if(s.length() == 0)
			result.add(t.substring(1));
		else
		{
			for(int i = 0;i <= s.length();i++)
			{
				String word = s.substring(0,i);

				if(wordDict.contains(word))
					wordBreak(s.substring(i),wordDict,t + " " + word,result);
			}
		}
	}
}