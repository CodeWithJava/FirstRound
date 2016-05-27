public class Solution
{
	public int trap(int [] height)
	{
		if(height == null || height.length < 3)
			return 0;

		int [] l = new int [height.length];
		l[0] = height[0];
		int max = height[0];

		for(int i = 1;i < height.length;i++)
		{
			if(height[i] < max)
				l[i] = max;
			else
			{
				l[i] = height[i];
				max = height[i];
			}
		}

		int [] r = new int [height.length];
		r[height.length - 1] = height[height.length - 1];
		max = height[height.length - 1];

		for(int i = height.length - 2;i >= 0;i--)
		{
			if(height[i] < max)
				r[i] = max;
			else
			{
				r[i] = height[i];
				max = height[i];
			}
		}

		int result = 0;

		for(int i = 0;i < height.length;i++)
			result += Math.min(l[i],r[i]) - height[i];

		return result;
	}
}