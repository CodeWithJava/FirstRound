public class Solution
{
	public int hIndex(int [] citations)
	{
		if(citations == null || citations.length == 0)
			return 0;

		Arrays.sort(citations);
		int result = 0;

		for(int i = citations.length - 1;i >= 0;i--)
		{
			if(result >= citations[i])
				return result;
			result++;
		}

		return result;
	}
}