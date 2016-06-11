public class Solution
{
	public int totalNQueens(int n)
	{
		int [] result = new int [1];

		if(n <= 0)
			return result[0];

		int [] column = new int [n];

		totalNQueens(n,0,column,result);

		return result[0];
	}

	private void totalNQueens(int n, int row, int [] column, int [] result)
	{
		if(row == n)
		{
			result[0]++;
		}
		else
		{
			for(int i = 0;i < n;i++)
			{
				column[row] = i;

				if(isValid(row,column))
					totalNQueens(n,row + 1,column,result);
			}
		}
	}

	private boolean isValid(int row, int [] column)
	{
		for(int i = 0;i < row;i++)
			if(column[row] == column[i] || Math.abs(column[row] - column[i]) == row - i)
				return false;

		return true;
	}
}