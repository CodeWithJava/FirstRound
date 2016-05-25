class Node
{
	TreeNode node;
	double l;
	double r;
	Node(TreeNode node, double l, double r)
	{
		this.node = node;
		this.l = l;
		this.r = r;
	}
}
public class Solution
{
	public boolean isValidBST(TreeNode root)
	{
		if(root == null)
			return true;

		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(root,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY));

		while(!q.isEmpty())
		{
			Node x = q.poll();

			if(x.node.val <= x.l || x.node.val >= x.r)
				return false;

			if(x.node.left != null)
				q.offer(new Node(x.node.left,x.l,x.node.val));
			if(x.node.right != null)
				q.offer(new Node(x.node.right,x.node.val,x.r));
		}

		return true;
	}
}