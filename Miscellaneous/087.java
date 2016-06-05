// Way One
public class Solution
{
	public boolean isScramble(String s1, String s2)
	{
		if(s1 == null && s2 == null || s1.length() == 0 && s2.length() == 0 || s1.equals(s2))
			return true;

		if(s1 == null || s2 == null || s1.length() != s2.length())
			return false;
 
 		int l = s1.length();

		char [] alphabet1 = s1.toCharArray();
		char [] alphabet2 = s2.toCharArray();

		Arrays.sort(alphabet1);
		Arrays.sort(alphabet2);

		if(! new String(alphabet1).equals(new String(alphabet2)))
			return false;

		for(int i = 1;i < l;i++)
		{
			String s11 = s1.substring(0,i);
			String s12 = s1.substring(i,l);
			String s21 = s2.substring(0,i);
			String s22 = s2.substring(i,l);
			String s23 = s2.substring(0,l - i);
			String s24 = s2.substring(l - i,l);

			if(isScramble(s11,s21) && isScramble(s12,s22))
				return true;

			if(isScramble(s11,s24) && isScramble(s12,s23))
				return true;
		}

		return false;
	}
}

// Way Two
public class Solution
{
	public boolean isScramble(String s1, String s2)
	{
		if(s1 == null && s2 == null || s1.length() == 0 && s2.length() == 0 || s1.equals(s2))
			return true;

		if(s1 == null || s2 == null || s1.length() != s2.length())
			return false;

		int l = s1.length();

		boolean [][][] result = new boolean [l][l][l + 1];

		for(int i = 0;i < l;i++)
			for(int j = 0;j < l;j++)
				result [i][j][1] = s1.charAt(i) == s2.charAt(j);

		for(int p = 2;p <= l;p++)
		{
			for(int i = 0;i < l - p + 1;i++)
			{
				for(int j = 0;j < l - p + 1;j++)
					for(int k = 1;k < p;k++)
						result[i][j][p] |= result[i][j][k] && result[i + k][j + k][p - k] || result[i][j + p - k][k] && result[i + k][j][p-k];
			}
		}

		return result[0][0][l];
	}
}