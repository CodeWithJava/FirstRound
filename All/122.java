public class Solution
{
	public int maxProfit(int [] prices)
	{
		if(prices == null || prices.length == 0)
			return 0;

		int profit = 0;

		for(int i = 0;i < prices.length - 1;i++)
		{
			int difference = prices[i + 1] - prices[i];

			if(difference > 0)
				profit += difference;
		}

		return profit;
	}
}