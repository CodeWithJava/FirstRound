class Edge
{
	int x;
	int height;
	boolean isStart;

	Edge(int x, int height, boolean isStart)
	{
		this.x = x;
		this.height = height;
		this.isStart = isStart;
	}
}

class EdgeComparator implements Comparator<Edge>
{
	public int compare(Edge e1, Edge e2)
	{
		if(e1.x != e2.x)
			return Integer.compare(e1.x,e2.x);

		if(e1.isStart && e2.isStart)
			return Integer.compare(e2.height,e1.height);

		if(!e1.isStart && !e2.isStart)
			return Integer.compare(e1.height,e2.height);

		return e1.isStart ? -1:1;
	}
}
public class Solution
{
	public List<int []> getSkyline(int [][] buildings)
	{
		List<int []> result = new ArrayList<>();

		if(buildings == null || buildings.length == 0)
			return result;

		List<Edge> edges = new ArrayList<>();

		for(int [] building: buildings)
		{
			Edge startEdge = new Edge(building[0],building[2],true);
			edges.add(startEdge);
			Edge endEdge = new Edge(building[1],building[2],false);
			edges.add(endEdge);
		}

		Collections.sort(edges,new EdgeComparator());

		Queue<Integer> heightHeap = new PriorityQueue<>(10,Collections.reverseOrder());

		for(Edge edge: edges)
		{
			if(edge.isStart)
			{
				if(heightHeap.isEmpty() || edge.height > heightHeap.peek())
					result.add(new int [] {edge.x,edge.height});

				heightHeap.offer(edge.height);
			}
			else
			{
				heightHeap.remove(edge.height);

				if(heightHeap.isEmpty())
					result.add(new int [] {edge.x,0});
				else if(edge.height > heightHeap.peek())
					result.add(new int [] {edge.x,heightHeap.peek()});
			}
		}

		return result;
	}
}