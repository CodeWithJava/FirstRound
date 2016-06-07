// Way One
// Time Complexity O(n)
// Space Complexity O(n)
public class Solution
{
	public List<Integer> majorityElement(int [] nums)
	{
		List<Integer> result = new ArrayList<>();

		if(nums == null || nums.length == 0)
			return result;

		Map<Integer,Integer> map = new HashMap<>();

		for(int x: nums)
		{
			if(map.containsKey(x))
				map.put(x,map.get(x) + 1);
			else
				map.put(x,1);
		}

		for(Map.Entry<Integer,Integer> entry: map.entrySet())
		{
			if(entry.getValue() > nums.length / 3)
				result.add(entry.getKey());
		}

		return result;
	}
}

// Way Two
// Time Complexity O(n)
// Space Complexity O(1)
public class Solution
{
	public List<Integer> majorityElement(int [] nums)
	{
		List<Integer> result = new ArrayList<>();

		if(nums == null || nums.length == 0)
			return result;

		Integer n1 = null;
		Integer n2 = null;

		int c1 = 0;
		int c2 = 0;

		for(int x: nums)
		{
			if(n1 != null && x == n1.intValue())
				c1++;
			else if(n2 != null && x == n2.intValue())
				c2++;
			else if(c1 == 0)
			{
				c1 = 1;
				n1 = x;
			}
			else if(c2 == 0)
			{
				c2 = 1;
				n2 = x;
			}
			else
			{
				c1--;
				c2--;
			}
		}

		c1 = 0;
		c2 = 0;

		for(int x: nums)
		{
			if(x == n1.intValue())
				c1++;
			else if(x == n2.intValue())
				c2++;
		}

		if(c1 > nums.length / 3)
			result.add(n1);

		if(c2 > nums.length / 3)
			result.add(n2);

		return result;
	}
}