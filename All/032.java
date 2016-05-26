public class Solution
{
	public int longestValidParentheses(String s)
	{
		if(s == null || s.length() == 0)
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