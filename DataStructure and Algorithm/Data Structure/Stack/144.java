// There are two ways to implement the method
// Must realisze the truth of the ways

//Way One
public class Solution
{
	public List<Integer> preorderTraversal(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();

		if(root == null)
			return result;

		preorderTraversal(root,result);

		return result;
	}

	public void preorderTraversal(TreeNode node, List<Integer> result)
	{
		if(node == null)
			return;
		result.add(node.val);
		preorderTraversal(node.left,result);
		preorderTraversal(node.right,result);
	}
}

//Way Two
public class Solution
{
	public List<Integer> preorderTraversal(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();

		if(root == null)
			return result;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty())
		{
			TreeNode node = stack.pop();

			result.add(node.val);

			if(node.right != null)
				stack.push(node.right);
			if(node.left != null)
				stack.push(node.left);
		}

		return result;
	}
}