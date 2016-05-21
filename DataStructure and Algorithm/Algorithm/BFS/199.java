public class Solution
{
	public List<Integer> rightSideView(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();

		if(root == null)
			return result;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty())
		{
			int size = q.size();
			for(int i = 0;i < size;i++)
			{
				TreeNode node = q.poll();

				if(i == 0)
					result.add(node.val);

				if(node.right != null)
					q.offer(node.right);
				if(node.left != null)
					q.offer(node.left);
			}
		}

		return result;
	}
}