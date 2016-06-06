public class Solution
{
	public int maximalRectangle(char [][] matrix)
	{
		if(matrix == null || matrix.length == 0)
			return 0;

		int r = matrix.length;
		int c = matrix[0].length;

		int [][] height = new int [r][c + 1];

		int result = 0;

		for(int i = 0;i < r;i++)
		{
			for(int j = 0;j < c;j++)
			{
				if(matrix[i][j] == '0')
					height[i][j] = 0;
				else
					height[i][j] = i == 0 ? 1:height[i - 1][j] + 1;
			}
		}

		for(int i = 0;i < r;i++)
		{
			int area = maxAreaInHistogram(height[i]);

			if(area > result)
				result = area;
		}

		return result;
	}

	private int maxAreaInHistogram(int [] height)
	{
		Stack<Integer> stack = new Stack<>();

		int i = 0;
		int max = 0;

		while(i < height.length)
		{
			if(stack.isEmpty() || height[stack.peek()] <= height[i])
				stack.push(i++);
			else
			{
				int t = stack.pop();
				max = Math.max(max,height[t] * (stack.isEmpty() ? i:i - stack.peek() - 1));
			}
		}

		return max;
	}
}