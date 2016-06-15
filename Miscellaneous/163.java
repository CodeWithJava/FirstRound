public class Solution
{
	public List<String> findMissingRanges(int [] nums,int lower,int upper)
	{
		List<String> result = new ArrayList<>();
		if(nums == null || nums.length == 0)
		{
			if(lower == upper)
				result.add(lower + "");
			else
				result.add(lower + "->" + upper);

			return result;
		}
		for(int i = 0;i <= nums.length;i++)
		{
			if(i == 0)
			{
				if(nums[i] - lower == 1)
					result.add(lower + "");
				else if (nums[i] - lower > 1)
					result.add(lower + "->" + (nums[i] - 1));
			}
			else if (i == nums.length)
			{
				if(upper - nums[i-1] == 1)
					result.add(upper + "");
				else if(upper - nums[i-1] > 1)
					result.add((nums[i-1] + 1) + "->" + upper);
			}
			else
			{
				if(nums[i] - nums[i-1] == 2)
					result.add((nums[i] - 1) + "");
				else if (nums[i] - nums[i-1] > 2)
					result.add((nums[i-1] + 1) + "->" + (nums[i] - 1));
			}
		}

		return result;
	}
}