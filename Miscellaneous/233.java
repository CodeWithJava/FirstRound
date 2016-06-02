public class Solution
{
	public int countDigitOne(int n)
	{
		if(n < 1)
			return 0;

		int ones = 0;

		for(long i = 1;i <= n;i *= 10)
		{
			long a = n / i;
			long b = n % i;

			ones += (a + 8) / 10 * i;

			if(a % 10 == 1)
				ones += b + 1;
		}

		return ones;
	}
}