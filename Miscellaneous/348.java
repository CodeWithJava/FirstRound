public class TicTacToe
{
	char [][] board;
	boolean done;

	/** Initialize your data structure here. */
	TicTacToe(int n)
	{
		board = new char [n][n];
	}

	/** Player {player} makes a move at ({row},{col}).
	    @param row The row of the board.
	    @param col The column of the board.
	    @param player The player, can be either 1 or 2.
	    @return The current winning condition, can be either:
	    	    0: No one wins.
		    1: Player 1 wins.
		    2: Player 1 wins. */

	public int move(int row, int col, int player)
	{
		if(done)
			return -1;

		if(board[row][col] != 'X' && board[row][col] != 'O')
		{
			if(player == 1)
				board[row][col] = 'X';
			else
				board[row][col] = 'O';
		}

		int n = board.length;

		int countX = 0;
		int countO = 0;

		for(int j = 0;j < n;j++)
		{
			if(board[row][j] == 'X')
				countX++;
			else if(board[row][j] == 'O')
				countO++;
		}

		if(countX == n || countO == n)
		{
			done = true;
			return player;
		}

		countX = 0;
		countO = 0;

		for(int i = 0;i < n;i++)
		{
			if(board[i][col] == 'X')
				countX++;
			else if(board[i][col] == 'O')
				countO++;
		}

		if(countX == n || countO == n)
		{
			done = true;
			return player;
		}

		if(row == col || row == n - 1 - col)
		{
			countX = 0;
			countO = 0;

			for(int i = 0;i < n;i++)
			{
				if(board[i][i] == 'X')
					countX++;
				else if(board[i][i] == 'O')
					countO++;
			}

			if(countX == n || countO == n)
			{
				done = true;
				return player;
			}

			countX = 0;
			countO = 0;

			for(int i = 0;i < n;i++)
			{
				if(board[i][n - 1 - i] == 'X')
					countX++;
				else if(board[i][n - 1 - i] == 'O')
					countO++;
			}

			if(countX == n || countO == n)
			{
				done = true;
				return player;
			}
		}

		return 0;
	}
}