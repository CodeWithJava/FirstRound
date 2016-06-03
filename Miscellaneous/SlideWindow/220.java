public class Solution
{
	public boolean containsNearbyAlmostDuplicate(int [] nums, int k, int t)
	{
		if(nums == null || nums.length < 2 || k < 0 || t < 0)
			return false;

		Set<Long> set = new TreeSet<>();

		for(int i = 0;i < nums.length;i++)
		{
			long cur = (long)nums[i];

			long leftBoundary = (long)cur - t;
			long rightBoundary = (long) cur + t + 1;

			Set<Long> sub = set.subSet(leftBoundary,rightBoundary);

			if(sub.size() > 0)
				return true;

			set.add(cur);

			if(i >= k)
				set.remove((long)nums[i - k]);
		}

		return false;
	}
}