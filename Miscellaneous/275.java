public class Solution
{
	public int hIndex(int [] citations)
	{
		if(citations == null || citations.length == 0)
			return 0;

		int size = citations.length;
		int l = 0;
		int r = size - 1;
		int m = l + (r - l) / 2;

		while(l <= r)
		{
			if(citations[m] >= size - m)
			{
				if(m == 0 || citations[m-1] < size - m +1)
					return size - m;
				else
					r = m - 1;
			}
			else
				l = m + 1;
			m = l + (r - l) / 2;
		}

		return 0;
	}
}