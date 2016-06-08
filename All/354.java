class EnvelopeComparator implements Comparator<int []>
{
	public int compare(int [] e1, int [] e2)
	{
		if(e1[0] == e2[0])
			return e2[1] - e1[1];
		else
			return e1[0] - e2[0];
	}
}
public class Solution
{
	public int maxEnvelopes(int [][] envelopes)
	{
		if(envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2)
			return 0;

		Arrays.sort(envelopes,new EnvelopeComparator());

		int [] dp = new int [envelopes.length];

		int length = 0;

		for(int [] envelope: envelopes)
		{
			int index = Arrays.binarySearch(dp,0,length,envelope[1]);

			if(index < 0)
				index = -(index + 1);

			dp[index] = envelope[1];

			if(index == length)
				length++;
		}

		return length;
	}
}