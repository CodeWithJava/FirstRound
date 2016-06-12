public class Solution
{
	public boolean exist(char [][] board, String word)
	{
		if(board == null || board.length == 0)
			return false;

		boolean result = false;

		for(int i = 0;i < board.length;i++)
		{
			for(int j = 0;j < board[0].length;j++)
			{
				if(exist(board,word,i,j,0))
					result = true;
			}
		}

		return result;
	}

	private boolean exist(char [][] board, String word, int i, int j, int k)
	{
		if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || k >= word.length())
			return false;

		if(board[i][j] == word.charAt(k))
		{
			char temp = board[i][j];
			board[i][j] = '*';

			if(k == word.length() - 1)
				return true;
			else if(exist(board,word,i - 1,j,k + 1) || exist(board,word,i + 1,j,k + 1) || exist(board,word,i,j - 1,k + 1) || exist(board,word,i,j + 1,k + 1))
				return true;

			board[i][j] = temp;
		}

		return false;
	}
}