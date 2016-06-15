public class Solution
{
	public void rotate(int [] nums, int k)
	{
		if(nums == null || nums.length == 0)
			return;

		k %= nums.length;

		if(k == 0)
			return;

		rotate(nums,0,nums.length - k - 1);
		rotate(nums,nums.length - k,nums.length - 1);
		rotate(nums,0,nums.length - 1;);
	}

	private void rotate(int [] nums, int l, int r)
	{
		if(l > r)
			return;

		while(l < r)
		{
			int t = nums[l];
			nums[l] = nums[r];
			nums[r] = t;

			l++;
			r--;
		}
	}
}

public class Solution
{
	public void rotate(int [] nums, int k)
	{
		if(nums == null || nums.length == 0)
			return;

		k %= nums.length;

		if(k == 0)
			return;

       		rotate(nums,0,nums.length - 1);
		rotate(nums,0,k - 1);
		rotate(nums,k,nums.length - 1);
	}

	private void rotate(int [] nums, int l, int r)
	{
		if(l > r)
			return;

		while(l < r)
		{
			int t = nums[l];
			nums[l] = nums[r];
			nums[r] = t;

			l++;
			r--;
		}
	}
}