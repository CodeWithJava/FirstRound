public class Solution
{
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p)
	{
		if(root == null || p == null)
			return null;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		boolean isNext = false;

		while(!stack.isEmpty())
		{
			TreeNode node = stack.pop();

			if(node.left == null && node.right == null)
			{
				if(isNext)
					return node;

				if(p.val == node.val)
					isNext = true;

				continue;
			}

			if(node.right != null)
			{
				stack.push(node.right);
				node.right = null;
			}

			stack.push(node);

			if(node.left != null)
			{
				stack.push(node.left);
				node.left = null;
			}
		}

		return null;
	}
}