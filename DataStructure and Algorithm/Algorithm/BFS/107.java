public class Solution
{
	public List<List<Integer>> levelOrderBottom(TreeNode root)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(root == null)
			return result;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		List<List<Integer>> t = new ArrayList<>();
		while(!q.isEmpty())
		{
			List<Integer> level = new ArrayList<>();
			
			int size = q.size();
			for(int i = 0;i < size;i++)
			{
				TreeNode node = q.poll();
				level.add(node.val);

				if(node.left != null)
					q.offer(node.left);
				if(node.right != null)
					q.offer(node.right);
			}

			t.add(new ArrayList<>(level));
		}

		for(int i = t.size() - 1;i >= 0;i--)
			result.add(new ArrayList<>(t.get(i)));

		return result;
	}
}