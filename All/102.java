public class Solution
{
	public List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(root == null)
			return result;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty())
		{
			List<Integer> t = new ArrayList<>();
			int size = q.size();
			for(int i = 0;i < size;i++)
			{
				TreeNode node = q.poll();
				t.add(node.val);

				if(node.left != null)
					q.offer(node.left);
				if(node.right != null)
					q.offer(node.right);
			}
			result.add(new ArrayList<>(t));
		}

		return result;
	}
}