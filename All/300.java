// Way One
public class Solution
{
	public int lengthOfLIS(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int [] dp = new int [nums.length];

		for(int i = 0;i < nums.length;i++)
		{
			dp[i] = 1;
			for(int j = 0;j < i;j++)
			{
				if(nums[i] > nums[j])
					dp[i] = Math.max(dp[i],dp[j] + 1);
			}
		}

		int result = 0;

		for(int i = 0;i < nums.length;i++)
		{
			if(dp[i] > result)
				result = dp[i];
		}

		return result;
	}
}

// Way Two
public class Solution
{
	public int lengthOfLIS(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;

		List<Integer> list = new ArrayList<>();

		for(int num: nums)
		{
			if(list.size() == 0)
				list.add(num);
			else if(num > list.get(list.size() - 1))
				list.add(num);
			else
			{
				int l = 0;
				int r = list.size() - 1;

				while(l < r)
				{
					int m = l + (r - l) / 2;

					if(list.get(m) < num)
						l = m + 1;
					else
						r = m;
				}

				list.set(r,num);
			}
		}

		return list.size();
	}
}