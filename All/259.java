public class Solution
{
	public int threeSumSmaller (int [] nums,int target)
	{
		if(nums == null || nums.length < 3)
			return 0;

		int result = 0;
		Arrays.sort(nums);

		for(int i = 0;i < nums.length - 2;i++)
		{
			int j = i + 1;
			int k = nums.length - 1;

			while(j < k)
			{
				int sum = nums[i] + nums[j] + nums[k];

				if(sum < target)
					result += k - j++;
				else
					k--;
			}
		}

		return result;
	}
}