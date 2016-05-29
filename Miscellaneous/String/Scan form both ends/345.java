public class Solution
{
	public String reverseVowels(String s)
	{
		if(s == null || s.length() == 0)
			return s;

		List<Character> vowels = new ArrayList<>();

		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');

		char [] alphabets = s.toCharArray();

		int l = 0;
		int r = s.length() - 1;

		while(l < r)
		{
			if(!vowels.contains(alphabets[l]))
			{
				l++;
				continue;
			}

			if(!vowels.contains(alphabets[r]))
			{
				r--;
				continue;
			}

			char t = alphabets[l];
			alphabets[l] = alphabets[r];
			alphabets[r] = t;

			l++;
			r--;
		}

		return new String(alphabets);
	}
}