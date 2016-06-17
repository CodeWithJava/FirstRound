public class Solution extends VersionControl
{
	public int firstBadVersion(int n)
	{
		if(n <= 0)
			throw new IllegalArgumentException("Input is invalid");
		if(n == 1)
			return 1;
		int l = 1;
		int r = n;
		Solution a = new Solution();

		while(l < r)
		{
			int m = l + (r - l) / 2;

			if(a.isBadVersion(m))
				r = m;
			else
				l = m + 1;
		}
		return l;
	}
}