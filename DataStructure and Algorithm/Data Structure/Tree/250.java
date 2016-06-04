public class Solution
{
	int count;

	public int countUnivalSubtrees(TreeNode root)
	{
		if(root == null)
			return 0;

		count = 0;

		univalueSubtrees(root);

		return count;
	}

	private boolean univalueSubtrees(TreeNode node)
	{
		if(node == null)
			return true;

		if(node.left == null && node.right == null)
		{
			count++;
			return true;
		}

		boolean l = univalueSubtrees(node.left);
		boolean r = univalueSubtrees(node.right);

		if(l && r && (node.left == null || node.left.val == node.val) && (node.right == null || node.right.val == node.val))
		{
			count++;
			return true;
		}

		return false;
	}
}