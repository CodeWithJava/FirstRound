public class Solution
{
	public TreeNode buildTree(int [] inorder, int [] postorder)
	{
		if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
			return null;

		return buildTree(inorder,0,inorder.length - 1,postorder,0,postorder.length - 1);
	}

	private TreeNode buildTree(int [] inorder, int iL, int iR, int [] postorder, int pL, int pR)
	{
		if(iL > iR || pL > pR)
			return null;

		int val = postorder[pR];
		TreeNode root = new TreeNode(val);

		int k = 0;
		for(int i = 0;i < inorder.length;i++)
		{
			if(inorder[i] == val)
			{
				k = i;
				break;
			}
		}

		root.left = buildTree(inorder,iL,iL + k - 1,postorder,pL,pL + k - iL -1);
		root.right = buildTree(inorder,k + 1,iR,postorder,pL + k - iL,pR - 1);

		return root;
	}
}