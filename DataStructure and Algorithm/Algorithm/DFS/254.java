public class Solution
{
	public List<List<Integer>> getFactors(int n)
	{
		List<List<Integer>> result = new ArrayList<>();

		getFactors(result,new ArrayList<Integer>(),n,2);

		return result;
	}

	private void getFactors(List<List<Integer>> result, List<Integer> t, int n, int start)
	{
		if(n == 1)
		{
			if(t.size() > 1)
				result.add(new ArrayList<>(t));
		}
		else
		{
			for(int i = start;i <= n;i++)
			{
				if(n % i == 0)
				{
					t.add(i);
					getFactors(result,t,n / i,i);
					t.remove(t.size() - 1);
				}
			}
		}
	}
}