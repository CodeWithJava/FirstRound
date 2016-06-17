public class Solution
{
	List<String> result = new ArrayList<>();

	public List<String> addOperators(String num, int target)
	{
		helper(num,target,"",0,0);

		return result;
	}
	
	private void helper(String num,int target,String temp,long curResult,long preNum)
	{
		if(curResult == target && num.length() == 0)
			result.add(temp);
		else
		{
			for(int i = 1;i <= num.length();i++)
			{
				String x = num.substring(0,i);

				if(x.length() > 1 && x.charAt(0) == '0')
					return;

				long curNum = Long.valueOf(x);
				String next = num.substring(i);
				if(temp.length() != 0)
				{
					helper(next,target,temp + "*" + curNum,(curResult - preNum)+ preNum * curNum,preNum * curNum);
					helper(next,target,temp + "+" + curNum,curResult + curNum,curNum);
					helper(next,target,temp + "-" + curNum,curResult - curNum,-curNum);
				}
				else
					helper(next,target,x,curNum,curNum);
			}
		}
	}
}