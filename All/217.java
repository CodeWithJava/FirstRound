// Time Limit Exceeded possible
public class Solution
{
	public boolean containsDuplicate(int [] nums)
	{
		if(nums == null || nums.length <= 1)
			return false;

		Set<Integer> set = new HashSet<>();
		for(int x: nums)
		{
			if(set.contains(x))
				return true;
			else
				set.add(x);
		}
		return false;
	}
}