public class Solution
{
	public void sortColors(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return;

		int l = 0;
		int r = nums.length - 1;

		int i = 0;

		while(i <= r)
		{
			if(nums[i] == 0)
			{
				swap(nums,i,l);
				i++;
				l++;
			}
			else if(nums[i] == 1)
				i++;
			else if(nums[i] == 2)
			{
				swap(nums,i,r);
				r--;
			}
		}
	}

	private void swap(int [] nums, int i, int j)
	{
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}