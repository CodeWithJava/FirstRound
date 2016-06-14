public class Solution
{
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
	{
		if(node == null)
			return null;

		Queue<UndirectedGraphNode> q = new LinkedList<>();
		q.offer(node);

		Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
		UndirectedGraphNode source = new UndirectedGraphNode(node.label);
		map.put(node,source);

		while(!q.isEmpty())
		{
			UndirectedGraphNode x = q.poll();
			List<UndirectedGraphNode> neighbors = x.neighbors;

			for(UndirectedGraphNode neighbor: neighbors)
			{
				if(map.containsKey(neighbor))
					map.get(x).neighbors.add(map.get(neighbor));
				else
				{
					UndirectedGraphNode clone = new UndirectedGraphNode(neighbor.label);
					map.put(neighbor,clone);
					map.get(x).neighbors.add(clone);
					q.offer(neighbor);
				}
			}
		}

		return source;
	}
}