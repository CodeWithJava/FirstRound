// Way One
public class Solution
{
	public int singleNumber(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int ones = 0;
		int twos = 0;
		int threes = 0;

		for(int i = 0;i < nums.length;i++)
		{
			twos |= ones & nums[i];
			ones ^= nums[i];
			threes = ones & twos;
			ones &= ~ threes;
			twos &= ~ threes;
		}

		return ones;
	}
}

// Way Two
public class Solution
{
	public int singleNumber(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int [] count = new int [32];
		int result = 0;

		for(int i = 0;i < 32;i++)
		{
			for(int j = 0;j < nums.length;j++)
			{
				if(((nums[j] >> i) & 1) == 1)
					count[i]++;
			}

			result |= ((count[i] % 3) << i);
		}

		return result;
	}
}