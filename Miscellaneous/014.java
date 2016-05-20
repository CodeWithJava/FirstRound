public class Solution
{
	public String longestCommonPrefix(String [] strs)
	{
		if(strs == null || strs.length == 0)
			return "";

		int min = Integer.MAX_VALUE;
		for(String str: strs)
			min = Math.min(min,str.length());

		if(min == 0)
			return "";

		for(int i = 0;i < min;i++)
		{
			char x = strs[0].charAt(i);
			for(int j = 1;j < strs.length;j++)
			{
				if(strs[j].charAt(i) != x)
					return strs[0].substring(0,i);
			}
		}

		return strs[0].substring(0,min);
	}
}