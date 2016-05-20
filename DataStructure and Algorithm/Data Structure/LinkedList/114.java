public class Solution
{
	public void flatten(TreeNode root)
	{
		if(root == null)
			return;

		TreeNode p = root;
		Stack<TreeNode> stack = new Stack<>();

		while(p != null || !stack.isEmpty())
		{
			if(p.right != null)
				stack.push(p.right);
			if(p.left != null)
			{
				p.right = p.left;
				p.left = null;
			}
			else if(!stack.isEmpty())
				p.right = stack.pop();
			p = p.right;
		}
	}
}