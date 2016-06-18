public class Solution
{
	private int r;
	private int c;
	private int [][] dp;

	public int longestIncreasingPath(int[][] matrix)
	{
		if(matrix == null || matrix.length == 0)
			return 0;

		r = matrix.length;
		c = matrix[0].length;

		dp = new int [r][c];

		int max = Integer.MIN_VALUE;

		for(int i = 0;i < r;i++)
			for(int j = 0;j < c;j++)
				max = Math.max(max,dfs(matrix,Integer.MIN_VALUE,0,i,j));
		return max;
	}

	private int dfs(int [][] matrix, int head,int length,int x,int y)
	{
		if(x < 0 || x > r - 1 || y < 0 || y > c - 1|| matrix[x][y] <= head)
			return length;

		if(dp[x][y] > 0)
			return dp[x][y] + length;

		int temp = matrix[x][y];
		matrix[x][y] = Integer.MIN_VALUE;

		int l1 = dfs(matrix,temp,length + 1,x - 1,y);
		int l2 = dfs(matrix,temp,length + 1,x + 1,y);
		int l3 = dfs(matrix,temp,length + 1,x,y - 1);
		int l4 = dfs(matrix,temp,length + 1,x,y + 1);

		matrix[x][y] = temp;

		dp[x][y] = Math.max(Math.max(l1,l2),Math.max(l3,l4)) - length;

		return dp[x][y] + length;
	}
}