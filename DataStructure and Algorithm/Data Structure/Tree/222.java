public class Solution
{
	public int countNodes(TreeNode root)
	{
		if(root == null)
			return 0;

		int l = getLeftHeight(root);
		int r = getRightHeight(root);

		if(l == r)
			return (2 << (l - 1)) - 1;

		return countNodes(root.left) + countNodes(root.right) + 1;
	}

	private int getLeftHeight(TreeNode node)
	{
		int height = 0;

		while(node != null)
		{
			node = node.left;
			height++;
		}

		return height;
	}

	private int getRightHeight(TreeNode node)
	{
		int height = 0;

		while(node != null)
		{
			node = node.right;
			height++;
		}

		return height;
	}
}