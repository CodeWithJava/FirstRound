public class Solution
{
	public List<Integer> spiralOrder(int [][] matrix)
	{
		List<Integer> result = new ArrayList<>();

		if(matrix == null || matrix.length == 0)
			return result;

		int r = matrix.length;
		int c = matrix[0].length;

		int x = 0;
		int y = 0;

		while(r > 0 && c > 0)
		{
			if(r == 1)
			{
				for(int i = 0;i < c;i++)
					result.add(matrix[x][y++]);

				break;
			}
			else if(c == 1)
			{
				for(int i = 0;i < r;i++)
					result.add(matrix[x++][y]);

				break;
			}

			for(int i = 0;i < c - 1;i++)
				result.add(matrix[x][y++]);

			for(int i = 0;i < r - 1;i++)
				result.add(matrix[x++][y]);

			for(int i = 0;i < c - 1;i++)
				result.add(matrix[x][y--]);

			for(int i = 0;i < r - 1;i++)
				result.add(matrix[x--][y]);

			x++;
			y++;

			r -= 2;
			c -= 2;
		}

		return result;
	}
}