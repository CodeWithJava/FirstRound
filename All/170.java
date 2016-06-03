public class TwoSum
{
	Map<Integer,Integer> map = new HashMap<>();

	// Add the number to an internal data structure.
	public void add(int number)
	{
		if(map.containsKey(number))
			map.put(number,map.get(number) + 1);
		else
			map.put(number,1);
	}

	// Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value)
	{
		for(Map.Entry<Integer,Integer> entry: map.entrySet())
		{
			int number = entry.getKey();
			int x = value - number;

			if(x == number)
			{
				if(entry.getValue() > 1)
					return true;
			}
			else if(map.containsKey(x))
				return true;
		}

		return false;
	}
}