// The two ways are the different explaination of the same method
// Try to feel the delicate difference between them

//Way One 
public class Solution
{
	public boolean isSymmetric(TreeNode root)
	{
		if(root == null)
			return true;

		return isSymmetric(root.left,root.right);
	}

	private boolean isSymmetic(TreeNode l, TreeNode r)
	{
		if(l == null && r == null)
			return true;
		else if(l != null && r != null)
		{
			if(l.val == r.val)
				return isSymmetric(l.left,r.right) && isSymmetric(l.right,r.left);
			else
				return false;
		}

		return false;
	}
}

// Way Two
public class Solution
{
	public boolean isSymmetric(TreeNode root)
	{
		if(root == null)
			return true;

		return isSymmetric(root.left,root.right);
	}

	private boolean isSymmetric(TreeNode l, TreeNode r)
	{
		if(l == null && r == null)
			return true;
		else if(l == null || r == null)
			return false;

		if(l.val != r.val)
			return false;
		if(!isSymmetric(l.left,r.right))
			return false;
		if(!isSymmetric(l.right,r.left))
			return false;

		return true;
	}
}