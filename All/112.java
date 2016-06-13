public class Solution
{
	public boolean hasPathSum(TreeNode root, int sum)
	{
		if(root == null)
			return false;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		Queue<Integer> sumValue = new LinkedList<>();
		sumValue.offer(root.val);

		while(!q.isEmpty())
		{
			TreeNode node = q.poll();
			int value = sumValue.poll();

			if(node.left == null && node.right == null && sum == value)
				return true;

			if(node.left != null)
			{
				q.offer(node.left);
				sumValue.offer(value + node.left.val);
			}

			if(node.right != null)
			{
				q.offer(node.right);
				sumValue.offer(value + node.right.val);
			}
		}

		return false;
	}
}