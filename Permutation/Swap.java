public class Swap
{
	public static void swap(int [] nums, int i, int j)
	{
		if(i < j)
		{
			int t = nums[i];
			nums[i] = nums[j];
			nums[j] = t;
		}
	}
}
