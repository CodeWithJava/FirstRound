public class Solution
{
	public int jump(int [] nums)
	{
		if(nums == null || nums.length < 2)
			return 0;

		int lastPosition = 0;
		int position = 0;
		int step = 0;

		for(int i = 0;i <= position && i < nums.length;i++)
		{
			if(i > lastPosition)
			{
				step++;
				lastPosition = position;
			}

			position = Math.max(position,i + nums[i]);
		}

		// Handle the situation that cannot jump to the end
		if(position < nums.length - 1)
			return -1;

		return step;
	}
}