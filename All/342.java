// Way One
// Naive Loop Method
public class Solution
{
	public boolean isPowerOfFour(int num)
	{
		if(num < 0)
			return false;

		while(num > 0)
		{
			if(num == 1)
				return true;

			if(num % 4 != 0)
				return false;
			else
				num /= 4;
		}

		return false;
	}
}

// Way Two
// Bit Manipulation
public class Solution
{
	public boolean isPowerOfFour(int num)
	{
		if(num < 0)
			return false;

		int ones = 0;
		int zeros = 0;

		while(num > 0)
		{
			if((num & 1) == 1)
				ones++;
			else
				zeros++;

			num >>= 1;
		}

		return ones == 1 && (zeros % 2 == 0);
	}
}

// Way Three
// Math Equation
public class Solution
{
	public boolean isPowerOfFour(int num)
	{
		if(num <= 0)
			return false;

		int pow = (int)(Math.log(num) / Math.log(4));

		if(num == (int)Math.pow(4,pow))
			return true;
		else
			return false;
	}
}