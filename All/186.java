public class Solution
{
	public void reverseWords(char [] s)
	{
		if(s == null || s.length == 0)
			return;

		reverse(s,0,s.length);

		int i = 0;

		for(int j = 0;j <= s.length;j++)
		{
			if(j == s.length || s[j] == ' ')
			{
				reverse(s,i,j);
				i = j + 1;
			}
		}
	}

	private void reverse(char [] s, int l, int r)
	{
		for(int i = 0;i < (r - l) / 2;i++)
		{
			char t = s[l + i];
			s[l + i] = s[r - 1 - i];
			s[r - 1 - i] = t;
		}
	}
}