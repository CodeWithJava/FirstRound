// There are two direction for the permutation
// previous permutation and next permutation
// the leetcode problem is the next permutation
// another one is the previous permutation
public class Solution
{
	public void nextPermutation(int [] nums)
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
		for(int i = nums.length - 1;i > p;i--)
		{
			if(nums[i] > nums[p])
			{
				q = i;
				break;
			}
		}

		if(p == 0 && q == 0)
		{
			reverse(nums,0,nums.length - 1);
			return;
		}

		swap(nums,p,q);

		if(p < nums.length - 1)
			reverse(nums,p + 1,nums.length - 1);
	}

	private void swap(int [] nums, int i, int j)
	{
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	private void reverse(int [] nums, int i, int j)
	{
		while(i < j)
		{
			int t = nums[i];
			nums[i] = nums[j];
			nums[j] = t;
			i++;
			j--;
		}
	}
}

public class Solution
{
	public void previousPermutation(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return;

		int p = 0;
		for(int i = nums.length - 1;i > 0;i--)
		{
			if(nums[i-1] > nums[i])
			{
				p = i - 1;
				break;
			}
		}

		int q = 0;
		for(int i = nums.length - 1;i > p;i--)
		{
			if(nums[i] < nums[p])
			{
				q = i;
				break;
			}
		}

		if(p == 0 && q == 0)
		{
			reverse(nums,0,nums.length - 1);
			return;
		}

		swap(nums,p,q);

		if(p < nums.length - 1)
			reverse(nums,p + 1,nums.length - 1);
	}

	private void swap(int [] nums, int i, int j)
	{
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	private void reverse(int [] nums, int i, int j)
	{
		while(i < j)
		{
			int t = nums[i];
			nums[i] = nums[j];
			nums[j] = t;
			i++;
			j--;
		}
	}
}