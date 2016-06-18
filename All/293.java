public class Solution
{
	public List<String> generatePossibleNextMoves(String s)
	{
		List<String> result = new ArrayList<>();

		if(s == null || s.length() == 0)
			return result;

		for(int i = 0;i < s.length() - 1;i++)
		{
			if(s.charAt(i) == '+' && s.charAt(i+1) == '+')
				result.add(s.substring(0,i) + "--" + s.substring(i+2));
		}

		return result;
	}
}