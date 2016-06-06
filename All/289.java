public class Solution
{
	public void gameOfLife(int [][] board)
	{
		if(board == null || board.length == 0)
			return;

		int r = board.length;
		int c = board[0].length;

		for(int i = 0;i < r;i++)
		{
			for(int j = 0;j < c;j++)
			{
				int lives = 0;

				if(i > 0)
					lives += board[i - 1][j] == 1 || board[i - 1][j] == 2 ? 1:0;

				if(j > 0)
					lives += board[i][j - 1] == 1 || board[i][j - 1] == 2 ? 1:0;

				if(i < r - 1)
					lives += board[i + 1][j] == 1 || board[i + 1][j] == 2 ? 1:0;

				if(j < c - 1)
					lives += board[i][j + 1] == 1 || board[i][j + 1] == 2 ? 1:0;

				if(i > 0 && j > 0)
					lives += board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2 ? 1:0;

				if(i < r - 1 && j < c - 1)
					lives += board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2 ? 1:0;

				if(i > 0 && j < c - 1)
					lives += board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2 ? 1:0;

				if(i < r - 1 && j > 0)
					lives += board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2 ? 1:0;

				if(board[i][j] == 0 && lives == 3)
					board[i][j] = 3;
				else if(board[i][j] == 1)
				{
					if(lives < 2 || lives > 3)
						board[i][j] = 2;
				}
			}
		}

		for(int i = 0;i < r;i++)
			for(int j = 0;j < c;j++)
				board[i][j] = board[i][j] % 2;
	}
}