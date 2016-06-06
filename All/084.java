public class Solution
{
	public int largestRectangleArea(int [] heights)
	{
		if(heights == null || heights.length == 0)
			return 0;

		Stack<Integer> stack = new Stack<>();

		int i = 0;
		int max = 0;

		while(i < heights.length)
		{
			if(stack.isEmpty() || heights[i] >= heights[stack.peek()])
				stack.push(i++);
			else
			{
				int t = stack.pop();
				max = Math.max(max, heights[t] * (stack.isEmpty() ? i:i - stack.peek() - 1));
			}
		}

		while(!stack.isEmpty())
		{
			int t = stack.pop();
			max = Math.max(max, heights[t] * (stack.isEmpty() ? i:i - stack.peek() - 1));
		}

		return max;
	}
}