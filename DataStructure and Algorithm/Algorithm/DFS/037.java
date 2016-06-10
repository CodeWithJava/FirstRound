public class Solution
{
	public void solveSudoku(char [][] board)
	{
		if(board == null || board.length != 9 || board[0].length != 9)
			return;

		solve(board);
	}

	private boolean solve(char [][] board)
	{
		for(int i = 0;i < board.length;i++)
		{
			for(int j = 0;j < board[0].length;j++)
			{
				if(board[i][j] == '.')
				{
					for(char x = '1';x <= '9';x++)
					{
						if(isValid(board,i,j,x))
						{
							board[i][j] = x;

							if(solve(board))
								return true;
							else
								board[i][j] = '.';
						}
					}

					return false;
				}
			}
		}

		return true;
	}

	private boolean isValid(char [][] board, int i, int j, char x)
	{
		for(int r = 0;r < 9;r++)
			if(board[r][j] == x)
				return false;

		for(int c = 0;c < 9;c++)
			if(board[i][c] == x)
				return false;

		for(int r = i / 3 * 3;r < i / 3 * 3 + 3;r++)
		{
			for(int c = j / 3 * 3;c < j / 3 * 3 + 3;c++)
				if(board[r][c] == x)
					return false;
		}

		return true;
	}
}