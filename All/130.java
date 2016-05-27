// Depth First Search
public class Solution
{
	public void solve(char [][] board)
	{
		if(board == null || board.length == 0)
			return;

		int r = board.length;
		int c = board[0].length;

		for(int i = 0;i < r;i++)
		{
			if(board[i][0] == 'O')
				merge(board,i,0);
			if(board[i][c - 1] == 'O')
				merge(board,i,c - 1);
		}

		for(int i = 0;i < c;i++)
		{
			if(board[0][i] == 'O')
				merge(board,0,i);
			if(board[r - 1][i] == 'O')
				merge(board,r - 1,c);
		}

		for(int i = 0;i < r;i++)
		{
			for(int j = 0;j < c;j++)
			{
				if(board[i][j] == 'O')
					board[i][j] = 'X';
				else if(board[i][j] == '#')
					board[i][j] = 'O';
			}
		}
	}

	private void merge(char [][] board, int i, int j)
	{
		if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
			return;

		if(board[i][j] != 'O')
			return;

		board[i][j] = '#';

		merge(board,i - 1,j);
		merge(board,i + 1,j);
		merge(board,i,j - 1);
		merge(board,i,j + 1);
	}
}

// Breath First Search
public class Solution
{
	private Queue<Integer> q = new LinkedList<>();

	public void solve(char [][] board)
	{
		if(board == null || board.length == 0)
			return;

		int r = board.length;
		int c = board[0].length;

		for(int i = 0;i < r;i++)
		{
			if(board[i][0] == 'O')
				solve(board,i,0);
			if(board[i][c - 1] == 'O')
				solve(board,i,c - 1);
		}

		for(int i = 0;i < c;i++)
		{
			if(board[0][i] == 'O')
				solve(board,0,i);
			if(board[r - 1][i] == 'O')
				solve(board,r - 1,i);
		}

		for(int i = 0;i < r;i++)
		{
			for(int j = 0;j < c;j++)
			{
				if(board[i][j] == 'O')
					board[i][j] = 'X';
				else if(board[i][j] == '#')
					board[i][j] = 'O';
			}
		}
	}

	private void solve(char [][] board, int i, int j)
	{
		int c = board[0].length;

		fill(board,i,j);

		while(!q.isEmpty())
		{
			int cur = q.poll();
			int x = cur / c;
			int y = cur % c;

			fill(board,x - 1,y);
			fill(board,x + 1,y);
			fill(board,x,y - 1);
			fill(board,x,y + 1);
		}
	}

	private void fill(char [][] board, int i, int j)
	{
		int r = board.length;
		int c = board[0].length;

		if(i < 0 || i > r - 1 || j < 0 || j > c - 1 || board[i][j] != 'O')
			return;

		q.offer(i * c + j);
		board[i][j] = '#';
	}
}