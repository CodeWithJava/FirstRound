public class Solution
{
	public int calculate(String s)
	{
		if(s == null || s.length() == 0)
			return 0;

		s = s.replaceAll(" ","");

		Stack<String> stack = new Stack<>();
		char [] arr = s.toCharArray();
		StringBuilder sb = new StringBuilder();

		for(int i = 0;i < arr.length;i++)
		{
			if(arr[i] == ' ')
				continue;

			if(arr[i] >= '0' && arr[i] <= '9')
			{
				sb.append(arr[i]);

				if(i == arr.length - 1)
					stack.push(sb.toString());
			}
			else
			{
				if(sb.length() > 0)
				{
					stack.push(sb.toString());
					sb = new StringBuilder();
				}

				if(arr[i] != ')')
					stack.push(new String(new char [] {arr[i]}));
				else
				{
					List<String> t = new ArrayList<>();

					while(!stack.isEmpty())
					{
						String top = stack.pop();

						if(top.equals("("))
							break;
						else
							t.add(0,top);
					}

					int temp = 0;

					if(t.size() == 1)
						temp = Integer.valueOf(t.get(0));
					else
					{
						for(int j = t.size() - 1;j > 0;j -= 2)
						{
							if(t.get(j - 1).equals("-"))
								temp += 0 - Integer.valueOf(t.get(j));
							else
								temp += Integer.valueOf(t.get(j));
						}

						temp += Integer.valueOf(t.get(0));
					}

					stack.push(String.valueOf(temp));
				}
			}
		}

		List<String> t = new ArrayList<String>();

		while (!stack.isEmpty())
		{
			String elem = stack.pop();
			t.add(0, elem);
		}
	
		int temp = 0;

		for (int i = t.size() - 1; i > 0; i = i - 2)
		{
			if (t.get(i - 1).equals("-"))
				temp += 0 - Integer.valueOf(t.get(i));
			else
				temp += Integer.valueOf(t.get(i));
		}

		temp += Integer.valueOf(t.get(0));
	
		return temp;
	}
}