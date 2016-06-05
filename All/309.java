public class Solution
{
	public int maxProfit(int [] prices)
	{
		if(prices == null || prices.length < 2)
			return 0;

		int [] sell = new int [prices.length];
		sell[1] = Math.max(0,prices[1] - prices[0]);

		int [] buy = new int [prices.length];
		buy[0] = - prices[0];
		buy[1] = Math.max(- prices[0],- prices[1]);

		for(int i = 2;i < prices.length;i++)
		{
			buy[i] = Math.max(buy[i - 1],sell[i - 2] - prices[i]);
			sell[i] = Math.max(sell[i - 1],buy[i - 1] + prices[i]);
		} 

		return sell[prices.length - 1];
	}
}