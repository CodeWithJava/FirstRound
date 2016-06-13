public class Solution
{
	public int largestRectangleArea(int [] heights)
	{
		if(heights == null || heights.length == 0)
			return 0;

		Stack<Integer> stack = new Stack<>();

		int max = 0;
		int i = 0;

		while(i < heights.length)
		{
			if(stack.isEmpty() || heights[stack.peek()] <= heights[i])
				stack.push(i++);
			else
			{
				int x = stack.pop();
				max = Math.max(max,heights[x] * (stack.isEmpty() ? i:(i - stack.peek() - 1)));
			}
		}

		while(!stack.isEmpty())
		{
			int x = stack.pop();
			max = Math.max(max,heights[x] * (stack.isEmpty() ? i:(i - stack.peek() - 1)));
		}

		return max;
	}
}