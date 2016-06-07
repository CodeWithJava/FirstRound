public class NumMatrix
{
	int r;
	int c;
	int [][] bit;
	int [][] t;

	NumMatrix(int [][] matrix)
	{
		if(matrix == null || matrix.length == 0)
			return;

		r = matrix.length;
		c = matrix[0].length;

		bit = new int [r + 1][c + 1];
		t = new int [r][c];

		for(int i = 0;i < r;i++)
			for(int j = 0;j < c;j++)
				update(i,j,matrix[i][j]);
	}

	public void update(int row, int col, int val)
	{
		int difference = val - t[row][col];
		t[row][col] = val;

		for(int i = row + 1;i <= r;i += i & -i)
			for(int j = col + 1;j <= c;j += j & -j)
				bit[i][j] += difference;
	}

	public int sumRegion(int row1, int col1, int row2, int col2)
	{
		return sumRegion(row2,col2) + sumRegion(row1 - 1,col1 - 1) - sumRegion(row1 - 1,col2) - sumRegion(row2,col1 - 1);
	}

	private int sumRegion(int row, int col)
	{
		int x = 0;

		for(int i = row + 1;i > 0;i -= i & -i)
			for(int j = col + 1;j > 0;j -= j & -j)
				x += bit[i][j];

		return x;
	}
}