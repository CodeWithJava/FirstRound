public class Solution
{
	public boolean containsNearbyDuplicate(int [] nums,int k)
	{
		if(nums == null || nums.length == 0)
			return false;

		int min = Integer.MAX_VALUE;
		Map<Integer,Integer> map = new HashMap<>();

		for(int i = 0;i < nums.length;i++)
		{
			if(map.containsKey(nums[i]))
			{
				int preIndex = map.get(nums[i]);
				min = Math.min(min,i-preIndex);
			}
			map.put(nums[i],i);
		}
		if(min <= k)
			return true;
		else
			return false;
	}
}