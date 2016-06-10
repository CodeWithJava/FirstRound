public class Solution
{
	public int [] searchRange(int [] nums, int target)
	{
		if(nums == null || nums.length == 0)
			return new int [] {-1,-1};

		int x = binarySearch(nums,0,nums.length - 1,target);

		if(x == -1)
			return new int [] {-1,-1};

		int l = 0;
		int r = 0;
		int t = x;

		while(t != -1)
		{
			l = t;
			t = binarySearch(nums,0,t - 1,target);
		}

		t = x;

		while(t != -1)
		{
			r = t;
			t = binarySearch(nums,t + 1,nums.length - 1,target);
		}

		return new int [] {l,r};
	}

	private int binarySearch(int [] nums, int l, int r, int target)
	{
		if(l > r || target < nums[l] || nums[r] < target)
			return -1;

		while(l <= r)
		{
			int m = l + (r - l) / 2;

			if(nums[m] == target)
				return m;
			else if(nums[m] < target)
				l = m + 1;
			else
				r = m - 1;
		}

		return -1;
	}
}