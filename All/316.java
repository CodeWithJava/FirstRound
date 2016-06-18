public class Solution
{
	public String removeDuplicateLetters(String s)
	{
		if(s == null || s.length() == 0)
			return "";

		int [] duplicates = new int [26];

		for(char x: s.toCharArray())
			duplicates[x - 'a']++;

		boolean [] exist = new boolean [26];
		Stack<Character> stack = new Stack<>();

		for(char x: s.toCharArray())
		{
			int index = x - 'a';
			duplicates[index]--;

			if(exist[index])
				continue;

			while(!stack.isEmpty() && x < stack.peek() && duplicates[stack.peek() - 'a'] != 0)
				exist[stack.pop() - 'a'] = false;

			stack.push(x);
			exist[index] = true;
		} 

		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty())
			sb.insert(0,stack.pop());
		return sb.toString();
	}
}