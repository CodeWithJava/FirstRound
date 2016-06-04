public class Solution
{
	public int maxProfit(int [] prices)
	{
		if(prices == null || prices.length == 0)
			return 0;

		int [] l = new int [prices.length];
		int [] r = new int [prices.length];

		l[0] = 0;
		int minimum = prices[0];

		for(int i = 1;i < prices.length;i++)
		{
			minimum = Math.min(minimum,prices[i]);
			l[i] = Math.max(l[i - 1],prices[i] - minimum);
		}

		r[prices.length - 1] = 0;
		int maximum = prices[prices.length - 1];

		for(int i = prices.length - 2;i >= 0;i--)
		{
			maximum = Math.max(maximum,prices[i]);
			r[i] = Math.max(r[i + 1],maximum - prices[i]);
		}

		int profit = 0;

		for(int i = 0;i < prices.length;i++)
			profit = Math.max(profit,l[i] + r[i]);

		return profit;
	}
}