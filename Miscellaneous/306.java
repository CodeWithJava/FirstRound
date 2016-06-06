// Way One Recursion Version
public class Solution
{
	public boolean isAdditiveNumber(String num)
	{
		if(num == null || num.length() < 3)
			return false;

		int l = num.length();

		for(int i = 1;i <= l / 2;i++)
		{
			if(num.charAt(0) == '0' && i > 1)
				return false;

			long x1 = Long.valueOf(num.substring(0,i));

			for(int j = 1;Math.max(i,j) <= l - i - j;j++)
			{
				if(num.charAt(i) == '0' && j > 1)
					break;

				long x2 = Long.valueOf(num.substring(i,i + j));

				if(isValid(x1,x2,i + j,num))
					return true;
			}
		}

		return false;
	}

	private boolean isValid(long x1, long x2, int start, String num)
	{
		if(start == num.length())
			return true;

		x2 = x2 + x1;
		x1 = x2 - x1;

		String sum = new Long(x2).toString();

		return num.startsWith(sum,start) && isValid(x1,x2,start + sum.length(),num);
	}
}

// Way Two Iterator Version
public class Solution
{
	public boolean isAdditiveNumber(String num)
	{
		if(num == null || num.length() == 0)
			return false;

		int l = num.length();

		for(int i = 1;i <= l / 2;i++)
		{
			for(int j = 1;Math.max(i,j) <= l - i - j;j++)
			{
				if(isValid(i,j,num))
					return true;
			}
		}

		return false;
	}

	private boolean isValid(int i, int j, String num)
	{
		if(num.charAt(0) == '0' && i > 1)
			return false;
		if(num.charAt(i) == '0' && j > 1)
			return false;

		String sum;

		long x1 = Long.valueOf(num.substring(0,i));
		long x2 = Long.valueOf(num.substring(i,i + j));

		for(int start = i + j;start != num.length();start += sum.length())
		{
			x2 = x2 + x1;
			x1 = x2 - x1;

			sum = new Long(x2).toString();

			if(!num.startsWith(sum,start))
				return false;
		}

		return true;
	}
}