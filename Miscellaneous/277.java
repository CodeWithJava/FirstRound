public class Solution extends Relation
{
	public int findCelebrity(int n)
	{
		if(n <= 0)
			throw new IllegalArgumentException("Input is invalid");

		int l = 0;
		int r = n - 1;

		while(l < r)
		{
			if(knows(l,r))
				l++;
			else
				r--;
		}

		for(int i = 0;i < n;i++)
		{
			if(i != l)
			{
				if(knows(l,i) || ! knows(i,l))
					return -1;
			}
		}

		return l;
	}
}