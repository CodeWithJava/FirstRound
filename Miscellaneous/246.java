public class Solution
{
	public boolean isStrobogrammatic(String num)
	{
		Map<Character,Character> map = new HashMap<>();
		map.put('0','0');
		map.put('1','1');
		map.put('8','8');
		map.put('6','9');
		map.put('9','6');

		int i = 0;
		int j = num.length() - 1;

		while(i <= j)
		{
			if(map.get(num.charAt(i)) != (Character)(num.charAt(j)))
				return false;
			i++;
			j--;
		}

		return true;  
	}
}