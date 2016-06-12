public class Solution
{
	public int removeDuplicates(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int curr = 2;
		int prev = 1;

		while(curr < nums.length)
		{
			if(nums[curr] == nums[prev] && nums[curr] == nums[prev - 1])
				curr++;
			else
				nums[++prev] = nums[curr++];
		}

		return ++prev;
	}
}