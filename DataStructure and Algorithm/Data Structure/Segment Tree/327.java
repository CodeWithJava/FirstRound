// Way One
// Naive Solution
// Time Limit Exceeded
public class Solution
{
	public int countRangeSum(int [] nums, int lower, int upper)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int l = nums.length;

		long [] sums = new long [l + 1];
		for(int i = 0;i < l;i++)
			sums[i + 1] = sums[i] + nums[i];

		int result = 0;

		for(int i = 0;i < l;i++)
		{
			for(int j = i + 1;j <= l;j++)
			{
				int t = sums[j] - sums[i];

				if(t >= lower && t <= upper)
					result++;
			}
		}

		return result;
	}
}

// Way Two
// Merge Sort Solution

public class Solution
{
	public int countRangeSum(int [] nums, int lower, int upper)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int l = nums.length;

		long [] sums = new long [l + 1];
		for(int i = 0;i < l;i++)
			sums[i + 1] = sums[i] + nums[i];

		return countRangeSum(sums,0,l + 1,lower,upper);
	}

	private int countRangeSum(long [] sums, int l, int r, int lower, int upper)
	{
		if(r - l <= 1)
			return 0;

		int m = l + (r - l) / 2;

		int count = countRangeSum(sums,l,m,lower,upper) + countRangeSum(sums,m,r,lower,upper);

		int i = m;
		int j = m;
		int k = m;

		long [] t = new long [r - l];

		int p = l;
		int q = 0;
		for(;p < m;p++,q++)
		{
			while(j < r && sums[j] - sums[p] < lower) j++;
			while(i < r && sums[i] - sums[p] <= upper) i++;
			while(k < r && sums[k] < sums[p]) t[q++] = sums[k++];

			t[q] = sums[p];
			count += i - j;
		}

		System.arraycopy(t,0,sums,l,k - l);

		return count;
	}
}