public class Solution
{
	public void moveZeroes(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return;

		int i = 0;
		int j = 0;

		while(i < nums.length)
		{
			if(nums[i] != 0)
				nums[j++] = nums[i];

			i++;
		}

		while(j < nums.length)
			nums[j++] = 0;
	}
}