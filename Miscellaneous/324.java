public class Solution
{
	public void wiggleSort(int[] nums)
	{
		if(nums == null || nums.length == 0 || nums.length == 1)
			return;

		Arrays.sort(nums);

		int [] temp = new int [nums.length];
		int middle = nums.length / 2;

		if(nums.length % 2 != 0)
			middle++;

		int low = middle - 1;
		int high = nums.length - 1;

		for(int i = 0;i < nums.length;i++)
		{
			if(i % 2 == 0)
			{
				temp[i] = nums[low];
				low--;
			}
			else
			{
				temp[i] = nums[high];
				high--;
			}
		}

		for(int i = 0;i < nums.length;i++)
			nums[i] = temp[i];
	}
}