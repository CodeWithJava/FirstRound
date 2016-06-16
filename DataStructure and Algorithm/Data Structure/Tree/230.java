public class Solution
{
	public int kthSmallest(TreeNode root,int k)
	{
		if(root == null)
			throw new IllegalArgumentException("Input is invalid");

		int result = 0;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;

		while(!stack.isEmpty() || p != null)
		{
			if(p != null)
			{
				stack.push(p);
				p = p.left;
			}
			else if(!stack.isEmpty())
			{
				TreeNode node = stack.pop();
				if(--k == 0)
					result = node.val;
				p = node.right;
			}
		}
		return result;
	}
}