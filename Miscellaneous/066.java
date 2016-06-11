public class Solution
{
	public int [] plusOne(int [] digits)
	{
		if(digits == null || digits.length == 0)
			return digits;

		digits[digits.length - 1]++;

		for(int i = digits.length - 1;i >= 0;i--)
		{
			int carry = digits[i] / 10;

			if(carry == 0)
				return digits;

			if(i - 1 >= 0)
				digits[i - 1] += carry;

			int digit = digits[i] % 10;
			digits[i] = digit;
		}

		int [] result = new int [digits.length + 1];
		result[0] = 1;

		return result;
	}
}