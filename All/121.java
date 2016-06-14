public class Solution
{
	public int maxProfit(int [] prices)
	{
		if(prices == null || prices.length == 0)
			return 0;

		int profit = 0;
		int min = Integer.MAX_VALUE;

		for(int i = 0;i < prices.length;i++)
		{
			min = Math.min(min,prices[i]);
			profit = Math.max(profit,prices[i] - min);
		}

		return profit;
	}
}