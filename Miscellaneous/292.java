public class Solution
{
	public boolean canWinNim(int n)
	{
		if(n <= 0)
			return false;

		if(n % 4 == 0)
			return false;

		return true;
	}
}