public class Solution
{
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
	{
		if(root == null)
			return root;

		if(p == root || q == root)
			return root;

		TreeNode l = lowestCommonAncestor(root.left,p,q);
		TreeNode r = lowestCommonAncestor(root.right,p,q);

		if(l != null && r != null)
			return root;

		return l != null ? l:r;
	}
}