public class Solution
{
	public List<String> removeInvalidParentheses(String s)
	{
		Set<String> set = new HashSet<>();

		int rmL = 0;
		int rmR = 0;

		for(int i = 0;i < s.length();i++)
		{
			char x = s.charAt(i);
			if(x == '(')
				rmL++;
			else if(x == ')')
			{
				if(rmL != 0)
					rmL--;
				else
					rmR++;
			}
		}

		remove(s,0,rmL,rmR,0,new StringBuilder(),set);
		return new ArrayList<String>(set);
	}

	private void remove(String s,int i,int rmL,int rmR,int open,StringBuilder sb,Set<String> set)
	{
		if(i == s.length() && rmL == 0 && rmR == 0 && open == 0)
		{
			set.add(sb.toString());
			return;
		}

		if(i == s.length() || rmL < 0 || rmR < 0 || open < 0)
			return;

		char x = s.charAt(i);
		int length = sb.length();

		if(x == '(')
		{
			remove(s,i+1,rmL-1,rmR,open,sb,set);
			remove(s,i+1,rmL,rmR,open+1,sb.append(x),set);
		}
		else if(x == ')')
		{
			remove(s,i+1,rmL,rmR-1,open,sb,set);
			remove(s,i+1,rmL,rmR,open-1,sb.append(x),set);
		}
		else
			remove(s,i+1,rmL,rmR,open,sb.append(x),set);
		sb.setLength(length);
	}
}