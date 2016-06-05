public class Solution
{
	int [][] numReach;
	int [][] distance;

	public int shortestDistance(int [][] grid)
	{
		if(grid == null || grid.length == 0)
			return 0;

		int r = grid.length;
		int c = grid[0].length;

		numReach = new int [r][c];
		distance = new int [r][c];

		int numBuilding = 0;

		for(int i = 0;i < r;i++)
		{
			for(int j = 0;j < c;j++)
			{
				if(grid[i][j] == 1)
				{
					boolean [][] visited = new boolean [r][c];
					Queue<Integer> q = new LinkedList<>();

					shortestDistance(grid,i,j,i,j,0,visited,q);

					numBuilding++;
				}
			}
		}

		int result = Integer.MAX_VALUE;

		for(int i = 0;i < r;i++)
		{
			for(int j = 0;j < c;j++)
			{
				if(grid[i][j] == 0 && numReach[i][j] == numBuilding)
					result = Math.min(result, distance[i][j]);
			}
		}

		return result == Integer.MAX_VALUE ? -1:result;
	}

	private void shortestDistance(int [][] grid, int x, int y, int i, int j, int curDistance, boolean [][] visited, Queue<Integer> q)
	{
		traversal(grid,i,j,i,j,curDistance,visited,q);

		int c = grid[0].length;

		while(!q.isEmpty())
		{
			int size = q.size();

			curDistance++;

			for(int k = 0;k < size;k++)
			{
				int n = q.poll();

				i = n / c;
				j = n % c;

				traversal(grid,x,y,i - 1,j,curDistance,visited,q);
				traversal(grid,x,y,i + 1,j,curDistance,visited,q);
				traversal(grid,x,y,i,j - 1,curDistance,visited,q);
				traversal(grid,x,y,i,j + 1,curDistance,visited,q);
			}
		}
	}

	private void traversal(int [][] grid, int x, int y, int i, int j, int curDistance, boolean [][] visited, Queue<Integer> q)
	{
		int r = grid.length;
		int c = grid[0].length;

		if(i < 0 || i > r - 1 || j < 0 || j > c - 1 || visited[i][j])
			return;

		if((i != x || j != y) && grid[i][j] != 0)
			return;

		visited[i][j] = true;
		numReach[i][j]++;
		distance[i][j] += curDistance;
		q.offer(i * c + j);
	}
}