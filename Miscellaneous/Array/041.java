public class Solution
{
	public int firstMissingPositive(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 1;

		int l = nums.length;

		for(int i = 0;i < l;i++)
		{
			while(nums[i] != i + 1)
			{
				if(nums[i] <= 0 || nums[i] >= l)
					break;

				if(nums[i] == nums[nums[i] - 1])
					break;

				int t = nums[i];
				nums[i] = nums[t - 1];
				nums[t - 1] = t;
			}
		}

		for(int i = 0;i < l;i++)
			if(nums[i] != i + 1)
				return ++i;

		return ++l;
	}
}