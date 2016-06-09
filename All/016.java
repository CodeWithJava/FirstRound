public class Solution
{
	public int threeSumClosest(int [] nums, int target)
	{
		if(nums == null || nums.length < 3)
			throw new IllegalArgumentException("Input is invalid");

		Arrays.sort(nums);

		int result = 0;
		int delta = Integer.MAX_VALUE;

		for(int i = 0;i < nums.length - 2;i++)
		{
			int j = i + 1;
			int k = nums.length - 1;

			while(j < k)
			{
				int sum = nums[i] + nums[j] + nums[k];
				int difference = Math.abs(target - sum);

				if(difference == 0)
					return sum;

				if(difference < delta)
				{
					result = sum;
					delta = difference;
				}

				if(sum < target)
					j++;

				if(sum > target)
					k--;
			}
		}

		return result;
	}
}