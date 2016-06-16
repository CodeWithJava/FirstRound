public class Solution
{
	public List<String> findStrobogrammatic(int n)
	{
		char [] keys = {'0','1','8','6','9'};
		char [] values = {'0','1','8','9','6'};
		char [] temp = new char [n];

		List<String> result = new ArrayList<>();
		findStrobogrammatric(keys,values,0,n,temp,result);
		return result;
	}

	private void findStrobogrammatric(char [] keys,char [] values,int index,int n,char [] temp,List<String> result)
	{
		if(index > n / 2 || index == n / 2 && n % 2 == 0)
			result.add(new String(temp));
		else
		{
			for(int i = 0;i < keys.length;i++)
			{
				if(index == 0 && keys[i] == '0' && n > 1 || index == n - 1 - index && ( keys[i] == '6'|| keys[i] == '9'))
					continue;
				temp[index] = keys[i];
				temp[n - 1 - index] = values[i];
				findStrobogrammatric(keys,values,index + 1,n,temp,result);
			}
		}
	}
}