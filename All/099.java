public class Solution
{
	TreeNode p;
	TreeNode m;
	TreeNode n;

	public void recoverTree(TreeNode root)
	{
		p = null;
		m = null;
		n = null;

		inorderTraversal(root);

		if(m != null && n != null)
		{
			int t = m.val;
			m.val = n.val;
			n.val = t;
		}
	}

	private void inorderTraversal(TreeNode root)
	{
		if(root == null)
			return;

		inorderTraversal(root.left);

		if(p == null)
			p = root;
		else
		{
			if(p.val > root.val)
			{
				if(m == null)
					m = p;
				n = root;
			}
			p = root;
		}

		inorderTraversal(root.right);
	}
}