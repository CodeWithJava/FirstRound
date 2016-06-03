public class Solution
{
	public int rangeBitwiseAnd(int m, int n)
	{
		if(m < 0 || m > Integer.MAX_VALUE || n < 0 || n > Integer.MAX_VALUE || m > n )
			throw new IllegalArgumentException("Input is invalid");

		while(n > m)
			n = n & (n - 1);

		return m & n;
	}
}