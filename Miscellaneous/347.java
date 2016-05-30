// Way One
class Pair
{
	int num;
	int count;

	Pair(int num, int count)
	{
		this.num = num;
		this.count = count;
	}
}
class PairComparator implements Comparator<Pair>
{
	public int compare(Pair p1, Pair p2)
	{
		return p1.count - p2.count;
	}
}
public class Solution
{
	public List<Integer> topKFrequent(int [] nums, int k)
	{
		if(nums == null || nums.length == 0 || k < 1 || k > nums.length)
			return new ArrayList<>();

		Map<Integer,Integer> map = new HashMap<>();

		for(int num: nums)
		{
			if(map.containsKey(num))
				map.put(num,map.get(num) + 1);
			else
				map.put(num,1);
		}

		Queue<Pair> minHeap = new PriorityQueue<>(new PairComparator());

		for(Map.Entry<Integer,Integer> entry: map.entrySet())
		{
			Pair p = new Pair(entry.getKey(),entry.getValue());

			minHeap.offer(p);

			if(minHeap.size() > k)
				minHeap.poll();
		}

		List<Integer> result = new ArrayList<>();

		while(!minHeap.isEmpty())
			result.add(0,minHeap.poll().num);

		return result;
	}
}

// Way Two
public class Solution
{
	public List<Integer> topKFrequent(int [] nums, int k)
	{
		if(nums == null || nums.length == 0 || k < 1 || k > nums.length)
			return new ArrayList<>();

		Map<Integer,Integer> map = new HashMap<>();

		for(int num: nums)
		{
			if(map.containsKey(num))
				map.put(num,map.get(num) + 1);
			else
				map.put(num,1);
		}

		int max = 0;

		for(Map.Entry<Integer,Integer> entry: map.entrySet())
			max = Math.max(max,entry.getValue());

		List<Integer> [] array = new ArrayList [max + 1];

		for(int i = 0;i <= max;i++)
			array[i] = new ArrayList<>();

		for(Map.Entry<Integer,Integer> entry: map.entrySet())
			array[entry.getValue()].add(entry.getKey());

		List<Integer> result = new ArrayList<>();

		for(int i = max;i >= 1;i--)
		{
			if(array[i].size() > 0)
				for(int x: array[i])
					result.add(x);

			if(result.size() == k)
				break;
		}

		return result;
	}
}

// Way Three
public class Solution
{
	public List<Integer> topKFrequent(int [] nums, int k)
	{
		List<Integer> result = new ArrayList<>();

		Map<Integer,Integer> map = new HashMap<>();

		for(int num: nums)
		{
			if(map.containsKey(num))
				map.put(num,map.get(num) + 1);
			else
				map.put(num,1);
		}

		Map<Integer,Integer> sortedMap = new TreeMap<>(new CountComparator(map));
		sortedMap.putAll(map);

		int i = 0;

		for(Map.Entry<Integer,Integer> entry: sortedMap.entrySet())
		{
			result.add(entry.getKey());
			i++;

			if(i == k)
				break;
		}

		return result;
	}
}
class CountComparator implements Comparator<Integer>
{
	Map<Integer,Integer> map = new HashMap<>();

	CountComparator(Map<Integer,Integer> m)
	{
		map.putAll(m);
	}

	public int compare(Integer i1, Integer i2)
	{
		int difference = map.get(i2) - map.get(i1);

		if(difference == 0)
			return 1;
		else
			return difference;
	}
}