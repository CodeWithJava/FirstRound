public class BSTIterator
{
	Stack<TreeNode> stack = new Stack<>();

	public BSTIterator(TreeNode root)
	{
		TreeNode node = root;
		while(node != null)
		{
			stack.push(node);
			node = node.left;
		}
	}

	public boolean hasNext()
	{
		return !stack.isEmpty();
	}

	public int next()
	{
		TreeNode node = stack.pop();

		int result = node.val;

		if(node.right != null)
		{
			node = node.right;
			while(node != null)
			{
				stack.push(node);
				node = node.left;
			}
		}

		return result;
	}
}