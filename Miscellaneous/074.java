// Way One
// Naive Method
public class Solution
{
	public boolean searchMatrix(int [][] matrix, int target)
	{
		if(matrix == null || matrix.length == 0)
			return false;

		int i = 0;
		int j = matrix[0].length - 1;

		while(i <= matrix.length - 1 && j >= 0)
		{
			if(matrix[i][j] == target)
				return true;
			else if(target < matrix[i][j])
				j--;
			else
				i++;
		}

		return false;
	}
}

// Way Two
// Binary Search
public class Solution
{
	public boolean searchMatrix(int [][] matrix,int target)
	{
		if(matrix == null || matrix.length == 0)
			return false;

		int r = matrix.length;
		int c = matrix[0].length;

		if(target < matrix[0][0] || matrix[r-1][c-1] < target)
			return false;

		int left = 0;
		int right = r * c - 1;

		while(left <= right)
		{
			int m = left + (right - left) / 2;
			int mx = m / c;
			int my = m % c;
			if(matrix[mx][my] == target)
				return true;
			else if(matrix[mx][my] < target)
				left = m + 1;
			else
				right = m - 1;
		}
		return false;
	}
}