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
// Time Complexity O(nlogn)
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

// Way Three
// Segment Tree
class SegmentTreeNode
{
	SegmentTreeNode left;
	SegmentTreeNode right;
	int count;
	long min;
	long max;

	SegmentTreeNode(long min, long max)
	{
		this.min = min;
		this.max = max;
	}
}
public class Solution
{
	public int countRangeSum(int [] nums, int lower, int upper)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int result = 0;

		Set<Long> set = new HashSet<>();
		long sum = 0;

		for(int i = 0;i < nums.length;i++)
		{
			sum += (long)nums[i];
			set.add(sum);
		}

		Long [] sums = set.toArray(new Long [0]);

		Arrays.sort(sums);

		SegmentTreeNode root = buildSegmentTree(sums,0,sums.length - 1);

		for(int i = nums.length - 1;i >= 0;i--)
		{
			updateSegmentTree(root,sum);
			sum -= (long)nums[i];
			result += getCount(root,(long)lower + sum,(long)upper + sum);
		}

		return result;
	}

	private SegmentTreeNode buildSegmentTree(Long [] sums, int l, int r)
	{
		if(l > r)
			return null;

		SegmentTreeNode root = new SegmentTreeNode(sums[l],sums[r]);

		if(l == r)
			return root;

		int m = l + (r - l) / 2;

		root.left = buildSegmentTree(sums,l,m);
		root.right = buildSegmentTree(sums,m + 1,r);

		return root;
	}

	private void updateSegmentTree(SegmentTreeNode node, Long val)
	{
		if(node == null)
			return;
		else
		{
			if(val >= node.min && val <= node.max)
			{
				node.count++;
				updateSegmentTree(node.left,val);
				updateSegmentTree(node.right,val);
			}
		}
	}

	private int getCount(SegmentTreeNode node, long min, long max)
	{
		if(node == null)
			return 0;

		if(min > node.max || max < node.min)
			return 0;

		if(min <= node.min && max >= node.max)
			return node.count;

		return getCount(node.left,min,max) + getCount(node.right,min,max);
	}
}