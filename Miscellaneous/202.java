public class Solution
{
	public boolean isHappy(int n)
	{
		if(n <= 0)
			return false;

		Set<Integer> set = new HashSet<>();

		while(set.add(n))
		{
			n = sumSquare(getDigits(n));
			if(n == 1)
				return true;
		}

		return false;
	}

	private int sumSquare(int [] digits)
	{
		int sum = 0;
		for(int x: digits)
			sum += x*x;
		return sum;
	}

	private int [] getDigits(int n)
	{
		int [] digits = new int [32];
		for(int i = 0;i < digits.length;i++)
		{
			digits[i] = n % 10;
			n /= 10;
		}
		return digits;
	}
}