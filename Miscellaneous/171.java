public class Solution
{
	public int titleToNumber(String s)
	{
		if(s == null || s.length() == 0)
			return 0;

		int i = s.length() - 1;
		int t = 0;
		int result = 0;

		while(i >= 0)
		{
			result += (int)Math.pow(26,t) * (s.charAt(i) - 'A' + 1);
			i--;
			t++;
		}

		return result;
	}
}