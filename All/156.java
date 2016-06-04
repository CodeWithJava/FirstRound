public class Solution
{
	public TreeNode upsideDownBinaryTree(TreeNode root)
	{
		if(root == null)
			return root;

		TreeNode cur = root;

		while(cur.left != null)
			cur = cur.left;

		rotate(root);

		return cur;
	}

	private void rotate(TreeNode node)
	{
		if(node.left != null)
		{
			rotate(node.left);

			node.left.right = node;
			node.left.left = node.right;
			node.left = null;
			node.right = null;
		}
	}
}