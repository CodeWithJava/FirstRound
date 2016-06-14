// Like we handle the tree problem
// Try to feel traversal the whole triangle from bottom to top
public class Solution
{
	public int minimumTotal(List<List<Integer>> triangle)
	{
		if(triangle.size() == 1)
			return triangle.get(0).get(0);

		int size = triangle.size();

		int [] dp = new int [size];

		for(int i = 0;i < triangle.get(size - 1).size();i++)
			dp[i] = triangle.get(size - 1).get(i);

		for(int i = size - 2;i >= 0;i--)
			for(int j = 0;j < triangle.get(i).size();j++)
				dp[j] = Math.min(dp[j],dp[j + 1]) + triangle.get(i).get(j);

		return dp[0];
	}
}