public class Solution
{
	public List<List<String>> solveNQueens(int n)
	{
		List<List<String>> result = new ArrayList<>();

		if(n <= 0)
			return result;

		int [] column = new int [n];

		solveNQueens(n,0,column,result);

		return result;
	}

	private void solveNQueens(int n, int row, int [] column, List<List<String>> result)
	{
		if(row == n)
		{
			List<String> t = new ArrayList<>();

			for(int i = 0;i < n;i++)
			{
				StringBuilder sb = new StringBuilder();

				for(int j = 0;j < n;j++)
				{
					if(column[i] == j)
						sb.append('Q');
					else
						sb.append('.');
				}

				t.add(sb.toString());
			}

			result.add(new ArrayList<String>(t));
		}
		else
		{
			for(int i = 0;i < n;i++)
			{
				column[row] = i;

				if(isValid(row,column))
					solveNQueens(n,row + 1,column,result);
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