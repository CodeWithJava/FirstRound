public class Solution
{
	public void rotate(int [][] matrix)
	{
		if(matrix == null || matrix.length == 0)
			return;

		int n = matrix.length;

		int [][] t = new int [n][n];

		for(int i = 0;i < n;i++)
			for(int j = 0;j < n;j++)
				t[i][j] = matrix[i][j];

		for(int i = 0;i < n;i++)
			for(int j = 0;j < n;j++)
				matrix[j][i] = t[n - 1 - i][j];
	}
}