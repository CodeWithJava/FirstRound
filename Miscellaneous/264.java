public class Solution
{
	public int nthUglyNumber(int n)
	{
		if(n <= 0)
			return 0;

		List<Integer> uglyNumbers = new ArrayList<>();
		uglyNumbers.add(1);

		int i = 0;
		int j = 0;
		int k = 0;

		while(uglyNumbers.size() < n)
		{
			int n2 = uglyNumbers.get(i) * 2;
			int n3 = uglyNumbers.get(j) * 3;
			int n5 = uglyNumbers.get(k) * 5;

			int minmum = Math.min(n2, Math.min(n3, n5));

			uglyNumbers.add(minmum);

			if(minmum == n2)
				i++;
			if(minmum == n3)
				j++;
			if(minmum == n5)
				k++;
		}

		return uglyNumbers.get(n - 1);
	}
}