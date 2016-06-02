// Way One
// Dynamic Programming
public class NumArray
{
	int [] dp;

	NumArray(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return;

		dp = nums;

		for(int i = 1;i < dp.length;i++)
			dp[i] += dp[i -1];
	}

	public int sumRange(int i, int j)
	{
		if(i < 0 || i > dp.length - 1 || j < 0 || j > dp.length - 1 || i > j)
			return 0;

		return i == 0 ? dp[j]:dp[j] - dp[i - 1];
	}
}

// Way Two
// Fenwick Tree (Binary Index Tree)
public class NumArray
{
	int [] bit;

	NumArray(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return;

		bit = new int [nums.length + 1];

		for(int i = 0;i < nums.length;i++)
			update(i + 1, nums[i]);
	}

	public int sumRange(int i, int j)
	{
		if(i < 0 || i > bit.length - 1 || j < 0 || j > bit.length - 1 || i > j)
			return 0;

		return sum(j + 1) - sum(i);
	}

	private int sum(int i)
	{
		int x = 0;

		while(i > 0)
		{
			x += bit[i];
			i -= lowBit(i);
		}

		return x;
	}

	private void update(int i, int val)
	{
		while(i < bit.length)
		{
			bit[i] += val;
			i += lowBit(i);
		}
	}

	private int lowBit(int i)
	{
		return i & (-i);
	}
}