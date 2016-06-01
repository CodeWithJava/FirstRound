public class Solution
{
	public int [] maxNumber(int [] nums1, int [] nums2, int k)
	{
		if(nums1 == null || nums2 == null || k <= 0 || k > nums1.length + nums2.length)
			return new int [0];

		int [] result = new int [k];

		for(int i = Math.max(k - nums2.length, 0);i <= Math.min(nums1.length,k);i++)
		{
			int [] sub1 = getMaxSubArray(nums1,i);
			int [] sub2 = getMaxSubArray(nums2,k - i);
			int [] x = new int [k];

			int i1 = 0;
			int i2 = 0;
			int t = 0;

			while(i1 < sub1.length || i2 < sub2.length)
				x[t++] = compare(sub1,i1,sub2,i2) ? sub1[i1++]:sub2[i2++];

			if(!compare(result,0,x,0))
				result = x;
		}

		return result;
	}

	private boolean compare(int [] sub1, int i1, int [] sub2, int i2)
	{
		for(;i1 < sub1.length && i2 < sub2.length;i1++, i2++)
		{
			if(sub1[i1] > sub2[i2])	return true;
			if(sub1[i1] < sub2[i2])	return false;
		}

		return i1 != sub1.length;
	}

	private int [] getMaxSubArray(int [] nums, int k)
	{
		int [] x = new int [k];
		int length = 0;

		for(int i = 0;i < nums.length;i++)
		{
			while(length > 0 && length + nums.length - i > k && x[length - 1] < nums[i])
				length--;

			if(length < k)
				x[length++] = nums[i];
		}

		return x;
	}
}