public class Solution
{
	public List<List<Integer>> subsets(int [] nums)
	{
		List<List<Integer>> result = new ArrayList<>():

		if(nums == null || nums.length == 0)
			return result;

		Arrays.sort(nums);

		for(int i = 0;i < nums.length;i++)
		{
			List<List<Integer>> t = new ArrayList<>();

			for(List<Integer> x: result)
				t.add(new ArrayList<>(x));

			for(List<Integer> x: t)
				x.add(nums[i]);

			List<Integer> itself = new ArrayList<>();
			itself.add(nums[i]);

			t.add(new ArrayList<>(itself));

			result.addAll(t);
		}

		result.add(new ArrayList<>());

		return result;
	}
}