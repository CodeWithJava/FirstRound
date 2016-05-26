public class Solution
{
	public int candy(int [] ratings)
	{
		if(ratings == null)
			throw new IllegalArgumentException("Input is invalid");

		if(ratings.length < 2)
			return ratings.length;

		int [] candies = new int [ratings.length];
		candies[0] = 1;

		for(int i = 1;i < ratings.length;i++)
		{
			if(ratings[i - 1] < ratings[i])
				candies[i] = candies[i - 1] + 1;
			else
				candies[i] = 1;
		}

		for(int i = ratings.length - 1;i > 0;i--)
			if(ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i])
				candies[i - 1] = candies[i] + 1;

		int result = 0;
		for(int i = 0;i < ratings.length;i++)
			result += candies[i];

		return result;
	}
}