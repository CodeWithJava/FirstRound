public class Solution
{
	public List<Integer> diffWaysToCompute(String input)
	{
		List<Integer> result = new ArrayList<>();

		if(input == null || input.length() == 0)
			return result;

		String operator = "+-*";

		for(int i = 0;i < input.length();i++)
		{
			if(operator.contains(input.charAt(i) + ""))
			{
				String l = input.substring(0,i);
				String r = input.substring(i + 1);

				List<Integer> left = diffWaysToCompute(l);
				List<Integer> right = diffWaysToCompute(r);

				for(Integer p: left)
				{
					for(Integer q: right)
					{
						if(input.charAt(i) == '+')
							result.add(p + q);
						else if(input.charAt(i) == '-')
							result.add(p - q);
						else if(input.charAt(i) == '*')
							result.add(p * q);
						else
							result.add(0);
					}
				}
			}
		}

		if(result.size() == 0)
			result.add(Integer.valueOf(input));

		return result;
	}
}