public class Solution
{
	public List<String> generateAbbreviations(String word)
	{
		List<String> result = new ArrayList<>();

		if(word == null || word.length() == 0)
		{
			result.add(new String(""));
			return result;
		}

		generateAbbreviations(word,0,"",result);

		return result;
	}

	private void generateAbbreviations(String word, int start, String cur, List<String> result)
	{
		result.add(cur + word.substring(start));

		if(start == word.length())
			return;
		else
		{
			int i = 0;

			if(start != 0)
				i = start + 1;

			for(;i < word.length();i++)
			{
				String prefix = cur + word.substring(start,i);

				for(int j = 1;j <= word.length() - i;j++)
					generateAbbreviations(word,i + j,prefix + j,result);
			}
		}
	}
}