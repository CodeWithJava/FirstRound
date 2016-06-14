public class Solution
{
	public List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(numRows <= 0)
			return result;

		List<Integer> prev = new ArrayList<>();
		prev.add(1);

		result.add(prev);

		for(int i = 2;i <= numRows;i++)
		{
			List<Integer> curr = new ArrayList<>();
			curr.add(1);

			for(int j = 0;j < prev.size() - 1;j++)
				curr.add(prev.get(j) + prev.get(j + 1));

			curr.add(1);

			result.add(curr);

			prev = curr;
		}

		return result;
	}
}