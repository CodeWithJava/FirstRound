public class Solution
{
	public String simplifyPath(String path)
	{
		if(path == null || path.length() == 0)
			return path;

		String [] elements = path.split("/");

		Stack<String> stack = new Stack<>();

		for(String x: elements)
		{
			if(x.length() == 0 || x.equals("."))
				continue;
			else if(x.equals(".."))
			{
				if(!stack.isEmpty())
					stack.pop();
			}
			else
				stack.push(x);
		}

		if(stack.isEmpty())
			return "/";

		StringBuilder sb = new StringBuilder();

		while(!stack.isEmpty())
			sb.insert(0,"/" + stack.pop());

		return sb.toString();
	}
}