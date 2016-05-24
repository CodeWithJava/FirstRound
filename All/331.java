//   There are two ways to implement the method
// Must realisze the truth of the ways

// Way One 
public class Solution
{
	public boolean isValidSerialization(String preorder)
	{
		if(preorder == null || preorder.length() == 0)
			return false;

		Stack<String> stack = new Stack<>();

		for(String x: preorder.split(","))
		{
			if(x.equals("#"))
			{
				while(!stack.isEmpty() && stack.peek().equals("#"))
				{
					stack.pop();

					if(stack.isEmpty())
						return false;

					stack.pop();
				}
				stack.push(x);
			}
			else
				stack.push(x);
		}

		return stack.size() == 1 && stack.peek().equals("#");
	}
}

// Way Two
public class Solution
{
	public boolean isValidSerialization(String preorder)
	{
		if(preorder == null || preorder.length() == 0)
			return false;

		int difference = 1;

		for(String x: preorder.split(","))
		{
			if(--difference < 0)
				return false;
			if(!x.equals( "#"))
				difference += 2;
		}

		return difference == 0;
	}
}