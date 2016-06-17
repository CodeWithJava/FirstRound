public class Solution
{
	public int missingNumber(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int result = 0;

		for(int i = 0;i < nums.length;i++)
			result += i + 1 - nums[i];

		return result;
	}
}