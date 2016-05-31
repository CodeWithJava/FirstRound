public class Solution
{
	public int minPatches(int [] nums, int n)
	{
		long curSum = 1;
		int count = 0;
		int i = 0;

		while(curSum <= n)
		{
			if(i < nums.length && nums[i] <= curSum)
			{
				curSum += nums[i];
				i++;
			}
			else
			{
				curSum *= 2;
				count++;
			}
		}

		return count;
	}
}