public class Solution
{
	public int evalRPN(String [] tokens)
	{
		if(tokens == null || tokens.length == 0)
			return 0;

		Stack<String> stack = new Stack<>();
		String operators = "+-*/";

		for(int i = 0;i < tokens.length;i++)
		{
			if(!operators.contains(tokens[i]))
				stack.push(tokens[i]);
			else
			{
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				int index = operators.indexOf(tokens[i]);
				switch(index)
				{
					case 0:
						stack.push(String.valueOf(b+a));
						break;
					case 1:
						stack.push(String.valueOf(b-a));
						break;
					case 2:
						stack.push(String.valueOf(b*a));
						break;
					case 3:
						stack.push(String.valueOf(b/a));
						break;
				}
			}
		}

		return Integer.valueOf(stack.pop());
	}
}