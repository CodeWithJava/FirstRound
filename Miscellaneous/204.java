public class Solution
{
	public int countPrimes(int n)
	{
		if(n <= 0)
			return 0;

		int [] composite = new int [n+1];

		composite[0] = 1;
		composite[1] = 1;

		for(int i = 2;i * i < n;i++)
		{
			if(i == 2)
			{
				int x = 4;
				while(x < n)
				{
					composite[x] = 1;
					x += 2;
				}
			}
			else if(composite[i] == 0)
			{
				int x = i * i;
				while(x < n)
				{
					composite[x] = 1;
					x += i * 2;
				}
			}
		}

		int result = 0;

		for(int i = 2;i < n;i++)
		{
			if(composite[i] == 0)
				result++;
		}

		return result;
	}
}