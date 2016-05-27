public class Solution
{
	public String getPermutation(int n, int k)
	{
		List<Integer> numbers = new ArrayList<>();
		for(int i = 1;i <= n;i++)
			numbers.add(i);

		k--;

		int factorial = 1;
		for(int i = 1;i <= n;i++)
			factorial *= i;

		StringBuilder sb = new StringBuilder();

		for(int i = 0;i < n;i++)
		{
			factorial /= n - i;
			int curIndex = k / factorial;
			k %= factorial;

			sb.append(numbers.get(curIndex));
			numbers.remove(curIndex);
		}

		return sb.toString();
	}
}