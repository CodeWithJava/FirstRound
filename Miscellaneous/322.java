// Way One
public class Solution
{
	public int coinChange(int [] coins, int amount)
	{
		if(coins == null || coins.length == 0)
			throw new IllegalArgumentException("There is no any denomination of any coins");
		if(amount == 0)
			return 0;

		int [] dp = new int [amount + 1];
		dp[0] = 0;

		for(int i = 1;i <= amount;i++)
			dp[i] = Integer.MAX_VALUE;

		for(int i = 0;i <= amount;i++)
		{
			for(int coin: coins)
			{
				if(i + coin <= amount)
				{
					if(dp[i] != Integer.MAX_VALUE)
						dp[i + coin] = Math.min(dp[i + coin],dp[i] + 1);						
				}
			}
		}

		return dp[amount] == Integer.MAX_VALUE ? -1:dp[amount];
	}
}

// Way Two
public class Solution
{
	public int coinChange(int [] coins, int amount)
	{
		if(coins == null || coins.length == 0)
			throw new IllegalArgumentException("There is no any denomination of any coins");
		if(amount == 0)
			return 0;

		Queue<Integer> amountQ = new LinkedList<>();
		amountQ.offer(0);

		Queue<Integer> coinNumQ = new LinkedList<>();
		coinNumQ.offer(0);

		while(!amountQ.isEmpty())
		{
			int t = amountQ.poll();
			int coinNum = coinNumQ.poll();

			if(t == amount)
				return coinNum;

			for(int coin: coins)
			{
				if(t > amount)
					continue;
				else
				{
					if(!amountQ.contains(t + coin))
					{
						amountQ.offer(t + coin);
						coinNumQ.offer(coinNum + 1);
					}
				}
			}
		}

		return -1;
	}
}