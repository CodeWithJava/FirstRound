public class Solution
{
	public List<Integer> getRow(int rowIndex)
	{
		List<Integer> prev = new ArrayList<>();
		prev.add(1);

		for(int i = 1;i <= rowIndex;i++)
		{
			List<Integer> curr = new ArrayList<>();
			curr.add(1);

			for(int j = 0;j < prev.size() - 1;j++)
				curr.add(prev.get(j) + prev.get(j + 1));

			curr.add(1);

			prev = curr;
			curr = new ArrayList<>();
		}

		return prev;
	}
}