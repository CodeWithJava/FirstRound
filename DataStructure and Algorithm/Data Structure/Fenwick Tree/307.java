// Fenwick Tree (Binary Index Tree)
public class NumArray
{
	int [] bit;
	int [] x;
	NumArray(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return;

		x = nums;
		bit = new int [nums.length + 1];

		for(int i = 0;i < nums.length;i++)
			updateDifference(i + 1, nums[i]);
	}

	public void update(int i, int val)
	{
		updateDifference(i + 1, val - x[i]);
		x[i] = val;
	}

	private void updateDifference(int i, int val)
	{
		while(i < bit.length)
		{
			bit[i] += val;
			i += lowBit(i);
		}
	}

	public int sumRange(int i, int j)
	{
		if(i < 0 || i > x.length - 1 || j < 0 || j > x.length - 1 || i > j)
			return 0;

		return sum(j + 1) - sum(i);
	}

	private int sum(int i)
	{
		int s = 0;

		while(i > 0)
		{
			s += bit[i];
			i -= lowBit(i);
		}

		return s;
	}

	private int lowBit(int i)
	{
		return i & (-i);
	}
}