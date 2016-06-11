public class Solution
{
	public double myPow(double x, int n)
	{
		if(n < 0)
			return 1 / power(x,-n);
		else if(n == 0)
			return 1;

		return power(x,n);
	}

	private double power(double x, int n)
	{
		if(n == 0)
			return 1;

		double v = power(x, n / 2);

		if(n % 2 != 0)
			return v * v * x;
		else
			return v * v;
	}
}