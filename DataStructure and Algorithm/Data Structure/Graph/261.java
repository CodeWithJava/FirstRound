public class Solution
{
	int [] father;

	public boolean validTree(int n, int[][] edges)
	{
		if(edges.length != n - 1)
			return false;

		father = new int [n];
		
		for(int i = 0;i < n;i++)
			father[i] = i;

		for(int i = 0;i < edges.length;i++)
		{
			if(find(edges[i][0]) == find(edges[i][1]))
				return false;
			union(edges[i][0],edges[i][1]);
		}

		return true;
	}
	
	private int find(int node)
	{
		if(father[node] == node)
			return node;

		father[node] = find(father[node]);

		return father[node];
	}
	
	private void union(int node1,int node2)
	{
		father[find(node1)] = find(node2);
	}
}