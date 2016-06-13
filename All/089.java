// Reach the bottom first then back to top
public class Solution
{
	public List<Integer> grayCode(int n)
	{
		if(n == 0)
		{
			List<Integer> result = new ArrayList<>();
			result.add(0);
			return result;
		}

		List<Integer> result = grayCode(n - 1);

		int reverse = 1 << (n - 1);
		int originalSize = result.size();

		for(int i = originalSize - 1;i >= 0;i--)
			result.add(reverse + result.get(i));

		return result;
	}
}