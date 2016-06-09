public class Solution
{
	public int romanToInt(String s)
	{
		if(s == null || s.length() == 0)
			return 0;

		Map<Character,Integer> map = new HashMap<>();
		map.put('M',1000);
		map.put('D',500);
		map.put('C',100);
		map.put('L',50);
		map.put('X',10);
		map.put('V',5);
		map.put('I',1);

		int result = 0;
		int previous = 0;

		for(int i = 0;i < s.length();i++)
		{
			int current = map.get(s.charAt(i));

			result += current > previous ? (current - 2 * previous):current;

			previous = current;
		}

		return result;
	}
}