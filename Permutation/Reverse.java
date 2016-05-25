
public class Reverse
{
	public static void reverse(int [] nums, int i, int j)
	{
		while(i < j)
		{
			Swap.swap(nums, i, j);
			i++;
			j--;
		}
	}
}
