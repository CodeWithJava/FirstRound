// There are two ways to implement the method
// Must realisze the truth of the ways

//Way One (Recursion)
public class Solution
{
	public TreeNode invertTree(TreeNode root)
	{
		if(root == null)
			return root;

		TreeNode t = root.left;
		root.left = root.right;
		root.right = t;

		if(root.left != null)
			invertTree(root.left);
		if(root.right != null)
			invertTree(root.right);

		return root;
	}
}

//Way Two (BFS)
public class Solution
{
	public TreeNode invertTree(TreeNode root)
	{
		if(root == null)
			return root;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty())
		{
			TreeNode node = q.poll();

			if(node.left != null)
				q.offer(node.left);
			if(node.right != null)
				q.offer(node.right);

			TreeNode t = node.left;
			node.left = node.right;
			node.right = t;
		}

		return root;
	}
}