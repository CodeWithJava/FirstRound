// Way One
public class Solution
{
	public void wiggleSort(int[] nums)
	{
		if(nums == null || nums.length == 0)
			return;

		for(int i = 1;i < nums.length;i++)
		{
			if(i % 2 == 1 && nums[i-1] > nums[i] || i % 2 == 0 && nums[i-1] < nums[i])
			{
				int temp = nums[i - 1];
				nums[i - 1] = nums[i];
				nums[i] = temp;
			}
		}
	}
}

// Way Two
public class Solution
{
	public void wiggleSort(int[] nums)
	{
		if(nums == null || nums.length == 0)
			return;

		Arrays.sort(nums);

		for(int i = 2;i < nums.length;i += 2)
		{
			int temp = nums[i-1];
			nums[i-1] = nums[i];
			nums[i] = temp;
		}
	}
}