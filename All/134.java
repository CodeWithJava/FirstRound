public class Solution
{
	public int canCompleteCircuit(int [] gas,int [] cost)
	{
		if((gas == null || gas.length == 0) || (cost == null || cost.length == 0))
			return -1;

		int sumRemaining = 0;
		int difference = 0;
		int start = 0;

		for(int i = 0;i < gas.length;i++)
		{
			int remaining = gas[i] - cost[i];

			if(sumRemaining >= 0)
				sumRemaining += remaining;
			else
			{
				sumRemaining = remaining;
				start = i;
			}

			difference += remaining;
		}

		if(difference >= 0)
			return start;

		return -1;
	}
}