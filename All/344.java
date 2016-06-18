public class Solution
{
	public String reverseString(String s)
	{
		if(s == null || s.length() == 0)
			return "";

		StringBuilder sb = new StringBuilder();

		for(int i = s.length() - 1;i >= 0;i--)
			sb.append(s.charAt(i));

		return sb.toString();
	}
}