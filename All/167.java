public class Solution
{
	public int [] twoSum(int [] numbers, int target)
	{
		if(numbers == null || numbers.length == 0)
			return new int [] {-1, -1};

		int l = 0;
		int r = numbers.length - 1;

		while(l < r)
		{
			int sum = numbers[l] + numbers[r];

			if(sum == target)
				return new int [] {l + 1,r + 1};
			else if(sum < target)
				l++;
			else
				r--;
		}

		return new int [] {-1, -1};
	}
}