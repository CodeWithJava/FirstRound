public class Solution
{
	public int calculate(String s)
	{
		if(s == null || s.length() == 0)
			throw new IllegalArgumentException("Input is invalid");

		int prev = 0;
		int curr = 0;
		int sign = 1;
		int digit = 0;
		char operator = '+';

		for(int i = 0;i < s.length();i++)
		{
			char x = s.charAt(i);

			if(Character.isDigit(x))
			{
				digit = digit * 10 + (x - '0');

				if(i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1)))
				{
					switch(operator)
					{
						case '+': curr = digit;
							break;
						case '-': curr = digit;
							break;
						case '*': curr *= digit;
							break;
						case '/': curr /= digit;
							break;
					}
				}
			}
			else if(x == '+' || x == '-' || x == '*' || x == '/')
			{
				operator = x;
				digit = 0;

				if(x == '+' || x == '-')
				{
					prev += sign * curr;
					sign = x == '+' ? 1:-1;
				}
			}
		}

		return prev + sign * curr;
	}
}