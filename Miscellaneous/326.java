public class Solution
{
	public boolean isPowerOfThree(int n)
	{
		if(n < 1)
			return false;
		else if (n == 1)
			return true;
		else
			return Math.abs(Math.pow(3,Math.round(Math.log(n) / Math.log(3))) - n) < 0.01;
	}
}