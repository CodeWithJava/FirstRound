public class Solution
{
	Map<String,Queue<String>> map = new HashMap<>();
	List<String> result = new ArrayList<>();

	public List<String> findItinerary(String [][] tickets)
	{
		if(tickets == null || tickets.length == 0)
			return result;

		for(String [] ticket: tickets)
		{
			if(!map.containsKey(ticket[0]))
			{
				Queue<String> q = new PriorityQueue<>();
				map.put(ticket[0],q);
			}

			map.get(ticket[0]).offer(ticket[1]);
		}

		findItinerary("JFK");

		return result;
	}

	private void findItinerary(String s)
	{
		Queue<String> q = map.get(s);

		while(q != null && !q.isEmpty())
			findItinerary(q.poll());

		result.add(0,s);
	}
}