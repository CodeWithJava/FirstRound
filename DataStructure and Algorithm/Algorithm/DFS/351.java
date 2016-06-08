// Way One
public class Solution
{
	int [][] jumps;
	boolean [] visited;

	public int numberOfPatterns(int m, int n)
	{
		jumps = new int [10][10];
		jumps[1][3] = jumps[3][1] = 2;
		jumps[4][6] = jumps[6][4] = 5;
		jumps[7][9] = jumps[9][7] = 8;
		jumps[1][7] = jumps[7][1] = 4;
		jumps[2][8] = jumps[8][2] = 5;
		jumps[3][9] = jumps[9][3] = 6;
		jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;

		visited = new boolean [10];

		int count = 0;

		count += numberOfPatterns(1,1,0,m,n) * 4;
		count += numberOfPatterns(2,1,0,m,n) * 4;
		count += numberOfPatterns(5,1,0,m,n);

		return count;
	}

	private int numberOfPatterns(int candidate, int length, int count, int m, int n)
	{
		if(length >= m)
			count++;

		length++;

		if(length > n)
			return count;

		visited[candidate] = true;

		for(int next = 1;next <= 9;next++)
		{
			int jump = jumps[candidate][next];

			if(!visited[next] && (jump == 0 || visited[jump]))
				count = numberOfPatterns(next,length,count,m,n);
		}

		visited[candidate] = false;

		return count;
	}
}

// Way Two
public class Solution
{
	public int numberOfPatterns(int m, int n)
	{
		int result = 0;

		boolean [][] visited = new boolean [3][3];

		for(int i = 0;i < 3;i++)
			for(int j = 0;j < 3;j++)
				result += numberOfPatterns(m,n,i,j,0,visited);

		return result;
	}

	private int numberOfPatterns(int m, int n, int x, int y, int current, boolean [][] visited)
	{
		visited[x][y] = true;

		current++;

		int count = 0;

		if(current >= m && current <= n)
			count++;

		if(current == n)
		{
			visited[x][y] = false;
			return count;
		}

		for(int i = 0;i < 3;i++)
		{
			for(int j = 0;j < 3;j++)
			{
				if(i == x && j == y)
					continue;

				if(visited[i][j])
					continue;

				int dx = i - x;
				int dy = j - y;

				if((Math.abs(dx) <= 1 && Math.abs(dy) <= 1) || (x != i && y != j && x - y != i - j && y - x != j - i && x + y != i + j) || visited[x + dx / 2][y + dy / 2])
					count += numberOfPatterns(m,n,i,j,current,visited);
			}
		}

		visited[x][y] = false;

		return count;
	}
}