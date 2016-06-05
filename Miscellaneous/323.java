public class Solution
{
	public int countComponents(int n, int [][] edges)
	{
		if(n < 0 || edges == null)
			return 0;

		int count = n;

		int [] root = new int [n];

		for(int i = 0;i < n;i++)
			root[i] = i;

		for(int i = 0;i < edges.length;i++)
		{
			int x = edges[i][0];
			int y = edges[i][1];

			int xRoot = getRoot(root,x);
			int yRoot = getRoot(root,y);

			if(xRoot != yRoot)
			{
				count--;
				root[xRoot] = yRoot;
			}
		}

		return count;
	}

	private int getRoot(int [] root, int i)
	{
		while(i != root[i])
			i = root[root[i]];

		return i;
	}
}