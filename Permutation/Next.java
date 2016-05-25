
public class Next
{
	public static void nextPermutation(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return;

		int p = 0;
		for(int i = nums.length - 1;i > 0;i--)
		{
			if(nums[i] > nums[i-1])
			{
				p = i - 1;
				break;
			}
		}

		int q = 0;
		for(int i = nums.length - 1;i > 0;i--)
		{
			if(nums[i] > nums[p])
			{
				q = i;
				break;
			}
		}

		if(p == 0 && q == 0)
		{
			Reverse.reverse(nums,0,nums.length - 1);
			return;
		}

		Swap.swap(nums, p, q);

		if(p < nums.length - 1)
			Reverse.reverse(nums, p + 1, nums.length - 1);
	}
}
