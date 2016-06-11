// Way One
// Same Method Different Details
public class Solution
{
	public String addBinary(String a, String b)
	{
		if(a == null || a.length() == 0)
			return b;

		if(b == null || b.length() == 0)
			return a;

		int m = a.length();
		int n = b.length();

		int carry = 0;
		StringBuilder sb = new StringBuilder();

		while(m > 0 || n > 0)
		{
			int p = 0;

			if(m > 0)
				p = Character.getNumericValue(a.charAt(--m));

			int q = 0;

			if(n > 0)
				q = Character.getNumericValue(b.charAt(--n));

			int sum = carry + p + q;

			if(sum >= 2)
			{
				sb.insert(0,sum - 2);
				carry = 1;
			}
			else
			{
				sb.insert(0,sum);
				carry = 0;
			}
		}

		if(carry != 0)
			sb.insert(0,carry);

		return sb.toString();
	}
}

// Way Two
// Same Method Different Details
public class Solution
{
	public String addBinary(String a, String b)
	{
		if(a == null || a.length() == 0)
			return b;

		if(b == null || b.length() == 0)
			return a;

		int m = a.length() - 1;
		int n = b.length() - 1;

		int carry = 0;
		StringBuilder sb = new StringBuilder();

		while(m >= 0 || n >= 0)
		{
			int p = 0;

			if(m >= 0)
				p = a.charAt(m--) == '0' ? 0:1;

			int q = 0;

			if(n >= 0)
				q = b.charAt(n--) == '0' ? 0:1;

			int sum = carry + p + q;

			if(sum >= 2)
			{
				sb.insert(0,sum - 2);
				carry = 1;
			}
			else
			{
				sb.insert(0,sum);
				carry = 0;
			}
		}

		if(carry != 0)
			sb.insert(0,carry);

		return sb.toString();
	}
}