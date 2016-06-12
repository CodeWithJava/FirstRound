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