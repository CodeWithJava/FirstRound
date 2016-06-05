public class Solution
{
	public int maxSubArrayLen(int [] nums, int k)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int subSum = 0;
		int max = 0;

		Map<Integer,Integer> map = new HashMap<>();

		for(int i = 0;i < nums.length;i++)
		{
			subSum += nums[i];

			if(subSum == k)
				max = i + 1;
			else if(map.containsKey(subSum - k))
				max = Math.max(max,i - map.get(subSum - k));

			if(!map.containsKey(subSum))
				map.put(subSum,i);
		}

		return max;
	}
}