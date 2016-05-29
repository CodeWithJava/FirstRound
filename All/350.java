// Way One
public class Solution
{
	public int [] intersect(int [] nums1, int [] nums2)
	{
		if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
			return new int [0];

		Map<Integer,Integer> map = new HashMap<>();

		for(int x: nums1)
		{
			if(map.containsKey(x))
				map.put(x,map.get(x) + 1);
			else
				map.put(x,1);
		}

		List<Integer> list = new ArrayList<>();

		for(int x: nums2)
		{
			if(map.containsKey(x))
			{
				if(map.get(x) > 1)
					map.put(x, map.get(x) - 1);
				else
					map.remove(x);

				list.add(x);
			}
		}

		int [] result = new int [list.size()];
		int i = 0;

		for(int x: list)
			result[i++] = x;

		return result;
	}
}

// Way Two
// The arrays are sorted

public class Solution
{
	public int [] intersect(int [] nums1, int [] nums2)
	{
		if(nums1 == null || nums1.length == 0|| nums2 == null || nums2.length == 0)
			return new int [0];

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		List<Integer> list = new ArrayList<>();

		int p = 0;
		int q = 0;

		while(p < nums1.length && q < nums2.length)
		{
			if(nums1[p] < nums2[q])
				p++;
			else if(nums1[p] > nums2[q])
				q++;
			else
			{
				list.add(nums1[p]);
				p++;
				q++;
			}
		}

		int [] result = new int [list.size()];
		int i = 0;

		for(int x: list)
			result[i++] = x;

		return result;
	}
}