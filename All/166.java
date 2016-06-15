public class Solution
{
	public String fractionToDecimal(int numerator, int denominator)
	{
		if(numerator == 0)
			return "0";

		if(denominator == 0)
			return "";

		String result = "";
		
		if((numerator < 0) && (denominator > 0) || (numerator > 0) && (denominator < 0))
			result += "-";
		
		long num = numerator;
		long den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);
		
		long quotient = num / den;
		result += String.valueOf(quotient);
		long remainder = (num % den) * 10;
		
		if(remainder == 0)
			return result;

		result += ".";

		Map<Long,Integer> map = new HashMap<>();

		while(remainder != 0)
		{
			if(map.containsKey(remainder))
			{
				int i = map.get(remainder);
				String part1 = result.substring(0,i);
				String part2 = result.substring(i,result.length());
				result = part1 + "(" + part2 + ")";

				return result;
			}

			map.put(remainder,result.length());
			quotient = remainder / den;
			result += String.valueOf(quotient);
			remainder = (remainder % den) * 10;
		}

		return result;
	}
}