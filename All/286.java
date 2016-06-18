public class Solution
{
	public void wallsAndGates(int [][] rooms)
	{
		if(rooms == null || rooms.length == 0)
			return;

		int r = rooms.length;
		int c = rooms[0].length;

		boolean [][] visited = new boolean [r][c];

		for(int i = 0;i < r;i++)
		{
			for(int j = 0;j < c;j++)
			{
				if(rooms[i][j] == 0)
					wallsAndGates(rooms,visited,i,j,0);
			}
		}
	}

	private void wallsAndGates(int [][] rooms,boolean [][] visited,int i,int j,int distance)
	{
		if(i < 0 || j < 0 || i > rooms.length-1 || j > rooms[0].length - 1)
			return;
		if(rooms[i][j] == -1)
			return;
		if(visited[i][j])
			return;
		if(distance > rooms[i][j])
			return;
		visited[i][j] = true;

		if(distance < rooms[i][j])
			rooms[i][j] = distance;

		wallsAndGates(rooms,visited,i-1,j,distance+1);
		wallsAndGates(rooms,visited,i+1,j,distance+1);
		wallsAndGates(rooms,visited,i,j-1,distance+1);
		wallsAndGates(rooms,visited,i,j+1,distance+1);

		visited[i][j] = false;
	}
}