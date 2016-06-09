public class Solution
{
	static final int [] weight = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	static final String [] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

	public String intToRoman(int num)
	{
		int i = 0;
		StringBuilder sb = new StringBuilder();

		while(num > 0)
		{
			int k = num / weight[i];

			for(int j = 0;j < k;j++)
			{
				sb.append(roman[i]);
				num -= weight[i];
			}

			i++;
		}

		return sb.toString();
	}
}