public class Solution
{
	public int minTotalDistance(int [][] grid)
	{
		if(grid == null || grid.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		List<Integer> x = new ArrayList<>();
		List<Integer> y = new ArrayList<>();

		for(int i = 0;i < grid.length;i++)
		{
			for(int j = 0;j < grid[0].length;j++)
			{
				if(grid[i][j] == 1)
				{
					x.add(j);
					y.add(i);
				}
			}
		}

		return getMedianPoint(x) + getMedianPoint(y);
	}

	private int getMedianPoint(List<Integer> l)
	{
		Collections.sort(l);

		int result = 0;

		int i = 0;
		int j = l.size() - 1;

		while(i < j)
			result += l.get(j--) - l.get(i++);

		return result;
	}
}