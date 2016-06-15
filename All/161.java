public class Solution
{
	public boolean isOneEditDistance(String s, String t)
	{
		if((s == null || s.length() == 0) && (t == null || t.length() == 0))
			return false;

		int x = s.length();
		int y = t.length();

		if(Math.abs(x - y) > 1)
			return false;

		String shorter = x < y ? s:t;
		String longer = x < y ? t:s;

		if(x == y)
		{
			int i = 0;
			int count = 0;

			while(i < x)
			{
				if(shorter.charAt(i) != longer.charAt(i))
				{
					count++;
					if(count > 1)
						return false;
				}

				i++;
			}

			return count == 1;
		}
		else
		{
			int i = 0;
			int j = 0;
			int count = 0;

			while(i < shorter.length())
			{
				if(shorter.charAt(i) != longer.charAt(j))
				{
					count++;
					if(count > 1)
						return false;

					j++;
				}
				else
				{
					i++;
					j++;
				}
			}

			return true;
		}
	}
}