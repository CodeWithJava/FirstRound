public class Solution
{
	public List<List<Integer>> permute(int [] nums)
	{
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());

		if(nums == null || nums.length == 0)
			return result;

		for(int i = 0;i < nums.length;i++)
		{
			List<List<Integer>> t = new ArrayList<>();

			for(List<Integer> x: result)
			{
				for(int j = 0;j <= x.size();j++)
				{
					x.add(j,nums[i]);
					t.add(new ArrayList<>(x));
					x.remove(j);
				}
			}

			result.clear();

			for(List<Integer> x: t)
				result.add(new ArrayList<>(x));
		}

		return result;
	}
}