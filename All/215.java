// Way One
// Get the top element among the array by heap
public class Solution
{
	public int findKthLargest(int [] nums,int k)
	{
		if(k <= 0 || k > nums.length || nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		int size = nums.length;
		buildHeap(nums);
		for(int i = 1;i < k;i++)
		{
			swap(nums,0,size-1);
			size--;
			maxHeap(nums,size,0);
		}

		return nums[0];
	}

	private void buildHeap(int [] nums)
	{
		for(int i = nums.length / 2;i >= 0;i--)
			maxHeap(nums,nums.length,i);
	}

	private void maxHeap(int [] nums,int size,int parent)
	{
		int l = parent * 2 + 1;
		int r = l + 1;
		int largest = parent;

		if(l < size && nums[l] > nums[largest])
			largest = l;
		if(r < size && nums[r] > nums[largest])
			largest = r;

		if(largest != parent)
		{
			swap(nums,largest,parent);
			maxHeap(nums,size,largest);
		}
	}

	private void swap(int [] nums,int i,int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}

// Way Two
// A method like quick sort
public class Solution
{
	public int findKthLargest(int [] nums,int k)
	{
		if(k <= 0 || k > nums.length || nums == null || nums.length == 0)
			throw new IllegalArgumentException("Input is invalid");

		return findKthLargest(nums,nums.length - k,0,nums.length - 1);
	}

	private int findKthLargest(int [] nums,int indexK,int start,int end)
	{
		int l = start;
		int r = end;
		int pivot = nums[end];

		while(l < r)
		{
			while(l < r && nums[l] < pivot)
				l++;
			while(l < r && pivot <= nums[r])
				r--;
			swap(nums,l,r);
		}
		swap(nums,l,end);

		if(l == indexK)
			return nums[l];
		else if(l < indexK)
			return findKthLargest(nums,indexK,l+1,end);
		else
			return findKthLargest(nums,indexK,start,l-1);
	}

	private void swap(int [] nums,int i,int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}

// Way Three
// Greedy Algorithm