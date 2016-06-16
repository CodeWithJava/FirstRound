public class Solution
{
	public int minCost(int [][] costs)
	{
		if(costs == null || costs.length == 0)
			return 0;
		int R = costs[0][0];
		int B = costs[0][1];
		int G = costs[0][2];
		for(int i = 1;i < costs.length;i++)
		{
			int r = R;
			int b = B;
			R = costs[i][0] + Math.min(B,G);
			B = costs[i][1] + Math.min(r,G);
			G = costs[i][2] + Math.min(r,b);
		}
		return Math.min(Math.min(R,B),G);
	}
}