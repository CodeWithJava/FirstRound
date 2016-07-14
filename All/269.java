public class Solution
{
	public String alienOrder(String [] words)
	{
		if(words == null || words.length == 0)
			return "";
		Map<Character,AlienChar> graph = new HashMap<>();

		boolean isBuildSucceed = buildGraph(words,graph);
		
		if(!isBuildSuceed)
			return "";

		String order = findOrder(graph);
		return order.length() == graph.size() ? order:"";
	}

	private boolean buildGraph(String [] words,Map<Character,AlienChar> graph)
	{
		Set<String> exist = new HashSet<>();
		initializeGraph(words,graph);
		for(int i = 0;i < words.length - 1;i++)
		{
			String p = words[i];
			String q = words[i+1];

			Character pre = null;
			Character next = null;

			for(int j = 0;j < p.length() && j < q.length();j++)
			{
				if(p.charAt(j) != q.charAt(j))
				{
					pre = p.charAt(j);
					next = q.charAt(j);
					break;
				}
			}

			if(pre != null && exist.contains(next + "" + pre))
				return false;
			if(pre != null && !exist.contains(pre + "" + next))
			{
				addEdge(pre,next,graph);
				exist.add(pre + "" + next);
			}
		}
		return true;
	}

	private void initializeGraph(String [] words,Map<Character,AlienChar> graph)
	{
		for(String word:words)
			for(int i = 0;i < word.length();i++)
				if(!graph.containsKey(word.charAt(i)))
					graph.put(word.charAt(i),new AlienChar(word.charAt(i)));
	}

	private void addEdge(char pre,char next,Map<Character,AlienChar> graph)
	{
		AlienChar preAlienChar = graph.get(pre);
		AlienChar nextAlienChar = graph.get(next);
		nextAlienChar.inDegree++;
		preAlienChar.nextVertexes.add(nextAlienChar);
		graph.put(pre,preAlienChar);
		graph.put(next,nextAlienChar);
	}

	private String findOrder(Map<Character,AlienChar> graph)
	{
		StringBuilder sb = new StringBuilder();
		Queue<AlienChar> q = new LinkedList<>();
		for(Character c: graph.keySet())
		{
			if(graph.get(c).inDegree == 0)
				q.offer(graph.get(c));
		}

		while(!q.isEmpty())
		{
			AlienChar cur = q.poll();
			sb.append(cur.val);
			for(AlienChar x: cur.nextVertexes)
			{
				if(--x.inDegree == 0)
					q.offer(x);
			}
		}
		return sb.toString();
	}
}
class AlienChar
{
	char val;
	List<AlienChar> nextVertexes;
	int inDegree;
	AlienChar(char c)
	{
		val = c;
		nextVertexes = new ArrayList<>();
		inDegree = 0;
	}
}