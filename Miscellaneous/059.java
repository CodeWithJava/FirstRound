public class Solution
{
	public int [][] generateMatrix(int n)
	{
		if(n <= 0)
			return new int [0][0];

		int [][] matrix = new int [n][n];

		int r = n;
		int c = n;

		int x = 0;
		int y = 0;

		int k = 1;

		while(r > 0 && c > 0)
		{
			if(r == 1 && c == 1)
			{
				matrix[x][y] = n * n;
				break;
			}

			for(int i = 0;i < c - 1;i++)
				matrix[x][y++] = k++;

			for(int i = 0;i < r - 1;i++)
				matrix[x++][y] = k++;

			for(int i = 0;i < c - 1;i++)
				matrix[x][y--] = k++;

			for(int i = 0;i < r - 1;i++)
				matrix[x--][y] = k++;

			x++;
			y++;

			r -= 2;
			c -= 2;
		}

		return matrix;
	}
}