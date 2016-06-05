public class Solution
{
	public List<Integer> numIslands2(int m, int n, int [][] positions)
	{
		List<Integer> result = new ArrayList<>();

		if(m <= 0 || n <= 0 || positions == null || positions.length == 0)
			return result;

		int [] rootArray = new int [m * n];
		Arrays.fill(rootArray,-1);

		int [][] directions = {{-1,0},{0,1},{1,0},{0,-1}};

		int count = 0;

		for(int k = 0;k < positions.length;k++)
		{
			count++;

			int [] p = positions[k];
			int index = p[0] * n + p[1];
			rootArray[index] = index;

			for(int r = 0;r < 4;r++)
			{
				int i = p[0] + directions[r][0];
				int j = p[1] + directions[r][1];

				if(i >= 0 && j >= 0 && i <= m - 1 && j <= n - 1 && rootArray[i *n + j] != -1)
				{
					int thisRoot = getRoot(rootArray,i * n + j);
					if(thisRoot != index)
					{
						rootArray[thisRoot] = index;
						count--;
					}
				}
			}

			result.add(count);
		}

		return result;
	}

	private int getRoot(int [] array, int i)
	{
		while(i != array[i])
			i = array[array[i]];

		return i;
	}
}