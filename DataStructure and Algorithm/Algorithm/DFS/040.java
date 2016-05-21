public class Solution
{
	public List<List<Integer>> combinationSum2(int [] candidates, int target)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(candidates == null || candidates.length == 0)
			return result;

		Arrays.sort(candidates);

		List<Integer> temp = new ArrayList<>();

		Set<List<Integer>> set = new HashSet<>();

		combinationSum2(candidates,0,target,temp,set);

		for(List<Integer> x: set)
			result.add(new ArrayList<>(x));

		return result;
	}

	private void combinationSum2(int [] candidates, int start, int target, List<Integer> temp, Set<List<Integer>> set)
	{
		if(target == 0)
			set.add(new ArrayList<>(temp));
		else
		{
			for(int i = start;i < candidates.length;i++)
			{
				if(target < candidates[i])
					return;
				temp.add(candidates[i]);
				combinationSum2(candidates,i+1,target - candidates[i],temp,set);
				temp.remove(temp.size() - 1);
			}
		}
	}
}