public class Solution
{
	public List<String> generateParenthesis(int n)
	{
		List<String> result = new ArrayList<>();

		if(n <= 0)
			return result;

		generateParenthesis("",n,n,result);

		return result;
	}

	private void generateParenthesis(String s, int l, int r, List<String> result)
	{
		if(l > r)
			return;

		if(l == 0 && r == 0)
			result.add(s);
		else
		{
			if(l > 0)
				generateParenthesis(s + "(",l - 1,r,result);

			if(r > 0)
				generateParenthesis(s + ")",l,r - 1,result);
		}
	}
}