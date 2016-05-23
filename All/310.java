public class Solution // 34ms
{
	public List<Integer> findMinHeightTrees(int n, int [][] edges)
	{
		List<Integer> result = new ArrayList<>();

		if(n == 1)
		{
			result.add(0);
			return result;
		}

		List<List<Integer>> graph = new ArrayList<>(n);
		for(int i = 0;i < n;i++)
			graph.add(new ArrayList<>());

		int [] inDegree = new int [n];

		for(int [] edge: edges)
		{
			graph.get(edge[0]).add(edge[1]);
			inDegree[edge[0]]++;
			graph.get(edge[1]).add(edge[0]);
			inDegree[edge[1]]++;
		}

		Queue<Integer> q = new LinkedList<>();
		for(int i = 0;i < n;i++)
			if(inDegree[i] == 1)
				q.offer(i);

		while(n > 2)
		{
			int size = q.size();
			for(int i = 0;i < size;i++)
			{
				int x = q.poll();
				n--;
				for(int p: graph.get(x))
				{
					if(--inDegree[p])
						q.offer(p);
				}
			}
		}

		while(!q.isEmpty())
			result.add(q.poll());

		return result;
	}
}

public class Solution // 65ms
{
	public List<Integer> findMinHeightTrees(int n, int [][] edges)
	{
		if(n == 1)
			return Collections.singletonList(0);

		List<Set<Integer>> graph = new ArrayList<>();
		for(int i = 0;i < n;i++)
			graph.add(new HashSet<>());

		for(int [] edge: edges)
		{
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		List<Integer> leaves = new ArrayList<>();
		for(int i = 0;i < n;i++)
			if(graph.get(i).size() == 1)
				leaves.add(i);

		while(n > 2)
		{
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for(int p: leaves)
			{
				int q = graph.get(p).iterator().next();
				graph.get(q).remove(p);
				if(graph.get(q).size() == 1)
					newLeaves.add(q);
			}
			leaves = newLeaves;
		}

		return leaves;
	}
}

public class Solution // 58ms
{
	public List<Integer> findMinHeightTrees(int n, int [][] edges)
	{
		if(n == 1)
			return Collections.singletonList(0);

		List<Set<Integer>> graph = new ArrayList<>();
		for(int i = 0;i < n;i++)
			graph.add(new HashSet<>());

		for(int [] edge: edges)
		{
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		Queue<Integer> q = new LinkedList<>();
		for(int i = 0;i < n;i++)
			if(graph.get(i).size() == 1)
				q.offer(i);

		while(n > 2)
		{
			int size = q.size();
			n -= size;
			for(int i = 0;i < size;i++)
			{
				int x = q.poll();
				int y = graph.get(x).iterator().next();
				graph.get(y).remove(x);
				if(graph.get(y).size() == 1)
					q.offer(y); 
			}
		}

		List<Integer> result = new ArrayList<>();

		while(!q.isEmpty())
			result.add(q.poll());

		return result;
	}
}