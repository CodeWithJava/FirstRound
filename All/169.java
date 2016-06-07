// Way One
// Time Complexity O(nlogn)
// Space Complexity O(1)
public class Solution
{
	public int majorityElement(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		Arrays.sort(nums);

		return nums[nums.length / 2];
	}
}

// Way Two
// Time Complexity O(n)
// Space Complexity O(1)
public class Solution
{
	public int majorityElement(int [] nums)
	{
		if(nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int result = 0;
		int count = 0;

		for(int i = 0;i < nums.length;i++)
		{
			if(count == 0)
			{
				result = nums[i];
				count = 1;
			}
			else if(result == nums[i])
				count++;
			else
				count--;
		}

		return result;
	}
}