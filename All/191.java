public class Solution
{
	public int hammingWeight(int n)
	{
		int count = 0;

		for(int i = 1;i < 33;i++)
			if(getOne(n,i))
				count++;

		return count;
	}

	private boolean getOne(int n, int i)
	{
		return (n & (1 << i)) != 0;
	}
}