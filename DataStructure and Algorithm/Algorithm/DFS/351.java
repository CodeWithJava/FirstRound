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