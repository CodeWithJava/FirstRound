public class Solution
{
	public boolean isValid(String s)
	{
		if(s == null || s.length() == 0)
			return true;

		Map<Character,Character> map = new HashMap<>();
		map.put('(',')');
		map.put('[',']');
		map.put('{','}');

		Stack<Character> stack = new Stack<>();

		for(int i = 0;i < s.length();i++)
		{
			char x = s.charAt(i);

			if(map.containsKey(x))
				stack.push(x);
			else if(map.values().contains(x))
			{
				if(!stack.isEmpty() && map.get(stack.peek()) == x)
					stack.pop();
				else
					return false;
			}
		}

		return stack.isEmpty();
	}
}