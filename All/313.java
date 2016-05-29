public class Solution
{
	public int nthSuperUglyNumber(int n, int [] primes)
	{
		int [] index = new int [primes.length];
		int [] result = new int [n];
		result[0] = 1;

		for(int i = 1;i < n;i++)
		{
			int minmum = Integer.MAX_VALUE;

			for(int j = 0;j < primes.length;j++)
				minmum = Math.min(minmum, primes[j] * result[index[j]]);

			result[i] = minmum;

			for(int j = 0;j < index.length;j++)
				if(result[index[j]] * primes[j] == minmum)
					index[j]++;
		}

		return result[n - 1];
	}
}