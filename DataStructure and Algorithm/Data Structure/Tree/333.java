public class Solution
{
	public int largestBSTSubtree(TreeNode root)
	{
		if(root == null)
			return 0;

		int [] result = new int [1];
		result[0] = 0;

		largestBSTSubtree(root,result);

		return result[0];
	}

	private void largestBSTSubtree(TreeNode node, int [] result)
	{
		if(node == null)
			return;

		int nodeNum = countNodeBST(node,Integer.MIN_VALUE,Integer.MAX_VALUE);

		if(nodeNum != -1)
		{
			result[0] = Math.max(result[0],nodeNum);
			return;
		}

		largestBSTSubtree(node.left,result);
		largestBSTSubtree(node.right,result);
	}

	private int countNodeBST(TreeNode node, int l, int r)
	{
		if(node == null)
			return 0;

		if(node.val < l || node.val > r)
			return -1;

		int left = countNodeBST(node.left,l,node.val);
		if(left == -1)
			return -1;

		int right = countNodeBST(node.right,node.val,r);
		if(right == -1)
			return -1;

		return left + right + 1;
	}
}