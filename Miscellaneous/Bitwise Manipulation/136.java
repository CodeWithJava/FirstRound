public class Solution
{
	public int singleNumber(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int x = 0;

		for(int num: nums)
			x ^= num;

		return x;
	}
}