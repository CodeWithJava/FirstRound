public class Solution
{
	public int lengthOfLastWord(String s)
	{
		if(s == null || s.length() == 0)
			return 0;

		boolean flag = false;
		int result = 0;
		for(int i = s.length() - 1;i >= 0;i--)
		{
			char x = s.charAt(i);

			if(x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z')
			{
				result++;
				flag = true;
			}
			else
			{
				if(flag)
					return result;
			}
		}

		return result;
	}
}