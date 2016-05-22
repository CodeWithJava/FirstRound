public class Solution
{
	public int mySqrt(int x)
	{
		if(x < 0)
			throw new IllegalArgumentException("Input must be not-negative");

		if(x == 0)
			return 0;

		double pre = 0;
		double result = 1;

		while(pre != result)
		{
			pre = result;
			result = (result + x / result) / 2;
		}

		return (int) result;
	}
}