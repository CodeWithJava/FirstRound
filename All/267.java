// Way One
public class Solution
{
	public List<String> generatePalindromes(String s)
	{
		List<String> result = new ArrayList<>();

		if(s == null || s.length() == 0)
			return result;

		Map<Character,Integer> map = new HashMap<>();

		for(int i = 0;i < s.length();i++)
		{
			char x = s.charAt(i);

			if(map.containsKey(x))
				map.put(x,map.get(x) + 1);
			else
				map.put(x,1);
		}

		String candidate = "";
		String single = "";
		boolean ready = false;

		for(char x: map.keySet())
		{
			int half = map.get(x) / 2;

			for(int i = 0;i < half;i++)
				candidate += x;

			if(map.get(x) % 2 != 0)
			{
				if(ready)
					return result;
				else
				{
					ready = true;
					single += x;
				}
			}
		}

		if(candidate.length() == 0 && single.length() != 1)
			return result;

		permuation("",candidate,single,candidate.length(),result);

		return result;
	}

	private void permuation(String left, String candidate, String single, int l, List<String> result)
	{
		if(left.length() == l)
		{
			String right = new StringBuilder(left).reverse().toString();
			result.add(left + single + right);
		}
		else
		{
			for(int i = 0;i < candidate.length();i++)
			{
				if(i != 0 && candidate.charAt(i) == candidate.charAt(i - 1))
					continue;

				permuation(left + candidate.charAt(i),candidate.substring(0,i) + candidate.substring(i + 1),single,l,result);
			}
		}
	}
}

// Way Two
public class Solution
{
	public List<String> generatePalindromes(String s)
	{
		List<String> result = new ArrayList<>();

		if(s == null || s.length() == 0)
			return result;

		Map<Character,Integer> map = new HashMap<>();

		for(int i = 0;i < s.length();i++)
		{
			char x = s.charAt(i);

			if(map.containsKey(x))
				map.put(x,map.get(x) + 1);
			else
				map.put(x,1);
		}

		String candidate = "";
		String single = "";
		boolean ready = false;

		for(char x: map.keySet())
		{
			int half = map.get(x) / 2;

			for(int i = 0;i < half;i++)
				candidate += x;

			if(map.get(x) % 2 != 0)
			{
				if(ready)
					return result;
				else
				{
					ready = true;
					single += x;
				}
			}
		}

		if(candidate.length() == 0 && single.length() != 1)
			return result;

		String copy = new String(candidate);

		do
		{
			copy = nextPermuation(copy);
			String r = new StringBuilder(copy).reverse().toString();

			result.add(copy + single + r);
		}
		while(!copy.equals(candidate));

		return result;
	}

	private String nextPermuation(String s)
	{
		if(s == null || s.length() == 0)
			throw new IllegalArgumentException("Input is invalid");

		char [] alphabet = s.toCharArray();

		int p = 0;
		for(int i = s.length() - 1;i > 0;i--)
		{
			if(alphabet[i] > alphabet[i - 1])
			{
				p = i - 1;
				break;
			}
		}

		int q = 0;
		for(int i = s.length() - 1;i > p;i--)
		{
			if(alphabet[i] > alphabet[p])
			{
				q = i;
				break;
			}
		}

		if(p == 0 && q == 0)
		{
			reverse(alphabet,0,s.length() - 1);
			return new String(alphabet);
		}

		swap(alphabet,p,q);

		if(p < s.length() - 1)
			reverse(alphabet,p + 1,s.length() - 1);

		return new String(alphabet);
	}

	private void swap(char [] alphabet,int i,int j)
        {
                char c = alphabet[i];
                alphabet[i] = alphabet[j];
                alphabet[j] = c;
        }

        private void reverse(char [] alphabet,int l,int r)
        {
                while(l < r)
                {
                        swap(alphabet,l,r);
                        l++;
                        r--;
                }
        }
}