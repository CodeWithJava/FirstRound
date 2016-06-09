public class Solution
{
	public double findMedianSortedArrays(int [] nums1, int [] nums2)
	{
		int m = nums1.length;
		int n = nums2.length;
		int k = (m + n) / 2;

		if((m + n) % 2 == 0)
			return (findKth(nums1,0,m,nums2,0,n,k) + findKth(nums1,0,m,nums2,0,n,k + 1)) / 2;
		else
			return findKth(nums1,0,m,nums2,0,n,k + 1);
	}

	private double findKth(int [] nums1, int l1, int r1, int [] nums2, int l2, int r2, int k)
	{
		int m = r1 - l1;
		int n = r2 - l2;

		if(m > n)
			return findKth(nums2,l2,r2,nums1,l1,r1,k);

		if(m == 0)
			return nums2[l2 + k - 1];

		if(k == 1)
			return Math.min(nums1[l1],nums2[l2]);

		int p = Math.min(k / 2,m);
		int q = k - p;

		if(nums1[l1 + p - 1] < nums2[l2 + q - 1])
			return findKth(nums1,l1 + p,r1,nums2,l2,r2,k - p);
		else if(nums1[l1 + p - 1] > nums2[l2 + q - 1])
			return findKth(nums1,l1,r1,nums2,l2 + q,r2,k - q);
		else
			return nums1[l1 + p - 1];
	}
}