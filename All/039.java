public class Solution
{
	public List<List<Integer>> combinationSum(int [] candidates, int target)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(candidates == null || candidates.length == 0)
			return result;

		Arrays.sort(candidates);
		List<Integer> temp = new ArrayList<>();

		combinationSum(candidates,0,target,temp,result);

		return result;
	}

	private void combinationSum(int [] candidates, int start, int target, List<Integer> temp, List<List<Integer>> result)
	{
		if(target == 0)
			result.add(new ArrayList<Integer>(temp));
		else
		{
			for(int i = start;i < candidates.length;i++)
			{
				if(target < candidates[i])
					return;
				temp.add(candidates[i]);
				combinationSum(candidates,i,target - candidates[i],temp,result);
				temp.remove(temp.size() - 1);
			}
		}
	}
}