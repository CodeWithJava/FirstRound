public class Solution
{
	public String reverseWords(String s)
	{
		if(s == null || s.length() == 0)
			return "";

		StringBuilder sb = new StringBuilder();
		int j = s.length();

		for(int i = s.length() - 1;i >= 0;i--)
		{
			if(s.charAt(i) == ' ')
				j = i;
			else if(i == 0 || s.charAt(i - 1) == ' ')
			{
				if(sb.length() != 0)
					sb.append(' ');

				sb.append(s.substring(i,j));
			}
		}

		return sb.toString();
	}
}