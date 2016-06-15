public class Solution
{
	public List<List<Integer>> combinationSum3(int k,int n)
	{
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		combinationSum3(k,n,1,temp,result);
		return result;
	}

	private void combinationSum3(int k,int n,int start,List<Integer> temp,List<List<Integer>> result)
	{
		if(temp.size() == k && n == 0)
			result.add(new ArrayList<>(temp));
		else
		{
			for(int i = start;i <= 9;i++)
			{
				if(n < i)
					return;
				temp.add(i);
				combinationSum3(k,n-i,i+1,temp,result);
				temp.remove(temp.size() - 1);
			}
		}
	}
}