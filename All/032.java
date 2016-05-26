// There are two ways to implement the method
// Must realisze the truth of the ways

//Way One 
public class Solution
{
	public int longestValidParentheses(String s)
	{
		if(s == null || s.length() < 2)
			return 0;

		int max = 0;

		Stack<Integer> stack = new Stack<>();

		for(int i = 0;i < s.length();i++)
		{
			char x = s.charAt(i);

			if(x == '(')
				stack.push(i);
			else
			{
				if(stack.isEmpty() || s.charAt(stack.peek()) == ')')
					stack.push(i);
				else
				{
					stack.pop();
					max = Math.max(max, stack.isEmpty() ? i + 1:i - stack.peek());
				}
			}
		}

		return max;
	}
}

//Way Two
public class Solution
{
	public int longestValidParentheses(String s)
	{
		if(s == null || s.length() < 2)
			return 0;

		int max = 0;
		int [] dp = new int [s.length()];

		for(int i = s.length() - 2;i >= 0;i--)
		{
			if(s.charAt(i) == '(')
			{
				int j = i + 1 + dp[i + 1];

				if(j < s.length() && s.charAt(j) == ')')
				{
					dp[i] = dp[i + 1] + 2;

					if(j + 1 < s.length())
						dp[i] += dp[j + 1];
				}

				if(dp[i] > max)
					max = dp[i];
			}
		}

		return max;
	}
}