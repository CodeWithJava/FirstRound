public class Solution
{
	public List<String> fullJustify(String [] words, int maxWidth)
	{
		List<String> result = new ArrayList<>();

		if(words == null || words.length == 0)
			return result;

		int count = 0;
		int last = 0;

		for(int i = 0;i < words.length;i++)
		{
			count += words[i].length();

			if(count + i - last > maxWidth)
			{
				int wordsLength = count - words[i].length();
				int spaceLength = maxWidth - wordsLength;
				int eachLength = 1;
				int extraLength = 0;

				if(i - last - 1 > 0)
				{
					eachLength = spaceLength / (i - last - 1);
					extraLength = spaceLength % (i - last - 1);
				}

				StringBuilder sb = new StringBuilder();

				for(int k = last; k < i - 1;k++)
				{
					sb.append(words[k]);

					int ce = 0;

					while(ce < eachLength)
					{
						sb.append(" ");
						ce++;
					}

					if(extraLength > 0)
					{
						sb.append(" ");
						extraLength--;
					}
				}

				sb.append(words[i - 1]);

				while(sb.length() < maxWidth)
					sb.append(" ");

				result.add(sb.toString());

				last = i;
				count = words[i].length();
			}
		}

		int lastLength = 0;
		StringBuilder sb = new StringBuilder();

		for(int i = last;i < words.length - 1;i++)
		{
			count += words[i].length();
			sb.append(words[i] + " ");
		}

		sb.append(words[words.length - 1]);

		int d = 0;

		while(sb.length() < maxWidth)
			sb.append(" ");

		result.add(sb.toString());

		return result;
	}
}