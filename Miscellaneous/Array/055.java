public class Solution
{
	public boolean canJump(int [] nums)
	{
		if(nums == null || nums.length < 2)
			return true;

		int max = nums[0];

		for(int i = 0;i < nums.length;i++)
		{
			if(max <= i && nums[i] == 0)
				return false;

			if(i + nums[i] > max)
				max = i + nums[i];

			if(max >= nums.length - 1)
				return true;
		}

		return false;
	}
}