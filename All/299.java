public class Solution
{
	public String getHint(String secret, String guess)
	{
		if(secret == null || secret.length() == 0 || guess == null || guess.length() == 0)
			return null;

		int [] ascii = new int [256];
		int bulls = 0;
		int cows = 0;

		for(int i = 0;i < secret.length();i++)
		{
			int s = Integer.valueOf(secret.charAt(i));
			if(secret.charAt(i) == guess.charAt(i))
				bulls++;
			else
				ascii[s]++;
		}

		for(int i = 0;i < secret.length();i++)
		{
			int g = Integer.valueOf(guess.charAt(i));
			if(secret.charAt(i) != guess.charAt(i) && ascii[g] > 0)
			{
				cows++;
				ascii[g]--;
			}
		}

		return bulls + "A" + cows + "B";
	}
}