public class Solution
{
	public List<List<Integer>> palindromePairs(String [] words)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(words == null || words.length == 0)
			return result;

		Map<String,Integer> map = new HashMap<>();

		for(int i = 0;i < words.length;i++)
			map.put(words[i],i);

		for(int i = 0;i < words.length;i++)
		{
			String s = words[i];

			if(isPalindrome(s))
			{
				if(map.containsKey(""))
				{
					if(map.get("") != i)
					{
						List<Integer> t = new ArrayList<>();

						t.add(i);
						t.add(map.get(""));

						result.add(new ArrayList<>(t));

						t = new ArrayList<>();

						t.add(map.get(""));
						t.add(i);

						result.add(new ArrayList<>(t));
					}
				}
			}

			String reversed = new StringBuilder(s).reverse().toString();

			if(map.containsKey(reversed))
			{
				if(map.get(reversed) != i)
				{
					List<Integer> t = new ArrayList<>();

					t.add(i);
					t.add(map.get(reversed));

					result.add(new ArrayList<>(t));
				}
			}

			for(int k = 1;k < s.length();k++)
			{
				String l = s.substring(0,k);
				String r = s.substring(k);

				if(isPalindrome(l))
				{
					String reversedR = new StringBuilder(r).reverse().toString();

					if(map.containsKey(reversedR))
					{
						if(map.get(reversedR) != i)
						{
							List<Integer> t = new ArrayList<>();

							t.add(map.get(reversedR));
							t.add(i);

							result.add(new ArrayList<>(t));
						}
					}
				}

				if(isPalindrome(r))
				{
					String reversedL = new StringBuilder(l).reverse().toString();

					if(map.containsKey(reversedL))
					{
						if(map.get(reversedL) != i)
						{
							List<Integer> t = new ArrayList<>();

							t.add(i);
							t.add(map.get(reversedL));

							result.add(new ArrayList<>(t));
						}
					}
				}
			}
		}

		return result;
	}

	private boolean isPalindrome(String s)
	{
		int l = 0;
		int r = s.length() - 1;

		while(l < r)
		{
			if(s.charAt(l) != s.charAt(r))
				return false;

			l++;
			r--;
		}

		return true;
	}
}