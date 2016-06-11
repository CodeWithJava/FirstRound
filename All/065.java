public class Solution
{
	public boolean isNumber(String s)
	{
		if(s == null || s.length() == 0)
			return false;

		int i = 0;
		int l = s.length();

		while(i < l && Character.isWhitespace(s.charAt(i))) i++;

		boolean isNumeric = false;

		if(i < l && (s.charAt(i) == '+' || s.charAt(i) == '-'))	i++;

		while(i < l && Character.isDigit(s.charAt(i)))
		{
			isNumeric = true;
			i++;
		}

		if(i < l && s.charAt(i) == '.')	i++;

		while(i < l && Character.isDigit(s.charAt(i)))
		{
			isNumeric = true;
			i++;
		}

		if(isNumeric && i < l && s.charAt(i) == 'e')
		{
			isNumeric = false;
			i++;

			if(i < l && (s.charAt(i) == '+' || s.charAt(i) == '-'))	i++;

			while(i < l && Character.isDigit(s.charAt(i)))
			{
				isNumeric = true;
				i++;
			}
		}

		while(i < l && Character.isWhitespace(s.charAt(i))) i++;

		return i == s.length() && isNumeric;
	}
}