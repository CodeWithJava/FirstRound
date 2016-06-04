public class Solution
{
	public int longestConsecutive(TreeNode root)
	{
		if(root == null)
			return 0;

		return longestConsecutive(root,0,root.val - 1);
	}

	private int longestConsecutive(TreeNode node, int length, int previousValue)
	{
		if(node == null)
			return length;

		int currentLength = previousValue + 1 == node.val ? length + 1:1;

		return Math.max(currentLength, Math.max(longestConsecutive(node.left,currentLength,node.val), longestConsecutive(node.right,currentLength,node.val)));
	}
}