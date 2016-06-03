// Way One
public class Solution
{
	public boolean verifyPreorder(int [] preorder)
	{
		if(preorder == null || preorder.length == 0)
			return true;

		return verifyPreorder(preorder,0,preorder.length);
	}

	private boolean verifyPreorder(int [] preorder, int l , int r)
	{
		if(l + 1 >= r)
			return true;

		int root = preorder[l];

		int i = l + 1;

		while(i < r && preorder[i] < root)
			i++;

		if(i < r)
		{
			int j = i;

			while(j < r && preorder[j] > root)
				j++;

			if(j < r)
				return false;

			return verifyPreorder(preorder,l + 1,i) && verifyPreorder(preorder,i,r);
		}
		else
			return verifyPreorder(preorder,l + 1,r);
	}
}

// Way Two
public class Solution
{
	public boolean verifyPreorder(int [] preorder)
	{
		if(preorder == null || preorder.length == 0)
			return true;

		Stack<Integer> stack = new Stack<>();
		List<Integer> sequence = new ArrayList<>();

		for(int x: preorder)
		{
			if(!sequence.isEmpty() && x < sequence.get(sequence.size() - 1))
				return false;

			while(!stack.isEmpty() && x > stack.peek())
				sequence.add(stack.pop());

			stack.push(x);
		}

		return true;
	}
}