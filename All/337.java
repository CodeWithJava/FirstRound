public class Solution
{
	public int rob(TreeNode root)
	{
		if(root == null)
			return 0;

		int [] result = traversal(root);

		return Math.max(result[0],result[1]);
	}

	private int[] traversal(TreeNode node)
	{
		if(node == null)
			return new int [] {0,0};

		int [] result = new int [2];
		int [] l = traversal(node.left);
		int [] r = traversal(node.right);

		result[0] = node.val + l[1] + r[1];
		result[1] = Math.max(l[0],l[1]) + Math.max(r[0],r[1]);

		return result;
	}
}