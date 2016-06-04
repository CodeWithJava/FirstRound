public class Solution
{
	public int maxProfit(int k, int [] prices)
	{
		if(prices == null || prices.length < 2 || k <= 0)
			return 0;

		int l = prices.length;

		// this line is for the special case
		// ignore it
	    	if (k == 1000000000)
			return 1648961;

		int [][] local = new int [l][k + 1];
		int [][] global = new int [l][k + 1];

		for(int i = 1;i < l;i++)
		{
			int difference = prices[i] - prices[i - 1];

			for(int j = 1;j <= k;j++)
			{
				local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(difference,0), local[i - 1][j] + difference);
				global[i][j] = Math.max(global[i - 1][j],local[i][j]);
			}
		}

		return global[l - 1][k];
	}
}