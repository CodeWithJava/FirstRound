public class Solution
{
	public List<Integer> countSmaller(int [] nums)
	{
		List<Integer> result = new ArrayList<>();

		if(nums == null || nums.length == 0)
			return result;

		int [] t = nums.clone();
		Arrays.sort(t);

		int [] bit = new int [nums.length + 1];

		for(int x: nums)
			add(bit,Arrays.binarySearch(t,x),1);

		for(int i = 0;i < nums.length;i++)
		{
			int index = Arrays.binarySearch(t,nums[i]);
			add(bit,index,-1);
			result.add(query(bit,index - 1));
		}

		return result;
	}

	private int query(int [] bit, int i)
	{
		int x = 0;
		i++;

		for(;i > 0;i -= i & -i)
			x += bit[i];

		return x; 
	}

	private void add(int [] bit, int i, int val)
	{
		i++;

		for(;i < bit.length;i += i & -i)
			bit[i] += val;
	}
}