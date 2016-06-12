public class Solution
{
	public List<List<Integer>> combine(int n, int k)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(n <= 0 || k <= 0)
			return result;

		List<Integer> t = new ArrayList<>();

		combine(n,k,1,t,result);

		return result;
	}

	private void combine(int n, int k, int start, List<Integer> t, List<List<Integer>> result)
	{
		if(t.size() == k)
			result.add(new ArrayList<>(t));
		else
		{
			for(int i = start;i <= n;i++)
			{
				t.add(i);
				combine(n,k,i + 1,t,result);
				t.remove(t.size() - 1);
			}
		}
	}
}